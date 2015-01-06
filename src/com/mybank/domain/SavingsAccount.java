package com.mybank.domain;
//import java.util.*;

public class SavingsAccount extends Account {
    //fields
	private double interestRate;
	//private Date DateOfCreation;
	//constructor
	protected SavingsAccount(double initBalance,double giveninterestRate) {
		super(initBalance);
		interestRate=giveninterestRate;
	//	DateOfCreation= new Date();
	}
	//methods
	// this must me called to update balance from doBatch(), I tried and failed to find a way to make it do automatically without calling a method.
	//can please you teach me that Siddarth.
	public void AccumulateInterest(){
		//Date CurrentDate = new Date();
		//long month = 1000*24*60*60*30;
		//long diff = (CurrentDate.getTime()-DateOfCreation.getTime());
		//if(diff==month){
			balance+=balance*(interestRate/12);
		//}
		//else{
		//	System.out.println("Its not been a month yet");
		//}
	}
}
