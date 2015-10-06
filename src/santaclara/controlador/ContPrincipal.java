package santaclara.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import javax.swing.JPanel;

import santaclara.modelo.Almacen;
import santaclara.modelo.Cliente;
import santaclara.modelo.EmpaqueProducto;
import santaclara.modelo.Usuario;
import santaclara.vista.IniciarSesionUI;
import santaclara.vista.PedidosUI;
import santaclara.vista.PrincipalUI;

public  class ContPrincipal implements IContGeneral {
	
	private PrincipalUI  vista ;
	private IContGeneral controlador;
	private Usuario		 usuario;
	private Stack<String> cache = new Stack<String>();
	private Stack<Object> cacheObjet = new Stack<Object>();
	private Boolean editorActivo = new Boolean(false);
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public static void main(String[] args) {
	   ContPrincipal controlador = new  ContPrincipal();
	   controlador.ejecutar();   
	   
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	private void ejecutar() {
		// TODO Auto-generated method stub
		vista = new PrincipalUI(this);
		// iniciar session
		try {
			setControlador(new ContIniciarSesion(this));
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	void agregarPanel(JPanel panel)
	{
		vista.getFrame().getContentPane().removeAll();
		vista.getFrame().getContentPane().add(panel);
		vista.getFrame().repaint();
	
	}
	
	void quitarPanel(){
		vista.getFrame().getContentPane().removeAll();
		vista.getFrame().repaint();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	public void dibujarMenu()
	{
		//dado el usuario 
		// limpiar contenedor 
		vista.getFrame().getContentPane().removeAll();
		vista.dibujarMenu(usuario);
		
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	public IContGeneral getControlador() {
		return controlador;
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	public void setControlador(IContGeneral controlador) {
		this.controlador = controlador;
	}

	@Override
	public JPanel getVista() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	/************ Salir Session *************/
	public ActionListener salirSesion() {
		// TODO Auto-generated method stub
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				vista.getMenuBar().setVisible(false);
				usuario = null;
				controlador = new ContIniciarSesion(ContPrincipal.this); 
				
			}
		};
	}

	public ActionListener activarMenu() {
		// TODO Auto-generated method stub
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource().equals(vista.getMntAlmacen()))
					{
						ActivarAlmacenes();
					}
				else if(e.getSource().equals(vista.getMntCamiones()))
				{
					ActivarCamiones();
				}
				else if(e.getSource().equals(vista.getMntCapacidades()))
				{
					ActivarCapacidades();
				}
				else if(e.getSource().equals(vista.getMntClientes()))
				{
					ActivarClientes();
				}
				else if(e.getSource().equals(vista.getMntConcesionario()))
				{
					ActivarUsuarios();
				}
				else if(e.getSource().equals(vista.getMntConcesionarioRutas()))
				{
					//ActivarConcesionarioRutas();
				}
				else if(e.getSource().equals(vista.getMntEmpaqueProductos()))
				{
					ActivarEmpaqueProductos();
				}
				else if(e.getSource().equals(vista.getMntJefeVenta()))
				{
					ActivarUsuarios();
				}
				else if(e.getSource().equals(vista.getMntPresentaciones()))
				{
					ActivarPresentaciones();
				}
				else if(e.getSource().equals(vista.getMntProductos()))
				{
					ActivarProductos();;
				}
				else if(e.getSource().equals(vista.getMntProductoAlmacenes()))
				{
					ActivarProductoAlmacenes();
				}
				else if(e.getSource().equals(vista.getMntRuta()))
				{
					ActivarRutas();
				}
				else if(e.getSource().equals(vista.getMntSabores()))
				{
					ActivarSabores();
				}
				else if(e.getSource().equals(vista.getMntSalps()))
				{
					ActivarClientes();
				}
				else if(e.getSource().equals(vista.getMntUsuarios()))
				{
					ActivarUsuarios();
				}
				else if(e.getSource().equals(vista.getMntVendedores()))
				{
					ActivarUsuarios();
				}
				else if(e.getSource().equals(vista.getMntVisitas()))
				{
					ActivarVisitas();
				}
				else if(e.getSource().equals(vista.getMntZonas()))
				{
					ActivarZonas();
				}
				else if(e.getSource().equals(vista.getMntCalendarios()))
				{
					ActivarCalendarios();
				}
				else if(e.getSource().equals(vista.getMntPedidos()))
				{
					ActivarPedidos(null,"",null);
				}
			}
		};
	}
	public void ActivarRutas(){
		// TODO Auto-generated method stub
		try {
			controlador = new ContRutas(ContPrincipal.this);
		}
		catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public void ActivarVisitas(){
		// TODO Auto-generated method stub
		try {
			controlador = new ContVisitas(ContPrincipal.this);
		}
		catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public void ActivarClientes() {
		// TODO Auto-generated method stub
		try {
			controlador = new ContClientes(ContPrincipal.this);
		}
		catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void ActivarVendedores() {
		// TODO Auto-generated method stub
		try {
			controlador = new ContUsuarios(ContPrincipal.this);
		}
		catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void setVista(PrincipalUI vista) {
		this.vista = vista;
	}

	public void ActivarProductos() {
		// TODO Auto-generated method stub
		try {
			controlador = new ContProductos(ContPrincipal.this);
		}
		catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		

	}
	
	public void ActivarPresentaciones() {
		// TODO Auto-generated method stub
		try {
			controlador = new ContPresentaciones(ContPrincipal.this);
		}
		catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
	
	public void ActivarCapacidades() {
		// TODO Auto-generated method stub
		try {
			controlador = new ContCapacidades(ContPrincipal.this);
		}
		catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void ActivarSabores() {
		// TODO Auto-generated method stub
		try {
			controlador = new ContSabores(ContPrincipal.this);
		}
		catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public void ActivarEmpaqueProductos() {
		// TODO Auto-generated method stub
		try {
			controlador = new ContEmpaqueProductos(ContPrincipal.this);
		}
		catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public void ActivarAlmacenes() {
		// TODO Auto-generated method stub
		try {
			controlador = new ContAlmacenes(ContPrincipal.this);
		}
		catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public void ActivarProductoAlmacenes() {
		// TODO Auto-generated method stub
		try {
			controlador = new ContProductoAlmacenes(ContPrincipal.this);
		}
		catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public void ActivarCamiones() {
		// TODO Auto-generated method stub
		try {
			controlador = new ContCamiones(ContPrincipal.this);
		}
		catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void ActivarUsuarios() {
		// TODO Auto-generated method stub
		try {
			controlador = new ContUsuarios(ContPrincipal.this);
		}
		catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public void ActivarZonas() {
		// TODO Auto-generated method stub
		try {
			controlador = new ContZonas(ContPrincipal.this);
		}
		catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void ActivarCalendarios() {
		// TODO Auto-generated method stub
		try {
			controlador = new ContCalendarios(ContPrincipal.this);
		}
		catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void ActivarPedidos(Object object,String value,Object vista) {
		// TODO Auto-generated method stub
		try {
			ContPedidos contPedidos = new ContPedidos(ContPrincipal.this);
			contPedidos.setVista((PedidosUI)vista);
			if (value!=""){
				
				switch (value) {
				case "santaclara.vista.AlmacenesUI":
					contPedidos.setAlmacen((Almacen)object);
					break;
				case "santaclara.vista.ClientesUI":
					contPedidos.setCliente((Cliente)object);
					break;
				case "santaclara.vista.UsuariosUI":
					Usuario vendedor = (Usuario)object;
					contPedidos.setVendedor(vendedor);
					break;
				case "santaclara.vista.EmpaqueProductosUI":
					EmpaqueProducto empaqueProducto = (EmpaqueProducto)object;
					contPedidos.setProducto(empaqueProducto);
					break;

				default:
					break;
				}
				contPedidos.actualizarVista();
			}
			controlador = contPedidos;
		}
		catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void ActivarAtras(Object object){
		// TODO Auto-generated method stub
		if (!cacheObjet.empty())
		{
			Object vista = cacheObjet.pop();
			
			String value = new String((vista).getClass().getName());
			
			vista = cacheObjet.pop();
			
			switch (vista.getClass().getName()) {
			case "santaclara.IniciarSesionUI": cacheObjet.push(
							new IniciarSesionUI(null));
			break;
			case "santaclara.vista.ProductosUI": 		ActivarProductos();
				break;
			case "santaclara.vista.PresentacionesUI": 	ActivarPresentaciones();
			break;
			case "santaclara.vista.VendedoresUI":		ActivarVendedores();
			break;
			case "santaclara.vista.ClientesUI":			ActivarClientes();
			break;
			case "santaclara.vista.RutasUI":				ActivarRutas();
			break;
			case "santaclara.vista.CapacidadesUI":		ActivarCapacidades();
			break;
			case "santaclara.vista.SaboresUI":			ActivarSabores();
			break;
			case "santaclara.vista.EmpaqueProductosUI":	ActivarEmpaqueProductos();
			break;
			case "santaclara.vista.AlmacenesUI":	ActivarAlmacenes();
			break;
			case "santaclara.vista.ProductoAlmacenesUI":	ActivarProductoAlmacenes();
			break;
			case "santaclara.vista.CamionesUI":	ActivarCamiones();
			break;
			case "santaclara.vista.UsuariosUI":	ActivarUsuarios();
			break;
			case "santaclara.vista.ZonasUI":	ActivarZonas();
			break;
			case "santaclara.vista.VisitasUI":	ActivarVisitas();
			break;
			case "santaclara.vista.CalendarioUI":	ActivarCalendarios();
			break;
			case "santaclara.vista.PedidosUI":	ActivarPedidos(object,value,vista);
			break;

			default:
				break;
			}
		}
	}
	
	public Stack<String> getCache() {
		return cache;
	}

	public void setCache(Stack<String> cache) {
		this.cache = cache;
	}

	public Boolean getEditorActivo() {
		return editorActivo;
	}

	public void setEditorActivo(Boolean editorActivo) {
		this.editorActivo = editorActivo;
	}

	public Stack<Object> getCacheObjet() {
		return cacheObjet;
	}

	public void setCacheObjet(Stack<Object> cacheObjet) {
		this.cacheObjet = cacheObjet;
	}

	
}
