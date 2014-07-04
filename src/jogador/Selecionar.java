package jogador;

import java.io.IOException;

import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.Sprite;

import defesa.Defesa;

public class Selecionar extends Sprite {
	private MiniCursor miniCursor;
		
	public Selecionar(MiniCursor miniCursor) throws IOException{
		super(Image.createImage("/menuinterno.jpg"),86,42);		
		this.miniCursor = miniCursor;
		this.setVisible(false);
	}
	
	public void aparecer(int x,int y){
		this.setPosition(x+5,y+5);
		this.miniCursor.setPosition(x+5,y+5);
		this.setVisible(true);
		this.miniCursor.setVisible(true);		
		this.miniCursor.item(0);
	}
	
	public int pegarOpcao(){
		return this.miniCursor.getMenu();
	}
	
	public void sumir(){
		this.setVisible(false);
		this.miniCursor.setVisible(false);		
		this.miniCursor.setNome("");
		this.miniCursor.setValor("");
		this.miniCursor.setMenu(0);
	}

	public void movimentar(int x,int y){
		this.move(x,y);					
		this.miniCursor.move(x,y);
	}

	public void movimentarMini(int pos){
		this.miniCursor.menu(pos);		
	}
}