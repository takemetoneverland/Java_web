package poly.player;

import poly.car.Benz;
import poly.car.Car;
import poly.car.Sonata;

public class Warrior extends Player {
	
	int rage;
	
	Warrior(String name) {
		super(name);
		this.rage = 60;
	}
	
	/*
       1. rush라는 기술을 사용하는 사람의 이름을 
        적절한 키워드를 사용하여 출력해 주세요.
        
       2. 이 기술을 맞는 사람의 피해량을 출력해 주세요.
        전사는 10의 피해, 마법사는 20의 피해, 사냥꾼은 15의 피해를
        각각 입습니다.
        
       3. 직업별로 다른 피해량을 instanceof 키워드를 사용하여
        구분해서 출력해 주세요.
        
       4. 남은 체력들도 마찬가지로 출력해 주세요.
	 */

	@Override
	void characterInfo() {
		super.characterInfo();
		System.out.println("# 분노: " + rage);
	}
	
	public void rush(Player p) { 
		if(p instanceof Warrior) {
			System.out.println(this.name + "님이 " + p.name + "에게 돌진을 시전했습니다!");
			System.out.println(p.name + "(전사)님이 10의 피해를 입혔습니다.");
			p.hp -= 10;
			System.out.println(p.name + "님의 남은 체력: " + p.hp);
		} else if(p instanceof Mage) {
			System.out.println(this.name + "님이 " + p.name + "에게 돌진을 시전했습니다!");
			System.out.println(p.name + "(마법사)님이 10의 피해를 입혔습니다.");
			p.hp -= 20;
			System.out.println(p.name + "님의 남은 체력: " + p.hp);
		} else {
			System.out.println(this.name + "님이 " + p.name + "에게 돌진을 시전했습니다!");
			System.out.println(p.name + "(사냥꾼)님이 15의 피해를 입혔습니다.");
			p.hp -= 15;
			System.out.println(p.name + "님의 남은 체력: " + p.hp);
		}
	}

}
