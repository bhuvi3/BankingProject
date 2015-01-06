package com.mybank.test;

import com.mybank.domain.*;

public class TestReport {

	public static void main(String[] args) {
		Employee manager = new Manager();
		Employee clerk = new Clerk();
		Bank.addEmployee(manager);
		Bank.addEmployee(clerk);
		DataSource ds = new DataSource("test.dat");//it says it doesn't throw an exception
        ds.loadData(manager);
		//generating report
		System.out.println("BEFORE DOING BATCHPROCESSING");
		((Clerk) clerk).generateReport();// i am asking a clerk(casting since i know this employee is a clerk) to generate report
		Bank.doBatch(clerk);
		System.out.println("AFTER DOING BATCHPROCESSING");
		((Clerk) clerk).generateReport();
	}
}
