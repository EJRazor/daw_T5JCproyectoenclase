package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Usuario;

public class Demo05 {

	public static void main(String[] args) {
		//fabrica --> DAO
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
	//Manejador de Entidades	
		EntityManager em= fabrica.createEntityManager();
	//Empieza el proceso -->en listado -->	em.getTransaction().begin();
		TypedQuery<Usuario> consulta = em.createQuery("Select u from Usuario u", Usuario.class);
		
		List<Usuario> lusuario = consulta.getResultList();
		
		for (Usuario u: lusuario) {
			System.out.println(u);
		}
	//cierre
		em.close();

	}

}
