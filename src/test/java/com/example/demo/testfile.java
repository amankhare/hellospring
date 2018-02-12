package com.example.demo;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.gson.Gson;

import apiTestingLibrary.APIFunctions;
import apiTestingLibrary.APIHeaders;
import apiTestingLibrary.Domain;

public class testfile {
	
	Gson gson;
	APIFunctions api;
	APIHeaders headers;
	WebDriver driver;
	private String name_Txt = "//input[@id='regUserName']";
	private String email_Txt = "//input[@id='regEmail']";
	private String password_Txt = "//input[@id='regPassword']";
	private String expLevelFresher_WE = "//label[text()='I am a Fresher']";
	private String expLevelExperienced_WE = "//label[text()='I have Work Experience']";
	private String continueToRegister_Btn = "//input[@id='gnbRegSubmit']";
	String Common_Resources_Path = System.getenv("Common_Resources");
	DataGenerator dataGenerator=new DataGenerator();
	
/*	
	@Test
	public void generatePOJO() {
		APIFunctions api = new APIFunctions(Domain.NAUKRI_GULF);

		try {
			api.createPOJOForJSON(".\\SampleJson\\APIResponse.txt",
					"com.example.pojo", "MainResponse");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	
	/*@DataProvider(name="data")
	public Object[][] DataProvider_CvUpload() throws Exception
	{
		api = new APIFunctions(Domain.NAUKRI_GULF);
		gson = new Gson();
		headers = new APIHeaders();
		Response response=api.get("http://localhost:8080/data", headers.getNotLoggedInHeaders("ndr01d"));
		MainResponse resp=gson.fromJson(response.getResponse(), MainResponse.class);
		List<Datum> data=resp.getEmbedded().getData();
		Object row[][] = new Object[data.size()][1];
		System.out.println(data.size());
		int i=0;
		for (Datum d:data) {
				row[i][0] = (Object)data.get(i);
				i++;
			}
		return row;
	}
	//Response response=api.get("http://localhost:8080/data", headers.getNotLoggedInHeaders("ndr01d"));
			//MainResponse resp=gson.fromJson(response.getResponse(), MainResponse.class);
			//List<Datum> data=resp.getEmbedded().getData();
	
	*/
	@DataProvider(name="data2")
	public Object[][] DataProvider_Reg() throws Exception
	{
		ArrayList<HashMap<String,String>> getdata=dataGenerator.getValidationData(Params.NG_Domain,Params.Name,Params.Email,Params.Password);
		Object row[][] = new Object[getdata.size()][2];
		for (int i = 0; i < getdata.size(); i++) {
			row[i][0] = i+1;
			row[i][1] = getdata.get(i);;
		}
		System.out.println("------------------------------------------------");
		return row;
	}
	//875
	@Test(dataProvider="data2")
	public void TC1(int row,HashMap<String,String> data) throws InterruptedException
	{
		
		String filename="ResmanP0.properties";		
		System.out.println(data.toString());
		FirefoxProfile profile = new FirefoxProfile();
		driver = new FirefoxDriver(new FirefoxBinary(new File(Common_Resources_Path+"\\MozillaVersions\\Mozilla Firefox30\\firefox.exe")), profile);
		driver.get("https://www.naukrigulf.com/register");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath(name_Txt)).sendKeys(data.get("Name"));
		String time=System.currentTimeMillis()+"";
		driver.findElement(By.xpath(email_Txt)).sendKeys("kiosk-"+time+data.get("Email"));
		driver.findElement(By.xpath(password_Txt)).sendKeys(data.get("Pass"));
		driver.findElement(By.xpath(expLevelExperienced_WE)).click();
		driver.findElement(By.xpath(expLevelFresher_WE)).click();
		driver.findElement(By.xpath(continueToRegister_Btn)).click();
		List<WebElement> error=driver.findElements(By.xpath("//span[contains(@id,'_err')]"));
		Assert.assertTrue(dataGenerator.AssertValidator(data.get("Invalid"),data.get("Expected"),error,filename));
		
	}
	
	@Test
	public void TC()
	{
		System.out.println(dataGenerator.getData(Params.NG_Domain,Params.Name,Params.Email,Params.Password).toString());
	}
	
	
	//@AfterMethod
	public void af()
	{
		driver.quit();
	}

	/*
	@Test(dataProvider="data")
	public void TC(Datum data) throws Exception
	{
		FirefoxProfile profile = new FirefoxProfile();
		WebDriver driver = new FirefoxDriver(new FirefoxBinary(new File(Common_Resources_Path+"\\MozillaVersions\\Mozilla Firefox30\\firefox.exe")), profile);
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath(name_Txt)).sendKeys(data.getName());
		driver.findElement(By.xpath(email_Txt)).sendKeys(data.getEmailId());
		driver.findElement(By.xpath(password_Txt)).sendKeys(data.getPassword());
		Thread.sleep(2000);
		if(data.getExperienceLevel().equals("Experience"))
		    driver.findElement(By.xpath(expLevelExperienced_WE)).click();
		else
			driver.findElement(By.xpath(expLevelFresher_WE)).click();
		driver.findElement(By.xpath(continueToRegister_Btn)).click();
		Thread.sleep(5000);
		driver.close();
	}
*/
}
