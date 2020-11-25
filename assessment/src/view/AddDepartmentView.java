package view;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.*;

public class AddDepartmentView {
	private JLabel dep[]= {
			new JLabel("Department Id"),
			new JLabel("Department Name"),
			new JLabel("Department Type"),
			new JLabel("Web Url"),
			new JLabel("Password")
			};
	
	
	
	public JTextField field[]= {
			new JTextField(20),
			new JTextField(20),
			new JTextField(30),
			new JTextField(30),
			new JTextField(30)
			};
	public JPanel panel=new JPanel(new GridLayout(11,0,0,10));
	private JButton add=new JButton("Add Department");
	private String id,name,type,url,pswd;
		
	public AddDepartmentView(String id,String name,String type,String url,String pswd) {
		this.id=id;
		this.name=name;
		this.type=type;
		this.url=url;
		this.pswd=pswd;
		for(int i=0;i<dep.length;i++) {
			panel.add(dep[i]);
			panel.add(field[i]);
		}
		
		panel.add(add);

	}
	
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getType() {
		return type;
	}
	public String getUrl() {
		return url;
	}
	public String getPass() {
		return pswd;
	}
	public void setValue() {
		for(int i=0;i<5;i++) {
			field[i].setText("");
		}
	
	}
	
	public void AddDepartmentListener(ActionListener e) {
		add.addActionListener(e);
	}


	

}
