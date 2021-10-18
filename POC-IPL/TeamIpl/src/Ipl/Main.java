package Ipl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Ipl.TeamMemberService;
import Ipl.TeamMembers;
import Ipl.database;
import Ipl.TeamUpdate;
import Ipl.TeamSearch;

public class Main {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		boolean var= database.addTeamMembersList(TeamMemberService.buildTeamMembersList());
		if(var) {
			System.out.println("Database Update Successful");
		}
		
		boolean update= TeamUpdate.updateTeamMembersList(TeamUpdate.TeamScoreList());
		if(update) {
			System.out.println("Changes Updated Successfully");
		}
		
		TeamSearch.retrieveTeamList(TeamSearch.SearchTeamList());
	
	}
	
}
