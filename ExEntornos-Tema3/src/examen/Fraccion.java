package examen;
/**
 * Clase que define una fraccion
 * @author lcardozo
 *
 */
public class Fraccion {
	/**
	 * Atributo Numerador
	 */
	private int num;

/**
 * 	 Atributo Denominador
 */
	private int den;
	
/**
 * Debe generar el valor neutro que es 0/1
 * Constructor por defecto
 */
	public Fraccion() { 
		num = 0;
		den = 1;

	}
/**
 * Constructor con parametro
 * @param num Numerador de la fraccion
 * @param Denominador de la fraccion
 */
	
	public Fraccion(int num, int den) {
		// debo evitar crear fracciones con 0 en el divisor
		this.num = num;
		if (den == 0) {
			this.den = 1;
		}else {
			this.den = den;
		// devuelvo la fracci�n simplificada
		simplificar();
		}
	}

	/**
	 *  Constructor copia
	 * @param Fraccion f
	 */
	public Fraccion(final Fraccion fraccion) {
		num = fraccion.num;
		den = fraccion.den;
	}

	// getters y setters

	public void setNum(int num) {
		this.num = num;

	}

	public int getNum() {
		return num;

	}

	public void setDen(int den) {
		this.den = den;
	}

	public int getDen() {
		return den;
	}

	// Cálculo del máximo común divisor por el algoritmo de Euclides
	private int maxComunDivisor() {
		int valorAbsNu = Math.abs(num); // valor absoluto del numerador
		int valorAbsDe = Math.abs(den); // valor absoluto del denominador
		if (valorAbsDe == 0) {
			
		}
		int r;
		while (valorAbsDe != 0) {
			r = valorAbsNu % valorAbsDe;
			valorAbsNu = valorAbsDe;
			valorAbsDe = r;
		}
		return valorAbsNu;
	}

	// método para simplificar fracciones
	public void simplificar() {
		int denominador = maxComunDivisor();
		num = num / denominador;
		den = den / denominador;
	}

	// Método toString

	public String toString() {
		String mensaje = num + "/" + den;
		return mensaje;

	}

	// suma de fracciones
	public Fraccion sumar(Fraccion fraccion) {
		Fraccion aux = new Fraccion();
		int cruce1 = num * fraccion.den;
		int cruce2 = den * fraccion.num;
		aux.num = cruce1 + cruce2;
		aux.den = den * fraccion.den;
		aux.simplificar();
		return aux;

	}

	// Restar fracciones

	public Fraccion restar(Fraccion fraccion) {
		Fraccion aux = new Fraccion();
		int cruce1 = num * fraccion.den;
		int cruce2 = den * fraccion.num;
		aux.num = cruce1 - cruce2;
		aux.den = den * fraccion.den;
		aux.simplificar();
		return aux;

	}

//Multiplicar fracciones

	public Fraccion multiplicar(Fraccion fraccion) {
		Fraccion aux = new Fraccion();
		aux.num = num * fraccion.num;
		aux.den = den * fraccion.den;
		aux.simplificar();
		return aux;

	}

//Dividir fracciones

	public Fraccion dividir(Fraccion fraccion) {
		Fraccion aux = new Fraccion();
		aux.num = num * fraccion.den;
		aux.den = den * fraccion.num;
		aux.simplificar();
		return aux;

	}

}
