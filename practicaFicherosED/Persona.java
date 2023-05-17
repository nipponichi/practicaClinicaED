package practicaFicherosED;

public class Persona {
	
	/**
	 * Declaración de constante para definir Sexo H como predefinido
	 */
	private final static char SEXO_DEF = 'H';
	
	/**
	 * Declaración de constante para definir el valor de IMC del objeto Persona
	 */
	public static final int INFRAPESO = -1, PESO_IDEAL = 0, 
			 SOBREPESO = 1;
	
	/**
	 * Declaración de variables protected para permitir acceso desde
	 * clase heredera Paciente.
	 * Todos los atributos tienen valor por defecto excepto el DNI
	 */
	 protected String nombre;
	 protected int edad;
	 protected String dni;
	 protected String sexo;
	 protected double peso;
	 protected double altura;
	 protected String localidad;

	 /**
	  * Constructor Persona por defecto.
	  */
	 public Persona() {
	 }
	 
	 /**
	  * Constructor Persona con todos los atributos como parámetro.
	  * @param nombre
	  * @param edad
	  * @param sexo
	  * @param peso
	  * @param altura
	  * @param dni
	  * @param localidad
	  */
	 public Persona(String nombre, int edad, String sexo, double peso,
			 double altura, String dni) {
		 this.nombre = nombre;
		 this.edad = edad;
		 this.peso = peso;
		 this.altura = altura;
		 this.sexo = sexo;
		 this.dni = dni;
	 }
	 
	 /**
	  * Método de comprobacion de Sexo, otorga sexo H por defecto
	  * si el caracter introducido es diferente de 'H' o 'M'
	  */
	 protected void comprobarSexo(char sexo) {
		 if (sexo != 'H' && sexo != 'M') {
				sexo = SEXO_DEF;
			}
	 }
	 
	 /**
	  * //Método SET para atributo nombre.
	  * @param nombre
	  */
	 public void setNombre(String nombre) {
		 this.nombre = nombre;
	}
	 
	 /**
	  * //Método SET para atributo edad.
	  * @param edad
	  */
	 public void setEdad(int edad) {
		 this.edad = edad;
	}

	 /**
	  * //Método SET para atributo sexo.
	  * @param sexo
	  */
	 public void setSexo(String sexo) {
		 this.sexo = sexo;
	}

	 /**
	  * //Método SET para atributo peso.
	  * @param peso
	  */
	 public void setPeso(double peso) {
		 this.peso = peso;
	}

	 /**
	  * //Método SET para atributo altura.
	  * @param altura
	  */
	 public void setAltura(double altura) {
		 this.altura = altura;
	}
	 
	public String getDni() {
		return dni;
	}
	
	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public int getEdad() {
		return edad;
	}

	public String getSexo() {
		return sexo;
	}

	public double getPeso() {
		return peso;
	}

	public double getAltura() {
		return altura;
	}
	
	/**
	  * Método de cálculo  de IMC
	  * @return Resultado IMC
	  */
	//Contemplar Static para no pasar objeto persona, solo necesitamos peso y altura
	 public int calcularIMC() {
		 //Calculamos el peso de la persona
		 double pesoActual = peso / (Math.pow(altura, 2));
		 //Segun el peso, devuelve un codigo
		 if (pesoActual >= 20 && pesoActual <= 25) {
			 return PESO_IDEAL;
			 	}
		 		else if (pesoActual < 20) {
		 			return INFRAPESO;
		 		} 
		 		else {
		 			return SOBREPESO;
		 		}
	 }
	 
	 /**
	  * Método booleano de reconocimiento de mayor o menor de edad.
	  * @return true si la persona tiene 18 años o mas.
	  */
	 public boolean esMayorDeEdad() {
		 return (this.edad >= 18);
	 }//esMayorDeEdad
	 
	 /**
	  * 
	  * @param sexo
	  * @return
	  */
	 public String determinarSexo(String sexo) {
			if (sexo.equals("H")) {
				return "Hombre";
			} else {
				return "Mujer";
			}
	}
	 
	 /**
	  * Método para representar los parámetros de los atributos del objeto Persona.
	  * sin este método obtendriamos el nombre del objeto y su dirección en memoria.
	  */
	 public String toString() {
		 //Convertimos el caracter de sexo 'H' o 'M'
		 //en String Hombre o Mujer
		 String sexo = "";

		 return "Informacion de la persona:\n"
		 + "Nombre: " + nombre + "\n"
		 + "Sexo: " + sexo + "\n"
		 + "Edad: " + edad + "\n"  
		 + "DNI: " + dni + "\n"
		 + "Peso: " + peso + " kg\n"
		 + "Altura: " + altura + " metros\n";
	 }//toString
}
