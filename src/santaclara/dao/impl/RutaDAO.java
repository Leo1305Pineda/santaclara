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

import santaclara.dao.IRutaDAO;
import santaclara.modelo.Ruta;
import santaclara.modelo.Zona;

public class RutaDAO extends GenericoDAO implements IRutaDAO  {
	
	public RutaDAO() {
		super();
		// TODO Auto-generated constructor stub
		try {
			activarConexionBaseDato();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Ruta> getRutas() throws Exception {
		// TODO Auto-generated method stub
		List<Ruta> rutas = new ArrayList<Ruta>();
		
		ResultSet rSet = getConexion().getSelect(
				"SELECT r.id,r.nombre,r.idzona,z.descripcion "
				+"FROM rutas r, zonas z WHERE r.idzona=z.id  Order by r.id "); 
		
		if(rSet==null || rSet.getFetchSize()!=0) return null;
		
			while(rSet.next()) rutas.add(
					new Ruta(rSet.getInt(1), rSet.getString(2),
							new Zona(rSet.getInt(3),rSet.getString(4)))); 
		return rutas;
	}
	
	@Override
	public List<Ruta> getRutas(Zona zona ) throws Exception {
		// TODO Auto-generated method stub
		List<Ruta> rutas = new ArrayList<Ruta>();
		
		ResultSet rSet = getConexion().getSelect(
				"SELECT r.id,r.nombre,r.idzona,z.descripcion "
				+"FROM rutas r, zonas z WHERE r.idzona=z.id "
				+" and z.id = '"+zona.getId()+"' "
				+ " Order by r.id "); 
		if(rSet==null)
			return null;
		else
			while(rSet.next()) 
				rutas.add(new Ruta(rSet.getInt(1), rSet.getString(2),
							new Zona(rSet.getInt(3),rSet.getString(4)))); 
		return rutas;
	}
	
	
	
	@Override
	public void guardar(Ruta ruta) throws Exception {
		// TODO Auto-generated method stub
		if (ruta.getId()==null){
			getConexion().ejecutar(
					"INSERT INTO rutas(nombre,idzona) "
					+ "VALUES ("
					+ "'" +ruta.getNombre()       + "', "
					+ " " +ruta.getZona().getId() + ") ;");	
		}
		else{
			getConexion().ejecutar(
					"UPDATE rutas SET  "
					+"nombre   = '"  +ruta.getNombre()      + "',"
					+"idzona   =  "  +ruta.getZona().getId()+ "  "
					+"WHERE id =  "  +ruta.getId()     +";");
		}
	}

	@Override
	public void eliminar(Ruta ruta) throws Exception {
		// TODO Auto-generated method stub
		if(ruta!=null) getConexion().ejecutar(
				"DELETE FROM rutas "
				+"WHERE id = "+ruta.getId() +";");
	}

	@Override
	public Ruta getRuta(Integer id) throws Exception {
		// TODO Auto-generated method stub
		ResultSet rSet = getConexion().getSelect(
				"SELECT r.id,r.nombre,z.id,z.descripcion FROM rutas r, zonas z "
				+ "WHERE r.id     = " + id 
				+ "AND   r.idzona = z.id ;"); 

		if(rSet == null || rSet.getFetchSize()!=0) return null;

		rSet.next();
		return new Ruta(rSet.getInt(1), rSet.getString(2),new Zona(rSet.getInt(3),rSet.getString(4)));
	}
	
	/**	
	private String ruta = "archivos/rutas.txt";
	
	@Override
	public List<Ruta> getRutas() throws NumberFormatException, Exception {
		// TODO Auto-generated method stub
		List<Ruta> rutas = new ArrayList<Ruta>();
		File file = new File(ruta);
 		Scanner scanner = new Scanner(file);
		ZonaDAO zonaDAO = new ZonaDAO();
 		List<Zona> zonas = zonaDAO.getZonas();
 		while(scanner.hasNext())
		{
			Ruta ruta = new Ruta();
			ruta.setId(new Integer(scanner.skip("id:").nextLine().toString().trim()));
			//guardo demas los datos de la Zona 
			Integer idZona = new Integer(scanner.skip("zona:").nextLine().trim());
			for(Zona zona : zonas)
			{
				if (zona.getId().equals(idZona))
				{
					ruta.setZona(zona);
				}
			}
			ruta.setNombre(scanner.skip("nombre:").nextLine());
			rutas.add(ruta); 
		}
		scanner.close();
		return rutas;
	}

	@Override
	public Ruta getRuta(Integer id) throws FileNotFoundException {
		// TODO Auto-generated method stub
		List<Ruta> rutas= getRutas();
		
		for(Ruta ruta: rutas)
		{	
			if(ruta.getId().equals(id))
			{
				return ruta;
			}
		}
		return null;
	}

	@Override
	public void guardar(Ruta ruta) throws IOException {
		// TODO Auto-generated method stub
		List<Ruta> rutas = getRutas();
		//buscar codigo el ultimo codigo Asignado 
		if(ruta.getId() == null )
		{
			int i = 0;
			for(Ruta ruta1 : rutas)
			{
				if(ruta1.getId()> i )
				{
					i = ruta1.getId();
				}
			}
			ruta.setId(i+1);
			rutas.add(ruta);
		}
		else
		{
			for(Ruta ruta1 :rutas)
			{
				if(ruta1.getId().equals(ruta.getId()))
				{ 
					ruta1.setNombre(ruta.getNombre());
					ruta1.setZona(ruta.getZona());
				}
			}
		}
		guardarTodo(rutas);
	}

	@Override
	public void eliminar(Ruta ruta) throws IOException {
		// TODO Auto-generated method stub
		List<Ruta> rutas = getRutas();
		for(Ruta ruta1 :rutas)
		{
			if(ruta1.getId().equals(ruta.getId()))
			{
				rutas.remove(ruta1);
				break;
			}
		}
		guardarTodo(rutas);
	}
	public void guardarTodo(List<Ruta> rutas) throws IOException
	{
		FileWriter fw = new FileWriter(ruta);
		for(Ruta ruta1 :rutas)
		{
			fw.append("id:"+ruta1.getId().toString()+"\n");
			fw.append("zona:"+(ruta1.getZona() == null 
					? " ": ruta1.getZona().getId().toString())+"\n");
			fw.append("nombre:"+ruta1.getNombre().toString()+"\n");
			
		}
		fw.close();
	}

	@Override
	public void Mostrar() throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Listado de Rutas");
		List<Ruta> rutas = getRutas();
		for (Ruta ruta1 : rutas)
		{
			System.out.println("id: "+ruta1.getId());
			System.out.println("zona: "+ruta1.getZona().getId());
			System.out.println("nombre: "+ruta1.getNombre()+"\n");
		}
	}
	
	public Boolean getRuta(Ruta ruta) throws FileNotFoundException {
		// TODO Auto-generated method stub
		List<Ruta> rutas = getRutas();
		for(Ruta ruta1 :rutas)
		{
				if(ruta1.getNombre().equals(ruta.getNombre())&&
						!ruta1.getId().equals(ruta.getId()))
				{ 
					return true;
				}
		}
		return false;
    }

	public List<Ruta> getRutas(Zona zona) throws FileNotFoundException {
		// TODO Auto-generated method stub
		List<Ruta> resultado =   new ArrayList();
		List<Ruta> rutas= getRutas();
		for(Ruta ruta: rutas)
		{	
			if (ruta.getZona().getId().equals(zona.getId())) {
				resultado.add(ruta);
			}
		}
		return resultado;
	}
	
/*Estructura
id:0
zona:1
nombre:El jebe

 * */

}
