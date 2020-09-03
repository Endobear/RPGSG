import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Criaturas.Esqueleto;
import Genericos.CriaturaHostil;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class TelaEscolhaMonst extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8574216045915060333L;
	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CriaturaHostil[] monst = new CriaturaHostil[] {new Esqueleto(), new Esqueleto(),new Esqueleto(),new Esqueleto(),new Esqueleto(), new Esqueleto(),new Esqueleto(),new Esqueleto(),new Esqueleto()};
			TelaEscolhaMonst dialog = new TelaEscolhaMonst(monst);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	CriaturaHostil criaturaEscohida = new CriaturaHostil();
	JLabel lblMonstro = new JLabel("Tempate");
	int numero;
	/**
	 * Create the dialog.
	 */
	public TelaEscolhaMonst(CriaturaHostil[] criaturas) {
		setBounds(100, 100, 530, 390);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		atualizarLayout(criaturas);
		setModal(true);
		
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				lblMonstro.setVisible(false);
				buttonPane.add(lblMonstro);
			}
			{
				JButton btnNewButton = new JButton("Informa\u00E7\u00F5es");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						JOptionPane.showMessageDialog(null, getCriaturaEscohida().informacoes());
					}
				});
				buttonPane.add(btnNewButton);
			}
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						setVisible(false);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
						setCriaturaEscohida(new CriaturaHostil());
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public CriaturaHostil getCriaturaEscohida() {
		return criaturaEscohida;
	}
	public void setCriaturaEscohida(CriaturaHostil criaturaEscohida) {
		this.criaturaEscohida = criaturaEscohida;
	}
	/**
	 * Faz e posiciona os botões de monstros
	 */
	public void atualizarLayout(CriaturaHostil[] criaturas) 
	{
		
		JButton[] btnMonstros = new JButton[criaturas.length];
		for (int i = 0,contBlocHor = 0, contBlocVert = 0; i < btnMonstros.length; i++,contBlocHor++) {
			setNumero(i);
			final int j;
			j = i;
			
			
			if(contBlocHor+1 > 4)
			{
				contBlocHor = 0;
				contBlocVert++;
			}
			
			
			btnMonstros[i] = new JButton(criaturas[i].getNome());
			
			btnMonstros[i].setBounds(10 +(125*(contBlocHor)), 75 +(40*contBlocVert), 120, 33);
			
			btnMonstros[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					setNumero(j);
					setCriaturaEscohida(criaturas[j]);
					lblMonstro.setText("Monstro Escolhido: " + criaturas[j].getNome());
					lblMonstro.setVisible(true);
				}
			});
			contentPanel.add(btnMonstros[i]);
			if(criaturas[i].isVivo() == false) 
			{
				btnMonstros[i].setVisible(false);
			}
		}
	}
}
