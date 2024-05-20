package cursoED.semana07.list;

public class Estudiante implements Comparable<Estudiante> {
	private String codigo;
	private String apellido;
	private String nombre;
	private float promedioPonderado;

	public Estudiante(String codigo, String apellido, String nombre,

			float promedioPonderado) {

		super();
		this.codigo = codigo;
		this.apellido = apellido;
		this.nombre = nombre;
		this.promedioPonderado = promedioPonderado;
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
	public int compareTo(Estudiante o) {
		int result = apellido.compareTo(o.apellido);
		if (result == 0)
			return nombre.compareTo(o.nombre);
		return result;
	}

	@Override
	public String toString() {
		return codigo;
	}
}
