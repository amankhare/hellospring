package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.gson.Gson;

import apiTestingLibrary.APIFunctions;
import apiTestingLibrary.APIHeaders;
import apiTestingLibrary.Domain;
import apiTestingLibrary.Response;
import pojo.DataSet;
import pojo.MainResponse;

public class updateData {
	
	Gson gson;
	APIFunctions api;
	APIHeaders headers;

	@BeforeMethod
	public void beforeMethod() {
		api = new APIFunctions(Domain.NAUKRI_GULF);
		gson = new Gson();
		headers = new APIHeaders();
	}
	
	@DataProvider(name="dataUpload")
	public Object[][] DataProvider_CvUpload()
	{
		String sheetName = "Data";
		Xls_Reader datatable = new Xls_Reader(".//DataUpdationSheet//TestData.xls");
		int colcount = datatable.getColumnCount(sheetName);
		int rowcount = datatable.getRowCount(sheetName);

		Object row[][] = new Object[rowcount - 1][2];
		for (int i = 2; i <= rowcount; i++) {
			row[i - 2][0] = i - 1;
			HashMap<String, String> data = new HashMap<String, String>();
			for (int j = 0; j <= colcount; j++) {
				data.put(datatable.getCellData(sheetName, j, 1), datatable.getCellData(sheetName, j, i));
			}
			row[i - 2][1] = data;
		}
		return row;
	}
	@Test(dataProvider="dataUpload")
	public void TC_CVUploadAPITest_001_Upload(int row,HashMap<String,String> xlData) throws Exception {
		System.out.println(xlData.toString());
		Response response;
		List<DataSet> lst=new ArrayList<DataSet>();
		DataSet set=new DataSet();
		set.setDomain(xlData.get("Domain"));
		set.setType(xlData.get("Type"));
		set.setValid(xlData.get("Valid").equalsIgnoreCase("True")? true : false);
		set.setValue(xlData.get("Value"));
		lst.add(set);
		MainResponse resp=new MainResponse();
		resp.setDataSet(lst);
		try {
			String json=gson.toJson(resp);
			response = api.post("http://localhost:8080/data/add", headers.getNotLoggedInHeaders("ndr01d"),json);
			String res=response.getResponse();
			System.out.println(res);
		} catch (Exception e) {
			System.out.println("UNABLE TO HIT TEST DATA API");
			e.printStackTrace();
		}
	}
}
