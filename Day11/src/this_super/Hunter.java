package this_super;

public class Hunter extends Player {

	String pet;
	
	Hunter(String name) {
		super(name);
		this.pet = "고양이";
	}

	@Override
	void characterInfo() {
		super.characterInfo();
		System.out.println("# 펫이름: " + pet);
	}
	
	
}
