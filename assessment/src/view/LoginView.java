package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class LoginView {
	public JFrame frame=new JFrame();
	
	public JButton sidebar[]= {
			new JButton("Home             "),
			new JButton("Lecturers      "),
			new JButton("Departments"),
			new JButton("Logout           "),
			new JButton("Exit               ")
			};
	public JLabel side[]= {
			new JLabel("Home"),
			new JLabel("Lecturers"),
			new JLabel("Departments"),
			new JLabel("Logout"),
			new JLabel("Exit"),
	};
	
	public JButton home[]= {
			new JButton("Add Department"),
			new JButton("Add Lecturers"),
			new JButton("Query Lecturers")
	};
	
	
	JPanel panel=new JPanel();
	public JLabel label=new JLabel("USER NAME  :");
	public JTextField txt=new JTextField(20);
	public JLabel label1=new JLabel("PASSWORD  :");
	private JPasswordField  txt1=new JPasswordField (20);
	private JButton login=new JButton("LOGIN");
	public String[] role= {"Admin","Secretary"};
	public JComboBox<String> com=new JComboBox<String>();
	private int n=0;
	
	public JPanel hpanel=new JPanel();

	
	
	public JPanel panel1[]= {
			new JPanel(),/*Sidebar*/
			new JPanel(),/*Title panel*/
			new JPanel(),/*Content of the functionality panel*/
			};	

	
	public LoginView() throws ClassNotFoundException {
			
		panel.setLayout(null);
		JPanel p=new JPanel();
		panel.setBounds(0,0,445,550);
		p.setBounds(0,0,434,200);
		p.setBackground(Color.BLACK);
		p.setBorder(BorderFactory.createLineBorder(Color.yellow));
		p.setLayout(null);
		panel.add(p);	
		ImageIcon log=new ImageIcon("logo.png");
		JLabel log1=new JLabel();
		log1.setIcon(log);
		p.add(log1);
		
		
		
		panel.add(label);		
		label.setBounds(80,250,100,30);
		panel.add(txt);
		txt.setBounds(200,250,150,30);
		panel.add(label1);
		label1.setBounds(80,300,100,30);
		panel.add(txt1);
		txt1.setBounds(200,300,150,30);
		panel.add(p);
		p.setLayout(new GridLayout(1,3));
		panel.add(com);
		com.setBounds(200,350,150,30);
		for(int i=0;i<role.length;i++)
			com.addItem(role[n++]);

		panel.add(login);
		login.setBounds(200, 400, 150, 30);
		
		login.setCursor(new Cursor(Cursor.HAND_CURSOR));

		
		
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
		
		
		
		/*Home*/
		ImageIcon himg[]= {
					new ImageIcon("add1.png"),
					new ImageIcon("add.png"),
					new ImageIcon("search.png")
		};
		
		hpanel.setLayout(new GridLayout(1,3));
		panel1[2].setLayout(null);
		hpanel.setBounds(20,100,700,400);
		for(int i=0;i<home.length;i++) {
			hpanel.add(home[i]);
			home[i].setIcon(himg[i]);
			himg[i].setDescription("Add Department");
			home[i].setVerticalTextPosition(SwingConstants.BOTTOM);
			home[i].setHorizontalTextPosition(SwingConstants.CENTER); 
			home[i].setBackground(Color.white);
			home[i].setPreferredSize(new Dimension(250,300));
			
		}
		
		panel1[2].add(hpanel);
			
		
		
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setTitle("Northampton Human Resource System");
		
		
	
	}
	
	public void addLogin() {
		frame.setBounds(450,120,450,550);
		frame.add(panel);
		panel.setBorder(BorderFactory.createLineBorder(Color.black));
	}
	
	public String getUser() {
		return txt.getText();
	}
	@SuppressWarnings("deprecation")
	public String getPassword() {
		return txt1.getText();
	}
	public void loginListener(ActionListener a) {
		login.addActionListener(a);
	}
	
	public void addAdminPage() {

		for(int i=0;i<panel1.length;i++) {
			panel1[1].setBorder(BorderFactory.createLineBorder(Color.yellow));
			frame.setBounds(200,0,1000,750);
			frame.add(panel1[i]);
			panel.setVisible(false);
			panel1[i].setBorder(BorderFactory.createLineBorder(Color.black));
			
		}
		
	}
	
	
	
public void navigation(ActionListener a) {
		for(int i=0;i<home.length;i++) {
			home[i].addActionListener(a);
		}
		for(int i=0;i<sidebar.length;i++) {
			sidebar[i].addActionListener(a);
		}
		
	}
	
	
	
	
	


}
