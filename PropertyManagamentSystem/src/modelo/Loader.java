package modelo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.File;
import modelo.Administrador;
import modelo.Consumible;
import modelo.Recepcionista;
import modelo.Empleado;
import modelo.Reserva;
import modelo.Habitacion;
import modelo.Usuario;

public class Loader
{
    /**
     * @param PMS
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static ArrayList<Object> cargarData(PropertyManagamentSystem PMS) throws FileNotFoundException, IOException
	{
        ArrayList<Object> Data= new ArrayList<>();
        Map<String, Empleado> empleados = new HashMap<String, Empleado>();
        ArrayList<Consumible> servicios = new ArrayList<>();
        ArrayList<Habitacion> habitaciones = new ArrayList<>();
        ArrayList<Reserva> ConsultaReserva = new ArrayList<>();
        ArrayList<Recepcionista> opcionesRecepcionista = new ArrayList<>();
        ArrayList<Usuario> usuarios = new ArrayList<>();

		String fileEmpleados= "data\\Empleados.txt";
		File archivo = new File(fileEmpleados);
		BufferedReader lector = new BufferedReader(new FileReader(archivo));
		String linea = lector.readLine();
		
		while (linea != null) {
            String[] partes = linea.split(",");
			String nombre = partes[0];
            String IDEmpleado=partes[1];
            String correo = partes[2];
            String password = partes[3];
            String rol = partes[4];
            Empleado elEmpleado= empleados.get(IDEmpleado);
            if (elEmpleado==null){
                elEmpleado=new Empleado(nombre, IDEmpleado, correo, password, rol, PMS);
                empleados.put(IDEmpleado, elEmpleado);
            }
			linea = lector.readLine();
		}
		lector.close();
        Data.add(empleados);


        String fileServicios= "data\\Servicios.txt";
		File archivoS = new File(fileServicios);
		BufferedReader lectorS = new BufferedReader(new FileReader(archivoS));
		String lineaS = lectorS.readLine();
		
		while (lineaS != null) {
            String[] partesS = lineaS.split(",");
			String precio = partesS[0];
            String IDS=partesS[1];
            String conceptoS= partesS[2];
            Consumible vservicio= buscarServicio(servicios);
            if (vservicio == null){
                vservicio = new Restaurante(IDS, conceptoS);
                servicios.add(vservicio);


            }
            
			lineaS = lectorS.readLine();
		}
		lectorS.close();
        Data.add(servicios);
    return Data;


		
	}


    public static Consumible buscarServicio(ArrayList<Consumible> Servicios)
    {   
        Consumible servicio=null;

        return servicio;
    }

}
