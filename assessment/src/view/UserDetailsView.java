package view;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class UserDetailsView {
	
	/*Query staff*/
	public String[] role= {"Part Time","Full Time","Contract"};
	public JComboBox<String> com=new JComboBox<String>();
	private int n=0;
	public JLabel queryLabel=new JLabel("Query By Job Type");
	public JPanel queryPanel=new JPanel();
	public JButton queryButton=new JButton("Search");
	public JLabel queryLabel1=new JLabel("Query With Id");
	public JButton queryButton1=new JButton("Search");
	public JTextField queryField =new JTextField(2);
	
	/*all staff*/
	public JPanel panel=new JPanel(); 
	public JTable tab = new JTable(); 
	public JButton delStaff = new JButton("Remove Staff");
	public JButton updStaff = new JButton("Edit Staff"); 
	public Object[] col = {"Id","Staff Name","Staff Address","Staf Phone","Staff Mail","Join Date","Type","Department"};
    public DefaultTableModel dtm = new DefaultTableModel();
	

	public UserDetailsView() {
		/*Query Part*/
		queryPanel.setLayout(null);
		queryPanel.add(queryLabel1);
		queryPanel.add(queryField);
		queryPanel.add(queryButton1);
		queryLabel1.setBounds(100,0,200,30);
		queryField.setBounds(320,0,200,30);
		queryButton1.setBounds(540,0,100,30);
		queryLabel1.setFont(queryLabel.getFont().deriveFont(20f));
		
		queryPanel.add(queryLabel);
		queryLabel.setBounds(100,50,200,30);
		queryLabel.setFont(queryLabel.getFont().deriveFont(20f));
		queryPanel.add(com);
		com.setBounds(320,50,200,30);
		for(int i=0;i<role.length;i++)
			com.addItem(role[n++]);
		queryPanel.add(queryButton);
		queryButton.setBounds(540, 50, 100, 30);
		
		
		
       /*Alll staff*/
        dtm.setColumnIdentifiers(col);
        tab.setModel(dtm);
        tab.setRowHeight(26);

        panel.setLayout(new GridLayout(2,1));
        JScrollPane jsp = new JScrollPane(tab);
        panel.add(jsp);
        
        JPanel panel1=new JPanel();
        panel1.setLayout(null);
        panel.add(panel1);
        panel1.add(delStaff);
        delStaff.setBounds(500, 150, 150, 40);
        panel1.add(updStaff);
        updStaff.setBounds(500, 90, 150, 40);
        
     
        
        
    

	}
	
	public void DisplayUser(ActionListener a) {
		delStaff.addActionListener(a);
		updStaff.addActionListener(a);
		queryButton.addActionListener(a);
		queryButton1.addActionListener(a);
}
}
	         
     
