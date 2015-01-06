package com.mybank.domain;

import java.util.*;

public class CustomerReport {
	//fields
	//default constructor
	//methods
	public void generateReport(Employee e){
		System.out.println("\t\tCUSTOMER REPORT");
		//ArrayList<Customer> customerList = Bank.getCustomerList(e);
		Iterator<Customer> it = Bank.getCustomerList(e).iterator();
		while(it.hasNext()){
			Customer temp = it.next();
			System.out.println("Customer: "+temp.getfirstName()+","+temp.getlastName());
			if(temp.getSavingsAccount() instanceof SavingsAccount){
				System.out.println("\t Savings Account: \n\t\tCurrent Balance is " + temp.getSavingsAccount().getBalance());
			}
			if(temp.getCheckingAccount() instanceof CheckingAccount){
				System.out.println("\t Checking Account: \n\t\tCurrent Balance is " + temp.getCheckingAccount().getBalance());
			}
			System.out.println("\n");		
		}
	}

}
