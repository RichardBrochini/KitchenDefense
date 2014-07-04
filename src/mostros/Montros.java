package mostros;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.Sprite;


public class Montros extends Sprite {
	private int delay;
	private int frame;
	private int vida;
	private boolean vivo;
	private boolean parado;
	private int level;
	
	public Montros(Image img,int a,int b){
		super(img,a,b);
		this.setPosition(75,-40);
		this.vivo=true;
		this.setParar(false);
	}

	public boolean getVivo(){
		return this.vivo;
	}
	
	public int getDelay() {
		return delay;
	}

	public void setDelay(int delay) {
		this.delay = delay;
	}

	public void setFrameMonstro(int frame) {
		this.frame = frame;
	}

	public int getVida(){
		return this.vida;
	}
	
	public void setVida(int vida){
		this.vida=vida;
	}
	
	public void morrer(){
		this.setFrame(3);							
		this.vivo = false; 
		this.delay=10;
	}
	public void setParar(boolean status){
		this.parado=status;
	}
	
	public void andar(){
		if(!this.parado){
			if(this.vivo){
				if(this.frame==3){
					this.frame=0;
				}
				this.setFrame(this.frame);
				this.frame++;
				if(this.delay==0){
					this.setTransform(this.TRANS_NONE);
					this.move(0,3);							
				}else{
					this.delay--;
				}			
			}else{
				if(this.delay==0){
					this.setVisible(false);
					this.setPosition(-50,-50);
				}
				this.delay--;
			}	
		}else{
			if(!this.vivo){
				if(this.delay==0){
					this.setVisible(false);
					this.setPosition(-50,-50);
				}
				this.delay--;				
			}			
		}
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
		this.vida=this.vida*this.level;
	}
}