package Ipl;

import java.io.*;
import java.util.ArrayList;
import java.util.List; 
import Ipl.TeamMembers;
public class TeamMemberService {
	
	 
	 
	public static List<TeamMembers> buildTeamMembersList()
	{  
		List<TeamMembers> membersList = new ArrayList<TeamMembers>();
	try  
	{  
	File file=new File("C:\\Users\\k.deivasigamani\\Documents\\Team.txt");   
	FileReader fr=new FileReader(file);    
	BufferedReader br=new BufferedReader(fr);   
	  
	String line;  
	
	while((line=br.readLine())!=null)  
	{  
	 
		String[] team= line.split("\t");
		String TeamID=team[0];
		String TeamName=team[1];
		String PlayerName=team[2];
		
		TeamMembers obj = new TeamMembers();
		obj.setTeamID(TeamID);
		obj.setTeamName(TeamName);
		obj.setPlayerName(PlayerName);
		
		membersList.add(obj);
	}  
	fr.close();   
	
	}  
	catch(IOException e)  
	{  
	e.printStackTrace();  
	}  
	
	return membersList;
	}  
	}  


