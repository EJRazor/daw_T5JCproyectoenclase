package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "tb_productos")
@Data
public class Producto {
	
		@Id
		@Column(name = "id_prod")
		private String cod;
		
		@Column(name = "des_prod")
		private String desc;
		
		@Column(name = "stk_prod")
		private int stk;
		
		@Column(name = "pre_prod")
		private double precio;
		
		@ManyToOne
		@JoinColumn (name="idcategoria", insertable = false, updatable = false)
		Categoria categoria;
		
		@Column(name = "idcategoria")
		private int idcat;
		
		@Column(name = "est_prod")
		private int estado;
		
		@ManyToOne
		@JoinColumn (name="idprovedor", insertable = false, updatable = false)
		Proveedor proveedor;
		
		@Column(name = "idprovedor")
		private int idproveedor;
		
		public Producto() {}
		
		
		
		
		@Override
		public String toString() {
			return "Producto [cod=" + cod + ", desc=" + desc + ", stk=" + stk + ", precio=" + precio + ", idcat="
					+ idcat + ", estado=" + estado + ", idproveedor=" + idproveedor + "]";
		}




		public Producto(String cod, String desc, int stk, double precio, int idcat, int estado, int idproveedor) {
			super();
			this.cod = cod;
			this.desc = desc;
			this.stk = stk;
			this.precio = precio;
			this.idcat = idcat;
			this.estado = estado;
			this.idproveedor = idproveedor;
		}




		public String getCod() {
			return cod;
		}
		public void setCod(String cod) {
			this.cod = cod;
		}
		public String getDesc() {
			return desc;
		}
		public void setDesc(String desc) {
			this.desc = desc;
		}
		public int getStk() {
			return stk;
		}
		public void setStk(int stk) {
			this.stk = stk;
		}
		public double getPrecio() {
			return precio;
		}
		public void setPrecio(double precio) {
			this.precio = precio;
		}
		public int getIdcat() {
			return idcat;
		}
		public void setIdcat(int idcat) {
			this.idcat = idcat;
		}
		public int getEstado() {
			return estado;
		}
		public void setEstado(int estado) {
			this.estado = estado;
		}
		public int getIdproveedor() {
			return idproveedor;
		}
		public void setIdproveedor(int idproveedor) {
			this.idproveedor = idproveedor;
		}
		
}
