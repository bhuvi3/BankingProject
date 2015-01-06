package com.mybank.domain;

import java.util.*;

public class Bank {
    //class members 
	private static HashMap<String,Customer> masterRecord =new HashMap<String,Customer>();
    private static ArrayList<Employee> employeeList = new ArrayList<Employee>();
	//constructor is default
    //class methods
    public static void addCustomer(Employee e){
    	if(e instanceof Manager){ //making sure that it is the Manager and not any other Employee
    	   e.doWork();
    	}   
    }
	public static int getNumOfCustomers(){
		return masterRecord.size();
	}
    public static Customer getCustomer(String name){
    	return masterRecord.get(name);
    }
    public static Iterable<Customer> getCustomerList(Employee e){// employees including clerk needs to update customer accounts(like doBatch())
    	for(Employee t: employeeList){                     // hence this checks if he is a registered employee and return customerList(Still mutable to masterRecord)
    		if(t==e){         //e has to be a registered employee here since it is mutable object.   //anyways he cannot add a customer to the masterRecord
    			return  masterRecord.values();//return (ArrayList<Customer>) masterRecord.values() not working???
    		}
    	}
    	return null;
    }
    public static void doBatch(Employee e){
    	e.doWork();
    }
    public static HashMap<String,Customer> getmasterRecord(){
    	return masterRecord;
    }
    public static void addEmployee(Employee e){
    	if(e instanceof Manager){ //it can also be equated to find if he is registered manager as it is mutable object.
    		((Manager) e).setmymasterRecord(masterRecord); 
    	}
    	employeeList.add(e);
    }
}    
