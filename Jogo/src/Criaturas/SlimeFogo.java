package Criaturas;

import Efeitos.Queimando;
import Genericos.Criatura;
import Itens.CuraQueimando;

public class SlimeFogo extends Criatura {

	public SlimeFogo() {
		this.setAtaque(4);
		this.setVida(8);
		this.setNome("Slime de Fogo");
		this.setDefesa(2);
		this.setId(3);
		this.setVelocidade(1);
		setXp((int) ((Math.random() * 6) + 1));
		if ((int) ((Math.random() * 5 + 1)) <= 2) {
			this.setDrop(new CuraQueimando());
		}
	}

	@Override
	public void atacar(Criatura criatura) {
		super.atacar(criatura);
		if (criatura.getVida() >= 0) {
			if ((int) ((Math.random() * 5 + 1)) <= 2) {
				aplicarEfeito(new Queimando(3, criatura), criatura);
			}
		}
	}

}
