package jogador;

import java.io.IOException;

import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.Sprite;

import defesa.Defesa;

public class Atualizar extends Sprite {
	private MiniCursorAtualizar miniCursor;
	private Defesa defesa;
	
	public Atualizar(MiniCursorAtualizar miniCursor) throws IOException{
		super(Image.createImage("/menuinternomodific.jpg"),88,42);
		this.setVisible(false);
		this.miniCursor = miniCursor;
		this.setVisible(false);
	}

	public void setDefesa(Defesa defesa){
		this.defesa=defesa;
	}

	public Defesa getDefesa(){
		return this.defesa;
	}
	
	public void aparecer(int x,int y){		
		this.miniCursor.setDefesa(this.defesa);
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