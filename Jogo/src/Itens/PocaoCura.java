package Itens;

import javax.swing.JOptionPane;

import Genericos.Criatura;
import Genericos.Item;

public class PocaoCura extends Item{

	public PocaoCura() {
		this.setDescricao("Po��o de Cura, cura 10 de vida");
		this.setEquipavel(false);
		this.setId(3);
		this.setNome("Po��o de Cura");
		this.setQuantidade(1);
		this.setEstacavel(true);
		this.setAtiravel(false);
		this.setUsavel(true);
		this.setUsos(1);
	}

	@Override
	public void usar(Criatura criatura) 
	{
		String criaturaNome = criatura.getNome();
		if(criatura.getId() == -1) 
		{
			criaturaNome = "Voc�";
		}
		if(criatura.getVida()+10 >= criatura.getMaxVida()) 
		{
			criatura.setVida(criatura.getMaxVida());
			JOptionPane.showMessageDialog(null, criaturaNome + " usa a po��o e se cura totalmente");
		}
		else 
		{
			criatura.setVida(criatura.getVida() + 10);
			JOptionPane.showMessageDialog(null, criaturaNome + " usa a po��o e cura 10 de vida, ficando com " + criatura.getVida() + "de vida");
		}
		this.gastar();
		}

}
