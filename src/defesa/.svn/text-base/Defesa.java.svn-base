package defesa;

import java.io.IOException;
import java.util.Vector;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.LayerManager;
import javax.microedition.lcdui.game.Sprite;

import mostros.Montros;

public class Defesa  extends Sprite {
	private int r;
	private Vector tiro;
	private int tempo;
	private int totalTiros;
	private int alvos[][];
	private int dano;
	private int delay;
	private int tiros;
	private int mortes;
	private int preco;
	
	public Defesa(Image img,int a,int b,int x,int y) throws IOException {
		super(img,a,b);
		this.setPreco(5);
		this.mortes = 0;
		this.setDano(10);
		this.delay = 4;
		this.alvos = new int[20][2];
		this.totalTiros = -1;
		this.tempo = 0;
		this.tiro  = new Vector();
		this.r     = 80;
		this.setPosition(x,y);
		this.defineReferencePixel(10,12);
	}

	public boolean tiro(int x,int y){
		if(this.tempo==0){
			int a = x-this.getRefPixelX();
			int b = y-this.getRefPixelY();
			int c = (a*a)+(b*b);
			if(c<=(this.r*this.r)){
				this.totalTiros++;
				this.alvos[this.totalTiros][0]=x;
				this.alvos[this.totalTiros][1]=y;
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}

	public void tragetoriaTiro(){
		Tiro tiro = null;
		for(int i=0;i<this.tiro.size();i++){
			tiro = (Tiro) this.tiro.elementAt(i);
			tiro.andar();
		}
	}
	
	public void acertou(Montros obj){
		Tiro tiro = null;
		for(int i=0;i<this.tiro.size();i++){
			tiro = (Tiro) this.tiro.elementAt(i);
			if(tiro.collidesWith(obj,true)){
				obj.setVida(obj.getVida()-this.dano);
				if(obj.getVida()<1){
					obj.morrer();				
					this.mortes++;
				}
				tiro.setVisible(false);
				tiro.setPosition(-50,-50);
				this.tiro.removeElement(tiro);
				tiro=null;
			}
		}		
	}
	
	public void limparTiros(){
		Tiro tiro = null;
		for(int i=0;i<this.tiro.size();i++){
			tiro = (Tiro) this.tiro.elementAt(i);
			tiro.setVisible(false);
			tiro.setPosition(-50,-50);
			this.tiro.removeElement(tiro);
			tiro=null;
		}
	}
	
	public int pegarMortes(){
		int m = this.mortes;
		this.mortes=0;
		return m;
	}
	
	public void atirar(LayerManager layer){
		int tiros=1;
		if(this.tempo==0){
			this.tempo=this.delay;
			while(tiros!=0 && this.totalTiros>-1){
				try {
					Tiro tiro = new Tiro(this.getX(),this.getY(),this.alvos[this.totalTiros][0],this.alvos[this.totalTiros][1],this.dano);
					tiro.setPosition(this.getRefPixelX(),this.getRefPixelY());
					tiro.calcularTragetoria();
					this.tiro.addElement(tiro);
					layer.append(tiro);
					this.totalTiros--;
				} catch (IOException e) {
					e.printStackTrace();
				}				
				tiros--;
			}
			this.alvos = new int[20][2];
			this.totalTiros = -1;
		}else{
			this.tempo--;
		}
	}

	public int getPreco() {
		return preco;
	}

	public void setPreco(int preco) {
		this.preco = preco;
	}

	public int getDano() {
		return this.dano;
	}

	public void setDano(int dano) {
		this.dano = dano;
	}

	public int getDelay() {
		return delay;
	}

	public void setDelay(int delay) {
		this.delay = delay;
	}
}