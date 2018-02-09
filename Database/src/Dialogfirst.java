// IT IS THE CONNECTOR DIALOG


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



public class Dialogfirst  extends JDialog implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	boolean isCancelled =true;
	
  JLabel lhost=new JLabel("HOST NAME");
  JTextField host =new JTextField();
  JLabel lport=new JLabel("PORT");
  JTextField port =new JTextField();
 JLabel luser=new JLabel("USER NAME");
  JTextField user =new JTextField();
  JLabel lpass=new JLabel("PASSWORD");
  JPasswordField pass =new JPasswordField();
  JLabel ldatabase=new JLabel("DATABASE");
  JTextField database =new JTextField();
  
  
  JButton ok=new JButton(" OK");
  JButton cancel=new JButton("CANCEL");
  
  Properties props;
   
  public Dialogfirst ( JFrame owner, String title,Properties p)
  {
	  super(owner,title,true);
	  setSize(300,200);
	  setLocation(250,200);
	  props=new Properties(p);
	  ok.setPreferredSize(new  Dimension(75,25));
	  ok.addActionListener(this);
	  cancel.setPreferredSize(new  Dimension(100,25));
	  cancel.addActionListener(this);
	  
	  JPanel cpanel=new JPanel();
	  JPanel cpanel2=new JPanel();
	   cpanel.setLayout(new GridLayout(5,2));//rows=5 column=2
	   cpanel.add(lhost);
	   cpanel.add(host);
	   cpanel.add(lport);
	   cpanel.add(port);
	   cpanel.add(luser );
	   cpanel.add(user);
	   cpanel.add(lpass);
	   cpanel.add(pass);
	   cpanel.add(ldatabase );
	   cpanel.add(database);
	  
	   cpanel2.add(ok);
	   cpanel2.add(cancel);
	    
	   add(cpanel,BorderLayout.NORTH);
	   add(cpanel2,BorderLayout.SOUTH);
  }
	   
	   
	   public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		   
		 if(e.getSource()== ok)
		 isCancelled = false;
		 this.dispose();
		
	}
 public Properties getprops() {
	 props.setProperty("DATABASE", database.getText());
	 props.setProperty("HOST NAME",host.getText() );
	 props.setProperty("PORT",port.getText());
	 props.setProperty("USER NAME",user.getText() );
	 return props;
	
}}