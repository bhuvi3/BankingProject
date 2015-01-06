package com.mybank.batch;

import java.util.*;

import com.mybank.domain.*;

public class AccumulateSavingsBatch {
	//fields
	//default constructor
	//methods
	public void doBatch(Employee e){
		//ArrayList<Customer> customerList = Bank.getCustomerList(e);
		Iterator<Customer> it = Bank.getCustomerList(e).iterator();
		while(it.hasNext()){
			Customer temp = it.next();
			if(temp.getSavingsAccount() instanceof SavingsAccount){
				temp.getSavingsAccount().AccumulateInterest();
			}
		}
	}

}
