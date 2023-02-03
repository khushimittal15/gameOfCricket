package TeamDetails;

import java.util.Scanner;
import  MatchInputs.Match ;
public class TakeTeamDetails {

    public static void takeTeamDetails(Scanner sc) {
        for (int teamIndex = 0; teamIndex < 2; teamIndex++) {
            System.out.println("ENTER YOUR TEAM'S NAME");
            Match.teams[teamIndex] = new TeamDetails();
            Match.teams[teamIndex].setTeamName(sc.next());
            System.out.println("ENTER PLAYERS' DETAILS");
            System.out.println();
            for (int i = 0; i < Match.playersInEachTeam; i++) {
                System.out.println("NAME");
                sc.nextLine();
                String playerName = sc.nextLine();
                System.out.println("AGE");
                int playerAge = sc.nextInt();
                System.out.println("PRESS 1 FOR BATSMAN, PRESS 0 FOR BOWLER");
                String choice = sc.next();
                boolean isBowler = choice == "0" ? true : false;
                Match.teams[teamIndex].addMembers(playerName, playerAge, isBowler);
                System.out.println();
            }

        }
    }


}
