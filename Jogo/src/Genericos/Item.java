package Genericos;

public class Item {
	boolean equipavel,usavel,atiravel,estacavel;
	int dano, defesa, usos, id,espacoNoInventario, quantidade,quantidadeMax;
	String nome,descricao,funcao;
	
	public Item() {this.setId(0);this.setNome("Vazio");this.setDescricao("O nada em forma de código");}
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
	
	public String informacoes() 
	{
		String info = "Item: " + this.getNome() 
							+"\nDescrição: " + this.getDescricao();
		if(this.getId() != 0) 
		{
			info += "\nId: " + this.getId();
		}
		if(this.isUsavel() == true) 
		{
			info += "\nUsável";
		}
		if(this.isAtiravel() == true) 
		{
			info += "\nAtiravel";
		}
		if(this.equipavel == true) 
		{
			info += "\nEquipável";
		}
		if(this.isEstacavel()) 
		{
			info += "\nEstacavel(" +this.getQuantidade() +" no inventário)";
		}
		if(this.getDano() > 0) 
		{
			info += "\nDano: " + this.getDano();
		}
		if(this.getDefesa() > 0) 
		{
			info += "\nDefesa: " + this.getDefesa();
		}
		
		
		return  info;
	}
	
	public void usar(Criatura criatura) {}
	
	/**
	 * Gasta um item, se ele é um item estacavel, ele verifica se já acabou todos os itens antes de ser retirado do inventário
	 */
	public void gastar() 
	{
		this.setUsos(this.getUsos() - 1);
		if(this.getUsos()<= 0)
		{
			if(this.isEstacavel()) 
			{
				this.setQuantidade(this.getQuantidade() - 1);
				if(this.getQuantidade() <=0) 
				{
					this.apagar();
				}
			}
			
			else 
			{
				this.apagar();
			}
		}
	}
	
	/**
	 * Transforma o item em um "Vazio"
	 */
	public void apagar() 
	{
		this.setId(0);
		this.setNome("Vazio");
		this.setDescricao("O nada em forma de código");
		this.setAtiravel(false);
		this.setUsavel(false);
		this.setDano(0);
		this.setDefesa(0);
		this.setEquipavel(false);
		this.setEstacavel(false);
		
	}
	
	//getters e setters 
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
	public boolean isEstacavel() {
		return estacavel;
	}
	public void setEstacavel(boolean estacavel) {
		this.estacavel = estacavel;
	}
	public String getFuncao() {
		return funcao;
	}
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public int getQuantidadeMax() {
		return quantidadeMax;
	}
	public void setQuantidadeMax(int quantidadeMax) {
		this.quantidadeMax = quantidadeMax;
	}
	
	
}
