package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class Tela_Login extends JFrame {

	private JPanel contentPane;
	private JTextField user;
	private JPasswordField pass;

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
					Tela_Login frame = new Tela_Login();
					
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
	public Tela_Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		
		setBounds(100, 100, 1382, 741);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIniciarSesso = new JLabel("LOGIN");
		lblIniciarSesso.setForeground(Color.BLACK);
		lblIniciarSesso.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblIniciarSesso.setBounds(68, 116, 83, 30);
		contentPane.add(lblIniciarSesso);
		
		JLabel lblNomeDeUsurio = new JLabel("Nome de Usu\u00E1rio");
		lblNomeDeUsurio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomeDeUsurio.setForeground(Color.DARK_GRAY);
		lblNomeDeUsurio.setBounds(68, 226, 105, 14);
		contentPane.add(lblNomeDeUsurio);
		
		user = new JTextField();
		user.setFont(new Font("Tahoma", Font.PLAIN, 16));
		user.setBounds(68, 253, 270, 40);
		contentPane.add(user);
		user.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSenha.setForeground(Color.DARK_GRAY);
		lblSenha.setBounds(68, 304, 48, 14);
		contentPane.add(lblSenha);
		
		pass = new JPasswordField();
		pass.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pass.setBounds(68, 329, 270, 40);
		contentPane.add(pass);
		
		JButton btnIniciarSesso = new JButton("ENTRAR");
		btnIniciarSesso.addActionListener(new ActionListener() {	
			public void actionPerformed(ActionEvent e) {

				
				try {
					
					Connection con = Conexao.faz_conexao();

					String sql = "Select * from logins where login=? and senha=?";

					PreparedStatement stmt = con.prepareStatement(sql);

					stmt.setString(1, user.getText());
					stmt.setString(2, new String(pass.getPassword()));
					ResultSet rs = stmt.executeQuery();
					
					if (rs.next()) {
						Tela_Principal exibir = new Tela_Principal();
						exibir.setVisible(true);
						setVisible(false);
						

					}



					else {
						JOptionPane.showMessageDialog(null, "Login ou Senha Incorreta...");

					}
					stmt.close();
					con.close();

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnIniciarSesso.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnIniciarSesso.setForeground(Color.DARK_GRAY);
		btnIniciarSesso.setBackground(Color.LIGHT_GRAY);
		btnIniciarSesso.setBounds(140, 520, 112, 30);
		contentPane.add(btnIniciarSesso);
		
		JLabel label = new JLabel("");
		label.setBounds(430, 64, 48, 14);
		contentPane.add(label);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(411, 0, 965, 707);
		contentPane.add(panel);
		
		
		
	}
}
