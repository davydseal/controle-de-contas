package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.EtchedBorder;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Quanto_gastei extends JFrame {

	private JPanel contentPane;
	private JTextField agua;
	private JTextField aguam;
	private JTextField energia;
	private JTextField energiaa;
	private JTextField faculdaden;
	private JTextField escolab;
	private JTextField net;
	private JTextField tv;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JLabel lblCombustvel;
	private JTextField feirac;
	private JTextField textField_11;
	private JLabel lblEnergiaDeAldeia;
	private JTextField combust;
	private JTextField textField_12;
	private JLabel lblCarTo;
	private JTextField cartao;
	private JTextField textField_13;
	private JLabel lblFeiraDoCentro;
	private JTextField feira2;
	private JTextField textField_10;
	private JLabel lblFeira_1;
	private JTextField feira1;
	private JTextField textField_9;
	private JTextField gas;
	private JTextField textField_14;
	private JPanel panel_3;
	private JLabel lblGastosTotais;
	private JTextField total;
	private JLabel lblMs;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Windows".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| javax.swing.UnsupportedLookAndFeelException ex) {
			System.err.println(ex);
		}
				
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Quanto_gastei frame = new Quanto_gastei();
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
	public Quanto_gastei() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Quanto_gastei.class.getResource("/img/file-warning_40447.png")));
		setTitle("Quanto eu Gastei?");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 330, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(null, "Contas Fixas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 294, 451);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblContaDegua = new JLabel("\u00C1gua");
		lblContaDegua.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContaDegua.setBounds(10, 32, 79, 14);
		panel.add(lblContaDegua);
		
		JLabel lblContaDeLuz = new JLabel("Energia");
		lblContaDeLuz.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContaDeLuz.setBounds(10, 82, 68, 14);
		panel.add(lblContaDeLuz);
		
		JLabel lblInternet = new JLabel("Internet");
		lblInternet.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblInternet.setBounds(10, 182, 68, 14);
		panel.add(lblInternet);
		
		JLabel lblFaculdadeDeNathaly = new JLabel("Faculdade de Nathaly");
		lblFaculdadeDeNathaly.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFaculdadeDeNathaly.setBounds(10, 132, 130, 17);
		panel.add(lblFaculdadeDeNathaly);
		
		JLabel lblEscolaDeBeatriz = new JLabel("Escola de Beatriz");
		lblEscolaDeBeatriz.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEscolaDeBeatriz.setBounds(10, 157, 113, 14);
		panel.add(lblEscolaDeBeatriz);
		
		JLabel lblSky = new JLabel("Tv por Assinatura");
		lblSky.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSky.setBounds(10, 207, 113, 14);
		panel.add(lblSky);
		
		JLabel lblGs = new JLabel("G\u00E1s");
		lblGs.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGs.setBounds(10, 356, 48, 14);
		panel.add(lblGs);
		
		JLabel lblFeira = new JLabel("Feira 1");
		lblFeira.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFeira.setBounds(10, 232, 48, 14);
		panel.add(lblFeira);
		
		JLabel lblMdia = new JLabel("M\u00E9dia");
		lblMdia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMdia.setBounds(150, 11, 48, 14);
		panel.add(lblMdia);
		
		agua = new JTextField();
		agua.setForeground(Color.RED);
		agua.setFont(new Font("Tahoma", Font.PLAIN, 14));
		agua.setText("260");
		agua.setEditable(false);
		agua.setBounds(150, 29, 60, 20);
		panel.add(agua);
		agua.setColumns(10);
		
		aguam = new JTextField();
		aguam.setForeground(Color.RED);
		aguam.setFont(new Font("Tahoma", Font.PLAIN, 14));
		aguam.setText("120");
		aguam.setEditable(false);
		aguam.setBounds(150, 54, 60, 20);
		panel.add(aguam);
		aguam.setColumns(10);
		
		energia = new JTextField();
		energia.setForeground(Color.RED);
		energia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		energia.setText("340");
		energia.setEditable(false);
		energia.setBounds(150, 79, 60, 20);
		panel.add(energia);
		energia.setColumns(10);
		
		energiaa = new JTextField();
		energiaa.setForeground(Color.RED);
		energiaa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		energiaa.setText("82");
		energiaa.setEditable(false);
		energiaa.setBounds(150, 104, 60, 20);
		panel.add(energiaa);
		energiaa.setColumns(10);
		
		faculdaden = new JTextField();
		faculdaden.setForeground(Color.RED);
		faculdaden.setFont(new Font("Tahoma", Font.PLAIN, 14));
		faculdaden.setText("642.18");
		faculdaden.setEditable(false);
		faculdaden.setBounds(150, 129, 60, 20);
		panel.add(faculdaden);
		faculdaden.setColumns(10);
		
		escolab = new JTextField();
		escolab.setForeground(Color.RED);
		escolab.setFont(new Font("Tahoma", Font.PLAIN, 14));
		escolab.setText("855");
		escolab.setEditable(false);
		escolab.setBounds(150, 154, 60, 20);
		panel.add(escolab);
		escolab.setColumns(10);
		
		net = new JTextField();
		net.setForeground(Color.RED);
		net.setFont(new Font("Tahoma", Font.PLAIN, 14));
		net.setText("104");
		net.setEditable(false);
		net.setBounds(150, 179, 60, 20);
		panel.add(net);
		net.setColumns(10);
		
		tv = new JTextField();
		tv.setForeground(Color.RED);
		tv.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tv.setText("88");
		tv.setEditable(false);
		tv.setBounds(150, 204, 60, 20);
		panel.add(tv);
		tv.setColumns(10);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char validar=e.getKeyChar();
				if(Character.isLetter(validar)) {
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(null, "Este campo aceita apenas numeros!");
					
				}
			}
		});
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setBounds(220, 29, 60, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char validar=e.getKeyChar();
				if(Character.isLetter(validar)) {
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(null, "Este campo aceita apenas numeros!");
					
				}
			}
		});
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_2.setColumns(10);
		textField_2.setBounds(220, 54, 60, 20);
		panel.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char validar=e.getKeyChar();
				if(Character.isLetter(validar)) {
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(null, "Este campo aceita apenas numeros!");
					
				}
			}
		});
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_3.setColumns(10);
		textField_3.setBounds(220, 79, 60, 20);
		panel.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char validar=e.getKeyChar();
				if(Character.isLetter(validar)) {
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(null, "Este campo aceita apenas numeros!");
					
				}
			}
		});
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_4.setColumns(10);
		textField_4.setBounds(220, 104, 60, 20);
		panel.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char validar=e.getKeyChar();
				if(Character.isLetter(validar)) {
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(null, "Este campo aceita apenas numeros!");
					
				}
			}
		});
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_5.setColumns(10);
		textField_5.setBounds(220, 129, 60, 20);
		panel.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char validar=e.getKeyChar();
				if(Character.isLetter(validar)) {
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(null, "Este campo aceita apenas numeros!");
					
				}
			}
		});
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_6.setColumns(10);
		textField_6.setBounds(220, 154, 60, 20);
		panel.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char validar=e.getKeyChar();
				if(Character.isLetter(validar)) {
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(null, "Este campo aceita apenas numeros!");
					
				}
			}
		});
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_7.setColumns(10);
		textField_7.setBounds(220, 179, 60, 20);
		panel.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char validar=e.getKeyChar();
				if(Character.isLetter(validar)) {
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(null, "Este campo aceita apenas numeros!");
					
				}
			}
		});
		textField_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_8.setColumns(10);
		textField_8.setBounds(220, 204, 60, 20);
		panel.add(textField_8);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblValor.setBounds(220, 11, 48, 14);
		panel.add(lblValor);
		
		lblCombustvel = new JLabel("Combust\u00EDvel");
		lblCombustvel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCombustvel.setBounds(10, 306, 79, 14);
		panel.add(lblCombustvel);
		
		feirac = new JTextField();
		feirac.setForeground(Color.RED);
		feirac.setFont(new Font("Tahoma", Font.PLAIN, 14));
		feirac.setText("200");
		feirac.setEditable(false);
		feirac.setColumns(10);
		feirac.setBounds(150, 278, 60, 20);
		panel.add(feirac);
		
		textField_11 = new JTextField();
		textField_11.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char validar=e.getKeyChar();
				if(Character.isLetter(validar)) {
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(null, "Este campo aceita apenas numeros!");
					
				}
			}
		});
		textField_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_11.setColumns(10);
		textField_11.setBounds(220, 278, 60, 20);
		panel.add(textField_11);
		
		lblEnergiaDeAldeia = new JLabel("Energia de aldeia");
		lblEnergiaDeAldeia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEnergiaDeAldeia.setBounds(10, 107, 113, 14);
		panel.add(lblEnergiaDeAldeia);
		
		combust = new JTextField();
		combust.setForeground(Color.RED);
		combust.setFont(new Font("Tahoma", Font.PLAIN, 14));
		combust.setText("234");
		combust.setEditable(false);
		combust.setColumns(10);
		combust.setBounds(150, 303, 60, 20);
		panel.add(combust);
		
		textField_12 = new JTextField();
		textField_12.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char validar=e.getKeyChar();
				if(Character.isLetter(validar)) {
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(null, "Este campo aceita apenas numeros!");
					
				}
			}
		});
		textField_12.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_12.setColumns(10);
		textField_12.setBounds(220, 303, 60, 20);
		panel.add(textField_12);
		
		lblCarTo = new JLabel("Cart\u00E3o");
		lblCarTo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCarTo.setBounds(10, 331, 48, 14);
		panel.add(lblCarTo);
		
		cartao = new JTextField();
		cartao.setForeground(Color.RED);
		cartao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cartao.setText("60");
		cartao.setEditable(false);
		cartao.setColumns(10);
		cartao.setBounds(150, 328, 60, 20);
		panel.add(cartao);
		
		textField_13 = new JTextField();
		textField_13.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char validar=e.getKeyChar();
				if(Character.isLetter(validar)) {
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(null, "Este campo aceita apenas numeros!");
					
				}
			}
		});
		textField_13.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_13.setColumns(10);
		textField_13.setBounds(220, 328, 60, 20);
		panel.add(textField_13);
		
		feira2 = new JTextField();
		feira2.setForeground(Color.RED);
		feira2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		feira2.setText("500");
		feira2.setEditable(false);
		feira2.setColumns(10);
		feira2.setBounds(150, 254, 60, 20);
		panel.add(feira2);
		
		textField_10 = new JTextField();
		textField_10.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char validar=e.getKeyChar();
				if(Character.isLetter(validar)) {
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(null, "Este campo aceita apenas numeros!");
					
				}
			}
		});
		textField_10.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_10.setColumns(10);
		textField_10.setBounds(220, 254, 60, 20);
		panel.add(textField_10);
		
		lblFeira_1 = new JLabel("Feira 2");
		lblFeira_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFeira_1.setBounds(10, 257, 48, 14);
		panel.add(lblFeira_1);
		
		feira1 = new JTextField();
		feira1.setForeground(Color.RED);
		feira1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		feira1.setText("500");
		feira1.setEditable(false);
		feira1.setColumns(10);
		feira1.setBounds(150, 229, 60, 20);
		panel.add(feira1);
		
		textField_9 = new JTextField();
		textField_9.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char validar=e.getKeyChar();
				if(Character.isLetter(validar)) {
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(null, "Este campo aceita apenas numeros!");
					
				}
			}
		});
		textField_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_9.setColumns(10);
		textField_9.setBounds(220, 229, 60, 20);
		panel.add(textField_9);
		
		JLabel lblguaMineral = new JLabel("\u00C1gua Mineral");
		lblguaMineral.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblguaMineral.setBounds(10, 57, 79, 14);
		panel.add(lblguaMineral);
		
		gas = new JTextField();
		gas.setForeground(Color.RED);
		gas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		gas.setText("180");
		gas.setEditable(false);
		gas.setColumns(10);
		gas.setBounds(150, 353, 60, 20);
		panel.add(gas);
		
		textField_14 = new JTextField();
		textField_14.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char validar=e.getKeyChar();
				if(Character.isLetter(validar)) {
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(null, "Este campo aceita apenas numeros!");
					
				}
			}
		});
		textField_14.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField_14.setColumns(10);
		textField_14.setBounds(220, 353, 60, 20);
		panel.add(textField_14);
		
		lblFeiraDoCentro = new JLabel("Feira do Centro");
		lblFeiraDoCentro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFeiraDoCentro.setBounds(10, 281, 94, 14);
		panel.add(lblFeiraDoCentro);
		
		lblMs = new JLabel("M\u00EAs");
		lblMs.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMs.setBounds(10, 381, 48, 14);
		panel.add(lblMs);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Janeiro", "Fevereiro", "Mar\u00E7o", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"}));
		comboBox.setBounds(150, 377, 130, 20);
		panel.add(comboBox);
		
		JButton btnNewButton = new JButton("Lembrete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Quanto_gastei2 exibir = new Quanto_gastei2();
				exibir.setVisible(true);
				//exibir.setLocationRelativeTo(null);
			}
		});
		btnNewButton.setBounds(102, 417, 89, 23);
		panel.add(btnNewButton);
		
		panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBorder(new TitledBorder(null, "Somas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(10, 473, 294, 127);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		lblGastosTotais = new JLabel("Gastos Totais");
		lblGastosTotais.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGastosTotais.setBounds(10, 22, 82, 14);
		panel_3.add(lblGastosTotais);
		
		total = new JTextField();
		total.setForeground(Color.RED);
		total.setFont(new Font("Tahoma", Font.BOLD, 18));
		total.setText(new String().valueOf(Double.parseDouble(agua.getText()) + Double.parseDouble(aguam.getText()) + Double.parseDouble(energia.getText()) + Double.parseDouble(energiaa.getText()) + Double.parseDouble(faculdaden.getText()) + Double.parseDouble(escolab.getText()) + Double.parseDouble(net.getText()) + Double.parseDouble(tv.getText()) + Double.parseDouble(feira1.getText()) + Double.parseDouble(feira2.getText()) + Double.parseDouble(feirac.getText()) + Double.parseDouble(combust.getText()) + Double.parseDouble(cartao.getText()) + Double.parseDouble(gas.getText())));
		//total.setText(new String().valueOf(Float.parseFloat(agua.getText()) + Float.parseFloat(aguam.getText()) + Float.parseFloat(energia.getText()) + Float.parseFloat(energiaa.getText()) + Float.parseFloat(faculdaden.getText()) + Float.parseFloat(escolab.getText()) + Float.parseFloat(net.getText()) + Float.parseFloat(tv.getText()) + Float.parseFloat(feira1.getText()) + Float.parseFloat(feira2.getText()) + Float.parseFloat(feirac.getText()) + Float.parseFloat(combust.getText()) + Float.parseFloat(cartao.getText()) + Float.parseFloat(gas.getText())));
		
		total.setEditable(false);
		total.setBounds(10, 47, 274, 29);
		panel_3.add(total);
		total.setColumns(10);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(151, 87, 75, 29);
		panel_3.add(btnSair);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Quanto_gastei.this.dispose();
			}
		});
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(66, 87, 75, 29);
		panel_3.add(btnSalvar);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o campo agua!");
				}
				else if(textField_2.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o campo agua mineral!");
				}
				else if(textField_3.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o campo energia!");
				}
				else if(textField_4.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o campo energia de Aldeia!");
				}
				else if(textField_5.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o campo faculdade de Nathaly!");
				}
				else if(textField_6.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o campo escola de Beatriz!");
				}
				else if(textField_7.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o campo internet!");
				}
				else if(textField_8.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o campo agua tv por assinatura!");
				}
				else if(textField_9.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o campo feira 1!");
				}
				else if(textField_10.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o campo feira 2!");
				}
				else if(textField_11.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o campo feira do centro!");
				}
				else if(textField_12.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o campo combustivel!");
				}
				else if(textField_13.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o campo cartão!");
				}
				else if(textField_14.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o campo gás!");
				}
				else if (((String) comboBox.getSelectedItem()).isEmpty()) {
					JOptionPane.showMessageDialog(null, "Selecione o Mês!");
				}

				else {

				try {
					Connection con = Conexao.faz_conexao();
					String sql = "insert into gastos(agua, aguaM, energia, energiaA, faculdadeN, escolaB, net, tv, feira1, feira2, feiraC, combustivel, cartao, gas, mes, status) value (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 1)";
					
					PreparedStatement stmt = con.prepareStatement(sql);
					
					
					stmt.setString(1, textField.getText());
					stmt.setString(2, textField_2.getText());
					stmt.setString(3, textField_3.getText());
					stmt.setString(4, textField_4.getText());
					stmt.setString(5, textField_5.getText());
					stmt.setString(6, textField_6.getText());
					stmt.setString(7, textField_7.getText());
					stmt.setString(8, textField_8.getText());
					stmt.setString(9, textField_9.getText());
					stmt.setString(10, textField_10.getText());
					stmt.setString(11, textField_11.getText());
					stmt.setString(12, textField_12.getText());
					stmt.setString(13, textField_13.getText());
					stmt.setString(14, textField_14.getText());
					stmt.setString(15, (String) comboBox.getSelectedItem());

					
					
					stmt.execute();
					
					stmt.close();
					con.close();
					JOptionPane.showMessageDialog(null, "Dados salvos com sucesso!");
					textField.setText("");
					textField_2.setText("");
					textField_3.setText("");
					textField_4.setText("");
					textField_5.setText("");
					textField_6.setText("");
					textField_7.setText("");
					textField_8.setText("");
					textField_9.setText("");
					textField_10.setText("");
					textField_11.setText("");
					textField_12.setText("");
					textField_13.setText("");
					textField_14.setText("");
					comboBox.setSelectedItem(null); 
			
					
					
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			}
		});
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 16));
	}
}
