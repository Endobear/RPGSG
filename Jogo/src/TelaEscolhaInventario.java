import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Criaturas.Jogador;
import Genericos.Item;
import Itens.EspadaMadeira;

public class TelaEscolhaInventario extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8412116656006131533L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Jogador j = new Jogador();
			j.inventario[0] = new EspadaMadeira();
			j.inventario[1] = new EspadaMadeira();
			TelaEscolhaInventario dialog = new TelaEscolhaInventario(j, false);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	Item itemEscolhido = new Item();
	JLabel lblItem = new JLabel("Tempate");
	int numero = -1;
	/**
	 * Create the dialog.
	 */
	public TelaEscolhaInventario(Jogador jogador, boolean emBatalha) {
		setBounds(100, 100, 530, 390);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		setModal(true);
		
		JButton[] btnItens = new JButton[jogador.inventario.length];
		for (int i = 0,contBlocHor = 0, contBlocVert = 0; i < jogador.inventario.length; i++,contBlocHor++) {
			setNumero(i);
			final int j;
			j = i;
			btnItens[i] = new JButton(jogador.inventario[i].getNome());
			if(contBlocHor+1 > 4)
			{
				contBlocHor = 0;
				contBlocVert++;
			}
			
			btnItens[i].setBounds(10 +(125*(contBlocHor)), 75 +(40*contBlocVert), 120, 33);
		
			btnItens[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					setNumero(j);
					setItemEscolhido(jogador.inventario[j]);
					lblItem.setText("Item: " + jogador.inventario[j].getNome() /*+ " | Numero: " + getNumero()*/);
					lblItem.setVisible(true);
				}
			});
			contentPanel.add(btnItens[i]);
		}
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				lblItem.setVisible(false);
				buttonPane.add(lblItem);
			}
			{
				JButton btnNewButton = new JButton("Informa\u00E7\u00F5es");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						JOptionPane.showMessageDialog(null,getItemEscolhido().informacoes());
					}
				});
				buttonPane.add(btnNewButton);
			}
			{
				JButton okButton = new JButton(textoDeConfirmacao(emBatalha));
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						setVisible(false);
					}
				});
				
				JButton btnEquipar = new JButton("Equipar");
				btnEquipar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							jogador.equiparDoInv(jogador, getNumero());
							lblItem.setVisible(false);
							setItemEscolhido(new Item());
							setNumero(-1);
						if(emBatalha) 
						{
							
							
							setItemEscolhido(new Item());
							setVisible(false);
						}
						else 
						{
							atualizar(btnItens, jogador);
						}
						
					}
				});
				buttonPane.add(btnEquipar);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						setItemEscolhido(new Item());
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public void atualizar(JButton[] btnItens, Jogador jogador) 
	{
		for (int i = 0; i < jogador.inventario.length; i++) {
				btnItens[i].setText(jogador.inventario[i].getNome());
		}
	}
	public String textoDeConfirmacao(boolean emBatalha) 
	{
		if(emBatalha == true) 
		{
			return "Usar";
		}
		else 
		{
			return "Ok";
		}
				
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Item getItemEscolhido() {
		return itemEscolhido;
	}
	public void setItemEscolhido(Item ItemEscohido) {
		this.itemEscolhido = ItemEscohido;
	}
}
