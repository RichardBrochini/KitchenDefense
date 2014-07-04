package Menu;

import java.io.IOException;

import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.GameCanvas;
import javax.microedition.lcdui.game.LayerManager;
import javax.microedition.midlet.MIDlet;

public class Tutorial extends GameCanvas implements Runnable {

	private boolean executando;
	private Display display;
	private MIDlet midlet;
	private TelaTutorial telas;
	private LayerManager layerManager;

	public Tutorial(Display display,MIDlet midlet){
		super(true);
		this.midlet = midlet;
		this.display=display;
		this.layerManager = new LayerManager();
		try {
			this.telas= new TelaTutorial();
			this.layerManager.append(this.telas);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private final void movimenta() {
		int keyStates = this.getKeyStates();
		if((keyStates & FIRE_PRESSED) !=0){
			Menu j = new Menu(this.display,this.midlet);
			j.setFullScreenMode(true);
			this.display.setCurrent(j);
			j.start();
			this.stop();
		}else if((keyStates & RIGHT_PRESSED) !=0){
			this.telas.nextFrame();
		}else if((keyStates & LEFT_PRESSED) !=0){
			this.telas.prevFrame();
		}
	}
	
	public final void start() {
		this.executando = true;
		Thread t = new Thread(this);
		t.start();
	}

	public final void stop() {
		this.executando = false;
	}

	public void run(){
		Graphics g = this.getGraphics();
		while (this.executando){
			this.movimenta();
			g.setColor(0x000000);			
			g.fillRect(0,0,200,400);
			this.layerManager.paint(g,0,0);
			this.flushGraphics();
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}		
	}
}