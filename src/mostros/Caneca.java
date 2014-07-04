package mostros;

import java.io.IOException;

import javax.microedition.lcdui.Image;

public class Caneca extends Montros {
	public Caneca(int delay,int lv) throws IOException {
		super(Image.createImage("/mostros/canecaanima.png"),30,35);
		this.defineReferencePixel(10,12);
		this.setDelay(delay);
		this.setFrameMonstro(0);
		this.setVida(30);
		this.setLevel(lv);		
	}
}
