package com.mybank.domain;

public class OverdraftException extends Exception{
	private static final long serialVersionUID = 7172004036079014713L;//generated serialUID (just to prevent warning as this was serializable)
	//fields
	private double deficit;
	//constructor
	public OverdraftException(String msg,double takendeficit) {
		super(msg);
		deficit=takendeficit;
	}
	//methods
	public double getDeficit(){
		return deficit;
	}
}
