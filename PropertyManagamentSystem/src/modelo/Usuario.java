package modelo;

public class Usuario {
	private String nombre;
	private String Id;
	private String Correo;
	protected String Password;
	private String Contacto;
	private String Rol;
	
	public Usuario(String name, String id, String correo, String password, String contacto, String rol) {
		super();
		nombre = name;
		Id = id;
		Correo = correo;
		Password = password;
		Contacto = contacto;
		Rol = rol;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getId() {
		return Id;
	}

	public String getCorreo() {
		return Correo;
	}
	
	
}
