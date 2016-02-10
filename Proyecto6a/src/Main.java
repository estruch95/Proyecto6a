import java.util.List;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GestionPersistencia gp;
		gp = new GestionPersistencia();
		
		
		Persona p1 = new Persona("Ivan", 20, "22596425Y");
		Persona p2 = new Persona("Pedro", 32, "57893546J");
		Persona p3 = new Persona("Miguel", 46, "12345678P");
		Persona p4 = new Persona("Manolo", 18, "20562435T");
		Persona p5 = new Persona("Pablo", 53, "20421387D");
		
		//Inserción de personas
		gp.insertarPersona(p1);
		gp.insertarPersona(p2);
		gp.insertarPersona(p3);
		gp.insertarPersona(p4);
		gp.insertarPersona(p5);
		
		
		gp.recuperarPersonaPorNombre("Manolo");
		//gp.recuperarPersonaPorInicial("Pa");
		//gp.recuperarPersonaPorDNI("12345678P");
		//gp.recuperarPersonaPorEdad(15, 30);
		//gp.recuperarPersonaAvanzada();
	}

}
