package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AddUserView {

	public JPanel panel=new JPanel();
	private JLabel label[]= {
			new JLabel("Staff Id"),
			new JLabel("Staff Name"),
			new JLabel("Address"),
			new JLabel("Phone"),
			new JLabel("mail"),
			new JLabel("Date Join")
		};
	private JLabel l=new JLabel();
	private JLabel wType=new JLabel("Work Type");
	
	public JTextField field[]= {
			new JTextField(10),
			new JTextField(25),
			new JTextField(30),
			new JTextField(20),
			new JTextField(25),
			new JTextField(10)
			};
	
	public String[] role= {"Part Time","Full Time","Contract"};
	public JComboBox<String> com=new JComboBox<String>();
	public JLabel depart=new JLabel("Assign Department");
	public JComboBox<String> dep=new JComboBox<String>();
	
	private int n=0;

	
	private JButton addUser=new JButton("Add account");
	private String id,name,address,phone,mail,date,type,department;
	
	public AddUserView(String id, String name, String address, String phone, String mail, String date, String type,String department){
		this.id=id;
		this.name=name;
		this.address=address;
		this.phone=phone;
		this.mail=mail;
		this.date=date;
		this.type=type;
		this.department=department;
		
		GridLayout g=new GridLayout(9,2,0,30);
		panel.setLayout(g);
		addUser.setCursor(new Cursor(Cursor.HAND_CURSOR));
		for(int i=0;i<label.length;i++) {
			panel.add(label[i]);
			panel.add(field[i]);
			}
		panel.add(wType);
		panel.add(com);
		for(int i=0;i<role.length;i++)
			com.addItem(role[n++]);
		panel.add(depart);
		panel.add(dep);
		panel.add(l);
		panel.add(addUser);


		
		}
		public String getId() {
			return id;
		}
		public String getName() {
			return name;
		}
		public String getAddress() {
			return address;
		}
		public String getPhone() {
			return phone;
		}
		public String getMail() {
			return mail;
		}
		public String getDate() {
			return date;
		}
		public String getType() {
			return type;
		}
		public String getDepart() {
			return department;
		}
		
		public void setValue() {
			for(int i=0;i<field.length;i++) {
				field[i].setText("");
			}
		}
	
		public void addUserListener(ActionListener a) {
			addUser.addActionListener(a);
		}
		
	
	}
