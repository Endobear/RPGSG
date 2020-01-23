package Genericos;


public class CriaturaHostil extends Criatura{
	
	public CriaturaHostil(String nome, int id, int vida, int ataque, int defesa, Item itemEquipado,int velocidade) {
		super(nome, id, vida, ataque, defesa, velocidade);
		this.setNome(nome);
		this.setId(id);
		this.setVida(vida);
		this.setAtaque(ataque);
		this.setDefesa(defesa);
		this.setItemEquipado(itemEquipado);
		this.setXp(0);
	}
	public CriaturaHostil(String nome, int id, int vida, int ataque, int defesa,int velocidade) {
		super(nome, id, vida, ataque, defesa, velocidade);
		this.setNome(nome);
		this.setId(id);
		this.setVida(vida);
		this.setAtaque(ataque);
		this.setDefesa(defesa);
		this.setXp(0);
	}
	public CriaturaHostil( int vida, int ataque, int defesa,Item itemEquipado) {
		super(vida, ataque, defesa);
		this.setVida(vida);
		this.setAtaque(ataque);
		this.setDefesa(defesa);
		this.setItemEquipado(itemEquipado);
		this.setXp(0);
	}
	public CriaturaHostil( int vida, int ataque, int defesa) {
		super(vida, ataque, defesa);
		this.setVida(vida);
		this.setAtaque(ataque);
		this.setDefesa(defesa);
		this.setXp(0);
	}
	public CriaturaHostil() 
	{setId(0);}
	
	@Override
	public String informacoes() 
	{
		return "Criatura: " + this.getNome() + "\nId: " + this.getId() + "\nvida: " + this.getVida()
		+ "\nItem: " + this.getItemEquipado().getNome() + "\nAtaque: " + this.getAtaque()
		+ "\nDefesa: " + this.getDefesa();
	}
	
	
	
	
	
	

}
