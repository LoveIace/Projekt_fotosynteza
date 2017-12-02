package pocasie;
import java.util.concurrent.ThreadLocalRandom;
import rocne.obdobie.Obdobie;

public class Pocasie {
	public int zrazky=0;
	public double svetlo=0;
	public int voda=0;
	public int teplota=0;
	
	public void pocasie_check(int hodina, Obdobie obdobie) {
		if (hodina == 1)
			teplota = ThreadLocalRandom.current().nextInt(0, obdobie.teplota_max-obdobie.teplota_min) + obdobie.teplota_min;
		if ((hodina >= obdobie.zapad) || (hodina <= obdobie.vychod))
			svetlo = 0;
		else svetlo = 1;
		double roll = ThreadLocalRandom.current().nextDouble(0, 1);
		if (zrazky>0) {
			zrazky--;
			svetlo = 0.5 * svetlo;
		}
		else {
			if(roll < obdobie.sanca_zrazok){
				zrazky = ThreadLocalRandom.current().nextInt(0, 10) + 1;
				voda = ThreadLocalRandom.current().nextInt(0, 6) + 1;
			}
			else if(roll < obdobie.sanca_zamrac)
				svetlo = 0.5 * svetlo;
			else {
				zrazky = 0;
				voda = 0;
			}
		}
			
	}
}