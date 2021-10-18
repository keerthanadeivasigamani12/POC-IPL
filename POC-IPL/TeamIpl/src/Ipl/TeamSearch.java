package Ipl;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Ipl.TeamMembers;
import Ipl.database;
public class TeamSearch {
	public static List<TeamMembers> SearchTeamList() throws ClassNotFoundException
	{  
		List<TeamMembers> membersList = new ArrayList<TeamMembers>();
		
		    Scanner sc = new Scanner(System.in);
			System.out.println("Enter TeamID:");
			String team= sc.nextLine();
						
			String sql = "select * from ipl where teamid = '" + team + "' order by playerscore ASC";
			try (Connection conn = database.connect();
			java.sql.Statement st=conn.createStatement();
			ResultSet rs = st.executeQuery(sql);){
			
			
			while(rs.next()) {
			TeamMembers obj = new TeamMembers();
			obj.setTeamID(rs.getString(1));
			obj.setTeamName(rs.getString(2));
			obj.setPlayerName(rs.getString(3));
			obj.setPlayerScore(rs.getInt(4));
			membersList.add(obj);
			}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		
	
		return membersList;
	}
	
	public static void retrieveTeamList(List<TeamMembers> members) {
		for(TeamMembers e:members) {
			System.out.println(e.getTeamID()+" "+e.getTeamName()+" "+e.getPlayerName()+" "+e.getPlayerScore());
		}
	}
	
}
