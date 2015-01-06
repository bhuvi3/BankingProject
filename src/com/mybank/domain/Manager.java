package com.mybank.domain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import com.mybank.batch.AccumulateSavingsBatch;

public class Manager implements Employee {
	//fields
	private String fname;
	private String lname;
	private String designation;
	private int age;
	private HashMap<String,Customer> masterRecord;
	//methods
	//implemented
	public void doWork(){
		Customer temp=addCustomer();
		masterRecord.put(temp.getfirstName()+ " "+ temp.getlastName(), temp);
	}
	public void printProfile(){
		System.out.println("Name : "+ fname + " " + lname);
		System.out.println("Age : "+ age);
		System.out.println("Designation : "+ designation);
	}
	//other specific methods
	public void doBatch(){
		AccumulateSavingsBatch asb = new AccumulateSavingsBatch();
		asb.doBatch(this);
	}
	public void setmymasterRecord(HashMap<String,Customer> masterRecord){
		this.masterRecord= masterRecord;
	}
	public void setmasterRecordfromFile(HashMap<String,Customer> loadedData){
		this.masterRecord.clear();
		this.masterRecord.putAll(loadedData);
	}
	public Customer addCustomer(){ 
		String fn=null,ln=null;
		double initBalance=0,overdraft=0,giveninterestRate=0;
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		boolean flag=true,savings=false,checking=false;
		int option = 0;
		System.out.print(String.format("Enter your first name and last name\n"));
		try{
			fn=br.readLine();
			ln=br.readLine();
		}catch(IOException e){
			System.err.println("CHECK YOUR INPUT\n"+e);
		}
		Customer tempcustomer=new Customer(fn,ln);
		while(flag){
		  if(savings && checking){
				   break;
		  }	
		  System.out.println("Which type of Account do you want to create?\n\t1.Checking Account\n\t2.Savings Account");
		  System.out.println("if you're done creating accounts, enter 0");
		  try{
			  option=Integer.parseInt(br.readLine());
		  }catch(IOException e){
			  System.err.println("ERROR: CHECK INPUT");
		  }
		  if(option ==1 && checking==false){//first creating two customers with checking account
			checking=true;
			System.out.print(String.format("you are creating a \"Checking account\"\nSo enter initial Balance and overdraft amount\n"));
			try{
				initBalance=Double.parseDouble(br.readLine());
				overdraft=Double.parseDouble(br.readLine());
				} catch(IOException e){
				System.err.println("CHECK YOUR INPUT\n"+e);
			}
			//creating checking account
			//simply to use overloaded constructors anyway overdraft==0 if it is entered as 0 since default is 0.
			if(overdraft!=0)
				tempcustomer.createCheckingAccount(initBalance, overdraft);
			else
				tempcustomer.createCheckingAccount(initBalance);
		    }
		    else if(option ==2 && savings==false){//first creating rest of the customers with savings account
			    savings=true;
			    System.out.print(String.format("you are creating a \"Savings account\"\nSo enter initial Balance and interest Rate\n"));
			    try{
				   initBalance=Double.parseDouble(br.readLine());;
				   giveninterestRate=Double.parseDouble(br.readLine());
			    }catch(IOException e){
				   System.err.println("CHECK YOUR INPUT\n"+e);
			    }
			    //creating savings account
			    tempcustomer.createSavingsAccount(initBalance, giveninterestRate);
		   }
		   else if(option==0){
			   flag=false;
		   }
		  else{
			  System.out.println("only one account of a type can be created");
		  }		  
	    }	
		return tempcustomer;
	}
}
