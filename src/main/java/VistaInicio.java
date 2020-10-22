
import javafx.geometry.Pos;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class VistaInicio extends VBox {
	

	
		
		private TextField usuarioText;
		private PasswordField contraseña; 
		private Label etiqueta1,etiqueta2;
		private Button acceder,cancelar;
		
		
		public VistaInicio(){
			super();
			
		usuarioText= new TextField();
		usuarioText.setPrefColumnCount(15);
		contraseña = new PasswordField();
		contraseña.setPrefColumnCount(15);
		
		etiqueta1 = new Label("Usuario");
		etiqueta2 = new Label("Contraseña");
		
		acceder = new Button();
		acceder.setText("Acceder");
		cancelar = new Button();
		cancelar.setText("Cancelar");
		
		
		
		HBox fila1 =new HBox();
		fila1.setAlignment(Pos.BASELINE_CENTER);
	      fila1.setSpacing(10);
	
		fila1.getChildren().addAll(etiqueta1, usuarioText);
		
		HBox fila2 =new HBox();
		fila2.getChildren().addAll(etiqueta2, contraseña);
		fila2.setAlignment(Pos.BASELINE_CENTER);
		fila2.setSpacing(10);
		//etAltura.setTranslateY(25);
		fila2.setTranslateX(-10);
		
		
		HBox fila3 =new HBox();
		fila3.getChildren().addAll(acceder, cancelar);
		fila3.setAlignment(Pos.BASELINE_CENTER);
		fila3.setSpacing(10);
		fila3.setTranslateY(25);
		
			 this.getChildren().addAll(fila1, fila2,fila3);
			 this.setAlignment(Pos.CENTER);	
		}
		
		
		public TextField usuarioTextget(){
			return usuarioText;
			}
		
		public PasswordField contraseñaTextget(){
			return contraseña;
			}
		public void usuarioTextset(String s){
			 usuarioText.setText(s);
			}
		
		public void contraseñaTextset(String s){
			 contraseña.setText(s);
			}
		
		public Button botonget(){
			return acceder;
					
		}
		
		
		public Button botonCancelarget(){
			return cancelar;
					
		}
	}