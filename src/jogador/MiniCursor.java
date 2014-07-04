package jogador;

import java.io.IOException;

import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.Sprite;

public class MiniCursor extends Sprite {
	private String nome;
	private String valor;
	private int    menu;
	private String[][] itens;
	public MiniCursor() throws IOException{
		super(Image.createImage("/selectinterno.png"),14,14);				
		this.itens = new String[4][2];
		this.itens[0][0]="Sal";
		this.itens[0][1]="10";              
		this.itens[1][0]="Palito";
		this.itens[1][1]="20";              
		this.itens[2][0]="Óleo";
		this.itens[2][1]="30";              
		this.itens[3][0]="Sair";
		this.itens[3][1]="";              
		this.menu = 0;
		this.setVisible(false);
		this.setNome("");
		this.setValor("");
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public void item(int pos){
		this.setNome(this.itens[pos][0]);
		this.setValor(this.itens[pos][1]);
	}
	public int getMenu(){
		return this.menu;
	}
	public void setMenu(int i){
		this.menu=i;
	}
	public void menu(int pos){
		if(this.menu>-1 && this.menu<4){
			this.menu=this.menu+pos;
			if(this.menu<0){
				this.menu=0;
				pos=2;
			}
			if(this.menu>3){
				this.menu=3;
				pos=2;
			}
			if(pos==-1){
				this.move(-23,0);
			}else if(pos==1){
				this.move(23,0);					
			}
			this.item(this.menu);
		}
	}
}