package modelo;
import modelo.Producto;
import modelo.Habitacion;
import modelo.Cama;
import modelo.ModificadorDeArchivos;
import modelo.PropertyManagmentSystem;
import modelo.Tarifa;
import modelo.Empleado;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.HashMap;

public class Administrador {
    public void cargarHabitaciones_txt(ArrayList<Habitacion> habitaciones, String archivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] campos = linea.split(",");
                String idHabi = campos[0];
                String ubicacion = campos[1];
                int capacidad = Integer.parseInt(campos[2]);
                String tipo = campos[3];
                int numcamas = Integer.parseInt(campos[4]);
                ArrayList<Cama> camas = new ArrayList<>();
                String[] camasStr = campos[5].split(";");
                for (String camaStr : camasStr) {
                    String[] camaCampos = camaStr.split("-");
                    String size = camaCampos[0];
                    int capacidad = Integer.parseInt(camaCampos[1]);
                    String uso = camaCampos[2];
                    Cama cama = new Cama(size, capacidad, uso);
                    camas.add(cama);
                }
                HashMap<String, Integer> elementosDeCobro = new HashMap<String, Integer>();
                String[] elementos = campos[6].split(";");
                for (String elemento : elementos ) {
                	String[] dictionary = elemento.split(":");
                	String nombre = dictionary[0];
                	int precio = Integer.parseInt(dictionary[1]);
                	elementosDeCobro.put(nombre, precio);
                }
                ArrayList<Tarifa> tarifas = new ArrayList<>();
                String[] tarifasStr = campos[7].split(";");
                for (String tarifaStr : tarifasStr) {
                    String[] tarifaCampos = tarifaStr.split("-");
                    String tipoTarifa = tarifaCampos[0];
                    double valor = Double.parseDouble(tarifaCampos[0]);
                    Date fechainicio = new Date(Long.parseLong(tarifaCampos[1]));
                    Date fechafinal = new Date(Long.parseLong(tarifaCampos[2]));
                    String producto = tarifaCampos[3];
                    Tarifa tarifa = new Tarifa(valor, fechainicio,fechafinal, producto);
                    tarifas.add(tarifa);
                }
              
