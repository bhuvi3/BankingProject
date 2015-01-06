package com.mybank.test;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

import com.mybank.domain.*;
import com.mybank.batch.*;

public class TestBatch {

   public static void main(String[] args) {
		AccumulateSavingsBatch asb = new AccumulateSavingsBatch();
		CustomerReport cr= new CustomerReport();
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br =new BufferedReader(isr);
		//creating 4 customers
		for(int i=0;i<4;i++){
			String f=null,l=null,opt=null;
			double initBalance=0,overdraft=0,giveninterestRate=0;
			System.out.println("Enter customer "+i+"'s Firstname and Lastname");
			try {
				 f=br.readLine();
				 l=br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.err.println("INPUT ERROR-PLEASE CHECK YOUR STATEMENT"+e);
			}
			Bank.addCustomer(f,l);//adding customer
			//adding customer's accounts
			//adding checking account
			System.out.println("Do you want to create a Checking Account?(true/false)");
			try {
				 opt=br.readLine();
			} catch (IOException e1) {
				System.err.println("INPUT ERROR-PLEASE CHECK YOUR STATEMENT");
			}
			boolean c = new Boolean(opt).booleanValue();
			if(c){
				System.out.print(String.format("you are creating a \"Checking account\"\nSo enter initial Balance and overdraft amount\n"));
				try{
					initBalance=Double.parseDouble(br.readLine());
					overdraft=Double.parseDouble(br.readLine());
					} catch(IOException e){
					System.err.println("CHECK YOUR INPUT\n"+e);
				}
				if(overdraft!=0)
				    Bank.getCustomer(i).createCheckingAccount(initBalance, overdraft);
				else
					Bank.getCustomer(i).createCheckingAccount(initBalance);
			}
			//adding savings account
			System.out.println("Do you want to create a Savings Account?(true/false)");
			try {
				 opt=br.readLine();
			} catch (IOException e1) {
				System.err.println("INPUT ERROR-PLEASE CHECK YOUR STATEMENT");
			}
			boolean s = new Boolean(opt).booleanValue();
			if(s){
				System.out.print(String.format("you are creating a \"Savings account\"\nSo enter initial Balance and interest Rate\n"));
				try{
					initBalance=Double.parseDouble(br.readLine());
					giveninterestRate=Double.parseDouble(br.readLine());
					} catch(IOException e){
					System.err.println("CHECK YOUR INPUT\n"+e);
				}
				Bank.getCustomer(i).createSavingsAccount(initBalance, giveninterestRate);
			}
		}		
		//generating report (before doBatch() )
		cr.generateReport();
		//calling doBatch()
		asb.doBacth();
		//generating report after calling doBatch()
		cr.generateReport();
	}

}

