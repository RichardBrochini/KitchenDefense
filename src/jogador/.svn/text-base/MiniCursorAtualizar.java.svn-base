package jogador;

import java.io.IOException;

import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.Sprite;

import defesa.Defesa;

public class MiniCursorAtualizar extends Sprite {
	private String nome;
	private String valor;
	private int    menu;
	private String[][] itens;	
	private Defesa defesa;

	public MiniCursorAtualizar() throws IOException{
		super(Image.createImage("/selectinterno.png"),14,14);				
		this.itens = new String[3][2];
		this.itens[0][0]="Dano";
		this.itens[0][1]="";              
		this.itens[1][0]="Vender";
		this.itens[1][1]="";              
		this.itens[2][0]="Sair";
		this.itens[2][1]="";              
		this.menu = 0;
		this.setVisible(false);
		this.setNome("");
		this.setValor("");
	}

	public void setDefesa(Defesa defesa){
		this.defesa=defesa;
		this.itens[0][1]=String.valueOf(this.defesa.getDano());              
		this.itens[1][1]=String.valueOf(this.defesa.getPreco()/2);              
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
		if(this.menu>-1 && this.menu<3){
			this.menu=this.menu+pos;
			if(this.menu<0){
				this.menu=0;
				pos=2;
			}
			if(this.menu>2){
				this.menu=2;
				pos=2;
			}
			if(pos==-1){
				this.move(-38,0);
			}else if(pos==1){
				this.move(38,0);					
			}
			this.item(this.menu);
		}
	}
}