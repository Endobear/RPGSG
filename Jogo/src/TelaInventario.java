import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Criaturas.Jogador;
import Genericos.Item;

public class TelaInventario extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInventario frame = new TelaInventario(new Jogador());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	int opcaoSelecionada;
	Item itemSelecionado;
	JLabel lblItemSelecionado = new JLabel("Item Selecionado");
	public TelaInventario(Jogador jogador) {
	
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInventrio = new JLabel("Invent\u00E1rio");
		lblInventrio.setBounds(173, 11, 69, 14);
		contentPane.add(lblInventrio);
		
		JButton btnItem1 = new JButton(jogador.inventario[0].getNome());
		btnItem1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setItemSelecionado(jogador.inventario[0]);
				setOpcaoSelecionada(0);
			}
		});
		btnItem1.setBounds(21, 94, 89, 23);
		contentPane.add(btnItem1);
		
		JButton btnItem2 = new JButton(jogador.inventario[1].getNome());
		btnItem2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setItemSelecionado(jogador.inventario[1]);
				setOpcaoSelecionada(1);
			}
		});
		btnItem2.setBounds(120, 94, 89, 23);
		contentPane.add(btnItem2);
		
		JButton btnItem3 = new JButton(jogador.inventario[2].getNome());
		btnItem3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setItemSelecionado(jogador.inventario[2]);
				setOpcaoSelecionada(2);
			}
		});
		btnItem3.setBounds(219, 94, 89, 23);
		contentPane.add(btnItem3);
		
		JButton btnItem4 = new JButton(jogador.inventario[3].getNome());
		btnItem4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setItemSelecionado(jogador.inventario[3]);
				setOpcaoSelecionada(3);
			}
		});
		btnItem4.setBounds(318, 94, 89, 23);
		contentPane.add(btnItem4);
		
		JButton btnItem5 = new JButton(jogador.inventario[4].getNome());
		btnItem5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setItemSelecionado(jogador.inventario[4]);
				setOpcaoSelecionada(4);
			}
		});
		btnItem5.setBounds(21, 128, 89, 23);
		contentPane.add(btnItem5);
		
		JButton btnItem6 = new JButton(jogador.inventario[5].getNome());
		btnItem6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setItemSelecionado(jogador.inventario[5]);
				setOpcaoSelecionada(5);
			}
		});
		btnItem6.setBounds(120, 128, 89, 23);
		contentPane.add(btnItem6);
		
		JButton btnItem7 = new JButton(jogador.inventario[6].getNome());
		btnItem7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setItemSelecionado(jogador.inventario[6]);
				setOpcaoSelecionada(6);
			}
		});
		btnItem7.setBounds(219, 128, 89, 23);
		contentPane.add(btnItem7);
		
		JButton btnItem8 = new JButton(jogador.inventario[7].getNome());
		btnItem8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setItemSelecionado(jogador.inventario[7]);
				setOpcaoSelecionada(7);
			}
		});
		btnItem8.setBounds(318, 128, 89, 23);
		contentPane.add(btnItem8);
		
		JButton btnItem9 = new JButton(jogador.inventario[8].getNome());
		btnItem9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setItemSelecionado(jogador.inventario[8]);
				setOpcaoSelecionada(8);
			}
		});
		btnItem9.setBounds(120, 162, 89, 23);
		contentPane.add(btnItem9);
		
		JButton btnItem10 = new JButton(jogador.inventario[9].getNome());
		btnItem10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setItemSelecionado(jogador.inventario[9]);
				setOpcaoSelecionada(9);
			}
		});
		btnItem10.setBounds(219, 162, 89, 23);
		contentPane.add(btnItem10);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, getOpcaoSelecionada());
				
				
				setOpcaoSelecionada(-1);
				setVisible(false);
				Teste.mostrarInv(jogador);
				
				
				
			}
		});
		btnVoltar.setBounds(335, 227, 89, 23);
		contentPane.add(btnVoltar);
		
		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, getOpcaoSelecionada() + " \nItem: " + jogador.inventario[getOpcaoSelecionada()].getNome());
				jogador.equiparDoInv(jogador, getOpcaoSelecionada());
				setVisible(false);
				Teste.mostrarInv(jogador);
				
			}
		});
		btnConfirmar.setBounds(21, 227, 89, 23);
		contentPane.add(btnConfirmar);
		
		
		lblItemSelecionado.setBounds(120, 231, 188, 14);
		contentPane.add(lblItemSelecionado);
	}
	
	
	
	public int getOpcaoSelecionada() {
		return opcaoSelecionada;
	}
	public void setOpcaoSelecionada(int opcaoSelecionada) {
		this.opcaoSelecionada = opcaoSelecionada;
	}
	public Item getItemSelecionado() {
		return itemSelecionado;
	}
	public void setItemSelecionado(Item itemSelecionado) {
		this.itemSelecionado = itemSelecionado;
		lblItemSelecionado.setText(itemSelecionado.getNome());
	}
	
	
}
