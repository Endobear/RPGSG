package Genericos;

import javax.swing.JOptionPane;

public class Efeito {

	/**
	 * Efeito genérico usado como base para criar outros efeitos
	 */
	String nome, descricao,mensagem; 
	/**
	 * turnos: quantos turnos vai durar. 
	 * Modificador: o quanto ele vai adicionar,tirar,dividir etc.
	 * Tipo: o que ele vai fazer: 0 = somar, 1 = subtrair
	 * local: onde o efeito vai ser aplicado: 0 = vida, 1 = ataque, 2 = defesa, 3 = velocidade
	 */
	public final int SOMAR = 0, SUBTRAIR = 1,VIDA = 0, ATAQUE = 1, DEFESA = 2, VELOCIDADE = 3;
	int id,turnosAtuais,turnosMax, modificador, tipo, local,posicao;
	Criatura criaturaPossuida;
	
	
	public Efeito() {
		this.setId(0);
		this.setNome("Nulo");
		this.setDescricao("Efeito genérico");
		this.setModificador(0);
		this.setTipo(0);
		this.setTurnosMax(1);
		this.setTurnosAtuais(getTurnosMax());
		this.setMensagem("não causou nada");
		
	}

	
	public Efeito(String nome, String descricao, int turnosMax, int modificador, int tipo) {
		this.setNome(nome);
		this.setDescricao(descricao);
		this.setModificador(modificador);
		this.setTipo(tipo);
		this.setTurnosMax(turnosMax);
		this.setTurnosAtuais(getTurnosMax());
	}
	
	public Efeito(String nome, String descricao, int modificador, int tipo) {
		this.setNome(nome);
		this.setDescricao(descricao);
		this.setModificador(modificador);
		this.setTipo(tipo);
	}
	
	
	
	/**
	 * Checa se não há nenhum efeito com turnos menores que 0
	 */
	public void checarEfeitos() 
	{
		for (int i = 0; i < getCriaturaPossuida().efeitos.length; i++) {
			if(getCriaturaPossuida().getEfeitos()[i].getId() != 0 && getCriaturaPossuida().efeitos[i].getTurnosAtuais() < 0) 
			{
				getCriaturaPossuida().getEfeitos()[i].dissiparEfeito();
			}
				
			}
	}
	/**
	 * Checa em qual posição o efeito está
	 * @return
	 */
	public int posicaoEfeitoo() 
	{
		int posicao = -1;
		for (int i = 0; i < getCriaturaPossuida().efeitos.length; i++) {
			if(getCriaturaPossuida().efeitos[i].getId() == getId()) 
			{
				posicao = i;
				break;
			}
			
		}
		return posicao ;
	}

	/**
	 * faz a ação do efeito na criatura
	 */
	public void causarEfeito() 
	{
		
		
		// o quanto vai ser retirado ou aplicado de uma certa característica
		int aplicar = this.getModificador();
		if(tipo == SUBTRAIR) 
		{
			aplicar = -this.getModificador();
		}
			
		//checa em qual local o efeito vai ser aplicado
		switch (getLocal()) {
		case 0:
			getCriaturaPossuida().setVida(getCriaturaPossuida().getVida() + aplicar); //tira ou coloca vida
			break;
			
		case 1:
			if(getCriaturaPossuida().getForcaTemp() + aplicar <= 0) //checa se o efeito vai deixar a força menor que zero
			{
				getCriaturaPossuida().setForcaTemp(0);
			}
			else {
			getCriaturaPossuida().setForcaTemp(getCriaturaPossuida().getForcaTemp() + aplicar); //aplica o efeito
			}
			break;
			
		case 2:
			if(getCriaturaPossuida().getDefesaTemp() + aplicar <= 0)  //checa se o efeito vai deixar a defesa menor que zero
			{
				getCriaturaPossuida().setDefesaTemp(0);
			}
			else {
			getCriaturaPossuida().setDefesaTemp(getCriaturaPossuida().getDefesaTemp() + aplicar); //aplica o efeito
			}
			break;
			
		case 3:
			//TODO Fazer sistema de aumentar e diminuir velocidade por efeitos
			break;
		default:
			break;
		}
		//mostra a mensagem do efeito
		JOptionPane.showMessageDialog(null, getMensagem());
		//checa se os turnos do efeito acabaram ou não para subtrair um turno do efeito
		if(getCriaturaPossuida().getEfeitos()[getPosicao()].getTurnosAtuais() - 1 < 0) 
		{
			getCriaturaPossuida().getEfeitos()[getPosicao()].dissiparEfeito();
		}
		else {getCriaturaPossuida().getEfeitos()[getPosicao()].setTurnosAtuais(getCriaturaPossuida().getEfeitos()[getPosicao()].getTurnosAtuais()-1);}
	}
	
