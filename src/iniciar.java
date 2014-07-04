import javax.microedition.lcdui.Display;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;

import Menu.Menu;
import Menu.jogo;


public class iniciar extends MIDlet {

	public iniciar() {

	}

	protected void destroyApp(boolean arg0) throws MIDletStateChangeException {

	}

	protected void pauseApp() {

	}

	protected void startApp() throws MIDletStateChangeException {
		Menu menu = new Menu(Display.getDisplay(this),this);		
		Display.getDisplay(this).setCurrent(menu);
		menu.setFullScreenMode(true);
		menu.start();
	}
}
