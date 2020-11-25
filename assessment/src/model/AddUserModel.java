package model;

import java.io.*;
import java.util.ArrayList;


public class AddUserModel {
	
public void AddUser(ArrayList<String> data){
		
		try {
			FileWriter f=new FileWriter(new File("staff.txt"),true);
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
