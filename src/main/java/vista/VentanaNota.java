package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Coordinador;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class VentanaNota extends JFrame {

	private JPanel contentPane;
Coordinador miCoordinador;
	
	

	public Coordinador getMiCoordinador() {
		return miCoordinador;
	}

	public void setMiCoordinador(Coordinador miCoordinador) {
		this.miCoordinador = miCoordinador;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaNota frame = new VentanaNota();
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
	public VentanaNota() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 614, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("New button");
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("New button");
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("New button");
		panel.add(btnNewButton_5);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JComboBox cbAlumno = new JComboBox();
		cbAlumno.setBounds(54, 57, 135, 22);
		panel_1.add(cbAlumno);
		
		JComboBox cbMateria = new JComboBox();
		cbMateria.setBounds(309, 57, 149, 22);
		panel_1.add(cbMateria);
		
		JLabel lblNewLabel = new JLabel("Nota:");
		lblNewLabel.setBounds(169, 141, 46, 14);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Alumno:");
		lblNewLabel_1.setBounds(58, 32, 46, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Materia:");
		lblNewLabel_2.setBounds(309, 32, 46, 14);
		panel_1.add(lblNewLabel_2);
		
		JComboBox cbNota = new JComboBox();
		cbNota.setBounds(212, 137, 46, 22);
		panel_1.add(cbNota);
		
		JLabel lblAlumno = new JLabel("New label");
		lblAlumno.setBounds(101, 32, 157, 14);
		panel_1.add(lblAlumno);
		
		JLabel lblMateria = new JLabel("New label");
		lblMateria.setBounds(355, 32, 189, 14);
		panel_1.add(lblMateria);
	}
}
