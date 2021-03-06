/*Seccion 6
 * Gipsis Marin 19.828.553
 *Leonardo Pineda 19.727.835
 *Rhonal Chirinos 19.827.297
 *Joan Puerta 19.323.522
 *Vilfer Alvarez 18.735.720
 */

package santaclara.vista;

import java.awt.EventQueue; 

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuItem; 
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import santaclara.controlador.ContPrincipal;
import santaclara.vista.herramientas.VistaGenericaUI; 

@SuppressWarnings("serial")
public class PrincipalUI extends JPanel {

	private JFrame frame;
	private JMenuBar menuBar = new JMenuBar();
	private ContPrincipal controlador;

	private 	JMenu mnCatalogo;
	private 	JMenu mnDetalleFacturacion;
	private 	JMenu mnDomicilioComerciales;
	private 	JMenu mnFacturacion;
	private 	JMenu mnReportes;
	private 	JMenu mnConsulta;
	private 	JMenu mnAsociacionTabla;
	private 	JMenu mnBaseDato;
	private 	JMenu mnSalir;
	private 	JMenuItem mntCerrar;
	
	private    JMenuItem mntAlmacen;
	private    JMenuItem mntCamiones;
	private    JMenuItem mntCapacidades;
	private 	JMenuItem mntClientes;
	private 	JMenuItem mntConcesionarios;
	private 	JMenuItem mntConcesionarioRutas;
	private 	JMenuItem mntEmpaqueProductos;
	private 	JMenuItem mntJefeVenta;
	private 	JMenuItem mntPresentaciones;
	private 	JMenuItem mntProductos;
	private 	JMenuItem mntProductoAlmacenes;
	private 	JMenuItem mntRutas;
	private 	JMenuItem mntSabores;
	private 	JMenuItem mntUsuarios;
	private 	JMenuItem mntVendedores;
	private 	JMenuItem mntVisitas;
	private 	JMenuItem mntZonas;
	private 	JMenuItem mntCalendarios;
	private    JMenuItem mntPedidos;
	private    JMenuItem mntReportMontFacturaAlmacen;

	private    JMenuItem mntReportMontFacturaVendedor;
	private    JMenuItem mntConsultaDetalleFacturaMesAlmacen;
	private 	JMenuItem mntListCantRefrescoSaborVendidoAlmacen;
	private 	JMenuItem mntListCantRefrescoPresentCapacFacturadoZona;
	private		JMenuItem mntListClienteZonaTipo;
	private		JMenuItem mntMontoFacturadoMesZonaTipoPago;
	
	private 	JMenuItem mntPostgreSqlAjustes;
	private 	JMenuItem mntPgAdmin3;
	
	private 	JMenuItem mntCapturarLista;
	
	private 	JMenuItem mntEjecutarCapturaLista;

	/**** codigo para la defensa  */
	 
	 private    JMenuItem mntReporte;
	 private    JMenuItem mntConsultadeMontoTotalporRefresco;
	 
	/**** fin */
	
	/**** para la animacion con imagenes */
	 
