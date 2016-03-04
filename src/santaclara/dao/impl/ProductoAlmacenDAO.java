/*Seccion 6
 * Gipsis Marin 19.828.553
 *Leonardo Pineda 19.727.835
 *Rhonal Chirinos 19.827.297
 *Joan Puerta 19.323.522
 *Vilfer Alvarez 18.735.720
 */

package santaclara.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import santaclara.dao.IProductoAlmacenDAO;
import santaclara.dbPostgresql.modelo.PostgreSql;
import santaclara.modelo.ProductoAlmacen;

public class ProductoAlmacenDAO extends GenericoDAO implements IProductoAlmacenDAO {

	@Override
	public List<ProductoAlmacen> getProductoAlmacenes() throws Exception {
		// TODO Auto-generated method stub
		List<ProductoAlmacen> productoAlmaceness = new ArrayList<ProductoAlmacen>();
		
		ResultSet rSet = new PostgreSql().getSelect(
				"SELECT idempaqueproducto, idalmacen, stock, stockmin, existencia FROM productoAlmacenes "); 
		
		if(rSet==null) return null;
		
			while(rSet.next())productoAlmaceness.add(
					new ProductoAlmacen( 
							new EmpaqueProductoDAO().getEmpaqueProducto(rSet.getInt("idempaqueproducto")) ,
							new AlmacenDAO().getAlmacen(rSet.getInt("idalmacen")),
							rSet.getInt("stock"),
							rSet.getInt("stockmin"),
							rSet.getInt("existencia"))); 
		return productoAlmaceness;
	}
	
	@Override
	public void guardar(ProductoAlmacen productoAlmacen) throws Exception {
		// TODO Auto-generated method stub
		
		
		List<ProductoAlmacen> productoAlmacenes = getProductoAlmacenes();
		Boolean enc = false;//true = Modifica , false = Guarda
		for(ProductoAlmacen productoAlmacen1: productoAlmacenes)
		{
			if(productoAlmacen1.getAlmacen().getId().equals(productoAlmacen.getAlmacen().getId())&&
					productoAlmacen1.getEmpaqueProducto().getId().equals(productoAlmacen.getEmpaqueProducto().getId()))
			{
				new PostgreSql().ejecutar(
						"UPDATE productoAlmacenes SET"
						+" stock     		 = " +productoAlmacen.getStock() 					+", "
						+" stockmin			 = " +productoAlmacen.getStockMin() 				+", "
						+" existencia		 = " +productoAlmacen.getExistencia() 				+" "
						+" WHERE "
						+" idempaqueproducto = " +productoAlmacen.getEmpaqueProducto().getId()	+" "
						+" AND "
						+" idalmacen         = " +productoAlmacen.getAlmacen().getId() 			+" "
						+" ;");
						
				enc = true;
				break;
			}
		}
		if(enc == false )new PostgreSql().ejecutar( 
				"INSERT INTO productoAlmacenes(idempaqueproducto, idalmacen, stock, stockmin, existencia) "
				+ "VALUES ("
				+" " +productoAlmacen.getEmpaqueProducto().getId()	+", "
				+" " +productoAlmacen.getAlmacen().getId()			+", "
				+" " +productoAlmacen.getStock()					+", "
				+" " +productoAlmacen.getStockMin()					+", "
				+" " +productoAlmacen.getExistencia()				+"  "
				+");");	

	}

	@Override
	public void eliminar(ProductoAlmacen productoAlmacen) throws Exception {
		// TODO Auto-generated method stub
		if(productoAlmacen!=null) new PostgreSql().ejecutar(
								"DELETE FROM productoAlmacenes "
								+" WHERE "
								+" idempaqueproducto = " +productoAlmacen.getEmpaqueProducto().getId()	+" "
								+" AND "
								+" idalmacen         = " +productoAlmacen.getAlmacen().getId() 			+" "
								+" ;");
	}

	@Override
	public ProductoAlmacen getProductoAlmacen(Integer idProducto,Integer idAlmacen) throws Exception {
		// TODO Auto-generated method stub
		
		ResultSet rSet = new PostgreSql().getSelect(
				"SELECT idempaqueproducto, idalmacen, stock, stockmin, existencia FROM productoAlmacenes "
						+" WHERE "
						+" idempaqueproducto = " +idProducto +" "
						+" AND "
						+" idalmacen         = " +idAlmacen	 +" "
						+" ;");

		if(rSet == null) return null;

		rSet.next();
		return new ProductoAlmacen( 
				new EmpaqueProductoDAO().getEmpaqueProducto(rSet.getInt("idempaqueproducto")) ,
				new AlmacenDAO().getAlmacen(rSet.getInt("idalmacen")),
				rSet.getInt("stock"),
				rSet.getInt("stockmin"),
				rSet.getInt("existencia"));
	}
	
