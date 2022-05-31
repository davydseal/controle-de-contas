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
import javax.swing.JTextArea;
import java.awt.SystemColor;
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

public class Gastos_extras extends JFrame {

	private JPanel contentPane;
	private JTextField descricao2;
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
					Gastos_extras frame = new Gastos_extras();
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
	public Gastos_extras() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Gastos_extras.class.getResource("/img/recipepizzaicon_109877.png")));
		setTitle("Gastos Extras");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 396, 622);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 358, 560);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(10, 11, 48, 14);
		panel.add(lblId);
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JComboBox dia = new JComboBox();
		dia.setBounds(85, 36, 65, 20);
		panel.add(dia);
		dia.setModel(new DefaultComboBoxModel(new String[] {"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		dia.setEnabled(false);
		
		
		JLabel lblDia = new JLabel("Dia");
		lblDia.setBounds(85, 11, 48, 14);
		panel.add(lblDia);
		lblDia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JComboBox mes = new JComboBox();
		mes.setBounds(160, 36, 101, 20);
		panel.add(mes);
		mes.setEnabled(false);
		mes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mes.setModel(new DefaultComboBoxModel(new String[] {"", "Janeiro", "Fevereiro", "Mar\u00E7o", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"}));
		
		JLabel lblMs = new JLabel("M\u00EAs");
		lblMs.setBounds(160, 11, 48, 14);
		panel.add(lblMs);
		lblMs.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		ano = new JTextField();
		ano.setBounds(271, 36, 77, 20);
		panel.add(ano);
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
		ano.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ano.setColumns(10);
		
		JLabel lblAno = new JLabel("Ano");
		lblAno.setBounds(271, 11, 48, 14);
		panel.add(lblAno);
		lblAno.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JComboBox descricao1 = new JComboBox();
		descricao1.setBounds(10, 92, 338, 20);
		panel.add(descricao1);
		descricao1.setEnabled(false);
		descricao1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		descricao1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(descricao1.getSelectedItem().toString().equals("Outros")) {

					 descricao2.setEnabled(true);
					 descricao1.setEnabled(false);

		       }

			}
		});
		descricao1.setModel(new DefaultComboBoxModel(new String[] {"", "Pizza", "Hamburguer", "Cachorro Quente", "Churrasco", "Anivers\u00E1rio", "Outros"}));
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setBounds(10, 67, 65, 14);
		panel.add(lblDescrio);
		lblDescrio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		descricao2 = new JTextField();
		descricao2.setBounds(10, 148, 164, 20);
		panel.add(descricao2);
		descricao2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		descricao2.setEnabled(false);
		descricao2.setColumns(10);
		
		JLabel lblDescrio_1 = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio_1.setBounds(10, 123, 65, 14);
		panel.add(lblDescrio_1);
		lblDescrio_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		valor = new JTextField();
		valor.setBounds(184, 148, 164, 20);
		panel.add(valor);
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
		valor.setForeground(Color.RED);
		valor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		valor.setColumns(10);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setBounds(184, 123, 48, 14);
		panel.add(lblValor);
		lblValor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JTextArea obs = new JTextArea();
		obs.setBounds(10, 204, 338, 95);
		panel.add(obs);
		obs.setEnabled(false);
		obs.setBackground(SystemColor.controlHighlight);
		
		JLabel lblObservaes = new JLabel("Observa\u00E7\u00F5es");
		lblObservaes.setBounds(10, 179, 77, 14);
		panel.add(lblObservaes);
		lblObservaes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 310, 338, 131);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Id", "Dia", "M\u00EAs", "Ano", "Descri\u00E7\u00E3o", "Descri\u00E7\u00E3o", "Valor", "Obs"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, true, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.setBounds(32, 452, 89, 23);
		panel.add(btnNovo);
		
		JButton btnLocalizar = new JButton("Localizar");
		btnLocalizar.setBounds(32, 486, 89, 23);
		panel.add(btnLocalizar);
		
		JButton btnSalvar = new JButton("Incluir");
		btnSalvar.setBounds(131, 452, 89, 23);
		panel.add(btnSalvar);
		btnSalvar.setEnabled(false);
		
		JButton btnListar = new JButton("Listar");
		btnListar.setBounds(230, 452, 89, 23);
		panel.add(btnListar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(131, 520, 89, 23);
		panel.add(btnSair);
		
		JComboBox id = new JComboBox();
		id.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					String sql ="select * from gastos_extras where codigo=?";
				con = DriverManager.getConnection("jdbc:mysql://localhost/sealf", "root", "");
					PreparedStatement statement = con.prepareStatement(sql);
					statement.setString(1, (String)id.getSelectedItem() );
					
					ResultSet set = statement.executeQuery();

					while (set.next()) {
				     
						dia.setSelectedItem(set.getString("dia"));
						mes.setSelectedItem(set.getString("mes"));
						 ano.setText(set.getString("ano"));
						 descricao1.setSelectedItem(set.getString("descricao1"));
						 descricao2.setText(set.getString("descricao2"));
						 valor.setText(set.getString("valor"));
						 obs.setText(set.getString("obs"));
							dia.setEnabled(true);
							mes.setEnabled(true);
							ano.setEnabled(true);
							descricao1.setEnabled(true);
							descricao2.setEnabled(true);
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
			String s = "select * from gastos_extras";
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
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setEnabled(false);
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (((String) id.getSelectedItem()).isEmpty()) {
					JOptionPane.showMessageDialog(null, "Selecione o Id!");
				}
				else {
					
				
				try {
					Connection con = Conexao.faz_conexao();
					String sql = "delete from gastos_extras where codigo=?";
					
					PreparedStatement stmt = con.prepareStatement(sql);

					stmt.setString(1, (String) id.getSelectedItem());
					
					stmt.execute();
					
					stmt.close();
					
					con.close();
					
					JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
					Gastos_extras.this.dispose();

					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			
			}
		});
		btnExcluir.setBounds(230, 486, 89, 23);
		panel.add(btnExcluir);
		
		JButton btnSalvar_1 = new JButton("Salvar");
		btnSalvar_1.setEnabled(false);
		btnSalvar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (((String) id.getSelectedItem()).isEmpty()) {
					JOptionPane.showMessageDialog(null, "Selecione o Id!");
				}
				else if (((String) dia.getSelectedItem()).isEmpty()) {
					JOptionPane.showMessageDialog(null, "Selecione o Dia!");
				}
				else if (((String) mes.getSelectedItem()).isEmpty()) {
					JOptionPane.showMessageDialog(null, "Selecione o Mês!");
				}
				else if(ano.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o campo Ano!");
				}
				else if (((String) descricao1.getSelectedItem()).isEmpty()) {
					JOptionPane.showMessageDialog(null, "Selecione a descrição!");
				}
				else if(valor.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o campo Valor!");
				}
				else {
				try {		
					Connection con = Conexao.faz_conexao();
					
					String sql = "update gastos_extras set dia=?, mes=?, ano=?, descricao1=?, descricao2=?, valor=?, obs=? where codigo=?";
					PreparedStatement stmt = con.prepareStatement(sql);
					
				
					stmt.setString(1, (String) dia.getSelectedItem());
					stmt.setString(2, (String) mes.getSelectedItem());
					stmt.setString(3, ano.getText());
					stmt.setString(4, (String) descricao1.getSelectedItem());
					stmt.setString(5, descricao2.getText());
					stmt.setString(6, valor.getText());
					stmt.setString(7, obs.getText());
					stmt.setString(8, (String) id.getSelectedItem());

			
					stmt.execute();
					
					stmt.close();
					con.close();
					JOptionPane.showMessageDialog(null, "Gasto extra salvo com sucesso!!!");
					Gastos_extras.this.dispose();
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			}
		});
		btnSalvar_1.setBounds(131, 486, 89, 23);
		panel.add(btnSalvar_1);
		
		JButton btnResetar = new JButton("Resetar");
		btnResetar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id.setSelectedItem(null); 
				dia.setSelectedItem(null); 
				mes.setSelectedItem(null); 
				ano.setText("");
				//descricao1.setSelectedItem(null); 
				descricao2.setText("");
				valor.setText("");
				obs.setText("");
				
				id.setEnabled(false);
				dia.setEnabled(false);
				mes.setEnabled(false);
				ano.setEnabled(false);
				descricao1.setEnabled(true);
				descricao2.setEnabled(false);
				valor.setEnabled(false);
				obs.setEnabled(false);
				
				btnNovo.setEnabled(true);
				btnSalvar.setEnabled(false);
				btnLocalizar.setEnabled(true);
				btnSalvar_1.setEnabled(false);
				btnExcluir.setEnabled(false);
				
				table.setModel(new DefaultTableModel (null, new String [] {"Id","Dia","Mês","Ano","Descrição","Descrição","Valor","Obs"}));
			}
		});
		btnResetar.setBounds(32, 520, 89, 23);
		panel.add(btnResetar);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Gastos_extras.this.dispose();
			}
		});
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con = Conexao.faz_conexao();
					String sql = "select * from gastos_extras";
					java.sql.PreparedStatement stmt = con.prepareStatement(sql);
					ResultSet rs = stmt.executeQuery();
					
					DefaultTableModel  modelo = (DefaultTableModel) table.getModel();
					modelo.setNumRows(0);
					
					while(rs.next()) {
					

						modelo.addRow(new Object[] {rs.getString("codigo"), rs.getString("dia"), rs.getString("mes") , rs.getString("ano"), rs.getString("descricao1"), rs.getString("descricao2"), rs.getString("valor"), rs.getString("obs")});
						
							}

				
					rs.first();
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (((String) descricao1.getSelectedItem()).isEmpty()) {
					JOptionPane.showMessageDialog(null, "Selecione a Descrição!");
				}
				else if (((String) dia.getSelectedItem()).isEmpty()) {
					JOptionPane.showMessageDialog(null, "Selecione o Dia!");
				}
				else if (((String) mes.getSelectedItem()).isEmpty()) {
					JOptionPane.showMessageDialog(null, "Selecione o Mês!");
				}
				else if(ano.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o campo Ano!");
				}
				else if(valor.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o campo Valor!");
				}
				else {
				try {
					Connection con = Conexao.faz_conexao();
					String sql = "insert into gastos_extras(descricao1, descricao2, dia, mes, ano, valor, obs, status) value (?, ?, ?, ?, ?, ?, ?, 1)";
					
					PreparedStatement stmt = con.prepareStatement(sql);
					
					
					stmt.setString(1, (String) descricao1.getSelectedItem());
					stmt.setString(2, descricao2.getText());
					stmt.setString(3, (String) dia.getSelectedItem());
					stmt.setString(4, (String) mes.getSelectedItem());
					stmt.setString(5, ano.getText());
					stmt.setString(6, valor.getText());
					stmt.setString(7, obs.getText());

					
					
					stmt.execute();
					
					stmt.close();
					con.close();
					JOptionPane.showMessageDialog(null, "Gastos extras salvos com sucesso!");
					descricao2.setText("");
					dia.setSelectedItem(null);
					//mes.setSelectedItem(null);
					//ano.setText("");
					valor.setText("");
					obs.setText("");
			
					
					
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
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
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dia.setEnabled(true);
				mes.setEnabled(true);
				ano.setEnabled(true);
				descricao1.setEnabled(true);
				valor.setEnabled(true);
				obs.setEnabled(true);
				btnNovo.setEnabled(false);
				btnLocalizar.setEnabled(false);
				btnSalvar.setEnabled(true);
				btnSalvar_1.setEnabled(false);
				btnExcluir.setEnabled(false);
			}
		});
	}
}
