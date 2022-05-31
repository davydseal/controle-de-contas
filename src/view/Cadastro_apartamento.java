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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Cadastro_apartamento extends JFrame {

	private JPanel contentPane;
	private JTextField aluguel;
	private JTextField condominio;
	private JTextField id;
	private JTextField iptu;
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
					Cadastro_apartamento frame = new Cadastro_apartamento();
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
	public Cadastro_apartamento() {
		setTitle("Cadastro de Apartamento");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 605, 185);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 570, 124);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNome = new JLabel("Apartamento");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(68, 11, 89, 14);
		panel.add(lblNome);
		
		aluguel = new JTextField();
		aluguel.addKeyListener(new KeyAdapter() {
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
		aluguel.setForeground(Color.BLUE);
		aluguel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		aluguel.setBounds(250, 36, 96, 20);
		panel.add(aluguel);
		aluguel.setColumns(10);
		
		JLabel lblAluguel = new JLabel("Aluguel");
		lblAluguel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAluguel.setBounds(250, 8, 48, 20);
		panel.add(lblAluguel);
		
		condominio = new JTextField();
		condominio.addKeyListener(new KeyAdapter() {
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
		condominio.setForeground(Color.RED);
		condominio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		condominio.setBounds(356, 36, 96, 20);
		panel.add(condominio);
		condominio.setColumns(10);
		
		JLabel lblCondomnio = new JLabel("Condom\u00EDnio");
		lblCondomnio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCondomnio.setBounds(356, 11, 74, 14);
		panel.add(lblCondomnio);
		
		JLabel lblId = new JLabel("Id");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblId.setBounds(10, 11, 48, 14);
		panel.add(lblId);
		
		id = new JTextField();
		id.setFont(new Font("Tahoma", Font.PLAIN, 14));
		id.setEnabled(false);
		id.setBounds(10, 36, 50, 20);
		panel.add(id);
		id.setColumns(10);
		
		iptu = new JTextField();
		iptu.addKeyListener(new KeyAdapter() {
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
		iptu.setForeground(Color.RED);
		iptu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		iptu.setBounds(462, 36, 96, 20);
		panel.add(iptu);
		iptu.setColumns(10);
		
		JLabel lblIptu = new JLabel("Iptu");
		lblIptu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIptu.setBounds(462, 11, 48, 14);
		panel.add(lblIptu);
		
		JButton btnEditar = new JButton("Salvar");
		btnEditar.setBounds(10, 79, 89, 23);
		panel.add(btnEditar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(109, 79, 89, 23);
		panel.add(btnSair);
		
		JComboBox nome = new JComboBox();
		nome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
try {
					
					String sql ="select * from apartamento where nome=?";
					con = DriverManager.getConnection("jdbc:mysql://localhost/sealf", "root", "");
					PreparedStatement statement = con.prepareStatement(sql);
					statement.setString(1, (String)nome.getSelectedItem() );
					
					ResultSet set = statement.executeQuery();

					while (set.next()) {
				      id.setText(set.getString("codigo"));
					  aluguel.setText(set.getString("aluguel"));
					  condominio.setText(set.getString("condominio"));
					  iptu.setText(set.getString("iptu"));
				
					}
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
			}
		});
		nome.setModel(new DefaultComboBoxModel(new String[] {""}));
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/sealf", "root", "");
			st = con.createStatement();
			String s = "select * from apartamento where status= 1";
			rs = st.executeQuery(s);
			
			while(rs.next()){
				nome.addItem(rs.getString("nome"));
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
		nome.setBounds(70, 36, 170, 20);
		panel.add(nome);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cadastro_apartamento.this.dispose();
			}
		});
		btnEditar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
			
				if (((String) nome.getSelectedItem()).isEmpty()) {
					JOptionPane.showMessageDialog(null, "Selecione o Apartamento!");
				}
				
				else if(aluguel.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha o campo Aluguel!");
				}
				
				else if(condominio.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha o campo Condominio!");
				}
				
				else if(iptu.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha o campo iptu!");
				}
				
				else {		
				
			
				
				try {		
					Connection con = Conexao.faz_conexao();
					
					String sql = "update apartamento set nome=?, aluguel=?, condominio=? , iptu=? where codigo=?";
					PreparedStatement stmt = con.prepareStatement(sql);
					
					stmt.setString(1, (String) nome.getSelectedItem());
					stmt.setString(2, aluguel.getText());
					stmt.setString(3, condominio.getText());
					stmt.setString(4, iptu.getText());
					stmt.setString(5, id.getText());

			
					stmt.execute();
					
					stmt.close();
					con.close();
					JOptionPane.showMessageDialog(null, "Apartamento editado com sucesso!!!");
					Cadastro_apartamento.this.dispose();

					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}	
			}
		});
	}

}
