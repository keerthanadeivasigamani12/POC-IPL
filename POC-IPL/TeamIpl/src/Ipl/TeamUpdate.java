package Ipl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Ipl.TeamMembers;
import Ipl.database;
public class TeamUpdate {
	public static List<TeamMembers> TeamScoreList()
	{  
		List<TeamMembers> membersList = new ArrayList<TeamMembers>();
		
		for(int i=1;i<=10;i++) {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter playername:");
			String player= sc.nextLine();
			
			System.out.println("Enter playerscore:");
			int score = sc.nextInt();
			
			TeamMembers obj = new TeamMembers();
			obj.setPlayerScore(score);
			obj.setPlayerName(player);
			
			membersList.add(obj);
		}
		
		
		return membersList;
	}
	
	
	public static boolean updateTeamMembersList(List<TeamMembers> members) throws ClassNotFoundException{
		
		boolean status = false;
		
		
		try {
			
			Connection conn = database.connect();
			PreparedStatement ps;
		String sql = "UPDATE ipl set playerscore = ? where playername = ?";
		
		for(TeamMembers e:members) {
		ps = conn.prepareStatement(sql);
		ps.setInt(1, e.getPlayerScore());
		ps.setString(2, e.getPlayerName());
		
	    int i=ps.executeUpdate();
		
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
