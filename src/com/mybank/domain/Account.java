package com.mybank.domain;

public abstract class Account {


	//Class Members			//Initialize a value for amt
	protected double balance;

	//Constructor
	protected Account(double initBalance)
	{
		balance=initBalance;
	}

	//Class Methods
	public double getBalance()
	{
		return balance;
	}
	public boolean deposit(double amt)
	{
		//Your code here
		balance=balance + amt;
		if (balance > 0)
		{
			return true;
		}
		else 
		{ 
			balance = balance-amt;
			return false;
		}
	}
	public boolean withdraw(double amt) throws OverdraftException
	{
		balance=balance - amt;
		if (balance > 0)
		{
			return true;
		}
		else 
		{   balance = balance+amt;
			throw (new OverdraftException("no balance",-(balance-amt)));
		}
	}
	public String toString(){
		return ("Account Balance : "+ getBalance());
	}

	/*//Main function
	public static void main(String[] abc)
	{
		double initial=10000;  //Initialize the variable with the initial amt

		Account acct=new Account(initial);

		//Complete the code

		System.out.println("balance initial = "+ acct.getBalance());
		//depositing
		acct.deposit(1000);
		System.out.println("balance after deposit = "+ acct.getBalance());
		//withdrawing
		acct.withdraw(500);
		System.out.println("balance after withdrawal = "+ acct.getBalance());
	}*/
}
