package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Usuario u = new Usuario();
		u.setCod(10);
		u.setNombre("Eren");
		u.setApellida("Yeager");
		u.setUsuario("eren@gmail.com");
		u.setClave("tatakae");
		u.setFechanac("2000/01/01");
		u.setTipo(1);
		u.setEstado(1);
	
		//Proceso de registro
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		EntityManager em= fabrica.createEntityManager();
		
		try {
		em.getTransaction().begin();
		em.persist(u);
		em.getTransaction().commit();
		}catch(Exception e) {
			System.out.println("Error al registrar Usuario");
			em.getTransaction().rollback();
		}
		em.close();
		
		System.out.println("Usuario registrado");
		System.out.print("Se registró "+u.toString());
	}

}
