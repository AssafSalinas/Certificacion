import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Consultar {

	public static void main(String[] args) {

		Conexion con = new Conexion();
		Connection cn = null;
		Statement stm = null;
		ResultSet rs = null;

		try {

			cn = con.Conectar();
			stm = cn.createStatement();
			rs = stm.executeQuery("Select * from empleados");

			while (rs.next()) {

				int No = rs.getInt(1);
				String No_control = rs.getString(2);
				String Nombre = rs.getString(3);
				String Apellidos = rs.getString(4);
				String Hora_Entrada = rs.getString(5);
				String Hora_salida = rs.getString(6);
				String Fecha = rs.getString(7);
				System.out.println();
				System.out.println(No + " " + No_control + " " + Nombre + " " + Apellidos + " " + Hora_Entrada + " "
						+ Hora_salida + " " + Fecha);

			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
