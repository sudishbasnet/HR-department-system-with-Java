package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class SecretaryView {
	public JFrame frame=new JFrame();
	
	public JButton sidebar[]= {
			new JButton("Home             "),
			new JButton("Lecturers      "),
			new JButton("Department"),
			new JButton("Logout           "),
			new JButton("Exit               ")
			};
	public JLabel side[]= {
			new JLabel("Home"),
			new JLabel("Lecturers"),
			new JLabel("Department"),
			new JLabel("Logout"),
			new JLabel("Exit"),
	};
	
	
	
	
	public JPanel panel1[]= {
			new JPanel(),/*Sidebar*/
			new JPanel(),/*Title panel*/
			new JPanel(),/*Content of the functionality panel*/
			};
	public JPanel hPanel=new JPanel();
	
	public JButton home=new JButton("Query Lecturers");
	

	
	public SecretaryView(){
		
		/*Adding panel label for userpage*/		
		/*implementation for sidebar design*/
		ImageIcon im=new ImageIcon("logo.png");
		JLabel logo=new JLabel();
		logo.setIcon(im);
		panel1[0].add(logo);
		logo.setBounds(0,10,200,180);
		
		ImageIcon img[] = { new ImageIcon("home.png"),
							new ImageIcon("lecturer.png"),
							new ImageIcon("department.png"),
							new ImageIcon("logout.png"),
							new ImageIcon("exit.png"),
							};
		panel1[0].setBackground(Color.black);		
		panel1[0].setBounds(0,0,210,700);
		panel1[0].setLayout(null);
		for(int i=0;i<sidebar.length;i++) {
			panel1[0].add(sidebar[i]);
			sidebar[i].setIcon(img[i]);
			sidebar[i].setHorizontalTextPosition(SwingConstants.LEFT);
			sidebar[i].setBackground(Color.white);
			
			side[i].setForeground(Color.WHITE);
			panel1[1].add(side[i]);
			side[i].setVisible(false);
			
		}
		sidebar[0].setBounds(0,250,210,50);
		sidebar[1].setBounds(0,300,210,50);
		sidebar[2].setBounds(0,350,210,50);
		sidebar[3].setBounds(0,400,210,50);
		sidebar[4].setBounds(0,450,210,50);
		
	

		
		
		
		/*Implementing design for the Title of the page open*/
		panel1[1].setBounds(240,5,750,50);
		panel1[1].setBackground(Color.DARK_GRAY);
		
		/*Implementation for the content of the system*/
		panel1[2].setBounds(240,100,750,700);		
		
		
	
		
		hPanel.setLayout(new GridLayout(1,3));
		panel1[2].setLayout(null);
		hPanel.setBounds(20,100,700,400);
		
		panel1[2].add(hPanel);
		
		/*Home*/
		ImageIcon himg[]= {
					new ImageIcon("search.png")
		};
		
			hPanel.add(home);
			home.setIcon(himg[0]);
			himg[0].setDescription("Add Department");
			home.setVerticalTextPosition(SwingConstants.BOTTOM);
			home.setHorizontalTextPosition(SwingConstants.CENTER); 
			home.setBackground(Color.white);
			home.setPreferredSize(new Dimension(250,300));
			
			
		
		
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setTitle("Northampton Human Resource System");
		
		
	
	}
	

	
	public void SecretaryPage() {

		for(int i=0;i<panel1.length;i++) {
			panel1[1].setBorder(BorderFactory.createLineBorder(Color.yellow));
			frame.setBounds(200,0,1000,750);
			frame.add(panel1[i]);
			panel1[i].setBorder(BorderFactory.createLineBorder(Color.black));
			
		}
		
	}
	
	
	
public void navigation(ActionListener a) {
		for(int i=0;i<sidebar.length;i++) {
			sidebar[i].addActionListener(a);
		}
		home.addActionListener(a);
		
	}
	
	
	
	
	


}
