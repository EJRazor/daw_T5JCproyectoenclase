package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo04 {

	public static void main(String[] args) {
		//fabrica --> DAO
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
	//Manejador de Entidades	
		EntityManager em= fabrica.createEntityManager();
	//Empieza el proceso -->en busqueda -->	em.getTransaction().begin();
	Usuario u = em.find(Usuario.class, 10);
	if (u == null)
	System.out.println("Usuario No existe!!!");
	else 
		System.out.print(u);
	//cierre
		em.close();
		
	}
}
