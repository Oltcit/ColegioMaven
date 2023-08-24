package controlador;

import vista.VentanaAlumno;
import vista.VentanaAlumnoBuscar;
import vista.VentanaMateria;
import vista.VentanaNota;
import vista.VentanaPrincipal;

public class Principal {

	Coordinador miCoordinador;
	VentanaPrincipal miVentanaPrincipal;
	VentanaAlumno miVentanaAlumno;
	VentanaMateria miVentanaMateria;
	VentanaNota miVentanaNota;
	VentanaAlumnoBuscar miVentanaAlumnoBuscar;
	
	public static void main(String[] args) {
		Principal miPrincipal = new Principal();
		miPrincipal.iniciar();
	}

	private void iniciar() {
		
		miCoordinador = new Coordinador();
		miVentanaPrincipal = new VentanaPrincipal();
		miVentanaAlumno = new VentanaAlumno();
		miVentanaMateria = new VentanaMateria();
		miVentanaNota = new VentanaNota();
		miVentanaAlumnoBuscar = new VentanaAlumnoBuscar();
		
		miCoordinador.setMiVentanaAlumno(miVentanaAlumno);
		miCoordinador.setMiVentanaMateria(miVentanaMateria);
		miCoordinador.setMiVentanaNota(miVentanaNota);
		miCoordinador.setMiVentanaPrincipal(miVentanaPrincipal);
		miCoordinador.setMiVentanaAlumnoBuscar(miVentanaAlumnoBuscar);

		miVentanaAlumno.setMiCoordinador(miCoordinador);
		miVentanaMateria.setMiCoordinador(miCoordinador);
		miVentanaNota.setMiCoordinador(miCoordinador);
		miVentanaPrincipal.setMiCoordinador(miCoordinador);
		miVentanaAlumnoBuscar.setMiCoordinador(miCoordinador);
		
		miVentanaPrincipal.setVisible(true);
	}

}
