package luka;
import java.util.concurrent.ThreadLocalRandom;

public class Listnaty extends Strom {	
	public Listnaty(){
		this.vek = ThreadLocalRandom.current().nextInt(0, 100*365);
		this.rast_listov = ThreadLocalRandom.current().nextInt(0, 3)+3;
		this.max_listy = this.listy = (this.vek)*this.rast_listov;
		this.plocha_listu = ThreadLocalRandom.current().nextDouble(0, 10) + 15;
	}
	public Listnaty(int listy, double plocha) {
		this.vek = 10;
		this.rast_listov = 5;
		this.max_listy = this.listy = listy;
		this.plocha_listu = plocha;
	}
	public Listnaty(int vek){
		if (vek<0)
			vek = 0;
		this.vek = ThreadLocalRandom.current().nextInt(0, (365*vek)/10)+365*vek-(365*vek)/20;
		this.rast_listov = ThreadLocalRandom.current().nextInt(0, 3)+3;
		this.max_listy = this.listy = (this.vek)*this.rast_listov;
		this.plocha_listu = ThreadLocalRandom.current().nextDouble(0, 10) + 15;
	}
}
