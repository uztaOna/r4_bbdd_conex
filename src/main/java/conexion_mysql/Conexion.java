package conexion_mysql;

import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import com.mysql.jdbc.Connection;

public class Conexion {

	private Connection cnx = null;	
	
	public Connection conectar() { 
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cnx = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/bidaion_g5","bidaiongrupo5","bidaiong5");
			JOptionPane.showMessageDialog(null, "Conexión establecida", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
		} catch (ClassNotFoundException | SQLException e) {
			JOptionPane.showMessageDialog(null, "¡Error al conectarse!", "Mensaje Error", JOptionPane.INFORMATION_MESSAGE);
		}
		return cnx;
	}
	
	public void desconectar() {
		try {
			cnx.close();
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
			System.out.println("[ERROR] No se pudo terminar la conexión");
		}
	}
}
