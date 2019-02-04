
public class Orc extends Creature{
		
	private Weapon weapons[];
	private String orcNames[] = {"Rugorim","Zalthu","Dumburz","Toghat","Purbag","Vukgilug","Orgug","Traugh","Yargol","Rurbag"};
	private double power = 0;

	public Orc(String name) {
		super(110,Math.round(Math.random()*500),Math.round(Math.random()*500),Math.random()*5,Math.random()*12+8);
		this.setSpecie("orc");
		this.setName(name);
	}
	
	public Orc() {
		super(110,Math.round(Math.random()*500),Math.round(Math.random()*500),Math.random()*5,Math.random()*12+8);
		this.setSpecie("orc");
		this.setName(orcNames[(int)Math.round(Math.random()*(orcNames.length-1))]);
	}
	
	public void fight(Elf elf) {
		this.setIsFigthing(true);
		elf.setIsFigthing(true);
		double intelligenceOrc = Math.random();
		if(intelligenceOrc <= 0.5) {
			this.setPower(this.getAttack() + (Math.random()+25));
		} else {
			this.setPower(this.getMagic() - 5);
		}
		
		double intelligenceElf = Math.random();
		if(intelligenceElf > 0.5) {
			elf.setPower(this.getMagic()+(Math.random()*15));
		} else {
			elf.setPower(this.getAttack() + 5);
		}
		
		if(this.getPower() >= elf.getPower()) {
			elf.setLife(elf.getLife()-this.getPower());;
		} else {
			this.setLife(this.getLife()-elf.getPower());
		}
		this.setIsFigthing(false);
		elf.setIsFigthing(false);
	}
	

	public Weapon[] getWeapons() {
		return weapons;
	}

	public void setWeapons(Weapon[] weapons) {
		this.weapons = weapons;
	}

	public double getPower() {
		return power;
	}

	public void setPower(double power) {
		this.power = power;
	}
	
	
	public void move(Creature b[]) {
		Creature nearestCreature = null;
		double distanceBetween = 0;
		
		for(int i = 0 ; i<b.length ; i++) {
			if(b[i]!=null) {
				if(distanceBetween == 0) {
					nearestCreature = b[i];
					distanceBetween = this.generateVector(nearestCreature);
				}
				if(this.generateVector(nearestCreature) > this.generateVector(b[i])) {
					nearestCreature = b[i];
					distanceBetween = this.generateVector(nearestCreature);
				}
			}
		}

		if(nearestCreature!=null) {
			if(this.getPosX() < nearestCreature.getPosX()) {
				this.setPosX(this.getPosX()+1);
			} else if(this.getPosX()>nearestCreature.getPosX()){
				this.setPosX(this.getPosX()-1);
			}
			
			if(this.getPosY() < nearestCreature.getPosY()) {
				this.setPosY(this.getPosY()+1);
			} else if(this.getPosY()>nearestCreature.getPosY()){
				this.setPosY(this.getPosY()-1);
			}	
		}
	}
	


}
