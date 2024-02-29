/**
 * Handles all PLayer Data
 *
 * @Author Holden Merkel & Hunter Schoch
 * @Since 2024.02.21
 * @Version 1.0
 */
public class Player {

	private int jersey;
	
	private String name;

	private int fieldGoals_1pt;

	private int fieldGoals_2pt;

	private int fieldGoals_3pt;

	private int fouls;
	
	private Player(){
		this.jersey = 0;
		this.name = "Unknown";
		this.fieldGoals_1pt = 0;
		this.fieldGoals_2pt = 0;
		this.fieldGoals_3pt = 0;
		this.fouls = 0;
	}
	
	public Player(int jersey) throws Exception {
		this();
		this.setJersey(jersey);
	}

	public Player(int jersey, String name) throws Exception {
		this();
		this.setName(name);
		this.setJersey(jersey);
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) throws Exception {
		name = name.trim();
		
		if (name.isEmpty())
			throw new Exception("Player name can not be blank.");
			
		this.name = name;
	}

	public int getJersey() {
		return this.jersey;
	}

	public void setJersey(int id) throws Exception {
		if (id < 0 || id > 55) {
            throw new Exception("Player ID can not be negative.");
        }
		
		this.jersey = id;
	}

	public void foul() {
		this.fouls++;
	}

	public int getFouls(){
		return this.fouls;
	}

	public int getFieldGoals_1pt(){
		return this.fieldGoals_1pt;
	}

	public int getFieldGoals_2pt(){
		return this.fieldGoals_2pt;
	}

	public int getFieldGoals_3pt(){
		return this.fieldGoals_3pt;
	}

	public void shot(int shotType) throws Exception {
		switch (shotType) {
			case 2:
				this.fieldGoals_1pt++;
				break;

			case 3:
				this.fieldGoals_2pt++;
				break;

			case 4:
				this.fieldGoals_3pt++;
				break;

			default:
				throw new Exception("Invalid Input!");
		}
	}

	public int getPoints() {
		return this.fieldGoals_1pt + (this.fieldGoals_2pt * 2) + (this.fieldGoals_3pt * 3);
	}

	public void displayStats(){
		System.out.print("#" + this.getJersey());
		System.out.print(" " + this.name);
		System.out.print(" Fouls: " + this.getFouls());
		System.out.println(" Points: " + this.getPoints());
	}

	@Override
    public boolean equals(Object object) {
        
        if(!(object instanceof Player))
            return false;
        
        Player other = (Player)object;

        return this.jersey == other.getJersey();
    }
	
	@Override 
	public String toString(){
		return this.jersey + " " + this.name;
	}
	
}
