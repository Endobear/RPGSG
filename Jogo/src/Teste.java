


import javax.swing.JOptionPane;

import Criaturas.Esqueleto;
import Criaturas.Jogador;
import Criaturas.Slime;
import Genericos.Criatura;
import Itens.EspadaMadeira;

public class Teste {
	public static void main(String[] args) {
		
			Jogador eu = new Jogador();
			eu.setNome(JOptionPane.showInputDialog(null, "Escreva seu nome"));
			if(eu.getNome() == null) 
			{
				System.exit(0);
			}
			
		iniciar(eu);

	}

	public static void iniciar(Jogador eu) {

		int opcao;

		Object[] yae = new Object[] { "Informações sobre o jogador", "inventario do Jogador", "Gerar Esqueleto" };

		opcao = JOptionPane.showOptionDialog(null, "Escolha uma opção", "Inicio", JOptionPane.DEFAULT_OPTION,
				JOptionPane.INFORMATION_MESSAGE, null, yae, "Informações sobre o jogador");

		switch (opcao) {
		case -1:
			System.exit(0);
			break;

		case 0:
			JOptionPane.showMessageDialog(null, eu.informacoes());
			iniciar(eu);
			break;

		case 1:
			mostrarInv(eu);
			break;

		case 2:
			mostrarEsqueleto(eu);
			break;
			
		default:
			System.exit(0);
			break;
		}

	}

	/**
	 * pega os itens no inventário e mostra 
	 * @param jogador
	 */
	
	public static void mostrarInv(Jogador jogador) {
		Object[] yae = new Object[] { "Voltar", "Colocar Espada", "Equipar" };
		int opcao;
		
		opcao = JOptionPane.showOptionDialog(null,
				"Inventario:\n" + jogador.inventario[0].getNome() + " | " + jogador.inventario[1].getNome() + " | "
						+ jogador.inventario[2].getNome() + " | \n" + jogador.inventario[3].getNome() + " | "
						+ jogador.inventario[4].getNome() + " | " + jogador.inventario[5].getNome() + " | \n"
						+ jogador.inventario[6].getNome() + " | " + jogador.inventario[7].getNome() + " | "
						+ jogador.inventario[8].getNome() + " | \n" + jogador.inventario[9].getNome(),
				"sim", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, yae, "Voltar");
		

		switch (opcao) {
		case 0:
			iniciar(jogador);
			break;
		case 1:
			jogador.darItem(new EspadaMadeira(), jogador);
			mostrarInv(jogador);
			break;
		case 2:
			equipar(jogador);
			break;
		case -1:
			System.exit(0);
			break;
			
		default:
			System.exit(0);
			break;
		}

	}

	public static void equipar(Jogador j) 
	{
		
		
		/*boolean naTela = true;
		int opcao;
		*/
		TelaEscolhaInventario tela = new TelaEscolhaInventario(j,false);
		tela.setVisible(true);
		iniciar(j);
		/*while(naTela == true) 
		{
			if(tela.isVisible() == false) 
			{
				
				opcao = tela.getOpcaoSelecionada();
				if(opcao == -1) 
				{
					JOptionPane.showMessageDialog(null, opcao + " \nItem: " + j.iventario[opcao].getNome());
					
					mostrarInv(j);
					naTela = false;
					
				}
				else
				{
					j.equiparDoInv(j, opcao);
					JOptionPane.showMessageDialog(null, opcao + " \nItem: " + j.iventario[opcao].getNome());
					
					mostrarInv(j);
					naTela = false;
				}
				
			}
			
		}
		*/
		
				//JOptionPane.showOptionDialog(null, "Escolha o item", "Equipar", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, yae, yae[0]);
		
		
		
	}
	
	/**
	 * Gera um esqueleto de Teste
	 */
	public static void mostrarEsqueleto(Jogador j) {
		Esqueleto esqueleto = new Esqueleto();

		Object[] yae = new Object[] {"Lutar","Voltar"};
		int opcoes = JOptionPane.showOptionDialog(null,esqueleto.informacoes(), esqueleto.getNome(), JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, yae, "Lutar");
		
		switch (opcoes) {
		case -1:
			System.exit(0);
			break;
			
		case 0:
			Batalha u = new Batalha();
			try {
				Criatura[] c = new Criatura[Integer.parseInt(JOptionPane.showInputDialog(null,"Quantos?"))];
			
			
			for (int i = 0; i < c.length; i++) {
				
					if((int) ((Math.random()*2) + 1) == 1) 
					{
						c[i] = new Slime();
					}
					else {c[i] = new Esqueleto();}
				
			}
			u.iniciarBatalha(j, c);

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Por favor colocar apenas numeros");
				mostrarEsqueleto(j);
			}
			break;

		case 1:
			iniciar(j);
			break;
	
		default:
			System.exit(0);
			break;
		}
				

		
	}


}
