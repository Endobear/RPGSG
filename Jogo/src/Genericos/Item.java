package Genericos;

import Criaturas.Jogador;

public class Item {
	boolean equipavel,usavel,atiravel;
	int dano, defesa, usos, id,espacoNoInventario;
	String nome,descricao;
	
	
	public Item(int id, String nome,String descricao, boolean equipavel, int dano, int defesa, int usos) 
	{
		this.setId(id);
		this.setDano(dano);
		this.setDefesa(defesa);
		this.setDescricao(descricao);
		this.setEquipavel(equipavel);
		this.setNome(nome);
		this.setUsos(usos);
		
	}
	public Item() {this.setId(0);this.setNome("Vazio");this.setDescricao("O nada em forma de código");}
	
	public String informacoes() 
	{
		return  "Item: " + this.getNome() 
				+ "\nDescrição: " + this.getDescricao()
				+ "\nId: " + this.getId()
				+ "\nAtaque: " + this.getDano();
	}
	
	public void Usar(Jogador jogador) {}
	public void Usar(Criatura criatura) {}
	public boolean isUsavel() {
		return usavel;
	}
	public void setUsavel(boolean usavel) {
		this.usavel = usavel;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public boolean isEquipavel() {
		return equipavel;
	}
	public void setEquipavel(boolean equipavel) {
		this.equipavel = equipavel;
	}
	public int getDano() {
		return dano;
	}
	public void setDano(int dano) {
		this.dano = dano;
	}
	public int getDefesa() {
		return defesa;
	}
	public void setDefesa(int defesa) {
		this.defesa = defesa;
	}
	public int getUsos() {
		return usos;
	}
	public void setUsos(int usos) {
		this.usos = usos;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public boolean isAtiravel() {
		return atiravel;
	}
	public void setAtiravel(boolean atiravel) {
		this.atiravel = atiravel;
	}
	public int getEspacoNoInventario() {
		return espacoNoInventario;
	}
	public void setEspacoNoInventario(int espacoNoInventario) {
		this.espacoNoInventario = espacoNoInventario;
	}
	
}
