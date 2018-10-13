
public class Artifacts {
	
	private double posX = 0;
	private double posY = 0;
	private double moreStat = 0;
	private String name = "";
	

	public Artifacts(double posX,double posY) {
		this.posX = posX;
		this.posY = posY;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPosX() {
		return posX;
	}

	public void setPosX(double posX) {
		this.posX = posX;
	}

	public double getPosY() {
		return posY;
	}

	public void setPosY(double posY) {
		this.posY = posY;
	}

	public double getMoreStat() {
		return moreStat;
	}

	public void setMoreStat(double moreStat) {
		this.moreStat = moreStat;
	}
	
	public double generateVector(Creature creature) {
		double finalX = creature.getPosX()-this.getPosX();
		double finalY = creature.getPosY()-this.getPosY();
		double vector = Math.sqrt((finalX*finalX)+(finalY*finalY));
		return vector;
	}

}
