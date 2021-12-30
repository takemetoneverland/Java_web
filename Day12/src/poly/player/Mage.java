package poly.player;

public class Mage extends Player {
	
	int mana;
	
	Mage(String name) {
		super(name);
		mana = 100;
	}
	
	public void blizzard(Player[] player) { //{w1,w2,m2,h1,h2}
		
		System.out.printf("%s님이 눈보라 시전!!!\n", this.name);
		System.out.println("---------------------------------");
		for(Player p : player) {
			int damage = (int) ((Math.random()*6) + 10);
			p.hp -= damage;
			System.out.printf("%s님이 %d만큼의 피해를 입었습니다. (남은 체력: %d)\n"
					, p.name, damage, p.hp);
		}
		
	}

	@Override
	void characterInfo() {
		super.characterInfo();
		System.out.println("# 정신력: " + mana);
	}
	

}
