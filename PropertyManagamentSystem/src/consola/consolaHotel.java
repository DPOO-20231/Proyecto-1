package consola;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import modelo.PropertyManagamentSystem;
import modelo.Loader;

public class consolaHotel {

	private boolean continuar = true;
	private PropertyManagamentSystem PMS;


	public void ejecutarAplicacion()
	{

		String Rol;
		iniciarAplicacion();
		while (continuar)
		{
			try
			{
				FirstOpcion();
				int Login = Integer.parseInt(input("Por favor seleccione una opción"));
				if (Login == 1)
					{
					Rol = VerifyLogin();
					if (Rol=="Administrador"){
						opcionesAdmin();
						int OpcionA = Integer.parseInt(input("Por favor seleccione una opción"));}
					else if (Rol=="Recepcionista"){
						opcionesRecepcionista();
						int OpcionR = Integer.parseInt(input("Por favor seleccione una opción"));}
					else if (Rol=="Empleado"){
						opcionesEmpleado();
						int OpcionE = Integer.parseInt(input("Por favor seleccione una opción"));}
					



					}
				else if (Login == 2)
				{
					System.out.println("Saliendo de la aplicación ...");
					continuar = false;
				}
			}
			catch (NumberFormatException e)
			{
				System.out.println("Debe seleccionar uno de los números de las opciones.");
			}
		}
	}
public void FirstOpcion()
	{
		System.out.println("\nBienvenido al Property Managament System\n");
		System.out.println("1. Iniciar Sesion");
		System.out.println("2. Salir de la aplicacion");

	}

public void opcionesAdmin()
	{
		System.out.println("\nBienvenido Administrador(a) \n");
		System.out.println("1. Crear Servicio");
		System.out.println("2. Modificar Servicio");
		System.out.println("3. Consultar Servicio");
		System.out.println("4. Crear Habitaciones");
		System.out.println("5. Modificar Habitaciones");
		System.out.println("6. Salir de la aplicación\n");
	}
public void opcionesRecepcionista()
{
	System.out.println("\nBienvenido Recepcionista\n");
	System.out.println("1. Consultar una Habitacion");
	System.out.println("2. Colsultar Las Reservas de una Habitacion");
	System.out.println("3. Realizar una Reservacion");
	System.out.println("4. Registrar Nuevos Huespeds");
	System.out.println("5. Crear Grupo de Huespeds");
	System.out.println("6. Realizar CheckOut");
	System.out.println("7. Cancelar Reserva");
	System.out.println("8. Salir de la aplicación\n");
}
public void opcionesEmpleado()
{
	System.out.println("\nBienvenido Recepcionista\n");
	System.out.println("1. Consultar una Habitacion");
	System.out.println("2. Habitacion");
	System.out.println("3. Restaurante");
	System.out.println("4. Registrar Nuevos Huespeds");
	System.out.println("5. Crear Grupo de Huespeds");
	System.out.println("6. Realizar CheckOut");
	System.out.println("7. Crear facturacion");
	System.out.println("8. Cancelar Reserva");
	System.out.println("9. Salir de la aplicación\n");
}
public String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}
public String VerifyLogin()
{
	String Login = input("Por favor digite su usuario");
	String Password = input("Por favor digite su contraseña");
	String Rol = PMS.VerifyLogin(Login, Password);
	return Rol;
}
private void iniciarAplicacion()
{
	try
	{
		PMS= Loader.cargarinformacion();
	}
	catch (FileNotFoundException e)
	{
		System.out.println("ERROR: el archivo indicado no se encontró.");
	}
	catch (IOException e)
	{
		System.out.println("ERROR: hubo un problema leyendo el archivo.");
		System.out.println(e.getMessage());
	}

}
public static void main(String[] args)
	{
		consolaHotel consola = new consolaHotel();
		
		consola.ejecutarAplicacion();
	}
	

}
