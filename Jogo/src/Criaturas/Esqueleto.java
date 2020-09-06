package Criaturas;
import Genericos.Criatura;
import Genericos.Item;
import Itens.EspadaMadeira;
import Itens.Pedra;

public class Esqueleto extends Criatura{
	
	
	/**
	 * Cria um esqueleto comum com ataque variando de 1 a 3
	 */
	public Esqueleto() {
		int numero = (int) (Math.random()*20) + 1;
		
		this.setId(1);
		this.setNome("Esqueleto");
		this.setAtaque((int) ((Math.random()*3) + 1) );
		this.setDefesa(1);
		this.setMaxVida(3);
		this.setVida(getMaxVida());
		this.setVelocidade((int) ((Math.random()*10) + 1) );
		setXp((int) ((Math.random()*5) + 1) );
		if(numero <= 4) 
		{
			this.setDrop(new Pedra());
		}
		else if(numero >= 19) 
		{
			this.setNome("Esqueleto Armadurado");
			this.setDefesa(5);
			this.setItemEquipado(new EspadaMadeira());
			this.setAtaque(this.getAtaque()+1+this.getItemEquipado().getDano());
			this.setDrop(this.getItemEquipado());
			this.setXp(this.getAtaque()*2);
		}
	}
	
	
	/**
	 * Cria um esqueleto com um item específico
	 * @param item
	 */
	public Esqueleto(Item item) {
		
		this.setId(1);
		this.setNome("Esqueleto");
		this.setAtaque((int) ((Math.random()*3) + 1) );
		this.setDefesa(1);
		this.setMaxVida(3);
		this.setVida(getMaxVida());
		this.setItemEquipado(item);
		this.setVelocidade(10);
		setXp((int) ((Math.random()*5) + 1) );
	}
	
	
	/**
	 * Cria um esqueleto com vida, ataque e defesa específicos
	 * @param vida
	 * @param ataque
	 * @param defesa
	 */
	public Esqueleto(int vida, int ataque, int defesa) {
		
		super(vida, ataque, defesa);
		
		this.setId(1);
		this.setNome("Esqueleto");
		this.setAtaque(ataque);
		this.setDefesa(defesa);
		this.setMaxVida(vida);
		this.setVida(getMaxVida());
		setXp((int) ((Math.random()*5) + 1) );
	}
	
	
	
	
}
