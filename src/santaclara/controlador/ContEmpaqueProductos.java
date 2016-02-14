package santaclara.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

import org.jdesktop.beansbinding.AutoBinding;
import org.jdesktop.beansbinding.BeanProperty;
import org.jdesktop.swingbinding.JComboBoxBinding;
import org.jdesktop.swingbinding.JTableBinding;
import org.jdesktop.swingbinding.SwingBindings;

import santaclara.Servicio.ServicioEmpaqueProducto;
import santaclara.Servicio.ServicioProducto;
import santaclara.modelo.EmpaqueProducto;
import santaclara.modelo.Producto;
import santaclara.vista.EmpaqueProductosUI;

public class ContEmpaqueProductos extends ContGeneral implements IContGeneral {

	private EmpaqueProductosUI vista;
	private ServicioEmpaqueProducto servicioEmpaqueProducto = new ServicioEmpaqueProducto();;
	private ContPrincipal contPrincipal;
	
	private List<EmpaqueProducto> empaqueProductos = new ServicioEmpaqueProducto().getEmpaqueProductos();
	private EmpaqueProducto empaqueProducto;
	private List<Producto> 		productos = new ServicioProducto().getProductos();

	
	public ContEmpaqueProductos(ContPrincipal contPrincipal) throws Exception {
		// TODO Auto-generated constructor stub
		this.contPrincipal = contPrincipal;
		setContPrincipal(contPrincipal);
		vista = new EmpaqueProductosUI(this);		
		dibujar(vista,this);
		
		activarBinding(servicioEmpaqueProducto.getEmpaqueProductos());
		cargarCmbProducto();
		
		//vista.quitarNuevo();
	}

	@Override
	public JPanel getVista() {
		// TODO Auto-generated method stub
		return vista;
	}

