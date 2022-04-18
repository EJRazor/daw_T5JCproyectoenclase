package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "tb_proveedor")
@Data
public class Proveedor {
	@Id
	@Column(name="idprovedor")
	private int idproveedor;
	
	@Column(name="nombre_rs")
	private String nombre;
	
	@Column(name="telefono")
	private String telef;
	
	@Column(name="email")
	private String email;

}
