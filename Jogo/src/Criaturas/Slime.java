package Criaturas;

import Genericos.CriaturaHostil;
import Itens.PocaoCura;

public class Slime extends CriaturaHostil{

	public Slime() {
		this.setAtaque(1);
		this.setVida(5);
		this.setNome("Slime");
		this.setDefesa(0);
		this.setId(2);
		this.setVelocidade(1);
		setXp((int) ((Math.random()*3) + 1) );
		if((int) Math.random()*5 + 1 <= 2) 
		{
			this.setDrop(new PocaoCura());
		}
	}

}
