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
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.EtchedBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Quanto_gastei2 extends JFrame {

	private JPanel contentPane;
	private JTextField agua;
	private JTextField aguaM;
	private JTextField energia;
	private JTextField energiaA;
	private JTextField faculdadeN;
	private JTextField escolaB;
	private JTextField net;
	private JTextField tv;
	private JLabel lblCombustvel;
	private JTextField feiraC;
	private JLabel lblEnergiaDeAldeia;
	private JTextField combustivel;
	private JLabel lblCarTo;
	private JTextField cartao;
	private JLabel lblFeiraDoCentro;
	private JTextField feira2;
	private JLabel lblFeira_1;
	private JTextField feira1;
	private JTextField gas;
	private JLabel lblMs;
	private JTextField mes;
	private JButton btnEditar;
	private JButton btnSalvar;
	private JButton btnSair;
	private JLabel lblId;
	private JTextField id;
	private JPanel panel_1;
	private JLabel label;
	private JTextField total;
	Connection con;
	Statement st;
	ResultSet rs;

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
					Quanto_gastei2 frame = new Quanto_gastei2();
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
	public Quanto_gastei2() {
		setTitle("Lembrete");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 348, 665);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(null, "Contas Fixas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 309, 475);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblContaDegua = new JLabel("\u00C1gua");
		lblContaDegua.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContaDegua.setBounds(10, 32, 79, 14);
		panel.add(lblContaDegua);
		
		JLabel lblContaDeLuz = new JLabel("Energia");
		lblContaDeLuz.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblContaDeLuz.setBounds(10, 82, 68, 17);
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
		
		agua = new JTextField();
		agua.addKeyListener(new KeyAdapter() {
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
		agua.setEnabled(false);
		agua.setForeground(Color.RED);
		agua.setFont(new Font("Tahoma", Font.PLAIN, 14));
		agua.setBounds(150, 29, 147, 20);
		panel.add(agua);
		agua.setColumns(10);
		
		aguaM = new JTextField();
		aguaM.addKeyListener(new KeyAdapter() {
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
		aguaM.setEnabled(false);
		aguaM.setForeground(Color.RED);
		aguaM.setFont(new Font("Tahoma", Font.PLAIN, 14));
		aguaM.setColumns(10);
		aguaM.setBounds(150, 54, 147, 20);
		panel.add(aguaM);
		
		energia = new JTextField();
		energia.addKeyListener(new KeyAdapter() {
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
		energia.setEnabled(false);
		energia.setForeground(Color.RED);
		energia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		energia.setColumns(10);
		energia.setBounds(150, 79, 147, 20);
		panel.add(energia);
		
		energiaA = new JTextField();
		energiaA.addKeyListener(new KeyAdapter() {
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
		energiaA.setEnabled(false);
		energiaA.setForeground(Color.RED);
		energiaA.setFont(new Font("Tahoma", Font.PLAIN, 14));
		energiaA.setColumns(10);
		energiaA.setBounds(150, 104, 147, 20);
		panel.add(energiaA);
		
		faculdadeN = new JTextField();
		faculdadeN.addKeyListener(new KeyAdapter() {
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
		faculdadeN.setEnabled(false);
		faculdadeN.setForeground(Color.RED);
		faculdadeN.setFont(new Font("Tahoma", Font.PLAIN, 14));
		faculdadeN.setColumns(10);
		faculdadeN.setBounds(150, 129, 147, 20);
		panel.add(faculdadeN);
		
		escolaB = new JTextField();
		escolaB.addKeyListener(new KeyAdapter() {
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
		escolaB.setEnabled(false);
		escolaB.setForeground(Color.RED);
		escolaB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		escolaB.setColumns(10);
		escolaB.setBounds(150, 154, 147, 20);
		panel.add(escolaB);
		
		net = new JTextField();
		net.addKeyListener(new KeyAdapter() {
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
		net.setEnabled(false);
		net.setForeground(Color.RED);
		net.setFont(new Font("Tahoma", Font.PLAIN, 14));
		net.setColumns(10);
		net.setBounds(150, 179, 147, 20);
		panel.add(net);
		
		tv = new JTextField();
		tv.addKeyListener(new KeyAdapter() {
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
		tv.setEnabled(false);
		tv.setForeground(Color.RED);
		tv.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tv.setColumns(10);
		tv.setBounds(150, 204, 147, 20);
		panel.add(tv);
		
		JLabel lblValor = new JLabel("Valor em R$");
		lblValor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblValor.setBounds(150, 11, 79, 14);
		panel.add(lblValor);
		
		lblCombustvel = new JLabel("Combust\u00EDvel");
		lblCombustvel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCombustvel.setBounds(10, 306, 79, 14);
		panel.add(lblCombustvel);
		
		feiraC = new JTextField();
		feiraC.addKeyListener(new KeyAdapter() {
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
		feiraC.setEnabled(false);
		feiraC.setForeground(Color.RED);
		feiraC.setFont(new Font("Tahoma", Font.PLAIN, 14));
		feiraC.setColumns(10);
		feiraC.setBounds(150, 278, 147, 20);
		panel.add(feiraC);
		
		lblEnergiaDeAldeia = new JLabel("Energia de aldeia");
		lblEnergiaDeAldeia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEnergiaDeAldeia.setBounds(10, 107, 113, 17);
		panel.add(lblEnergiaDeAldeia);
		
		combustivel = new JTextField();
		combustivel.addKeyListener(new KeyAdapter() {
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
		combustivel.setEnabled(false);
		combustivel.setForeground(Color.RED);
		combustivel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		combustivel.setColumns(10);
		combustivel.setBounds(150, 303, 147, 20);
		panel.add(combustivel);
		
		lblCarTo = new JLabel("Cart\u00E3o");
		lblCarTo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCarTo.setBounds(10, 331, 48, 14);
		panel.add(lblCarTo);
		
		cartao = new JTextField();
		cartao.addKeyListener(new KeyAdapter() {
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
		cartao.setEnabled(false);
		cartao.setForeground(Color.RED);
		cartao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cartao.setColumns(10);
		cartao.setBounds(150, 328, 147, 20);
		panel.add(cartao);
		
		feira2 = new JTextField();
		feira2.addKeyListener(new KeyAdapter() {
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
		feira2.setEnabled(false);
		feira2.setForeground(Color.RED);
		feira2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		feira2.setColumns(10);
		feira2.setBounds(150, 254, 147, 20);
		panel.add(feira2);
		
		lblFeira_1 = new JLabel("Feira 2");
		lblFeira_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFeira_1.setBounds(10, 257, 48, 14);
		panel.add(lblFeira_1);
		
		feira1 = new JTextField();
		feira1.addKeyListener(new KeyAdapter() {
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
		feira1.setEnabled(false);
		feira1.setForeground(Color.RED);
		feira1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		feira1.setColumns(10);
		feira1.setBounds(150, 229, 147, 20);
		panel.add(feira1);
		
		JLabel lblguaMineral = new JLabel("\u00C1gua Mineral");
		lblguaMineral.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblguaMineral.setBounds(10, 57, 79, 14);
		panel.add(lblguaMineral);
		
		gas = new JTextField();
		gas.addKeyListener(new KeyAdapter() {
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
		gas.setEnabled(false);
		gas.setForeground(Color.RED);
		gas.setFont(new Font("Tahoma", Font.PLAIN, 14));
		gas.setColumns(10);
		gas.setBounds(150, 353, 147, 20);
		panel.add(gas);
		
		lblFeiraDoCentro = new JLabel("Feira do Centro");
		lblFeiraDoCentro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFeiraDoCentro.setBounds(10, 281, 94, 14);
		panel.add(lblFeiraDoCentro);
		
		lblMs = new JLabel("M\u00EAs");
		lblMs.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMs.setBounds(10, 381, 48, 14);
		panel.add(lblMs);
		
		mes = new JTextField();
		mes.setEnabled(false);
		mes.setForeground(Color.RED);
		mes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mes.setColumns(10);
		mes.setBounds(150, 378, 147, 20);
		panel.add(mes);
		
		btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEditar.setEnabled(false);
				btnSalvar.setEnabled(true);
				agua.setEnabled(true);
				aguaM.setEnabled(true);
				energia.setEnabled(true);
				energiaA.setEnabled(true);
				faculdadeN.setEnabled(true);
				escolaB.setEnabled(true);
				net.setEnabled(true);
				tv.setEnabled(true);
				feira1.setEnabled(true);
				feira2.setEnabled(true);
				feiraC.setEnabled(true);
				combustivel.setEnabled(true);
				cartao.setEnabled(true);
				gas.setEnabled(true);
				mes.setEnabled(true);
			}
		});
		btnEditar.setBounds(10, 441, 89, 23);
		panel.add(btnEditar);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(agua.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o campo agua!");
				}
				else if(aguaM.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o campo agua mineral!");
				}
				else if(energia.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o campo energia!");
				}
				else if(energiaA.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o campo energia de Aldeia!");
				}
				else if(faculdadeN.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o campo faculdade de Nathaly!");
				}
				else if(escolaB.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o campo escola de Beatriz!");
				}
				else if(net.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o campo internet!");
				}
				else if(tv.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o campo agua tv por assinatura!");
				}
				else if(feira1.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o campo feira 1!");
				}
				else if(feira2.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o campo feira 2!");
				}
				else if(feiraC.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o campo feira do centro!");
				}
				else if(combustivel.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o campo combustivel!");
				}
				else if(cartao.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o campo cartão!");
				}
				else if(gas.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o campo gás!");
				}
				else if(mes.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o campo Mês!");
				}

				else {

				try {		
					Connection con = Conexao.faz_conexao();
					
					String sql = "update gastos_extras2 set agua=?, aguaM=?, energia=? , energiaA=? , faculdadeN=? , escolaB=? , net=? , tv=? , feira1=? , feira2=? , feiraC=? , combustivel=? , cartao=? , gas=? , mes=? where codigo=?";
					PreparedStatement stmt = con.prepareStatement(sql);
					
					stmt.setString(1, agua.getText());
					stmt.setString(2, aguaM.getText());
					stmt.setString(3, energia.getText());
					stmt.setString(4, energiaA.getText());
					stmt.setString(5, faculdadeN.getText());
					stmt.setString(6, escolaB.getText());
					stmt.setString(7, net.getText());
					stmt.setString(8, tv.getText());
					stmt.setString(9, feira1.getText());
					stmt.setString(10, feira2.getText());
					stmt.setString(11, feiraC.getText());
					stmt.setString(12, combustivel.getText());
					stmt.setString(13, cartao.getText());
					stmt.setString(14, gas.getText());
					stmt.setString(15, mes.getText());
					stmt.setString(16, id.getText());

			
					stmt.execute();
					
					stmt.close();
					con.close();
					JOptionPane.showMessageDialog(null, "Lembrete editado com sucesso!!!");
					Quanto_gastei2.this.dispose();

					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			}
		});
		btnSalvar.setEnabled(false);
		btnSalvar.setBounds(109, 441, 89, 23);
		panel.add(btnSalvar);
		
		btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Quanto_gastei2.this.dispose();
			}
		});
		btnSair.setBounds(208, 441, 89, 23);
		panel.add(btnSair);
		
		lblId = new JLabel("Id");
		lblId.setBounds(10, 416, 48, 14);
		panel.add(lblId);
		
		id = new JTextField();
		id.setEditable(false);
		id.setFont(new Font("Tahoma", Font.PLAIN, 14));
		id.setEnabled(false);
		id.setColumns(10);
		id.setBounds(150, 409, 147, 20);
		panel.add(id);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(null, "Somas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(10, 497, 309, 100);
		contentPane.add(panel_1);
		
		label = new JLabel("Gastos Totais");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(10, 22, 82, 14);
		panel_1.add(label);
		
		total = new JTextField();
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/sealf", "root", "");
			st = con.createStatement();
			String s = "select * from gastos_extras2";
			rs = st.executeQuery(s);
			while(rs.next()){
				id.setText(rs.getString("codigo"));
				agua.setText(rs.getString("agua"));
				aguaM.setText(rs.getString("aguaM"));
				energia.setText(rs.getString("energia"));
				energiaA.setText(rs.getString("energiaA"));
				faculdadeN.setText(rs.getString("faculdadeN"));
				escolaB.setText(rs.getString("escolaB"));
				net.setText(rs.getString("net"));
				tv.setText(rs.getString("tv"));
				feira1.setText(rs.getString("feira1"));
				feira2.setText(rs.getString("feira2"));
				feiraC.setText(rs.getString("feiraC"));
				combustivel.setText(rs.getString("combustivel"));
				cartao.setText(rs.getString("cartao"));
				gas.setText(rs.getString("gas"));
				mes.setText(rs.getString("mes"));
				
				total.setText("R$ "+new String().valueOf(Float.parseFloat(agua.getText()) + Float.parseFloat(aguaM.getText()) + Float.parseFloat(energia.getText()) + Float.parseFloat(energiaA.getText()) + Float.parseFloat(faculdadeN.getText()) + Float.parseFloat(escolaB.getText()) + Float.parseFloat(net.getText()) + Float.parseFloat(tv.getText()) + Float.parseFloat(feira1.getText()) + Float.parseFloat(feira2.getText()) + Float.parseFloat(feiraC.getText()) + Float.parseFloat(combustivel.getText()) + Float.parseFloat(cartao.getText()) + Float.parseFloat(gas.getText())));
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
		
		total.setForeground(Color.RED);
		total.setFont(new Font("Tahoma", Font.BOLD, 18));
		total.setEditable(false);
		total.setColumns(10);
		total.setBounds(10, 47, 274, 29);
		panel_1.add(total);
	}
}
