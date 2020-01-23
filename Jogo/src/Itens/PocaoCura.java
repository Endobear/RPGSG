package Itens;

import javax.swing.JOptionPane;

import Criaturas.Jogador;
import Genericos.Item;

public class PocaoCura extends Item{

	public PocaoCura() {
		this.setDescricao("Po��o de cura. cura 10 de vida");
		this.setEquipavel(false);
		this.setId(3);
		this.setNome("Po��o de cura");
		this.setAtiravel(false);
		this.setUsavel(true);
		this.setUsos(1);
	}

	@Override
	public void Usar(Jogador jogador) 
	{
		if(jogador.getVida()+10 >= jogador.getMaxVida()) 
		{
			jogador.setVida(jogador.getMaxVida());
			JOptionPane.showMessageDialog(null, "Voc� usa a po��o e se cura totalmente");
		}
		else 
		{
			jogador.setVida(jogador.getVida() + 10);
			JOptionPane.showMessageDialog(null, "Voc� usa a po��o e cura 10 de vida, te deixando com " + jogador.getVida() + "de vida");
		}
		this.setUsos(this.getUsos()-1);
		}

}
