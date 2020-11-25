package controller;

import java.awt.event.*;
import java.util.*;
import javax.swing.JOptionPane;
import model.*;
import view.*;

public class AddDepartmentController {
	private AddDepartmentView v;
	private AddDepartmentModel m;
	
	public AddDepartmentController(AddDepartmentView v,AddDepartmentModel m) {
		this.m=m;
		this.v=v;
	}
	
	public void AddDepartment() {

		v.AddDepartmentListener(new ActionListener() {
			

			@Override
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<String> a=new ArrayList<String>();
				if(v.field[0].getText().equals("") ||v.field[1].getText().equals("") ||v.field[2].getText().equals("") ||v.field[4].getText().equals("") ) 
					JOptionPane.showMessageDialog(null,"Invalid Datas");
				else {			
				a.add(v.field[0].getText()+"-"+v.field[1].getText()+"-"+v.field[2].getText()+"-"+v.field[3].getText()+"-"+v.field[4].getText());
				m.AddDepartment(a);
				v.setValue();
				}
				
					
				
			}
		
			
		});
	}
	
	



}
