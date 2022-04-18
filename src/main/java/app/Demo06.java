package app;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Usuario;

public class Demo06 {

	public static void main(String[] args) {
		//fabrica --> DAO
				EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
			//Manejador de Entidades	
				EntityManager em= fabrica.createEntityManager();
			//select * from tb_usuarios where idtipo = ?
				TypedQuery<Usuario> consulta = em.createQuery("Select u from Usuario u where tipo = :xtipo", Usuario.class);
				consulta.setParameter("xtipo", 1);
				
				List<Usuario> lusuario = consulta.getResultList();
				
				for (Usuario u: lusuario) {
					System.out.println(u);
				}
			//cierre
				em.close();

	}

}
