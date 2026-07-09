package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSlider;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;

public class TelaPrincipalAnimacao extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private int [] vetor;
	private JTextArea txtMensagens;
	private JLabel lblComparacoes;
	private JLabel lblTrocas;
	private JLabel lblTempo;
	private JSlider slider = new JSlider();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipalAnimacao frame = new TelaPrincipalAnimacao();
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
	public TelaPrincipalAnimacao() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 759, 677);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox <String>comboBox = new JComboBox<String>();
		comboBox.setBounds(102, 73, 111, 20);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Bubble Sort", "Insertion Sort", "Selection Sort"}));
		contentPane.add(comboBox);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 722, 53);
		panel.setBackground(new Color(128, 128, 255));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("VISUALIZADOR DE ALGORITMO DE ORDENAÇÃO");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
		lblNewLabel.setBounds(186, 0, 366, 37);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Algoritmo:");
		lblNewLabel_1.setBounds(20, 75, 89, 14);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Quantidade de elementos:");
		lblNewLabel_2.setBounds(20, 110, 160, 12);
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Velocidade:");
		lblNewLabel_3.setBounds(20, 151, 106, 12);
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(177, 108, 96, 18);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Gerar Vetor");
		btnNewButton.setBounds(20, 226, 106, 20);
		btnNewButton.setForeground(new Color(64, 0, 128));
		btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Random random = new Random();
				vetor = new int [20]; // depois podemos pegar esse valor de um JTextField
				for(int i =0; i < vetor.length; i++) {
					vetor[i] = random.nextInt(100);
				}
				adicionarMensagem("Vetor gerado com sucesso!");
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Iniciar");
		btnNewButton_1.setBounds(157, 226, 84, 20);
		btnNewButton_1.setForeground(new Color(64, 0, 128));
		btnNewButton_1.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(vetor == null) {
					JOptionPane.showMessageDialog(null, "Primeiro gere um vetor!");
					return;
				}
				
			
				String algoritmo = comboBox.getSelectedItem().toString();
				int velocidade = slider.getValue();
				
	
				adicionarMensagem("Executando " + algoritmo + "...");
				adicionarMensagem("Velocidade: " + velocidade);
				//integração com o C++
				
				
				
			}
			
		});
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Reiniciar");
		btnNewButton_2.setBounds(269, 226, 84, 20);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vetor = null;
				txtMensagens.setText("");
				adicionarMensagem("Sistema reiniciado.");
			}

			
		});
		btnNewButton_2.setForeground(new Color(64, 0, 128));
		btnNewButton_2.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		contentPane.add(btnNewButton_2);
		
		slider = new JSlider();
		slider.setToolTipText("");
		slider.setBounds(91, 151, 200, 25);
		slider.setMinimum(1);
		slider.setMaximum(100);
		slider.setValue(50); // velocidade inicial
		contentPane.add(slider);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(20, 256, 675, 196);
		panel_1.setBackground(new Color(179, 231, 255));
		contentPane.add(panel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 532, 675, 98);
		contentPane.add(scrollPane);
		
		txtMensagens = new JTextArea();
		txtMensagens.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		scrollPane.setViewportView(txtMensagens);
		txtMensagens.setText("Mensagens\n");
		
		lblComparacoes = new JLabel("Comparações:     0");
		lblComparacoes.setBounds(20, 462, 150, 12);
		lblComparacoes.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		contentPane.add(lblComparacoes);

		lblTrocas = new JLabel("Trocas:     0");
		lblTrocas.setBounds(20, 478, 150, 12);
		lblTrocas.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		contentPane.add(lblTrocas);

		lblTempo = new JLabel("Tempo:    0 ms");
		lblTempo.setBounds(20, 500, 150, 12);
		lblTempo.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		contentPane.add(lblTempo);
		
		JLabel lblNewLabel_4 = new JLabel("Lenta");
		lblNewLabel_4.setBounds(91, 173, 44, 12);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Rápida");
		lblNewLabel_5.setBounds(255, 173, 44, 12);
		contentPane.add(lblNewLabel_5);

	}//fim do construtor
	private void adicionarMensagem(String mensagem) {
		txtMensagens.append(mensagem + "\n");
	}

}
