package modelo;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AlumnoDAO {

	public void registrarAlumno(AlumnoVO miAlumnoVO) {
		try{
			Conexion conex = new Conexion();
			Statement estatuto=conex.getConnection().createStatement();
			estatuto.executeUpdate("INSERT INTO alumno VALUES ('"+miAlumnoVO.getDni()+"','"
					+miAlumnoVO.getApe()+"','"+miAlumnoVO.getFnac()+"','"+miAlumnoVO.getDoc()+"')");
			
			JOptionPane.showMessageDialog(null, "Se ha registrado exitosamente","Información",
					JOptionPane.INFORMATION_MESSAGE);
			estatuto.close();
			conex.desconectar();
		} catch (SQLException e){
			System.out.println("dni: "+miAlumnoVO.getDni()+" Ape: "+miAlumnoVO.getApe());
			System.out.println("Fecha: "+miAlumnoVO.getFnac()+" DOc: "+miAlumnoVO.getDoc());
			JOptionPane.showMessageDialog(null, "No se registró", "Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		
	}

	public void modificarAlumno(AlumnoVO miAlumnoVO) {
		try {
			Conexion conex= new Conexion();
			String consulta="UPDATE alumno SET aldni=?, alapynom=?, alfnac=?, aldoc=? "
					+ "WHERE aldni=?";
			PreparedStatement estatuto=conex.getConnection().prepareStatement(consulta);
			estatuto.setInt(1, miAlumnoVO.getDni());
			estatuto.setString(2, miAlumnoVO.getApe());
			estatuto.setString(3, miAlumnoVO.getFnac());
			estatuto.setByte(4, miAlumnoVO.getDoc());
			estatuto.setInt(5, miAlumnoVO.getDni());
			estatuto.executeUpdate();
			
			JOptionPane.showMessageDialog(null, "Se ha modificado correctamente","Confirmación"
					,JOptionPane.INFORMATION_MESSAGE);
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Error al modificar","Error",JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
		
	}

	public void buscarAlumnos(DefaultTableModel modelo) {
		try {
			Conexion conex = new Conexion();
			java.sql.Statement estatuto = conex.getConnection().createStatement();
			ResultSet  res = estatuto.executeQuery("select * from alumno order by alapynom");
			
			while (res.next())
			{
				Object fila[] = new Object[4];
				for (int i=0; i<4; i++)
				{
					fila[i]=res.getObject(i+1);
					
				}
				modelo.addRow(fila);
			}
			res.close();
			estatuto.close();
			conex.desconectar();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al consultar","Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}

	public void eliminarAlumno(Integer doc) {
		try {
			Conexion conex=new Conexion();
			Statement estatuto = conex.getConnection().createStatement();
			estatuto.executeUpdate("DELETE FROM alumno where aldni="+doc);
			JOptionPane.showMessageDialog(null, "Se ha eliminado correctamente","Información",
					JOptionPane.INFORMATION_MESSAGE);
			estatuto.close();
			conex.desconectar();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "No se eliminó","Información",JOptionPane.INFORMATION_MESSAGE);
		}
	}

}
