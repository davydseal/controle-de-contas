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

public class Ganhos_extras extends JFrame {

	private JPanel contentPane;
	private JTextField descricao;
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
					Ganhos_extras frame = new Ganhos_extras();
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
	public Ganhos_extras() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ganhos_extras.class.getResource("/img/money_dollar_cash_coins_riches_wealth_icon-icons.com_53585 (1).png")));
		setTitle("Ganhos Extras");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 397, 581);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 360, 520);
		contentPane.add(panel);
		panel.setLayout(null);
		
		descricao = new JTextField();
		descricao.setEnabled(false);
		descricao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		descricao.setBounds(10, 90, 164, 20);
		panel.add(descricao);
		descricao.setColumns(10);
		
		JLabel lblDescrio_1 = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescrio_1.setBounds(10, 65, 65, 14);
		panel.add(lblDescrio_1);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblValor.setBounds(184, 65, 39, 14);
		panel.add(lblValor);
		
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
		valor.setBounds(184, 90, 164, 20);
		panel.add(valor);
		valor.setColumns(10);
		
		JLabel lblObservaes = new JLabel("Observa\u00E7\u00F5es");
		lblObservaes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblObservaes.setBounds(10, 121, 77, 14);
		panel.add(lblObservaes);
		
		JTextArea obs = new JTextArea();
		obs.setEnabled(false);
		obs.setBounds(10, 146, 338, 95);
		panel.add(obs);
		obs.setBackground(SystemColor.controlHighlight);
		
		JLabel lblMs = new JLabel("M\u00EAs");
		lblMs.setBounds(160, 8, 48, 14);
		panel.add(lblMs);
		lblMs.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JComboBox mes = new JComboBox();
		mes.setEnabled(false);
		mes.setBounds(160, 35, 101, 20);
		panel.add(mes);
		mes.setFont(new Font("Tahoma", Font.PLAIN, 14));
		mes.setModel(new DefaultComboBoxModel(new String[] {"", "Janeiro", "Fevereiro", "Mar\u00E7o", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"}));
		
		JComboBox dia = new JComboBox();
		dia.setEnabled(false);
		dia.setBounds(85, 35, 65, 20);
		panel.add(dia);
		dia.setModel(new DefaultComboBoxModel(new String[] {"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		dia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblDia = new JLabel("Dia");
		lblDia.setBounds(85, 8, 48, 14);
		panel.add(lblDia);
		lblDia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblAno = new JLabel("Ano");
		lblAno.setBounds(271, 9, 48, 14);
		panel.add(lblAno);
		lblAno.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
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
		ano.setBounds(271, 35, 77, 20);
		panel.add(ano);
		ano.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ano.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 252, 338, 131);
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
		
		JLabel lblId = new JLabel("Id");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblId.setBounds(10, 11, 48, 14);
		panel.add(lblId);
		
		JComboBox id = new JComboBox();
		id.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					String sql ="select * from ganhos_extras where codigo=?";
				con = DriverManager.getConnection("jdbc:mysql://localhost/sealf", "root", "");
					PreparedStatement statement = con.prepareStatement(sql);
					statement.setString(1, (String)id.getSelectedItem() );
					
					ResultSet set = statement.executeQuery();

					while (set.next()) {
				     
						dia.setSelectedItem(set.getString("dia"));
						mes.setSelectedItem(set.getString("mes"));
						 ano.setText(set.getString("ano"));
						 descricao.setText(set.getString("descricao"));
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
			String s = "select * from ganhos_extras";
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
		id.setBounds(10, 35, 65, 20);
		panel.add(id);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.setBounds(32, 410, 89, 23);
		panel.add(btnNovo);
		
		JButton btnSalvar = new JButton("Incluir");
		btnSalvar.setEnabled(false);
		btnSalvar.setBounds(131, 410, 89, 23);
		panel.add(btnSalvar);
		
		JButton btnListar = new JButton("Listar");
		btnListar.setBounds(230, 410, 89, 23);
		panel.add(btnListar);
		
		JButton btnLocalizar = new JButton("Localizar");
		btnLocalizar.setBounds(32, 444, 89, 23);
		panel.add(btnLocalizar);
		
		JButton btnSalvar_1 = new JButton("Salvar");
		btnSalvar_1.addActionListener(new ActionListener() {
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
				else if(descricao.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o Descrição!");
				}
				else if(valor.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o campo Valor!");
				}
				else {
				try {		
					Connection con = Conexao.faz_conexao();
					
					String sql = "update ganhos_extras set descricao=?, dia=?, mes=? , ano=? , valor=?, obs=? where codigo=?";
					PreparedStatement stmt = con.prepareStatement(sql);
					
					stmt.setString(1, descricao.getText());
					stmt.setString(2, (String) dia.getSelectedItem());
					stmt.setString(3, (String) mes.getSelectedItem());
					stmt.setString(4, ano.getText());
					stmt.setString(5, valor.getText());
					stmt.setString(6, obs.getText());
					stmt.setString(7, (String) id.getSelectedItem());

			
					stmt.execute();
					
					stmt.close();
					con.close();
					JOptionPane.showMessageDialog(null, "Ganho extra salvo com sucesso!!!");
					Ganhos_extras.this.dispose();
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			}
		});
		btnSalvar_1.setEnabled(false);
		btnSalvar_1.setBounds(131, 444, 89, 23);
		panel.add(btnSalvar_1);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (((String) id.getSelectedItem()).isEmpty()) {
					JOptionPane.showMessageDialog(null, "Selecione o Id!");
				}
				else {
					
				
				try {
					Connection con = Conexao.faz_conexao();
					String sql = "delete from ganhos_extras where codigo=?";
					
					PreparedStatement stmt = con.prepareStatement(sql);

					stmt.setString(1, (String) id.getSelectedItem());
					
					stmt.execute();
					
					stmt.close();
					
					con.close();
					
					JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
					id.setSelectedItem(null);
					descricao.setText("");
					dia.setSelectedItem(null);
					mes.setSelectedItem(null);
					ano.setText("");
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
		btnExcluir.setBounds(230, 444, 89, 23);
		panel.add(btnExcluir);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(131, 478, 89, 23);
		panel.add(btnSair);
		
		JButton btnResetar = new JButton("Resetar");
		btnResetar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				id.setSelectedItem(null); 
				dia.setSelectedItem(null); 
				mes.setSelectedItem(null); 
				ano.setText("");
				descricao.setText("");
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
				btnSalvar_1.setEnabled(false);
				btnExcluir.setEnabled(false);
				
				table.setModel(new DefaultTableModel (null, new String [] {"Id","Dia","Mês","Ano","Descrição","Valor","Obs"}));
			}
		});
		btnResetar.setBounds(32, 478, 89, 23);
		panel.add(btnResetar);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ganhos_extras.this.dispose();
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
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection con = Conexao.faz_conexao();
					String sql = "select * from ganhos_extras";
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
				else if(descricao.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o Descrição!");
				}
				else if(valor.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o campo Valor!");
				}
				else {
				try {
					Connection con = Conexao.faz_conexao();
					String sql = "insert into ganhos_extras(descricao, dia, mes, ano, valor, obs, status) value (?, ?, ?, ?, ?, ?, 1)";
					
					PreparedStatement stmt = con.prepareStatement(sql);
					
					stmt.setString(1, descricao.getText());
					stmt.setString(2, (String) dia.getSelectedItem());
					stmt.setString(3, (String) mes.getSelectedItem());
					stmt.setString(4, ano.getText());
					stmt.setString(5, valor.getText());
					stmt.setString(6, obs.getText());

					
					
					stmt.execute();
					
					stmt.close();
					con.close();
					JOptionPane.showMessageDialog(null, "Ganhos extras salvos com sucesso!");
					descricao.setText("");
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
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dia.setEnabled(true);
				mes.setEnabled(true);
				ano.setEnabled(true);
				descricao.setEnabled(true);
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
