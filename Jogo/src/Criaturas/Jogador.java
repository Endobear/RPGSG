package Criaturas;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import Genericos.Criatura;
import Genericos.Item;

public class Jogador extends Criatura{
	int maxXp;
	
	public Item[] inventario = new Item[] {new Item(),new Item(),new Item(),new Item(),new Item(),new Item(),new Item(),new Item(),new Item(),new Item()};
	
	/**
	 * Cria um jogador nivel 1 com 10 de vida, ataque 2, defesa 1 e sem nome
	 */
	public Jogador() 
	{
		this.setMaxVida(10);
		this.setId(-1);
		this.setVida(getMaxVida());
		this.setForca(2);
		this.setResistencia(1);
		this.setDefesa(this.getResistencia());
		this.setAtaque(this.getForca());
		this.setNivel(1);
		this.setMaxXp(this.getNivel()*5);
		this.setXp(0);
		this.setNome("Nulo");
		this.setVelocidade(5);
	}
	
	/**
	 * cria um jogador com vida, ataque e defesa customizáveis
	 * @param vida
	 * @param ataque
	 * @param defesa
	 */
	public Jogador(int vida, int ataque, int defesa) 
	{
		this.setId(0);
		this.setMaxVida(vida);
		this.setVida(vida);
		this.setForca(2);
		this.setResistencia(1);
		this.setDefesa(this.getResistencia());
		this.setAtaque(this.getForca());
		this.setNivel(1);
		this.setMaxXp(10);
		this.setXp(0);
		this.setNome("Nulo");
		this.setVelocidade(5);
		
	}

	/**
	 * Verifíca se o jogador não está com o inventário cheio e coloca o item no inventário
	 * @param item Item a ser recebido
	 * @param jogador Jogador que vai receber o item
	 * @return Se o jogador pode receber o item
	 */
	public void darItem(Item item, Jogador jogador)
	{
		String mensg = "inventário cheio";
		boolean n = false;
		for (int i = 0; i < jogador.getIventario().length; i++) {
			if(item.isEstacavel()) //verifica se vc pode estacar o item
			{
				if(jogador.inventario[i].getId() == item.getId()) //adiciona um item ao que já está lá
				{
					jogador.inventario[i].setQuantidade(jogador.inventario[i].getQuantidade() + 1);
					mensg = "Você adiciona mais " + item.getNome()+" ao seu inventário";
					n = true;
					break;
				}
				
			}
			if(n == false) {
				if(jogador.inventario[i].getId() == 0) //se o id do item for 0 (Vazio)
				{
					
					jogador.inventario[i] = item; //o "vazio" é substituido pelo item
					jogador.inventario[i].setEspacoNoInventario(i);
					mensg = item.getNome() + " foi colocado no inventário";
					n = true;
					break;
					
				}
			}
		}
			
			
			
				JOptionPane.showMessageDialog(null, mensg);
			
				
			
			
	}
	
	/**
	 * Verifica se o inventario do jogador esta vazio
	 * @param jogador
	 * @return
	 */
	public boolean isInventarioLivre(Jogador jogador) 
	{
		boolean n = false;
		for (int i = 0; i < jogador.getIventario().length; i++) {
			if(jogador.inventario[i].getId() == 0) //se o id do item for 0 (Vazio)
			{
				n = true;
				break;
				
			}
		}
			
			
			
		
		return n;
	}
	
	/**
	 * Equipa o jogador com um item que não está no inventário
	 * @param j Jogador
	 * @param i Item a ser equipado
	 */
	public void equipar(Jogador j,Item i) 
	{
		if(j.getItemEquipado().getId() == 0 && i.isEquipavel() == true) //verifica se a mão do jogador está livre
		{
			j.setItemEquipado(i); //equipa o item
			j.getItemEquipado().setEspacoNoInventario(-1);
			j.setAtaque(j.getForca() + j.getItemEquipado().getDano()); // Faz o novo ataque do jogador
			JOptionPane.showMessageDialog(null, i.getNome() + " foi equipado"); 
		}
		else 
		{
			//se a mão já tem algo e o iventtário está livre, ele troca o item da mão com o que está no inventário
			if(isInventarioLivre(j) == true && i.isEquipavel() == true) { 
			colocarEquipInv(j); 
			equipar(j,i);
			JOptionPane.showMessageDialog(null, "Item equipado foi trocado");
			}
			
			else if(i.isEquipavel() == false)
			{
				JOptionPane.showMessageDialog(null, i.getNome() + "não é equipável");
				darItem(i, j);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Inventário e mão cheios");
			}
		}
	}
	
