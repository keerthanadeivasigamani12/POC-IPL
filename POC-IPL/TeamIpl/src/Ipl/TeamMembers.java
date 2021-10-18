package Ipl;

public class TeamMembers {
	String TeamID;
	String TeamName;
	String PlayerName;
	int PlayerScore;
	
	
	public TeamMembers() {
		super();
		
	}


	public TeamMembers(String teamID, String teamName, String playerName, int playerScore) {
		super();
		TeamID = teamID;
		TeamName = teamName;
		PlayerName = playerName;
		PlayerScore = playerScore;
	}

    



	public String getTeamID() {
		return TeamID;
	}





	public void setTeamID(String teamID) {
		TeamID = teamID;
	}





	public String getTeamName() {
		return TeamName;
	}





	public void setTeamName(String teamName) {
		TeamName = teamName;
	}





	public String getPlayerName() {
		return PlayerName;
	}





	public void setPlayerName(String playerName) {
		PlayerName = playerName;
	}





	public int getPlayerScore() {
		return PlayerScore;
	}





	public void setPlayerScore(int playerScore) {
		PlayerScore = playerScore;
	}





	
}
