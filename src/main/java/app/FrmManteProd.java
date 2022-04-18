package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Categoria;
import model.Producto;
import model.Proveedor;
import model.Usuario;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;

public class FrmManteProd extends JFrame {

	
	private JPanel contentPane;
	
	private JTextArea txtSalida;
	private JTextField txtCódigo;
	JComboBox cboCategorias;
	private JTextField txtDescripcion;
	private JTextField txtStock;
	private JTextField txtPrecio;
	private JButton btnListado;
	private JLabel lblCodigo;
	private JLabel lblCategora;
	private JLabel lblNomProducto;
	private JLabel lblStock;
	private JLabel lblPrecio;
	private JButton btnRegistrar;
	private JLabel lblProveedor;
	private JComboBox cboProveedores;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmManteProd frame = new FrmManteProd();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmManteProd() {
		setTitle("Mantenimiento de Productos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 441);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registrar();
			}
		});
		btnRegistrar.setBounds(324, 29, 89, 23);
		contentPane.add(btnRegistrar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 180, 687, 177);
		contentPane.add(scrollPane);
		
		txtSalida = new JTextArea();
		scrollPane.setViewportView(txtSalida);
		
		btnListado = new JButton("Listado");
		btnListado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listado();
			}
		});
		btnListado.setBounds(371, 368, 89, 23);
		contentPane.add(btnListado);
		
		txtCódigo = new JTextField();
		txtCódigo.setBounds(122, 11, 86, 20);
		contentPane.add(txtCódigo);
		txtCódigo.setColumns(10);
		
		lblCodigo = new JLabel("Id. Producto :");
		lblCodigo.setBounds(10, 14, 102, 14);
		contentPane.add(lblCodigo);
		
		cboCategorias = new JComboBox();
		cboCategorias.setBounds(122, 70, 199, 22);
		contentPane.add(cboCategorias);
		
		lblCategora = new JLabel("Categor\u00EDa");
		lblCategora.setBounds(10, 74, 102, 14);
		contentPane.add(lblCategora);
		
		lblNomProducto = new JLabel("Nom. Producto :");
		lblNomProducto.setBounds(10, 45, 102, 14);
		contentPane.add(lblNomProducto);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(122, 42, 144, 20);
		contentPane.add(txtDescripcion);
		
		lblStock = new JLabel("Stock:");
		lblStock.setBounds(10, 106, 102, 14);
		contentPane.add(lblStock);
		
		txtStock = new JTextField();
		txtStock.setColumns(10);
		txtStock.setBounds(122, 103, 77, 20);
		contentPane.add(txtStock);
		
		lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(10, 134, 102, 14);
		contentPane.add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(122, 131, 77, 20);
		contentPane.add(txtPrecio);
		
		lblProveedor = new JLabel("Proveedor:");
		lblProveedor.setBounds(10, 159, 86, 14);
		contentPane.add(lblProveedor);
		
		cboProveedores = new JComboBox();
		cboProveedores.setBounds(122, 155, 199, 22);
		contentPane.add(cboProveedores);
		
		llenaCombo();
		
	}

	void llenaCombo() {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = fabrica.createEntityManager();
		TypedQuery<Categoria> consulta = em.createQuery("Select c from Categoria c", Categoria.class);
		List<Categoria> listaC = consulta.getResultList();
		
		cboCategorias.addItem("Seleccione Categoria");
		for(Categoria c: listaC) {
			cboCategorias.addItem( c.getId()+"-"+c.getDesc());
		}
		
		TypedQuery<Proveedor> consultaP = em.createQuery("Select p from Proveedor p", Proveedor.class);
		List<Proveedor> listaP = consultaP.getResultList();
		
		cboProveedores.addItem("Seleccione Proveedor");		
		for(Proveedor p : listaP) {
			cboProveedores.addItem(p.getIdproveedor()+"-"+p.getNombre());			
		}
		em.close();
	}
	

	void listado() {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = fabrica.createEntityManager();
		TypedQuery<Producto> consulta = em.createQuery("Select p from Producto p", Producto.class);
		List<Producto> lista = consulta.getResultList();
		
		txtSalida.setText("");
		for (Producto p: lista) {
			txtSalida.append("----------Producto----------"+"\n");
			txtSalida.append("Id producto: "+p.getCod()+"\n");
			txtSalida.append("Descripcion producto: "+p.getDesc()+"\n");
			txtSalida.append("Stock: "+p.getStk()+"\n");
			txtSalida.append("Precio producto: "+p.getPrecio()+"\n");
			txtSalida.append("Estado: "+p.getEstado()+"\n");
			txtSalida.append("Proveedor: "+p.getIdproveedor()+"-"+p.getProveedor().getNombre()+"\n");
			txtSalida.append("Id Categoria: "+p.getIdcat()+"\n");
			txtSalida.append("Categoria: "+p.getCategoria().getDesc()+"\n"+"\n");
		}
		em.close();
	}
	
	void registrar() {
		String cod = txtCódigo.getText();
		String Nombre = txtDescripcion.getText();
		int stock = Integer.parseInt(txtStock.getText().trim());
		double precio = Double.parseDouble(txtPrecio.getText().trim());
		int categoria = cboCategorias.getSelectedIndex();
		int estado = 1;
		int proveedor = cboProveedores.getSelectedIndex();
		
		Producto p = new Producto();
		p.setCod(cod);
		p.setDesc(Nombre);
		p.setStk(stock);
		p.setPrecio(precio);
		p.setIdcat(categoria);
		p.setEstado(estado);
		p.setIdproveedor(proveedor);
		
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
		EntityManager em = fabrica.createEntityManager();
		
		if(em.find(Producto.class,p.getCod()) ==null) {
			em.getTransaction().begin();
			em.persist(p);
			em.getTransaction().commit();
			em.close();
			JOptionPane.showMessageDialog(this, "Producto registrado");
		}else {
			JOptionPane.showMessageDialog(this, "El codigo de Producto ya esta Registrado");
			txtCódigo.setText("");
			txtCódigo.requestFocus();
		}
		em.close();
	}
}
