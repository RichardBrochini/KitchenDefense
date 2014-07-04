package Menu;

import java.io.IOException;
import java.io.InputStream;

import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.GameCanvas;
import javax.microedition.lcdui.game.LayerManager;
import javax.microedition.media.Manager;
import javax.microedition.media.MediaException;
import javax.microedition.media.Player;
import javax.microedition.midlet.MIDlet;

public class Menu extends GameCanvas implements Runnable {

	private Iniciar iniciar;
	private Sair    sair;
	private Credito credito;
	private Como    como;
	private boolean executando;
	private LayerManager layerManager;
	private int pos;
	private Display display;
	private MIDlet midlet;
	
	public Menu(Display display,MIDlet midlet){
		super(true);
		this.midlet = midlet;
		this.display=display;
		try {
			this.iniciar = new Iniciar(50,70);
			this.como    = new Como(50,100);
			this.credito = new Credito(50,130);
			this.sair    = new Sair(50,160);
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.pos=0;
		this.layerManager = new LayerManager();
		this.layerManager.append(this.iniciar);
		this.layerManager.append(this.como);
		this.layerManager.append(this.credito);
		this.layerManager.append(this.sair);		
	}

	private final void movimenta() {
		int keyStates = this.getKeyStates();
		if((keyStates & FIRE_PRESSED) !=0){
			if(this.pos==0){
				jogo j = new jogo(this.midlet);
				j.setFullScreenMode(true);
				this.display.setCurrent(j);
				j.start();
				this.stop();
			}else if(this.pos==1){
				Tutorial tuto = new Tutorial(this.display,this.midlet);
				tuto.setFullScreenMode(true);
				this.display.setCurrent(tuto);
				tuto.start();
				this.stop();
			}else if(this.pos==2){
				Desenvolvedores desenvolvedores = new Desenvolvedores(this.display,this.midlet);
				desenvolvedores.setFullScreenMode(true);
				this.display.setCurrent(desenvolvedores);
				desenvolvedores.start();
				this.stop();
			}else if(this.pos==3){
				this.midlet.notifyDestroyed();
			}
		} else if ((keyStates & this.UP_PRESSED) != 0) {
			if(this.pos>0){
				this.pos--;				
			}
			this.select();
		} else if ((keyStates & this.DOWN_PRESSED) != 0) {
			if(this.pos<3){
				this.pos++;				
			}
			this.select();
		}		
	}

	private void select(){
		if(this.pos==0){
			this.iniciar.setFrame(1);
			this.como.setFrame(0);
			this.credito.setFrame(0);
			this.sair.setFrame(0);
		}else if(this.pos==1){
			this.iniciar.setFrame(0);
			this.como.setFrame(1);
			this.credito.setFrame(0);
			this.sair.setFrame(0);			
		}else if(this.pos==2){
			this.iniciar.setFrame(0);
			this.como.setFrame(0);
			this.credito.setFrame(1);
			this.sair.setFrame(0);			
		}else if(this.pos==3){
			this.iniciar.setFrame(0);
			this.como.setFrame(0);
			this.credito.setFrame(0);
			this.sair.setFrame(1);			
		}
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
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
		this.select();
		while (this.executando){
			this.movimenta();			
			try{
				g.drawImage(Image.createImage("/fundomenu.jpg"),0,0,0);
			}catch(IOException e1) {
				e1.printStackTrace();
			}
			this.renderiza(g);
		}		
	}

	private final void renderiza(Graphics g) {
		this.layerManager.paint(g,0,0);
		flushGraphics();
	}
}