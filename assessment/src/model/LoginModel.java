package model;

import java.io.*;
import java.util.Scanner;

public class LoginModel {

	public boolean checkAdmin(String str,String str1) {
			if(str.equals("admin") & str1.equals("admin"))			
				return true;
			else				
			return false;
	}
	
	public boolean checkSec(String str,String str1) throws FileNotFoundException {
		boolean result = false;
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(new File("department.txt"));
				String dat;
				String [] sub;
				while(sc.hasNextLine()) {
					dat =sc.nextLine();
					sub=dat.split("-");
					if(str.equals(sub[1]) & str1.equals(sub[4]))			
						return result=true;
			} 
			return result;
			
				
			}
}



