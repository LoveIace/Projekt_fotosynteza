package luka;

public class Rastlina {
	protected int max_listy;
	protected int listy;
	protected double plocha_listu;
	protected int vek;
	protected int hodin_bez_vody = 0;
	protected int rast_listov;
	
	public int getListy() {
		return this.listy;
	}
	public double getPlocha_listu() {
		return this.plocha_listu;
	}
	public int getVek() {
		return this.vek;
	}
	public void strat_listy() {
		this.listy-= this.max_listy/500;
		if (this.listy<0)
			this.listy=0;
	}
	public void rast_listy() {
		this.listy+= this.max_listy/500;
		if (this.listy>this.max_listy)
			this.listy=this.max_listy;
	}
	public void starni() {
		this.vek++;
		this.max_listy+=this.rast_listov;
	}
	public void damage(Policko x) {
		this.hodin_bez_vody++;
		if (hodin_bez_vody == 48)
			x.setRastlina(new Trava());
	}
	public void pi(Policko x) {
		x.voda-=x.getRastlina().getListy()/20000;
		if (x.voda<0)
			x.voda=0;
		x.vyz_latky++;
	}
}