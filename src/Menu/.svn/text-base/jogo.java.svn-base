package Menu;
import java.io.IOException;
import java.util.Vector;

import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.GameCanvas;
import javax.microedition.lcdui.game.LayerManager;
import javax.microedition.media.Manager;
import javax.microedition.media.MediaException;
import javax.microedition.media.Player;
import javax.microedition.midlet.MIDlet;

import jogador.Atualizar;
import jogador.Cursor;
import jogador.MiniCursor;
import jogador.MiniCursorAtualizar;
import jogador.Selecionar;
import jogador.Status;

import defesa.Defesa;
import defesa.Mira;
import defesa.Oleo;
import defesa.Paliteiro;
import defesa.Saleiro;

import mostros.Banana;
import mostros.Caneca;
import mostros.Chaleira;
import mostros.Colher;
import mostros.Leite;
import mostros.Montros;
import mostros.Torradeira;
import mostros.Xicara;

public class jogo extends GameCanvas implements Runnable {
	private boolean executando;
	private LayerManager layerManager;
	private Vector montros;
	private Vector defesa;	
	private Status status;
	private Cursor cursor;
	private Selecionar selecionar;
	private Atualizar  atualizar;
	private MiniCursor miniCursor;
	private MiniCursorAtualizar miniCursorAtualizar;
	private int vida;
	private int din;
	private int level;
	private int tempo;
	private MIDlet midlet;
	private boolean perdeu;
	
	public jogo(MIDlet midlet){
		super(true);
		this.midlet = midlet;
		this.tempo  = 200;
		this.vida   = 10;
		this.level  = 0;
		this.din    = 20;
		this.perdeu = false;
		try{
			this.layerManager = new LayerManager();
			this.miniCursorAtualizar = new MiniCursorAtualizar();
			this.atualizar = new Atualizar(this.miniCursorAtualizar);
			this.defesa  = new Vector();
			this.montros = new Vector();
			this.miniCursor = new MiniCursor();
			this.selecionar = new Selecionar(this.miniCursor);
			this.cursor = new Cursor(this.selecionar,50,50,this.defesa,this.layerManager,this.atualizar);	
			this.status = new Status();
			this.cursor.setDin(this.din);
		}catch (IOException e){
			e.printStackTrace();
		}
		this.layerManager.append(this.status);
		this.layerManager.append(this.miniCursor);
		this.layerManager.append(this.miniCursorAtualizar);
		this.layerManager.append(this.selecionar);
		this.layerManager.append(this.atualizar);
		this.layerManager.append(this.cursor);
		this.layerManager.append(this.cursor.getMira());
	}

	public void limparMemoria(){
		Montros montros = null;
		Defesa defesa   = null;
		for(int i=0;i<this.montros.size();i++){
			montros = (Montros) this.montros.elementAt(i);
			if(montros.getX()<0){
				this.montros.removeElement(montros);
				montros = null;
			}
		}
		for(int i=0;i<this.defesa.size();i++){
			defesa = (Defesa) this.defesa.elementAt(i);
			defesa.limparTiros();
			if(defesa.getX()<0){
				this.defesa.removeElement(defesa);
				defesa = null;
			}
		}
	}
	
