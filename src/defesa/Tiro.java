package defesa;
import java.io.IOException;

import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.Sprite;


public class Tiro  extends Sprite {
	private int pos;
	private int tx;
	private int ty;
	private int x;
	private int y;
	private int mx;
	private int my;
	private int VELOCIDADE = 7;
	private int dano;
	
	public Tiro(int x1,int y1,int x,int y,int dano) throws IOException{
		super(Image.createImage("/tiro1.png"),6,6);
		this.dano = dano;
		this.tx = x;
		this.ty = y;
		this.x = x1;
		this.y = y1;
	}
	
	public void calcularTragetoria(){
		if(this.x<this.tx && this.y<this.ty){
			this.setTransform(this.TRANS_ROT90);
			this.mx=VELOCIDADE;
			this.my=VELOCIDADE;
		}
		if(this.x>this.tx && this.y>this.ty){
			this.mx=-VELOCIDADE;
			this.my=-VELOCIDADE;			
		}
		if(this.x<this.tx && this.y>this.ty){
			this.mx=VELOCIDADE;
			this.my=-VELOCIDADE;						
		}
		if(this.x>this.tx && this.y<this.ty){
			this.mx=-VELOCIDADE;
			this.my=VELOCIDADE;									
		}
		if(this.x==this.tx && this.y<this.ty){
			this.mx=0;
			this.my=VELOCIDADE;
		}
		if(this.x==this.tx && this.y>this.ty){
			this.mx=0;
			this.my=-VELOCIDADE;			
		}
		if(this.x<this.tx && this.y==this.ty){
			this.mx=VELOCIDADE;
			this.my=0;						
		}
		if(this.x>this.tx && this.y==this.ty){
			this.mx=-VELOCIDADE;
			this.my=0;									
		}
	}
	
	public void andar(){
		this.move(this.mx,this.my);
	}
}