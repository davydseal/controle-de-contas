package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Cadastro_operador extends JFrame {

	private JPanel contentPane;
	private JTextField data;
	private JTextField nome;
	private JTextField user;
	private JPasswordField pass;
	private JTextField dia;
	private JTextField ano;
	private JTextField celular;
	private JTextField email;

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
					Cadastro_operador frame = new Cadastro_operador();
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
	public Cadastro_operador() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Cadastro_operador.class.getResource("/img/icons8-adicionar-usu\u00E1rio-masculino-32.png")));
		setTitle("Cadastro de Usuario");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 304, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(null, "Dados", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 266, 492);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblData = new JLabel("Data");
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblData.setBounds(10, 24, 48, 14);
		panel.add(lblData);
		
		data = new JTextField();
		data.setFont(new Font("Tahoma", Font.PLAIN, 14));
		data.setEditable(false);
		data.setEnabled(false);
		data.setText(new SimpleDateFormat("dd/MM/yyyy").format(new Date(System.currentTimeMillis())));
		data.setBounds(10, 49, 96, 20);
		panel.add(data);
		data.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(10, 80, 48, 14);
		panel.add(lblNome);
		
		nome = new JTextField();
		nome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nome.setBounds(10, 105, 241, 20);
		panel.add(nome);
		nome.setColumns(10);
		
		JLabel lblDia = new JLabel("Dia");
		lblDia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDia.setBounds(10, 136, 48, 14);
		panel.add(lblDia);
		
		dia = new JTextField();
		dia.addKeyListener(new KeyAdapter() {
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
		dia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		dia.setBounds(10, 161, 50, 20);
		panel.add(dia);
		dia.setColumns(10);
		
		JComboBox mes = new JComboBox();
		mes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mes.setModel(new DefaultComboBoxModel(new String[] {"", "Janeiro", "Fevereiro", "Mar\u00E7o", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"}));
		mes.setBounds(71, 161, 120, 20);
		panel.add(mes);
		
		ano = new JTextField();
		ano.addKeyListener(new KeyAdapter() {
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
		ano.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ano.setColumns(10);
		ano.setBounds(201, 161, 50, 20);
		panel.add(ano);
		
		JLabel lblMs = new JLabel("M\u00EAs");
		lblMs.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMs.setBounds(68, 136, 48, 14);
		panel.add(lblMs);
		
		JLabel lblAno = new JLabel("Ano");
		lblAno.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAno.setBounds(201, 136, 48, 14);
		panel.add(lblAno);
		
		JLabel lblCelular = new JLabel("Celular");
		lblCelular.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCelular.setBounds(10, 192, 48, 14);
		panel.add(lblCelular);
		
		celular = new JTextField();
		celular.setFont(new Font("Tahoma", Font.PLAIN, 14));
		celular.setBounds(10, 217, 96, 20);
		panel.add(celular);
		celular.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(10, 248, 48, 14);
		panel.add(lblEmail);
		
		email = new JTextField();
		email.setFont(new Font("Tahoma", Font.PLAIN, 14));
		email.setBounds(10, 273, 241, 20);
		panel.add(email);
		email.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSalvar.setBounds(32, 443, 89, 23);
		panel.add(btnSalvar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSair.setBounds(131, 443, 89, 23);
		panel.add(btnSair);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(10, 310, 48, 14);
		panel.add(lblLogin);
		lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		user = new JTextField();
		user.setBounds(10, 335, 241, 20);
		panel.add(user);
		user.setFont(new Font("Tahoma", Font.PLAIN, 14));
		user.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setBounds(10, 366, 48, 14);
		panel.add(lblSenha);
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		pass = new JPasswordField();
		pass.setBounds(10, 391, 241, 20);
		panel.add(pass);
		pass.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cadastro_operador.this.dispose();
			}
		});
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if(nome.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o campo nome!");
				}
				else if(dia.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o campo Dia!");
				}
				else if(ano.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o campo Ano!");
				}
				else if(celular.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o campo Celular!");
				}
				else if(email.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o campo Email!");
				}
				else if(user.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o campo Login!");
				}
				else if(pass.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o campo Senha!");
				}
				
				
				else {
				
				try {
					Connection con = Conexao.faz_conexao();
					String sql = "insert into logins(login, senha, status, nome, dia, mes, ano, celular, email) value (?, ?, 1, ?, ?, ?, ?, ?, ?)";
					
					PreparedStatement stmt = con.prepareStatement(sql);
					
					stmt.setString(1, user.getText());
					stmt.setString(2, pass.getText());
					stmt.setString(3, nome.getText());
					stmt.setString(4, dia.getText());
					stmt.setString(5, (String) mes.getSelectedItem());
					stmt.setString(6, ano.getText());
					stmt.setString(7, celular.getText());
					stmt.setString(8, email.getText());
					
					
					stmt.execute();
					
					stmt.close();
					con.close();
					JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
					nome.setText("");
					dia.setText("");
					mes.setSelectedItem(null);
					ano.setText("");
					celular.setText("");
					email.setText("");
					user.setText("");
					pass.setText("");
					
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				}	
			}
		});
	}
}
