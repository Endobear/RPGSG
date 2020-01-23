import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import Criaturas.Esqueleto;
import Criaturas.Jogador;
import Criaturas.Slime;
import Genericos.CriaturaHostil;
import Genericos.Item;
import Itens.EspadaMadeira;
import Itens.Pedra;
import Itens.PocaoCura;

public class TesteFinal {

	private JFrame frmRpgsg;

	/**
	 * Launch the application.
	 */
	Map<Integer,Item> itens = new HashMap<Integer, Item>();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jogador jogador = new Jogador();
					TesteFinal window = new TesteFinal(jogador);
					window.frmRpgsg.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TesteFinal(Jogador jogador) {
		initialize(jogador);
		iniciarItens(itens);
		
		
		jogador.setNome(JOptionPane.showInputDialog(null, "Escreva seu nome"));
		if(jogador.getNome() == null) 
		{
			System.exit(0);
		}
		if(jogador.getNome().trim().equals("")) 
		{
			jogador.setNome("Nulo");
		}
		
	}

	private void iniciarItens(Map<Integer, Item> mapa) 
	{
		
		mapa.put(new Item().getId(), new Item());
		mapa.put(new EspadaMadeira().getId(), new EspadaMadeira());
		mapa.put(new Pedra().getId(), new Pedra());
		mapa.put(new PocaoCura().getId(), new PocaoCura());
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Jogador jogador) {
		frmRpgsg = new JFrame();
		frmRpgsg.setTitle("RPGSG v0.0.2");
		frmRpgsg.setBounds(100, 100, 617, 267);
		frmRpgsg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRpgsg.getContentPane().setLayout(null);
		
		JButton btnInfo = new JButton("Informa\u00E7\u00F5es sobre o Jogador");
		btnInfo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jogador.informacoes(itens);
			}
		});
		btnInfo.setBounds(10, 132, 186, 68);
		frmRpgsg.getContentPane().add(btnInfo);
		
		JLabel lblTitulo = new JLabel("RPG Sem Gra\u00E7a");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(196, 11, 229, 108);
		frmRpgsg.getContentPane().add(lblTitulo);
		
		JButton btnInventario = new JButton("Invent\u00E1rio");
		btnInventario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnInventario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaEscolhaInventario tela = new TelaEscolhaInventario(jogador, false);
				tela.setVisible(true);
			}
		});
		btnInventario.setBounds(206, 132, 186, 68);
		frmRpgsg.getContentPane().add(btnInventario);
		
		JButton btnGerarEsqueleto = new JButton("Lutar");
		btnGerarEsqueleto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnGerarEsqueleto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Batalha b = new Batalha();
				try {
					String numero = JOptionPane.showInputDialog(null,"Com quantos montros deseja lutar?");
					if(numero != null) 
					{
						
					
					CriaturaHostil[] c = new CriaturaHostil[Integer.parseInt(numero)];
				
				
				for (int i = 0; i < c.length; i++) {
					
						if((int) ((Math.random()*2 +1)) == 1) 
						{
							c[i] = new Slime();
						}
						else {c[i] = new Esqueleto();}
					
				}
				b.iniciarBatalha(jogador, c);
					}
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Por favor colocar apenas numeros positivos");
				}
			}
		});
		btnGerarEsqueleto.setBounds(402, 132, 186, 68);
		frmRpgsg.getContentPane().add(btnGerarEsqueleto);
	}
}
