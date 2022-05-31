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
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.Toolkit;

public class Ganhos_apts extends JFrame {

	private JPanel contentPane;
	private JTextField ano;
	private JTextField valor;
	private JTable table;
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
					Ganhos_apts frame = new Ganhos_apts();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Cadastro_apartamento Cadastro_apartamento;
	private JTextField condominio;
	private JTextField iptu;
	/**
	 * Create the frame.
	 */
	public Ganhos_apts() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ganhos_apts.class.getResource("/img/icons8-editar-propriedade-32.png")));
		setTitle("Apartamentos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 396, 639);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 359, 574);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblId = new JLabel("Id");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblId.setBounds(10, 11, 48, 14);
		panel.add(lblId);
		
		JComboBox dia = new JComboBox();
		dia.setModel(new DefaultComboBoxModel(new String[] {"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		dia.setEnabled(false);
		dia.setBounds(85, 36, 65, 20);
		panel.add(dia);
		
		JComboBox mes = new JComboBox();
		mes.setModel(new DefaultComboBoxModel(new String[] {"", "Janeiro", "Fevereiro", "Mar\u00E7o", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"}));
		mes.setEnabled(false);
		mes.setBounds(160, 36, 101, 20);
		panel.add(mes);
		
		JLabel lblDia = new JLabel("Dia");
		lblDia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDia.setBounds(85, 11, 48, 14);
		panel.add(lblDia);
		
		JLabel lblMs = new JLabel("M\u00EAs");
		lblMs.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMs.setBounds(160, 13, 48, 14);
		panel.add(lblMs);
		
		ano = new JTextField();
		ano.setEnabled(false);
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
		ano.setBounds(271, 36, 77, 20);
		panel.add(ano);
		ano.setColumns(10);
		
		JLabel lblAno = new JLabel("Ano");
		lblAno.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAno.setBounds(271, 11, 48, 14);
		panel.add(lblAno);
		
		JLabel lblNome = new JLabel("Apartamento");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNome.setBounds(10, 67, 89, 20);
		panel.add(lblNome);
		
		JComboBox descricao = new JComboBox();
		descricao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					String sql ="select * from apartamento where nome=?";
				con = DriverManager.getConnection("jdbc:mysql://localhost/sealf", "root", "");
					PreparedStatement statement = con.prepareStatement(sql);
					statement.setString(1, (String)descricao.getSelectedItem() );
					
					ResultSet set = statement.executeQuery();

					while (set.next()) {
				      condominio.setText(set.getString("condominio"));
				      iptu.setText(set.getString("iptu"));
					  
					 
					}
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		descricao.setModel(new DefaultComboBoxModel(new String[] {""}));
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/sealf", "root", "");
			st = con.createStatement();
			String s = "select * from apartamento";
			rs = st.executeQuery(s);
			
			while(rs.next()){
				descricao.addItem(rs.getString("nome"));

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
		descricao.setEnabled(false);
		descricao.setBounds(10, 92, 164, 20);
		panel.add(descricao);
		
		JLabel lblAluguel = new JLabel("Aluguel");
		lblAluguel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAluguel.setBounds(184, 67, 48, 17);
		panel.add(lblAluguel);
		
		valor = new JTextField();
		valor.setForeground(Color.RED);
		valor.setEnabled(false);
		valor.addKeyListener(new KeyAdapter() {
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
		valor.setBounds(184, 92, 164, 20);
		panel.add(valor);
		valor.setColumns(10);
		
		JLabel label_2 = new JLabel("Observa\u00E7\u00F5es");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(10, 185, 77, 14);
		panel.add(label_2);
		
		JTextArea obs = new JTextArea();
		obs.setEnabled(false);
		obs.setBackground(SystemColor.controlHighlight);
		obs.setBounds(10, 210, 338, 95);
		panel.add(obs);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 316, 338, 131);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"Id", "Dia", "M\u00EAs", "Ano", "Descri\u00E7\u00E3o", "Valor", "Obs"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.setBounds(32, 458, 89, 23);
		panel.add(btnNovo);
		
		JButton btnIncluir = new JButton("Incluir");
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (((String) dia.getSelectedItem()).isEmpty()) {
					JOptionPane.showMessageDialog(null, "Selecione o Dia!");
				}
				else if (((String) mes.getSelectedItem()).isEmpty()) {
					JOptionPane.showMessageDialog(null, "Selecione o Mês!");
				}
				else if(ano.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o campo Ano!");
				}
				else if (((String) descricao.getSelectedItem()).isEmpty()) {
					JOptionPane.showMessageDialog(null, "Selecione a Descrição!");
				}
				else if(valor.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o campo Valor!");
				}
				else {
				try {
					Connection con = Conexao.faz_conexao();
					String sql = "insert into ganhos(dia, mes, ano, descricao, valor, obs, status) value (?, ?, ?, ?, ?, ?, 1)";
					
					PreparedStatement stmt = con.prepareStatement(sql);
					
			
					stmt.setString(1, (String) dia.getSelectedItem());
					stmt.setString(2, (String) mes.getSelectedItem());
					stmt.setString(3, ano.getText());
					stmt.setString(4, (String) descricao.getSelectedItem());
					stmt.setString(5, valor.getText());
					stmt.setString(6, obs.getText());

					
					
					stmt.execute();
					
					stmt.close();
					con.close();
					JOptionPane.showMessageDialog(null, "Salário salvo com sucesso!");
					dia.setSelectedItem(null);
					//mes.setSelectedItem(null);
					//ano.setText("");
					descricao.setSelectedItem(null);
					valor.setText("");
					obs.setText("");
			
					
					
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			}
		});
		btnIncluir.setBounds(131, 458, 89, 23);
		panel.add(btnIncluir);
		btnIncluir.setEnabled(false);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con = Conexao.faz_conexao();
					String sql = "select * from ganhos";
					java.sql.PreparedStatement stmt = con.prepareStatement(sql);
					ResultSet rs = stmt.executeQuery();
					
					DefaultTableModel  modelo = (DefaultTableModel) table.getModel();
					modelo.setNumRows(0);
					
					while(rs.next()) {
					

						modelo.addRow(new Object[] {rs.getString("codigo"), rs.getString("dia"), rs.getString("mes") , rs.getString("ano") , rs.getString("descricao"), rs.getString("valor"), rs.getString("obs")});
						
							}

				
					rs.first();
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnListar.setBounds(230, 458, 89, 23);
		panel.add(btnListar);
		
		JButton btnLocalizar = new JButton("Localizar");
		btnLocalizar.setBounds(32, 492, 89, 23);
		panel.add(btnLocalizar);
		
		JButton btnGastos = new JButton("Edi\u00E7\u00F5es");
		btnGastos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(Cadastro_apartamento == null) 
				{
					Cadastro_apartamento = new Cadastro_apartamento();
					Cadastro_apartamento.setLocationRelativeTo(null);
				}
				Cadastro_apartamento.setVisible(true);
			}
		});
		btnGastos.setBounds(131, 526, 89, 23);
		panel.add(btnGastos);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(230, 526, 89, 23);
		panel.add(btnSair);
		
		JComboBox id = new JComboBox();
		id.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					String sql ="select * from ganhos where codigo=?";
				con = DriverManager.getConnection("jdbc:mysql://localhost/sealf", "root", "");
					PreparedStatement statement = con.prepareStatement(sql);
					statement.setString(1, (String)id.getSelectedItem() );
					
					ResultSet set = statement.executeQuery();

					while (set.next()) {
				     
						dia.setSelectedItem(set.getString("dia"));
						mes.setSelectedItem(set.getString("mes"));
						 ano.setText(set.getString("ano"));
						 descricao.setSelectedItem(set.getString("descricao"));
						 valor.setText(set.getString("valor"));
						 obs.setText(set.getString("obs"));
							dia.setEnabled(true);
							mes.setEnabled(true);
							ano.setEnabled(true);
							descricao.setEnabled(true);
							valor.setEnabled(true);
							obs.setEnabled(true);
					 
					}
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		id.setModel(new DefaultComboBoxModel(new String[] {""}));
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/sealf", "root", "");
			st = con.createStatement();
			String s = "select * from ganhos";
			rs = st.executeQuery(s);
			
			while(rs.next()){
				id.addItem(rs.getString("codigo"));

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
		id.setEnabled(false);
		id.setBounds(10, 36, 65, 20);
		panel.add(id);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setEnabled(false);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (((String) dia.getSelectedItem()).isEmpty()) {
					JOptionPane.showMessageDialog(null, "Selecione o Dia!");
				}
				else if (((String) mes.getSelectedItem()).isEmpty()) {
					JOptionPane.showMessageDialog(null, "Selecione o Mês!");
				}
				else if(ano.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o campo Ano!");
				}
				else if (((String) descricao.getSelectedItem()).isEmpty()) {
					JOptionPane.showMessageDialog(null, "Selecione a Descrição!");
				}
				else if(valor.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o campo Valor!");
				}
				else {
				try {		
					Connection con = Conexao.faz_conexao();
					
					String sql = "update ganhos set dia=?, mes=?, ano=?, descricao=?, valor=?, obs=? where codigo=?";
					PreparedStatement stmt = con.prepareStatement(sql);
					
				
					stmt.setString(1, (String) dia.getSelectedItem());
					stmt.setString(2, (String) mes.getSelectedItem());
					stmt.setString(3, ano.getText());
					stmt.setString(4, (String) descricao.getSelectedItem());
					stmt.setString(5, valor.getText());
					stmt.setString(6, obs.getText());
					stmt.setString(7, (String) id.getSelectedItem());

			
					stmt.execute();
					
					stmt.close();
					con.close();
					JOptionPane.showMessageDialog(null, "Ganhos salvo com sucesso!!!");
					Ganhos_apts.this.dispose();
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			}
		});
		btnSalvar.setBounds(131, 492, 89, 23);
		panel.add(btnSalvar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (((String) id.getSelectedItem()).isEmpty()) {
					JOptionPane.showMessageDialog(null, "Selecione o Id!");
				}
				else {
					
				
				try {
					Connection con = Conexao.faz_conexao();
					String sql = "delete from ganhos where codigo=?";
					
					PreparedStatement stmt = con.prepareStatement(sql);

					stmt.setString(1, (String) id.getSelectedItem());
					
					stmt.execute();
					
					stmt.close();
					
					con.close();
					
					JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
					id.setSelectedItem(null);
					dia.setSelectedItem(null);
					mes.setSelectedItem(null);
					ano.setText("");
					descricao.setSelectedItem(null);
					valor.setText("");
					obs.setText("");

					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			}
		});
		btnExcluir.setEnabled(false);
		btnExcluir.setBounds(230, 492, 89, 23);
		panel.add(btnExcluir);
		
		JButton btnResetar = new JButton("Resetar");
		btnResetar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id.setSelectedItem(null); 
				dia.setSelectedItem(null); 
				mes.setSelectedItem(null); 
				ano.setText("");
				descricao.setSelectedItem(null); 
				valor.setText("");
				obs.setText("");
				
				id.setEnabled(false);
				dia.setEnabled(false);
				mes.setEnabled(false);
				ano.setEnabled(false);
				descricao.setEnabled(false);
				valor.setEnabled(false);
				obs.setEnabled(false);
				
				btnNovo.setEnabled(true);
				btnSalvar.setEnabled(false);
				btnLocalizar.setEnabled(true);
				btnIncluir.setEnabled(false);
				btnExcluir.setEnabled(false);
				
				table.setModel(new DefaultTableModel (null, new String [] {"Id","Dia","Mês","Ano","Descrição","Valor","Obs"}));
			}
		});
		btnResetar.setBounds(32, 526, 89, 23);
		panel.add(btnResetar);
		
		JLabel lblCondominio = new JLabel("Condom\u00EDnio");
		lblCondominio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCondominio.setBounds(10, 123, 77, 20);
		panel.add(lblCondominio);
		
		condominio = new JTextField();
		condominio.setForeground(Color.RED);
		condominio.setEnabled(false);
		condominio.setColumns(10);
		condominio.setBounds(10, 154, 164, 20);
		panel.add(condominio);
		
		iptu = new JTextField();
		iptu.setForeground(Color.RED);
		iptu.setEnabled(false);
		iptu.setColumns(10);
		iptu.setBounds(184, 154, 164, 20);
		panel.add(iptu);
		
		JLabel lblIptu = new JLabel("Iptu");
		lblIptu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIptu.setBounds(184, 128, 77, 20);
		panel.add(lblIptu);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ganhos_apts.this.dispose();
			}
		});
		btnLocalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id.setEnabled(true);
				btnNovo.setEnabled(false);
				btnIncluir.setEnabled(false);
				btnLocalizar.setEnabled(false);
				btnSalvar.setEnabled(true);
				btnExcluir.setEnabled(true);
			}
		});
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dia.setEnabled(true);
				mes.setEnabled(true);
				ano.setEnabled(true);
				descricao.setEnabled(true);
				valor.setEnabled(true);
				obs.setEnabled(true);
				btnNovo.setEnabled(false);
				btnIncluir.setEnabled(true);
				btnLocalizar.setEnabled(false);
				btnSalvar.setEnabled(false);
				btnExcluir.setEnabled(false);
			}
		});
	}
}
