package proyectoFinal;

public abstract class Automivil {
	
	public String  modelo, motor, transmision;
	
	
	public Automivil( String modelo, String motor, String transmision){
		
		
		this.modelo=modelo;
		this.motor=motor;
		this.transmision=transmision;
		
		}

	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}


	public String getMotor() {
		return motor;
	}


	public void setMotor(String motor) {
		this.motor = motor;
	}


	public String getTransmision() {
		return transmision;
	}


	public void setTransmision(String transmision) {
		this.transmision = transmision;
	}
	
	

	
	
	
	

}
