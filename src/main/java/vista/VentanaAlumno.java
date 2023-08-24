package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controlador.Coordinador;
import modelo.AlumnoDAO;
import modelo.AlumnoVO;

public class VentanaAlumno extends JFrame {

	private JPanel contentPane;
	private JTextField txtDni;
	private JTextField txtApynom;
	private JTextField txtFNac;
Coordinador miCoordinador;
int accion;
private JButton btnAgrega;
private JButton btnBusca;
private JButton btnMod;
private JButton btnGuarda;
private JButton btnCancela;
private JButton btnEli;
private JCheckBox chkDoc;
	
	

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
					VentanaAlumno frame = new VentanaAlumno();
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
	public VentanaAlumno() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 622, 308);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		
		btnGuarda = new JButton("Guardar");
		btnGuarda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		panel.add(btnGuarda);
		
		btnAgrega = new JButton("Agregar");
		btnAgrega.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregar();
			}
		});
		panel.add(btnAgrega);
		
		btnMod = new JButton("Modificar");
		panel.add(btnMod);
		
		btnEli = new JButton("Eliminar");
		panel.add(btnEli);
		
		btnBusca = new JButton("Buscar");
		btnBusca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscarAlumno();
			}
		});
		panel.add(btnBusca);
		
		btnCancela = new JButton("Cancelar");
		btnCancela.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiar();
			}
		});
		panel.add(btnCancela);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("DNI:");
		lblNewLabel.setBounds(20, 36, 46, 14);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Apellido y nombre:");
		lblNewLabel_1.setBounds(20, 78, 101, 14);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Fecha de nacimiento:");
		lblNewLabel_2.setBounds(20, 118, 113, 14);
		panel_1.add(lblNewLabel_2);
		
		chkDoc = new JCheckBox("Documentación");
		chkDoc.setBounds(20, 163, 150, 23);
		panel_1.add(chkDoc);
		
		txtDni = new JTextField();
		txtDni.setBounds(58, 33, 86, 20);
		panel_1.add(txtDni);
		txtDni.setColumns(10);
		
		txtApynom = new JTextField();
		txtApynom.setBounds(129, 75, 248, 20);
		panel_1.add(txtApynom);
		txtApynom.setColumns(10);
		
		txtFNac = new JTextField();
		txtFNac.setBounds(139, 115, 238, 20);
		panel_1.add(txtFNac);
		txtFNac.setColumns(10);
		
		habilita(true, false, false, false, false, true, false, false, true, true);
	}

	protected void buscarAlumno() {
		miCoordinador.mostrarVentanaAlumnoBuscar();
		
	}

	protected void guardar() {
		try {
			AlumnoVO miAlumnoVO = new AlumnoVO();
			miAlumnoVO.setDni(Integer.valueOf(txtDni.getText()));
			miAlumnoVO.setApe(txtApynom.getText());
			miAlumnoVO.setFnac(txtFNac.getText());
			if (chkDoc.isSelected())
				miAlumnoVO.setDoc((byte) 1);
			else
				miAlumnoVO.setDoc((byte) 0);
			
			AlumnoDAO miAlumnoDAO = new AlumnoDAO();
			if (accion==1)
			{				
				miAlumnoDAO.registrarAlumno(miAlumnoVO);
				limpiar();
			}else {
				
				miAlumnoDAO.modificarAlumno(miAlumnoVO);
				limpiar();
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error en el ingreso","Error",JOptionPane.ERROR_MESSAGE);
			limpiar();
		}
		
	}

	private void limpiar() {
		txtDni.setText("");
		txtApynom.setText("");
		txtFNac.setText("");
		chkDoc.setSelected(false);
		
		habilita(true, false, false, false, false, true, false, false, true, true);
	}
	protected void agregar() {
		accion=1;
		habilita(true, true, true, true, true, false, false, false, false, true);
	}
	
	public void habilita(boolean dni, boolean nom, boolean fnac, boolean doc, boolean bGuarda,
			boolean bAgrega, boolean bMod, boolean bEli, boolean bBusca, boolean bCancela) {
		
		txtDni.setEditable(dni);
		txtApynom.setEditable(nom);
		txtFNac.setEditable(fnac);
		chkDoc.setEnabled(doc);
		btnGuarda.setVisible(bGuarda);
		btnAgrega.setEnabled(bAgrega);
		btnMod.setEnabled(bMod);
		btnEli.setEnabled(bEli);
		btnBusca.setEnabled(bBusca);
		btnCancela.setEnabled(bCancela);
	}
	
}	

