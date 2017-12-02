package rovnice;
import luka.Listnaty;
import luka.Policko;
import pocasie.Pocasie;

public class Fotosynteza {
	public static double getKyslik(Policko x, Pocasie pocasie){
		if (pocasie.teplota<7)
			if(x.getRastlina() instanceof Listnaty)
				x.getRastlina().strat_listy();
		if(pocasie.voda>0)
			x.voda+= pocasie.voda;
		if(pocasie.svetlo>0){
			if (x.voda>0)
			{
				x.getRastlina().pi(x);
				x.vyz_latky++;
				x.getRastlina().rast_listy();
				return (x.getRastlina().getListy()*x.getRastlina().getPlocha_listu()*pocasie.svetlo*(0.5+pocasie.teplota*(0.5/25))*0.00025);
			}
			else {
				x.getRastlina().damage(x);
				x.getRastlina().strat_listy();
				return 0;
			}
		}
		else {
			if(x.vyz_latky>0)
				x.vyz_latky--;
			else 
				x.getRastlina().strat_listy();
			return 0;
		}
	}
}
