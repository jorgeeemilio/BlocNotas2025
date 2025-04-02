package es.studium.BlocNotas;

public class Modelo
{
	// Funcionalidad
	// Método contar palabras
	public int contarPalabras(String cadena)
	{
		int contador = 0;
	    if (cadena != null && !cadena.trim().isEmpty()) 
	    {
	    	String[] palabras = cadena.trim().split("\\s+");
	    	contador = palabras.length;
	    }
	    return contador;
	}
	// Método contar letras
	public int contarLetras(String cadena)
	{
		String abecedario = "aábcdeéfghiíjklmnñoópqrstuúüvwxyz" +
                "AÁBCDEÉFGHIÍJKLMNÑOÓPQRSTUÚÜVWXYZ";
		int contador = 0;
		for(int i = 0; i < cadena.length(); i++)
		{
			if(abecedario.indexOf(cadena.charAt(i))!=-1)
			{
				contador++;
			}
		}
		return contador;
	}
	// Método contar vocales
	public int contarVocales(String cadena)
	{
		int contador = 0;
		for(int i = 0; i < cadena.length(); i++)
		{
			switch(cadena.charAt(i)) 
			{
				case 'a': case 'e': case 'i': case 'o': case 'u':
				case 'A': case 'E': case 'I': case 'O': case 'U':
				case 'á': case 'é': case 'í': case 'ó': case 'ú':
				case 'Á': case 'É': case 'Í': case 'Ó': case 'Ú':
					contador++;
					break;
			}
		}
		return contador;
	}
}