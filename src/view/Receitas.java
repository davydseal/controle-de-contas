package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import util.Calcular;
import util.Calcular2;
import util.Calcular3;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Receitas extends JFrame {

	private JPanel contentPane;
	private JTextField data;
	private JTextField txtn1;
	private JTextField txtn2;
	private JTextField txtn3;
	private JTextField txtn4;
	private JTextField txtn5;
	private JTextField resultado;
	private JTextField txtn1e;
	private JTextField txtn2e;
	private JTextField txtn3e;
	private JTextField txtn4e;
	private JTextField txtn5e;
	private JTextField condo1;
	private JTextField condo2;
	private JTextField condo3;
	private JLabel lblCondominio;
	private JTextField resultadocondo;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JTextField aluguel;
	
	Connection con;
	Statement st;
	ResultSet rs;
	private JLabel lblIptu;
	private JTextField iptu1;
	private JTextField iptu2;
	private JTextField iptu3;
	private JTextField iptutotal;
	private JTextField salariot;
	private JLabel lblSomaDoSlario;
	private JLabel lblEntrada;
	private JLabel label;
	private JButton btnNewButton;
	private JLabel lblTotal_1;
	private JTextField resultado2;
	private JButton btnCalcular_1;
	private JTextField textField;
	private JButton btnNewButton_1;
	private JTextField textField_1;
	private JButton btnSalvar;
	private JLabel lblLiquido;
	private JComboBox mes;
	private JLabel lblMs_1;

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
					Receitas frame = new Receitas();
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
	public Receitas() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Receitas.class.getResource("/img/ic_attach_money_128_28210.png")));
		setTitle("Quanto eu ganhei?");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 963, 442);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel_2 = new JPanel();
		panel_2.setBounds(624, 11, 312, 312);
		contentPane.add(panel_2);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(new TitledBorder(null, "S\u00E1lario", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setLayout(null);
		
		JLabel lblSlarioDia = new JLabel("S\u00E1lario dia 10");
		lblSlarioDia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSlarioDia.setBounds(10, 22, 83, 14);
		panel_2.add(lblSlarioDia);
		
		JLabel lblSlarioDia_1 = new JLabel("S\u00E1lario dia 25");
		lblSlarioDia_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSlarioDia_1.setBounds(10, 78, 83, 14);
		panel_2.add(lblSlarioDia_1);
		
		txtn4e = new JTextField();
		txtn4e.setForeground(Color.BLUE);
		txtn4e.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtn4e.setBounds(10, 47, 135, 20);
		panel_2.add(txtn4e);
		txtn4e.setText("4470");
		txtn4e.setEditable(false);
		txtn4e.setColumns(10);
		
		txtn4 = new JTextField();
		txtn4.addKeyListener(new KeyAdapter() {
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
		txtn4.setForeground(Color.BLUE);
		txtn4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtn4.setBounds(155, 47, 135, 20);
		panel_2.add(txtn4);
		txtn4.setColumns(10);
		
		txtn5 = new JTextField();
		txtn5.addKeyListener(new KeyAdapter() {
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
		txtn5.setForeground(Color.BLUE);
		txtn5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtn5.setBounds(155, 103, 135, 20);
		panel_2.add(txtn5);
		txtn5.setColumns(10);
		
		txtn5e = new JTextField();
		txtn5e.setForeground(Color.BLUE);
		txtn5e.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtn5e.setBounds(10, 103, 135, 20);
		panel_2.add(txtn5e);
		txtn5e.setText("3470");
		txtn5e.setEditable(false);
		txtn5e.setColumns(10);
		
		lblEntrada = new JLabel("Entrada");
		lblEntrada.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEntrada.setBounds(155, 22, 48, 14);
		panel_2.add(lblEntrada);
		
		lblSomaDoSlario = new JLabel("Soma dos Sal\u00E1rios");
		lblSomaDoSlario.setBounds(10, 190, 120, 14);
		panel_2.add(lblSomaDoSlario);
		lblSomaDoSlario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		salariot = new JTextField();
		salariot.setBounds(10, 215, 143, 38);
		panel_2.add(salariot);
		salariot.setForeground(Color.BLUE);
		salariot.setFont(new Font("Tahoma", Font.PLAIN, 20));
		salariot.setEditable(false);
		salariot.setColumns(10);
		salariot.setText(new String().valueOf(Float.parseFloat(txtn4e.getText()) + Float.parseFloat(txtn5e.getText())));
		
		resultado = new JTextField();
		resultado.setBounds(163, 215, 127, 38);
		panel_2.add(resultado);
		resultado.setForeground(Color.BLUE);
		resultado.setFont(new Font("Tahoma", Font.PLAIN, 20));
		resultado.setEditable(false);
		resultado.setColumns(10);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setBounds(163, 190, 48, 14);
		panel_2.add(lblTotal);
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		label = new JLabel("Entrada");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(155, 80, 48, 14);
		panel_2.add(label);
		
		JButton btnCalcular = new JButton("calcular");
		btnCalcular.setBounds(55, 264, 96, 37);
		panel_2.add(btnCalcular);
		btnCalcular.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 159, 280, 20);
		panel_2.add(comboBox);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Janeiro", "Fevereiro", "Mar\u00E7o", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"}));
		
		JLabel lblMs = new JLabel("M\u00EAs");
		lblMs.setBounds(10, 134, 48, 14);
		panel_2.add(lblMs);
		lblMs.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnInserir = new JButton("Salvar");
		btnInserir.setBounds(161, 264, 96, 37);
		panel_2.add(btnInserir);
		btnInserir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 
				if(txtn4.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o Sálario do dia 10!");
				}
				else if(txtn5.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o Sálario do dia 25!");
				}
				else if (((String) comboBox.getSelectedItem()).isEmpty()) {
					JOptionPane.showMessageDialog(null, "Selecione o Mês!");
				}
				else if(resultado.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Calcule os valores!");
				}
				else {
				try {
					Connection con = Conexao.faz_conexao();
					String sql = "insert into ganhos_salario(mes, valor, status) value (?, ?, 1)";
					
					PreparedStatement stmt = con.prepareStatement(sql);
					
					
					stmt.setString(1, (String) comboBox.getSelectedItem());
					stmt.setString(2, resultado.getText());	
					
					stmt.execute();
					
					stmt.close();
					con.close();
					JOptionPane.showMessageDialog(null, "Dados salvos com sucesso!");
					txtn4.setText("");
					txtn5.setText("");
					resultado.setText("");
					comboBox.setSelectedItem(null); 
			
					
					
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			}
		});
		btnInserir.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				if(txtn4.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
				}
				else if(txtn5.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
				}
				else {
					
				
				Calcular calc = new Calcular();

				calc.setN4(Float.parseFloat(txtn4.getText()));
				calc.setN5(Float.parseFloat(txtn5.getText()));
				
				resultado.setText(String.valueOf(calc.calcula()));
				}
			}
		});
		panel_3 = new JPanel();
		panel_3.setBounds(10, 11, 604, 312);
		contentPane.add(panel_3);
		panel_3.setBackground(Color.WHITE);
		panel_3.setBorder(new TitledBorder(null, "Apartamentos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setLayout(null);
		
		JLabel lblEstimativa = new JLabel("Aluguel");
		lblEstimativa.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEstimativa.setBounds(149, 42, 58, 14);
		panel_3.add(lblEstimativa);
		
		lblCondominio = new JLabel("Condom\u00EDnio");
		lblCondominio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCondominio.setBounds(258, 42, 74, 14);
		panel_3.add(lblCondominio);
		
		JLabel lblRealidade = new JLabel("Entrada");
		lblRealidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblRealidade.setBounds(470, 42, 67, 14);
		panel_3.add(lblRealidade);
		
		txtn1e = new JTextField();
		txtn1e.setForeground(Color.BLUE);
		txtn1e.setFont(new Font("Tahoma", Font.PLAIN, 14));
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/sealf", "root", "");
			st = con.createStatement();
			String s = "select * from apartamento where codigo = 1";
			rs = st.executeQuery(s);
			while(rs.next()){
				txtn1e.setText(rs.getString("aluguel"));
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR");
		}
		finally 
		{
			try {
				st.close();
				rs.close();
				con.close();
				
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "ERROR CLOSE");
			}
		}
		txtn1e.setBounds(149, 67, 96, 20);
		panel_3.add(txtn1e);
		txtn1e.setEditable(false);
		txtn1e.setColumns(10);
		
		condo1 = new JTextField();
		condo1.setForeground(Color.RED);
		condo1.setFont(new Font("Tahoma", Font.PLAIN, 14));

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/sealf", "root", "");
			st = con.createStatement();
			String s = "select * from apartamento where codigo = 1";
			rs = st.executeQuery(s);
			while(rs.next()){
				condo1.setText(rs.getString("condominio"));
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR");
		}
		finally 
		{
			try {
				st.close();
				rs.close();
				con.close();
				
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "ERROR CLOSE");
			}
		}
		condo1.setBounds(258, 67, 96, 20);
		panel_3.add(condo1);
		condo1.setEditable(false);
		condo1.setColumns(10);
		
		txtn1 = new JTextField();
		txtn1.addKeyListener(new KeyAdapter() {
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
		txtn1.setForeground(Color.BLUE);
		txtn1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtn1.setBounds(470, 67, 96, 20);
		panel_3.add(txtn1);
		txtn1.setColumns(10);
		
		txtn2e = new JTextField();
		txtn2e.setForeground(Color.BLUE);
		txtn2e.setFont(new Font("Tahoma", Font.PLAIN, 14));
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/sealf", "root", "");
			st = con.createStatement();
			String s = "select * from apartamento where codigo = 2";
			rs = st.executeQuery(s);
			while(rs.next()){
				txtn2e.setText(rs.getString("aluguel"));
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR");
		}
		finally 
		{
			try {
				st.close();
				rs.close();
				con.close();
				
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "ERROR CLOSE");
			}
		}
		txtn2e.setBounds(149, 98, 96, 20);
		panel_3.add(txtn2e);
		txtn2e.setEditable(false);
		txtn2e.setColumns(10);
		
		condo2 = new JTextField();
		condo2.setForeground(Color.RED);
		condo2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/sealf", "root", "");
			st = con.createStatement();
			String s = "select * from apartamento where codigo = 2";
			rs = st.executeQuery(s);
			while(rs.next()){
				condo2.setText(rs.getString("condominio"));
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR");
		}
		finally 
		{
			try {
				st.close();
				rs.close();
				con.close();
				
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "ERROR CLOSE");
			}
		}
		condo2.setBounds(258, 98, 96, 20);
		panel_3.add(condo2);
		condo2.setEditable(false);
		condo2.setColumns(10);
		
		txtn2 = new JTextField();
		txtn2.addKeyListener(new KeyAdapter() {
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
		txtn2.setForeground(Color.BLUE);
		txtn2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtn2.setBounds(470, 98, 96, 20);
		panel_3.add(txtn2);
		txtn2.setColumns(10);
		
		txtn3e = new JTextField();
		txtn3e.setForeground(Color.BLUE);
		txtn3e.setFont(new Font("Tahoma", Font.PLAIN, 14));
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/sealf", "root", "");
			st = con.createStatement();
			String s = "select * from apartamento where codigo = 3";
			rs = st.executeQuery(s);
			while(rs.next()){
				txtn3e.setText(rs.getString("aluguel"));
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR");
		}
		finally 
		{
			try {
				st.close();
				rs.close();
				con.close();
				
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "ERROR CLOSE");
			}
		}
		txtn3e.setBounds(149, 129, 96, 20);
		panel_3.add(txtn3e);
		txtn3e.setEditable(false);
		txtn3e.setColumns(10);
		
		condo3 = new JTextField();
		condo3.setForeground(Color.RED);
		condo3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/sealf", "root", "");
			st = con.createStatement();
			String s = "select * from apartamento where codigo = 3";
			rs = st.executeQuery(s);
			while(rs.next()){
				condo3.setText(rs.getString("condominio"));
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR");
		}
		finally 
		{
			try {
				st.close();
				rs.close();
				con.close();
				
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "ERROR CLOSE");
			}
		}
		condo3.setBounds(258, 129, 96, 20);
		panel_3.add(condo3);
		condo3.setEditable(false);
		condo3.setColumns(10);
		
		txtn3 = new JTextField();
		txtn3.addKeyListener(new KeyAdapter() {
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
		txtn3.setForeground(Color.BLUE);
		txtn3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtn3.setBounds(470, 129, 96, 20);
		panel_3.add(txtn3);
		txtn3.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Apt. Violetas");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 70, 129, 14);
		panel_3.add(lblNewLabel_2);
		
		JLabel lblAluguelAptDi = new JLabel("Apt. Di' Bragan\u00E7a");
		lblAluguelAptDi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAluguelAptDi.setBounds(10, 101, 132, 14);
		panel_3.add(lblAluguelAptDi);
		
		JLabel lblAluguelAptSta = new JLabel("Apt. Sta Terezinha");
		lblAluguelAptSta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAluguelAptSta.setBounds(10, 132, 132, 14);
		panel_3.add(lblAluguelAptSta);
		
		lblIptu = new JLabel("Iptu");
		lblIptu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIptu.setBounds(364, 42, 48, 14);
		panel_3.add(lblIptu);
		
		iptu1 = new JTextField();
		iptu1.setForeground(Color.RED);
		iptu1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/sealf", "root", "");
			st = con.createStatement();
			String s = "select * from apartamento where codigo = 1";
			rs = st.executeQuery(s);
			while(rs.next()){
				iptu1.setText(rs.getString("iptu"));
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR");
		}
		finally 
		{
			try {
				st.close();
				rs.close();
				con.close();
				
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "ERROR CLOSE");
			}
		}
		iptu1.setEditable(false);
		iptu1.setBounds(364, 67, 96, 20);
		panel_3.add(iptu1);
		iptu1.setColumns(10);
		
		iptu2 = new JTextField();
		iptu2.setForeground(Color.RED);
		iptu2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/sealf", "root", "");
			st = con.createStatement();
			String s = "select * from apartamento where codigo = 2";
			rs = st.executeQuery(s);
			while(rs.next()){
				iptu2.setText(rs.getString("iptu"));
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR");
		}
		finally 
		{
			try {
				st.close();
				rs.close();
				con.close();
				
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "ERROR CLOSE");
			}
		}
		iptu2.setEditable(false);
		iptu2.setColumns(10);
		iptu2.setBounds(364, 98, 96, 20);
		panel_3.add(iptu2);
		
		iptu3 = new JTextField();
		iptu3.setForeground(Color.RED);
		iptu3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/sealf", "root", "");
			st = con.createStatement();
			String s = "select * from apartamento where codigo = 3";
			rs = st.executeQuery(s);
			while(rs.next()){
				iptu3.setText(rs.getString("iptu"));
			}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "ERROR");
		}
		finally 
		{
			try {
				st.close();
				rs.close();
				con.close();
				
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "ERROR CLOSE");
			}
		}
		iptu3.setEditable(false);
		iptu3.setColumns(10);
		iptu3.setBounds(364, 129, 96, 20);
		panel_3.add(iptu3);
		
		data = new JTextField();
		data.setBounds(513, 11, 81, 20);
		panel_3.add(data);
		data.setFont(new Font("Tahoma", Font.PLAIN, 14));
		data.setEnabled(false);
		data.setEditable(false);
		data.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date(System.currentTimeMillis())));
		data.setColumns(10);
		
		aluguel = new JTextField();
		aluguel.setBounds(149, 160, 96, 20);
		panel_3.add(aluguel);
		aluguel.setForeground(Color.BLUE);
		aluguel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		aluguel.setText("11090.0");
		aluguel.setEditable(false);
		aluguel.setColumns(10);
		aluguel.setText(new String().valueOf(Float.parseFloat(txtn1e.getText()) + Float.parseFloat(txtn2e.getText()) +Float.parseFloat(txtn3e.getText())));
		
		resultadocondo = new JTextField();
		resultadocondo.setBounds(258, 160, 96, 20);
		panel_3.add(resultadocondo);
		resultadocondo.setForeground(Color.RED);
		resultadocondo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		resultadocondo.setEditable(false);
		resultadocondo.setColumns(10);
		resultadocondo.setText(new String().valueOf(Float.parseFloat(condo1.getText()) + Float.parseFloat(condo2.getText())+ Float.parseFloat(condo3.getText())));
		
		iptutotal = new JTextField();
		iptutotal.setBounds(364, 160, 96, 20);
		panel_3.add(iptutotal);
		iptutotal.setForeground(Color.RED);
		iptutotal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		iptutotal.setEditable(false);
		iptutotal.setColumns(10);
		iptutotal.setText(new String().valueOf(Float.parseFloat(iptu1.getText()) + Float.parseFloat(iptu2.getText()) + Float.parseFloat(iptu3.getText())));
		
		btnNewButton = new JButton("Editar Im\u00F3veis");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Receitas.this.dispose();
				Cadastro_apartamento exibir = new Cadastro_apartamento();
				exibir.setVisible(true);
				exibir.setLocationRelativeTo(null);
			}
		});
		btnNewButton.setBounds(10, 243, 129, 37);
		panel_3.add(btnNewButton);
		
		lblTotal_1 = new JLabel("Total");
		lblTotal_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTotal_1.setBounds(10, 165, 48, 14);
		panel_3.add(lblTotal_1);
		
		resultado2 = new JTextField();
		resultado2.setEditable(false);
		resultado2.setForeground(Color.BLUE);
		resultado2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		resultado2.setColumns(10);
		resultado2.setBounds(470, 160, 96, 20);
		panel_3.add(resultado2);
		
		btnCalcular_1 = new JButton("Calcular");
		btnCalcular_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(txtn1.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
				}
				else if(txtn2.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
				}
				else if(txtn3.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
				}
				else {
					
				
				Calcular2 calc = new Calcular2();

				calc.setN1(Float.parseFloat(txtn1.getText()));
				calc.setN2(Float.parseFloat(txtn2.getText()));
				calc.setN3(Float.parseFloat(txtn3.getText()));
				
				resultado2.setText(String.valueOf(calc.calcula()));
				}
			}
		});
		btnCalcular_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCalcular_1.setBounds(149, 243, 96, 37);
		panel_3.add(btnCalcular_1);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setText(new String().valueOf(Float.parseFloat(resultadocondo.getText()) + Float.parseFloat(iptutotal.getText())));
		textField.setFont(textField.getFont().deriveFont(textField.getFont().getSize() + 3f));
		textField.setForeground(Color.RED);
		textField.setEditable(false);
		textField.setBounds(258, 191, 202, 20);
		panel_3.add(textField);
		textField.setColumns(10);
		
		btnNewButton_1 = new JButton("Valor Liquido");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(resultado2.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
				}
				
				else {
					
				
				Calcular3 calc = new Calcular3();

				calc.setN1(Float.parseFloat(resultado2.getText()));
				calc.setN2(Float.parseFloat(textField.getText()));
				
				textField_1.setText(String.valueOf(calc.calcula()));
				}
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBounds(255, 243, 119, 37);
		panel_3.add(btnNewButton_1);
		
		textField_1 = new JTextField();
		textField_1.setForeground(Color.BLUE);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_1.setEditable(false);
		textField_1.setBounds(384, 243, 123, 36);
		panel_3.add(textField_1);
		textField_1.setColumns(10);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (((String) mes.getSelectedItem()).isEmpty()) {
					JOptionPane.showMessageDialog(null, "Selecione o Mês!");
				}
				else if(txtn1.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
				}
				else if(txtn2.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
				}
				else if(txtn3.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
				}
				else if(resultado2.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Calcule os valores!");
				}
				else if(textField_1.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Calcule todos os valores!");
				}
				else {
				try {
					Connection con = Conexao.faz_conexao();
					String sql = "insert into ganhos_apt(mes, valor, status) value (?, ?, 1)";
					
					PreparedStatement stmt = con.prepareStatement(sql);
					
					stmt.setString(1, (String) mes.getSelectedItem());
					stmt.setString(2, textField_1.getText());
					
					
					stmt.execute();
					
					stmt.close();
					con.close();
					JOptionPane.showMessageDialog(null, "Dados salvos com sucesso!");
					txtn1.setText("");
					txtn2.setText("");
					txtn3.setText("");
					resultado2.setText("");
					textField_1.setText("");
					mes.setSelectedItem(null); 
			
					
					
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			}
		});
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSalvar.setBounds(513, 243, 74, 37);
		panel_3.add(btnSalvar);
		
		lblLiquido = new JLabel("Liquido");
		lblLiquido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLiquido.setBounds(384, 212, 48, 20);
		panel_3.add(lblLiquido);
		
		mes = new JComboBox();
		mes.setModel(new DefaultComboBoxModel(new String[] {"", "Janeiro", "Fevereiro", "Mar\u00E7o", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"}));
		mes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mes.setBounds(43, 191, 202, 20);
		panel_3.add(mes);
		
		lblMs_1 = new JLabel("M\u00EAs");
		lblMs_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMs_1.setBounds(10, 194, 24, 14);
		panel_3.add(lblMs_1);
		
		panel_4 = new JPanel();
		panel_4.setBounds(10, 334, 926, 63);
		contentPane.add(panel_4);
		panel_4.setBackground(Color.WHITE);
		panel_4.setBorder(new TitledBorder(null, "Dados", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setLayout(null);
				
				JButton btnSair = new JButton("Sair");
				btnSair.setBounds(426, 13, 74, 37);
				panel_4.add(btnSair);
				btnSair.setFont(new Font("Tahoma", Font.PLAIN, 16));
				btnSair.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Receitas.this.dispose();
					}
				});
	}
}
