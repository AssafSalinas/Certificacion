import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	private static final String url = "jdbc:mysql://localhost:3306/bitacora2";
	private static final String root = "root";
	private static final String controlador = "com.mysql.cj.jdbc.Driver";
    private static final String password = "";
    
    static {
    	try {
			Class.forName(controlador);
			System.out.println("El controlador se cargo exitosamente"); 

		} 
    	
    	catch (ClassNotFoundException e) {
			System.out.println("Error al cargar el controlador"); 
    		e.printStackTrace();
		}
    }
    
   public Connection conexion() {
	   
	     Connection conexion = null;
	     
	   try {
		conexion = DriverManager.getConnection(url,root,password);
		System.out.println("Conexion exitosa con la base de datos"); 

		
	} catch (SQLException e) {
		System.out.println("Consulta no exitosa");	
		e.printStackTrace();
			
	}
	return conexion;
	
}

 

}



