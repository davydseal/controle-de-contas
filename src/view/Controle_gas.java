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

public class Controle_gas extends JFrame {

	private JPanel contentPane;
	private JTextField id;
	private JTextField dataf;
	private JTextField dataf_1;
	private JTextField datai;
	private JTextField local2;
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
					Controle_gas frame = new Controle_gas();
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
	public Controle_gas() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Controle_gas.class.getResource("/img/5_97257.png")));
		setTitle("G\u00E1s");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 252, 451);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 214, 387);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblAno = new JLabel("Data Inicial");
		lblAno.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAno.setBounds(10, 69, 68, 14);
		panel.add(lblAno);
		
		JLabel lblObserva = new JLabel("Observa\u00E7\u00F5es");
		lblObserva.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblObserva.setBounds(10, 181, 80, 14);
		panel.add(lblObserva);
		
		JTextArea obs = new JTextArea();
		obs.setBounds(10, 206, 188, 77);
		panel.add(obs);
		obs.setBackground(SystemColor.controlHighlight);
		
		JComboBox local = new JComboBox();
		local.setModel(new DefaultComboBoxModel(new String[] {"", "Fog\u00E3o", "Forno"}));
		local.setBounds(10, 150, 89, 20);
		panel.add(local);
		
		JLabel lblLocal = new JLabel("Local");
		lblLocal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLocal.setBounds(10, 125, 48, 14);
		panel.add(lblLocal);
		
		JLabel lblId = new JLabel("Id");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblId.setBounds(10, 11, 48, 14);
		panel.add(lblId);
		
		id = new JTextField();
		id.setEnabled(false);
		id.setEditable(false);
		id.setBounds(10, 36, 48, 20);
		panel.add(id);
		id.setColumns(10);
		
		JComboBox data = new JComboBox();
		data.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					String sql ="select * from controle_gas where datai=?";
				con = DriverManager.getConnection("jdbc:mysql://localhost/sealf", "root", "");
					PreparedStatement statement = con.prepareStatement(sql);
					statement.setString(1, (String)data.getSelectedItem() );
					
					ResultSet set = statement.executeQuery();

					while (set.next()) {
				      id.setText(set.getString("codigo"));
					  datai.setText(set.getString("datai"));
					  dataf.setText(set.getString("dataf"));
					  local2.setText(set.getString("local"));
					  obs.setText(set.getString("obs"));
					 

					  
					}
					
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
		});
		data.setModel(new DefaultComboBoxModel(new String[] {""}));
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost/sealf", "root", "");
			st = con.createStatement();
			String s = "select * from controle_gas";
			rs = st.executeQuery(s);
			
			while(rs.next()){
				data.addItem(rs.getString("datai"));
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
		data.setEnabled(false);
		data.setBounds(68, 35, 130, 20);
		panel.add(data);
		
		JLabel lblData = new JLabel("Data");
		lblData.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblData.setBounds(68, 11, 48, 14);
		panel.add(lblData);
		
		JLabel lblDataFinal = new JLabel("Data Final");
		lblDataFinal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDataFinal.setBounds(109, 69, 80, 14);
		panel.add(lblDataFinal);
		
		dataf = new JTextField();
		try{

	           javax.swing.text.MaskFormatter format_dataf = new javax.swing.text.MaskFormatter("##/##/####");

	           dataf = new javax.swing.JFormattedTextField(format_dataf);
	           dataf.setEnabled(false);

	        }catch (Exception e){}
		dataf.setBounds(109, 94, 89, 20);
		panel.add(dataf);
		dataf.setColumns(10);
		
		datai = new JTextField();
		try{

	           javax.swing.text.MaskFormatter format_datai = new javax.swing.text.MaskFormatter("##/##/####");

	           datai = new javax.swing.JFormattedTextField(format_datai);

	        }catch (Exception e){}
		datai.setColumns(10);
		datai.setBounds(10, 94, 89, 20);
		panel.add(datai);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(10, 302, 89, 23);
		panel.add(btnSalvar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setBounds(109, 302, 89, 23);
		panel.add(btnEditar);
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if(datai.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Preencha o campo data inicial!");
					}
				 else if(dataf.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Preencha o campo data final!");
					}
					 else if (((String) local.getSelectedItem()).isEmpty()) {
							JOptionPane.showMessageDialog(null, "Selecione o Local!");
						}
					
					
					else {
				try {		
					Connection con = Conexao.faz_conexao();
					
					String sql = "update controle_gas set datai=?, dataf=?, local=? , obs=? where codigo=?";
					PreparedStatement stmt = con.prepareStatement(sql);
					
					stmt.setString(1, datai.getText());
					stmt.setString(2, dataf.getText());
					stmt.setString(3, (String) local.getSelectedItem());
					stmt.setString(4, obs.getText());
					stmt.setString(5, id.getText());

			
					stmt.execute();
					
					stmt.close();
					con.close();
					JOptionPane.showMessageDialog(null, "Gás editado com sucesso!!!");
					Controle_gas.this.dispose();
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			}
		});
		btnEditar.setEnabled(false);
		
		JButton btnLocalizar = new JButton("Localizar");
		btnLocalizar.setBounds(10, 336, 89, 23);
		panel.add(btnLocalizar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(109, 336, 89, 23);
		panel.add(btnSair);
		
		local2 = new JTextField();
		local2.setEditable(false);
		local2.setEnabled(false);
		local2.setColumns(10);
		local2.setBounds(109, 150, 89, 20);
		panel.add(local2);
		
		JLabel label = new JLabel("Local");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(109, 127, 48, 14);
		panel.add(label);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Controle_gas.this.dispose();
			}
		});
		btnLocalizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSalvar.setEnabled(false);
				btnEditar.setEnabled(true);
				btnLocalizar.setEnabled(false);
				data.setEnabled(true);
				dataf.setEnabled(true);
			}
		});
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 if(datai.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Preencha o campo data inicial!");
				}
				 else if (((String) local.getSelectedItem()).isEmpty()) {
						JOptionPane.showMessageDialog(null, "Selecione o Local!");
					}
				
				
				else {
				try {
					Connection con = Conexao.faz_conexao();
					String sql = "insert into controle_gas(datai, local, obs, dataf, status) value (?, ?, ?, '00/00/0000', 1)";
					
					PreparedStatement stmt = con.prepareStatement(sql);
					
					
					
					stmt.setString(1, datai.getText());
					stmt.setString(2, (String) local.getSelectedItem());
					stmt.setString(3, obs.getText());

					
					
					stmt.execute();
					
					stmt.close();
					con.close();
					JOptionPane.showMessageDialog(null, "Gastos salvos com sucesso!");
					datai.setText("");
					local.setSelectedItem(null);
					obs.setText("");
			
					
					
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			}
		});
	}
}
