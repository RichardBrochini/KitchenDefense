package Menu;

import java.io.IOException;

import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.Sprite;

public class Iniciar extends Sprite {
	public Iniciar(int x,int y) throws IOException{
		super(Image.createImage("/menuiniciar.png"),74,25);
		this.setPosition(x,y);
	}
}