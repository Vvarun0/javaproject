//IT CONTAINS THE DATABASE CONNECTION

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Database extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static JTextField sql =new JTextField();
	JLabel prompt =new JLabel("please enter ur sql query");
	JButton exe= new JButton("execute");
	JButton reset= new JButton("reset");
	 static JTable table=new JTable();
	 static DefaultTableModel model= (DefaultTableModel)table.getModel();
	 JScrollPane pane=new JScrollPane(sql);
	 static Connector dc;
	 
	 
	 
	  public Database(Connector conn){
		  add(prompt);
		  dc=conn;
		 JScrollPane spane=new JScrollPane(sql);
			spane.setPreferredSize(new Dimension(750,100)); 
		add(spane);
		exe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			execute();	
			}
		});
			reset.addActionListener(new ActionListener(){
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
			model.setRowCount(0);
			model.setColumnCount(0);
				}	
			
		}
		);
		  add(exe);
		  add(reset);
		  JScrollPane rpane=new JScrollPane(table);
			rpane.setPreferredSize(new Dimension(750,400)); 
		add(rpane);
		 
	 }
	
	private static void execute() {
		model.setRowCount(0);
		model.setColumnCount(0);
		String s=sql.getText();
	try {
	ResultSet rs =dc.executeQuery(s);	
	ResultSetMetaData rsmd=rs.getMetaData();//no of resultset object columns
	for(int i =1;i<=rsmd.getColumnCount();i++)
	{
	model.addColumn(rsmd.getColumnName(i));	
	}
	while(rs.next()) {
		String[] data= new String[rsmd.getColumnCount()];
		for(int i =1;i<=rsmd.getColumnCount();i++) {
			data[i-1]=rs.getString(i);
			
		}
		model.addRow(data);
		
	}
	}
	catch (SQLException e) {
		System.out.println("Error: " +e);

	}
	}

}
