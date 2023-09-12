package controlador;

import modelo.AlumnoVO;
import vista.VentanaAlumno;
import vista.VentanaAlumnoBuscar;
import vista.VentanaMateria;
import vista.VentanaNota;
import vista.VentanaPrincipal;

public class Coordinador {

	VentanaPrincipal miVentanaPrincipal;
	VentanaAlumno miVentanaAlumno;
	VentanaMateria miVentanaMateria;
	VentanaNota miVentanaNota;
	VentanaAlumnoBuscar miVentanaAlumnoBuscar;
	
	
	
	public VentanaAlumnoBuscar getMiVentanaAlumnoBuscar() {
		return miVentanaAlumnoBuscar;
	}
	public void setMiVentanaAlumnoBuscar(VentanaAlumnoBuscar miVentanaAlumnoBuscar) {
		this.miVentanaAlumnoBuscar = miVentanaAlumnoBuscar;
	}
	public VentanaPrincipal getMiVentanaPrincipal() {
		return miVentanaPrincipal;
	}
	public void setMiVentanaPrincipal(VentanaPrincipal miVentanaPrincipal) {
		this.miVentanaPrincipal = miVentanaPrincipal;
	}
	public VentanaAlumno getMiVentanaAlumno() {
		return miVentanaAlumno;
	}
	public void setMiVentanaAlumno(VentanaAlumno miVentanaAlumno) {
		this.miVentanaAlumno = miVentanaAlumno;
	}
	public VentanaMateria getMiVentanaMateria() {
		return miVentanaMateria;
	}
	public void setMiVentanaMateria(VentanaMateria miVentanaMateria) {
		this.miVentanaMateria = miVentanaMateria;
	}
	public VentanaNota getMiVentanaNota() {
		return miVentanaNota;
	}
	public void setMiVentanaNota(VentanaNota miVentanaNota) {
		this.miVentanaNota = miVentanaNota;
	}
	public void mostrarVentanaAlumno() {
		miVentanaAlumno.setVisible(true);
		
	}
	public void mostrarVentanaAlumnoBuscar() {
		miVentanaAlumnoBuscar.setVisible(true);
		miVentanaAlumnoBuscar.mostrarDatosConTableModel();
	}
	public void mostrarAlumno(AlumnoVO miAlumnoVO) {
		miVentanaAlumno.mostrarAlumno(miAlumnoVO);
		
	}
	
	
}
