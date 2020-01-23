import javax.swing.JOptionPane;

import Criaturas.Esqueleto;
import Criaturas.Jogador;
import Criaturas.Slime;
import Genericos.CriaturaHostil;
import Genericos.Item;
import Itens.Pedra;

public class Batalha {

	
	Jogador jooj;
	CriaturaHostil[] adversarios;
	boolean fugiu = false;
	
	public static void main(String[] args) {
	
		Batalha batalha = new Batalha();
		Jogador j = new Jogador();
		j.inventario[1] = new Pedra();
		CriaturaHostil[] adv = new CriaturaHostil[]{new Esqueleto(), new Slime()};
		
		batalha.iniciarBatalha(j,adv);
	}

	/**
	 * inicia batalha com 1 criatura.
	 * @param jogador
	 * @param criatura
	 */
	public  void iniciarBatalha(Jogador jogador, CriaturaHostil criatura) 
	{
		
		adversarios = new CriaturaHostil[1]; //inicia adiversarios com 1 espaço
		adversarios[0] = criatura; //coloca a criaturo nos adversários
		passaTurno(jogador, adversarios); //começa o 1° turno
	}
	/**
	 * Inicia batalha com mais de 1 criatura
	 * @param jogador
	 * @param criatura
	 */
	public void iniciarBatalha(Jogador jogador, CriaturaHostil[] criatura) 
	{
		adversarios = new CriaturaHostil[criatura.length]; //inicia adversários com espaços para cada criatura que vai lutar
		adversarios = criatura; //transfere todas as criaturas para a variave adversários
		passaTurno(jogador, adversarios);//começa o 1° turno
	}

	/**
	 * Passa turno com várias criaturas
	 * @param jogador
	 * @param criatura
	 */
	public void passaTurno(Jogador jogador, CriaturaHostil[] criatura) 
	{
		
		int acoes = (jogador.getVelocidade()/2);//simples sistemas de ações que vai ser mudado depois
		// TODO fazer um sistema de ataques para poder atacar mais de uma vez 
		Boolean[] acoesMonst = new Boolean[adversarios.length]; //matriz que armazenará se cada monstro atacou
		
		//Inicia a matriz
		for (int i = 0; i < acoesMonst.length; i++) {
			acoesMonst[i] = true;
		}
		
		boolean atacou = false;//diz se o jogador atacou, pro definição começa falso
		for (int i = 0; i < adversarios.length + acoes; i++) {//começo dos turnos
			if(jogador.getVida() <= 0) 
			{
				JOptionPane.showMessageDialog(null, "Infelizmente você morreu, e esse jogo ainda não tem sistema de salvamento."
						+ "\nAinda pretendo melhorar ele e adicionar muitas coisas novas(além de deixar o jogo melhor). Espere por mais atualizações futuras"
						+ "\nEspero que tenha gostado do jogo. Obrigado por jogar!"
						+ "\n-Endo");
				System.exit(0);
			}	
		
			
			if(i+1 <= adversarios.length) //Verificação se  todos os monstros já fizeram suas açoes
			{
				if(adversarios[i].isVivo()) {
				
				if(jogador.getVelocidade() >= adversarios[i].getVelocidade() && acoes > 0 && atacou == false) //verificação se a velocidade do jogador é maior que a do monstro, se ele possui ações e se ele já atacou no ultimo turno
				{
					escolhas(jogador);//inicia as escohas do jogador
					if (fugiu || temAdversariosVivos(adversarios,jogador) == false) {
						break;
					}
					acoes--;//tira uma ação do jogador
					atacou = true;//diz q ele já atacou(que tambem diz q ele já fez uma ação)
						i--;	//volta 1 turno
				}
				
				else  if(acoesMonst[i] == true) //verifica se o monstro da vez pode fazer uma ação
				{
					turnoInimigo(adversarios[i], jogador); //faz a ação do inimigo
					acoesMonst[i] = false;
					atacou = false;
					if(i - 1 >= 0) 
					{
						i--;	
					}
					
				}
				
				}
				/**
				 * derrota o monstro caso haja algum erro
				 */
				else if(adversarios[i].isVivo() & adversarios[i].getVida() <= 0) 
				{
					jogador.derrotarMonstro(adversarios[i]);
				}
				
				
			}
			
			else if(i+1 >= adversarios.length && acoes > 0) //verifica se se todos os monstros já atacaram e se o jogador ainda possui ações
			{
				escolhas(jogador);
				if (fugiu || temAdversariosVivos(adversarios,jogador) == false) {
					break;
				}
				acoes--;
			}
			
			
			
			
		}
		if(temAdversariosVivos(adversarios,jogador) & fugiu == false) 
		{
			passaTurno(jogador, criatura);
		}
		
		else 
		{
			if(fugiu) 
			{
				JOptionPane.showMessageDialog(null, "Você fugiu da luta");
				//Teste.iniciar(jogador);	
			}
			
			else 
			{
				JOptionPane.showMessageDialog(null, "Parabéns, você derrotou todos os inimigos");
				//Teste.iniciar(jogador);
			}
		}
	}

	

