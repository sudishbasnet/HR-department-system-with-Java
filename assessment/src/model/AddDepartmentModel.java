package model;

import java.io.*;
import java.util.ArrayList;


public class AddDepartmentModel {

	public void AddDepartment(ArrayList<String> data){
		
		
		
		try {
			FileWriter f=new FileWriter(new File("department.txt"),true);
			BufferedWriter w=new BufferedWriter(f);
			for(String x:data) {
				w.write(x+"\n");
			}
			w.close();
		}
		catch(IOException e) {
			System.out.println("error");
		}
		

	}
	
	
	
}
