package rocne.obdobie;

public class Rok {
	public Obdobie[] obdobie = new Obdobie[4];
	
	public Rok() {
		obdobie[1] = new Jar();
		obdobie[2] = new Leto();
		obdobie[3] = new Jesen();
		obdobie[0] = new Zima();
	}	
}