	 private JLabel lblAnimacion;
	 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalUI window = new PrincipalUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param controlador 
	 */
	public PrincipalUI(ContPrincipal controlador) {
		this.controlador = controlador;
		initialize();
	}
	
	
	public PrincipalUI( ) {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame("Embotelladora Santa Clara");
		frame.setBounds(VistaGenericaUI.getMargenX(),VistaGenericaUI.getMargenY(),VistaGenericaUI.getWidthPantalla(),VistaGenericaUI.getHeightPantalla());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		  
		JPanel panel = new JPanel();
		frame.setContentPane(panel);
		frame.setVisible(true);
  
		menuBar.setToolTipText("Menu");
		frame.setJMenuBar(menuBar);
		
		mnCatalogo = new JMenu("Catalogo");
		menuBar.add(mnCatalogo);
		
		mnFacturacion = new JMenu("Facturacion");
		menuBar.add(mnFacturacion);

		mnReportes = new JMenu("Reportes");
		menuBar.add(mnReportes);
		
		mnConsulta = new JMenu("Consulta");
		menuBar.add(mnConsulta);
		
		mnAsociacionTabla = new JMenu("Asociar Tabla");
		menuBar.add(mnAsociacionTabla);
		
		mnBaseDato = new JMenu("Base de Dato");
		menuBar.add(mnBaseDato);

 
		/***************************** Botones para catalogo **********************************/
		
		mntAlmacen = new JMenuItem("Almacenes");
		mntAlmacen.addActionListener(controlador.activarMenu());
		mntAlmacen.setIcon(new ImageIcon("img/gestion/empresa.png"));
		mnCatalogo.add(mntAlmacen);
		
		mnCatalogo.add(new JSeparator());

		/***************************** Botones para Reporte **********************************/
		
		mntReportMontFacturaAlmacen = new JMenuItem("Monto Total Facturado por Almacenes");
		mntReportMontFacturaAlmacen.setIcon(new ImageIcon("img/gestion/consulta1.png"));
		mnReportes.add(mntReportMontFacturaAlmacen);
		mntReportMontFacturaAlmacen.addActionListener(controlador.activarMenu());
		
		mntReportMontFacturaVendedor = new JMenuItem("Monto Total Facturado por Vendedores");
		mntReportMontFacturaVendedor.setIcon(new ImageIcon("img/gestion/consulta2.png"));
		mnReportes.add(mntReportMontFacturaVendedor);
		mntReportMontFacturaVendedor.addActionListener(controlador.activarMenu());
		
		/***************************** Botones para Consultar **********************************/
		
		mntConsultaDetalleFacturaMesAlmacen = new JMenuItem("Detalle Facturado mensualmente por Almacen");
		mntConsultaDetalleFacturaMesAlmacen.setIcon(new ImageIcon("img/gestion/consulta3.png"));
		mnConsulta.add(mntConsultaDetalleFacturaMesAlmacen);
		mntConsultaDetalleFacturaMesAlmacen.addActionListener(controlador.activarMenu());

		mntListCantRefrescoSaborVendidoAlmacen = new JMenuItem("Listado Cantidad de refresco por Sabor Vendido en Cada Almacen");
		mntListCantRefrescoSaborVendidoAlmacen.setIcon(new ImageIcon("img/gestion/consulta4.png"));
		mnConsulta.add(mntListCantRefrescoSaborVendidoAlmacen);
		mntListCantRefrescoSaborVendidoAlmacen.addActionListener(controlador.activarMenu());

		mntListCantRefrescoPresentCapacFacturadoZona = new JMenuItem("Listado Cantidad de Refresco por Presentacion y Capacidad Facturado por Zona");
		mntListCantRefrescoPresentCapacFacturadoZona.setIcon(new ImageIcon("img/gestion/consulta5.png"));
		mnConsulta.add(mntListCantRefrescoPresentCapacFacturadoZona);
		mntListCantRefrescoPresentCapacFacturadoZona.addActionListener(controlador.activarMenu());

		mntListClienteZonaTipo = new JMenuItem("Listado Detalle de Cliente por Zona y por Tipo");
		mntListClienteZonaTipo.setIcon(new ImageIcon("img/gestion/consulta8.png"));
		mnConsulta.add(mntListClienteZonaTipo);
		mntListClienteZonaTipo.addActionListener(controlador.activarMenu());
		
		mntMontoFacturadoMesZonaTipoPago = new JMenuItem("Monto total Facturado Mensualmente por almacen y por Tipo de Pago");
		mntMontoFacturadoMesZonaTipoPago.setIcon(new ImageIcon("img/gestion/consulta7.png"));
		mnConsulta.add(mntMontoFacturadoMesZonaTipoPago);
		mntMontoFacturadoMesZonaTipoPago.addActionListener(controlador.activarMenu());
		
		mntProductos = new JMenuItem("Productos");
		mntProductos.setIcon(new ImageIcon("img/gestion/producto.png"));
		mntProductos.addActionListener(controlador.activarMenu());
		mnCatalogo.add(mntProductos);
		
		mntSabores = new JMenuItem("Sabores");
		mntSabores.setIcon(new ImageIcon("img/gestion/Sabor.png"));
		mntSabores.addActionListener(controlador.activarMenu());
		mnCatalogo.add(mntSabores);
		
		mntEmpaqueProductos = new JMenuItem("Empaque Productos");
		mntEmpaqueProductos.setIcon(new ImageIcon("img/gestion/empaqueProducto.png"));
		mntEmpaqueProductos.addActionListener(controlador.activarMenu());
		mnCatalogo.add(mntEmpaqueProductos);

		mntPresentaciones = new JMenuItem("Presentaciones");
		mntPresentaciones.setIcon(new ImageIcon("img/gestion/Presentacion.png"));
		mntPresentaciones.addActionListener(controlador.activarMenu());
		mnCatalogo.add(mntPresentaciones);
 
		mntCapacidades = new JMenuItem("Capacidades");
		mntCapacidades.setIcon(new ImageIcon("img/gestion/Capacidad.png"));
		mnCatalogo.add(mntCapacidades);
		mntCapacidades.addActionListener(controlador.activarMenu());

		mnCatalogo.add(new JSeparator());

		mntRutas = new JMenuItem("Ruta");
		mntRutas.setIcon(new ImageIcon("img/gestion/ruta.png"));
		mntRutas.addActionListener(controlador.activarMenu());
		mnCatalogo.add(mntRutas);
		
		mntZonas = new JMenuItem("Zonas");
		mntZonas.addActionListener(controlador.activarMenu());
		mntZonas.setIcon(new ImageIcon("img/gestion/zona.png"));
		mnCatalogo.add(mntZonas);

		mntClientes = new JMenuItem("Clientes ");
		mntClientes.setIcon(new ImageIcon("img/gestion/clientes.png"));
		mntClientes.addActionListener(controlador.activarMenu());
		mnCatalogo.add(mntClientes);
		
		mnCatalogo.add(new JSeparator());

		mntUsuarios = new JMenuItem("Usuarios ('Jefes de Ventas','Vendedores','Concecionaros')");
		mntUsuarios.setIcon(new ImageIcon("img/gestion/user.png"));
		mnCatalogo.add(mntUsuarios);
		mntUsuarios.addActionListener(controlador.activarMenu());

		mntJefeVenta = new JMenuItem("Jefe Ventas");
		mntJefeVenta.setIcon(new ImageIcon("img/gestion/jefeVenta.png"));
		mnCatalogo.add(mntJefeVenta);
		mntJefeVenta.addActionListener(controlador.activarMenu());
	
		mntConcesionarios = new JMenuItem("Concesionarios");
		mntConcesionarios.setIcon(new ImageIcon("img/gestion/concesionario.png"));
		mnCatalogo.add(mntConcesionarios);
		mntConcesionarios.addActionListener(controlador.activarMenu());

		mntVendedores = new JMenuItem("Vendedores");
		mntVendedores.setIcon(new ImageIcon("img/gestion/vendedor.png"));
		mnCatalogo.add(mntVendedores);
		mntVendedores.addActionListener(controlador.activarMenu());	
		
		mnCatalogo.add(new JSeparator());
		
		mntCalendarios = new JMenuItem("Calendario");
		mntCalendarios.setIcon(new ImageIcon("img/gestion/calendario.png"));
		mnCatalogo.add(mntCalendarios);
		mntCalendarios.addActionListener(controlador.activarMenu());
		
		mntVisitas = new JMenuItem("Visitas");
		mntVisitas.setIcon(new ImageIcon("img/gestion/visita.png"));
		mnCatalogo.add(mntVisitas);
		mntVisitas.addActionListener(controlador.activarMenu());
		
		mnCatalogo.add(new JSeparator());
		mntCamiones = new JMenuItem("Camiones");
		mntCamiones.setIcon(new ImageIcon("img/gestion/camion.png"));
		mnCatalogo.add(mntCamiones);
		mntCamiones.addActionListener(controlador.activarMenu());

		
		/*
		
		mntVisitas = new JMenuItem("Visitas");
		mnCatalogo.add(mntVisitas);
		mntVisitas.addActionListener(controlador.activarMenu());
		*/ 
		
		mntPedidos = new JMenuItem("Pedidos");
		mntPedidos.setIcon(new ImageIcon("img/gestion/pedido.png"));
		mntPedidos.addActionListener(controlador.activarMenu());
		mnFacturacion.add(mntPedidos);
		
		/*
		mntConcesionarios = new JMenuItem("Consesionarios");
		mnCatalogo.add(mntConcesionarios);
		*/ 
		/****************** btn cerrar session  ******/
		mnSalir = new JMenu("Salir");
		mntCerrar = new JMenuItem("cerrar sesión ");
		mntCerrar.setIcon(new ImageIcon("img/gestion/pedido.png"));
		mnSalir.add(mntCerrar);  
		mntCerrar.addActionListener(controlador.salirSesion());
		menuBar.add(mnSalir);
		 
		menuBar.setVisible(false);;
		frame.setVisible(true); 
	
		
		mntReporte = new JMenuItem("TuNombre"); 
		mntReporte.setIcon(new ImageIcon("img/gestion/consulta14.png"));
		mnReportes.add(mntReporte);
		mntReporte.addActionListener(controlador.activarMenu());
		
		mntConsultadeMontoTotalporRefresco = new JMenuItem("Consulta de Monto Total por Refresco"); 
		mntConsultadeMontoTotalporRefresco.setIcon(new ImageIcon("img/gestion/consulta15.png"));
		mnConsulta.add(mntConsultadeMontoTotalporRefresco);
		mntConsultadeMontoTotalporRefresco.addActionListener(controlador.activarMenu());
		
		mntPostgreSqlAjustes = new JMenuItem("Ajustes de Conexion");
		mntPostgreSqlAjustes.setIcon(new ImageIcon("img/gestion/db.png"));
		mntPostgreSqlAjustes.setToolTipText("Configuracion de la Base de Dato");
		mnBaseDato.add(mntPostgreSqlAjustes);
		mntPostgreSqlAjustes.addActionListener(controlador.activarMenu());
		
		mntPgAdmin3 = new JMenuItem("pgAdmin III");
		mntPgAdmin3.setIcon(new ImageIcon("img/gestion/pgAdmin3.png"));
		mntPgAdmin3.setToolTipText("pgAdmin III");
		mnBaseDato.add(mntPgAdmin3);
		mntPgAdmin3.addActionListener(controlador.activarMenu());
		
		mntCapturarLista = new JMenuItem("Capturar Tabla");
		mntCapturarLista.setToolTipText("Permite la asociacion de tablas");
		mntCapturarLista.setIcon(new ImageIcon("img/gestion/asociar.png"));
		mnAsociacionTabla.add(mntCapturarLista);
		mntCapturarLista.addActionListener(controlador.activarMenu());
		
		mntEjecutarCapturaLista = new JMenuItem("Ejecutar Composicion Tabla");
		mntEjecutarCapturaLista.setToolTipText("Procesar informacion");
		mntEjecutarCapturaLista.setIcon(new ImageIcon("img/gestion/ejecutar.png"));
		mnAsociacionTabla.add(mntEjecutarCapturaLista);
		mntEjecutarCapturaLista.addActionListener(controlador.activarMenu());
		
	}
	
