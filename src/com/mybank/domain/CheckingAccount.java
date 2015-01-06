package com.mybank.domain;

public class CheckingAccount extends Account {
	//fields
	private double overdraftAmount;
	//constructor
	public CheckingAccount(double initBalance,double overdraft){
		super(initBalance);
		overdraftAmount=overdraft;
	}
	public CheckingAccount(double initBalance){//overloaded constructor with overdraft amount =0;
		super(initBalance);
	}
	//methods
	public boolean withdraw(double amt) throws OverdraftException{  //withdraw method overridden
		balance=balance - amt;
		if ( balance > (-overdraftAmount) )
		{
			return true;
		}
		else 
		{   balance = balance+amt;
			throw(new OverdraftException("Overdraft",(balance-amt)-overdraftAmount));
		}
	}

}
