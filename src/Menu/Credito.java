package Menu;

import java.io.IOException;

import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.Sprite;

public class Credito extends Sprite {
	public Credito(int x,int y) throws IOException{
		super(Image.createImage("/menucredito.png"),74,25);
		this.setPosition(x,y);
	}
}