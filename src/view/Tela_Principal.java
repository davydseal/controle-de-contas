package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class Tela_Principal extends JFrame {

	private JPanel contentPane;

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
					Tela_Principal frame = new Tela_Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	Cadastro_operador Cadastro_operador;
	Ganhos_bolos Ganhos_bolos;
	Ganhos_extras Ganhos_extras;
	Gastos_bolos Gastos_bolos;
	Gastos_extras Gastos_extras;
	//Quanto_gastei Quanto_gastei;
	Gastos Gastos;
	Ganhos Ganhos;
	Relatorio Relatorio;
	Feira2 Feira2;
	Controle_gas Controle_gas;
	Ganhos_apts Ganhos_apts;
	private JTextField conta;
	private JTextField nubank;
	private JTextField poupanca;
	private JTextField aplicacao;
	private JTextField euro;
	private JTextField balde;
	Connection con;
	Statement st;
	ResultSet rs;
	private JTextField cotacao;
	private JTextField valorR;
	private JTextField total;
	private JTextField id;


	/**
	 * Create the frame.
	 */
	public Tela_Principal() {
		setTitle("Seal System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setBounds(100, 100, 1385, 740);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArquivo = new JMenu("Arquivo");
		mnArquivo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnArquivo);
		
		JMenuItem mntmCalculadora = new JMenuItem("Calculadora");
		mntmCalculadora.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mntmCalculadora.setIcon(new ImageIcon(Tela_Principal.class.getResource("/img/Calculator_30001.png")));
		mntmCalculadora.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Runtime.getRuntime().exec("calc.exe");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnArquivo.add(mntmCalculadora);
		
		JMenuItem mntmBlocoDeNotas = new JMenuItem("Bloco de Notas");
		mntmBlocoDeNotas.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mntmBlocoDeNotas.setIcon(new ImageIcon(Tela_Principal.class.getResource("/img/bloc_notes_21874.png")));
		mntmBlocoDeNotas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Runtime.getRuntime().exec("notepad.exe");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnArquivo.add(mntmBlocoDeNotas);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mntmSair.setIcon(new ImageIcon(Tela_Principal.class.getResource("/img/icons8-desligar-32.png")));
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnArquivo.add(mntmSair);
		
		JMenu mnCadastro = new JMenu("Cadastrar");
		mnCadastro.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnCadastro);
		
		JMenuItem mntmCadastrarOperador = new JMenuItem("Cadastrar Usu\u00E1rio");
		mntmCadastrarOperador.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mntmCadastrarOperador.setIcon(new ImageIcon(Tela_Principal.class.getResource("/img/icons8-adicionar-usu\u00E1rio-masculino-32.png")));
		mntmCadastrarOperador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Cadastro_operador == null) 
				{
					Cadastro_operador = new Cadastro_operador();
					Cadastro_operador.setLocationRelativeTo(null);
				}
				Cadastro_operador.setVisible(true);
				//Cadastro_operador exibir = new Cadastro_operador();
				//exibir.setVisible(true);
				//exibir.setLocationRelativeTo(null);
			}
		});
		mnCadastro.add(mntmCadastrarOperador);
		
		JMenu mnReceitas = new JMenu("Quanto eu Ganhei?");
		mnReceitas.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnReceitas);
		
		JMenuItem mntmReceitas = new JMenuItem("Sal\u00E1rio");
		mntmReceitas.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mntmReceitas.setIcon(new ImageIcon(Tela_Principal.class.getResource("/img/ic_attach_money_128_28210.png")));
		mntmReceitas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Ganhos == null) 
				{
					Ganhos = new Ganhos();
					Ganhos.setLocationRelativeTo(null);
				}
				Ganhos.setVisible(true);
				//Receitas exibir = new Receitas();
				//exibir.setVisible(true);
				//exibir.setLocationRelativeTo(null);
			}
		});
		mnReceitas.add(mntmReceitas);
		
		JMenuItem mntmBolos = new JMenuItem("Bolo");
		mntmBolos.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mntmBolos.setIcon(new ImageIcon(Tela_Principal.class.getResource("/img/Cake_ChocolateCake_26374.png")));
		mntmBolos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Ganhos_bolos == null) 
				{
					Ganhos_bolos = new Ganhos_bolos();
					Ganhos_bolos.setLocationRelativeTo(null);
				}
				Ganhos_bolos.setVisible(true);
				//Ganhos_bolos exibir = new Ganhos_bolos();
				//exibir.setVisible(true);
				//exibir.setLocationRelativeTo(null);
			}
		});
		
		JMenuItem mntmGanhosExtras = new JMenuItem("Extras");
		mntmGanhosExtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Ganhos_extras == null) 
				{
					Ganhos_extras = new Ganhos_extras();
					Ganhos_extras.setLocationRelativeTo(null);
				}
				Ganhos_extras.setVisible(true);
				//Ganhos_extras exibir = new Ganhos_extras();
				//exibir.setVisible(true);
				//exibir.setLocationRelativeTo(null);
			}
		});
		
		JMenuItem mntmApartamentos = new JMenuItem("Apartamentos");
		mntmApartamentos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Ganhos_apts == null) 
				{
					Ganhos_apts = new Ganhos_apts();
					Ganhos_apts.setLocationRelativeTo(null);
				}
				Ganhos_apts.setVisible(true);
				//Receitas exibir = new Receitas();
				//exibir.setVisible(true);
				//exibir.setLocationRelativeTo(null);
			}
		});
		mntmApartamentos.setIcon(new ImageIcon(Tela_Principal.class.getResource("/img/icons8-editar-propriedade-32.png")));
		mnReceitas.add(mntmApartamentos);
		mntmGanhosExtras.setIcon(new ImageIcon(Tela_Principal.class.getResource("/img/money_dollar_cash_coins_riches_wealth_icon-icons.com_53585 (1).png")));
		mntmGanhosExtras.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnReceitas.add(mntmGanhosExtras);
		mnReceitas.add(mntmBolos);
		
		JMenu mnGastos = new JMenu("Quanto eu Gastei?");
		mnGastos.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnGastos);
		
		JMenuItem mntmDispesas = new JMenuItem("Gastos Fixos");
		mntmDispesas.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mntmDispesas.setIcon(new ImageIcon(Tela_Principal.class.getResource("/img/file-warning_40447.png")));
		mntmDispesas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Gastos == null) 
				{
					Gastos = new Gastos();
					Gastos.setLocationRelativeTo(null);
				}
				Gastos.setVisible(true);
				//Quanto_gastei exibir = new Quanto_gastei();
				//exibir.setVisible(true);
				//exibir.setLocationRelativeTo(null);
			}
		});
		mnGastos.add(mntmDispesas);
		
		JMenuItem mntmBolos_1 = new JMenuItem("Gastos do Bolo");
		mntmBolos_1.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mntmBolos_1.setIcon(new ImageIcon(Tela_Principal.class.getResource("/img/recipedessertcakeicon_109876.png")));
		mntmBolos_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Gastos_bolos == null) 
				{
					Gastos_bolos = new Gastos_bolos();
					Gastos_bolos.setLocationRelativeTo(null);
				}
				Gastos_bolos.setVisible(true);
				//Gastos_bolos exibir = new Gastos_bolos();
				//exibir.setVisible(true);
				//exibir.setLocationRelativeTo(null);
			}
		});
		
		JMenuItem mntmGastosExtras = new JMenuItem("Gastos Extras");
		mntmGastosExtras.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mntmGastosExtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Gastos_extras == null) 
				{
					Gastos_extras = new Gastos_extras();
					Gastos_extras.setLocationRelativeTo(null);
				}
				Gastos_extras.setVisible(true);
				//Gastos_extras exibir = new Gastos_extras();
				//exibir.setVisible(true);
				//exibir.setLocationRelativeTo(null);
			}
		});
		
		JMenuItem mntmGastosFeira = new JMenuItem("Alimentos P\u00F3s Feira");
		mntmGastosFeira.setIcon(new ImageIcon(Tela_Principal.class.getResource("/img/32395greensalad_98843.png")));
		mntmGastosFeira.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Feira2 == null) 
				{
					Feira2 = new Feira2();
					Feira2.setLocationRelativeTo(null);
				}
				Feira2.setVisible(true);
			}
		});
		mntmGastosFeira.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mnGastos.add(mntmGastosFeira);
		mntmGastosExtras.setIcon(new ImageIcon(Tela_Principal.class.getResource("/img/recipepizzaicon_109877.png")));
		mnGastos.add(mntmGastosExtras);
		mnGastos.add(mntmBolos_1);
		
		JMenu mnControle = new JMenu("Controle");
		mnControle.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnControle);
		
		JMenuItem mntmGs = new JMenuItem("Controle do G\u00E1s");
		mntmGs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Controle_gas == null) 
				{
					Controle_gas = new Controle_gas();
					Controle_gas.setLocationRelativeTo(null);
				}
				Controle_gas.setVisible(true);
			}
		});
		mntmGs.setIcon(new ImageIcon(Tela_Principal.class.getResource("/img/5_97257.png")));
		mnControle.add(mntmGs);
		
		JMenu mnRelatrios = new JMenu("Relat\u00F3rios");
		mnRelatrios.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		menuBar.add(mnRelatrios);
		
		JMenuItem mntmGanhos = new JMenuItem("Consultar");
		mntmGanhos.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		mntmGanhos.setIcon(new ImageIcon(Tela_Principal.class.getResource("/img/business_salesreport_salesreport_negocio_2353.png")));
		mntmGanhos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Relatorio == null) 
				{
					Relatorio = new Relatorio();
					Relatorio.setLocationRelativeTo(null);
				}
				Relatorio.setVisible(true);
				//Relatorio exibir = new Relatorio();
				//exibir.setVisible(true);
				//exibir.setLocationRelativeTo(null);
			}
		});
		mnRelatrios.add(mntmGanhos);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 630, 1369, 56);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblControleFinanceiro = new JLabel("Controle Financeiro");
		lblControleFinanceiro.setForeground(Color.ORANGE);
		lblControleFinanceiro.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblControleFinanceiro.setBounds(605, 15, 159, 14);
		panel.add(lblControleFinanceiro);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Conta", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(52, 59, 200, 224);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblR = new JLabel("R$");
		lblR.setBounds(10, 33, 48, 14);
		panel_1.add(lblR);
		
		conta = new JTextField();
		conta.setEnabled(false);
		conta.setBounds(10, 58, 180, 30);
		panel_1.add(conta);
		conta.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Nubank", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(262, 59, 200, 224);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel label = new JLabel("R$");
		label.setBounds(10, 33, 48, 14);
		panel_2.add(label);
		
		nubank = new JTextField();
		nubank.setEnabled(false);
		nubank.setColumns(10);
		nubank.setBounds(10, 58, 180, 30);
		panel_2.add(nubank);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Poupan\u00E7a", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(472, 59, 200, 224);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel label_1 = new JLabel("R$");
		label_1.setBounds(10, 33, 48, 14);
		panel_3.add(label_1);
		
		poupanca = new JTextField();
		poupanca.setEnabled(false);
		poupanca.setColumns(10);
		poupanca.setBounds(10, 58, 180, 30);
		panel_3.add(poupanca);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(null, "Aplica\u00E7\u00E3o", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(682, 59, 200, 224);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel label_2 = new JLabel("R$");
		label_2.setBounds(10, 33, 48, 14);
		panel_4.add(label_2);
		
		aplicacao = new JTextField();
		aplicacao.setEnabled(false);
		aplicacao.setColumns(10);
		aplicacao.setBounds(10, 58, 180, 30);
		panel_4.add(aplicacao);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(null, "Euro", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(892, 59, 200, 224);
		contentPane.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel label_3 = new JLabel("\u00A3");
		label_3.setBounds(10, 33, 48, 14);
		panel_5.add(label_3);
		
		euro = new JTextField();
		euro.setEnabled(false);
		euro.setColumns(10);
		euro.setBounds(10, 58, 80, 30);
		panel_5.add(euro);
		
		cotacao = new JTextField();
		cotacao.setEnabled(false);
		cotacao.setColumns(10);
		cotacao.setBounds(110, 58, 80, 30);
		panel_5.add(cotacao);
		
		valorR = new JTextField();
		valorR.setEnabled(false);
		valorR.setColumns(10);
		valorR.setBounds(10, 127, 180, 30);
		panel_5.add(valorR);
		
		JLabel lblValorEmR = new JLabel("Valor em R$");
		lblValorEmR.setBounds(10, 102, 80, 14);
		panel_5.add(lblValorEmR);
		
		JLabel lblCotao = new JLabel("Cota\u00E7\u00E3o");
		lblCotao.setBounds(110, 33, 48, 14);
		panel_5.add(lblCotao);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBorder(new TitledBorder(null, "Balde", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_6.setBackground(Color.WHITE);
		panel_6.setBounds(1102, 59, 200, 224);
		contentPane.add(panel_6);
		panel_6.setLayout(null);
		
		JLabel label_4 = new JLabel("R$");
		label_4.setBounds(10, 33, 48, 14);
		panel_6.add(label_4);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(Color.WHITE);
		panel_8.setBounds(52, 471, 1250, 79);
		contentPane.add(panel_8);
		panel_8.setLayout(null);
		
		id = new JTextField();
		id.setEditable(false);
		id.setBounds(10, 30, 48, 38);
		panel_8.add(id);
		id.setColumns(10);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(10, 11, 48, 14);
		panel_8.add(lblId);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {		
					Connection con = Conexao.faz_conexao();
					
					String sql = "update capital set conta=?, nubank=?, poupanca=?, aplicacao=?, euro=?, cotacao=?, balde=? where codigo=?";
					PreparedStatement stmt = con.prepareStatement(sql);
					
					stmt.setString(1, conta.getText());
					stmt.setString(2, nubank.getText());
					stmt.setString(3, poupanca.getText());
					stmt.setString(4, aplicacao.getText());
					stmt.setString(5, euro.getText());
					stmt.setString(6, cotacao.getText());
					stmt.setString(7, balde.getText());
					stmt.setString(8, id.getText());

			
					stmt.execute();
					
					stmt.close();
					con.close();
					JOptionPane.showMessageDialog(null, "Capital salvo com sucesso!!!");
					
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSalvar.setEnabled(false);
		btnSalvar.setBounds(465, 11, 100, 57);
		panel_8.add(btnSalvar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEditar.setEnabled(false);
				btnSalvar.setEnabled(true);
				conta.setEnabled(true);
				nubank.setEnabled(true);
				poupanca.setEnabled(true);
				aplicacao.setEnabled(true);
				euro.setEnabled(true);
				cotacao.setEnabled(true);
				balde.setEnabled(true);
			}
		});
		btnEditar.setBounds(575, 11, 100, 57);
		panel_8.add(btnEditar);
		
		JButton btnResetar = new JButton("Resetar");
		btnResetar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnResetar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEditar.setEnabled(true);
				btnSalvar.setEnabled(false);
				conta.setEnabled(false);
				nubank.setEnabled(false);
				poupanca.setEnabled(false);
				aplicacao.setEnabled(false);
				euro.setEnabled(false);
				cotacao.setEnabled(false);
				balde.setEnabled(false);
			}
		});
		btnResetar.setBounds(685, 11, 100, 57);
		panel_8.add(btnResetar);
		
		balde = new JTextField();
		balde.setEnabled(false);
		balde.setColumns(10);
		balde.setBounds(10, 58, 180, 30);
		panel_6.add(balde);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.WHITE);
		panel_7.setBounds(52, 294, 1250, 166);
		contentPane.add(panel_7);
		panel_7.setLayout(null);
		
		total = new JTextField();
		total.setHorizontalAlignment(SwingConstants.CENTER);
		total.setFont(new Font("Tahoma", Font.PLAIN, 80));
		total.setForeground(Color.BLUE);
		total.setEditable(false);
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/sealf", "root", "");
			st = con.createStatement();
			String s = "select * from capital";
			rs = st.executeQuery(s);
			while(rs.next()){
				id.setText(rs.getString("codigo"));
				conta.setText(rs.getString("conta"));
				nubank.setText(rs.getString("nubank"));
				poupanca.setText(rs.getString("poupanca"));
				aplicacao.setText(rs.getString("aplicacao"));
				euro.setText(rs.getString("euro"));
				cotacao.setText(rs.getString("cotacao"));
				balde.setText(rs.getString("balde"));
				
				
				
				valorR.setText(new String().valueOf(Float.parseFloat(euro.getText()) * Float.parseFloat(cotacao.getText())));
				total.setText("R$ "+new String().valueOf(Float.parseFloat(conta.getText()) + Float.parseFloat(nubank.getText()) + Float.parseFloat(poupanca.getText()) + Float.parseFloat(aplicacao.getText()) + Float.parseFloat(valorR.getText()) + Float.parseFloat(balde.getText())));
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
		total.setBounds(10, 11, 1230, 112);
		panel_7.add(total);
		total.setColumns(10);
		
		
		
		
	}
}
