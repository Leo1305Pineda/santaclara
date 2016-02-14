package santaclara.controlador;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

public abstract class ContGeneral implements IContGeneral {

	
	private ContPrincipal 	 contPrincipal;
//	  JLabel lblImagen = new JLabel();
		
	public void dibujar(JPanel vista,Object cacheobject)
	{
		contPrincipal.agregarPanel(vista);
		if(!this.contPrincipal.getCacheObjet().empty())
		{
			Object object = this.contPrincipal.getCacheObjet().pop();
			if (object.equals(cacheobject))
			{
				this.contPrincipal.getCacheObjet().push(object);
			}
			else
			{
				this.contPrincipal.getCacheObjet().push(object);
				this.contPrincipal.getCacheObjet().push(cacheobject);
			}
		}
		else 
			this.contPrincipal.getCacheObjet().push(cacheobject);
	}
	
	public void quitarVista(){//btnSalir
		contPrincipal.quitarPanel();
		if (!this.contPrincipal.getCacheObjet().empty())
		{
			while(this.contPrincipal.getCacheObjet().size()>1)
			{
				this.contPrincipal.getCacheObjet().pop();
			}
		}
	}
	 
	
	
	
	public void ActivarAtras(Object object) {//btnAtras
		
		if(this.contPrincipal.getCacheObjet().size()>1)
			this.contPrincipal.ActivarAtras(object);
		else
			quitarVista();
	}


	public ContPrincipal getContPrincipal() {
		return contPrincipal;
	}

	public void setContPrincipal(ContPrincipal contPrincipal) {
		this.contPrincipal = contPrincipal;
	}	
	
	public Stack<String> getCache() {
		return this.contPrincipal.getCache();
	}

	public void setCache(Stack<String> cache) {
		this.contPrincipal.setCache(cache);
		
	}
	
	public Stack<Object> getCacheObjet() {
		return this.contPrincipal.getCacheObjet();
	}

	public void setCacheObjet(Stack<Object> cacheObject) {
		this.contPrincipal.setCacheObjet(cacheObject);
		
	}

	public List<Icon> getImagenes(String ruta) throws FileNotFoundException {
		// TODO Auto-generated method stub
		List<Icon> iconos = new ArrayList<Icon>();
		File file = new File(ruta.concat("conf.txt"));
 		Scanner scanner = new Scanner(file);
		while(scanner.hasNext())
		{
			iconos.add(new ImageIcon(ruta.concat(scanner.skip("imagen:").nextLine().toString().trim())));
		}
		scanner.close();
		return iconos;
	}
	
	public void runAnimacion(JLabel lblImagen,String folder,Integer tiempo){
		List<Icon> imagenes = new ArrayList<Icon>();
		try {
			imagenes = getImagenes("img/animados/".concat(folder).concat("/"));
	
				//System.out.println(imagenes.size());
				for(Icon icon : imagenes){
					Thread.sleep(tiempo);
					lblImagen.setIcon(icon);	
				}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public JTable buscar(JTable tabla1,String valueBuscar){
		tabla1.clearSelection();
		for(int i = 0;i<tabla1.getRowCount();i++)
		{
			
			for(int j = 0; j<=tabla1.getColumnCount()-1; j++) 
			{
				if (tabla1.getValueAt(i, j).toString().trim().equals(valueBuscar))
				{
					tabla1.setRowSelectionInterval(i,i);
					return tabla1;			
				}
			}
		}
		return tabla1;			
	}
	
}
