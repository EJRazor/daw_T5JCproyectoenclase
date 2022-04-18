package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmLogin extends JFrame implements ActionListener {
	public String mensajeBienvenida;
	private JPanel contentPane;
	private JLabel lblTitulo;
	private JLabel lblUsuario;
	private JLabel lblPass;
	private JTextField txtUsu;
	private JTextField txtPass;
	private JButton btnIngresar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmLogin frame = new FrmLogin();
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
	public FrmLogin() {
		setTitle("Login\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 554, 355);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTitulo = new JLabel("Inicio de Sesi\u00F3n");
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTitulo.setBounds(216, 23, 150, 30);
		contentPane.add(lblTitulo);
		
		lblUsuario = new JLabel("Usuario:");
		lblUsuario.setBounds(93, 82, 85, 14);
		contentPane.add(lblUsuario);
		
		lblPass = new JLabel("Contrase\u00F1a:");
		lblPass.setBounds(93, 141, 85, 14);
		contentPane.add(lblPass);
		
		txtUsu = new JTextField();
		txtUsu.setBounds(180, 79, 188, 20);
		contentPane.add(txtUsu);
		txtUsu.setColumns(10);
		
		txtPass = new JTextField();
		txtPass.setBounds(180, 138, 188, 20);
		contentPane.add(txtPass);
		txtPass.setColumns(10);
		
		btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(this);
		btnIngresar.setBounds(216, 195, 116, 30);
		contentPane.add(btnIngresar);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnIngresar) {
			actionPerformedBtnIngresar(e);
		}
	}
	protected void actionPerformedBtnIngresar(ActionEvent e) {
		String usu = txtUsu.getText().trim();
		String psw = txtPass.getText().trim();
		if(usu.equals("")) {
			 mensaje("El Usuario no puede quedar en blanco");
			 txtUsu.requestFocus();
		} else if( usu.matches("[a-zA-z\\d\\_\\-]{3,}[@][a-zA-Z\\S]{3,}[.][a-z]{2,}")==false ) {
				 mensaje("El usuario debe ser una dirección de correo electrónico");
			 } else if(psw.equals("")) {
				 mensaje("El campo de contraseña no puede quedar en blanco");
			 }else if(psw.matches("[a-zA-z\\d\\_\\\\-]{3,}")==false) {
				 mensaje("Contraseña solo admita letras, números y guiones");
			 }else {
				 EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("mysql");
					//Manejador de Entidades	
						EntityManager em= fabrica.createEntityManager();
					//proceso
						Query sql = em.createNativeQuery("{call login (:usuario,:clave)}",Usuario.class);
						sql.setParameter("usuario",usu);
						sql.setParameter("clave",psw);
						Usuario u = null;
						try {
						u = (Usuario)sql.getSingleResult();
						}catch(NoResultException ex){
							mensaje("Usuario no Existe");
							txtUsu.setText("");
							txtPass.setText("");
							txtUsu.requestFocus();
						}
						if(u != null) {
							mensajeBienvenida = "Bienvenido "+u.getNombre()+" "+u.getApellida();
							FrmManteProd obj = new FrmManteProd();
							obj.main(null);
							this.dispose();
							JOptionPane.showMessageDialog(obj, mensajeBienvenida);;
						}
						em.close();
			 }
	}
	
	
	protected void mensaje(String cad) {
		JOptionPane.showMessageDialog(this, cad);
	}
}
