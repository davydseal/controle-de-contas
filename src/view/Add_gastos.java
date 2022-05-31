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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class Add_gastos extends JFrame {

	private JPanel contentPane;
	private JTextField descricao;
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
					Add_gastos frame = new Add_gastos();
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
	public Add_gastos() {
		setTitle("Add Gastos fixos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 435, 364);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 397, 302);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblId = new JLabel("Id");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblId.setBounds(10, 11, 48, 14);
		panel.add(lblId);
		
		JComboBox id = new JComboBox();
		id.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					String sql ="select * from contas where codigo=?";
				con = DriverManager.getConnection("jdbc:mysql://localhost/sealf", "root", "");
					PreparedStatement statement = con.prepareStatement(sql);
					statement.setString(1, (String)id.getSelectedItem() );
					
					ResultSet set = statement.executeQuery();

					while (set.next()) {
				     

						 descricao.setText(set.getString("descricao"));
						
							descricao.setEnabled(true);

					 
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
			String s = "select * from contas";
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
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescrio.setBounds(85, 8, 91, 20);
		panel.add(lblDescrio);
		
		descricao = new JTextField();
		descricao.setEnabled(false);
		descricao.setBounds(85, 36, 300, 20);
		panel.add(descricao);
		descricao.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 67, 375, 113);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				"Id", "Descri\u00E7\u00E3o"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.setBounds(51, 191, 89, 23);
		panel.add(btnNovo);
		
		JButton btnIncluir = new JButton("Incluir");
		btnIncluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 if(descricao.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o campo Descrição!");
				}
				
				else {
				try {
					Connection con = Conexao.faz_conexao();
					String sql = "insert into contas(descricao, status) value (?, 1)";
					
					PreparedStatement stmt = con.prepareStatement(sql);
					
					stmt.setString(1, descricao.getText());
					

					
					
					stmt.execute();
					
					stmt.close();
					con.close();
					JOptionPane.showMessageDialog(null, "Conta salva com sucesso!");
					descricao.setText("");	
					
				
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			}
		});
		btnIncluir.setBounds(150, 191, 89, 23);
		panel.add(btnIncluir);
		btnIncluir.setEnabled(false);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con = Conexao.faz_conexao();
					String sql = "select * from contas";
					java.sql.PreparedStatement stmt = con.prepareStatement(sql);
					ResultSet rs = stmt.executeQuery();
					
					DefaultTableModel  modelo = (DefaultTableModel) table.getModel();
					modelo.setNumRows(0);
					
					while(rs.next()) {
					

						modelo.addRow(new Object[] {rs.getString("codigo"), rs.getString("descricao")});
						
							}

				
					rs.first();
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnListar.setBounds(249, 191, 89, 23);
		panel.add(btnListar);
		
		JButton btnLocalizar = new JButton("Localizar");
		btnLocalizar.setBounds(51, 225, 89, 23);
		panel.add(btnLocalizar);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(descricao.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o campo Descrição!");
				}
				else {
				try {		
					Connection con = Conexao.faz_conexao();
					
					String sql = "update contas set descricao=? where codigo=?";
					PreparedStatement stmt = con.prepareStatement(sql);
					
				
					
					stmt.setString(1, descricao.getText());
					stmt.setString(2, (String) id.getSelectedItem());

			
					stmt.execute();
					
					stmt.close();
					con.close();
					JOptionPane.showMessageDialog(null, "Conta salva com sucesso!!!");
					Add_gastos.this.dispose();
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			}
		});
		btnSalvar.setBounds(150, 225, 89, 23);
		panel.add(btnSalvar);
		btnSalvar.setEnabled(false);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (((String) id.getSelectedItem()).isEmpty()) {
					JOptionPane.showMessageDialog(null, "Selecione o Id!");
				}
				else {
					
				
				try {
					Connection con = Conexao.faz_conexao();
					String sql = "delete from contas where codigo=?";
					
					PreparedStatement stmt = con.prepareStatement(sql);

					stmt.setString(1, (String) id.getSelectedItem());
					
					stmt.execute();
					
					stmt.close();
					
					con.close();
					
					JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
					id.setSelectedItem(null);
					descricao.setText("");

					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			}
		});
		btnExcluir.setBounds(249, 225, 89, 23);
		panel.add(btnExcluir);
		btnExcluir.setEnabled(false);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Add_gastos.this.dispose();
			}
		});
		btnSair.setBounds(150, 259, 89, 23);
		panel.add(btnSair);
		
		JButton btnResetar = new JButton("Resetar");
		btnResetar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id.setSelectedItem(null);  
				descricao.setText("");
				
				id.setEnabled(false);
				descricao.setEnabled(false);
				
				btnNovo.setEnabled(true);
				btnSalvar.setEnabled(false);
				btnLocalizar.setEnabled(true);
				btnIncluir.setEnabled(false);
				btnExcluir.setEnabled(false);
				
				table.setModel(new DefaultTableModel (null, new String [] {"Id","Descrição"}));
			}
		});
		btnResetar.setBounds(51, 259, 89, 23);
		panel.add(btnResetar);
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
				descricao.setEnabled(true);
				btnNovo.setEnabled(false);
				btnIncluir.setEnabled(true);
				btnLocalizar.setEnabled(false);
				btnSalvar.setEnabled(false);
				btnExcluir.setEnabled(false);
			}
		});
	}
}
