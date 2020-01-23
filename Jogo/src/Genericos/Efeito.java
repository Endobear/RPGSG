package Genericos;

public class Efeito {

	/**
	 * Efeito genérico usado como base para criar outros efeitos
	 */
	String nome, descricao; 
	/**
	 * turnos: quantos turnos vai durar. 
	 * Modificador: o quanto ele vai adicionar,tirar,dividir etc.
	 * Tipo: o que ele vai fazer, 0 = somar, 1 = subtrair
	 */
	int id,turnos, modificador, tipo;
	
	
	
	public Efeito() {
		this.setId(0);
		this.setNome("Nulo");
		this.setDescricao("Efeito genérico");
		this.setModificador(0);
		this.setTipo(0);
		this.setTurnos(0);
	}

	
	public Efeito(String nome, String descricao, int turnos, int modificador, int tipo) {
		this.setNome(nome);
		this.setDescricao(descricao);
		this.setModificador(modificador);
		this.setTipo(tipo);
		this.setTurnos(turnos);
	}
	
	public Efeito(String nome, String descricao, int modificador, int tipo) {
		this.setNome(nome);
		this.setDescricao(descricao);
		this.setModificador(modificador);
		this.setTipo(tipo);
	}
	
	public boolean temEfeito(Criatura criatura, Efeito efeito) 
	{
		boolean n = false;
		for (int i = 0; i < criatura.efeitos.length; i++) {
			if(criatura.efeitos[i].getId() == efeito.getId()) 
			{
				n = true;
				break;
			}
			
		}
		return n ;
	}

	
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getTurnos() {
		return turnos;
	}

	public void setTurnos(int turnos) {
		this.turnos = turnos;
	}

	public int getModificador() {
		return modificador;
	}

	public void setModificador(int modificador) {
		this.modificador = modificador;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

}
