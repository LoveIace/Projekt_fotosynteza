package main;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import luka.*;
import rovnice.Fotosynteza;
import pocasie.Pocasie;
import rocne.obdobie.Rok;

public class Proces {
	private int hodina=0;
	private int den=1;
	private int mesiac=1;
	private int rok=2017;
	private double kyslik=0;
	private Oblast area;
	private Pocasie pocasie;
	private Rok obdobia;
	private ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
	void vypis() {
		System.out.println(obdobia.obdobie[(mesiac%12)/3].nazov);
    	System.out.println(hodina+":00, "+den+"."+mesiac+"."+rok+", "+pocasie.teplota+"°C \n");
    	if (pocasie.svetlo == 0) {
    		System.out.printf("Noc");
    		if (pocasie.zrazky>0 && pocasie.teplota>0)
    			System.out.println(", prší (intenzita "+pocasie.voda+")");
    		else if (pocasie.zrazky>0 && pocasie.teplota<=0)
    			System.out.println(", sneží (intenzita "+pocasie.voda+")");
    		else System.out.println(", jasno");
    	}
    	else {
    		System.out.printf("Deò");
    		if (pocasie.svetlo == 1)
    			System.out.printf(", jasno\n");
    		else {
    			System.out.printf(", zamraèené ");
    			if (pocasie.zrazky>0 && pocasie.teplota>0)
        			System.out.println(", prší (intenzita "+pocasie.voda+")");
        		else if (pocasie.zrazky>0 && pocasie.teplota<=0)
        			System.out.println(", sneží (intenzita "+pocasie.voda+")");
    		}
    	}
    	System.out.printf("Vyprodukovany kyslik: %.3f l \n\n\n", kyslik);
	}
	
	void nakresli() {
		int i, j;
    	for(i=0; i<area.getX(); i++) {
    		for(j=0; j<area.getY(); j++) {
    			if (area.oblast[i][j].getRastlina() instanceof Listnaty)
    				System.out.printf("L ");
    			else if (area.oblast[i][j].getRastlina() instanceof Ihlicnan)
    				System.out.printf("I ");
    			else if (area.oblast[i][j].getRastlina() instanceof Trava)
    				System.out.printf(". ");
    		}
    		System.out.printf("\n");	
    	}
	}
	
    final Runnable cas = new Runnable() {
    	int i, j;
        public void run() {
        	hodina++;
        	pocasie.pocasie_check(hodina, obdobia.obdobie[(mesiac%12)/3]);
        	for(i=0; i<area.getX(); i++) {
        		for(j=0; j<area.getY(); j++) {
        			kyslik+=Fotosynteza.getKyslik(area.oblast[i][j], pocasie);
        			if (hodina == 23)
        				area.oblast[i][j].getRastlina().starni();
        		}
        	}
        	if (hodina == 24)
        	{
        		hodina = 0;
        		den++;
        		if (den == 31) 
            	{
            		den = 1;
            		mesiac++;
            		if (mesiac == 13)
            		{
            			mesiac = 1;
            			rok++;
            		}
            	}
        	}  
        	vypis();
    		nakresli();
        }
    };
    Proces(Oblast area){
    	this.area = area;
    	this.pocasie = new Pocasie();
    	this.obdobia = new Rok();
    }
    void spusti_proces(){
    	scheduler.scheduleAtFixedRate(cas, 1000, 10, MILLISECONDS);
    }
}
