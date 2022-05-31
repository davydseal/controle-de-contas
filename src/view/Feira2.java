package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Feira2 extends JFrame {

	private JPanel contentPane;
	private JTextField descricao;
	private JTextField valor;
	private JTextField ano;
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
					Feira2 frame = new Feira2();
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
	public Feira2() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Feira2.class.getResource("/img/32395greensalad_98843.png")));
		setTitle("Alimentos P\u00F3s Feira");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 398, 590);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 362, 529);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblDia = new JLabel("Dia");
		lblDia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDia.setBounds(85, 11, 48, 14);
		panel.add(lblDia);
		
		JComboBox dia = new JComboBox();
		dia.setEnabled(false);
		dia.setModel(new DefaultComboBoxModel(new String[] {"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		dia.setBounds(85, 36, 65, 20);
		panel.add(dia);
		
		JLabel lblMs = new JLabel("M\u00EAs");
		lblMs.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMs.setBounds(160, 11, 48, 14);
		panel.add(lblMs);
		
		JLabel lblAno = new JLabel("Ano");
		lblAno.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAno.setBounds(271, 11, 48, 14);
		panel.add(lblAno);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescrio.setBounds(10, 69, 60, 14);
		panel.add(lblDescrio);
		
		descricao = new JTextField();
		descricao.setEnabled(false);
		descricao.setBounds(10, 94, 164, 20);
		panel.add(descricao);
		descricao.setColumns(10);
		
		JLabel lblValor = new JLabel("Valor");
		lblValor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblValor.setBounds(184, 69, 48, 14);
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
		valor.setForeground(Color.RED);
		valor.setBounds(184, 94, 164, 20);
		panel.add(valor);
		valor.setColumns(10);
		
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
		
		JComboBox mes = new JComboBox();
		mes.setEnabled(false);
		mes.setModel(new DefaultComboBoxModel(new String[] {"", "Janeiro", "Fevereiro", "Mar\u00E7o", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"}));
		mes.setBounds(160, 36, 101, 20);
		panel.add(mes);
		
		JLabel lblObserva = new JLabel("Observa\u00E7\u00F5es");
		lblObserva.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblObserva.setBounds(10, 125, 80, 14);
		panel.add(lblObserva);
		
		JTextArea obs = new JTextArea();
		obs.setEnabled(false);
		obs.setBounds(10, 150, 338, 95);
		panel.add(obs);
		obs.setBackground(SystemColor.controlHighlight);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 256, 338, 130);
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
		lblId.setBounds(10, 13, 48, 14);
		panel.add(lblId);
		
		JComboBox id = new JComboBox();
		id.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					String sql ="select * from feira2 where codigo=?";
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
			String s = "select * from feira2";
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
		id.setBounds(10, 35, 65, 20);
		panel.add(id);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.setBounds(32, 413, 89, 23);
		panel.add(btnNovo);
		
		JButton btnSalvar = new JButton("Incluir");
		btnSalvar.setBounds(131, 413, 89, 23);
		panel.add(btnSalvar);
		btnSalvar.setEnabled(false);
		
		JButton btnListar = new JButton("Listar");
		btnListar.setBounds(230, 413, 89, 23);
		panel.add(btnListar);
		
		JButton btnLocalizar = new JButton("Localizar");
		btnLocalizar.setBounds(32, 447, 89, 23);
		panel.add(btnLocalizar);
		
		JButton btnSalvar_1 = new JButton("Salvar");
		btnSalvar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {		
					Connection con = Conexao.faz_conexao();
					
					String sql = "update feira2 set dia=?, mes=?, ano=?, descricao=?, valor=?, obs=? where codigo=?";
					PreparedStatement stmt = con.prepareStatement(sql);
					
					
					stmt.setString(1, (String) dia.getSelectedItem());
					stmt.setString(2, (String) mes.getSelectedItem());
					stmt.setString(3, ano.getText());
					stmt.setString(4, descricao.getText());
					stmt.setString(5, valor.getText());
					stmt.setString(6, obs.getText());
					stmt.setString(7, (String) id.getSelectedItem());

			
					stmt.execute();
					
					stmt.close();
					con.close();
					JOptionPane.showMessageDialog(null, "Alimentos pós feira salvo com sucesso!!!");
					Feira2.this.dispose();
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnSalvar_1.setBounds(131, 447, 89, 23);
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
					String sql = "delete from feira2 where codigo=?";
					
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
					descricao.setText("");
					valor.setText("");
					obs.setText("");

					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			}
		});
		btnExcluir.setBounds(230, 447, 89, 23);
		panel.add(btnExcluir);
		btnExcluir.setEnabled(false);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(131, 481, 89, 23);
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
		btnResetar.setBounds(32, 481, 89, 23);
		panel.add(btnResetar);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Feira2.this.dispose();
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
					String sql = "select * from feira2";
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
					String sql = "insert into feira2 (dia, mes, ano, descricao, valor, obs, status) value (?, ?, ?, ?, ?, ?, 1)";
					
					PreparedStatement stmt = con.prepareStatement(sql);
					
					
					stmt.setString(1, (String) dia.getSelectedItem());
					stmt.setString(2, (String) mes.getSelectedItem());
					stmt.setString(3, ano.getText());
					stmt.setString(4, descricao.getText());
					stmt.setString(5, valor.getText());
					stmt.setString(6, obs.getText());

					
					
					stmt.execute();
					
					stmt.close();
					con.close();
					JOptionPane.showMessageDialog(null, "Gastos salvos com sucesso!");
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
