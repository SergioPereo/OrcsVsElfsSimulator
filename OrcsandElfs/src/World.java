
public class World {

	Orc[] orcs = {new Orc(),new Orc(),new Orc(),new Orc(),new Orc()};
	Elf[] elfs = {new Elf(),new Elf(),new Elf(),new Elf(),new Elf()};
	Weapon[] weapons = {new Weapon(),new Weapon(),new Weapon(),new Weapon(),new Weapon(),
						new Weapon(),new Weapon(),new Weapon(),new Weapon(),new Weapon(),
						new Weapon(),new Weapon(),new Weapon(),new Weapon(),new Weapon(),
						new Weapon(),new Weapon(),new Weapon(),new Weapon()
						};
	Amulet[] amulets = {new Amulet(),new Amulet(),new Amulet(),new Amulet(),new Amulet(),new Amulet(),new Amulet(),new Amulet(),new Amulet(),
						new Amulet(),new Amulet(),new Amulet(),new Amulet(),new Amulet(),new Amulet(),new Amulet(),new Amulet(),new Amulet(),
						new Amulet()
						};
	String winner = "None";
	String loser = "None";
	public static void main(String[] args) {
		World world = new World();
		world.run();
	}
	
	public World() {
		
	}
	
	public void run() {
		printPositions(orcs,elfs);
		int days = 0;
		while(!orcsDead() == !elfsDead()) {
			movement(orcs,elfs);
			artifactsInteraction(weapons,amulets,orcs,elfs);
			physicsFights(orcs,elfs);
			lifeComparison(orcs,elfs);
			//printPositions(orcs,elfs);
			artifactsInteraction(weapons,amulets, orcs, elfs);
			days++;
		}
		if(orcsDead()) {
			winner = "Elfs";
			loser = "Orcs";
			
		} else {
			winner = "Orcs";
			loser = "Elfs";
		}
		System.out.println("The "+ winner + " defeat " + loser + " in " + days + " days");
	}
	
	public void printPositions(Creature a[],Creature b[]) {
		System.out.println("\n-------------------------------------------------------------\n");
		System.out.println("ORCS");
		for(int i = 0 ; i<a.length ; i++) {
			if(a[i]!=null) {
				System.out.println("\nOrc: "+a[i].getName()+"\tX:  " + a[i].getPosX() + "\tY: " + a[i].getPosY());
			} else {
				System.out.println("\nOrc: Died!!!!!!!!!!!!!");
			}
		}
		System.out.println("\n-------------------------------------------------------------\n");
		System.out.println("\n-------------------------------------------------------------\n");
		System.out.println("ELFS");
		for(int i = 0 ; i<b.length ; i++) {
			if(b[i]!=null) {
				System.out.println("\nElf: "+b[i].getName()+"\tX:  " + b[i].getPosX() + "\tY: " + b[i].getPosY());
			} else {
				System.out.println("\nElf: Died!!!!!!!!!!!!!");
			}
		}
		System.out.println("\n-------------------------------------------------------------\n");
	}
	
	public void physicsFights(Orc a[], Elf b[]) {
		for(int i = 0 ; i<a.length ; i++) {
			for(int j = 0 ; j<b.length ; j++) {
				if(a[i]!=null && b[j]!=null) {
					if(a[i].generateVector(b[j])<5) {
						a[i].fight(b[j]);
					}
				}
			}
		}
		for(int i = 0 ; i<b.length ; i++) {
			for(int j = 0 ; j<a.length ; j++) {
				if(b[i]!=null && a[j]!=null) {
					if(b[i].generateVector(a[j])<5) {
						b[i].fight(a[j]);
					}
				}
			}
		}
	}
	
	public void movement(Orc a[], Elf b[]) {
		for(int i = 0 ; i<a.length ; i++) {
			if(a[i] != null && !a[i].isFighting()) {
				a[i].move(b);
			}
		}
		for(int i = 0 ; i<b.length ; i++) {
			if(b[i] != null && !b[i].isFighting()) {
				b[i].move(a);
			}
		}
	}
	
	
	public void artifactsInteraction(Weapon a[],Amulet b[], Creature c[], Creature d[]) {
		for(int i = 0 ; i<a.length ; i++) {
			for(int j = 0 ; j<c.length ; j++) {
				if(a[i]!=null && c[j]!=null) {
					if(a[i].generateVector(c[j]) < 5) {
						a[i].receiveItem(c[j]);
						System.out.println("The Orc: " + c[j].getName() + " pick a " + a[i].getName());
						a[i] = null;
					}
				}
			}
			for(int j = 0 ; j<d.length ; j++) {
				if(a[i]!=null && d[j]!=null) {
					if(a[i].generateVector(d[j]) < 5) {
						a[i].receiveItem(d[j]);
						System.out.println("The Elf: " + d[j].getName() + " destroy a " + a[i].getName());
						a[i] = null;
					}
				}
			}
		}
		for(int i = 0 ; i<b.length ; i++) {
			for(int j = 0 ; j<c.length ; j++) {
				if(b[i]!=null && c[j]!=null) {
					if(b[i].generateVector(c[j]) < 5) {
						b[i].receiveItem(c[j]);
						System.out.println("The Orc: " + c[j].getName() + " destroy a " + b[i].getName());
						b[i] = null;
					}
				}
			}
			for(int j = 0 ; j<d.length ; j++) {
				if(b[i]!=null && d[j]!=null) {
					if(b[i].generateVector(d[j]) < 5) {
						b[i].receiveItem(d[j]);
						System.out.println("The Elf: " + d[j].getName() + " pick a " + b[i].getName());
						b[i] = null;
					}
				}
			}
		}
	}
	
	public void lifeComparison(Orc a[], Elf b[]) {
		for(int i = 0 ; i<a.length ; i++) {
			if(a[i]!=null) {
				if(a[i].getLife()<=0) {
					System.out.println("The orc " + a[i].getName() + " died");
					a[i] = null;
				}
			}
			
		}
		for(int i = 0 ; i<b.length ; i++) {
			if(b[i]!=null) {
				if(b[i].getLife()<=0) {
					System.out.println("The elf " + b[i].getName() + " died");
					b[i] = null;
				}
			}
			
		}
	}
	
	public boolean orcsDead() {
		return (orcs[0]==null)&&(orcs[1]==null)&&(orcs[2]==null)&&(orcs[3]==null)&&(orcs[4]==null);
	}
	
	public boolean elfsDead() {
		return (elfs[0]==null)&&(elfs[1]==null)&&(elfs[2]==null)&&(elfs[3]==null)&&(elfs[4]==null);
	}
	
	public Orc[] getOrcs() {
		return orcs;
	}
	
	public Elf[] getElfs() {
		return elfs;
	}
}
