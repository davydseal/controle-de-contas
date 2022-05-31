package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import util.Calcular4;
import util.Calcular5;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class Relatorio extends JFrame {

	private JPanel contentPane;
	Connection con;
	Statement st;
	ResultSet rs;
	private JTable table_2;
	private JTable table_3;
	private JTextField total3;
	private JTextField total4;
	private JTextField textField_5;
	private JTable table_5;
	private JTextField textField;
	private JTable table_6;
	private JTextField textField_1;
	private JTable table_7;
	private JTextField textField_2;
	private JTable table;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTable table_4;
	private JTable table_8;
	private JTextField textField_9;
	private JTable table_9;

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
					Relatorio frame = new Relatorio();
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
	public Relatorio() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Relatorio.class.getResource("/img/business_salesreport_salesreport_negocio_2353.png")));
		setTitle("Relat\u00F3rios");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setBounds(100, 100, 1385, 740);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		contentPane.add(tabbedPane, BorderLayout.CENTER);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		tabbedPane.addTab("Ganhos dos Im\u00F3veis", null, panel_5, null);
		panel_5.setLayout(null);
		
		JPanel panel_17 = new JPanel();
		panel_17.setLayout(null);
		panel_17.setBounds(10, 11, 662, 135);
		panel_5.add(panel_17);
		
		JLabel label_6 = new JLabel("M\u00EAs");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_6.setBounds(10, 11, 26, 14);
		panel_17.add(label_6);
		
		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setModel(new DefaultComboBoxModel(new String[] {"", "Janeiro", "Fevereiro", "Mar\u00E7o", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"}));
		comboBox_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_6.setBounds(10, 36, 323, 22);
		panel_17.add(comboBox_6);
		
		JButton button_10 = new JButton("Sair");
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Relatorio.this.dispose();
			}
		});
		button_10.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_10.setBounds(232, 79, 101, 23);
		panel_17.add(button_10);
		
		JButton button_11 = new JButton("Ver Todos");
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				try {
					Connection con = Conexao.faz_conexao();
					String sql = "select * from ganhos_apt";
					java.sql.PreparedStatement stmt = con.prepareStatement(sql);
					ResultSet rs = stmt.executeQuery();
					
					DefaultTableModel  modelo = (DefaultTableModel) table_6.getModel();
					modelo.setNumRows(0);
					float soma =0;
					while(rs.next()) {
						soma+=Float.parseFloat(rs.getString("valor"));

						modelo.addRow(new Object[] {rs.getString("mes"), rs.getString("valor")});
						
							}

					textField.setText(""+soma);
					rs.first();
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		button_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_11.setBounds(121, 79, 101, 23);
		panel_17.add(button_11);
		
		JButton button_12 = new JButton("Consultar");
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String sql ="select * from ganhos_apt where mes=?";
					con = DriverManager.getConnection("jdbc:mysql://localhost/sealf", "root", "");
					java.sql.PreparedStatement statement = con.prepareStatement(sql);
					statement.setString(1, (String)comboBox_6.getSelectedItem() );
					ResultSet set = statement.executeQuery();

					
					DefaultTableModel  modelo = (DefaultTableModel) table_6.getModel();
					modelo.setNumRows(0);
					Double soma =0.0;
					while(set.next()) {
						soma+=Double.parseDouble(set.getString("valor"));

						modelo.addRow(new Object[] {set.getString("mes"), set.getString("valor")});
					}
					textField.setText(""+soma);
					set.first();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		button_12.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_12.setBounds(10, 79, 101, 23);
		panel_17.add(button_12);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setForeground(Color.BLUE);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 45));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(343, 36, 267, 66);
		panel_17.add(textField);
		
		JLabel lblGanhosDosApartamentos = new JLabel("Ganhos dos Im\u00F3veis");
		lblGanhosDosApartamentos.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGanhosDosApartamentos.setBounds(343, 11, 129, 14);
		panel_17.add(lblGanhosDosApartamentos);
		
		JScrollPane scrollPane_6 = new JScrollPane();
		scrollPane_6.setBounds(10, 157, 1334, 495);
		panel_5.add(scrollPane_6);
		
		table_6 = new JTable();
		table_6.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				"M\u00EAs", "Valor"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane_6.setViewportView(table_6);
		
		JPanel panel_18 = new JPanel();
		panel_18.setLayout(null);
		panel_18.setBounds(682, 11, 662, 135);
		panel_5.add(panel_18);
		
		JLabel label_5 = new JLabel("Gastos");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_5.setBounds(10, 12, 48, 14);
		panel_18.add(label_5);
		
		textField_6 = new JTextField();
		textField_6.setHorizontalAlignment(SwingConstants.CENTER);
		textField_6.setForeground(Color.RED);
		textField_6.setFont(new Font("Tahoma", Font.PLAIN, 50));
		textField_6.setColumns(10);
		textField_6.setBounds(10, 36, 230, 65);
		panel_18.add(textField_6);
		
		JLabel label_11 = new JLabel("Resultado");
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_11.setBounds(250, 11, 61, 14);
		panel_18.add(label_11);
		
		textField_7 = new JTextField();
		textField_7.setHorizontalAlignment(SwingConstants.CENTER);
		textField_7.setForeground(Color.BLUE);
		textField_7.setFont(new Font("Tahoma", Font.PLAIN, 50));
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setBounds(250, 36, 230, 65);
		panel_18.add(textField_7);
		
		JButton button_2 = new JButton("Calcular");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textField.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
				}
				else if(textField_6.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
				}
				else {
					
				
				Calcular5 calc = new Calcular5();

				calc.setN4(Float.parseFloat(textField.getText()));
				calc.setN5(Float.parseFloat(textField_6.getText()));
				
				textField_7.setText(String.valueOf(calc.calcula()));
				}
				
			}
		});
		button_2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		button_2.setBounds(490, 36, 119, 65);
		panel_18.add(button_2);
		
		JPanel panel_19 = new JPanel();
		panel_19.setBackground(Color.WHITE);
		tabbedPane.addTab("Ganhos do Sal\u00E1rio", null, panel_19, null);
		panel_19.setLayout(null);
		
		JPanel panel_20 = new JPanel();
		panel_20.setLayout(null);
		panel_20.setBounds(10, 11, 662, 135);
		panel_19.add(panel_20);
		
		JLabel label_7 = new JLabel("M\u00EAs");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_7.setBounds(10, 11, 26, 14);
		panel_20.add(label_7);
		
		JComboBox comboBox_7 = new JComboBox();
		comboBox_7.setModel(new DefaultComboBoxModel(new String[] {"", "Janeiro", "Fevereiro", "Mar\u00E7o", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"}));
		comboBox_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_7.setBounds(10, 36, 323, 22);
		panel_20.add(comboBox_7);
		
		JButton button_13 = new JButton("Sair");
		button_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Relatorio.this.dispose();
			}
		});
		button_13.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_13.setBounds(232, 79, 101, 23);
		panel_20.add(button_13);
		
		JButton button_14 = new JButton("Ver Todos");
		button_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_1.setText("");
				try {
					Connection con = Conexao.faz_conexao();
					String sql = "select * from ganhos";
					java.sql.PreparedStatement stmt = con.prepareStatement(sql);
					ResultSet rs = stmt.executeQuery();
					
					DefaultTableModel  modelo = (DefaultTableModel) table_7.getModel();
					modelo.setNumRows(0);
					float soma =0;
					while(rs.next()) {
						soma+=Float.parseFloat(rs.getString("valor"));

						modelo.addRow(new Object[] {rs.getString("dia"), rs.getString("mes"), rs.getString("ano"), rs.getString("descricao"), rs.getString("valor"), rs.getString("obs")});
						
							}

					textField_1.setText(""+soma);
					rs.first();
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		button_14.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_14.setBounds(121, 79, 101, 23);
		panel_20.add(button_14);
		
		JButton button_15 = new JButton("Consultar");
		button_15.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String sql ="select * from ganhos where mes=?";
					con = DriverManager.getConnection("jdbc:mysql://localhost/sealf", "root", "");
					java.sql.PreparedStatement statement = con.prepareStatement(sql);
					statement.setString(1, (String)comboBox_7.getSelectedItem() );
					ResultSet set = statement.executeQuery();

					
					DefaultTableModel  modelo = (DefaultTableModel) table_7.getModel();
					modelo.setNumRows(0);
					float soma =0;
					while(set.next()) {
						soma+=Float.parseFloat(set.getString("valor"));

						modelo.addRow(new Object[] {set.getString("dia"), set.getString("mes"), set.getString("ano"), set.getString("descricao"), set.getString("valor"), set.getString("obs")});
					}
					textField_1.setText(""+soma);
					set.first();
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
			}
		});
		button_15.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_15.setBounds(10, 79, 101, 23);
		panel_20.add(button_15);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setForeground(Color.BLUE);
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 45));
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(343, 36, 267, 66);
		panel_20.add(textField_1);
		
		JLabel lblGanhosDoSalrio_1 = new JLabel("Ganhos do Sal\u00E1rio");
		lblGanhosDoSalrio_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGanhosDoSalrio_1.setBounds(343, 11, 129, 14);
		panel_20.add(lblGanhosDoSalrio_1);
		
		JPanel panel_21 = new JPanel();
		panel_21.setLayout(null);
		panel_21.setBounds(682, 11, 662, 135);
		panel_19.add(panel_21);
		
		JLabel lblGanhosDoSalrio = new JLabel("GANHOS DO SAL\u00C1RIO");
		lblGanhosDoSalrio.setForeground(Color.BLUE);
		lblGanhosDoSalrio.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblGanhosDoSalrio.setBounds(203, 51, 255, 32);
		panel_21.add(lblGanhosDoSalrio);
		
		JScrollPane scrollPane_7 = new JScrollPane();
		scrollPane_7.setBounds(10, 157, 1334, 495);
		panel_19.add(scrollPane_7);
		
		table_7 = new JTable();
		table_7.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"Dia", "M\u00EAs", "Ano", "Descri\u00E7\u00E3o", "Valor", "Obs"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane_7.setViewportView(table_7);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		tabbedPane.addTab("Ganhos Extras", null, panel, null);
		panel.setLayout(null);
		
		JPanel panel_14 = new JPanel();
		panel_14.setLayout(null);
		panel_14.setBounds(10, 11, 662, 135);
		panel.add(panel_14);
		
		JLabel label_8 = new JLabel("M\u00EAs");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_8.setBounds(10, 11, 26, 14);
		panel_14.add(label_8);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] {"", "Janeiro", "Fevereiro", "Mar\u00E7o", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"}));
		comboBox_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_5.setBounds(10, 36, 323, 22);
		panel_14.add(comboBox_5);
		
		JButton button_7 = new JButton("Sair");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Relatorio.this.dispose();
			}
		});
		button_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_7.setBounds(232, 79, 101, 23);
		panel_14.add(button_7);
		
		JButton button_8 = new JButton("Ver Todos");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_5.setText("");
				try {
					Connection con = Conexao.faz_conexao();
					String sql = "select * from ganhos_extras";
					java.sql.PreparedStatement stmt = con.prepareStatement(sql);
					ResultSet rs = stmt.executeQuery();
					
					DefaultTableModel  modelo = (DefaultTableModel) table_5.getModel();
					modelo.setNumRows(0);
					float soma =0;
					while(rs.next()) {
						soma+=Float.parseFloat(rs.getString("valor"));

						modelo.addRow(new Object[] {rs.getString("dia"), rs.getString("mes"), rs.getString("ano"), rs.getString("descricao"), rs.getString("valor"), rs.getString("obs")});
						
							}

					textField_5.setText(""+soma);
					rs.first();
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		button_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_8.setBounds(121, 79, 101, 23);
		panel_14.add(button_8);
		
		JButton button_9 = new JButton("Consultar");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String sql ="select * from ganhos_extras where mes=?";
					con = DriverManager.getConnection("jdbc:mysql://localhost/sealf", "root", "");
					java.sql.PreparedStatement statement = con.prepareStatement(sql);
					statement.setString(1, (String)comboBox_5.getSelectedItem() );
					ResultSet set = statement.executeQuery();

					
					DefaultTableModel  modelo = (DefaultTableModel) table_5.getModel();
					modelo.setNumRows(0);
					float soma =0;
					while(set.next()) {
						soma+=Float.parseFloat(set.getString("valor"));

						modelo.addRow(new Object[] {set.getString("dia"), set.getString("mes"), set.getString("ano"), set.getString("descricao"), set.getString("valor"), set.getString("obs")});
					}
					textField_5.setText(""+soma);
					set.first();
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
			}
		});
		button_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_9.setBounds(10, 79, 101, 23);
		panel_14.add(button_9);
		
		textField_5 = new JTextField();
		textField_5.setHorizontalAlignment(SwingConstants.CENTER);
		textField_5.setEditable(false);
		textField_5.setForeground(Color.BLUE);
		textField_5.setFont(new Font("Tahoma", Font.PLAIN, 45));
		textField_5.setColumns(10);
		textField_5.setBounds(343, 36, 267, 65);
		panel_14.add(textField_5);
		
		JLabel lblGanhosExtras_1 = new JLabel("Ganhos Extras");
		lblGanhosExtras_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGanhosExtras_1.setBounds(343, 11, 96, 14);
		panel_14.add(lblGanhosExtras_1);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(10, 157, 1334, 495);
		panel.add(scrollPane_5);
		
		table_5 = new JTable();
		table_5.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"Dia", "M\u00EAs", "Ano", "Descri\u00E7\u00E3o", "Valor", "Obs"
			}
		));
		scrollPane_5.setViewportView(table_5);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(682, 11, 662, 135);
		panel.add(panel_2);
		
		JLabel lblGanhosExtras_2 = new JLabel("GANHOS EXTRAS");
		lblGanhosExtras_2.setForeground(Color.BLUE);
		lblGanhosExtras_2.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblGanhosExtras_2.setBounds(231, 51, 199, 32);
		panel_2.add(lblGanhosExtras_2);
		
		JPanel panel_27 = new JPanel();
		panel_27.setBackground(Color.WHITE);
		tabbedPane.addTab("Gastos Fixos", null, panel_27, null);
		panel_27.setLayout(null);
		
		JPanel panel_28 = new JPanel();
		panel_28.setLayout(null);
		panel_28.setBounds(10, 11, 662, 135);
		panel_27.add(panel_28);
		
		JLabel label_15 = new JLabel("M\u00EAs");
		label_15.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_15.setBounds(10, 11, 26, 14);
		panel_28.add(label_15);
		
		JComboBox comboBox_9 = new JComboBox();
		comboBox_9.setModel(new DefaultComboBoxModel(new String[] {"", "Janeiro", "Fevereiro", "Mar\u00E7o", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"}));
		comboBox_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_9.setBounds(10, 36, 323, 22);
		panel_28.add(comboBox_9);
		
		JButton button_22 = new JButton("Sair");
		button_22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Relatorio.this.dispose();
			}
		});
		button_22.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_22.setBounds(232, 79, 101, 23);
		panel_28.add(button_22);
		
		JButton button_23 = new JButton("Ver Todos");
		button_23.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_9.setText("");
				try {
					Connection con = Conexao.faz_conexao();
					String sql = "select * from gastos_fixo order by dia asc";
					java.sql.PreparedStatement stmt = con.prepareStatement(sql);
					ResultSet rs = stmt.executeQuery();
					
					DefaultTableModel  modelo = (DefaultTableModel) table_9.getModel();
					modelo.setNumRows(0);
					float soma =0;
					while(rs.next()) {
						soma+=Float.parseFloat(rs.getString("valor"));
						modelo.addRow(new Object[] {rs.getString("dia"), rs.getString("mes"), rs.getString("ano"), rs.getString("descricao"), rs.getString("valor"), rs.getString("obs")});
						
							}

					textField_9.setText(""+soma);
					rs.first();
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		button_23.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_23.setBounds(121, 79, 101, 23);
		panel_28.add(button_23);
		
		JButton button_24 = new JButton("Consultar");
		button_24.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String sql ="select * from gastos_fixo where mes=? order by dia asc";
					con = DriverManager.getConnection("jdbc:mysql://localhost/sealf", "root", "");
					java.sql.PreparedStatement statement = con.prepareStatement(sql);
					statement.setString(1, (String)comboBox_9.getSelectedItem() );
					ResultSet set = statement.executeQuery();

					
					DefaultTableModel  modelo = (DefaultTableModel) table_9.getModel();
					modelo.setNumRows(0);
					float soma =0;
					while(set.next()) {
						soma+=Float.parseFloat(set.getString("valor"));


						modelo.addRow(new Object[] {set.getString("dia"), set.getString("mes"), set.getString("ano"), set.getString("descricao"), set.getString("valor"), set.getString("obs")});
					}
					textField_9.setText(""+soma);
					set.first();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		button_24.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_24.setBounds(10, 79, 101, 23);
		panel_28.add(button_24);
		
		textField_9 = new JTextField();
		textField_9.setHorizontalAlignment(SwingConstants.CENTER);
		textField_9.setForeground(Color.RED);
		textField_9.setFont(new Font("Tahoma", Font.PLAIN, 45));
		textField_9.setEditable(false);
		textField_9.setColumns(10);
		textField_9.setBounds(343, 37, 267, 65);
		panel_28.add(textField_9);
		
		JLabel label_16 = new JLabel("Gastos Fixos");
		label_16.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_16.setBounds(343, 11, 76, 14);
		panel_28.add(label_16);
		
		JPanel panel_29 = new JPanel();
		panel_29.setLayout(null);
		panel_29.setBounds(682, 11, 662, 135);
		panel_27.add(panel_29);
		
		JLabel lblGastos = new JLabel("GASTOS");
		lblGastos.setForeground(Color.RED);
		lblGastos.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblGastos.setBounds(284, 51, 94, 32);
		panel_29.add(lblGastos);
		
		JScrollPane scrollPane_9 = new JScrollPane();
		scrollPane_9.setBounds(10, 157, 1334, 495);
		panel_27.add(scrollPane_9);
		
		table_9 = new JTable();
		table_9.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"Dia", "M\u00EAs", "Ano", "Descri\u00E7\u00E3o", "Valor", "Obs"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane_9.setViewportView(table_9);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBackground(Color.WHITE);
		tabbedPane.addTab("Alimentos P\u00F3s Feira", null, panel_12, null);
		panel_12.setLayout(null);
		
		JPanel panel_13 = new JPanel();
		panel_13.setLayout(null);
		panel_13.setBounds(10, 11, 662, 135);
		panel_12.add(panel_13);
		
		JLabel label_12 = new JLabel("M\u00EAs");
		label_12.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_12.setBounds(10, 11, 26, 14);
		panel_13.add(label_12);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"", "Janeiro", "Fevereiro", "Mar\u00E7o", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"}));
		comboBox_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_4.setBounds(10, 36, 323, 22);
		panel_13.add(comboBox_4);
		
		JButton button_3 = new JButton("Sair");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Relatorio.this.dispose();
			}
		});
		button_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_3.setBounds(232, 79, 101, 23);
		panel_13.add(button_3);
		
		JButton button_5 = new JButton("Ver Todos");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_8.setText("");
				try {
					Connection con = Conexao.faz_conexao();
					String sql = "select * from feira2 order by dia asc";
					java.sql.PreparedStatement stmt = con.prepareStatement(sql);
					ResultSet rs = stmt.executeQuery();
					
					DefaultTableModel  modelo = (DefaultTableModel) table_4.getModel();
					modelo.setNumRows(0);
					float soma =0;
					while(rs.next()) {
						soma+=Float.parseFloat(rs.getString("valor"));
						modelo.addRow(new Object[] {rs.getString("dia"), rs.getString("mes"), rs.getString("ano"), rs.getString("descricao"), rs.getString("valor"), rs.getString("obs")});
						
							}

					textField_8.setText(""+soma);
					rs.first();
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		button_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_5.setBounds(121, 79, 101, 23);
		panel_13.add(button_5);
		
		JButton button_18 = new JButton("Consultar");
		button_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String sql ="select * from feira2 where mes=? order by dia asc";
					con = DriverManager.getConnection("jdbc:mysql://localhost/sealf", "root", "");
					java.sql.PreparedStatement statement = con.prepareStatement(sql);
					statement.setString(1, (String)comboBox_4.getSelectedItem() );
					ResultSet set = statement.executeQuery();

					
					DefaultTableModel  modelo = (DefaultTableModel) table_4.getModel();
					modelo.setNumRows(0);
					float soma =0;
					while(set.next()) {
						soma+=Float.parseFloat(set.getString("valor"));

						modelo.addRow(new Object[] {set.getString("dia"), set.getString("mes"), set.getString("ano"), set.getString("descricao"), set.getString("valor"), set.getString("obs")});
					}
					textField_8.setText(""+soma);
					set.first();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		button_18.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_18.setBounds(10, 79, 101, 23);
		panel_13.add(button_18);
		
		textField_8 = new JTextField();
		textField_8.setHorizontalAlignment(SwingConstants.CENTER);
		textField_8.setForeground(Color.RED);
		textField_8.setFont(new Font("Tahoma", Font.PLAIN, 45));
		textField_8.setEditable(false);
		textField_8.setColumns(10);
		textField_8.setBounds(343, 37, 267, 65);
		panel_13.add(textField_8);
		
		JLabel label_13 = new JLabel("Gastos Fixos");
		label_13.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_13.setBounds(343, 11, 76, 14);
		panel_13.add(label_13);
		
		JPanel panel_23 = new JPanel();
		panel_23.setLayout(null);
		panel_23.setBounds(682, 11, 662, 135);
		panel_12.add(panel_23);
		
		JLabel lblGastosComFeira = new JLabel("ALIMENTOS P\u00D3S FEIRA");
		lblGastosComFeira.setForeground(Color.RED);
		lblGastosComFeira.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblGastosComFeira.setBounds(195, 51, 271, 32);
		panel_23.add(lblGastosComFeira);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(10, 157, 1334, 495);
		panel_12.add(scrollPane_4);
		
		table_4 = new JTable();
		table_4.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"Dia", "M\u00EAs", "Ano", "Descri\u00E7\u00E3o", "Valor", "Observa\u00E7\u00F5es"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane_4.setViewportView(table_4);
		
		JPanel panel_15 = new JPanel();
		panel_15.setBackground(Color.WHITE);
		tabbedPane.addTab("Gastos Extras", null, panel_15, null);
		panel_15.setLayout(null);
		
		JPanel panel_16 = new JPanel();
		panel_16.setLayout(null);
		panel_16.setBounds(10, 11, 662, 135);
		panel_15.add(panel_16);
		
		JLabel label_9 = new JLabel("M\u00EAs");
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_9.setBounds(10, 11, 26, 14);
		panel_16.add(label_9);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"", "Janeiro", "Fevereiro", "Mar\u00E7o", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"}));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setBounds(10, 36, 338, 22);
		panel_16.add(comboBox);
		
		JButton button_1 = new JButton("Sair");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Relatorio.this.dispose();
			}
		});
		button_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_1.setBounds(242, 79, 106, 23);
		panel_16.add(button_1);
		
		JButton button_16 = new JButton("Ver Todos");
		button_16.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_2.setText("");
				try {
					Connection con = Conexao.faz_conexao();
					String sql = "select * from gastos_extras order by dia asc";
					java.sql.PreparedStatement stmt = con.prepareStatement(sql);
					ResultSet rs = stmt.executeQuery();
					
					DefaultTableModel  modelo = (DefaultTableModel) table.getModel();
					modelo.setNumRows(0);
					float soma =0;
					while(rs.next()) {
						soma+=Float.parseFloat(rs.getString("valor"));
						modelo.addRow(new Object[] {rs.getString("dia"), rs.getString("mes"), rs.getString("ano"), rs.getString("descricao1"), rs.getString("descricao2"), rs.getString("valor"), rs.getString("obs")});
						
							}

					textField_2.setText(""+soma);
					rs.first();
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		button_16.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_16.setBounds(126, 79, 106, 23);
		panel_16.add(button_16);
		
		JButton button_17 = new JButton("Consultar");
		button_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String sql ="select * from gastos_extras where mes=? order by dia asc";
					con = DriverManager.getConnection("jdbc:mysql://localhost/sealf", "root", "");
					java.sql.PreparedStatement statement = con.prepareStatement(sql);
					statement.setString(1, (String)comboBox.getSelectedItem() );
					ResultSet set = statement.executeQuery();

					
					DefaultTableModel  modelo = (DefaultTableModel) table.getModel();
					modelo.setNumRows(0);
					float soma =0;
					while(set.next()) {
						soma+=Float.parseFloat(set.getString("valor"));
						modelo.addRow(new Object[] {set.getString("dia"), set.getString("mes"), set.getString("ano"), set.getString("descricao1"), set.getString("descricao2"), set.getString("valor"), set.getString("obs")});
					}
					textField_2.setText(""+soma);
					set.first();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		button_17.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_17.setBounds(10, 79, 106, 23);
		panel_16.add(button_17);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.CENTER);
		textField_2.setForeground(Color.RED);
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 45));
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(358, 37, 252, 65);
		panel_16.add(textField_2);
		
		JLabel label_10 = new JLabel("Gastos Extras");
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_10.setBounds(358, 11, 83, 14);
		panel_16.add(label_10);
		
		JPanel panel_22 = new JPanel();
		panel_22.setLayout(null);
		panel_22.setBounds(682, 11, 662, 135);
		panel_15.add(panel_22);
		
		JLabel lblGastosExtras_2 = new JLabel("GASTOS EXTRAS");
		lblGastosExtras_2.setForeground(Color.RED);
		lblGastosExtras_2.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblGastosExtras_2.setBounds(234, 51, 193, 32);
		panel_22.add(lblGastosExtras_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 157, 1334, 495);
		panel_15.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"Dia", "M\u00EAs", "Ano", "Descri\u00E7\u00E3o", "Outros", "Valor", "Obs"
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
		
		JPanel panel_24 = new JPanel();
		panel_24.setBackground(Color.WHITE);
		tabbedPane.addTab("Controle do G\u00E1s", null, panel_24, null);
		panel_24.setLayout(null);
		
		JPanel panel_25 = new JPanel();
		panel_25.setLayout(null);
		panel_25.setBounds(10, 11, 662, 135);
		panel_24.add(panel_25);
		
		JLabel label_14 = new JLabel("M\u00EAs");
		label_14.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_14.setBounds(10, 11, 26, 14);
		panel_25.add(label_14);
		
		JComboBox comboBox_8 = new JComboBox();
		comboBox_8.setModel(new DefaultComboBoxModel(new String[] {""}));
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/sealf", "root", "");
			st = con.createStatement();
			String s = "select * from controle_gas";
			rs = st.executeQuery(s);
			
			while(rs.next()){
				comboBox_8.addItem(rs.getString("datai"));
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
		comboBox_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_8.setBounds(10, 36, 338, 22);
		panel_25.add(comboBox_8);
		
		JButton button_19 = new JButton("Sair");
		button_19.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Relatorio.this.dispose();
			}
		});
		button_19.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_19.setBounds(242, 79, 106, 23);
		panel_25.add(button_19);
		
		JButton button_20 = new JButton("Ver Todos");
		button_20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection con = Conexao.faz_conexao();
					String sql = "select * from controle_gas";
					java.sql.PreparedStatement stmt = con.prepareStatement(sql);
					ResultSet rs = stmt.executeQuery();
					
					DefaultTableModel  modelo = (DefaultTableModel) table_8.getModel();
					modelo.setNumRows(0);
					
					while(rs.next()) {
						
						modelo.addRow(new Object[] {rs.getString("datai"), rs.getString("dataf"), rs.getString("local"), rs.getString("obs")});
						
							}


					
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		button_20.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_20.setBounds(126, 79, 106, 23);
		panel_25.add(button_20);
		
		JButton button_21 = new JButton("Consultar");
		button_21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String sql ="select * from controle_gas where datai=?";
					con = DriverManager.getConnection("jdbc:mysql://localhost/sealf", "root", "");
					java.sql.PreparedStatement statement = con.prepareStatement(sql);
					statement.setString(1, (String)comboBox_8.getSelectedItem() );
					ResultSet set = statement.executeQuery();

					
					DefaultTableModel  modelo = (DefaultTableModel) table_8.getModel();
					modelo.setNumRows(0);
				
					while(set.next()) {
					
						modelo.addRow(new Object[] {set.getString("datai"), set.getString("dataf"), set.getString("local"), set.getString("obs")});
					}
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		button_21.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_21.setBounds(10, 79, 106, 23);
		panel_25.add(button_21);
		
		JPanel panel_26 = new JPanel();
		panel_26.setLayout(null);
		panel_26.setBounds(682, 11, 662, 135);
		panel_24.add(panel_26);
		
		JLabel lblControleDoGs = new JLabel("CONTROLE DO G\u00C1S");
		lblControleDoGs.setForeground(Color.RED);
		lblControleDoGs.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblControleDoGs.setBounds(217, 51, 227, 32);
		panel_26.add(lblControleDoGs);
		
		JScrollPane scrollPane_8 = new JScrollPane();
		scrollPane_8.setBounds(10, 157, 1334, 495);
		panel_24.add(scrollPane_8);
		
		table_8 = new JTable();
		table_8.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"Data Inicial", "Data Final", "Local", "Observa\u00E7\u00F5es"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane_8.setViewportView(table_8);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.WHITE);
		tabbedPane.addTab("Ganhos do Bolo", null, panel_6, null);
		panel_6.setLayout(null);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBounds(10, 11, 662, 135);
		panel_6.add(panel_7);
		
		JLabel label_1 = new JLabel("M\u00EAs");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(10, 11, 26, 14);
		panel_7.add(label_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"", "Janeiro", "Fevereiro", "Mar\u00E7o", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"}));
		comboBox_2.setBounds(10, 36, 323, 22);
		panel_7.add(comboBox_2);
		
		JButton button_4 = new JButton("Sair");
		button_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Relatorio.this.dispose();
			}
		});
		button_4.setBounds(232, 79, 101, 23);
		panel_7.add(button_4);
		
		JButton btnVerTodos_2 = new JButton("Ver Todos");
		btnVerTodos_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVerTodos_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				total3.setText("");
				try {
					Connection con = Conexao.faz_conexao();
					String sql = "select * from ganhos_bolo order by dia asc";
					java.sql.PreparedStatement stmt = con.prepareStatement(sql);
					ResultSet rs = stmt.executeQuery();
					
					DefaultTableModel  modelo = (DefaultTableModel) table_2.getModel();
					modelo.setNumRows(0);
					float soma =0;
					while(rs.next()) {
						soma+=Float.parseFloat(rs.getString("valor"));
						modelo.addRow(new Object[] {rs.getString("dia"), rs.getString("mes"), rs.getString("ano"), rs.getString("cliente"), rs.getString("local"), rs.getString("valor")});
						
							}
					total3.setText(""+soma);
					rs.first();
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
			
			}
		});
		btnVerTodos_2.setBounds(121, 79, 101, 23);
		panel_7.add(btnVerTodos_2);
		
		JButton btnConsultar_2 = new JButton("Consultar");
		btnConsultar_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConsultar_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String sql ="select * from ganhos_bolo where mes=? order by dia asc";
					con = DriverManager.getConnection("jdbc:mysql://localhost/sealf", "root", "");
					java.sql.PreparedStatement statement = con.prepareStatement(sql);
					statement.setString(1, (String)comboBox_2.getSelectedItem() );
					ResultSet set = statement.executeQuery();

					
					DefaultTableModel  modelo = (DefaultTableModel) table_2.getModel();
					modelo.setNumRows(0);
					float soma =0;
					while(set.next()) {
				
						soma+=Float.parseFloat(set.getString("valor"));

						modelo.addRow(new Object[] {set.getString("dia"), set.getString("mes"), set.getString("ano"), set.getString("cliente"), set.getString("local"), set.getString("valor")});
					}
					total3.setText(""+soma);
					set.first();
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
			}
		});
		btnConsultar_2.setBounds(10, 79, 101, 23);
		panel_7.add(btnConsultar_2);
		
		JLabel label_3 = new JLabel("Ganhos");
		label_3.setBounds(343, 11, 48, 14);
		panel_7.add(label_3);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		total3 = new JTextField();
		total3.setBounds(343, 37, 267, 65);
		panel_7.add(total3);
		total3.setHorizontalAlignment(SwingConstants.CENTER);
		total3.setEditable(false);
		total3.setFont(new Font("Tahoma", Font.PLAIN, 50));
		total3.setForeground(Color.BLUE);
		total3.setColumns(10);
		
		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBounds(682, 11, 662, 135);
		panel_6.add(panel_8);
		
		textField_3 = new JTextField();
		textField_3.setHorizontalAlignment(SwingConstants.CENTER);
		textField_3.setForeground(Color.RED);
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 50));
		textField_3.setBounds(10, 37, 230, 65);
		panel_8.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setHorizontalAlignment(SwingConstants.CENTER);
		textField_4.setForeground(Color.BLUE);
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 50));
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(250, 37, 230, 65);
		panel_8.add(textField_4);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(total3.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
				}
				else if(textField_3.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
				}
				else {
					
				
				Calcular4 calc = new Calcular4();

				calc.setN4(Float.parseFloat(total3.getText()));
				calc.setN5(Float.parseFloat(textField_3.getText()));
				
				textField_4.setText(String.valueOf(calc.calcula()));
				}
				
			}
		});
		btnCalcular.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnCalcular.setBounds(490, 37, 119, 65);
		panel_8.add(btnCalcular);
		
		JLabel lblNewLabel = new JLabel("Gastos");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(10, 13, 48, 14);
		panel_8.add(lblNewLabel);
		
		JLabel lblResultado = new JLabel("Resultado");
		lblResultado.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblResultado.setBounds(250, 12, 61, 14);
		panel_8.add(lblResultado);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 157, 1334, 495);
		panel_6.add(scrollPane_2);
		
		table_2 = new JTable();
		table_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"Dia", "M\u00EAs", "Ano", "Cliente", "Local", "Valor"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane_2.setViewportView(table_2);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(Color.WHITE);
		tabbedPane.addTab("Gastos do Bolo", null, panel_9, null);
		panel_9.setLayout(null);
		
		JPanel panel_10 = new JPanel();
		panel_10.setLayout(null);
		panel_10.setBounds(10, 11, 662, 135);
		panel_9.add(panel_10);
		
		JLabel label_2 = new JLabel("M\u00EAs");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(10, 11, 26, 14);
		panel_10.add(label_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"", "Janeiro", "Fevereiro", "Mar\u00E7o", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"}));
		comboBox_3.setBounds(10, 36, 323, 22);
		panel_10.add(comboBox_3);
		
		JButton button_6 = new JButton("Sair");
		button_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Relatorio.this.dispose();
			}
		});
		button_6.setBounds(232, 79, 101, 23);
		panel_10.add(button_6);
		
		JButton btnVerTodos_3 = new JButton("Ver Todos");
		btnVerTodos_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnVerTodos_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				total4.setText("");
				try {
					Connection con = Conexao.faz_conexao();
					String sql = "select * from gastos_bolo order by dia asc";
					java.sql.PreparedStatement stmt = con.prepareStatement(sql);
					ResultSet rs = stmt.executeQuery();
					
					DefaultTableModel  modelo = (DefaultTableModel) table_3.getModel();
					modelo.setNumRows(0);
					double soma =0;
					while(rs.next()) {
						soma+=Double.parseDouble(rs.getString("valor"));
						modelo.addRow(new Object[] {rs.getString("dia"), rs.getString("mes"), rs.getString("ano"), rs.getString("descricao"), rs.getString("valor"), rs.getString("obs")});
						
							}

					total4.setText(""+soma);
					rs.first();
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		btnVerTodos_3.setBounds(121, 79, 101, 23);
		panel_10.add(btnVerTodos_3);
		
		JButton btnConsultar_3 = new JButton("Consultar");
		btnConsultar_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConsultar_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String sql ="select * from gastos_bolo where mes=? order by dia asc";
					con = DriverManager.getConnection("jdbc:mysql://localhost/sealf", "root", "");
					java.sql.PreparedStatement statement = con.prepareStatement(sql);
					statement.setString(1, (String)comboBox_3.getSelectedItem() );
					ResultSet set = statement.executeQuery();

					
					DefaultTableModel  modelo = (DefaultTableModel) table_3.getModel();
					modelo.setNumRows(0);
					double soma =0;
					while(set.next()) {
				
						soma+=Double.parseDouble(set.getString("valor"));
						modelo.addRow(new Object[] {set.getString("dia"), set.getString("mes"), set.getString("ano"), set.getString("descricao"), set.getString("valor"), set.getString("obs")});
					}
					total4.setText(""+soma);
					set.first();
				} catch (Exception e2) {
					// TODO: handle exception
				}
				
			}
		});
		btnConsultar_3.setBounds(10, 79, 101, 23);
		panel_10.add(btnConsultar_3);
		
		JLabel label_4 = new JLabel("Gastos");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_4.setBounds(343, 11, 48, 14);
		panel_10.add(label_4);
		
		total4 = new JTextField();
		total4.setHorizontalAlignment(SwingConstants.CENTER);
		total4.setEditable(false);
		total4.setFont(new Font("Tahoma", Font.PLAIN, 45));
		total4.setForeground(Color.RED);
		total4.setColumns(10);
		total4.setBounds(343, 37, 267, 65);
		panel_10.add(total4);
		
		JPanel panel_11 = new JPanel();
		panel_11.setLayout(null);
		panel_11.setBounds(682, 11, 662, 135);
		panel_9.add(panel_11);
		
		JLabel lblGastosBolo = new JLabel("GASTOS DO BOLO");
		lblGastosBolo.setForeground(Color.RED);
		lblGastosBolo.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblGastosBolo.setBounds(226, 51, 210, 32);
		panel_11.add(lblGastosBolo);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 157, 1334, 495);
		panel_9.add(scrollPane_3);
		
		table_3 = new JTable();
		table_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table_3.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"Dia", "M\u00EAs", "Ano", "Descri\u00E7\u00E3o", "Valor R$", "Obs"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane_3.setViewportView(table_3);
	}
}
