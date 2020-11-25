package controller;

import java.awt.event.*;
import model.*;
import view.*;

public class SecretaryController {
	SecretaryView view;
	public SecretaryController(SecretaryView view) {
		this.view=view;
		
	}
	
public void NavigationMenu(String department) {
		

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
					view.panel1[2].add(view.hPanel);
					view.panel1[2].revalidate();
					
				}
				else if(a.getSource()==view.sidebar[1]) {
					  view.panel1[2].removeAll();
					  view.panel1[2].repaint();
					  /*calling another class panel to add*/
					  UserDetailsView udv=new UserDetailsView();
					  UserDetailsController udc=new UserDetailsController(udv);
					  udc.DisplayUser();
					  udc.addRowSecretary(department);
					for(int i=0;i<5;i++) {
						view.side[i].setVisible(false);
						view.side[1].setVisible(true);
					}
					udv.updStaff.setEnabled(false);
					udv.delStaff.setEnabled(false);
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
					  ddc.addRowSecretary(department);
					  ddc.DisplayDepartment();
					  for(int i=0;i<5;i++) {
							view.side[i].setVisible(false);
							view.side[2].setVisible(true);
						}
					  ddv.panel.setBounds(0, 0, 750, 700);
					  view.panel1[2].add(ddv.panel);
					  ddv.delDep.setEnabled(false);
					  ddv.updDep.setEnabled(false);
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
						System.out.println("Class Not Found");
						
					}
					
					
				}
				else if(a.getSource()==view.sidebar[4]) {
					System.exit(0);
				}
				
				else if(a.getSource()==view.home) {
					
					view.panel1[2].removeAll();
					  view.panel1[2].repaint();
					  UserDetailsView udv=new UserDetailsView();
					  UserDetailsController udc=new UserDetailsController(udv);
					  udc.DisplayUserSecretary(department);
					for(int i=0;i<5;i++) {
						view.side[i].setVisible(false);
						view.side[1].setVisible(true);
					}
					udv.updStaff.setEnabled(false);
					udv.delStaff.setEnabled(false);
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
