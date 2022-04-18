package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;
public class Demo03 {

	public static void main(String[] args) {
		// Eliminar un Usuario
				
			//fabrica --> DAO
				EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
			//Manejador de Entidades	
				EntityManager em= fabrica.createEntityManager();
			//Empieza el proceso	-->reg, act o elimin.
				em.getTransaction().begin();
			//proceso
				//Forma 1. Eliminación lógica --> actualización de estados
				//Forma 2. eliminación física --> delete...
				Usuario u = new Usuario();
				u.setCod(10);
				
				if(em.find(Usuario.class, u.getCod())==null)
					System.out.println("Usuario no existee");
				else {
				em.remove(em.find(Usuario.class, u.getCod())); // !!Ojo.. Necesita un objeto que se debe devolver
				//Confirmación	
				em.getTransaction().commit();
				System.out.println("Usuario eliminado correctamente");
				}
			//cierre
				em.close();

	}

}
