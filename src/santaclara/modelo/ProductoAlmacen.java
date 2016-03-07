/*Seccion 6
 * Gipsis Marin 19.828.553
 *Leonardo Pineda 19.727.835
 *Rhonal Chirinos 19.827.297
 *Joan Puerta 19.323.522
 *Vilfer Alvarez 18.735.720
 */

package santaclara.modelo;

public class ProductoAlmacen {
	private EmpaqueProducto empaqueProducto;
	private Almacen almacen;
	private Integer stock;
	private Integer stockMin;
	private Integer existencia;
	
	public ProductoAlmacen(EmpaqueProducto empaqueProducto, Almacen almacen,
			Integer stock, Integer stockMin, Integer existencia) {
		super();
		this.empaqueProducto = empaqueProducto;
		this.almacen = almacen;
		this.stock = stock;
		this.stockMin = stockMin;
		this.existencia = existencia;
	}

	
	public EmpaqueProducto getEmpaqueProducto() {
		return empaqueProducto;
	}


	public void setEmpaqueProducto(EmpaqueProducto empaqueProducto) {
		this.empaqueProducto = empaqueProducto;
	}


	public Almacen getAlmacen() {
		return almacen;
	}
	
	public String getUbicacion() {
		return almacen.getUbicacion();
	}

	public String getIdAlmacen() {
		return almacen.getId().toString();
	}

	public void setAlmacen(Almacen almacen) {
		this.almacen = almacen;
	}


	public Integer getStock() {
		return stock;
	}


	public void setStock(Integer stock) {
		this.stock = stock;
	}


	public Integer getStockMin() {
		return stockMin;
	}


	public void setStockMin(Integer stockMin) {
		this.stockMin = stockMin;
	}


	public Integer getExistencia() {
		return existencia;
	}


	public void setExistencia(Integer existencia) {
		this.existencia = existencia;
	}


	public ProductoAlmacen() {
		// TODO Auto-generated constructor stub
	}
	
	public String getIdAlmacenStr() {
		return	almacen.getId().toString();
	}
	
	public String getUbicacionAlmacenStr() {
		return	almacen.getId().toString();
	}
	
	public String getIdEmpaqueProductoStr() {
		return	empaqueProducto.getId().toString();
	}
	
	public String getPresentacionStr() {
		return	empaqueProducto.getProducto().getPresentacion().getMaterial();
	}
	
	public String getCapacidadStr() {
		return	empaqueProducto.getProducto().getCapacidad().getVolumen().toString();
	}
	
	public String getSaborStr() {
		return	empaqueProducto.getProducto().getSabor().getSabor();
	}
	
	public String getProductoStr() {
		return	empaqueProducto.getProducto().getNombre();
	}
}
