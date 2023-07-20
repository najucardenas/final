package proyectoFinal;

public class Automoviles extends Automivil{
	

	private double precio;
	private String marca;
	private String version, numeroSerie,imagen;
    
	public Automoviles(String modelo, String motor, String transmision, double precio, String marca, String version, String numeroSerie,String imagen) {
		super(modelo, motor, transmision);
		this.version=version;
		this.precio=precio;
		this.marca=marca;
		this.numeroSerie=numeroSerie;
		this.imagen=imagen;
		
		// TODO Auto-generated constructor stub
	}
	
	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public double getPrecio() {
		return precio;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
	
	
	
 public String getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

public String getVersion() {
	 
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

@Override
 public String toString() {
	 
return modelo+" "+motor+" "+transmision+" "+getPrecio()+" "+getMarca()+" " +getVersion();
 }
	

}
