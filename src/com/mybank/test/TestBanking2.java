package com.mybank.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.mybank.domain.Bank;

public class TestBanking2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int numofcustomers = 6; // to open bank account for '6' customers hence initialized to 6 
	    InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		//this step has to be enclosed in the try-catch block for it to work
		for(int i=0;i<numofcustomers;i++){
			String f=null,l=null;
			double initBalance=0;
			System.out.print("Enter customer"+(i+1)+"'s firstname, lastname and initial amount :- ");
			try {
				 f=br.readLine();
				 l=br.readLine();
				 initBalance= Double.parseDouble(br.readLine());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.err.println("INPUT ERROR-PLEASE CHECK YOUR STATEMENT");
			}
			//initiating bank customers' account
			Bank.addCustomer(f,l);
		    (Bank.getCustomer(i)).createCheckingAccount(initBalance);
		    
		}
		//output
		for(int i=0;i<numofcustomers;i++){
			System.out.println("corpbank Customer index:"+i);
			System.out.println("first name:"+(Bank.getCustomer(i)).getfirstName());
			System.out.println("last name:"+(Bank.getCustomer(i)).getlastName());
			System.out.println("Account balance:"+((Bank.getCustomer(i)).getCheckingAccount()).getBalance());
		}
		    
	}

}
