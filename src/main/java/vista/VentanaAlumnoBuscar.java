package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controlador.Coordinador;
import modelo.AlumnoDAO;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaAlumnoBuscar extends JFrame {

	private JPanel contentPane;
	Coordinador miCoordinador;
	JTable tabla;
	JScrollPane  scrollpane;

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
					VentanaAlumnoBuscar frame = new VentanaAlumnoBuscar();
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
	public VentanaAlumnoBuscar() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		panel.add(btnVolver);
		
		scrollpane = new JScrollPane();
		contentPane.add(scrollpane, BorderLayout.CENTER);
	}

	public void mostrarDatosConTableModel() {
		DefaultTableModel modelo = new DefaultTableModel();
		tabla = new JTable();
		
		tabla.setModel(modelo);
		modelo.addColumn("DNI");
		modelo.addColumn("Apellido y nombre");
		modelo.addColumn("Fecha de nacimiento");
		modelo.addColumn("Documentación");
		
		AlumnoDAO miAlumnoDAO =new AlumnoDAO();
		miAlumnoDAO.buscarAlumnos(modelo);
		
		scrollpane.setViewportView(tabla);
	}

}
