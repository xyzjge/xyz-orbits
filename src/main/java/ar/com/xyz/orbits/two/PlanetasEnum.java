package ar.com.xyz.orbits.two;

public enum PlanetasEnum {

	MERCURIO(57910, 2439.7f, 3.303e+23),
	VENUS(108200, 6051.8f, 4.869e+24),
	TIERRA(149600, 6378.14f, 5.976e+24),
	MARTE(227940, 3397.2f, 6.421e+23),
	JUPITER(778330, 71492f, 1.9e+27),
	SATURNO(1429400, 60268f, 5.688e+26),
	URANO(2870990, 25559f, 8.686e+25),
	NEPTUNO(4504300, 24746f, 1.024e+26),
	PLUTON(5913520, 1160f, 1.29e+22),
	;
	
	PlanetasEnum(long distancia, float radio, double masa) {
		this.distancia = distancia;
		this.radio = radio;
		this.masa = masa;
	}
	
	private long distancia ;
	private float radio ;
	private double masa ;

	public long getDistancia() {
		return distancia;
	}
	public float getRadio() {
		return radio;
	}
	public double getMasa() {
		return masa;
	}
	
}