	/*
	 	private String ruta = "archivos/productoAlmacenes.txt";
	@Override
	public List<ProductoAlmacen> getProductoAlmacenes() throws Exception{
		// TODO Auto-generated method stub
		List<ProductoAlmacen> productoAlmacenes = new ArrayList<ProductoAlmacen>();
		File file = new File(ruta);
 		Scanner scanner = new Scanner(file);
		while(scanner.hasNext())
		{			
			 ProductoAlmacen productoAlmacen = new ProductoAlmacen();
			 //asigna Producto
			 EmpaqueProductoDAO productoEmpaqueDAO = new EmpaqueProductoDAO();
			 
			 productoAlmacen.setEmpaqueProducto(
					 productoEmpaqueDAO.getEmpaqueProducto(
							 new Integer(scanner.skip("idEmpaqueProducto:").nextLine().toString().trim())));
			 
			 //asigna Almacen
			 AlmacenDAO almacenDAO = new AlmacenDAO();
			 productoAlmacen.setAlmacen(
					 almacenDAO.getAlmacen(
							 new Integer(scanner.skip("idAlmacen:").nextLine().toString().trim())));
			 
			 productoAlmacen.setStock(new Integer(scanner.skip("stock:").nextLine().toString().trim()));
			 productoAlmacen.setStockMin(new Integer(scanner.skip("stockMin:").nextLine().toString().trim()));
			 productoAlmacen.setExistencia(new Integer(scanner.skip("existencia:").nextLine().toString().trim()));
			 
			 productoAlmacenes.add(productoAlmacen); 
		}
		scanner.close();
		return productoAlmacenes;

	}

	@Override
	public void guardar(ProductoAlmacen productoAlmacen) throws Exception {
		// TODO Auto-generated method stub
		
		List<ProductoAlmacen> productoAlmacenes = getProductoAlmacenes();
		Boolean enc = false;//true = Modifica , false = Guarda
		for(ProductoAlmacen productoAlmacen1: productoAlmacenes)
		{
			if(productoAlmacen1.getAlmacen().getId().equals(productoAlmacen.getAlmacen().getId())&&
					productoAlmacen1.getEmpaqueProducto().getId().equals(productoAlmacen.getEmpaqueProducto().getId()))
			{
				productoAlmacen1.setStock(productoAlmacen.getStock());
				productoAlmacen1.setStockMin(productoAlmacen.getStockMin());
				productoAlmacen1.setExistencia(productoAlmacen.getExistencia());
				enc = true;
				break;
			}
		}
		if(enc == false )productoAlmacenes.add(productoAlmacen);
		
		guardarTodo(productoAlmacenes);

	}

	@Override
	public void eliminar(ProductoAlmacen productoAlmacen) throws Exception {
		// TODO Auto-generated method stub
		List<ProductoAlmacen> productoAlmacenes = getProductoAlmacenes();
		for(ProductoAlmacen productoAlmacen1: productoAlmacenes)
		{
			if(productoAlmacen1.getEmpaqueProducto().getId().equals(productoAlmacen.getEmpaqueProducto().getId())&&
					productoAlmacen1.getAlmacen().getId().equals(productoAlmacen.getAlmacen().getId()))
			{
				productoAlmacenes.remove(productoAlmacen1);
				break;
			}
		}
		guardarTodo( productoAlmacenes);
	}

	public ProductoAlmacenDAO(String ruta) {
		super();
		this.ruta = ruta;
	}

	public ProductoAlmacenDAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ProductoAlmacen getProductoAlmacen(Integer idProducto,Integer idAlmacen) throws Exception{
		// TODO Auto-generated method stub
		List<ProductoAlmacen> productoAlmacenes = getProductoAlmacenes();
		for(ProductoAlmacen productoAlmacen1 : productoAlmacenes)
		{
			if(productoAlmacen1.getAlmacen().getId().equals(idAlmacen) 
					&& productoAlmacen1.getEmpaqueProducto().getId().equals(idProducto))
			{
				return productoAlmacen1;
			}
		}
		return null;
	}
	
	public void guardarTodo(List<ProductoAlmacen> productoAlmacenes ) throws IOException
	{
		FileWriter fw = new FileWriter(ruta);
		for(ProductoAlmacen productoAlmacen :productoAlmacenes)
		{
			fw.append("idEmpaqueProducto:"+(productoAlmacen.getEmpaqueProducto() == null 
					? "  ":productoAlmacen.getEmpaqueProducto().getId().toString())+"\n");
			fw.append("idAlmacen:"+(productoAlmacen.getAlmacen() == null 
					? "  ":productoAlmacen.getAlmacen().getId().toString())+"\n");
			fw.append("stock:"+productoAlmacen.getStock()+"\n");
			fw.append("stockMin:"+productoAlmacen.getStockMin()+"\n");
			fw.append("existencia:"+productoAlmacen.getExistencia()+"\n");
		}
		fw.close();
	}

	 * 
	 * */
	
/*
 * idEmpaqueProducto::0
idAlmacen:0
stock:100000
stockMin:900000
existencia: 70000
*/
}
