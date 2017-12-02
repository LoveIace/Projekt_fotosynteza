package luka;

import java.util.concurrent.ThreadLocalRandom;

public class Kvet extends Rastlina {
	protected int listy;
	protected double plocha_listu;
	
	public Kvet(){
		this.listy = ThreadLocalRandom.current().nextInt(10, 20 + 1);
		this.plocha_listu = 10;
	}
}
