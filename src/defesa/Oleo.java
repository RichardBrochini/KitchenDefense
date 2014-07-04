package defesa;

import java.io.IOException;

import javax.microedition.lcdui.Image;

public class Oleo  extends Defesa {	
	public Oleo(int x,int y) throws IOException {
		super(Image.createImage("/oleo.png"),30,35,x,y);
		this.defineReferencePixel(10,12);
		this.setPreco(30);
		this.setDano(100);
		this.setDelay(20);
	}
}
