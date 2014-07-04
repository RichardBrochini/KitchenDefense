package Menu;

import java.io.IOException;

import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.GameCanvas;
import javax.microedition.midlet.MIDlet;

public class Desenvolvedores extends GameCanvas implements Runnable {

	private boolean executando;
	private Display display;
	private MIDlet midlet;
	
	public Desenvolvedores(Display display,MIDlet midlet){
		super(true);
		this.midlet = midlet;
		this.display=display;
	}

	private final void movimenta() {
		int keyStates = this.getKeyStates();
		if((keyStates & FIRE_PRESSED) !=0){
			Menu j = new Menu(this.display,this.midlet);
			j.setFullScreenMode(true);
			this.display.setCurrent(j);
			j.start();
			this.stop();
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
			try{
				g.drawImage(Image.createImage("/creditos.jpg"),0,0,0);
			}catch(IOException e1) {
				e1.printStackTrace();
			}
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.paint(g);
			this.flushGraphics();
		}		
	}
}
