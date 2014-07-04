package mostros;

import java.io.IOException;
import javax.microedition.lcdui.Image;

public class Leite  extends Montros {
	public Leite(int delay,int lv) throws IOException {
		super(Image.createImage("/mostros/caixaleiteanima.png"),30,35);
		this.defineReferencePixel(10,12);
		this.setDelay(delay);
		this.setFrameMonstro(0);
		this.setVida(10);
		this.setLevel(lv);
	}
}
