
public class Creature {

	private double life = 110;
	private double magic = 0;
	private double attack = 0;
	private double posX = 0;
	private double posY = 0;
	private boolean isF = false;
	private String specie = "";
	private String name;
	

	public Creature(double life,double posX, double posY, double magic, double attack) {
		this.life = life;
		this.posX = posX;
		this.posY = posY;
		this.magic = magic;
		this.attack = attack;
	}
	
	public String getSpecie() {
		return specie;
	}
	
	public void setSpecie(String specie) {
		this.specie = specie;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getLife() {
		return life;
	}
	public void setLife(double life) {
		this.life = life;
	}
	
	public boolean isFighting() {
		return isF;
	}
	
	public void setIsFigthing(boolean isF) {
		this.isF = isF;
	}

	public double getMagic() {
		return magic;
	}

	public void setMagic(double magic) {
		this.magic = magic;
	}

	public double getAttack() {
		return attack;
	}

	public void setAttack(double attack) {
		this.attack = attack;
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
	
	public void move() {
		this.posX += (Math.random()*6)-3;
		this.posY += (Math.random()*6)-3;
	}
	
	public double generateVector(Creature a) {
		double finalX = a.getPosX()-this.getPosX();
		double finalY = a.getPosY()-this.getPosY();
		double vector = Math.sqrt((finalX*finalX)+(finalY*finalY));
		return vector;
	}
	
	

}
