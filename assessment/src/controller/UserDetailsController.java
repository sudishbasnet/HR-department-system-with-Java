package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;
import view.*;

public class UserDetailsController {
	UserDetailsView view;

	
	public UserDetailsController(UserDetailsView view) {
		this.view =view;
	
		
	}
	
	public void addRow() {
		Object[] row = new Object[8];
		try {
			@SuppressWarnings("resource")
			Scanner sc =new Scanner(new File("staff.txt"));
			String dat;
			String [] sub;
			while(sc.hasNextLine()) {
				dat =sc.nextLine();
				sub=dat.split("-");
				row[0] = sub[0];
			     row[1] = sub[1];
			     row[2] = sub[2];
			     row[3] = sub[3];
			     row[4] = sub[4];
			     row[5] = sub[5];
			     row[6] =sub[6];
			     row[7] =sub[7];
			     view.dtm.addRow(row);
				
			}
		}
		catch(FileNotFoundException e) {
			System.out.println("File Not Found");
		}

	}

	public void addRowSecretary(String department) {
		Object[] row = new Object[8];
		try {
			@SuppressWarnings("resource")
			Scanner in =new Scanner(new File("staff.txt"));
			String dat;
			String [] sub;
			while(in.hasNextLine()) {
				dat =in.nextLine();
				sub=dat.split("-");
				if(sub[7].equals(department)) {
				row[0] = sub[0];
			     row[1] = sub[1];
			     row[2] = sub[2];
			     row[3] = sub[3];
			     row[4] = sub[4];
			     row[5] = sub[5];
			     row[6] =sub[6];
			     row[7] =sub[7];
			     view.dtm.addRow(row);
				}
				
			}
		}
		catch(FileNotFoundException e) {
			System.out.println("File Not Found");		}

	}

public void DisplayUser() {
	
	view.DisplayUser(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==view.updStaff) {
				
				int t = view.tab.getSelectedRow();
	            
	            if(t >= 0) 
	            {
	            	ArrayList<String> arr=memory();
	        		String[] sub_arr;
	        		for(int i=0;i<arr.size();i++) {
	        			sub_arr=arr.get(i).split("-");
	        			if(sub_arr[0].equals(view.dtm.getValueAt(t, 0))) {
	        				arr.set(i, view.dtm.getValueAt(t,0).toString()+"-"+view.dtm.getValueAt(t,1).toString()+"-"+view.dtm.getValueAt(t,2).toString()+"-"+view.dtm.getValueAt(t,3).toString()+"-"+view.dtm.getValueAt(t,4).toString()+"-"+view.dtm.getValueAt(t,5).toString()+"-"+view.dtm.getValueAt(t,6).toString());
	        				insert(arr);
	        				JOptionPane.showMessageDialog(null,"Staff Updated");
	        			}
	  
	        		}
	        				
	        	}
				
				
			}
			
			if(e.getSource()==view.delStaff) {
				int t = view.tab.getSelectedRow();
				
	            
				 if(t >= 0) 
		            {
		            	ArrayList<String> arr=memory();
		        		String [] userData;;
		        		
		        		for(int i=0;i<arr.size();i++) {
		        			userData=arr.get(i).split("-");
		        			if(userData[0].equals(view.dtm.getValueAt(t,0).toString())) {
		        				arr.remove(i);
		        				insert(arr);
		        				view.dtm.removeRow(t);
		        				JOptionPane.showMessageDialog(null,"Staff Deleted");
		        			}
		        			
		        			
		        				
		        			}
		            	
		            }        
				
			}
			if(e.getSource()==view.queryButton) {
				Object[] row = new Object[8];
				try {
					@SuppressWarnings("resource")
					Scanner sc =new Scanner(new File("staff.txt"));
					String dat;
					String [] sub;
					while(sc.hasNextLine()) {
						dat =sc.nextLine();
						sub=dat.split("-");
						if(sub[6].equals(view.com.getSelectedItem().toString())) {
						row[0] = sub[0];
					     row[1] = sub[1];
					     row[2] = sub[2];
					     row[3] = sub[3];
					     row[4] = sub[4];
					     row[5] = sub[5];
					     row[6] =sub[6];
					     row[7] =sub[7];
					     view.dtm.addRow(row);
					     
						}
					
						
					}
				}
				catch(FileNotFoundException e1) {
					System.out.println("File Not Found");
				}

				
			}
			
			else if(e.getSource()==view.queryButton1) {
				Object[] row = new Object[8];
				try {
					@SuppressWarnings("resource")
					Scanner sc =new Scanner(new File("staff.txt"));
					String dat;
					String [] sub;
					while(sc.hasNextLine()) {
						dat =sc.nextLine();
						sub=dat.split("-");
						if(sub[0].equals(view.queryField.getText())) {
						row[0] = sub[0];
					     row[1] = sub[1];
					     row[2] = sub[2];
					     row[3] = sub[3];
					     row[4] = sub[4];
					     row[5] = sub[5];
					     row[6] =sub[6];
					     row[7] =sub[7];
					     view.dtm.addRow(row);
					     
						}
					
						
					}
				}
				catch(FileNotFoundException e1) {
					System.out.println("File Not Found");
				}

				
			}
			
		}
		
	});
}

