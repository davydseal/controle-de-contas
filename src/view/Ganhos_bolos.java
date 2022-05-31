package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Ganhos_bolos extends JFrame {

	private JPanel contentPane;
	private JTextField valor;
	private JTextField cliente;
	private JTable table;
	private JTextField ano;
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
					Ganhos_bolos frame = new Ganhos_bolos();
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
	public Ganhos_bolos() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ganhos_bolos.class.getResource("/img/Cake_ChocolateCake_26374.png")));
		setTitle("Ganhos do Bolo");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 434, 520);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 396, 459);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblMs = new JLabel("Dia");
		lblMs.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMs.setBounds(90, 11, 48, 14);
		panel.add(lblMs);
		
		JComboBox dia = new JComboBox();
		dia.setEnabled(false);
		dia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		dia.setModel(new DefaultComboBoxModel(new String[] {"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		dia.setBounds(90, 37, 70, 21);
		panel.add(dia);
		
		valor = new JTextField();
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
		valor.setForeground(Color.BLUE);
		valor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		valor.setBounds(170, 149, 212, 20);
		panel.add(valor);
		valor.setColumns(10);
		
		JLabel lblValorR = new JLabel("Valor R$");
		lblValorR.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblValorR.setBounds(170, 123, 59, 14);
		panel.add(lblValorR);
		
		JLabel lblMs_1 = new JLabel("M\u00EAs");
		lblMs_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMs_1.setBounds(170, 11, 48, 14);
		panel.add(lblMs_1);
		
		JLabel lblOnde = new JLabel("Local");
		lblOnde.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblOnde.setBounds(10, 123, 48, 14);
		panel.add(lblOnde);
		
		cliente = new JTextField();
		cliente.setEnabled(false);
		cliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cliente.setBounds(10, 93, 372, 20);
		panel.add(cliente);
		cliente.setColumns(10);
		
		JLabel lblCliente = new JLabel("Cliente");
		lblCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCliente.setBounds(10, 68, 48, 14);
		panel.add(lblCliente);
		
		JComboBox mes = new JComboBox();
		mes.setEnabled(false);
		mes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mes.setBounds(170, 37, 101, 21);
		panel.add(mes);
		mes.setModel(new DefaultComboBoxModel(new String[] {"", "Janeiro", "Fevereiro", "Mar\u00E7o", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"}));
		
		JComboBox local = new JComboBox();
		local.setEnabled(false);
		local.setFont(new Font("Tahoma", Font.PLAIN, 14));
		local.setBounds(10, 148, 150, 21);
		panel.add(local);
		local.setModel(new DefaultComboBoxModel(new String[] {"", "Conta", "Balde"}));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 201, 372, 126);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"Id", "Dia", "M\u00EAs", "Ano", "Cliente", "Local", "Valor"
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
		
		JLabel lblId = new JLabel("Id");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblId.setBounds(10, 13, 48, 14);
		panel.add(lblId);
		
		JComboBox id = new JComboBox();
		id.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					String sql ="select * from ganhos_bolo where codigo=?";
				con = DriverManager.getConnection("jdbc:mysql://localhost/sealf", "root", "");
					PreparedStatement statement = con.prepareStatement(sql);
					statement.setString(1, (String)id.getSelectedItem() );
					
					ResultSet set = statement.executeQuery();

					while (set.next()) {
				     
						dia.setSelectedItem(set.getString("dia"));
						mes.setSelectedItem(set.getString("mes"));
						 ano.setText(set.getString("ano"));
						 cliente.setText(set.getString("cliente"));
						 local.setSelectedItem(set.getString("local"));
						 valor.setText(set.getString("valor"));
						
							dia.setEnabled(true);
							mes.setEnabled(true);
							ano.setEnabled(true);
							cliente.setEnabled(true);
							local.setEnabled(true);
							valor.setEnabled(true);
							
					 
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
			String s = "select * from ganhos_bolo";
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
		id.setFont(new Font("Tahoma", Font.PLAIN, 14));
		id.setBounds(10, 37, 70, 21);
		panel.add(id);
		
		ano = new JTextField();
		ano.setEnabled(false);
		ano.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ano.setColumns(10);
		ano.setBounds(286, 37, 96, 20);
		panel.add(ano);
		
		JLabel lblAno = new JLabel("Ano");
		lblAno.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAno.setBounds(286, 11, 48, 14);
		panel.add(lblAno);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.setBounds(47, 355, 89, 23);
		panel.add(btnNovo);
		
		JButton btnSalvar = new JButton("Incluir");
		btnSalvar.setBounds(146, 355, 89, 23);
		panel.add(btnSalvar);
		btnSalvar.setEnabled(false);
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JButton btnListar = new JButton("Listar");
		btnListar.setBounds(245, 355, 89, 23);
		panel.add(btnListar);
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con = Conexao.faz_conexao();
					String sql = "select * from ganhos_bolo";
					java.sql.PreparedStatement stmt = con.prepareStatement(sql);
					ResultSet rs = stmt.executeQuery();
					
					DefaultTableModel  modelo = (DefaultTableModel) table.getModel();
					modelo.setNumRows(0);
					
					while(rs.next()) {
					

						modelo.addRow(new Object[] {rs.getString("codigo"), rs.getString("dia"), rs.getString("mes"), rs.getString("ano"), rs.getString("cliente") , rs.getString("local"), rs.getString("valor")});
						
							}

				
					rs.first();
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnListar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JButton btnLocalizar = new JButton("Localizar");
		btnLocalizar.setBounds(47, 391, 89, 23);
		panel.add(btnLocalizar);
		
		JButton btnSalvar_1 = new JButton("Salvar");
		btnSalvar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {		
					Connection con = Conexao.faz_conexao();
					
					String sql = "update ganhos_bolo set dia=?, mes=?, ano=?, cliente=?, local=?, valor=? where codigo=?";
					PreparedStatement stmt = con.prepareStatement(sql);
					
					stmt.setString(1, (String) dia.getSelectedItem());
					stmt.setString(2, (String) mes.getSelectedItem());
					stmt.setString(3, ano.getText());
					stmt.setString(4, cliente.getText());
					stmt.setString(5, (String) local.getSelectedItem());
					stmt.setString(6, valor.getText());
					stmt.setString(7, (String) id.getSelectedItem());

			
					stmt.execute();
					
					stmt.close();
					con.close();
					JOptionPane.showMessageDialog(null, "Ganho do bolo salvo com sucesso!!!");
					Ganhos_bolos.this.dispose();
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSalvar_1.setBounds(146, 391, 89, 23);
		panel.add(btnSalvar_1);
		btnSalvar_1.setEnabled(false);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (((String) id.getSelectedItem()).isEmpty()) {
					JOptionPane.showMessageDialog(null, "Selecione o Id!");
				}
				else {
					
				
				try {
					Connection con = Conexao.faz_conexao();
					String sql = "delete from ganhos_bolo where codigo=?";
					
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
					cliente.setText("");
					local.setSelectedItem(null);
					valor.setText("");
					

					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			}
		});
		btnExcluir.setBounds(245, 391, 89, 23);
		panel.add(btnExcluir);
		btnExcluir.setEnabled(false);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(146, 425, 89, 23);
		panel.add(btnSair);
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		JButton btnResetar = new JButton("Resetar");
		btnResetar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id.setSelectedItem(null); 
				dia.setSelectedItem(null); 
				mes.setSelectedItem(null); 
				ano.setText("");
				cliente.setText("");
				local.setSelectedItem(null); 
				valor.setText("");
				
				id.setEnabled(false);
				dia.setEnabled(false);
				mes.setEnabled(false);
				ano.setEnabled(false);
				cliente.setEnabled(false);
				local.setEnabled(false);
				valor.setEnabled(false);
				
				btnNovo.setEnabled(true);
				btnSalvar.setEnabled(false);
				btnLocalizar.setEnabled(true);
				btnSalvar_1.setEnabled(false);
				btnExcluir.setEnabled(false);
				
				table.setModel(new DefaultTableModel (null, new String [] {"Id","Dia","Mês","Ano","Cliente","Local","Valor"}));
				
			}
		});
		btnResetar.setBounds(47, 425, 89, 23);
		panel.add(btnResetar);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ganhos_bolos.this.dispose();
			}
		});
		btnLocalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id.setEnabled(true);
				btnSalvar.setEnabled(false);
				btnNovo.setEnabled(false);
				btnLocalizar.setEnabled(false);
				btnSalvar_1.setEnabled(true);
				btnExcluir.setEnabled(true);
			}
		});
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (((String) dia.getSelectedItem()).isEmpty()) {
					JOptionPane.showMessageDialog(null, "Selecione o Dia!");
				}
				else if (((String) mes.getSelectedItem()).isEmpty()) {
					JOptionPane.showMessageDialog(null, "Selecione o Mês!");
				}
				else if(ano.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha o campo Ano!");
				}
				else if (((String) local.getSelectedItem()).isEmpty()) {
					JOptionPane.showMessageDialog(null, "Selecione o Local!");
				}
				else if(valor.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Preencha o campo Valor!");
				}
				else {
				try {
					Connection con = Conexao.faz_conexao();
					String sql = "insert into ganhos_bolo(dia, mes, ano, cliente, local, valor, status) value (?, ?, ?, ?, ?, ?, 1)";
					
					PreparedStatement stmt = con.prepareStatement(sql);
					
					


					stmt.setString(1, (String) dia.getSelectedItem());
					stmt.setString(2, (String) mes.getSelectedItem());
					stmt.setString(3, ano.getText());
					stmt.setString(4, cliente.getText());
					stmt.setString(5, (String) local.getSelectedItem());
					stmt.setString(6, valor.getText());
					
					
					stmt.execute();
					
					stmt.close();
					con.close();
					JOptionPane.showMessageDialog(null, "Dados salvos com sucesso!");


					dia.setSelectedItem(null); 
					//mes.setSelectedItem(null); 
					cliente.setText("");
					local.setSelectedItem(null); 
					valor.setText("");
					//ano.setText("");
					
					
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			}
		});
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dia.setEnabled(true);
				mes.setEnabled(true);
				ano.setEnabled(true);
				cliente.setEnabled(true);
				local.setEnabled(true);
				valor.setEnabled(true);
				btnNovo.setEnabled(false);
				btnSalvar.setEnabled(true);
				btnLocalizar.setEnabled(false);
				btnSalvar_1.setEnabled(false);
				btnExcluir.setEnabled(false);
				
			}
		});
	}
}
