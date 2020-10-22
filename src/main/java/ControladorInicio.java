import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;

import org.apache.commons.codec.digest.DigestUtils;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class ControladorInicio {

	private VistaInicio vista = new VistaInicio();
	private static ModeloInicio modelo =new ModeloInicio ();
	
	
	public ControladorInicio(VistaInicio v,ModeloInicio m){
		
		vista=v;
		
		modelo=m;
		
		vista.botonget().setOnAction(e-> acceder(e));	  
		vista.botonCancelarget().setOnAction(e-> borrado(e));	
	}
	
	 private void borrado(ActionEvent e) {
		vista.contraseñaTextset("");
		vista.usuarioTextset("");
	 }
	
	
	 private void acceder(ActionEvent e) {

			
	modelo.setusuario(vista.usuarioTextget().getText());	
	String sinCodi =vista.contraseñaTextget().getText();
	String codificado = DigestUtils.md5Hex(sinCodi).toUpperCase();
	modelo.setcontraseña(codificado);	
	try {
		comprobar();
	} catch (IOException e1) {
		
		e1.printStackTrace();
	}
	


	}
	
	 
		public static String[] leerLineaALinea(File fichero, Charset charset) throws IOException {
		
			
			String lineas[]= new String[3];
			
			FileReader fr = new FileReader(fichero, charset);
			
			BufferedReader br = new BufferedReader(fr);
			
			String line;
			int i=0;
			while ((line = br.readLine()) != null) {
				lineas[i]=(line);
				i++;
			}
			br.close();
			fr.close();
			return lineas;
		}

		
		public static void comprobar()  throws IOException {
			String[] lineas = leerLineaALinea(new File("datos.csv"), Charset.forName("UTF-8"));
			int i=0;
			boolean error=true;
			for(i=0;i<lineas.length;i++) {
				String [] parts = lineas[i].split(",");
				String username = parts[0];
				String password = parts[1];
				
				if(username.equals(modelo.getusuario())&& password.equals(modelo.getcontraseña())) {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Iniciar sesion");
					alert.setHeaderText("Acceso permitido");
					alert.setContentText("Usuario y contraseña correctos");
					alert.showAndWait();
					error=false;
				}
				
			}
			if( error==true){
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Iniciar sesion");
				alert.setHeaderText("Acceso no permitido");
				alert.setContentText("Usuario y/o contraseña incorrectos");
				alert.showAndWait();
			}
		}
		
		
	public VistaInicio getVista() {
		 return vista;
		 
	 }
	
}