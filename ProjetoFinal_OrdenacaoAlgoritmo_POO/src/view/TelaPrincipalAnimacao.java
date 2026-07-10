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

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Image;
import javax.swing.SwingConstants;

import javax.swing.border.TitledBorder;

import controller.OrdenacaoController;
import model.Estatisticas;

import javax.swing.border.EtchedBorder;

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
	private JPanel panelAnimacao;
	private JComboBox<String> comboBox;
	
	

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
		setBounds(100, 100, 803, 746);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(210, 210, 210));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox <String>comboBox = new JComboBox<String>();
		comboBox.setBounds(87, 73, 111, 20);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Bubble Sort", "Insertion Sort", "Selection Sort"}));
		contentPane.add(comboBox);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 789, 38);
		panel.setBackground(new Color(255, 255, 255));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("VISUALIZADOR DE ALGORITMO DE ORDENAÇÃO");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
		lblNewLabel.setBounds(105, 0, 465, 37);
		panel.add(lblNewLabel);
		
		ImageIcon icon = new ImageIcon(TelaPrincipalAnimacao.class.getResource("/imagens/grafico.png"));

		Image imagem = icon.getImage().getScaledInstance(80, 40, Image.SCALE_SMOOTH);

		JLabel lblNewLabel_6 = new JLabel();
		lblNewLabel_6.setIcon(new ImageIcon(imagem));
		lblNewLabel_6.setBounds(23, 0, 72, 37);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_1 = new JLabel("Algoritmo:");
		lblNewLabel_1.setBounds(10, 75, 89, 14);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Quantidade de elementos:");
		lblNewLabel_2.setBounds(231, 72, 180, 20);
		lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 12));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Velocidade:");
		lblNewLabel_3.setBounds(10, 134, 106, 12);
		lblNewLabel_3.setFont(new Font("Segoe UI", Font.BOLD, 12));
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setBounds(390, 71, 130, 25);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Gerar Vetor");
		btnNewButton.setBounds(115, 222, 106, 20);
		btnNewButton.setForeground(new Color(0, 128, 255));
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		            int quantidade = Integer.parseInt(textField.getText());

		            if (quantidade <= 0) {
		                JOptionPane.showMessageDialog(null,
		                        "Digite uma quantidade maior que zero!");
		                return;
		            }

		            Random random = new Random();
		            vetor = new int[quantidade];

		            for (int i = 0; i < vetor.length; i++) {
		                vetor[i] = random.nextInt(100);
		            }

		            adicionarMensagem("Vetor gerado com sucesso!");
		            adicionarMensagem("Quantidade de elementos: " + quantidade);

		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(null,
		                    "Digite um número válido na quantidade de elementos.");
		        }
		    }
		});
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Iniciar");
		btnNewButton_1.setBounds(231, 222, 84, 20);
		btnNewButton_1.setForeground(new Color(128, 255, 0));
		btnNewButton_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
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

				long inicio = System.currentTimeMillis();

				Estatisticas estatisticas = new Estatisticas();
				OrdenacaoController controller = new OrdenacaoController();

				switch(algoritmo) {
					case "Bubble Sort":
						controller.bubbleSort(vetor, estatisticas);
						break;
					case "Insertion Sort":
						controller.insertionSort(vetor, estatisticas);
						break;
					case "Selection Sort":
						controller.selectionSort(vetor, estatisticas);
					break;
				}

				estatisticas.setTempoMs(System.currentTimeMillis() - inicio);

				lblComparacoes.setText(String.valueOf(estatisticas.getComparacoes()));
				lblTrocas.setText(String.valueOf(String.valueOf(estatisticas.getTrocas())));
				lblTempo.setText(estatisticas.getTempoMs() + " ms");
				adicionarMensagem(algoritmo + " concluído!");			
			}
			
		});
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Reiniciar");
		btnNewButton_2.setBounds(327, 222, 84, 20);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vetor = null;
				txtMensagens.setText("");
				adicionarMensagem("Sistema reiniciado.");
			}

			
		});
		btnNewButton_2.setForeground(new Color(128, 0, 64));
		btnNewButton_2.setFont(new Font("Segoe UI", Font.BOLD, 12));
		contentPane.add(btnNewButton_2);
		
		//daqui
		slider = new JSlider(1, 100, 50);

		slider.setBounds(82, 134, 161, 20);

		slider.setPaintTicks(false);
		slider.setPaintLabels(false);

		contentPane.add(slider);
		
		JLabel lblLenta = new JLabel("Lenta");
		lblLenta.setBounds(87, 156, 40, 20);
		contentPane.add(lblLenta);

		JLabel lblValor = new JLabel("50%");
		lblValor.setBounds(152, 156, 40, 20);
		contentPane.add(lblValor);

		JLabel lblRapida = new JLabel("Rápida");
		lblRapida.setBounds(214, 156, 50, 20);
		contentPane.add(lblRapida);

		slider.addChangeListener(e -> {
		    lblValor.setText(slider.getValue() + "%");
		});//até aqui para deixar limpo o botão slide de velocidade
		
		
		
		
		panelAnimacao = new JPanel();
		panelAnimacao.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Visualiza\u00E7\u00E3o da Ordena\u00E7\u00E3o", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(255, 255, 255)));
		panelAnimacao.setBounds(37, 252, 675, 270);
		panelAnimacao.setBackground(new Color(0, 0, 66));
		contentPane.add(panelAnimacao);
		panelAnimacao.setLayout(null);
		
		//Mensagem dentro do painel
		JLabel lblAguardando = new JLabel("Clique em \"Gerar Vetor\" para iniciar...");
		lblAguardando.setBackground(new Color(192, 192, 192));
		lblAguardando.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblAguardando.setForeground(new Color(128, 128, 128));
		lblAguardando.setBounds(142, 116, 350, 30);

		panelAnimacao.add(lblAguardando);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(260, 542, 452, 124);
		contentPane.add(scrollPane);
		
		scrollPane.setBorder(
			    BorderFactory.createTitledBorder("Mensagens do Algoritmo")
			);
		txtMensagens = new JTextArea();
		txtMensagens.setFont(new Font("Segoe UI", Font.BOLD, 12));
		scrollPane.setViewportView(txtMensagens);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Estat\u00EDsticas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(37, 542, 203, 124);
		contentPane.add(panel_2);
						panel_2.setLayout(null);
				
						lblTempo = new JLabel("Tempo:    0 ms");
						lblTempo.setBounds(10, 32, 82, 16);
						panel_2.add(lblTempo);
						lblTempo.setFont(new Font("Segoe UI", Font.BOLD, 12));
		
				lblTrocas = new JLabel("Trocas:     0");
				lblTrocas.setBounds(10, 47, 63, 17);
				panel_2.add(lblTrocas);
				lblTrocas.setFont(new Font("Segoe UI", Font.BOLD, 12));
				
				lblComparacoes = new JLabel("Comparações:     0");
				lblComparacoes.setBounds(10, 10, 150, 27);
				panel_2.add(lblComparacoes);
				lblComparacoes.setFont(new Font("Segoe UI", Font.BOLD, 12));

		
	}//fim do construtor
	
	//PESSOAL DE GC!!!!
	
	public void adicionarMensagem(String mensagem) {
		txtMensagens.append(mensagem + "\n");
	}
	public int[] getVetor() {
	    return vetor;
	}
	public String getAlgoritmoSelecionado() {
	    return comboBox.getSelectedItem().toString();
	}
	public int getVelocidade() {
	    return slider.getValue();
	}
	public void atualizarComparacoes(int valor) {
	    lblComparacoes.setText("Comparações: " + valor);
	}

	public void atualizarTrocas(int valor) {
	    lblTrocas.setText("Trocas: " + valor);
	}

	public void atualizarTempo(long tempo) {
	    lblTempo.setText("Tempo: " + tempo + " ms");
	}
	public JPanel getPanelAnimacao() {
	    return panelAnimacao;
	}
}
