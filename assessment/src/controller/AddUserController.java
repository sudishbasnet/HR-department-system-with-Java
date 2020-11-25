package controller;

import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;
import model.*;
import view.*;

public class AddUserController {
	AddUserView view;
	AddUserModel model;
	public AddUserController(AddUserView v,AddUserModel m) {
		view=v;
		model=m;
		
		
	}
	public void saveData() {
		depart();
	
		view.addUserListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent a) {
				ArrayList<String> a1=new ArrayList<String>();
				if(view.field[0].getText().equals("") || view.field[1].getText().equals("") ||view.field[4].getText().equals("") ||view.field[5].getText().equals("") )
					JOptionPane.showMessageDialog(null,"Invalid Datas");
				else{
					a1.add(view.field[0].getText()+"-"+view.field[1].getText()+"-"+view.field[2].getText()+"-"+view.field[3].getText()+"-"+view.field[4].getText()+"-"+view.field[5].getText()+"-"+view.com.getSelectedItem().toString()+"-"+view.dep.getSelectedItem().toString());
					view.setValue();
					model.AddUser(a1);
				}
				
				
									
					
			}	
			
		});
	}


	public void depart() {
		try {
			@SuppressWarnings("resource")
			Scanner sc =new Scanner(new File("department.txt"));
			String dat;
			String [] sub;
			while(sc.hasNextLine()) {
				dat =sc.nextLine();
				sub=dat.split("-");
			    String dep=sub[1];
			    view.dep.addItem(dep);
				
			}
		}
		catch(FileNotFoundException e) {
			System.out.println("File Not Found");
		}
	}

}
