package practicaFicherosED;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Configuracion {
	private static final String RUTA_CONF = "C:\\Users\\Javier\\eclipse-workspace\\practicaFicherosED2\\src\\almacenamiento\\configuracion.txt";
	private static String nombreBBDD;
	private static String ubicacion;
	private static String puerto;
	private static String usuario;
	private static String clave;
	
	public Configuracion() {
		
	}

	public static String getNombreBBDD() {
		return nombreBBDD;
	}

	public static void setNombreBBDD(String nombreBBDD) {
		Configuracion.nombreBBDD = nombreBBDD;
	}

	public static String getUbicacion() {
		return ubicacion;
	}

	public static void setUbicacion(String ubicacion) {
		Configuracion.ubicacion = ubicacion;
	}

	public static String getPuerto() {
		return puerto;
	}

	public static void setPuerto(String puerto) {
		Configuracion.puerto = puerto;
	}

	public static String getUsuario() {
		return usuario;
	}

	public static void setUsuario(String usuario) {
		Configuracion.usuario = usuario;
	}

	public static String getClave() {
		return clave;
	}

	public static void setClave(String clave) {
		Configuracion.clave = clave;
	}
	
    //Determina las rutas de los archivos para utilizar en otros metodos del 
    //programa
    public void leerConfiguracion(){
		String rutaConfiguracion = "C:\\Users\\Javier\\eclipse-workspace\\practicaFicherosED2\\src\\almacenamiento\\configuracion.txt";
		File listadoParametrosF = new File(rutaConfiguracion);
                FileReader listadoParametrosFR = null;
                BufferedReader listadoParametrosBR = null;
        
        try {
            listadoParametrosFR = new FileReader(listadoParametrosF);
            listadoParametrosBR = new BufferedReader(listadoParametrosFR);
            
            int i = 0;
            String linea;
            while ((linea = listadoParametrosBR.readLine())!= null && i<5){
                String[] lineas = linea.split("\\|");
                switch(i){
                    case 0:
                        setNombreBBDD(lineas[0]);
                        break;
                    case 1:
                        setUbicacion(lineas[0]);
                        break;
                    case 2:
                        setPuerto(lineas[0]);
                        break;
                    case 3:
                        setUsuario(lineas[0]);
                        break;
                    case 4:
                        setClave(lineas[0]);
                        break;
                }
                i++;
            }
            listadoParametrosBR.close();
        }
        catch(IOException e){
        	System.out.println("Archivo de configuracion no encontrado");
        }
    }
	
	/**
	 * Método de escritura de archivos: configuracion.txt.
	 */


    public void modificarConfiguracion(String parametro) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(RUTA_CONF))) {
            bw.write(parametro);
            bw.newLine();
            System.out.println("Archivo actualizado con exito");
        } catch (IOException e) {
            System.out.println("Error al escribir el parámetro en el archivo");
        }
        Menu.menuConfiguracion();
    }

}
