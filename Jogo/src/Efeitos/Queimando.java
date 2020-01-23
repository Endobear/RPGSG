package Efeitos;

import Genericos.Efeito;

public class Queimando extends Efeito{

	public Queimando(int turnos) {
		this.setNome("Queimando!");
		this.setModificador(2);
		this.setDescricao("A criatura com esse debuff levará " + this.getModificador() + "de dano em cada turno");
		this.setTipo(1);
	}
	public void aumentarDano(int DanoAdicional) 
	{
		this.setModificador(this.getModificador() + DanoAdicional);
	}
}
