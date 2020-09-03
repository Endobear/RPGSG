package Criaturas;

import Efeitos.Queimando;
import Genericos.Criatura;
import Genericos.CriaturaHostil;
import Genericos.Item;
import Itens.PocaoCura;

public class SlimeFogo extends CriaturaHostil {

	public SlimeFogo() {
		this.setAtaque(4);
		this.setVida(8);
		this.setNome("Slime de Fogo");
		this.setDefesa(2);
		this.setId(3);
		this.setVelocidade(1);
		setXp((int) ((Math.random()*6) + 1) );
		if((int) (Math.random()*5) + 1 <= 4) 
		{
			this.setDrop(new PocaoCura());
		}
	}
	
	@Override
	public void atacar(Criatura criatura) {
		if((int) (Math.random()*5) + 1 <= 1) 
		{
			aplicarEfeito(new Queimando(3,criatura), criatura);
		}
		super.atacar(criatura);
	}


}