	/**
	 * Equipa um item do Inventário no jogador
	 * @param j Jogador
	 * @param posicao Posição no inventário do item que vai ser equipado
	 */
	public void equiparDoInv(Jogador j,int posicao) 
	{
		Item itemSendoEquipado;
		if(j.getItemEquipado().getId() == 0) //verifica se a mão do jogador está livre
		{
			if(j.inventario[posicao].isEquipavel()) { //verifica se o item a ser equipado é equipavel
			//esvazia o espaço no inventário do jogador e equipa o item que estava naquele espaço
			itemSendoEquipado = j.inventario[posicao];
			j.inventario[posicao] = new Item();
			j.setItemEquipado(itemSendoEquipado);
			JOptionPane.showMessageDialog(null, itemSendoEquipado.getNome() + " foi equipado");
			j.getItemEquipado().setEspacoNoInventario(-1);
			j.setAtaque(j.getForca() + j.getItemEquipado().getDano()); // Faz o novo ataque do jogador
			}
			
			else {JOptionPane.showMessageDialog(null,j.inventario[posicao].getNome() + "  não é equipavel");}
			
		}
		else 
		{
			/**
			 * Troca o item que está na mão do jogador com o que está no inventário
			 */
			if(isInventarioLivre(j) == true && j.inventario[posicao].isEquipavel() == true) {
				itemSendoEquipado = j.inventario[posicao];
				j.inventario[posicao] = new Item();
				j.colocarEquipInv(j);
				j.setItemEquipado(itemSendoEquipado);
				j.getItemEquipado().setEspacoNoInventario(-1);
				j.setAtaque(j.getForca() + j.getItemEquipado().getDano()); // Faz o novo ataque do jogador
				
			JOptionPane.showMessageDialog(null, "Item equipado foi trocado por " + itemSendoEquipado.getNome());
			}
			else if(j.inventario[posicao].isEquipavel() != true) 
			{
				JOptionPane.showMessageDialog(null,j.inventario[posicao].getNome() + "  não é equipavel");
			}
			else {
			JOptionPane.showMessageDialog(null, "Mão e inventário cheio");
			}
		}
	}
	
	/**
	 * Coloca um item equipado no inventário
	 * @param jogador
	 */
	public void colocarEquipInv(Jogador jogador) 
	{
		if(jogador.getItemEquipado().getId() != 0) 
		{
			if(jogador.isInventarioLivre(jogador) != false) { 
			jogador.darItem(jogador.getItemEquipado(),jogador);
			}
		}
		
	}
	
	/**
	 * Função para atacar uma criatura
	 * @param criatura
	 */
	@Override
	public void atacar(Criatura criatura) 
	{
		int dano = (this.getAtaque() + this.getForcaTemp())-criatura.getDefesa(); 
		if(dano < 0) 
		{
			if(criatura.getDefesa() < this.getAtaque()*2) 
			{
				if((int) (Math.random()*2) + 1 == 1)
				{
					criatura.setVida(criatura.getVida()-1);
					JOptionPane.showMessageDialog(null, "Com muito esforço, você consegue dar 1 de dano em " + criatura.getNome());
				}
				else 
				{
					JOptionPane.showMessageDialog(null, "Você ataca, mas seu esforço não é suficiente para causar dano em " + criatura.getNome());
				}
			}
			else 
			{
				JOptionPane.showMessageDialog(null, "Você ataca "+ criatura.getNome()+", mas não causa dano");
			}
		}
		else 
		{
		criatura.setVida(criatura.getVida()-(dano));
		JOptionPane.showMessageDialog(null, this.getNome() + " ataca " + criatura.getNome() + " e tira " + dano + " de vida");
		if(criatura.getVida() <= 0) 
		{
			this.derrotarMonstro(criatura);
		}
		}
	}
	