	public void chamarInimigos(){
		this.limparMemoria();
		try {
			int j = 0;
			if(this.level==1){
				for(int i=0;i<7;i++){
					if(i==0){
						j=1;
					}else{
						j=i*10;
					}
					this.montros.addElement(new Xicara(j,this.level));
				}
			}else if(this.level==2){
				for(int i=0;i<7;i++){
					if(i==0){
						j=1;
					}else{
						j=i*10;
					}
					this.montros.addElement(new Colher(j,this.level));						
				}
			}else if(this.level==3){
				for(int i=0;i<7;i++){
					if(i==0){
						j=1;
					}else{
						j=i*10;
					}
					this.montros.addElement(new Chaleira(j,this.level));
				}
			}else if(this.level==4){
				for(int i=0;i<7;i++){
					if(i==0){
						j=1;
					}else{
						j=i*10;
					}
					this.montros.addElement(new Caneca(j,this.level));
				}
			}else if(this.level==5){
				for(int i=0;i<7;i++){
					if(i==0){
						j=1;
					}else{
						j=i*10;
					}
					this.montros.addElement(new Torradeira(j,this.level));
				}
			}else if(this.level==6){
				for(int i=0;i<7;i++){
					if(i==0){
						j=1;
					}else{
						j=i*10;
					}
					this.montros.addElement(new Leite(j,this.level));
				}
			}else if(this.level==7){
				for(int i=0;i<7;i++){
					if(i==0){
						j=1;
					}else{
						j=i*10;
					}					
					this.montros.addElement(new Banana(j,this.level));
				}				
			}else{
				this.montros.addElement(new Banana(1,this.level));
				this.montros.addElement(new Xicara(20,this.level));
				this.montros.addElement(new Torradeira(30,this.level));
				this.montros.addElement(new Leite(40,this.level));
				this.montros.addElement(new Caneca(50,this.level));
				this.montros.addElement(new Chaleira(60,this.level));
				this.montros.addElement(new Colher(70,this.level));						
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		for(int i=0;i<this.montros.size();i++){
			this.layerManager.append((Montros) this.montros.elementAt(i));					
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
		Graphics g     = this.getGraphics();
		int turno      = 0;
		int segundos   = 20;
		int contaTempo = 0;
		while (this.executando){
			if(!this.perdeu){				
				this.cursor.Andar(this);
				for(int i=0;i<this.montros.size();i++){
					Montros montro = (Montros) this.montros.elementAt(i);
					montro.andar();
					if(montro.getY()>180){
						this.vida--;
						montro.morrer();
						montro.setVisible(false);
						montro.setPosition(-50,-50);
						Display.getDisplay(this.midlet).vibrate(1000);
						if(this.vida==0){
							this.perdeu=true;
							Display.getDisplay(this.midlet).vibrate(5000);
						}
					}
					if(montro.getVivo()){
						for(int j=0;j<this.defesa.size();j++){
							Defesa defesa = (Defesa) this.defesa.elementAt(j);				
							if(defesa.collidesWith(montro,true)){
								montro.setParar(true);
							}
							defesa.tiro(montro.getX(),montro.getY());
							defesa.acertou(montro);
						}	
					}				
				}			
				this.din = this.cursor.getDin();
				for(int j=0;j<this.defesa.size();j++){
					Defesa defesa = (Defesa) this.defesa.elementAt(j);				
					defesa.atirar(this.layerManager);
					defesa.tragetoriaTiro();
					this.din = this.din+(3*(defesa.pegarMortes()));
				}
				this.cursor.setDin(this.din);
			}
			g.setColor(0x00ff00);
			try{
				g.drawImage(Image.createImage("/fundojogo.jpg"),0,16,0);
			}catch(IOException e1) {
				e1.printStackTrace();
			}
			this.layerManager.paint(g,0,0);
			g.setColor(0xffffff);
			if(!this.perdeu){
				contaTempo++;
				if(contaTempo==10){
					segundos--;				
					contaTempo=0;
				}				
			}
			g.setFont(Font.getFont(Font.FACE_SYSTEM,Font.STYLE_PLAIN, Font.SIZE_MEDIUM));
			g.drawString(this.miniCursor.getNome(),this.cursor.getX()+10,this.cursor.getY()+30, g.LEFT | g.TOP);
			g.drawString(this.miniCursor.getValor(),this.cursor.getX()+72,this.cursor.getY()+30, g.LEFT | g.TOP);
			g.drawString(this.miniCursorAtualizar.getNome(),this.cursor.getX()+10,this.cursor.getY()+30, g.LEFT | g.TOP);
			g.drawString(this.miniCursorAtualizar.getValor(),this.cursor.getX()+72,this.cursor.getY()+30, g.LEFT | g.TOP);
			g.drawString(String.valueOf(segundos),75,0,g.LEFT | g.TOP);			
			g.drawString(String.valueOf(this.level),25,2,g.LEFT | g.TOP);			
			g.drawString(String.valueOf(this.vida),95,5,g.LEFT | g.TOP);			
			g.drawString(String.valueOf(this.din),130,2,g.LEFT | g.TOP);			
			if(!this.perdeu){
				if(this.tempo<1){
					this.tempo=200;
					segundos=20;				
					contaTempo=0;
					this.level++;
					this.chamarInimigos();
				}
				this.tempo--;				
			}
			this.repaint();
			this.flushGraphics();
			try{
				Thread.sleep(100);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
			if(!this.perdeu){
				turno++;
			}
		}		
	}
}