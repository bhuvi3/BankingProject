package com.mybank.domain;

import java.util.ArrayList;
import java.util.Iterator;

public class Customer {
    //class members
	private String firstName;
	private String lastName;
    private ArrayList<Account> accounts= new ArrayList<Account>();
    //constructor method
    public Customer(String f,String l){
    	firstName=f;
    	lastName=l;
    }
    //class methods
    public String getfirstName(){
    	return firstName;
    }
    public String getlastName(){
    	return lastName;
    }
    public SavingsAccount getSavingsAccount(){
    	for(Account a: accounts){
    		if(a instanceof SavingsAccount){
    			return (SavingsAccount)a;
    		}
    	}
    	return null;
    }
    public CheckingAccount getCheckingAccount(){
    	for(Account a: accounts){
    		if(a instanceof CheckingAccount){
    			return (CheckingAccount)a;
    		}
    	}
    	return null;
    }
    public void setAccount(Account acct){
    	if(acct.getClass().getName()=="com.mybank.domain.SavingsAccount"){
    		for(Account a : accounts){
    			if(a instanceof SavingsAccount){
    			accounts.remove(a);
    			accounts.add(acct);
    			}
    		}	
    	}
    	else if(acct.getClass().getName()=="com.mybank.domain.CheckingAccount"){
        	for(Account a : accounts){
        		if(a instanceof CheckingAccount){
        			accounts.remove(a);
        			accounts.add(acct);
        		}
        	}
        }
    }
    //account is of type Account so it can refer to any of the subclasses of Account, says polymorphism.
    /*An Account object cannot be created by a Customer since account constructor is protected
    and Customer does not extend Account. So createAccount method has been changed as follows*/
    public void createSavingsAccount(double initBalance,double giveninterestRate){//to create savings account
    	boolean flag = true;
    	for(Account a : accounts){
    		if(a instanceof SavingsAccount){
    			flag=false;
    			System.out.println("A savings account already exists");
    			break;
    		}
    	}
    	if(flag){
    		accounts.add(new SavingsAccount(initBalance,giveninterestRate));
    	}		
    }
    public void createCheckingAccount(double initBalance,double givenOverDraft){//to create checking account
    	boolean flag = true;
    	for(Account a : accounts){
    		if(a instanceof CheckingAccount){
    			flag=false;
    			System.out.println("A Checking account already exists");
    			break;
    		}
    	}
    	if(flag){
    		accounts.add(new CheckingAccount(initBalance,givenOverDraft));
    	}		
    }
    public void createCheckingAccount(double initBalance){//to create checking account
    	boolean flag = true;
    	for(Account a : accounts){
    		if(a instanceof CheckingAccount){
    		flag=false;
    		System.out.println("A Checking account already exists");
    		break;
    		}
    	}
    	if(flag){
    		accounts.add(new CheckingAccount(initBalance));
    	}		
    }
    public String toString(){
    	String temp =(firstName +" " + lastName + accounts.size());
    	Iterator<Account> it= accounts.iterator();
    	while(it.hasNext()){
    		if(it.next() instanceof SavingsAccount){
    			temp.concat("\n Savings Account");
    		}
    		if(it.next() instanceof CheckingAccount){
    			temp.concat("\n Checking Account");
    		}
    	}
    	return temp;
    }
}
