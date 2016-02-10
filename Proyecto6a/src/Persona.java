
public class Persona {

	private String nombre;
	private int edad;
	private String dni;

	public Persona(String nom, int eda, String dn) {
		nombre = nom;
		edad = eda;
		dni = dn;
	}
	
	public String getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}

	public int getEdad() {
		return edad;
	}
	
	public void setDni(String d) {
		dni = d;
	}

	public void setNombre(String n) {
		nombre = n;
	}

	public void setEdad(int e) {
		edad = e;
	}
	
	public void print(){
		System.out.println("Dni: "+dni+" Nombre: "+nombre+" y edad "+edad);
	}

}