public void DisplayUserSecretary(String department) {
	
	view.DisplayUser(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {

			if(e.getSource()==view.queryButton) {
				Object[] row = new Object[8];
				try {
					@SuppressWarnings("resource")
					Scanner sc =new Scanner(new File("staff.txt"));
					String dat;
					String [] sub;
					while(sc.hasNextLine()) {
						dat =sc.nextLine();
						sub=dat.split("-");
						if(sub[6].equals(view.com.getSelectedItem().toString())) {
						if(sub[7].equals(department)) {
						row[0] = sub[0];
					     row[1] = sub[1];
					     row[2] = sub[2];
					     row[3] = sub[3];
					     row[4] = sub[4];
					     row[5] = sub[5];
					     row[6] =sub[6];
					     row[7] =sub[7];
					     view.dtm.addRow(row);
						}
					     
						}
					
						
					}
				}
				catch(FileNotFoundException e1) {
					System.out.println("File Not Found");
				}

				
			}
			
			else if(e.getSource()==view.queryButton1) {
				Object[] row = new Object[8];
				try {
					@SuppressWarnings("resource")
					Scanner sc =new Scanner(new File("staff.txt"));
					String dat;
					String [] sub;
					while(sc.hasNextLine()) {
						dat =sc.nextLine();
						sub=dat.split("-");
						if(sub[0].equals(view.queryField.getText())) {
						if(sub[7].equals(department)) {
						row[0] = sub[0];
					     row[1] = sub[1];
					     row[2] = sub[2];
					     row[3] = sub[3];
					     row[4] = sub[4];
					     row[5] = sub[5];
					     row[6] =sub[6];
					     row[7] =sub[7];
					     view.dtm.addRow(row);
						}
					     
						}
					
						
					}
				}
				catch(FileNotFoundException e1) {
					System.out.println("File Not Found");
				}

				
			}
			
		}
		
	});
}

public static ArrayList<String> memory(){
	ArrayList<String> datas =new ArrayList<String>();
	String str;
	try {
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(new File("staff.txt"));
		while(sc.hasNext()) {
			str=sc.nextLine();
			datas.add(str);
		}
		return datas;
	}
	catch(IOException e) {
		System.out.println("Writing Failed");
		
	}
	return null;
}

public static void insert(ArrayList<String> str) {
	try {
		FileWriter f=new FileWriter(new File("staff.txt"));
		BufferedWriter w=new BufferedWriter(f);
		for(String s:str) {
			w.write(s+"\n");
		}
		w.close();
	}
	catch(IOException e) {
		System.out.println("Writing Failed");

	}
}
}

