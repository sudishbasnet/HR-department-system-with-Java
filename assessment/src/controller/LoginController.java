package controller;

import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import javax.swing.JOptionPane;

import model.*;
import view.*;

public class LoginController{
	LoginView view;
	LoginModel model;
	
	
	public LoginController(LoginView view,LoginModel model) {
		this.view =view;
		this.model = model;
	}
	public void login() {
		
		view.loginListener(new ActionListener(){
			

			public void actionPerformed(ActionEvent a) {
				
				if(view.com.getSelectedItem().equals("Admin")) {
				if(model.checkAdmin(view.getUser(),view.getPassword())==true) {
					view.addAdminPage();
					NavigationMenu();
					
				}
				
				else
					 JOptionPane.showMessageDialog(null, "Wrong Username Or Password");
				}
				else if(view.com.getSelectedItem().equals("Secretary")) {
					try {
						if(model.checkSec(view.getUser(),view.getPassword())==true){
						String department =view.txt.getText();	
						view.frame.dispose();
						SecretaryView sv=new SecretaryView();
						SecretaryController sc=new SecretaryController(sv);
						sv.SecretaryPage();
						
						sc.NavigationMenu(department);
						
						}
						else
							JOptionPane.showMessageDialog(null, "Wrong Username Or Password");
					} catch (HeadlessException | FileNotFoundException e) {
						System.out.println("File And Header Not Founds");
					}
				}
				
		}
			
		});
	}
	
	public void NavigationMenu() {
		

		view.navigation(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent a) {
	
				if(a.getSource()==view.sidebar[0]) {
					view.panel1[2].removeAll();	
					view.panel1[2].repaint();
					for(int i=0;i<5;i++) {
						view.side[i].setVisible(false);
						view.side[0].setVisible(true);
					}
					view.panel1[2].add(view.hpanel);
					view.panel1[2].revalidate();
					
				}
				else if(a.getSource()==view.sidebar[1]) {
					  view.panel1[2].removeAll();
					  view.panel1[2].repaint();
					  /*calling another class panel to add*/
					  UserDetailsView udv=new UserDetailsView();
					  UserDetailsController udc=new UserDetailsController(udv);
					  udc.addRow();
					  udc.DisplayUser();
					for(int i=0;i<5;i++) {
						view.side[i].setVisible(false);
						view.side[1].setVisible(true);
					}
					udv.panel.setBounds(0, 0, 750, 700);
					view.panel1[2].add(udv.panel);
					view.panel1[2].revalidate();
					
				}
				else if(a.getSource()==view.sidebar[2]) {
					  view.panel1[2].removeAll();
					  view.panel1[2].repaint();
					  /*calling another class panel to add*/
					  DepartmentDetailsView ddv=new DepartmentDetailsView();
					  DepartmentDetailsController ddc=new DepartmentDetailsController(ddv);
					  ddc.addRow();
					  ddc.DisplayDepartment();
					  for(int i=0;i<5;i++) {
							view.side[i].setVisible(false);
							view.side[2].setVisible(true);
						}
					  ddv.panel.setBounds(0, 0, 750, 700);
					  view.panel1[2].add(ddv.panel);
					  view.panel1[2].revalidate();
					
				}
				else if(a.getSource()==view.sidebar[3]) {
					view.frame.dispose();
					LoginView l;
					try {
						l = new LoginView();
						l.addLogin();
						 /*calling another class panel to add*/
						LoginModel m=new LoginModel();
						LoginController c=new LoginController(l,m);
						c.login();
						view.panel1[1].add(view.side[3]);
						for(int i=0;i<5;i++) {
							view.side[i].setVisible(false);
							view.side[3].setVisible(true);
						}
		
					} catch (ClassNotFoundException e) {
						
					}
					
					
				}
				else if(a.getSource()==view.sidebar[4]) {
					System.exit(0);
				}
				else if(a.getSource()==view.home[0]) {
					view.panel1[2].removeAll();
					view.panel1[2].repaint();
					 /*calling another class panel to add*/
					AddDepartmentView adv=new AddDepartmentView(null, null, null, null, null);
					AddDepartmentModel adm=new AddDepartmentModel();
					AddDepartmentController adc=new AddDepartmentController(adv,adm);
					adc.AddDepartment();
					  for(int i=0;i<5;i++) {
							view.side[i].setVisible(false);
							view.side[2].setVisible(true);
						}
					  adv.panel.setBounds(50, 10, 400, 500);
					  view.panel1[2].add(adv.panel);
					  view.panel1[2].revalidate();
					
				}
				
				else if(a.getSource()==view.home[1]) {
					view.panel1[2].removeAll();
					view.panel1[2].repaint();
					 /*calling another class panel to add*/
					AddUserView auv=new AddUserView(null, null, null, null, null, null, null, null);
					AddUserModel aum=new AddUserModel();
					AddUserController auc=new AddUserController(auv,aum);
					auc.saveData();
					  for(int i=0;i<5;i++) {
							view.side[i].setVisible(false);
							view.side[1].setVisible(true);
						}
					  auv.panel.setBounds(50, 10,400, 500);
					  view.panel1[2].add(auv.panel);
					  view.panel1[2].revalidate();
					
				}
				
				else if(a.getSource()==view.home[2]) {
					view.panel1[2].removeAll();
					  view.panel1[2].repaint();
					  /*calling another class panel to add*/
					  UserDetailsView udv=new UserDetailsView();
					  UserDetailsController udc=new UserDetailsController(udv);
					  udc.DisplayUser();
					for(int i=0;i<5;i++) {
						view.side[i].setVisible(false);
						view.side[1].setVisible(true);
					}
					view.panel1[2].setLayout(null);
					udv.queryPanel.setBounds(0, 0, 750, 100);
					view.panel1[2].add(udv.queryPanel);
					udv.panel.setBounds(0, 100, 750, 600);
					view.panel1[2].add(udv.panel);
					view.panel1[2].revalidate();
					
				}
				
				
			}
			
		});
		
		
	}

}
