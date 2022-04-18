package model;

import javax.persistence.*;

import lombok.Data;

@Entity 
@Table(name = "tb_usuarios")
@Data
public class Usuario {
	
	@Id
	@Column(name = "cod_usua")
	private int cod;
	
	@Column(name = "nom_usua")
	private String nombre;
	
	@Column(name = "ape_usua")
	private String apellida;
	
	@Column(name = "usr_usua")
	private String usuario;
	
	@Column(name = "cla_usua")
	private String clave;
	
	@Column(name = "fna_usua")
	private String fechanac;

	@Column(name = "idtipo")
	private int tipo;
	
	@Column(name = "est_usua")
	private int estado;
	
	public Usuario() {}
	

	public Usuario(int cod, String nombre, String apellida, String usuario, String clave, String fechanac, int tipo,
			int estado) {
		super();
		this.cod = cod;
		this.nombre = nombre;
		this.apellida = apellida;
		this.usuario = usuario;
		this.clave = clave;
		this.fechanac = fechanac;
		this.tipo = tipo;
		this.estado = estado;
	}

	

	@Override
	public String toString() {
		return "Usuario [cod=" + cod + ", nombre=" + nombre + ", apellida=" + apellida + ", usuario=" + usuario
				+ ", clave=" + clave + ", fechanac=" + fechanac + ", tipo=" + tipo + ", estado=" + estado + "]";
	}


	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellida() {
		return apellida;
	}

	public void setApellida(String apellida) {
		this.apellida = apellida;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClave() {
		return clave;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getFechanac() {
		return fechanac;
	}

	public void setFechanac(String fechanac) {
		this.fechanac = fechanac;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	
	
}
