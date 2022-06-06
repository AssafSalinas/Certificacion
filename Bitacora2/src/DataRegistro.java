import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class DataRegistro {

	private static final String controlador = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/bitacora";
	private static final String usuario = "root";
	private static final String clave = "";
	Variables var = new Variables();

	static {
		try {
			Class.forName(controlador);
			System.out.println("Se encontro el controlador");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection Conector() {
		Connection Conector = null;
		try {
			Conector = DriverManager.getConnection(url, usuario, clave);
			System.out.println("Se encontro la base de datos");

		} catch (SQLException e) {

			e.printStackTrace();
			System.out.println("Conexion fallida");

		}
		return Conector;
	}

	public Variables insertarRegistro() {
		DataRegistro conexion = new DataRegistro();
		Connection cn = null;
		PreparedStatement pstm = null;

		try {
			cn = conexion.Conector();
			String query = "INSERT INTO registro VALUES(?,?,?,?,?)";
			pstm = cn.prepareStatement(query);
			pstm.setString(1, Variables.ncon);
			pstm.setString(2, Variables.nom);
			pstm.setString(3, Variables.hre);
			pstm.setString(4, Variables.hrs);
			pstm.setString(5, Variables.fecha);
			pstm.executeUpdate();
			JOptionPane.showMessageDialog(null, "Registro guardado");
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Registro no guardado");
			e.printStackTrace();
		}
		return var;

	}

	public Variables eliminarRegistro() {
		DataRegistro conexion = new DataRegistro();
		Connection cn = null;
		PreparedStatement pstm = null;

		try {
			cn = conexion.Conector();
			String buscar = JOptionPane.showInputDialog(null, "Buscar Registro");
			String query = "DELETE FROM registro WHERE No_Control=? ";
			pstm = cn.prepareStatement(query);
			pstm.setString(1, buscar);
			pstm.executeUpdate();

			JOptionPane.showMessageDialog(null, "Se borro exitosamente");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "No se encontro");
			e.printStackTrace();
		}
		return var;

	}

	public static void main(String[] args) {
		DataRegistro a = new DataRegistro();
		a.Conector();
	}

}
