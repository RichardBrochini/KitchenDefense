package jogador;

import java.io.IOException;
import java.util.Vector;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.GameCanvas;
import javax.microedition.lcdui.game.LayerManager;
import javax.microedition.lcdui.game.Sprite;
import defesa.*;

public class Cursor extends Sprite {
	private Selecionar selecionar;
	private Atualizar  atualizar;
	private int MOVIMENTO = 10;
	private boolean trava;
	private boolean selecionado;
	private Vector defesa;	
	private LayerManager layerManager;
	private Mira mira;
	private int din;
	
	public Cursor(Selecionar selecionar,int x,int y,Vector defesa,LayerManager layerManager,Atualizar atualizar) throws IOException{
		super(Image.createImage("/select.png"),30,33);		
		this.defesa = defesa;
		this.selecionado = false;
		this.trava = false;
		this.layerManager = layerManager;
		this.selecionar = selecionar;
		this.setPosition(x,y);
		this.mira = new Mira(0,0);
		this.mira.setVisible(false);
		this.atualizar = atualizar;
	}

	public Mira getMira(){
		return this.mira;
	}
	
	public void Andar(GameCanvas game){
		int keyStates = game.getKeyStates();
		if(this.getX()>40 && this.getX()<110){
			if(this.getX()>70){
				this.setPosition(40,this.getY());				
			}else if(this.getX()<70){
				this.setPosition(110,this.getY());
			}
		}
		if(this.trava){
				if((keyStates & game.FIRE_PRESSED) != 0){			
					if(this.selecionado){
						if(this.atualizar.pegarOpcao()==0){
						}else if(this.atualizar.pegarOpcao()==1){
							this.atualizar.getDefesa().setVisible(false);
							this.atualizar.getDefesa().setPosition(-50,-50);
							this.setDin(this.getDin()+(this.atualizar.getDefesa().getPreco()/2));
						}else if(this.atualizar.pegarOpcao()==2){
						}
						this.mira.setVisible(false);
						this.mira.setPosition(0,0);
						this.trava = false;
						this.nextFrame();
						this.selecionado=false;
						this.atualizar.sumir();
						this.atualizar.setVisible(false);																

					}else{
						try {
							if(this.selecionar.pegarOpcao()==0){
								Saleiro sal = new Saleiro(this.getX(),this.getY());
								if(this.getDin()>=sal.getPreco()){
									this.defesa.addElement(sal);												
									this.layerManager.append(sal);
									this.setDin(this.getDin()-sal.getPreco());
								}
							}else if(this.selecionar.pegarOpcao()==1){
								Paliteiro pal = new Paliteiro(this.getX(),this.getY());
								if(this.getDin()>=pal.getPreco()){
									this.defesa.addElement(pal);						
									this.layerManager.append(pal);
									this.setDin(this.getDin()-pal.getPreco());
								}
							}else if(this.selecionar.pegarOpcao()==2){
								Oleo oleo = new Oleo(this.getX(),this.getY());
								if(this.getDin()>=oleo.getPreco()){
									this.defesa.addElement(oleo);
									this.layerManager.append(oleo);				
									this.setDin(this.getDin()-oleo.getPreco());
								}
							}
						} catch (IOException e) {
							e.printStackTrace();
						}
						this.mira.setVisible(false);
						this.mira.setPosition(0,0);
						this.trava = false;
						this.selecionar.sumir();
						this.nextFrame();
						this.selecionar.setVisible(false);																
					}
				}else if ((keyStates & game.LEFT_PRESSED) != 0) {
					if(this.selecionado){
						this.atualizar.movimentarMini(-1);												
					}else{
						this.selecionar.movimentarMini(-1);						
					}
				} else if ((keyStates & game.RIGHT_PRESSED) != 0) {
					if(this.selecionado){
						this.atualizar.movimentarMini(+1);																		
					}else{
						this.selecionar.movimentarMini(+1);
					}
				}		
		}else{
			if((keyStates & game.FIRE_PRESSED) != 0){
				int r = 20;
				boolean vizinho = false;
				boolean selecionar = false;
				for(int i=0;i<this.defesa.size();i++){					
					Defesa defesa = (Defesa) this.defesa.elementAt(i);
					int a = defesa.getX()-this.getRefPixelX();
					int b = defesa.getY()-this.getRefPixelY();
					int c = (a*a)+(b*b);
					if(c<=(r*r)){
						vizinho = true;
						if(this.getX()==defesa.getX() && this.getY()==defesa.getY()){
							selecionar=true;
							this.atualizar.setDefesa(defesa);
						}
						break;
					}					
				}
				if(!this.trava && !vizinho){
					this.mira.setPosition(this.getX()-15,this.getY()-15);
					this.mira.setVisible(true);
					this.selecionar.aparecer(this.getX()+5,this.getY()+5);
					this.trava=true;
					this.nextFrame();
					this.selecionar.setVisible(true);				
				}else if(selecionar){
					this.mira.setPosition(this.getX()-15,this.getY()-15);
					this.mira.setVisible(true);
					this.atualizar.aparecer(this.getX()+5,this.getY()+5);
					this.trava=true;
					this.selecionado=true;
					this.nextFrame();
				}
			}else if ((keyStates & game.LEFT_PRESSED) != 0) {
				this.move(-MOVIMENTO,0);
				this.selecionar.movimentar(-MOVIMENTO,0);
			} else if ((keyStates & game.RIGHT_PRESSED) != 0) {
				this.move(MOVIMENTO,0);
				this.selecionar.movimentar(MOVIMENTO,0);
			} else if ((keyStates & game.UP_PRESSED) != 0) {
				this.move(0,-MOVIMENTO);
				this.selecionar.movimentar(0,-MOVIMENTO);			
			} else if ((keyStates & game.DOWN_PRESSED) != 0) {
				this.move(0,MOVIMENTO);
				this.selecionar.movimentar(0,MOVIMENTO);			
			}			
		}
	}

	public int getDin() {
		return din;
	}

	public void setDin(int din) {
		this.din = din;
	}
}