	/**
	 * Derrota uma criatura, adicionando xp,pegando drops da criatura etc.
	 * @param criatura
	 */
	public void derrotarMonstro(Criatura criatura)
	{
	
		if(criatura.isVivo()) {//verifica se a criatura está viva, mas isso é porque ela vai ser colocada como morta/derrotada nesse código
			JOptionPane.showMessageDialog(null, "Você derrotou um " + criatura.getNome() + " e ganhou " + criatura.getXp() + " de experiência");
			if(criatura.getXp()+ this.getXp() >= this.getMaxXp()) //Verifica se o jogador pode passar de nível
			{
				int sas = this.getMaxXp() - this.getXp();
				int xpGanho = criatura.getXp();
				xpGanho -= sas;
				this.passaNivel(xpGanho);
				
			}
			else 
			{
				this.setXp(this.getXp()+criatura.getXp());//adiciona experiência do monstro para o jogador
			}
			/**
			 * verifica se o monstro tem algum drop e se o jogador quer
			 */
			if(criatura.getDrop().getId() != 0) 
			{
				Object[] o = new Object[] {"Equipar","Colocar no inventário", "Deixar aí"};
				Object a = JOptionPane.showInputDialog(null, criatura.getNome() + " deixou cair " + criatura.getDrop().getNome()+ " o que quer fazer com o item?", "Drop", JOptionPane.DEFAULT_OPTION, null, o, o[0]);
				if(a == "Equipar") 
				{
					this.equipar(this, criatura.getDrop());
				}
				else if (a == "Colocar no inventário") 
				{
					this.darItem(criatura.getDrop(), this);
				}
			}
			
			criatura.setVivo(false);//finalmente mata/derrota a criatura
			
		}
		
	}
	
	/**
	 * Da experiência para o jogador por um numero inteiro
	 * @param xp
	 */
	public void darXP(int xp) 
	{
		if(xp + this.getXp() >= this.getMaxXp()) 
		{
			xp -= this.getMaxXp() - this.getXp();
			this.passaNivel(xp);
		}
		else 
		{
			JOptionPane.showMessageDialog(null, "Você ganhou " + xp + " de experiência");
			this.setXp(this.getXp() + xp);
		}
	}
	
	/**
	 * Passa o nivel do jogador
	 * @param xpRestante xp caso o jogador consiga experiência o suficiente para passar de nivel e mais um pouco
	 */
	public void passaNivel(int xpRestante) 
	{
		
		this.setNivel(this.getNivel()+1);//sobe o nivel
		this.setXp(0);//reseta a experiencia do jogador pois passou de nivel
		this.setMaxXp(this.getNivel()*5);//aumenta o necessário de xp para o próximo nível
		JOptionPane.showMessageDialog(null, "Parabéns, você passou de nivel!\nAgora você é nivel " + this.getNivel());
		
		//TODO fazer um sistema melhor de aumento das habilidades, com numeros aleatórios
		this.setForca(this.getForca()+2);
		this.setResistencia(this.getDefesa()+1);
		this.setVelocidade(this.getVelocidade()+5);
		this.setMaxVida(getMaxVida()+5);
		if(this.getVida() + 5 >= this.getMaxVida()) 
		{
			this.setVida(this.getMaxVida());
		}
		else
		{
			this.setVida(this.getVida()+5);
		}
		this.setAtaque(this.getForca()+this.getItemEquipado().getDano());
		this.setDefesa(this.getResistencia());
		
		if(xpRestante >= this.getMaxXp()) //caso o jogador consiga passar mais de 1 nivel
		{
			xpRestante -= this.getMaxXp();
			passaNivel(xpRestante);
		}
		else
		{
			this.setXp(xpRestante);
		}
		
	}
	
	
	
	
	@Override
	public String informacoes() 
	{
		String efeitosMon = "", info = "Nome: " + this.getNome() 
									+ "\nNivel: " + this.getNivel()
									+ "\nExperiência: " + this.getXp() + "/" + this.getMaxXp()
									+ "\nVida: " + this.getVida();
		if(this.getItemEquipado().getId() != 0) {
			info += "\nItem: " + this.getItemEquipado().getNome() +"(Dano: "+ this.getItemEquipado().getDano() +")";
		}
		info += "\nAtaque: " + this.getAtaque() + "\nDefesa: " + this.getDefesa();
		
		
		for (int i = 0; i < getEfeitos().length; i++) {
			if(getEfeitos()[i].getId() != 0) 
			{
				if(efeitosMon.equals("")) 
				{
					efeitosMon = "\nEfeitos: " ;
				}
				efeitosMon += getEfeitos()[i].getNome() + " ";
			}
		}
		info += efeitosMon;
		return info;
	}
	
