import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataRegistro {

	private static final String controlador = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3306/bitacora2";
	private static final String usuario = "root";
	private static final String clave = "";

	static {
		try {
			Class.forName(controlador);
			System.out.println("Se encontro el controlador");

		} catch (ClassNotFoundException e) {
			// TODO: handle exception
		}
	}

	public Connection Conexion() {
		Connection Conexion = null;
		try {
			Conexion = DriverManager.getConnection(url, usuario, clave);
			System.out.println("Se encontro la base de datos");

		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("Conexion fallida");

		}
		return Conexion;
	}

	public Variables InsertarRegistro() {
		DataRegistro Conexion = new DataRegistro();
		Connection cn = null;
		PreparedStatement pstm = null;

		try {
			cn = Conexion.Conexion();
			String query = "INSERT INTRO `tabla`(?,?,?,?,?)";
			pstm = cn.prepareStatement(query);
			pstm.setString(2, Variables.ncon);
			pstm.setString(3, Variables.nom);
			pstm.setString(4, Variables.hre);
			pstm.setString(5, Variables.hrs);
			pstm.setString(6, Variables.fecha);
			pstm.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Conexion fallida");
			e.printStackTrace();
		}
		return InsertarRegistro();

	}

	public static void main(String[] args) {
		DataRegistro a = new DataRegistro();
		a.Conexion();
	}

}
