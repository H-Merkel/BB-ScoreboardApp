/**
 * Handles all UI information
 *
 * @Author Holden Merkel & Hunter Schoch
 * @Since 2024.02.21
 * @Version 1.0
 */
import java.util.ArrayList;
import java.util.List;



public class ScoreboardApp {
    private final static String DOUBLE_LINE = "==================================================";
    private final static String SINGLE_LINE = "--------------------------------------------------";

    Team homeTeam;
    Team awayTeam;

    public ScoreboardApp(){
        homeTeam = new Team();
        awayTeam = new Team();
    }

    private void displayAppHeading() {
        System.out.println(DOUBLE_LINE);
        System.out.println("Welcome to the Scoreboard App");
        System.out.println(DOUBLE_LINE);
        System.out.println();
    }

    private void setupTeams() throws Exception {

        String teamName = "Unknown";

        teamName = Input.getLine("Enter Home Team's name: ");
        this.homeTeam.setTeamName(teamName);
        this.setupPlayers(this.homeTeam);

        System.out.println();

        teamName = Input.getLine("Enter Away Team's name: ");
        this.awayTeam.setTeamName(teamName);
        this.setupPlayers(this.awayTeam);

    }

    private void setupPlayers(Team team) {
        String teamName = team.getTeamName();
        String playerName = null;
        int playerJersey = 0;

        while (true) {
            System.out.println();
            playerName = Input.getLine("Enter " + teamName + " player's name or 'q' to quit: ");

            if (playerName.equals("q"))
                return;

            try {
                playerJersey = Input.getIntRange("Enter " + playerName + " jersey number: ", 0, 55);
                team.addPlayer(playerName, playerJersey);
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("Unable to add student!");
            }

        }

    }

    private void playGame() throws Exception {

        boolean keepLooping = true;
        int userInput = 0;

        System.out.println();
        System.out.println(DOUBLE_LINE);
        System.out.println("Play Ball");
        System.out.println(DOUBLE_LINE);
        System.out.println();

        while (keepLooping) {

            System.out.println(SINGLE_LINE);
            System.out.println("Main Menu");
            System.out.println(SINGLE_LINE);

            System.out.println("0 = End Scoreboard App");
            System.out.println("1 = Enter " + homeTeam.getTeamName() + " Stats");
            System.out.println("2 = Enter " + awayTeam.getTeamName() + " Stats");
            System.out.println("3 = Display Game Stats");

            System.out.println(SINGLE_LINE);
            userInput = Input.getIntRange("Menu Choice: ", 0, 3);
            System.out.println(SINGLE_LINE);

            System.out.println();

            switch (userInput) {
                case 0:
                    keepLooping = false;
                    System.out.println();
                    break;

                case 1:
                    this.updateTeamStats(homeTeam);
                    break;

                case 2:
                    this.updateTeamStats(awayTeam);
                    break;

                case 3:
                    this.displayGameStatus();
                    break;

                default:
                    System.out.println("Invalid menu choice = " + userInput);

            }
        }

    }

    private void updateTeamStats(Team team) throws Exception {
        int playerJersey = 0;
        Player player;

        while (true) {
            playerJersey = Input.getIntRange("Enter " + team.getTeamName() + "'s Player Jersey # or 0 to quit: ", 0, 55);

            if (playerJersey == 0)
                break;

            player = team.getPlayer(playerJersey);

            if (player == null) {
                System.out.println("Invalid Jersey Number, please try again!");
                continue;
            }

            this.updatePlayerStats(player);

        }
        System.out.println();
        System.out.println(SINGLE_LINE);
        team.displayTeamStats();
        System.out.println(SINGLE_LINE);
        System.out.println();

    }

        private void updatePlayerStats(Player player) throws Exception {
            int status = 0;

            System.out.println();

            System.out.println(SINGLE_LINE);
            System.out.println("Enter #" + player.getJersey() + " " + player.getName() + " Stats");
            System.out.println(SINGLE_LINE);

            System.out.println("0 = Return");
            System.out.println("1 = Foul");
            System.out.println("2 = Free Throw");
            System.out.println("3 = 2pt Field Goal");
            System.out.println("4 = 3pt Field Goal");

            System.out.println(SINGLE_LINE);
            status = Input.getIntRange("Enter Status: ", 0, 4);
            System.out.println(SINGLE_LINE);

            switch(status) {
                case 0:
                    System.out.println("No changes have been updated.");
                    break;
                case 1:
                    player.foul();
                    break;
                case 2:
                    player.shot(status);
                    break;
                case 3:
                    player.shot(status);
                    break;
                case 4:
                    player.shot(status);
                    break;
                default:
                    throw new Exception("Invalid attendance status!");
        }
            player.displayStats();
            System.out.println();
    }

    private void updateScoreboard() {
        this.homeTeam.displayTeamStats();
        this.awayTeam.displayTeamStats();
    }

    private void displayGameStatus() {
        System.out.println(DOUBLE_LINE);
        System.out.println("Home Team");
        this.homeTeam.displayDetailStats();

        System.out.println();

        System.out.println("Away Team");
        this.awayTeam.displayDetailStats();
    }

    public static void main(String[] args) throws Exception {

        ScoreboardApp app = new ScoreboardApp();

        app.displayAppHeading();

        try {
            app.setupTeams();
            app.playGame();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Sorry but this program ended with an error. Please contact Hunter or Holden!");
        }

        Input.sc.close();

    }
}
