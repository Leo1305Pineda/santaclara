package santaclara.vista;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.swingbinding.JComboBoxBinding;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import net.miginfocom.swing.MigLayout;
import santaclara.controlador.ContUsuarios;
import santaclara.modelo.Concesionario;
import santaclara.modelo.JefeVenta;
import santaclara.modelo.Ruta;
import santaclara.modelo.Usuario;
import santaclara.modelo.Vendedor;
import santaclara.modelo.Zona;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class UsuariosUI extends JPanel {
	
	private JPanel pnOpciones;
	private JPanel panel;
	private JPanel pnUsuarios;
	private JPanel panel_1;
	private JPanel pnTabla;
	private JPanel pnEditar; 
	
	private JButton btnNuevo;
	private JButton btnEditar;
	private JButton btnAtras;
	private JButton btnSalir;
	private JButton btnABuscar;
	private JButton btnEliminar;
	private JButton btnAbrirZona;
	

	private JComboBox<String> cmbTipoUsuario ;
	private JComboBox<Ruta> comboRutas;
	private JComboBox<Zona> cmbZona;
	
	
	private JTable table;
	@SuppressWarnings("rawtypes")
	private JTableBinding binUsuarios;
	
	@SuppressWarnings("rawtypes")
	private JTableBinding  binRutas;
	
	private JScrollPane scrollPanel;
	
	private JTextField txtABuscar;
		
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	private List<Ruta> rutasVendedores = new ArrayList<Ruta>();
	private List<Ruta> rutas = new ArrayList<Ruta>();
	private List<Zona> zonas = new ArrayList<Zona>();
	
	private JLabel lblTipoUsuario;
	private JPanel pnUsuario;
	private JButton btnGuardar;
	private JButton btnCancelar;
	private JLabel lblUserName;
	private JTextField txtUserName;
	private JTextField txtId;
	private JLabel lblCedula;
	private JLabel lblContrasena;
	private JLabel lblNombre;
	private JLabel lblReContrasena;
	private JTextField txtCedula;
	private JTextField txtContrasena;
	private JTextField txtNombre;
	private JTextField txtReContrasena;
	private JPanel pnEditarRuta;
	private JPanel pnZona;

	private JLabel lblZona;
	private JButton btnAbrirRuta;
	private JTable tablaRutas;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public UsuariosUI(ContUsuarios contUsuarios,List<Usuario> usuarios,List<Ruta> rutas,List<Zona> zonas) {
		this.usuarios = usuarios;
		this.rutas = rutas;
		this.zonas = zonas;
		
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		
		pnUsuarios = new JPanel();
		pnUsuarios.setBackground(Color.DARK_GRAY);
		pnUsuarios.setForeground(Color.DARK_GRAY);
		pnUsuarios.setBounds(12, 12, 876, 505);
		pnUsuarios.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Modulo Usuarios", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		add(pnUsuarios);
		pnUsuarios.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(12, 45, 852, 42);
		pnUsuarios.add(panel);
		panel.setLayout(null);
		
		pnOpciones = new JPanel();
		pnOpciones.setBounds(0, 0, 852, 34);
		panel.add(pnOpciones);
		pnOpciones.setBackground(Color.DARK_GRAY);
		pnOpciones.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Opciones", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		pnOpciones.setLayout(null);
		
		btnNuevo = new JButton("Nuevo");
		btnNuevo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				if(cmbTipoUsuario.getSelectedItem().equals("Todos")) btnNuevo.setEnabled(false);
				else btnNuevo.setEnabled(true);
				if(btnNuevo.isEnabled()){
					btnNuevo.setToolTipText("Nuevo "+cmbTipoUsuario.getSelectedItem().toString());
				}
				else btnNuevo.setToolTipText("Seleccione el Tipo de Usuario");
			}
		});
		btnNuevo.addActionListener(contUsuarios.nuevo());
		btnNuevo.setBounds(125, 15, 115, 16);
		btnNuevo.setForeground(Color.WHITE);
		btnNuevo.setBackground(Color.DARK_GRAY);
		btnNuevo.setIcon(new ImageIcon("img/gestion/add.png"));
		btnNuevo.setEnabled(false);
		pnOpciones.add(btnNuevo);
		
		btnEditar = new JButton("Editar");
		btnEditar.addActionListener(contUsuarios.modificar());
		btnEditar.setBounds(245, 15, 115, 16);
		btnEditar.setForeground(Color.WHITE);
		btnEditar.setBackground(Color.DARK_GRAY);
		btnEditar.setIcon(new ImageIcon("img/gestion/Modificara.png"));
		pnOpciones.add(btnEditar);
		
		btnAtras = new JButton("Atras");
		btnAtras.addActionListener(contUsuarios.atras());
		btnAtras.setBounds(5, 15, 115, 16);
		btnAtras.setForeground(Color.WHITE);
		btnAtras.setBackground(Color.DARK_GRAY);
		btnAtras.setIcon(new ImageIcon("img/gestion/AtrasCurva.png"));
		pnOpciones.add(btnAtras);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(contUsuarios.salir());
		btnSalir.setBounds(725, 15, 115, 16);
		btnSalir.setForeground(Color.WHITE);
		btnSalir.setBackground(Color.DARK_GRAY);
		btnSalir.setIcon(new ImageIcon("img/gestion/SalirCurva.png"));
		pnOpciones.add(btnSalir);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.setBackground(Color.DARK_GRAY);
		btnEliminar.setIcon(new ImageIcon("img/gestion/cancel.png"));
		btnEliminar.addActionListener(contUsuarios.eliminar());
		btnEliminar.setBounds(365, 15, 115, 16);
		pnOpciones.add(btnEliminar);
		
		btnAbrirRuta = new JButton("Ruta");
		btnAbrirRuta.setBounds(485, 15, 115, 16);
		pnOpciones.add(btnAbrirRuta);
		btnAbrirRuta.setForeground(Color.WHITE);
		btnAbrirRuta.setBackground(Color.DARK_GRAY);
		
		btnAbrirZona = new JButton("Zona");
		btnAbrirZona.setForeground(Color.WHITE);
		btnAbrirZona.setBackground(Color.DARK_GRAY);
		btnAbrirZona.setBounds(605, 15, 115, 16);
		pnOpciones.add(btnAbrirZona);
		
		pnTabla = new JPanel();
		pnTabla.setBounds(12, 85, 852, 103);
		pnUsuarios.add(pnTabla);
		pnTabla.setLayout(null);
		
		scrollPanel = new JScrollPane();
		scrollPanel.setBounds(0, 0, 852, 100);
		pnTabla.add(scrollPanel);
		
		table = new JTable();
		table.setBounds(0, 0, 1, 1);
		pnTabla.add(table);
		
		panel_1 = new JPanel();
		panel_1.setForeground(Color.GRAY);
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(324, 13, 540, 30);
		pnUsuarios.add(panel_1);
		panel_1.setLayout(new MigLayout("", "[grow]", "[]"));
		
		txtABuscar = new JTextField();
		txtABuscar.setForeground(Color.WHITE);
		txtABuscar.setBackground(new Color(64, 64, 64));
		panel_1.add(txtABuscar, "flowx,cell 0 0,growx");
		txtABuscar.setColumns(10);
		
		btnABuscar = new JButton("");
		btnABuscar.addActionListener(contUsuarios.buscar());
		btnABuscar.setVerticalAlignment(SwingConstants.TOP);
		btnABuscar.setBackground(Color.DARK_GRAY);
		btnABuscar.setIcon(new ImageIcon("img/gestion/buscar.png"));
		panel_1.add(btnABuscar, "cell 0 0");
		
		lblTipoUsuario = new JLabel("Tipo Usuario:");
		lblTipoUsuario.setForeground(Color.WHITE);
		lblTipoUsuario.setFont(new Font("DejaVu Sans", Font.BOLD, 13));
		lblTipoUsuario.setBounds(12, 18, 113, 25);
		pnUsuarios.add(lblTipoUsuario);
		
		cmbTipoUsuario = new JComboBox();
		cmbTipoUsuario.setModel(new DefaultComboBoxModel(new String[] {"Todos", "JefeVenta", "Vendedor", "Concesionario"}));
		cmbTipoUsuario.addActionListener(contUsuarios.ActivarTipoUsuario());
		cmbTipoUsuario.setBounds(114, 18, 200, 20);
		pnUsuarios.add(cmbTipoUsuario);
		
		pnEditar = new JPanel();
		pnEditar.setBackground(Color.GRAY);
		pnEditar.setBounds(12, 200, 852, 293);
		pnUsuarios.add(pnEditar);
		pnEditar.setLayout(null);
		
		pnUsuario = new JPanel();
		pnUsuario.setLayout(null);
		pnUsuario.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)),"Editar Usuario", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		pnUsuario.setBackground(Color.DARK_GRAY);
		pnUsuario.setBounds(0, 5, 852, 80);
		pnEditar.add(pnUsuario);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(contUsuarios.guardar());
		btnGuardar.setForeground(Color.WHITE);
		btnGuardar.setBackground(Color.DARK_GRAY);
		btnGuardar.setBounds(720, 17, 120, 16);
		pnUsuario.add(btnGuardar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				quitarNuevo();
			}
		});
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setBackground(Color.DARK_GRAY);
		btnCancelar.setBounds(5, 17, 120, 16);
		pnUsuario.add(btnCancelar);
		
		lblUserName = new JLabel("UserName:");
		lblUserName.setForeground(Color.WHITE);
		lblUserName.setFont(new Font("DejaVu Sans", Font.BOLD, 13));
		lblUserName.setBounds(143, 13, 81, 25);
		pnUsuario.add(lblUserName);
		
		txtUserName = new JTextField();
		txtUserName.setColumns(10);
		txtUserName.setBounds(229, 17, 200, 16);
		pnUsuario.add(txtUserName);
		
		txtId = new JTextField();
		txtId.setColumns(10);
		txtId.setBounds(163, 9, 54, 19);
		pnUsuario.add(txtId);
		
		lblCedula = new JLabel("Cedula:");
		lblCedula.setForeground(Color.WHITE);
		lblCedula.setFont(new Font("DejaVu Sans", Font.BOLD, 13));
		lblCedula.setBounds(36, 40, 69, 25);
		pnUsuario.add(lblCedula);
		
		lblContrasena = new JLabel("Contraseña:");
		lblContrasena.setForeground(Color.WHITE);
		lblContrasena.setFont(new Font("DejaVu Sans", Font.BOLD, 13));
		lblContrasena.setBounds(239, 40, 103, 25);
		pnUsuario.add(lblContrasena);
		
		lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("DejaVu Sans", Font.BOLD, 13));
		lblNombre.setBounds(440, 13, 69, 25);
		pnUsuario.add(lblNombre);
		
		lblReContrasena = new JLabel("Repetir Contraseña:");
		lblReContrasena.setForeground(Color.WHITE);
		lblReContrasena.setFont(new Font("DejaVu Sans", Font.BOLD, 13));
		lblReContrasena.setBounds(440, 40, 157, 25);
		pnUsuario.add(lblReContrasena);
		
		txtCedula = new JTextField();
		txtCedula.setColumns(10);
		txtCedula.setBounds(124, 45, 100, 16);
		pnUsuario.add(txtCedula);
		
		txtContrasena = new JTextField();
		txtContrasena.setColumns(10);
		txtContrasena.setBounds(327, 42, 100, 16);
		pnUsuario.add(txtContrasena);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(499, 16, 200, 16);
		pnUsuario.add(txtNombre);
		
		txtReContrasena = new JTextField();
		txtReContrasena.setColumns(10);
		txtReContrasena.setBounds(599, 43, 100, 16);
		pnUsuario.add(txtReContrasena);
		
		pnEditarRuta = new JPanel();
		pnEditarRuta.setLayout(null);
		pnEditarRuta.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Editar Rutas", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		pnEditarRuta.setBackground(Color.DARK_GRAY);
		pnEditarRuta.setBounds(0, 90, 852, 130);
		pnEditar.add(pnEditarRuta);
		
		JPanel pnRutas = new JPanel();
		pnRutas.setBounds(10, 20, 575, 90);
		pnEditarRuta.add(pnRutas);
		pnRutas.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 575, 90);
		pnRutas.add(scrollPane);
		
		tablaRutas = new JTable();
		scrollPane.setViewportView(tablaRutas);
		
		comboRutas = new JComboBox();
		comboRutas.setBounds(592, 20, 248, 24);
		comboRutas.setRenderer(new ListCellRenderer() {
			@Override
			public Component getListCellRendererComponent(JList list,
					Object value, int index, boolean isSelected,
					boolean cellHasFocus) {
				// TODO Auto-generated method stub
				Ruta ruta = (Ruta)value;
				return new JLabel(ruta.getNombre());	
			}
		});
	
		pnEditarRuta.add(comboRutas);
		
		activarJComboBoxBindingRuta();
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Boolean enc = false;
				for(Ruta ruta1: rutasVendedores) if (ruta1.equals(comboRutas.getSelectedItem())) enc = true;
				if (!enc) rutasVendedores.add((Ruta) comboRutas.getSelectedItem()); 
				activarBindingRutas(rutasVendedores);
			}
		});
		btnAgregar.setForeground(Color.WHITE);
		btnAgregar.setBackground(Color.DARK_GRAY);
		btnAgregar.setBounds(592, 58, 120, 16);
		pnEditarRuta.add(btnAgregar);
		
		JButton btnQuitar = new JButton("Guardar");
		btnQuitar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				rutasVendedores.remove(comboRutas.getSelectedItem());
				activarBindingRutas(rutasVendedores);
			}
		});
		btnQuitar.setForeground(Color.WHITE);
		btnQuitar.setBackground(Color.DARK_GRAY);
		btnQuitar.setBounds(720, 58, 120, 16);
		pnEditarRuta.add(btnQuitar);
		
		pnZona = new JPanel();
		pnZona.setLayout(null);
		pnZona.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Editar Zona", TitledBorder.LEADING, TitledBorder.TOP, null, Color.WHITE));
		pnZona.setBackground(Color.DARK_GRAY);
		pnZona.setBounds(0, 227, 852, 63);
		pnEditar.add(pnZona);
		
		cmbZona = new JComboBox();
		cmbZona.setBounds(56, 22, 248, 24);
		cmbZona.setRenderer(new ListCellRenderer() {
			
			public Component getListCellRendererComponent(JList list,
					Object value, int index, boolean isSelected,
					boolean cellHasFocus) {
				// TODO Auto-generated method stub
				Zona zona = (Zona)value;
				return new JLabel(zona.getDescripcion());	
			}
		});
	
		pnZona.add(cmbZona);
		
		activarJComboBoxBindingZona();
		
		lblZona = new JLabel("Zona:");
		lblZona.setForeground(Color.WHITE);
		lblZona.setFont(new Font("DejaVu Sans", Font.BOLD, 13));
		lblZona.setBounds(12, 22, 50, 25);
		pnZona.add(lblZona);
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void activarBindingVendedores(List<Vendedor> vendedores) {
		pnTabla.setVisible(true);
		table = new JTable();
		scrollPanel.setViewportView(table);
		binUsuarios = SwingBindings.createJTableBinding(AutoBinding.UpdateStrategy.READ_WRITE,
    			vendedores,table);
		BeanProperty idUsuario  = BeanProperty.create("id");
		BeanProperty UserNameUsuario = BeanProperty.create("userName");
		BeanProperty CedulaUsuario = BeanProperty.create("cedula");
		BeanProperty NombreUsuario = BeanProperty.create("nombre");
		
		BeanProperty rutaVendedor = BeanProperty.create("ruta.nombre");
		
		binUsuarios.addColumnBinding(idUsuario).setColumnClass(Integer.class).setColumnName("idVendedor ");
		binUsuarios.addColumnBinding(UserNameUsuario).setColumnClass(String.class).setColumnName("UserName");
		binUsuarios.addColumnBinding(CedulaUsuario).setColumnClass(String.class).setColumnName("Cedula");
		binUsuarios.addColumnBinding(NombreUsuario).setColumnClass(String.class).setColumnName("Nombre");
		
		binUsuarios.addColumnBinding(rutaVendedor).setColumnClass(String.class).setColumnName("Ruta1");
	    binUsuarios.addColumnBinding(rutaVendedor).setColumnClass(String.class).setColumnName("Ruta2");
	    binUsuarios.addColumnBinding(rutaVendedor).setColumnClass(String.class).setColumnName("Ruta3");
	    binUsuarios.bind();
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void activarBindingJefeVentas(List<JefeVenta> jefeVentas) {
		pnTabla.setVisible(true);
		table = new JTable();
		scrollPanel.setViewportView(table);
		binUsuarios = SwingBindings.createJTableBinding(AutoBinding.UpdateStrategy.READ_WRITE,
				jefeVentas,table);
		BeanProperty idUsuario  = BeanProperty.create("id");
		BeanProperty UserNameUsuario = BeanProperty.create("username");
		BeanProperty CedulaUsuario = BeanProperty.create("cedula");
		BeanProperty NombreUsuario = BeanProperty.create("nombre");
		
		BeanProperty zonaJefeVenta = BeanProperty.create("zona.Nombre");
		
		binUsuarios.addColumnBinding(idUsuario).setColumnClass(Integer.class).setColumnName("idJefeVenta ");
		binUsuarios.addColumnBinding(UserNameUsuario).setColumnClass(String.class).setColumnName("UserName");
		binUsuarios.addColumnBinding(CedulaUsuario).setColumnClass(String.class).setColumnName("Cedula");
		binUsuarios.addColumnBinding(NombreUsuario).setColumnClass(String.class).setColumnName("Nombre");
		
		binUsuarios.addColumnBinding(zonaJefeVenta).setColumnClass(String.class).setColumnName("Zona.descripcion");
	    binUsuarios.bind();
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void activarBindingConcesionarios(List<Concesionario> concesionarios) {
		pnTabla.setVisible(true);
		table = new JTable();
		scrollPanel.setViewportView(table);
		binUsuarios = SwingBindings.createJTableBinding(AutoBinding.UpdateStrategy.READ_WRITE,
				concesionarios,table);
		BeanProperty idUsuario  = BeanProperty.create("id");
		BeanProperty UserNameUsuario = BeanProperty.create("userName");
		BeanProperty CedulaUsuario = BeanProperty.create("cedula");
		BeanProperty NombreUsuario = BeanProperty.create("nombre");
		
		BeanProperty camionConcesionario = BeanProperty.create("camion.placa");
		BeanProperty rutaConcesionario = BeanProperty.create("ruta.nombre");

		binUsuarios.addColumnBinding(idUsuario).setColumnClass(Integer.class).setColumnName("idConcesionario ");
		binUsuarios.addColumnBinding(UserNameUsuario).setColumnClass(String.class).setColumnName("UserName");
		binUsuarios.addColumnBinding(CedulaUsuario).setColumnClass(String.class).setColumnName("Cedula");
		binUsuarios.addColumnBinding(NombreUsuario).setColumnClass(String.class).setColumnName("Nombre");
		
		binUsuarios.addColumnBinding(camionConcesionario).setColumnClass(String.class).setColumnName("Camion");
	    binUsuarios.addColumnBinding(rutaConcesionario).setColumnClass(String.class).setColumnName("Ruta");
	    
	    binUsuarios.bind();

	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void activarBinding(List<Usuario> usuarios) {
		// TODO Auto-generated method stub
		pnTabla.setVisible(true);
		table = new JTable();
		scrollPanel.setViewportView(table);
		binUsuarios = SwingBindings.createJTableBinding(AutoBinding.UpdateStrategy.READ_WRITE,
    			usuarios,table);
		
			BeanProperty idUsuario  = BeanProperty.create("id");
			BeanProperty UserNameUsuario = BeanProperty.create("username");
			BeanProperty CedulaUsuario = BeanProperty.create("cedula");
			BeanProperty NombreUsuario = BeanProperty.create("nombre");
			
			binUsuarios.addColumnBinding(idUsuario).setColumnClass(Integer.class).setColumnName("idUsuario ");
			binUsuarios.addColumnBinding(UserNameUsuario).setColumnClass(String.class).setColumnName("UserName");
			binUsuarios.addColumnBinding(CedulaUsuario).setColumnClass(String.class).setColumnName("Cedula");
			binUsuarios.addColumnBinding(NombreUsuario).setColumnClass(String.class).setColumnName("Nombre");
			binUsuarios.bind();

	}
	
	@SuppressWarnings("rawtypes")
	public void activarJComboBoxBindingRuta(){
		JComboBoxBinding jcomboRutas = SwingBindings.createJComboBoxBinding(AutoBinding.UpdateStrategy.READ,rutas,comboRutas);
	    jcomboRutas.bind();
	}
	
	@SuppressWarnings("rawtypes")
	public void activarJComboBoxBindingZona(){
		JComboBoxBinding jcomboZonas = SwingBindings.createJComboBoxBinding(AutoBinding.UpdateStrategy.READ,zonas,cmbZona);
	    jcomboZonas.bind();
	}
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void activarBindingRutas(List<Ruta> rutas) {
		// TODO Auto-generated method stubactivarBinding

		binRutas = SwingBindings.createJTableBinding(AutoBinding.UpdateStrategy.READ,
    			rutas,tablaRutas);
		
		 BeanProperty idRuta = BeanProperty.create("id");
		    BeanProperty zonaRuta = BeanProperty.create("zona.descripcion");
		    BeanProperty nombreRuta = BeanProperty.create("nombre");
		  

		    binRutas.addColumnBinding(idRuta).setColumnClass(String.class).setColumnClass(String.class).setColumnName("id");
		    binRutas.addColumnBinding(zonaRuta).setColumnClass(String.class).setColumnClass(String.class).setColumnName("zona");
		    binRutas.addColumnBinding(nombreRuta).setColumnClass(String.class).setColumnClass(String.class).setColumnName("nombre");
		    
		    binRutas.bind();    
	}

	public void activarNuevo() {
		// TODO Auto-generated method stub
		txtId.setVisible(false);
		if (cmbTipoUsuario.getSelectedItem().equals("JefeVenta")) pnEditar.setBounds(12, 81, 852, 298);
		else if (cmbTipoUsuario.getSelectedItem().equals("Todos")) pnEditar.setBounds(12, 81, 852, 90);
		else pnEditar.setBounds(12, 81, 852, 230);
		pnEditar.setVisible(true);
		getTxtCedula().setText("");
		getTxtNombre().setText("");
		getTxtReContrasena().setText("");
		getTxtContrasena().setText("");
		getTxtUserName().setText("");
		pnTabla.setVisible(false);
	}
	
	public void quitarNuevo() {
		// TODO Auto-generated method stub
		pnEditar.setVisible(false);
		
		pnTabla.setVisible(true);
		scrollPanel.setVisible(true);
		
	}
	
	public JPanel getPnOpciones() {
		return pnOpciones;
	}

	public void setPnOpciones(JPanel pnOpciones) {
		this.pnOpciones = pnOpciones;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JPanel getPnUsuarios() {
		return pnUsuarios;
	}

	public void setPnUsuarios(JPanel pnUsuarios) {
		this.pnUsuarios = pnUsuarios;
	}

	public JPanel getPanel_1() {
		return panel_1;
	}

	public void setPanel_1(JPanel panel_1) {
		this.panel_1 = panel_1;
	}

	public JPanel getPnTabla() {
		return pnTabla;
	}

	public void setPnTabla(JPanel pnTabla) {
		this.pnTabla = pnTabla;
	}

	public JPanel getPnEditar() {
		return pnEditar;
	}

	public void setPnEditar(JPanel pnEditar) {
		this.pnEditar = pnEditar;
	}

	public JButton getBtnNuevo() {
		return btnNuevo;
	}

	public void setBtnNuevo(JButton btnNuevo) {
		this.btnNuevo = btnNuevo;
	}

	public JButton getBtnEditar() {
		return btnEditar;
	}

	public void setBtnEditar(JButton btnEditar) {
		this.btnEditar = btnEditar;
	}

	public JButton getBtnAtras() {
		return btnAtras;
	}

	public void setBtnAtras(JButton btnAtras) {
		this.btnAtras = btnAtras;
	}

	public JButton getBtnSalir() {
		return btnSalir;
	}

	public void setBtnSalir(JButton btnSalir) {
		this.btnSalir = btnSalir;
	}

	public JButton getBtnABuscar() {
		return btnABuscar;
	}

	public void setBtnABuscar(JButton btnABuscar) {
		this.btnABuscar = btnABuscar;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}

	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}

	@SuppressWarnings("rawtypes")
	public JComboBox getCmbTipoUsuario() {
		return cmbTipoUsuario;
	}
	
	public void setCmbTipoUsuario(JComboBox<String> cmbTipoUsuario) {
		this.cmbTipoUsuario = cmbTipoUsuario;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	@SuppressWarnings("rawtypes")
	public JTableBinding getBinUsuarios() {
		return binUsuarios;
	}

	@SuppressWarnings("rawtypes")
	public void setBinUsuarios(JTableBinding binUsuarios) {
		this.binUsuarios = binUsuarios;
	}

	public JScrollPane getScrollPanel() {
		return scrollPanel;
	}

	public void setScrollPanel(JScrollPane scrollPanel) {
		this.scrollPanel = scrollPanel;
	}

	public JTextField getTxtABuscar() {
		return txtABuscar;
	}

	public void setTxtABuscar(JTextField txtABuscar) {
		this.txtABuscar = txtABuscar;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setCamiones(List<Usuario> camiones) {
		this.usuarios = camiones;
	}

	public JLabel getLblTipoUsuario() {
		return lblTipoUsuario;
	}

	public void setLblTipoUsuario(JLabel lblTipoUsuario) {
		this.lblTipoUsuario = lblTipoUsuario;
	}

	public JPanel getPnUsuario() {
		return pnUsuario;
	}

	public void setPnUsuario(JPanel pnUsuario) {
		this.pnUsuario = pnUsuario;
	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}

	public void setBtnGuardar(JButton btnGuardar) {
		this.btnGuardar = btnGuardar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public void setBtnCancelar(JButton btnCancelar) {
		this.btnCancelar = btnCancelar;
	}

	public JLabel getLblUserName() {
		return lblUserName;
	}

	public void setLblUserName(JLabel lblUserName) {
		this.lblUserName = lblUserName;
	}

	public JTextField getTxtUserName() {
		return txtUserName;
	}

	public void setTxtUserName(JTextField txtUserName) {
		this.txtUserName = txtUserName;
	}

	public JTextField getTxtId() {
		return txtId;
	}

	public void setTxtId(JTextField txtID) {
		this.txtId = txtID;
	}

	public JLabel getLblCedula() {
		return lblCedula;
	}

	public void setLblCedula(JLabel lblCedula) {
		this.lblCedula = lblCedula;
	}

	public JLabel getLblContrasena() {
		return lblContrasena;
	}

	public void setLblContrasena(JLabel lblContrasena) {
		this.lblContrasena = lblContrasena;
	}

	public JLabel getLblNombre() {
		return lblNombre;
	}

	public void setLblNombre(JLabel lblNombre) {
		this.lblNombre = lblNombre;
	}

	public JLabel getLblReContrasena() {
		return lblReContrasena;
	}

	public void setLblReContrasena(JLabel lblReContrasena) {
		this.lblReContrasena = lblReContrasena;
	}

	public JTextField getTxtCedula() {
		return txtCedula;
	}

	public void setTxtCedula(JTextField txtCedula) {
		this.txtCedula = txtCedula;
	}

	public JTextField getTxtContrasena() {
		return txtContrasena;
	}

	public void setTxtContrasena(JTextField txtContrasena) {
		this.txtContrasena = txtContrasena;
	}

	public JTextField getTxtNombre() {
		return txtNombre;
	}

	public void setTxtNombre(JTextField txtNombre) {
		this.txtNombre = txtNombre;
	}

	public JTextField getTxtReContrasena() {
		return txtReContrasena;
	}

	public void setTxtReContrasena(JTextField txtReContrasena) {
		this.txtReContrasena = txtReContrasena;
	}

	public JPanel getPnRuta() {
		return pnEditarRuta;
	}

	public void setPnRuta(JPanel pnRuta) {
		this.pnEditarRuta = pnRuta;
	}

	public JPanel getPnZona() {
		return pnZona;
	}

	public void setPnZona(JPanel pnZona) {
		this.pnZona = pnZona;
	}

	@SuppressWarnings("rawtypes")
	public JComboBox getCmbZona() {
		return cmbZona;
	}

	public void setCmbZona(JComboBox<Zona> cmbZona) {
		this.cmbZona = cmbZona;
	}

	public JLabel getLblZona() {
		return lblZona;
	}

	public void setLblZona(JLabel lblZona) {
		this.lblZona = lblZona;
	}


	public JButton getBtnAbrirRuta() {
		return btnAbrirRuta;
	}

	public void setBtnAbrirRuta(JButton btnAbrirRuta) {
		this.btnAbrirRuta = btnAbrirRuta;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}
}