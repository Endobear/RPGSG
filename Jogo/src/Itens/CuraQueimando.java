package Itens;

import javax.swing.JOptionPane;

import Efeitos.Queimando;
import Genericos.Criatura;
import Genericos.Item;

public class CuraQueimando extends Item {
	
	public CuraQueimando() {
		setId(4);
		setNome("Cura Queimadura");
		setUsavel(true);
		setDescricao("Essa poção cura o efeito Queimando!");
		setEstacavel(true);
		setQuantidade(1);
		setQuantidadeMax(5);
		setEquipavel(false);
		setUsos(1);
	}
	@Override
	public void usar(Criatura criatura) {
		int posicao = criatura.temEfeito(new Queimando());
		if( posicao == -1 ) 
		{
			JOptionPane.showMessageDialog(null, criatura.getNome() + "não está queimando");
		}
		else 
		{
			criatura.getEfeitos()[posicao].apagar();
			JOptionPane.showMessageDialog(null, criatura.getNome() + " parou de queimar");
			this.gastar();
		}
		
	}

}
