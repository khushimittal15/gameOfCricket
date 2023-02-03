package MatchInputs;

import ScoreCalculations.CalculateScores;
import TeamDetails.*;
import Toss.DecidePlayingOrder;

import java.util.Scanner;

public class Match {
    public static int overs;
    public static int playersInEachTeam;
    public static TeamDetails[] teams = new TeamDetails[2];

    public static void initialize() {
        Scanner sc = new Scanner(System.in);
        Thread th = new Thread();

        System.out.println("ENTER TOTAL OVERS YOU WANT TO PLAY");
        overs = sc.nextInt();
        System.out.println("ENTER NUMBER OF PLAYERS IN EACH TEAM");
        Match.playersInEachTeam = sc.nextInt();
        sc.nextLine();

        TakeTeamDetails.takeTeamDetails(sc);
        DecidePlayingOrder.decidePlayingOrder();
        CalculateScores.calculateScores(th);


    }
}
