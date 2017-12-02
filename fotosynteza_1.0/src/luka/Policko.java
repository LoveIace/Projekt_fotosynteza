package luka;

public class Policko {
	public int vyz_latky;
	public int voda;
	private Rastlina rastlina;
	
	Policko(){
		this.vyz_latky = 100;
		this.voda = 100;
	}
	
	public void setRastlina(Ihlicnan rastlina) {
		this.rastlina = rastlina;
	}
	public void setRastlina(Listnaty rastlina) {
		this.rastlina = rastlina;
	}
	public void setRastlina(Trava rastlina) {
		this.rastlina = rastlina;
	}
	public Rastlina getRastlina() {
		return this.rastlina;
	}
	
}
