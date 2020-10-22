


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
 private ControladorInicio controlador;
	
public void start(Stage primaryStage) throws Exception {
	
	
	
	VistaInicio vista =new VistaInicio();
	ModeloInicio modelo =new ModeloInicio();
	
	controlador= new ControladorInicio(vista,modelo);
	Scene scene = new Scene (controlador.getVista(),300,170);
	
	primaryStage.setScene(scene);
	primaryStage.setTitle("Inicio Sesion");
	primaryStage.show();
	
}
public static void main(String[] args) {
	launch(args);
}
	
}
