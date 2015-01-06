package com.mybank.domain;

import java.io.*;
import java.util.*;

public class DataSource {
	//fields
	private File dataFile;
	//constructor
	public DataSource(String dataFilePath){
		dataFile=new File(dataFilePath);
	}
	//methods
	@SuppressWarnings("deprecation")// suppressing the warning after knowing that readLine() doesn't effectively convert bytes to charachter
	public void loadData(Employee e){
		if(e instanceof Manager){//ensuring only managers can load loadData
			try{
				HashMap<String,Customer> loadedData = new HashMap<String,Customer>();
				InputStream is = new FileInputStream(dataFile);
				DataInputStream dis = new DataInputStream(is);
				//parsing data from the file in the specified format
				int noc=Integer.parseInt(dis.readLine());//number of customers
				dis.readLine();//to skip reading the new line
				//iterating to get each customer and loading it to loadedData
				for(int i=0;i<noc;i++){
					String fn=null,ln=null;
					int noa=0;//number of accounts
					String temp1 = dis.readLine();
					System.out.println(temp1);
					String[] tokens1=temp1.split(" ");
					fn=tokens1[0];
					ln=tokens1[1];
					noa=Integer.parseInt(tokens1[2]);
					Customer tempCustomer=new Customer(fn,ln); //a Current Customer is created
					//creating accounts of the Current Customer
					for(int j=0;j<noa;j++){
						String temp2= dis.readLine();
						System.out.println(temp2);
						String[] tokens2 = temp2.split(" ");
						if(tokens2[0].charAt(0)== 'C'){//checking account-type-code
							//creating Checking account of the customer
							double initBalance=Double.parseDouble(tokens2[1]),overdraft=Double.parseDouble(tokens2[2]);
							if(overdraft!=0){
								tempCustomer.createCheckingAccount(initBalance, overdraft);
							}else{
								tempCustomer.createCheckingAccount(initBalance);
						    }
						}
						if(tokens2[0].charAt(0)=='S'){ //tokens2[0] == "S"; doesn't work
							//creating Savings account of the customer
							double initBalance=Double.parseDouble(tokens2[1]),giveninterestRate=Double.parseDouble(tokens2[2]);
						    tempCustomer.createSavingsAccount(initBalance, giveninterestRate);
						}
					}
					//the Current Customer is completely built and can be added to loadedDate
					loadedData.put(tempCustomer.getfirstName()+ " " +tempCustomer.getlastName(), tempCustomer);
					dis.readLine();//to skip the new line
				}
				dis.close();//closing all chained streams
				//loadedData is completely cloned and ready to be loaded to masterRecord
				((Manager)e).setmasterRecordfromFile(loadedData);
			}catch(IOException error){
				System.err.println("File Path incorrect"+e);
				error.printStackTrace();
			}
		}
		else{
			System.err.println("you do not have necessary permissions");
		}
	}
}
