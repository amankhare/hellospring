package com.example.demo;

public class DataSetModel {
	
	String Type;
	boolean Valid;
	String Value;
	
	public DataSetModel(String Type,boolean Valid,String Value)
	{
		this.Type=Type;
		this.Valid=Valid;
		this.Value=Value;
	}

	public String getType() {
		return Type;
	}

	public boolean isValid() {
		return Valid;
	}

	public String getValue() {
		return Value;
	}
	
	
}
