/*Seccion 6
 * Gipsis Marin 19.828.553
 *Leonardo Pineda 19.727.835
 *Rhonal Chirinos 19.827.297
 *Joan Puerta 19.323.522
 *Vilfer Alvarez 18.735.720
 */

package santaclara.Servicio;

import java.util.ArrayList;
import java.util.List;

import santaclara.modelo.Concesionario;
import santaclara.modelo.JefeVenta;
import santaclara.modelo.Usuario;
import santaclara.modelo.Vendedor;
import santaclara.dao.impl.ConcesionarioDAO;
import santaclara.dao.impl.JefeVentaDAO;
import santaclara.dao.impl.UsuarioDAO;
import santaclara.dao.impl.VendedorDAO;

public class ServicioUsuario {
	
	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	private VendedorDAO vendedorDAO = new VendedorDAO();
	private JefeVentaDAO jefeVentaDAO = new JefeVentaDAO();
	private ConcesionarioDAO concesionarioDAO = new ConcesionarioDAO();
	
	private List<Usuario> usuarios = new ArrayList<Usuario>();
		
	public List<Usuario> getUsuarios() throws Exception{
		// TODO Auto-generated method stub
		
		return usuarioDAO.getUsuarios();
	}

	public List<JefeVenta> getJefeVentas() throws Exception{
		// TODO Auto-generated method stub
		
		return jefeVentaDAO.getJefeVentas();
	}
	
	public List<Vendedor> getVendedores() throws Exception{
		// TODO Auto-generated method stub
		
		return vendedorDAO.getVendedores();
	}
	
	public List<Concesionario> getConcesionarios() throws Exception{
		// TODO Auto-generated method stub
		
		return concesionarioDAO.getConcecionarios();
	}
	
	public UsuarioDAO getUsuarioDAO() {
		 
		return usuarioDAO;
	}

	public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
		this.usuarioDAO = usuarioDAO;
	}

 
	public Usuario buscar(String username) throws Exception {
		// TODO Auto-generated method stub
		return usuarioDAO.getUsuario(username);
	}

	public Usuario buscarCedula(String cedula) throws Exception {
		// TODO Auto-generated method stub
		return usuarioDAO.getUsuarioCedula(cedula);
	}
	
	
	public void guardar(Usuario usuario) throws Exception {
		// TODO Auto-generated method stub
		
		usuarios = usuarioDAO.getUsuarios();
		
		for(Usuario Usuario1 :usuarios)
		{
			if(Usuario1.getCedula().equals(usuario.getCedula())&&
					Usuario1.getUsername().equals(usuario.getUsername())&&
					Usuario1.getId().equals(usuario.getId())) 
			{
				if(Usuario1.getNombre().equals(usuario.getNombre())&&
						Usuario1.getContrasena().equals(usuario.getContrasena()))
					throw new Exception ("El Vendedor Existente"); 
				break;//rompe el for para modificar
			}
		}
		
		usuarioDAO.guardar(usuario);
				
		
	}
	
	public Usuario getUsuario(Integer id) throws Exception{
		return usuarioDAO.getUsuario(id);
	}
	
	public void eliminar(Usuario usuario) throws Exception{
		usuarioDAO.eliminar(usuario);
	}
	
}
