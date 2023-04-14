package ar.com.xyz.orbits.two;

/**
 * En este enum estan algunos datos de los planetas pero con respecto a la tierra.
 * 
 * @author alfredo
 *
 */
public enum PlanetasEarthEnum {

	SOL(0, 0, 695000f, 1.989e+30),
	MERCURIO(46.001009f, 57910, 2439.7f, 3.303e+23),
	VENUS(107.476170f, 108200, 6051.8f, 4.869e+24),
	TIERRA(147.098291f, 149600, 6378.14f, 5.976e+24),
	
	
//	MARTE(206.645215f, 227940, 3397.2f, 6.421e+23),
//	JUPITER(740.679835f, 778330, 71492f, 1.9e+27),
//	SATURNO(1349.823615f, 1429400, 60268f, 5.688e+26),
//	URANO(2734.998229f, 2870990, 25559f, 8.686e+25),
//	NEPTUNO(4459.753056f, 4504300, 24746f, 1.024e+26),
//	PLUTON(4436.756954f, 5913520, 1160f, 1.29e+22),
	;
	
	/**
	 * Necesito la velocidad ... con el semieje mayor y el período creo que la puedo obtener ...
	 * 
	 */
	
	
	
	PlanetasEarthEnum(float velocidadPerihelio, float semiejeMayor, float radio, double masa) {
		this.velocidadPerihelio = velocidadPerihelio;
		this.semiejeMayor = semiejeMayor;
		this.radio = radio;
		this.masa = masa;
	}
	
	/**
	 * Perihelio es la distancia mas corta y afelio (semieje mayor) la mas larga
	 */
	private float velocidadPerihelio ;
	private float semiejeMayor /* perihelio */;
	private float radio ;
	private double masa ;

	
	public float getVelocidadPerihelio() {
		return velocidadPerihelio;
	}
	public float getVelocidadPerihelioEnUnidadesTerrestres() {
		return velocidadPerihelio /* /TIERRA.getVelocidadPerihelio() */;
	}
	
	public float getSemiejeMayorEnUnidadesTerrestres() {
		return semiejeMayor /TIERRA.getSemiejeMayor() ;
	}
	
	public float getSemiejeMayor() {
		return semiejeMayor;
	}
	
	public float getRadio() {
		return radio;
	}
	public double getMasa() {
		return masa;
	}
	
	public float getMasaEnUnidadesTerrestres() {
		return (float) (masa /TIERRA.getMasa() );
	}
	
}
