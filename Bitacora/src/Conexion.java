import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion { // Creacion de la clase Conexion
	private static final String controlador="com.mysql.cj.jdbc.Driver";
	private static final String url="jdbc:mysql://localhost:3306/bitacora";
	private static final String user="root";
	private static final String password="";
	static{
		try {	// Generar la condicion del try catch
			
			Class.forName(controlador); //Hacer la conexion con el driver 
			// Conexion con nuestra base de datos donde se concatena el url, el usuario y la contraseña
			System.out.println("El controlador se cargo exitosamente"); 
			// Imprimir en consola el estado de la conexion si esta bien 
			
		}
		catch (ClassNotFoundException e) { // Error del driver
			// TODO: handle exception
			
			System.out.println("Error al cargar el controlador"); 
			// Imprimir en consola el estado de la conexion si esta mal
			e.printStackTrace(); // Imprimir el error
			
			
		}
	}
	public Connection conectar() {
		
		Connection  conexion= null;
		
		try {	// Generar la condicion del try catch
			
			conexion = DriverManager.getConnection(url,user,password); 
			// Conexion con nuestra base de datos donde se concatena el url, el usuario y la contraseña
			System.out.println("Conexion exitosa con la base de datos"); 
			// Imprimir en consola el estado de la conexion si esta bien 
			
		}
		
		
		catch (SQLException e ) { // Error en la base de datos
			// TODO: handle exception
			System.out.println("No se realizo la conexion");
			// Imprimir en consola el estado de la conexion si esta mal
			e.printStackTrace(); // Imprimir el error
		}
		return conexion;
	}
		
}




