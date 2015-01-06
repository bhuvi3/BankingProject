package com.mybank.test;

import com.mybank.domain.*;

public class TestBanking {

	public static void main(String[] args) {
		Employee manager = new Manager();
		Employee clerk = new Clerk();
		Bank.addEmployee(manager);
		Bank.addEmployee(clerk);
		int noc = 3;
		//manager inputs customers to THE BANK, and creates their account
		for(int i=0;i<noc;i++){
			Bank.addCustomer(manager);
		}
		//generating report
		System.out.println("BEFORE DOING BATCHPROCESSING");
		((Clerk) clerk).generateReport();// i am asking a clerk(casting since i know this employee is a clerk) to generate report
		Bank.doBatch(clerk);
		System.out.println("AFTER DOING BATCHPROCESSING");
		((Clerk) clerk).generateReport();
	}
}
