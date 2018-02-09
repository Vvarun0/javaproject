

import java.util.Properties;

import java.sql.*;


public class Connector {
Connection conn;
Statement stat;
static String  url,database,username,password,port,hostname,driver;
 public Connector(Properties props,String pass) {
	database = props.getProperty("DATABASE") ;
	username = props.getProperty("USER NAME") ;
	password =pass;
	hostname = props.getProperty("HOST NAME");
	port = props.getProperty("PORT") ;
	driver= "com.mysql.jdbc.Driver";
	url ="jdbc:mysql://" +hostname+ ":" +port+"/"+ database;
 }
 
 
 public boolean open()  //to open a connection
 {
	try {
		DriverManager.registerDriver((java.sql.Driver) Class.forName(driver).newInstance());
		conn=DriverManager.getConnection(url,username,password);
		stat=conn.createStatement();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		if(conn==null)
			return false;
			
	}
	System.out.println("Connection successful");
	 return true;
 }
 public ResultSet executeQuery(String s) throws SQLException {
	 return stat.executeQuery(s);
	 }
 
 
 public void executeUpdate(String s) throws SQLException {
	 stat.executeUpdate(s);
	 
 }
}
