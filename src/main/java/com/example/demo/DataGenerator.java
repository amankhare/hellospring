package com.example.demo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebElement;

//import com.example.pojo.MainResponse;
import com.google.gson.Gson;

import apiTestingLibrary.APIFunctions;
import apiTestingLibrary.APIHeaders;
import apiTestingLibrary.Domain;
import apiTestingLibrary.Response;
import pojo.DataSet2;
import pojo.MainResponse;

public class DataGenerator {
	
	
	static Gson gson;
	static APIFunctions api;
	static APIHeaders headers;
	
	/*public ArrayList<HashMap<String,String>> getPositiveData()
	{
		ArrayList<DataSet> data=dataGenerator.returnData();//has data in row format
		ArrayList<DataSet> positivedata=new ArrayList<>();
		for(DataSet row:data)
		{
			if(row.Valid)
				positivedata.add(row);
		}
	}*/
	
	public ArrayList<HashMap<String,String>> getValidationData(ArrayList<DataSet> data2)
	{
		ArrayList<DataSet> data=data2;//has data in row format
		ArrayList<DataSet> finaldata=new ArrayList<>();//has data in row format
		ArrayList<DataSet> positivedata=new ArrayList<>();
		ArrayList<DataSet> positivedatafromHash=new ArrayList<>();
		ArrayList<DataSet> negativedata=new ArrayList<>();
		HashMap<String,DataSet> pdata=new HashMap<>();
		HashMap<String,DataSet> ndata=new HashMap<>();
		//somehow here we know which fields are required and we also know that we require validation cases
	
		for(DataSet row:data)
		{
			if(row.Valid)
			{
				positivedata.add(row);
				pdata.put(row.Type, row);
			}
			else
			{
				negativedata.add(row);
				ndata.put(row.Type, row);
			}
		}
		Collections.sort(negativedata,new Comparator<DataSet>(){
	        @Override
	        public int compare(DataSet p1, DataSet p2) {
	            return p1.Type.compareTo(p2.Type); // if you want to short by name
	        }
	    });
		positivedatafromHash.addAll(pdata.values());
		for(DataSet aa:negativedata)
		{
			finaldata.add(aa);
			for(DataSet temp:positivedatafromHash)
			{
				if(!temp.Type.equals(aa.Type))
				finaldata.add(temp);
			}
		}
		for(DataSet aa:positivedatafromHash)
			finaldata.add(aa);
		
		for(DataSet aa:ndata.values())
			finaldata.add(aa);
		
		return convertToHashMap(finaldata,3);
	}
	
	public ArrayList<HashMap<String,String>> convertToHashMap(ArrayList<DataSet> list,int count)
	{
		ArrayList<HashMap<String,String>> output=new ArrayList<>();
		int i=0;
		int countforvaldation=0;
		HashMap<String,String> abc=new HashMap<>();
		for(DataSet data:list)
		{
			i++;
			abc.put(data.Type, data.Value);
			if(!data.Valid)
			{
				countforvaldation++;
				abc.put("Expected","Not Submitted");
				if(countforvaldation==count)
					abc.put("Invalid","All");
				else
				abc.put("Invalid",data.Type);
			}
			if(i%count==0)
			{
				countforvaldation=0;
				if(!abc.containsKey("Expected"))
				{
					abc.put("Expected","Submitted");
					abc.put("Invalid","Nothing");
				}
				output.add(abc);
				abc=new HashMap<>();
			}
			
		}
		for(HashMap<String,String> abcd:output)
		{
			System.out.println(abcd);
		}
		return output;
	}
	
	public boolean AssertValidator(String field,String Expected,List<WebElement> errors)
	{
		Properties prop = new Properties();
		InputStream input=null;
		if(Expected.equalsIgnoreCase("Submitted"))
		{
			return errors.size()==0;
		}
		try
		{
		input = input = new FileInputStream("TestDataForMessages.properties");
		prop.load(input);
		System.out.println(prop.getProperty(field));
		ArrayList<String> errorText=new ArrayList<>();
		for(WebElement web:errors)
		{
			String text=web.getText();
			if(!text.equals(""))
				errorText.add(text);
		}
		return errorText.contains(prop.get(field));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return false;
	}
	/*
	public ArrayList<DataSet> returnData(String domain,String str[])
	{
		api = new APIFunctions(Domain.NAUKRI_GULF);
		gson = new Gson();
		headers = new APIHeaders();
		Response response=null;
		String queryParam="?type=";
		for(int i=0;i<str.length;i++)
			queryParam+=str[i]+",";
		queryParam=queryParam.substring(0, queryParam.length()-1);
		System.out.println("query param is:----"+queryParam);
		MainResponse res = null;
		try {
			response = api.get("http://localhost:8080/data/"+domain+queryParam, headers.getNotLoggedInHeaders("ndr01d"));
			String resp=response.getResponse();
			res=gson.fromJson(resp, MainResponse.class);
		} catch (Exception e) {
			System.out.println("UNABLE TO HIT TEST DATA API");
			e.printStackTrace();
		}
		ArrayList<DataSet> data=new ArrayList<>();
		if(res!=null)
		{
		for(DataSet2 dd:res.getDataSet())
		{
			DataSet tempData=new DataSet(dd.getType(), dd.getValid(), dd.getValue());
			data.add(tempData);
		}
				}
	}
*/
	public static void main(String args[])
	{
		ArrayList<DataSet> data=new ArrayList<>();
		DataSet data0=new DataSet("Name",false,"!false  name^&*(");
		DataSet data1=new DataSet("Name",true,"Aman");
		DataSet data2=new DataSet("Name",false,"*(&^%$#@");
		/*DataSet data3=new DataSet("Pass",true,"Aman");
		DataSet data4=new DataSet("Pass",false,"(*&^%$#");
		DataSet data5=new DataSet("Pass",true,"naukri");
		DataSet data6=new DataSet("Email",true,"shaz@yopmail.com");
		DataSet data7=new DataSet("Email",false,"shaz@@yopmail.com");
		DataSet data8=new DataSet("Email",false,"!@#@@yopmail.com");*/
		data.add(data0);
		data.add(data1);
		data.add(data2);
		/*data.add(data3);
		data.add(data4);
		data.add(data5);
		data.add(data6);
		data.add(data7);
		data.add(data8);*/
		new DataGenerator().getValidationData(data);
	}
 
}
