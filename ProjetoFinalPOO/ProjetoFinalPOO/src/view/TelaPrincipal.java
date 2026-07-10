package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;
import javax.swing.JSlider;
import java.awt.Font;

public class TelaPrincipal extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private int[] vetor;
	private JTextField textField;
	private JTextArea txtMensagens;
	private JLabel lblComparacoes;
	private JLabel lblTrocas;
	private JLabel lblTempo;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			TelaPrincipal dialog = new TelaPrincipal();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public TelaPrincipal() {
		setBounds(100, 100, 767, 688);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Algoritmo");
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(31, 69, 60, 24);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Quantidade de elementos:");
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(31, 103, 157, 12);
		contentPanel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Velocidade:");
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(31, 134, 96, 12);
		contentPanel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Comparações:");
		lblNewLabel_4.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(31, 442, 84, 12);
		contentPanel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Trocas:");
		lblNewLabel_5.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(31, 464, 44, 12);
		contentPanel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Tempo:");
		lblNewLabel_6.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNewLabel_6.setBounds(31, 475, 68, 29);
		contentPanel.add(lblNewLabel_6);
		
		//arrumar despois da integração
		lblComparacoes = new JLabel("0");
		lblTrocas = new JLabel("0");
		lblTempo = new JLabel("0 ms");
		
		lblComparacoes.setBounds(120, 439, 60, 20);
		contentPanel.add(lblComparacoes);

		lblTrocas.setBounds(120, 464, 60, 20);
		contentPanel.add(lblTrocas);

		lblTempo.setBounds(120, 480, 80, 20);
		contentPanel.add(lblTempo);
		
		JComboBox<String> comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Bubble Sort", "Insertion Sort", "Selection Sort"}));
		comboBox.setToolTipText("Selecione o algoritmo de ordenação");
		comboBox.setBounds(99, 72, 89, 20);
		contentPanel.add(comboBox);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 128, 255));
		panel.setBounds(0, 0, 753, 55);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel(" VISUALIZADOR DE ALGORITMOS DE ORDENAÇÃO   ");
		lblNewLabel.setFont(new Font("Segoe UI Black", Font.PLAIN, 17));
		lblNewLabel.setBounds(154, 10, 440, 24);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Iniciar");
		btnNewButton.setForeground(new Color(0, 128, 255));
		btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(vetor == null) {
					JOptionPane.showMessageDialog(null, "Primeiro gere um vetor!");
					return;
				}
				String algoritmo = comboBox.getSelectedItem().toString();
				adicionarMensagem("Executando " + algoritmo + "...");
				
				//integração com o C++
				
				
				
			}
		});
		btnNewButton.setBounds(292, 162, 84, 20);
		contentPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Reiniciar");
		btnNewButton_1.setForeground(new Color(0, 128, 255));
		btnNewButton_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vetor = null;
				txtMensagens.setText("");
				adicionarMensagem("Sistema reiniciado.");
			}
		});
		btnNewButton_1.setBounds(409, 162, 84, 20);
		contentPanel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Gerar Vetor");
		btnNewButton_2.setForeground(new Color(0, 128, 255));
		btnNewButton_2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Random random = new Random();
				vetor = new int [20]; // depois podemos pegar esse valor de um JTextField
				for(int i =0; i < vetor.length; i++) {
					vetor[i] = random.nextInt(100);
				}
				adicionarMensagem("Vetor gerado com sucesso!");
			}
		});
		btnNewButton_2.setBounds(152, 162, 110, 20);
		contentPanel.add(btnNewButton_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(128, 128, 255));
		panel_1.setBounds(31, 192, 647, 240);
		contentPanel.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(31, 525, 635, 106);
		contentPanel.add(scrollPane);
		
	    txtMensagens = new JTextArea();
		txtMensagens.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		scrollPane.setViewportView(txtMensagens);
		
		
		
		textField = new JTextField();
		textField.setBounds(187, 100, 96, 18);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JSlider slider = new JSlider();
		slider.setBounds(110, 127, 200, 25);
		contentPanel.add(slider);
		
		JLabel lblNewLabel_7 = new JLabel("Mensagens");
		lblNewLabel_7.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		lblNewLabel_7.setBounds(31, 503, 84, 24);
		contentPanel.add(lblNewLabel_7);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
		}
	}//fim do construtor
	private void adicionarMensagem(String mensagem) {
		txtMensagens.append(mensagem + "\n");
	}
}
