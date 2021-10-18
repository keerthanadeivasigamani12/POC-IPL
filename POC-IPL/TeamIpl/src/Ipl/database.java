package Ipl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;
import java.util.List;


public class database {
	private static String dbDriver = "com.mysql.jdbc.Driver";
	private static String dbUrl = "jdbc:mysql://localhost:3306/teamipl";
	private static String dbUname = "root";
	private static String dbPassword = "Keerthi@123";
	
	
	
	
	public static Connection connect()  throws ClassNotFoundException, SQLException{
		try {
			Class.forName(dbDriver);
			
			return DriverManager.getConnection(dbUrl, dbUname, dbPassword);
		}
		catch( ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public static boolean addTeamMembersList(List<TeamMembers> members) throws ClassNotFoundException, SQLException
	{ 
		boolean status = false;
		
		
		try {
			
			Connection conn = connect();
			PreparedStatement ps;
		String sql = "INSERT INTO ipl(TeamID,TeamName,PlayerName) VALUES(?,?,?)";
		
		for(TeamMembers e:members) {
		ps = conn.prepareStatement(sql);
		ps.setString(1, e.getTeamID());
		ps.setString(2, e.getTeamName());
		ps.setString(3, e.getPlayerName());
		
		int i= ps.executeUpdate();
		if(i>0) {
			status = true;
		}
		else {
			status =  false;
		}
		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
	}

