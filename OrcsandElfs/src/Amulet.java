
public class Amulet extends Artifacts{
	private String amuletsTypes[] = {"wand","scepter","warhorn","focus","dagger","staff"};
	
	public Amulet(String name) {
		super(Math.round(Math.random()*500),Math.round(Math.random()*500));
		this.setMoreStat(15);
		this.setName(name);
	}
	
	public Amulet() {
		super(Math.round(Math.random()*500),Math.round(Math.random()*500));
		this.setMoreStat(15);
		this.setName(amuletsTypes[(int)Math.round(Math.random()*(amuletsTypes.length-1))]);
	}
	
	
	public void receiveItem(Creature creature) {
		if(creature.getSpecie() == "elf") {
			creature.setMagic(creature.getMagic()+this.getMoreStat());
		}
	}
	
	
	

}