	public void dibujarMenu()
	{ 
		menuBar.setVisible(true);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
 

	public JMenuBar getMenuBar() {
		return menuBar;
	}

	public void setMenuBar(JMenuBar menuBar) {
		this.menuBar = menuBar;
	}

	public JMenuItem getMntVendedores() {
		return mntVendedores;
	}

	public void setMntVendedores(JMenuItem mntVendedores) {
		this.mntVendedores = mntVendedores;
	}

	public JMenu getMnCatalogo() {
		return mnCatalogo;
	}

	public void setMnCatalogo(JMenu mnCatalogo) {
		this.mnCatalogo = mnCatalogo;
	}

	public JMenuItem getMntEmpaqueProductos() {
		return mntEmpaqueProductos;
	}

	public void setMntEmpaqueProductos(JMenuItem mntProductos) {
		this.mntEmpaqueProductos = mntProductos;
	}

	public JMenuItem getMntClientes() {
		return mntClientes;
	}

	public void setMntClientes(JMenuItem mntClientes) {
		this.mntClientes = mntClientes;
	}

	public JMenuItem getMntConcesionario() {
		return mntConcesionarios;
	}

	public void setMntConcesionario(JMenuItem mntConcesionario) {
		this.mntConcesionarios = mntConcesionario;
	}

	public JMenu getMnFacturacion() {
		return mnFacturacion;
	}

	public void setMnFacturacion(JMenu mnFacturacion) {
		this.mnFacturacion = mnFacturacion;
	}

	public JMenu getMnReportes() {
		return mnReportes;
	}

	public void setMnReportes(JMenu mnReportes) {
		this.mnReportes = mnReportes;
	}

	public JMenu getMnConsulta() {
		return mnConsulta;
	}

	public void setMnConsulta(JMenu mnConsulta) {
		this.mnConsulta = mnConsulta;
	}

	public JMenu getMnSalir() {
		return mnSalir;
	}

	public void setMnSalir(JMenu mnSalir) {
		this.mnSalir = mnSalir;
	}

	public JMenuItem getMntCerrar() {
		return mntCerrar;
	}

	public void setMntCerrar(JMenuItem mntCerrar) {
		this.mntCerrar = mntCerrar;
	}

	public JMenuItem getMntRuta() {
		return mntRutas;
	}

	public void setMntRuta(JMenuItem mntRuta) {
		this.mntRutas = mntRuta;
	}

	public ContPrincipal getControlador() {
		return controlador;
	}

	public void setControlador(ContPrincipal controlador) {
		this.controlador = controlador;
	}

	public JMenuItem getMntRutas() {
		return mntRutas;
	}

	public void setMntRutas(JMenuItem mntRutas) {
		this.mntRutas = mntRutas;
	}

	public JMenuItem getMntPresentaciones() {
		return mntPresentaciones;
	}

	public void setMntPresentaciones(JMenuItem mntPresentaciones) {
		this.mntPresentaciones = mntPresentaciones;
	}

	public JMenuItem getMntAlmacen() {
		return mntAlmacen;
	}

	public void setMntAlmacen(JMenuItem mntAlmacen) {
		this.mntAlmacen = mntAlmacen;
	}

	public JMenuItem getMntCamiones() {
		return mntCamiones;
	}

	public void setMntCamiones(JMenuItem mntCamiones) {
		this.mntCamiones = mntCamiones;
	}

	public JMenuItem getMntCapacidades() {
		return mntCapacidades;
	}

	public void setMntCapacidades(JMenuItem mntCapacidades) {
		this.mntCapacidades = mntCapacidades;
	}

	public JMenuItem getMntConcesionarios() {
		return mntConcesionarios;
	}

	public void setMntConcesionarios(JMenuItem mntConcesionarios) {
		this.mntConcesionarios = mntConcesionarios;
	}

	public JMenuItem getMntConcesionarioRutas() {
		return mntConcesionarioRutas;
	}

	public void setMntConcesionarioRutas(JMenuItem mntConcesionarioRutas) {
		this.mntConcesionarioRutas = mntConcesionarioRutas;
	}

	public JMenu getMnDetalleFacturacion() {
		return mnDetalleFacturacion;
	}

	public void setMnDetalleFacturacion(JMenu mnDetalleFacturacion) {
		this.mnDetalleFacturacion = mnDetalleFacturacion;
	}

	public JMenu getMnDomicilioComerciales() {
		return mnDomicilioComerciales;
	}

	public void setMnDomicilioComerciales(JMenu mnDomicilioComerciales) {
		this.mnDomicilioComerciales = mnDomicilioComerciales;
	}

	public JMenuItem getMntJefeVenta() {
		return mntJefeVenta;
	}

	public void setMntJefeVenta(JMenuItem mntJefeVenta) {
		this.mntJefeVenta = mntJefeVenta;
	}

	public JMenuItem getMntProductos() {
		return mntProductos;
	}

	public void setMntProductos(JMenuItem mntProductos) {
		this.mntProductos = mntProductos;
	}

	public JMenuItem getMntProductoAlmacenes() {
		return mntProductoAlmacenes;
	}

	public void setMntProductoAlmacenes(JMenuItem mntProductoAlmacenes) {
		this.mntProductoAlmacenes = mntProductoAlmacenes;
	}

	public JMenuItem getMntSabores() {
		return mntSabores;
	}

	public void setMntSabores(JMenuItem mntSabores) {
		this.mntSabores = mntSabores;
	}

 
	public JMenuItem getMntUsuarios() {
		return mntUsuarios;
	}

	public void setMntUsuarios(JMenuItem mntUsuarios) {
		this.mntUsuarios = mntUsuarios;
	}

	public JMenuItem getMntVisitas() {
		return mntVisitas;
	}

	public void setMntVisitas(JMenuItem mntVisitas) {
		this.mntVisitas = mntVisitas;
	}

	public JMenuItem getMntZonas() {
		return mntZonas;
	}

	public void setMntZonas(JMenuItem mntZonas) {
		this.mntZonas = mntZonas;
	}

	public JMenuItem getMntCalendarios() {
		return mntCalendarios;
	}

	public void setMntCalendarios(JMenuItem mntCalendarios) {
		this.mntCalendarios = mntCalendarios;
	}

	public JMenuItem getMntPedidos() {
		return mntPedidos;
	}

	public void setMntPedidos(JMenuItem mntPedido) {
		this.mntPedidos = mntPedido;
	}

	public JMenuItem getMntReportMontFacturaAlmacen() {
		return mntReportMontFacturaAlmacen;
	}

	public void setMntReportMontFacturaAlmacen(JMenuItem mntReportMontFacturaAlmacen) {
		this.mntReportMontFacturaAlmacen = mntReportMontFacturaAlmacen;
	}
 
	public JMenuItem getMntReportMontFacturaVendedor() {
		return mntReportMontFacturaVendedor;
	}

	public void setMntReportMontFacturaVendedor(
			JMenuItem mntReportMontFacturaVendedor) {
		this.mntReportMontFacturaVendedor = mntReportMontFacturaVendedor;
	}

	public JMenuItem getMntConsultaDetalleFacturaMesAlmacen() {
		return mntConsultaDetalleFacturaMesAlmacen;
	}

	public void setMntConsultaDetalleFacturaMesAlmacen(
			JMenuItem mntConsultaDetalleFacturaMesAlmacen) {
		this.mntConsultaDetalleFacturaMesAlmacen = mntConsultaDetalleFacturaMesAlmacen;
	}

	public JMenuItem getMntListCantRefrescoSaborVendidoAlmacen() {
		return mntListCantRefrescoSaborVendidoAlmacen;
	}

	public void setMntListCantRefrescoSaborVendidoAlmacen(
			JMenuItem mntListCantRefrescoSaborVendidoAlmacen) {
		this.mntListCantRefrescoSaborVendidoAlmacen = mntListCantRefrescoSaborVendidoAlmacen;
	}

	public JMenuItem getMntListCantRefrescoPresentCapacFacturadoZona() {
		return mntListCantRefrescoPresentCapacFacturadoZona;
	}

	public void setMntListCantRefrescoPresentCapacFacturadoZona(
			JMenuItem mntListCantRefrescoPresentCapacFacturadoZona) {
		this.mntListCantRefrescoPresentCapacFacturadoZona = mntListCantRefrescoPresentCapacFacturadoZona;
	}

	public JMenuItem getMntListClienteZonaTipo() {
		return mntListClienteZonaTipo;
	}

	public void setMntListClienteZonaTipo(JMenuItem mntListClienteZonaTipo) {
		this.mntListClienteZonaTipo = mntListClienteZonaTipo;
	}

	public JMenuItem getMntMontoFacturadoMesZonaTipoPago() {
		return mntMontoFacturadoMesZonaTipoPago;
	}

	public void setMntMontoFacturadoMesZonaTipoPago(
			JMenuItem mntMontoFacturadoMesZonaTipoPago) {
		this.mntMontoFacturadoMesZonaTipoPago = mntMontoFacturadoMesZonaTipoPago;
	}

	public JMenuItem getMntReporte() {
		return mntReporte;
	}

	public void setMntReporte(JMenuItem mntReporte) {
		this.mntReporte = mntReporte;
	}

	public JMenuItem getMntConsulta() {
		return mntConsultadeMontoTotalporRefresco;
	}

	public void setMntConsulta(JMenuItem mntConsulta) {
		this.mntConsultadeMontoTotalporRefresco = mntConsulta;
	}

	public JMenu getMnBaseDato() {
		return mnBaseDato;
	}

	public void setMnBaseDato(JMenu mnBaseDato) {
		this.mnBaseDato = mnBaseDato;
	}

	public JMenuItem getMntPostgreSqlAjustes() {
		return mntPostgreSqlAjustes;
	}

	public void setMntPostgreSqlAjustes(JMenuItem mntPostgreSqlAjustes) {
		this.mntPostgreSqlAjustes = mntPostgreSqlAjustes;
	}

	public JMenuItem getMntConsultadeMontoTotalporRefresco() {
		return mntConsultadeMontoTotalporRefresco;
	}

	public void setMntConsultadeMontoTotalporRefresco(
			JMenuItem mntConsultadeMontoTotalporRefresco) {
		this.mntConsultadeMontoTotalporRefresco = mntConsultadeMontoTotalporRefresco;
	}

	public JMenuItem getMntPgAdmin3() {
		return mntPgAdmin3;
	}

	public void setMntPgAdmin3(JMenuItem mntPgAdmin3) {
		this.mntPgAdmin3 = mntPgAdmin3;
	}

	public JLabel getLblAnimacion() {
		return lblAnimacion;
	}

	public void setLblAnimacion(JLabel lblAnimacion) {
		this.lblAnimacion = lblAnimacion;
	}

	public JMenu getMnAsociacionTabla() {
		return mnAsociacionTabla;
	}

	public void setMnAsociacionTabla(JMenu mnAsociacionTabla) {
		this.mnAsociacionTabla = mnAsociacionTabla;
	}

	public JMenuItem getMntCapturarLista() {
		return mntCapturarLista;
	}

	public void setMntCapturarLista(JMenuItem mntCapturarLista) {
		this.mntCapturarLista = mntCapturarLista;
	}

	public JMenuItem getMntEjecutarCapturaLista() {
		return mntEjecutarCapturaLista;
	}

	public void setMntEjecutarCapturaLista(JMenuItem mntEjecutarCapturaLista) {
		this.mntEjecutarCapturaLista = mntEjecutarCapturaLista;
	}	
	
}
