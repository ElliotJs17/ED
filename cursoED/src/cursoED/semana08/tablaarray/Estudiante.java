package cursoED.semana08.tablaarray;

public class Estudiante implements WithPriority {
	private String codigo;
	private String apellido;
	private String nombre;
	private float promedioPonderado;
	private int priority;

	public Estudiante(String codigo, String apellido, String nombre, float promedioPonderado, int priority) {

		super();
		this.codigo = codigo; 
		this.apellido = apellido;
		this.nombre = nombre;
		this.promedioPonderado = promedioPonderado; 
		this.priority = priority;
	}

	@Override
	public int getPriority() {
		return priority;
	}
	
	public String getCodigo() {
		return codigo;
	}

	public String getApellido() {
		return apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public float getPromedioPonderado() {
		return promedioPonderado;
	}
	
	@Override
	public String toString() {
		return codigo;
	}
}