	/**
	 * Função que o jogador faz uma ação 
	 * @param jogador
	 */
	private void escolhas(Jogador jogador) {
		
		// TODO Auto-generated method stub
		Object[] opcoes = new Object[] {"Atacar","Itens","Usar Habilidade","Fugir"};
		Object[] nomeAdv = new Object[adversarios.length];
		for (int i = 0; i < nomeAdv.length; i++) {
			nomeAdv[i] = adversarios[i].getNome();
		}
		int escolha;
		escolha = JOptionPane.showOptionDialog(null, jogador.getNome()+"\nVida: " + jogador.getVida(), "Batalha", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, "Atacar");
		switch (escolha) {
		/**
		 * Se o jogador escolher atacar
		 */
		case 0:
			TelaEscolhaMonst telaMonstro = new TelaEscolhaMonst(adversarios);
			telaMonstro.setVisible(true);
			if(telaMonstro.getCriaturaEscohida().getId() == 0) 
			{
				escolhas(jogador);
			}
			else 
			{
				jogador.atacar(telaMonstro.getCriaturaEscohida());
			}
			break;
		/**
		 * Se o jogador resolver usar algum item	
		 */
		case 1:
			TelaEscolhaInventario telaInv = new TelaEscolhaInventario(jogador, true);//cria uma tela para o jogador escoher o item
			telaInv.setVisible(true);
			//se o jogador equipar algum item ele usa uma ação
			if(telaInv.getItemEscolhido().getId() != 0) //Se ele escolheu algum item
			{
				if(telaInv.getItemEscolhido().isUsavel()) //verifica se o item escolhido é usável
				{
					if(telaInv.getItemEscolhido().isAtiravel()) {
						TelaEscolhaMonst telaMonst = new TelaEscolhaMonst(adversarios); //se o item é atirave, cria uma tela para escolher o inimigo ao qual o item será atirado
						telaMonst.setVisible(true);
						if(telaMonst.getCriaturaEscohida().getId() == 0)  //se ele não escolher nenhum inimigo, ele volta a fazer alguma escolha
						{
							escolhas(jogador);
						}
						else 
						{
							/**
							 * Atira o item em alguma criatura
							 */
							jogador.inventario[telaInv.getNumero()].Usar(telaMonst.getCriaturaEscohida());
							if(jogador.inventario[telaInv.getNumero()].getUsos() <= 0) 
							{
								jogador.inventario[telaInv.getNumero()] = new Item();
							}
						}
						
					}
					
					/**
					 * Se o item não é atiravel, o item é usado no jogador
					 */
					else
					{
						jogador.inventario[telaInv.getNumero()].Usar(jogador);
						if(jogador.inventario[telaInv.getNumero()].getUsos() <= 0) 
						{
							jogador.inventario[telaInv.getNumero()] = new Item();
						}
					}
				}
				
				else 
				{
					JOptionPane.showMessageDialog(null, telaInv.getItemEscolhido().getNome() + " não é usável");
				}
			}
			else {escolhas(jogador);}
			
			break;
			
		case 2:
			/**
			 * Aqui ficará o sistema de uso de habilidades
			 */
			JOptionPane.showMessageDialog(null, "Sitema de habilidades ainda não está disponível");
			escolhas(jogador);
			break;		
		/**
		 * caso o jogador escolha fugir
		 */
		case 3:
			fugiu = true;
			break;
			
		case -1:
			System.exit(0);
			break;
			
		default:
			System.out.println("IIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIii");
			System.exit(0);
			break;
		}
		
	}
	
	/**
	 * Faz as ações dos inimigos
	 * @param criatura
	 * @param jogador
	 */
	// TODO fazer com que cada inimigo, na classe dele, tenha programado o que ele irá fazer em seu turno, por exemplo: atacar, se curar, curar um aliado, dar efeito
	private void turnoInimigo(CriaturaHostil criatura, Jogador jogador) {
		criatura.atacar(jogador);
	}
	
	
	
	public boolean temAdversariosVivos(CriaturaHostil[] criaturas,Jogador jogador) 
	{
		boolean n = false;
		for (int i = 0; i < criaturas.length; i++) {
			if(criaturas[i].isVivo() == true) 
			{
				if(criaturas[i].getVida()<= 0) 
				{
				jogador.derrotarMonstro(criaturas[i]);	
				}
				else 
				{
				n = true;
				break;
				}
			}

		}
		return n;
	}
	
	
}
