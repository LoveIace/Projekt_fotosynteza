package luka;

public class Trava extends Rastlina {
	
	Trava(){
		this.listy = 8000;
		this.plocha_listu = 5;
	}
	Trava(int vek){
		this.listy = 8000;
		this.plocha_listu = 5;
	}
	public void pi(Policko x) {
		x.voda--;
		x.vyz_latky++;
	}
	public void strat_listy() {}
	public void rast_listy() {}
	public void starni() {}
}
