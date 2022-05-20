import java.sql.DriverManager;
import java.sql.SQLException;

public class Libreria { // Creacion de la clase Conexion

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {	// Generar la condicion del try catch
			
			Class.forName("com.mysql.cj.jdbc.Driver"); //Hacer la conexion con el driver
			// Es un conjunto de controladores para las bases de datos
			DriverManager.getConnection("jdbc:mysql://localhost:3306/libreria","root",""); 
			// Conexion con nuestra base de datos donde se concatena el url, el usuario y la 			contrase�a
			System.out.println("Conexion exitosa"); 
			// Imprimir en consola el estado de la conexion si esta bien 
			
		}
		
		catch (ClassNotFoundException e) { // Error del driver
			// TODO: handle exception
			
			System.out.println("Error al cargar el controlador"); 
			// Imprimir en consola el estado de la conexion si esta mal
			e.printStackTrace(); // Imprimir el error
			
			
		}
		catch (SQLException e) { // Error en la base de datos
			// TODO: handle exception
			System.out.println("No se realizo la conexion");
			// Imprimir en consola el estado de la conexion si esta mal
			e.printStackTrace(); // Imprimir el error
		}
			
	}

}