	public void informacoes(Map<Integer, Item> mapa) 
	{
		int escolha;

		Object[] opcoes = new Object[] { "OK", "Salvar","Carregar"};

		escolha = JOptionPane.showOptionDialog(null, this.informacoes(), this.getNome(), JOptionPane.DEFAULT_OPTION,
				JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);
		
		switch (escolha) {
		case 1:
			this.salvarJogador();
			break;
			
		case 2:
			JFileChooser caminho = new JFileChooser();
			int checaSeRetornou = caminho.showOpenDialog(null);
			if(checaSeRetornou == JFileChooser.APPROVE_OPTION) 
			{
				
				this.carregarJogador(caminho, mapa);
			}
			
			
			break;
			
		default:
			break;
		}
	}
	
	public void salvarJogador() 
	{
		
		try {
			FileWriter save;
			save = new FileWriter("Salvamentos\\" + this.getNome() + ".txt");
			PrintWriter escrevedor = new PrintWriter(save);
			String inventario = "";
			for (int i = 0; i < this.inventario.length; i++) {
				if(i+1 != this.inventario.length) {
					inventario += Integer.toString(this.inventario[i].getId()) + "|";
				}
				else 
				{
					inventario += Integer.toString(this.inventario[i].getId());
				}
			}
			
			escrevedor.printf("NOME " + this.getNome()+"\n");
			escrevedor.printf("NIVEL " + this.getNivel()+"\n");
			escrevedor.printf("MAXXP " + this.getMaxXp()+"\n");
			escrevedor.printf("XP " + this.getXp()+"\n");
			escrevedor.printf("FORCA " + this.getForca()+"\n");
			escrevedor.printf("RESISTENCIA " + this.getResistencia()+"\n");
			escrevedor.printf("VELOCIDADE " + this.getVelocidade()+"\n");
			escrevedor.printf("VIDAMAX " + this.getMaxVida()+"\n");
			escrevedor.printf("VIDA " + this.getVida()+"\n");
			escrevedor.printf("ITEMEQUIPADO " + this.getItemEquipado().getId()+"\n");
			escrevedor.printf("INVENTARIO " + inventario);
			
			
			
			escrevedor.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
	public void carregarJogador(JFileChooser arquivo, Map<Integer, Item> mapa) 
	{
		
		//TODO fazer esse sistema em Json pq em txt puro eu to ficando PUTO
		try {
			FileReader arq = new  FileReader(arquivo.getSelectedFile());
			BufferedReader leitor = new BufferedReader(arq);
			//to com sono
			String linha = leitor.readLine();
			while (leitor != null) {
				for (int i = 0; i < 12; i++) {
					switch (i) {
					
					case 0:
						this.setNome(linha.substring(5));
						break;
						
					case 1:
						this.setNivel(Integer.parseInt(linha.substring(7)));
						break;
						
					case 2:
						this.setMaxVida(Integer.parseInt(linha.substring(6)));
						break;
					case 3:
						
						break;
					case 4:
						
						break;
					case 5:
						
						break;
					case 6:
						
						break;
					case 7:
						
						break;
					case 8:
						
						break;
					case 9:
						
						break;
					case 10:
						
						break;
					case 11:
						
						break;
						
					default:
						break;
					}
					
					linha = leitor.readLine();
				}
				
			}
			
			arq.close();
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
//getters and setters
	

	public Item[] getIventario() {
		return inventario;
	}


	public void setIventario(Item[] iventario) {
		this.inventario = iventario;
	}

	


	public int getMaxXp() {
		return maxXp;
	}

	public void setMaxXp(int maxXp) {
		this.maxXp = maxXp;
	}
	
	
}
