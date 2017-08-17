package Diagnostic;


public abstract class Planta extends Empleado {

	protected double pagoSemanal;
	protected boolean[] prestaciones;
	protected double diaVacaciones;
	protected String nombrePuesto;
	
	private static final String [] PRESTACIONES = {"Vales despensa", "Afore", "Infonavit", "Vacaciones Semana Santa", 
				"Vacaciones Verano", "Descuento proveedores afiliados", "Seguro de auto", "Seguro de vida"}; 
	private static final double [] PAGO_PRESTACIONES = {1000, 0.2, 0.1, 7, 2, 0.25, 5000, 25000}; 				 
	private static final double PORCENTAJE_PLANTA = 0.1;			
	private static final int MAXIMO_SUELDO = 25000;
	
	

	public Planta( String nombre, String apellido, int antiguedad, double pagoSemanal, boolean[] prestaciones) {
		super(nombre, apellido, antiguedad);
		/*
		 * TODO: 
		 * Constructor de la clase Planta.
		 * 1. Inicializa el atributo  de instancia del arreglo de prestaciones con los valores
		 *    del arreglo de prestaciones que recibe de parámetro.
		 * 2. Valida que el atributo de instancia, pagoSemanal, se inicialice con un valor entre 0 y MAXIMO_SUELDO.
		 *    En caso contrario, se asigna 0.
		 * 3. El atributo de instancia, diaVacaciones, se inicializa con el pagoSemanal * antiguedad * PORCENTAJE_PLANTA. 
		 */
		this.nombre = new String (nombre);
		this.apellido = new String (apellido);
		this.antiguedad = antiguedad;
		this.prestaciones = prestaciones;

		
		if (pagoSemanal <= MAXIMO_SUELDO && pagoSemanal > 0) {
			this.pagoSemanal=pagoSemanal;
		}else {
			this.pagoSemanal = 0;

		}
		diaVacaciones = this.pagoSemanal*antiguedad*PORCENTAJE_PLANTA;
		
	}
   
   
    private String regresaPrestaciones() {
    	/*
    	 * TODO: 
    	 * Método privado que recorre el arreglo de instancia de prestaciones y si tiene un valor de true en la posición i,
    	 * entonces crea una cadena con el nombre de la prestación correspondiente. Los nombres de las prestaciones están en
    	 * el arreglo estático PRESTACIONES, en la misma posición i. Así, si prestaciones[0] = true, entonces la prestación
    	 * correspondiente es PRESTACIONES[0] (que es “Vales despensa”).
    	 */
    	String presta= new String();
    	for (int i=0;i < prestaciones.length;i++) {
    		if (prestaciones[i]==true) {
    			presta+=PRESTACIONES[i]+", ";
    		}
    	}
    	return presta;
	}
	
	
	public double sueldo() { 
		/*
		 * TODO:
		 * Calcula el sueldo de un empleado de Planta de la siguiente manera:
		 *    El sueldo inicial es el pagoSemanal.
		 * A ese sueldo se le agregan las prestaciones de la siguiente forma:
		 *    Si el arreglo de instancia de prestaciones tiene un valor de true en la posición i, donde i es:
		 *       0, 6, 7: sumarle al sueldo el PAGO_PRESTACIONES de la misma posición i
		 *       1, 2, 5: sumarle al sueldo el PAGO_PRESTACIONES de la misma posición i multiplicado por el pagoSemanal
		 *       3, 4: sumarle al sueldo el PAGO_PRESTACIONES de la misma posición i multiplicado por diaVacaciones
		 */
		double sueldo= pagoSemanal; 
		for (int i=0;i < prestaciones.length;i++) {
    		if (prestaciones[i]==true ) {
    			if (i==0 || i==6 || i==7) {
    				sueldo+=PAGO_PRESTACIONES[i];
    			}else if (i==1 || i==2 || i==5) {
    				sueldo+=(PAGO_PRESTACIONES[i]*pagoSemanal);
    			}else if (i==4 || i==3 ) {
    				sueldo+=(PAGO_PRESTACIONES[i]*diaVacaciones);
    			}
    		}
		}
		return sueldo;
	}
	
    public void setPagoSemanal( double pagoSemanal ) { 
		if (pagoSemanal > 0 && pagoSemanal <= MAXIMO_SUELDO)
			this.pagoSemanal = pagoSemanal;
	}
   
   	public String toString() {
		return "\n***  Empleado de Planta  ***\n" + super.toString() + "\nCon puesto: " + this.getNombrePuesto() +
				"\nPago semanal: " + this.pagoSemanal + "\nSueldo integrado: " + this.sueldo() + "\nPrestaciones: " + this.regresaPrestaciones();
	}
	
	public String getNombrePuesto() {
		return this.nombrePuesto;
	}
	
	public abstract void setNombrePuesto(String nombrePuesto);
	/*
	 * TODO:
	 * Crear método público abstracto de nombre setNombrePuesto.
	 * El método no regresa nada.
	 * El método recibe una cadena de caracteres con el nombre del puesto (nombrePuesto).
	 */
}