package luka;

import java.util.concurrent.ThreadLocalRandom;

public class Oblast {
	public Policko[][] oblast;
	private int x;
	private int y;

	public Oblast(int m, int n) {
		int i, j;
		this.x = m;
		this.y = n;
		this.oblast = new Policko[m][n];
		for (i=0; i<m; i++)
			for(j=0; j<n; j++) {
				this.oblast[i][j] = new Policko();
				double roll = ThreadLocalRandom.current().nextDouble(0, 1);
				if (roll < 0.1)
					this.oblast[i][j].setRastlina(new Listnaty());
				else 
					this.oblast[i][j].setRastlina(new Trava());
				}				
	}	
	public Oblast(int m, int n, Listnaty listnaty) {
		int i, j;
		this.x = m;
		this.y = n;
		this.oblast = new Policko[m][n];
		for (i=0; i<m; i++)
			for(j=0; j<n; j++) {
				this.oblast[i][j] = new Policko();
				this.oblast[i][j].setRastlina(new Listnaty());
				}				
	}
	public Oblast(int m, int n, Listnaty listnaty,int vek) {
		int i, j;
		this.x = m;
		this.y = n;
		this.oblast = new Policko[m][n];
		for (i=0; i<m; i++)
			for(j=0; j<n; j++) {
				this.oblast[i][j] = new Policko();
				this.oblast[i][j].setRastlina(new Listnaty(vek));
				}				
	}
	public Oblast(int m, int n, Ihlicnan ihlicnaty) {
		int i, j;
		this.x = m;
		this.y = n;
		this.oblast = new Policko[m][n];
		for (i=0; i<m; i++)
			for(j=0; j<n; j++) {
				this.oblast[i][j] = new Policko();
				this.oblast[i][j].setRastlina(new Ihlicnan());
				}				
	}
	public Oblast(int m, int n, Ihlicnan ihlicnaty, int vek) {
		int i, j;
		this.x = m;
		this.y = n;
		this.oblast = new Policko[m][n];
		for (i=0; i<m; i++)
			for(j=0; j<n; j++) {
				this.oblast[i][j] = new Policko();
				this.oblast[i][j].setRastlina(new Ihlicnan(vek));
				}				
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}
}