                Habitacion habitacion = new Habitacion(idHabi, ubicacion, capacidad, tipo, numcamas,elementosDeCobro, 
                         tarifas, camas);
                habitaciones.add(habitacion);
            }
        } catch (IOException e) {
            System.err.format("Error de E/S: %s%n", e);
        }
    }
    public void cargarHabitaciones_mano(ArrayList<Habitacion> habitaciones) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese los datos de la habitación (o ingrese 'fin' para terminar):");
        while (true) {
            System.out.print("ID de habitación: ");
            String idHabi = scanner.nextLine();
            if (idHabi.equals("fin")) {
                break;
            }
            System.out.print("Ubicación: ");
            String ubicacion = scanner.nextLine();
            System.out.print("Capacidad: ");
            int capacidad = scanner.nextInt();
            scanner.nextLine(); 
            System.out.print("Tipo: ");
            String tipo = scanner.nextLine();
            System.out.print("Número de camas: ");
            int numcamas = scanner.nextInt();
            scanner.nextLine(); 
            ArrayList<Cama> camas = new ArrayList<>();
            for (int i = 0; i < numcamas; i++) {
                System.out.printf("Cama %d:%n", i + 1);
                System.out.print("Tamaño: ");
                String size = scanner.nextLine();
                System.out.print("capacidad: ");
                int capacidad_1 = scanner.nextInt();
                System.out.print("uso: ");
                String uso = scanner.nextLine();
                scanner.nextLine(); 
                Cama cama = new Cama(size, capacidad_1,uso);
                camas.add(cama);
            }
            
            HashMap<String, Integer> elementosCobro1 = new HashMap<String, Integer>();
            System.out.print("numero de elementos");
            int valor = scanner.nextInt();
            for (int i = 0; i < valor; i++) {
            	System.out.print("Producto: ");
                String name = scanner.nextLine();
            	System.out.print("Valor: ");
                int price = scanner.nextInt();
                elementosCobro1.put(name, price);
            }
            
            
            System.out.printf("Tarifa ");
            System.out.print("Valor ");
            double valor_ = scanner.nextDouble();
            System.out.print("año inicio: ");
            long anoinicio = (long) scanner.nextDouble();
            System.out.print("mes inicio: ");
            long mesinicio = (long) scanner.nextDouble();
            System.out.print("día inicio: ");
            long diainicio = (long) scanner.nextDouble();
            long miliseconds = (long) ((mesinicio* 2629743833.3) + (diainicio*86400000)+(anoinicio*3600000));
            scanner.nextLine(); 
            Date fechainicial = new Date(miliseconds); 
            System.out.print("año final: ");
            long anofinal = (long) scanner.nextDouble();
            System.out.print("mes final: ");
            long mesfinal = (long) scanner.nextDouble();
            System.out.print("día final: ");
            long diafinal = (long) scanner.nextDouble();
            long milisecondsfinal = (long) ((mesfinal* 2629743833.3) + (diafinal*86400000)+(anofinal*3600000));
            scanner.nextLine(); 
            Date fechafinal = new Date(milisecondsfinal);
            System.out.print("Producto : ");
            String producto = scanner.nextLine();
            scanner.nextLine(); 
            Tarifa tarifas = new Tarifa(valor_, fechainicial,fechafinal,producto);
            
            Habitacion habitacion = new Habitacion(idHabi, ubicacion, capacidad, tipo, numcamas,elementosDeCobro, 
                    tarifas, camas);
            habitaciones.add(habitacion);
        }
        
    }
    public void modificarHabitacion(ArrayList<Habitacion> habitaciones) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID de la habitación a modificar: ");
        String idHabi = scanner.nextLine();
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getIdHabi().equals(idHabi)) {
                System.out.println("¿Qué desea modificar?");
                System.out.println("1. Capacidad");
                System.out.println("2. Número de camas");
                System.out.println("3. Camas");
                System.out.println("4. Ubicacion");
                System.out.println("5. tipo");
                System.out.println("6. Elementos de cobro");
                System.out.println("7. tarifa");
                System.out.print("Ingrese el número de opción: ");
                int opcion = scanner.nextInt();
                scanner.nextLine(); 
                switch (opcion) {
                    case 1:
                    	ModificadorDeArchivos.modificarCapacidad(habitacion);
                        break;
                    case 2:
                    	ModificadorDeArchivos.modificarNumCamas(habitacion);
                        break;
                    case 3:
                    	ModificadorDeArchivos.modificarCamas(habitacion);
                        break;
                    case 4:
                    	ModificadorDeArchivos.modificarUbicacion(habitacion);
                        break;
                    case 5:
                    	ModificadorDeArchivos.modificarTipo(habitacion);
                        break;
                    case 6:
                    	ModificadorDeArchivos.modificarElementos(habitacion);
                        break;
                    case 7:
                    	ModificadorDeArchivos.modificarTarifa(habitacion);
                    	break;
                    default:
                        System.out.println("Opción inválida.");
                        break;
                }
                return;
            }
        }
        System.out.printf("No se encontró la habitación con ID %s.%n", idHabi);
    }
    
    
    
    public void verTodasLasHabitaciones(ArrayList<Habitacion> habitaciones) {
        for (Habitacion habitacion : habitaciones) {
            System.out.println(habitacion.toString());
        }
    }
    public void crearservicio(ArrayList<Producto> productos) {
    	Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese los datos del producto (o ingrese 'fin' para terminar):");
        while (true) {
            System.out.print("nombre ");
            String nombre = scanner.nextLine();
            if (nombre.equals("fin")) {
                break;
            }
            System.out.print("Descripcion: ");
            String descripcion = scanner.nextLine();
            System.out.print("Disponibilidad: ");
            Boolean disponibleHabitacion = scanner.nextBoolean();
            System.out.print("precio: ");
            int precio = scanner.nextInt();
            System.out.print("Inicio: ");
            String in = scanner.nextLine();
            LocalTime inicioDisponible = LocalTime.parse(in);
            System.out.print("Final: ");
            String fin = scanner.nextLine();
            LocalTime finDisponible = LocalTime.parse(fin);
            scanner.nextLine();
            Producto producto = new Producto(nombre, descripcion, disponibleHabitacion, precio, inicioDisponible, finDisponible);
            productos.add(producto);
            
        }
    	
    }
    
    
    public void modificarServicio(ArrayList<Producto> productos) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del producto a modificar: ");
        String nombre = scanner.nextLine();
        for (Producto producto : productos) {
            if (producto.getNombre().equals(nombre)) {
                System.out.println("¿Qué desea modificar?");
                System.out.println("1. Descripción");
                System.out.println("2. Disponibilidad Habitacion");
                System.out.println("3. Precio");
                System.out.println("4. Hora Inicio Disponible ");
                System.out.println("5. Hora Final Disponible ");
                System.out.print("Ingrese el número de opción: ");
                int opcion = scanner.nextInt();
                scanner.nextLine(); 
                switch (opcion) {
                    case 1:
                    	ModificadorDeArchivos.modificarDescripcion(producto);
                        break;
                    case 2:
                    	ModificadorDeArchivos.modificarDisponibilidad(producto);
                        break;
                    case 3:
                    	ModificadorDeArchivos.modificarPrecio(producto);
                        break;
                    case 4:
                    	ModificadorDeArchivos.modificarInicio(producto);
                        break;
                    case 5:
                    	ModificadorDeArchivos.modificarFinal(producto);
                        break;
                    default:
                        System.out.println("Opción inválida.");
                        break;
                }
                return;
            }
        }
        System.out.printf("No se encontró la habitación con ID %s.%n", idHabi);
    }
    
    public void cargarPersonal(HashMap<String, Empleado> diccionario) {
    	Scanner scanner = new Scanner(System.in);
    	System.out.println("Ingrese los datos del personal (o ingrese 'fin' para terminar):");
    	while (true) {
            System.out.print("nombre: ");
            String nombre = scanner.nextLine();
            if (nombre.equals("fin")) {
                break;
            }
            System.out.println("id: ");
            String id = scanner.nextLine();
            System.out.println("Correo: ");
            String correo = scanner.nextLine();
            System.out.println("Password: ");
            String password = scanner.nextLine();
            System.out.println("Rol: ");
            String rol = scanner.nextLine();
            PropertyManagmentSystem pms = new PropertyManagmentSystem();
            Empleado empleado = new Empleado(nombre, id, correo, password, rol, pms);
            diccionario.put(id, empleado);
    	}
    }
    
}
