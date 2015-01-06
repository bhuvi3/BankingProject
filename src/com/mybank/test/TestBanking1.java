package com.mybank.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.mybank.domain.Customer;

public class TestBanking1 {
 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fname = null;
		String lname = null;
		double initBalance = 0;
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		//this step has to be enclosed in the try-catch block for it to work
		System.out.print("Enter customer's firstname, lastname and initial amount :- ");
		try {
			fname=br.readLine();
			lname=br.readLine();
			initBalance= Double.parseDouble(br.readLine());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("INPUT ERROR-PLEASE CHECK YOUR STATEMENT");
		}
		//initializing customer and his account
		Customer corpbank1 = new Customer(fname,lname);
		corpbank1.createCheckingAccount(initBalance);
		//simulating a set of transactions
		//depositing into account
		double amt=0;
		boolean flag=false;
		//deposit
		System.out.println("Hello corpbank1!:"+fname+" "+lname);
		System.out.println("Account Balance = "+(corpbank1.getCheckingAccount()).getBalance());
		System.out.println("Enter the amount you want to deposit");
		try{
			amt=Double.parseDouble(br.readLine());
		}
		catch(IOException e){
			System.err.println("PLEASE CHECK IF IT IS A NUMBER");
		
		}
		flag=(corpbank1.getCheckingAccount()).deposit(amt);
		if(flag==true){
			System.out.println("deposit successful");
			System.out.println("current balance ="+ (corpbank1.getCheckingAccount()).getBalance());
		}
		else{
			System.out.println("deposit failed, check balance!");
			System.out.println("Current Balance ="+ (corpbank1.getCheckingAccount()).getBalance());
		}
		
		
        //withdrawing from account
		amt=0;
		flag=false;
		//withdraw
		System.out.println("Hello corpbank1!:"+fname+" "+lname);
		System.out.println("Account Balance = "+(corpbank1.getCheckingAccount()).getBalance());
		System.out.println("Enter the amount you want to withdraw");
		try{
			amt=Double.parseDouble(br.readLine());
		}
		catch(IOException e){
			System.err.println("PLEASE CHECK IF IT IS A NUMBER");
				
		}
		flag=(corpbank1.getCheckingAccount()).withdraw(amt);
		if(flag==true){		
			System.out.println("withdraw successful");
			System.out.println("Current Balance ="+ (corpbank1.getCheckingAccount()).getBalance());
		}
		else{
			System.out.println("withdraw failed, check balance!");
			System.out.println("current balance ="+ (corpbank1.getCheckingAccount()).getBalance());
		}
		
     }

}

