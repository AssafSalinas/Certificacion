import java.sql.DriverManager;
import java.sql.SQLException;

public class Persona {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Conexion con el controlador"); 
			DriverManager.getConnection("jdbc:mysql://localhost:3306/bitacora","root","");//Hacer la 			conexion con el driver
			System.out.println("Conexion exitosa"); 

			// Imprimir en consola el estado de la conexion si esta bien 
		} 
		catch (ClassNotFoundException e) {
			// TODO: handle exception
			System.out.println("Error al cargar el controlador"); 
			e.printStackTrace();
		} 
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Error en conectar"); 
			e.printStackTrace();
		} 
		
		
	}


}

