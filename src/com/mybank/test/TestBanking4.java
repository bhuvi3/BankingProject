package com.mybank.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.io.DataInputStream;

import com.mybank.domain.*;

public class TestBanking4 {
	public static void main(String[] args) {      //main method
		//local variables
		Customer[] customers =new Customer[5];
		int numOfCustomers=5;
		double amt=0;
		boolean flag=false;
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		//DataInputStream dis=new DataInputStream(System.in);
		//taking inputs and creating customer accounts
		for(int i=0;i<numOfCustomers;i++){
			String fn=null,ln=null;
			double initBalance=0,overdraft=0,giveninterestRate=0;
			if(i<2){//first creating two customers with checking account
				System.out.print(String.format("Customer %d : \nEnter your first name and last name\n",i));
				System.out.print(String.format("you are creating a \"Checking account\"\nSo enter initial Balance and overdraft amount\n"));
				try{
					fn=br.readLine();
					ln=br.readLine();
					initBalance=Double.parseDouble(br.readLine());//i dunno why dis.readDouble() wasn't working properly
					overdraft=Double.parseDouble(br.readLine());
					} catch(IOException e){
					System.err.println("CHECK YOUR INPUT\n"+e);
				}
				customers[i]=new Customer(fn,ln);//creating customer
				//creating checking account
				//simply to use overloaded constructors anyway overdraft==0 if it is entered as 0 since default is 0.
				if(overdraft!=0)
				    customers[i].createCheckingAccount(initBalance, overdraft);
				else
					customers[i].createCheckingAccount(initBalance);
			}
			else{//first creating rest of the customers with savings account
				System.out.print(String.format("Customer %d : \nEnter your first name and last name\n",i));
				System.out.print(String.format("you are creating a \"Savings account\"\nSo enter initial Balance and interest Rate\n"));
				try{
					fn=br.readLine();
					ln=br.readLine();
					initBalance=Double.parseDouble(br.readLine());;
					giveninterestRate=Double.parseDouble(br.readLine());
				} catch(IOException e){
					System.err.println("CHECK YOUR INPUT\n"+e);
				}
				customers[i]=new Customer(fn,ln);//creating customer
				//creating savings account
				customers[i].createSavingsAccount(initBalance, giveninterestRate);
			}
		}
		//simulating transactions
		//checking account simulation
		System.out.println("Customer 1 simulation(checking account holder):\n");
		//depositing
		System.out.println(customers[1].getfirstName()+" "+customers[1].getlastName()+" Enter amount to deposit");
		try{
			amt=Double.parseDouble(br.readLine());
		} catch(IOException e){
			System.err.println("CHECK YOUR INPUT\n"+e);
		}
		flag=(customers[1].getCheckingAccount()).deposit(amt);
		if(flag)
		    System.out.println("New Balance :"+(customers[1].getCheckingAccount()).getBalance());
		else{
			System.out.println("Transaction failed, check balance");
			System.out.println("Current Balance :"+(customers[1].getCheckingAccount()).getBalance());
		}
		//withdrawing
		System.out.println(customers[1].getfirstName()+" "+customers[1].getlastName()+" Enter amount to withdraw");
		try{
			amt=Double.parseDouble(br.readLine());
		} catch(IOException e){
			System.err.println("CHECK YOUR INPUT\n"+e);
		}
		try{
		   flag=(customers[1].getCheckingAccount()).withdraw(amt);
		}catch(OverdraftException e){
			e.printStackTrace();
		}
		if(flag)
		    System.out.println("New Balance :"+(customers[1].getCheckingAccount()).getBalance());
		else{
			System.out.println("Transaction failed, check balance");
			System.out.println("Current Balance :"+(customers[1].getCheckingAccount()).getBalance());
		}
		
		
		//savings account simulation
		System.out.println("customer 3 simulation(savings account holder):\n");
		//depositing
		System.out.println(customers[3].getfirstName()+" "+customers[3].getlastName()+" enter amount to deposit");
		try{
			amt=Double.parseDouble(br.readLine());
		} catch(IOException e){
			System.err.println("CHECK YOUR INPUT\n"+e);
		}
		flag=(customers[3].getSavingsAccount()).deposit(amt);
		if(flag)
		    System.out.println("new Balance :"+(customers[3].getSavingsAccount()).getBalance());
		else{
			System.out.println("transaction failed, check balance");
			System.out.println("current Balance :"+(customers[3].getSavingsAccount()).getBalance());
		}
		//withdrawing
		System.out.println(customers[3].getfirstName()+" "+customers[3].getlastName()+" enter amount to withdraw");
		try{
			amt=Double.parseDouble(br.readLine());
		} catch(IOException e){
			System.err.println("CHECK YOUR INPUT\n"+e);
		}
		try{
			flag=(customers[1].getSavingsAccount()).withdraw(amt);
		}catch(OverdraftException e){
			e.printStackTrace();
		}
		if(flag)
		    System.out.println("new Balance :"+(customers[3].getSavingsAccount()).getBalance());
		else{
			System.out.println("transaction failed, check balance");
			System.out.println("current Balance :"+(customers[3].getSavingsAccount()).getBalance());
		}
	}
}
