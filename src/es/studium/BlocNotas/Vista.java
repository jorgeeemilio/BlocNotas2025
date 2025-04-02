package es.studium.BlocNotas;

import java.awt.Dialog;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextArea;

public class Vista
{
	// Elementos gráficos
	Frame ventana = new Frame("Gestión de archivos");
	FileDialog fdAbrir = new FileDialog(ventana, "Seleccionar archivo", FileDialog.LOAD);
	FileDialog fdGuardar = new FileDialog(ventana, "Seleccionar archivo", FileDialog.SAVE);
	
	MenuBar barraMenu = new MenuBar();
	Menu menuArchivo = new Menu("Archivo");
	Menu menuGestion = new Menu("Gestión");
	MenuItem mniNuevo = new MenuItem("Nuevo");
	MenuItem mniAbrir = new MenuItem("Abrir");
	MenuItem mniGuardar = new MenuItem("Guardar");
	MenuItem mniSalir = new MenuItem("Salir");
	MenuItem mniContarPalabras = new MenuItem("Contar palabras");
	MenuItem mniContarLetras= new MenuItem("Contar letras");
	MenuItem mniContarVocales = new MenuItem("Contar vocales");
	
	TextArea txaTexto = new TextArea(1,1);
	
	Dialog mensaje = new Dialog(ventana, "Contador de Palabras");
	Label lblMensaje = new Label("Hay X palabras en el texto");
	
	Vista()
	{
		menuArchivo.add(mniNuevo);
		menuArchivo.add(mniAbrir);
		menuArchivo.add(mniGuardar);
		menuArchivo.addSeparator();
		menuArchivo.add(mniSalir);
		
		menuGestion.add(mniContarPalabras);
		menuGestion.add(mniContarLetras);
		menuGestion.add(mniContarVocales);
		
		barraMenu.add(menuArchivo);
		barraMenu.add(menuGestion);
		ventana.setMenuBar(barraMenu);
		ventana.add(txaTexto);
		ventana.setSize(400, 275);
		ventana.setResizable(false);
		ventana.setLocationRelativeTo(null);
		// Hacemos visible la pantalla
		ventana.setVisible(true);
		
		mensaje.setLayout(new FlowLayout());
		mensaje.setSize(200,125);
		mensaje.add(lblMensaje);
		mensaje.setResizable(false);
		mensaje.setLocationRelativeTo(null);
	}
}