  // evento Guardar Prodcuto 
	public ActionListener guardar() {
		// TODO Auto-generated method stub
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// se va hacer las validaciones del controlador 

				empaqueProducto = new EmpaqueProducto();
				String msg="";
				
				if (vista.getTxtId().getText().equals("")) empaqueProducto.setId(null);
					else empaqueProducto.setId(new Integer(vista.getTxtId().getText().toString()));
				
				if(vista.getTxtCantidad().getValue().equals(0))empaqueProducto.setCantidad(0);
					else empaqueProducto.setCantidad((Integer) vista.getTxtCantidad().getValue());
				
				empaqueProducto.setProducto((Producto)vista.getCmbProducto().getSelectedItem());
				
				if (msg!="") JOptionPane.showMessageDialog(vista,"Campos Vacios: "+msg);
					else
						{
							try {
									JOptionPane.showMessageDialog(vista,servicioEmpaqueProducto.guardar(empaqueProducto));
									// agregarlo a la lista
									empaqueProductos.add(empaqueProducto);
									activarBinding(servicioEmpaqueProducto.getEmpaqueProductos());
									vista.quitarNuevo();
									vista.getScrollPanel().setVisible(true);
									
								} catch (IOException e1) {
								// TODO Auto-generated catch block
								JOptionPane.showConfirmDialog(null,e1.getMessage());
								e1.printStackTrace();
								}
						}
			}
		};
	}
	
	public ActionListener buscar() {
		// TODO Auto-generated method stub
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				vista.setTable(buscar(vista.getTable(),vista.getTxtABuscar().getText().toString().trim()));
				Integer fila = new Integer(vista.getTable().getSelectedRow());
				if(fila>=0)
				{
					cargarEmpaqueProducto(empaqueProductos.get(fila));
				}
				else 
				{
					JOptionPane.showMessageDialog(new JPanel(),"No Encontrado");
					cargarEmpaqueProducto(new EmpaqueProducto());
				}
			}
		};
	}
	
	public ActionListener eliminar() {
		return new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (vista.getTable().getSelectedRow()>=0)
				{
					try {
						servicioEmpaqueProducto.eliminar(empaqueProductos.get(vista.getTable().getSelectedRow()));				
						activarBinding(servicioEmpaqueProducto.getEmpaqueProductos());
						JOptionPane.showMessageDialog(vista,"Operacion Exitosa ");
						vista.quitarNuevo();
		
					} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					}
				}
				else
				{
					JOptionPane.showMessageDialog(vista,"Seleccione el EmpaqueProducto ");
				}
			}
		};
	}


	public ActionListener nuevo() {
		// TODO Auto-generated method stub
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				vista.dibujarPanelEmpaqueProducto();
				vista.getPnTabla().setVisible(false);
			}
		};
	}
	
	public ActionListener salir() {
		// TODO Auto-generated method stub
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				quitarVista();
			}
		};
	}
	
	@SuppressWarnings("rawtypes")
	public void setSelectedValue(JComboBox comboBox,Integer id)
    {	
        for (int i = 0; i < comboBox.getItemCount(); i++)
        {
        	comboBox.setSelectedIndex(i);
        	Boolean enc=false;
        	switch (comboBox.getSelectedItem().getClass().getName().toString()) {
			case "santaclara.modelo.Producto":
				enc = (((Producto)comboBox.getSelectedItem()).getId().equals(id)); 
					break;
			default:
				break;
			}
        	if (enc) break;
        }
    }

	public ActionListener AbrirProducto() {
		// TODO Auto-generated method stub
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
						new ContProductos(contPrincipal);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		};
	}

	public ActionListener Atras() {
		// TODO Auto-generated method stub
		return new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					if (vista.getTable().getSelectedRow()>=0)
					{
						EmpaqueProducto empaqueProducto = new EmpaqueProducto();
						empaqueProducto = new ServicioEmpaqueProducto().buscar(new Integer(vista.getTable().getValueAt(vista.getTable().getSelectedRow(),0).toString()));
						ActivarAtras(empaqueProducto);
					}
					else 	ActivarAtras(null);
				} catch (NumberFormatException | IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		};
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void activarBinding(List<EmpaqueProducto> EmpaqueProductos) {
		// TODO Auto-generated method stub
		vista.remove(vista.getPanelEmpaqueProducto());
		vista.getPnTabla().setVisible(true);
		vista.setTable(new JTable());
		vista.getScrollPanel().setViewportView(vista.getTable());
		
		JTableBinding   binEmpaqueProductos = SwingBindings.createJTableBinding(AutoBinding.UpdateStrategy.READ_WRITE,
    			EmpaqueProductos,vista.getTable());
		BeanProperty idEmpaqueProducto  = BeanProperty.create("id");
	    
		BeanProperty nombreProducto = BeanProperty.create("producto.nombre");
	    BeanProperty presentacionProducto = BeanProperty.create("producto.presentacion.material");
	    BeanProperty capacidadProducto = BeanProperty.create("producto.capacidad.volumen");
	    BeanProperty saborProducto = BeanProperty.create("producto.sabor.sabor");
	    
	    BeanProperty cantidadProducto = BeanProperty.create("unidadesStr");

	    binEmpaqueProductos.addColumnBinding(idEmpaqueProducto).setColumnClass(Integer.class).setColumnName("id Empaque");;
	    
	    binEmpaqueProductos.addColumnBinding(nombreProducto).setColumnClass(String.class).setColumnName("Producto");
	    binEmpaqueProductos.addColumnBinding(presentacionProducto).setColumnClass(String.class).setColumnName("Presentacion");
	    binEmpaqueProductos.addColumnBinding(capacidadProducto).setColumnClass(String.class).setColumnName("Capacidad");
	    binEmpaqueProductos.addColumnBinding(saborProducto).setColumnClass(String.class).setColumnName("Sabor");
	    
	    binEmpaqueProductos.addColumnBinding(cantidadProducto).setColumnClass(String.class).setColumnName("Unidades por Empaque");

	    binEmpaqueProductos.bind();
	    
		vista.getTable().addKeyListener(mostrarEmpaqueProducto_keypress());
		vista.getTable().addMouseListener(mostrarEmpaqueProducto());
	}
	
	@SuppressWarnings("rawtypes")
	public void cargarCmbProducto(){
		 JComboBoxBinding jcomboProductos = SwingBindings.createJComboBoxBinding(AutoBinding.UpdateStrategy.READ,productos,vista.getCmbProducto());
		 jcomboProductos.bind();
	}

	public MouseAdapter mostrarEmpaqueProducto() {
		// TODO Auto-generated method stub
		return new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evento) {
				if (evento.getClickCount()==1) {
					cargarEmpaqueProducto(empaqueProductos.get(vista.getTable().getSelectedRow()));
				}
			}
		};
	}

	public KeyAdapter mostrarEmpaqueProducto_keypress() {
		// TODO Auto-generated method stub
		return new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				Integer fila = new Integer(vista.getTable().getSelectedRow());
				Integer contFila = empaqueProductos.size();
				 
				if(e.getKeyCode()==38 )
				{
					if(fila<=0)cargarEmpaqueProducto(empaqueProductos.get(0));
					else cargarEmpaqueProducto(empaqueProductos.get(fila-1));
				}
				else if(e.getKeyCode()==40 )
				{
					if(fila+1>=contFila)cargarEmpaqueProducto(empaqueProductos.get(contFila-1));
					else cargarEmpaqueProducto(empaqueProductos.get(fila+1));
				}

			}
		};
	}  

	public void cargarEmpaqueProducto(EmpaqueProducto empaqueProducto) {
		// TODO Auto-generated method stub
		vista.remove(vista.getPanelEmpaqueProducto());
		vista.dibujarPanelEmpaqueProducto();
		cargarCmbProducto();
		if (vista.getTable().getSelectedRow() >= 0)
		{
			cargarCmbProducto();
 			vista.getTxtCantidad().setValue(empaqueProducto.getCantidad());
			setSelectedValue(vista.getCmbProducto(), empaqueProducto.getProducto().getId());
		}
		
	}
	
}

