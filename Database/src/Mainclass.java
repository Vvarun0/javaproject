import java.util.Properties;

import javax.swing.JFrame;

public class Mainclass {
	   public static void main(String[] args)
{
 JFrame frame =new JFrame("Database");
 Properties props =new Properties();
 Dialogfirst dialog =new Dialogfirst(frame,"DATABASE CONNECTOR",props);
 dialog.setVisible(true);
 if(dialog.isCancelled)
	 System.exit(0);
 Connector conn=new Connector(dialog.getprops(), new String(dialog.pass.getPassword()));
 if(!conn.open()== false)
  System.exit(0);
 Database dpanel =new Database(conn);
 frame.setSize(800,600);
 frame.add(dpanel);
 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 frame.setVisible(true);
 
}
}
