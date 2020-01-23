package Itens;

import javax.swing.JOptionPane;

import Genericos.Criatura;
import Genericos.Item;

public class Pedra extends Item{

	public Pedra(){
		this.setUsavel(true);
		this.setDano(5);
		this.setDescricao("É uma pedra");
		this.setEquipavel(false);
		this.setId(2);
		this.setNome("Pedra");
		this.setUsavel(true);
		this.setAtiravel(true);
		this.setUsos(1);
	}

	@Override
	public void Usar(Criatura criatura) 
	{
		int dano = this.getDano() - criatura.getDefesa();
		if (dano <= 0) 
		{
			JOptionPane.showMessageDialog(null, "Você taca uma pedra em " + criatura.getNome() + " mas não causa dano");
			this.setUsos(this.getUsos()-1);
		}
		else 
		{
			criatura.setVida(criatura.getVida()-dano);
			JOptionPane.showMessageDialog(null, "Você taca uma pedra em " +criatura.getNome() + " causando " + dano + " de dano");
			
		}
		this.setUsos(this.getUsos()-1);
	}
}
