package Genericos;

import javax.swing.JOptionPane;

public class Criatura {
//Toda criatura do jogo terá isso, seja ela hostil ou não
	String nome, descricao;
	Efeito[] efeitos = new Efeito[] { new Efeito(), new Efeito(), new Efeito(), new Efeito(), new Efeito(),
			new Efeito(), new Efeito(), new Efeito(), new Efeito(), new Efeito() };
	int id, vida, ataque, defesa, velocidade, xp, forcaTemp, defesaTemp, velocidadeTemp, maxVida, nivel, forca,
			resistencia;
	Item drop = new Item();
	Item itemEquipado = new Item();
	boolean vivo = true;

	public Criatura(String nome, int id, int vida, int ataque, int defesa, int velocidade) {
		this.setNome(nome);
		this.setId(id);
		this.setVida(vida);
		this.setAtaque(ataque);
		this.setDefesa(defesa);
		this.setVelocidade(velocidade);

	}

	public Criatura(int vida, int ataque, int defesa) {
		this.setVida(vida);
		this.setAtaque(ataque);
		this.setDefesa(defesa);

	}

	public Criatura() {

	}

	/**
	 * Ataca uma criatura
	 * 
	 * @param criatura criatura a ser atacada
	 */
	public void atacar(Criatura criatura) {
		int dano = (this.getAtaque() + this.getForcaTemp()) - criatura.getDefesa();
		if (dano <= 0) {
			if (criatura.getDefesa() < this.getAtaque() * 2) {
				if ((int) (Math.random() * 2) + 1 == 1) {
					criatura.setVida(criatura.getVida() - 1);
					JOptionPane.showMessageDialog(null, "Com muito esforço, " + this.getNome()
							+ " consegue dar 1 de dano em " + criatura.getNome());
				} else {
					JOptionPane.showMessageDialog(null, this.getNome() + " ataca " + criatura.getNome()
							+ ", mas seu esforço não é suficiente para causar dano");
				}
			} else {
				JOptionPane.showMessageDialog(null,
						this.getNome() + " ataca " + criatura.getNome() + ", mas não causa dano");
			}
		} else {
			criatura.setVida(criatura.getVida() - (dano));
			if (criatura.getVida() <= 0) {
				JOptionPane.showMessageDialog(null, this.getNome() + " derrotou " + criatura.getNome());

			} else {
				JOptionPane.showMessageDialog(null, this.getNome() + " ataca " + criatura.getNome() + " causando "
						+ dano + " de dano.\n" + criatura.getNome() + " fica com " + criatura.getVida() + " de vida");
			}

		}
	}

	/**
	 * Retorna as informações da criatura
	 * 
	 * @return informações da criatura
	 */
	public String informacoes() {
		String info = "Criatura: " + this.getNome() + "\nVida: " + this.getVida() + "\nItem: "
				+ this.getItemEquipado().getNome() + "\nAtaque: " + this.getAtaque() + "\nDefesa: " + this.getDefesa(),
				efeitosMon = "";

		for (int i = 0; i < getEfeitos().length; i++) {
			if (getEfeitos()[i].getId() != 0) {
				if (efeitosMon.equals("")) {
					efeitosMon = "Efeitos: ";
				}
				efeitosMon += getEfeitos()[i].getNome() + " ";
			}
		}
		info += efeitosMon;
		return info;

	}

	/**
	 * Aplica efeito em uma criatura
	 * 
	 * @param efeito
	 * @param criatura
	 */
	public void aplicarEfeito(Efeito efeito, Criatura criatura) {

		String mensagem = this.getNome() + " Tentou adicionar" + efeito.getNome() + " em " + criatura.getNome()
				+ " mas falhou";

		for (int i = 0; i < this.getEfeitos().length; i++) {
			if (criatura.efeitos[i].getId() == efeito.getId()) // se um efeito do jogador for igual ao que será aplicado
			{
				criatura.efeitos[i].setTurnosAtuais(criatura.efeitos[i].getTurnosMax());
				mensagem = criatura.efeitos[i].getNome() + " em " + criatura.getNome() + " foi aplicado novamente por "
						+ this.getNome();

				break;
			}

			else if (criatura.efeitos[i].getId() == 0) // se o id do efeito for 0 (Nulo)
			{
				criatura.efeitos[i] = efeito; // o "Nulo" é substituido pelo efeito
				criatura.efeitos[i].setCriaturaPossuida(criatura);// fala pro efeito qual criatura ele possui
				criatura.efeitos[i].setPosicao(i);

				mensagem = this.getNome() + " adicionou " + efeito.getNome() + " em " + criatura.getNome();
				break;

			}
		}

		JOptionPane.showMessageDialog(null, mensagem);

	}

	/**
	 * Verifica se uma criatura tem um efeito específico
	 * 
	 * @param efeito a ser verificado
	 * @return
	 */
	public int temEfeito(Efeito efeito) {
		int posicao = -1;

		for (int i = 0; i < this.efeitos.length; i++) {
			if (this.efeitos[i].getId() == efeito.getId()) {
				posicao = this.efeitos[i].getPosicao();
				break;
			}

		}
		return posicao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getVida() {
		return vida;
	}

	public void setVida(int vida) {
		this.vida = vida;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public int getDefesa() {
		return defesa;
	}

	public void setDefesa(int defesa) {
		this.defesa = defesa;
	}

	public int getVelocidade() {
		return velocidade;
	}

	public Item getDrop() {
		return drop;
	}

	public void setDrop(Item drop) {
		this.drop = drop;
	}

	public void setVelocidade(int velocidade) {
		this.velocidade = velocidade;
	}

	public boolean isVivo() {
		return vivo;
	}

	public void setVivo(boolean vivo) {
		this.vivo = vivo;
	}

	public int getXp() {
		return xp;
	}

	public void setXp(int xp) {
		this.xp = xp;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Item getItemEquipado() {
		return itemEquipado;
	}

	public void setItemEquipado(Item itemEquipado) {
		this.itemEquipado = itemEquipado;
		itemEquipado.espacoNoInventario = -1;
	}

	public int getForcaTemp() {
		return forcaTemp;
	}

	public void setForcaTemp(int forcaTemp) {
		this.forcaTemp = forcaTemp;
	}

	public int getDefesaTemp() {
		return defesaTemp;
	}

	public void setDefesaTemp(int defesaTemp) {
		this.defesaTemp = defesaTemp;
	}

	public int getVelocidadeTemp() {
		return velocidadeTemp;
	}

	public void setVelocidadeTemp(int velocidadeTemp) {
		this.velocidadeTemp = velocidadeTemp;
	}

	public int getMaxVida() {
		return maxVida;
	}

	public void setMaxVida(int maxVida) {
		this.maxVida = maxVida;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public int getForca() {
		return forca;
	}

	public void setForca(int forca) {
		this.forca = forca;
	}

	public int getResistencia() {
		return resistencia;
	}

	public void setResistencia(int resistencia) {
		this.resistencia = resistencia;
	}

	public Efeito[] getEfeitos() {
		return efeitos;
	}

	public void setEfeitos(Efeito[] efeitos) {
		this.efeitos = efeitos;
	}

}
