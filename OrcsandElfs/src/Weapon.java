
public class Weapon extends Artifacts{
	private String weaponsTypes[] = {"hammer","axe","sword","long sword","scimitar","cudgel"};
	public Weapon(String name) {
		super(Math.round(Math.random()*500),Math.round(Math.random()*500));
		this.setMoreStat(10);
		this.setName(name);
	}
	
	public Weapon() {
		super(Math.round(Math.random()*500),Math.round(Math.random()*500));
		this.setMoreStat(10);
		this.setName(weaponsTypes[(int)Math.round(Math.random()*(weaponsTypes.length-1))]);
	}
	
	public void receiveItem(Creature creature) {
		if(creature.getSpecie() == "orc") {
			creature.setAttack(creature.getAttack()+this.getMoreStat());
		}
	}

}
