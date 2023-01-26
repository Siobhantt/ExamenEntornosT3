package fraccion;

/**
 * Clase que define una fracción
 * @author lcardozo
 *
 */
public class Fraccion {
	/**
	 * Atributo Numerador
	 */
	private int num;

	/**
	 * Atributo Denominador
	 */
	private int den;

	/**
	 * Constructor por defecto que debe generar un valor neutro que es 0/1
	 */

	public Fraccion() { 
		num = 0;
		den = 1;
	}

	/**
	 * Constructor con parámetros
	 * @param numerador de la fraccion
	 * @param denominador de la fraccion
	 *@return Devuelve la fraccion simplificada
	 */
	public Fraccion(int num, int den) {
		// debo evitar crear fracciones con 0 en el divisor
		this.num = num;
		if (den == 0)
			this.den = 1;
		else
			this.den = den;
		// devuelvo la fracci�n simplificada
		simplificar();
	}

	/**
	 *  Constructor copia
	 * @param f
	 */
	public Fraccion(final Fraccion f) {
		num = f.num;
		den = f.den;
	}

	// getters y setters
/**
 * Establece el numero
 * @param num
 */
	public void setNum(int num) {
		this.num = num;

	}
/**
 * Devuelve el numero
 * @return
 */
	public int getNum() {
		return num;

	}
/**
 * Establece el denominador
 * @param den
 */
	public void setDen(int den) {
		this.den = den;
	}
/**
 * Devuleve el denominador
 * @return
 */
	public int getDen() {
		return den;
	}

	/**
	 * Cálculo del máximo común divisor por el algoritmo de Euclides
	 * @return Devuelve el valor absoluto del numerador 
	 */
	
	private int mcd() {
		int u = (Math.abs(num)); // valor absoluto del numerador
		int v = (Math.abs(den)); // valor absoluto del denominador
		if (v == 0) {
			return u;
		}
		int r;
		while (v != 0) {
			r = u % v;
			u = v;
			v = r;
		}
		return u;
	}
/**
 * Metodo para simplicar fracciones
 */
	
	public void simplificar() {
		int n = mcd();
		num = num / n;
		den = den / n;
	}

	/**
	 * Metodo que devuelve el mensaje
	 */

	public String toString() {
		String mensaje = num + "/" + den;
		return mensaje;

	}

	/**
	 * Suma las fracciones 
	 * @param f La fraccion
	 * @return la suma de la fraccion
	 */
	public Fraccion sumar(Fraccion f) {
		Fraccion aux = new Fraccion();
		aux.num = num * f.den + den * f.num;
		aux.den = den * f.den;
		aux.simplificar();
		return aux;

	}

	
/**
 * Resta las fracciones
 * @param f recibe la fraccion
 * @return Devuelve el resultado de la resta de la fraccion
 */
	public Fraccion restar(Fraccion f) {
		Fraccion aux = new Fraccion();
		aux.num = num * f.den - den * f.num;
		aux.den = den * f.den;
		aux.simplificar();
		return aux;

	}

//Multiplicar fracciones
/**
 * Multiplica la fraccion
 * @param f recibe la fraccion
 * @return devuelve la multiplicacion de la fraccion
 */
	public Fraccion multiplicar(Fraccion f) {
		Fraccion aux = new Fraccion();
		aux.num = num * f.num;
		aux.den = den * f.den;
		aux.simplificar();
		return aux;

	}

//Dividir fracciones
/** 
 * Divide la fracciom
 * @param f recibe la fraccion
 * @return devuelve la division de la fraccion
 */
	public Fraccion dividir(Fraccion f) {
		Fraccion aux = new Fraccion();
		aux.num = num * f.den;
		aux.den = den * f.num;
		aux.simplificar();
		return aux;

	}

}
