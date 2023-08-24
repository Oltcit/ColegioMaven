package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.Coordinador;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VentanaMateria extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
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
					VentanaMateria frame = new VentanaMateria();
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
	public VentanaMateria() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 605, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton btnNewButton_1 = new JButton("Guardar");
		panel.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Agregar");
		panel.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Modificar");
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Eliminar");
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Buscar");
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Cancelar");
		panel.add(btnNewButton_5);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Código:");
		lblNewLabel.setBounds(10, 37, 46, 14);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setBounds(10, 74, 46, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Módulos:");
		lblNewLabel_2.setBounds(10, 124, 46, 14);
		panel_1.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(73, 34, 86, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(73, 71, 86, 20);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(73, 121, 86, 20);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
	}

}
