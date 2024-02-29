/**
 * Handles all Team Data
 *
 * @Author Holden Merkel & Hunter Schoch
 * @Since 2024.02.21
 * @Version 1.0
 */
import java.util.ArrayList;
import java.util.List;


public class Team {

    private String teamName;
    private List<Player> players;

    public Team() {
        this.teamName =  "Unknown";
        players = new ArrayList<Player>();
    }

    public Team(String teamName) throws Exception {
        this();
        this.setTeamName(teamName);
    }

    public void setTeamName(String teamName) throws Exception {
        teamName = teamName.trim();

        if (teamName.isEmpty())
            throw new Exception("Team name can not be blank!");

        this.teamName = teamName;
    }
    public String getTeamName() {
        return this.teamName;
    }

    public Player getPlayer(int jersey) throws Exception {

        int index = this.players.indexOf(new Player(jersey));

        if (index == -1)
            return null;
        else
            return this.players.get(index);
    }

    public void addPlayer(String name, int jersey) throws Exception {
        Player player = this.getPlayer(jersey);

        if (player == null) {
            this.players.add(new Player(jersey, name));
        } else {
            throw new Exception("Jersey: " + jersey + " is already in use  by " + player.getName() + "!");
        }
    }


    public int getTeamPoints() {
        int totalPoints = 0;

        for (int i = 0; i < this.players.size(); i++) {
            totalPoints += this.players.get(i).getPoints();
        }

        return totalPoints;
    }

    public int getTeamFouls() {
        int totalFouls = 0;

        for (int i = 0; i < this.players.size(); i++) {
            totalFouls += this.players.get(i).getFouls();
        }

        return totalFouls;
    }

    public void displayTeamStats() {
        System.out.println(this.teamName);
        System.out.println(" Fouls=" + this.getTeamFouls());
        System.out.println(" Points=" + this.getTeamPoints());
    }

    public void displayDetailStats() {
        this.displayTeamStats();
        System.out.println();
        System.out.println("Jersey Name            Fouls Free Throw 2pt FG 3pt FG");
        System.out.println("====== =============== ===== ========== ====== ======");

        for (int i = 0; i < players.size(); i++) {
            System.out.printf("%6d %-15s %5d %10d %6d %6d\n",
                    this.players.get(i).getJersey(),
                    this.players.get(i).getName(),
                    this.players.get(i).getFouls(),
                    this.players.get(i).getFieldGoals_1pt(),
                    this.players.get(i).getFieldGoals_2pt(),
                    this.players.get(i).getFieldGoals_3pt(),
                    this.players.get(i).getPoints());
        }
    }

    @Override
    public String toString(){
        return this.teamName;
    }

} 
