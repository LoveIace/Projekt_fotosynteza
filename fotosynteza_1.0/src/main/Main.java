package main;
import luka.*;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Oblast oblast;
		System.out.println("zadajte rozmery sledovanej oblasti: ");
		int x = sc.nextInt();
		int y = sc.nextInt();
		System.out.println("zadajte typ sledovanej oblasti: 1-Listnaty les		2-Ihlicnaty les		3-Luka");
		int z = sc.nextInt();
		if (z==3)
			oblast = new Oblast(x, y);
		else if(z==2){
			System.out.println("zadajte vek lesa: ");
			int vek = sc.nextInt();
			oblast = new Oblast(x, y, new Ihlicnan(), vek);
		}
		else if(z==1) {
			System.out.println("zadajte vek lesa: ");
			int vek = sc.nextInt();
			oblast = new Oblast(x, y, new Listnaty(), vek);
		} 
		else {
			oblast = new Oblast(x, y);
		}
		sc.close();
		Proces proces1 = new Proces(oblast);
		proces1.spusti_proces();		
	}
}