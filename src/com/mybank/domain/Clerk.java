package com.mybank.domain;

import com.mybank.batch.AccumulateSavingsBatch;

public class Clerk implements Employee{
	//fields
		private String fname;
		private String lname;
		private String designation;
		private int age;
		//methods
		//implemented
		public void doWork(){
			doBatch();
		}
		public void printProfile(){
			System.out.println("Name : "+ fname + " " + lname);
			System.out.println("Age : "+ age);
			System.out.println("Designation : "+ designation);
		}
		//other specific methods
		public void doBatch(){
			AccumulateSavingsBatch asb = new AccumulateSavingsBatch();
			asb.doBatch(this);
		}
		public void generateReport(){
			CustomerReport cr = new CustomerReport();
			cr.generateReport(this);
		}

}
