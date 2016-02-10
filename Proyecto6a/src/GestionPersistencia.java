import java.awt.List;
import java.util.ArrayList;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Constraint;
import com.db4o.query.Query;


public class GestionPersistencia {
	ObjectContainer bbdd;
	
	public GestionPersistencia() {
		// TODO Auto-generated constructor stub
	}
	
	//Insertar persona
	public void insertarPersona(Persona p){
		bbdd = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "personas.db4o");
		try{
			bbdd.store(p);
			bbdd.commit();
			System.out.println("Se ha insertado la persona correctamente.");
		}
		finally{
			bbdd.close();
		}	
	}
	
	//Recuperar lista de personas por nombre
	public ArrayList<Persona> recuperarPersonaPorNombre(String nombre){
		ArrayList<Persona> listaPersonasPorNombre = new ArrayList<Persona>();
		bbdd = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "personas.db4o");
		
		try{
			Query consulta = bbdd.query();
			consulta.constrain(Persona.class);
			consulta.descend("nombre").constrain(nombre);
			
			ObjectSet<Persona> resultado = consulta.execute();
			
			for(Persona p2: resultado){
				p2.print();
				listaPersonasPorNombre.add(p2);
			}
		}
		finally{
			bbdd.close();
		}
		
		return listaPersonasPorNombre;
	}
	
	//Recuperar lista de personas por cadena inicial
	public ArrayList<Persona> recuperarPersonaPorInicial(String cadenaInicial){
		ArrayList<Persona> listaPersonasPorInicial = new ArrayList<Persona>();
		bbdd = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "personas.db4o");
		
		try{
			Query consulta = bbdd.query();
			consulta.constrain(Persona.class);
			consulta.descend("nombre").constrain(cadenaInicial).startsWith(true);
			
			ObjectSet<Persona> resultado = consulta.execute();
			
			for(Persona p2: resultado){
				p2.print();
				listaPersonasPorInicial.add(p2);
			}
		}
		finally{
			bbdd.close();
		}
		
		return listaPersonasPorInicial;
	}
	
	//Recuperar persona por DNI
	public Persona recuperarPersonaPorDNI(String dni){
		bbdd = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "personas.db4o");
		Persona persona = null;
		
		try{
			Query consulta = bbdd.query();
			consulta.constrain(Persona.class);
			consulta.descend("dni").constrain(dni);
			
			ObjectSet<Persona> resultado = consulta.execute();
			
			for(Persona p2: resultado){
				p2.print();
				persona = p2;
			}
		}
		finally{
			bbdd.close();
		}
		
		return persona;
	}
	
	//Recuperar lista de personas por edad
	public ArrayList<Persona> recuperarPersonaPorEdad(int menor, int mayor){
		ArrayList<Persona> listaPersonasPorEdad = new ArrayList<Persona>();
		bbdd = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "personas.db4o");
		
		try{
			Query consulta = bbdd.query();
			consulta.constrain(Persona.class);
			Constraint c1 = consulta.descend("edad").constrain(menor).greater();
			Constraint c2 = consulta.descend("edad").constrain(mayor).smaller();
			c1.and(c2);
			
			ObjectSet<Persona> resultado = consulta.execute();
			
			for(Persona p2: resultado){
				p2.print();
				listaPersonasPorEdad.add(p2);
			}
		}
		finally{
			bbdd.close();
		}
		
		return listaPersonasPorEdad;
	}
	
	//Recuperar lista de personas de forma avanzada
	public ArrayList<Persona> recuperarPersonaAvanzada(){
		ArrayList<Persona> listaPersonasPorCustom = new ArrayList<Persona>();
		bbdd = Db4oEmbedded.openFile(Db4oEmbedded.newConfiguration(), "personas.db4o");
		
		try{
			Query consulta = bbdd.query();
			consulta.constrain(Persona.class);
			Constraint c1 = consulta.descend("edad").constrain(30).greater();
			Constraint c2 = consulta.descend("dni").constrain("20").startsWith(true);
			Constraint c3 = consulta.descend("nombre").constrain("o").endsWith(true);
			c1.or(c2).or(c3);
			
			ObjectSet<Persona> resultado = consulta.execute();
			
			for(Persona p2: resultado){
				p2.print();
				listaPersonasPorCustom.add(p2);
			}
		}
		finally{
			bbdd.close();
		}
		
		return listaPersonasPorCustom;
	}
}
