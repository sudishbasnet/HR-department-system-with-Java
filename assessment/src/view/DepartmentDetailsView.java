
package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DepartmentDetailsView {
	public JPanel panel=new JPanel(); 
	public JTable tab = new JTable(); 
	public JButton delDep = new JButton("Remove Department");
	public JButton updDep = new JButton("Edit Department");
	public Object[] col = {"Id","Department Name","Department Type","Department Url","Password"};
	public DefaultTableModel dtm = new DefaultTableModel();	
	
	

	public DepartmentDetailsView(){		
	dtm.setColumnIdentifiers(col); 
   	tab.setModel(dtm);
   	tab.setRowHeight(26);
      
    panel.setLayout(new GridLayout(2,1));
    JScrollPane jsp = new JScrollPane(tab);
    panel.add(jsp);
    
    JPanel panel1=new JPanel();
    panel1.setLayout(null);
    panel.add(panel1);
    panel1.add(delDep);
    panel1.add(updDep);
    delDep.setBounds(500, 150, 150, 40);
    updDep.setBounds(500, 100, 150, 40);
    
    
    
    
   
		}
	
	
	public void DisplayDepartment(ActionListener a) {
		delDep.addActionListener(a);
		updDep.addActionListener(a);
}
	 
}
     
