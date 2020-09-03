package Efeitos;

import Genericos.Criatura;
import Genericos.Efeito;

public class Queimando extends Efeito{

	public Queimando(int turnos, Criatura criatura) {
		this.setCriaturaPossuida(criatura);
		this.setNome("Queimando!");
		this.setModificador(2);
		this.setDescricao("A criatura com esse efeito levará " + this.getModificador() + " de dano em cada turno");
		this.setTipo(1);
		this.setLocal(0);
		this.setTurnosMax(turnos);
		this.setId(1);
		this.setMensagem(getCriaturaPossuida().getNome() + " levou " + this.getModificador() + " de dano por Queimadura!");
	}
	public Queimando(Criatura criatura) {
		this.setCriaturaPossuida(criatura);
		this.setNome("Queimando!");
		this.setModificador(2);
		this.setDescricao("A criatura com esse efeito levará " + this.getModificador() + " de dano em cada turno");
		this.setTipo(1);
		this.setLocal(0);
		this.setTurnosMax(1);
		this.setId(1);
		this.setMensagem(getCriaturaPossuida().getNome() + " levou " + this.getModificador() + " de dano por Queimadura!");
	}
	
	public void aumentarDano(int DanoAdicional) 
	{
		this.setModificador(this.getModificador() + DanoAdicional);
	}
}
