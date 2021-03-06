/*Seccion 6
 * Gipsis Marin 19.828.553
 *Leonardo Pineda 19.727.835
 *Rhonal Chirinos 19.827.297
 *Joan Puerta 19.323.522
 *Vilfer Alvarez 18.735.720
 */

package santaclara.modelo;

public class Ruta {
	
	private Integer id;
	private Zona zona;
	private String nombre;

	public Ruta() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Ruta(Integer id, String nombre,Zona zona) {
		super();
		this.id = id;
		this.zona = zona;
		this.nombre = nombre;
	}
	public Ruta(Integer id ) {
		super();
		this.id = id; 
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Zona getZona() {
		return zona;
	}
	
	public String getZonaStr() {
		return this.zona.getDescripcion();
	}
	
	public void setZona(Zona zona) {
		this.zona = zona;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
