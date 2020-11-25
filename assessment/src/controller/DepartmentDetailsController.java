package controller;

import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;
import view.*;

public class DepartmentDetailsController {
	DepartmentDetailsView view;
	
	public DepartmentDetailsController(DepartmentDetailsView view) {
		this.view =view;
		
	}
	
	public void addRow() {
		Object row[]=new Object[5];
		try {
			@SuppressWarnings("resource")
			Scanner in =new Scanner(new File("department.txt"));
			String dat;
			String [] sub;
			while(in.hasNextLine()) {
				dat =in.nextLine();
				sub=dat.split("-");
				row[0] = sub[0];
			     row[1] = sub[1];
			     row[2] = sub[2];
			     row[3] = sub[3];
			     row[4] = sub[4];
			     view.dtm.addRow(row);
				
			}
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	public void addRowSecretary(String department) {
		Object row[]=new Object[5];
		try {
			@SuppressWarnings("resource")
			Scanner sc =new Scanner(new File("department.txt"));
			String dat;
			String [] sub;
			while(sc.hasNextLine()) {
				dat =sc.nextLine();
				sub=dat.split("-");
				if(sub[1].equals(department)) {
				row[0] = sub[0];
			     row[1] = sub[1];
			     row[2] = sub[2];
			     row[3] = sub[3];
			     row[4] = sub[4];
			     view.dtm.addRow(row);
				}
				
			}
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}

	}


public void DisplayDepartment() {
	
	view.DisplayDepartment(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==view.updDep) {
				
				int t = view.tab.getSelectedRow();
	            
	            if(t >= 0) 
	            {
	            	ArrayList<String> arr=memory();
	        		String[] sub_arr;
	        		for(int i=0;i<arr.size();i++) {
	        			sub_arr=arr.get(i).split("-");
	        			if(sub_arr[0].equals(view.dtm.getValueAt(t, 0))) {
	        				arr.set(i, view.dtm.getValueAt(t,0).toString()+"-"+view.dtm.getValueAt(t,1).toString()+"-"+view.dtm.getValueAt(t,2).toString()+"-"+view.dtm.getValueAt(t,3).toString()+"-"+view.dtm.getValueAt(t,4).toString());
	        				insert(arr);
	        				JOptionPane.showMessageDialog(null,"Department Updated");
	        			}
	  
	        		}
	        				
	        	}
				
				
			}
			
			if(e.getSource()==view.delDep) {
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
		        				JOptionPane.showMessageDialog(null,"Department Deleted");
		        			}
		        			
		        			
		        				
		        			}
		            	
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
		Scanner s=new Scanner(new File("department.txt"));
		while(s.hasNext()) {
			str=s.nextLine();
			datas.add(str);
		}
		return datas;
	}
	catch(IOException e) {
		
	}
	return null;
}

public static void insert(ArrayList<String> str) {
	try {
		FileWriter f=new FileWriter(new File("department.txt"));
		BufferedWriter w=new BufferedWriter(f);
		for(String s:str) {
			w.write(s+"\n");
		}
		w.close();
	}
	catch(IOException e) {

	}
}
}

