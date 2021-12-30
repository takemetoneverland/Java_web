package poly.car;

public class MainClass {

	public static void main(String[] args) {
		
		Car s1 = new Sonata();
		Sonata s2 = new Sonata();
		Sonata s3 = new Sonata();
		
		Car b1 = new Benz();
		Benz b2 = new Benz();
		Benz b3 = new Benz();
		
		Car t1 = new Tesla();
		Tesla t2 = new Tesla();
		Tesla t3 = new Tesla();
		Tesla t4 = new Tesla();

		Car[] cars = {s1, s2, s3, b1, b2, b3, t1, t2, t3, t4};
		for(Car c : cars) {
			c.run();
		}
		
		System.out.println("--------------------------------------");
		
		Driver kim = new Driver();
		kim.drive(b2);
		kim.drive(s3);
		kim.drive(t2);
		
		System.out.println("--------------------------------------");
		
		Tesla t5 = (Tesla) kim.buyCar("테슬라");
		t5.run();
		t5.enterMembership();
//		c.run();
//		Tesla t5 = (Tesla) c;
//		t5.enterMembership();
		
		System.out.println("--------------------------------------");
		
		s1.frontLeft = new Ntire();
		s1.frontRight = new Ntire();
		s1.rearLeft = new Htire();
		s1.rearRight = new Htire();
		
		System.out.println("--------------------------------------");
		
		CarShop shop = new CarShop();
		shop.carPrice(s1);
		shop.carPrice(new Benz());
		shop.carPrice(kim.buyCar("테슬라"));
		
	}

}
