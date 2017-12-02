package luka;

import java.util.concurrent.ThreadLocalRandom;

public class Ihlicnan extends Strom{
	public Ihlicnan(){
		this.rast_listov = ThreadLocalRandom.current().nextInt(0, 5)+30;
		this.vek = ThreadLocalRandom.current().nextInt(0, 100*365);
		this.max_listy = this.listy = (this.vek)*this.rast_listov;
		this.plocha_listu = 2;
	}
	public Ihlicnan(int listy, double plocha) {
		this.rast_listov = 35;
		this.max_listy = this.listy = listy;
		this.plocha_listu = plocha;
	}
	public Ihlicnan(int vek){
		this.rast_listov = ThreadLocalRandom.current().nextInt(0, 5)+30;
		this.vek = ThreadLocalRandom.current().nextInt(0, (365*vek)/10)+365*vek-(365*vek)/20;
		this.max_listy = this.listy = (this.vek)*this.rast_listov;
		this.plocha_listu = 2;
	}
}
