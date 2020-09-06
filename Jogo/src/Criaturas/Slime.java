package Criaturas;


import Genericos.Criatura;
import Itens.PocaoCura;

public class Slime extends Criatura{

	public Slime() {
		this.setAtaque(1);
		this.setMaxVida(5);
		this.setVida(getMaxVida());
		this.setNome("Slime");
		this.setDefesa(0);
		this.setId(2);
		this.setVelocidade(1);
		setXp((int) ((Math.random()*3) + 1) );
		if((int) ((Math.random()*5 +1)) <= 3) 
		{
			this.setDrop(new PocaoCura());
		}
	}

}
