package Menu;

import java.io.IOException;

import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.Sprite;

public class Como extends Sprite {
	public Como(int x,int y) throws IOException{
		super(Image.createImage("/menucomojogar.png"),74,25);
		this.setPosition(x,y);
	}
}
