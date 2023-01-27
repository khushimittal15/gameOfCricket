import java.util.Scanner;
import java.lang.Math ;
public class Main {
    private static int[] GenerateScoreBoard(int overs,int players) {
        int random  ;
        int wickets= 0 ;
        int score = 0 ;
        for(int over= 0 ;over<overs ; over++){
            for(int ball = 0 ;ball<6;ball++){
                random = (int)(Math.random()*15)%8;
                if(random == 7){
                    System.out.print("W ");
                    wickets+=1 ;
                    if(wickets == players){
                        System.out.println("The inning is over");
                        return new int[]{score, wickets};
                    }
                }
                else if(random == 6){
                    System.out.print("6 ");
                    score+=6 ;
                }
                else if(random == 5){
                    System.out.print("5 ");
                    score+=5 ;
                }
                else if(random == 4){
                    System.out.print("4 ");
                    score+=4 ;
                }
                else if(random == 3){
                    System.out.print("3 ");
                    score+=3 ;
                }
                else if(random == 2){
                    System.out.print("2 ");
                    score+=2 ;
                }
                else if(random == 1){
                    System.out.print("1 ");
                    score+=1 ;
                }
                else{
                    System.out.print("0 ");

                }


            }
            System.out.println();

        }
        System.out.println("The inning is over");
        System.out.println();
        return new int[]{score, wickets};

    }
    public static void main(String[] args) {
        Batsman currentBatsman ;
        Bowler currentBowler ;
        Scanner sc = new Scanner(System.in) ;
        System.out.println("Please enter for how many overs would you like to play cricket?");
        int totalOvers = sc.nextInt();
        TeamDetails[] teams = new TeamDetails[2] ;
        for(int teamIndex= 0 ; teamIndex<2 ; teamIndex++){
            System.out.println("Enter name of team");
            teams[teamIndex] = new TeamDetails() ;
            teams[teamIndex].setTeamName(sc.next()) ;
            System.out.println("Enter names of player");
            for(int i = 0 ;i<5;i++){
                System.out.println("Enter player's name");
                String playerName = sc.next() ;
                System.out.println("Enter player's age");
                int playerAge = sc.nextInt() ;
                teams[teamIndex].addMembers(playerName,playerAge);
            }
        }

        int[] team1Score = GenerateScoreBoard(totalOvers,5) ;
        int[] team2Score = GenerateScoreBoard(totalOvers,5) ;

        System.out.println("Score of "+teams[0].getTeamName()+team1Score[0]+"/"+team1Score[1]);
        System.out.println("Score of "+teams[0].getTeamName()+team2Score[0]+"/"+team2Score[1]);
        
        if(team1Score[0]>team2Score[0])
            System.out.printf(teams[0].getTeamName()+" team won");
        else if(team2Score[0]>team1Score[0])
            System.out.println(teams[1].getTeamName()+" team won");
        else
            System.out.println("Match is a draw");



    }
}