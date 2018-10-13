import java.util.ArrayList;

public class Elf extends Creature{
	
	private ArrayList<Amulet> amulets = new ArrayList<Amulet>();
	private String elficNames[] = {"Light Shoot","Nuvian Ylladove","Braern Olaberos","Aithlin Pawreak","Khiiral Adna","Elauthin Xyrdithas",
								   "Vulen Omageiros","Halueve Magxidor","Lorsan Ulajor","Hubys Thesys","Alluin Xildi"};
	private double power = 0;

	public Elf(String name) {
		super(90,Math.round(Math.random()*500),Math.round(Math.random()*500),Math.random()*15+15,Math.random()*5+5);
		this.setSpecie("elf");
		this.setName(name);
	}
	
	public Elf() {
		super(90,Math.round(Math.random()*500),Math.round(Math.random()*500),Math.random()*15+150000,Math.random()*5+5);
		this.setSpecie("elf");
		this.setName(elficNames[(int)Math.round(Math.random()*(elficNames.length-1))]);
	}
	
	public void fight(Orc orc) {
		this.setIsFigthing(true);
		orc.setIsFigthing(true);
		double intelligenceElf = Math.random();
		//System.out.println(intelligenceElf);
		if(intelligenceElf < 0.5) {
			this.setPower(this.getMagic()+(Math.random()*15));
		} else {
			this.setPower(this.getAttack() + 5);
		}
		double intelligenceOrc = Math.random();
		//System.out.println(intelligenceOrc);
		if(intelligenceOrc >= 0.5) {
			orc.setPower(this.getAttack() + (Math.random()+25));
		} else {
			orc.setPower(this.getMagic() - 5);
		}
		if(this.getPower() >= orc.getPower()) {
			orc.setLife(orc.getLife()-this.getPower());;
		} else {
			this.setLife(this.getLife()-orc.getPower());
		}
		this.setIsFigthing(false);
		orc.setIsFigthing(false);
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
				}
			}
		}

		if(nearestCreature!=null) {
			//System.out.println("\n X: " + nearestCreature.getPosX() + " Y: " + nearestCreature.getPosY());
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
		} else {
			//System.out.println("NUUUUUUUUUUUUUUUUUUUUUUUUULLLLLLLLLLLLLL CREATURE");
		}
		
	}

	public ArrayList<Amulet> getAmulets() {
		return amulets;
	}

	public void setAmulets(ArrayList<Amulet> amulets) {
		this.amulets = amulets;
	}

	public double getPower() {
		return power;
	}

	public void setPower(double power) {
		this.power = power;
	}
	
	public void receiveAmulet(Amulet amulet) {
		amulets.add(amulet);
		this.setMagic(this.getMagic()+15);
	}
}
