package es.studium.BlocNotas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Controlador implements WindowListener, ActionListener
{
	Modelo modelo;
	Vista vista;

	Controlador(Vista v, Modelo m)
	{
		this.vista = v;
		this.modelo = m;

		this.vista.ventana.addWindowListener(this);
		this.vista.mensaje.addWindowListener(this);
		this.vista.mniNuevo.addActionListener(this);
		this.vista.mniAbrir.addActionListener(this);
		this.vista.mniGuardar.addActionListener(this);
		this.vista.mniSalir.addActionListener(this);
		this.vista.mniContarPalabras.addActionListener(this);
		this.vista.mniContarLetras.addActionListener(this);
		this.vista.mniContarVocales.addActionListener(this);
	}

	public void actionPerformed(ActionEvent evento) 
	{
		if(evento.getSource().equals(vista.mniSalir))
		{
			// Salir
			System.exit(0);
		}
		else if(evento.getSource().equals(vista.mniNuevo))
		{
			vista.txaTexto.setText("");
		}
		else if(evento.getSource().equals(vista.mniAbrir))
		{
			vista.fdAbrir.setVisible(true);
			vista.txaTexto.setText("");
			try
			{
				String rutaFichero = vista.fdAbrir.getDirectory() + "\\" + vista.fdAbrir.getFile();
				FileReader fr = new FileReader(rutaFichero);
				BufferedReader entrada = new BufferedReader(fr);
				String contenido = "";
				while((contenido=entrada.readLine())!=null)
				{
					vista.txaTexto.append(contenido+"\n");
				}
				// Cerrar
				entrada.close();
				fr.close();
			}
			catch(FileNotFoundException e)
			{
				vista.lblMensaje.setText("Archivo NO encontrado");
				vista.mensaje.setVisible(true);
			}
			catch(IOException i)
			{
				vista.lblMensaje.setText("Se produjo un error de Archivo");
				vista.mensaje.setVisible(true);
			}
		}
		else if(evento.getSource().equals(vista.mniGuardar))
		{
			vista.fdGuardar.setVisible(true);
			try
			{
				String rutaFichero = vista.fdGuardar.getDirectory() + "\\" + vista.fdGuardar.getFile();
				FileWriter fw = new FileWriter(rutaFichero);
				BufferedWriter bw = new BufferedWriter(fw);
				PrintWriter salida = new PrintWriter(bw);
				salida.println(vista.txaTexto.getText());
				//Cerrar objetos
				salida.close();
				bw.close();
				fw.close();
			}
			catch(IOException i)
			{
				vista.lblMensaje.setText("Se produjo un error de Archivo");
				vista.mensaje.setVisible(true);
			}
		}
		else if(evento.getSource().equals(vista.mniContarPalabras))
		{
			vista.lblMensaje.setText("Hay " + modelo.contarPalabras(vista.txaTexto.getText()) + " palabras en el texto");
			vista.mensaje.setVisible(true);
		}
		else if(evento.getSource().equals(vista.mniContarLetras))
		{
			vista.lblMensaje.setText("Hay " + modelo.contarLetras(vista.txaTexto.getText()) + " letras en el texto");
			vista.mensaje.setVisible(true);
		}
		else if(evento.getSource().equals(vista.mniContarVocales))
		{
			vista.lblMensaje.setText("Hay " + modelo.contarVocales(vista.txaTexto.getText()) + " vocales en el texto");
			vista.mensaje.setVisible(true);
		}
	}

	public void windowActivated(WindowEvent e) {}
	public void windowClosed(WindowEvent e) {}
	public void windowClosing(WindowEvent evento) 
	{
		if(evento.getSource().equals(vista.ventana))
		{
			// Salir
			System.exit(0);
		}
		else
		{
			vista.mensaje.setVisible(false);
		}
	}
	public void windowDeactivated(WindowEvent e) {}
	public void windowDeiconified(WindowEvent e) {}
	public void windowIconified(WindowEvent e) {}
	public void windowOpened(WindowEvent e) {}
}
