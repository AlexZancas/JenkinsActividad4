
public class Trabajador {
	
	private String nombre;
	private String posicion;
	private double horaIngreso;
	
	
	
	public Trabajador(String nombre, String posicion, double horaIngreso) {
		super();
		this.nombre = nombre;
		this.posicion = posicion;
		this.horaIngreso = horaIngreso;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPosicion() {
		return posicion;
	}
	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	public double getHoraIngreso() {
		return horaIngreso;
	}
	public void setHoraIngreso(double horaIngreso) {
		this.horaIngreso = horaIngreso;
	}
	
	
	
}