	public void dissiparEfeito() 
	{
		//O Quanto vai ser retirado do efeito da criatura
		int retirar = -this.getModificador();
		if(tipo == 1) 
		{
			retirar = this.getModificador();
		}
		
		//checa se o efeito existe na criatura
		if(getPosicao() == -1) 
		{
			JOptionPane.showMessageDialog(null, "Erro, " + getNome() + " não encontrado em " + getCriaturaPossuida().nome);
		}
		else {
		
		// Checa qual característica vai ser removida o efeito
		switch (getLocal()) {
		//não tem efeito de vida pq os efeitos da vida não podem ser "retirados"

		case 1:
			if(getCriaturaPossuida().getForcaTemp() + retirar <= 0) //checa se retirar o efeito vai deixar a força menor que zero
			{
				getCriaturaPossuida().setForcaTemp(0);
			}
			else {
			getCriaturaPossuida().setForcaTemp(getCriaturaPossuida().getForcaTemp() + retirar);//retira o efeito
			}
			break;
			
		case 2:
			if(getCriaturaPossuida().getDefesaTemp() + retirar <= 0) //checa se retirar o efeito deixará a defesa menor que zero
			{
				getCriaturaPossuida().setDefesaTemp(0);
			}
			else {
			getCriaturaPossuida().setDefesaTemp(getCriaturaPossuida().getDefesaTemp() + retirar );//retira o efeito
			}
			break;
			
		default:
			break;
	}
		JOptionPane.showMessageDialog(null, getNome() + " foi retirado de " + getCriaturaPossuida());
		//deixa o slot do efeito vazio, ou seja, retira o efeito
		criaturaPossuida.getEfeitos()[getPosicao()].apagar();
		checarEfeitos();
	
		}
	}
	/**
	 * tranforma um efeito em um "Vazio"
	 */
	public void apagar() 
	{
		this.setId(0);
		this.setNome("Nulo");
		this.setDescricao("Efeito genérico");
		this.setModificador(0);
		this.setTipo(0);
		this.setTurnosMax(1);
		this.setTurnosAtuais(getTurnosMax());
		this.setMensagem("não causou nada");
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

	public int getTurnosAtuais() {
		return turnosAtuais;
	}

	public void setTurnosAtuais(int turnos) {
		this.turnosAtuais = turnos;
	}
	
	public int getTurnosMax() {
		return turnosMax;
	}

	public void setTurnosMax(int turnos) {
		this.turnosMax = turnos;
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


	public Criatura getCriaturaPossuida() {
		return criaturaPossuida;
	}


	public void setCriaturaPossuida(Criatura criaturaPossuida) {
		this.criaturaPossuida = criaturaPossuida;
	}

	/**
	 * local: onde o efeito vai ser aplicado: 1 = ataque, 2 = defesa, 3 = velocidade
	 */
	public int getLocal() {
		return local;
	}

	/**
	 * local: onde o efeito vai ser aplicado: 1 = ataque, 2 = defesa, 3 = velocidade
	 */
	public void setLocal(int local) {
		this.local = local;
	}


	public String getMensagem() {
		return mensagem;
	}


	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}


	public int getPosicao() {
		return posicao;
	}


	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}
	

}
