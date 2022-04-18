package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Usuario;

public class Demo02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Usuario u = new Usuario();
		u.setCod(3);
		u.setNombre("Carla");
		u.setApellida("Toro");
		u.setUsuario("U002@gmail.com");
		u.setClave("10002");
		u.setFechanac("2000/03/01");
		u.setTipo(2);
		u.setEstado(1);
	
		//Proceso de registro
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		
		EntityManager em= fabrica.createEntityManager();
		
		try {
		em.getTransaction().begin();
		em.merge(u);
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
