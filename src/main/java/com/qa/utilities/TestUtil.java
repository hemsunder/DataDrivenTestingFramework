package com.qa.utilities;

import java.util.ArrayList;


public class TestUtil {
	static Xls_Reader reader;
	
	public static ArrayList<Object[]> getdatafromExcel(){
		
		ArrayList<Object[]> mydata = new ArrayList<Object[]>();
		
		try {
			reader = new Xls_Reader("C:\\Users\\HEM\\Desktop\\Automation Data\\TestDataDDT-1.xlsx");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for(int rowNum=2;rowNum<=reader.getRowCount("DDT");rowNum++){
			
			String username = reader.getCellData("DDT", "Username", rowNum);
			String password = reader.getCellData("DDT", "Password", rowNum);
			String storeid = reader.getCellData("DDT", "storeID", rowNum);
			
			Object ob[]={username, password, storeid};
			mydata.add(ob);

		}
		
		return mydata;
	}

}
