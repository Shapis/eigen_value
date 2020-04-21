
public class Particle {


private double xX;
private double eX;
private double vX;
private double mass;
	
	public double getMass() {
	return mass;
}
public void setMass(double mass) {
	this.mass = mass;
}
	public double getxX() {
		return xX;
	}
	public void setxX(double xX) {
		this.xX = xX;
	}
	public double geteX() {
		return eX;
	}
	public void seteX(double eX) {
		this.eX = eX;
	}
	public double getvX() {
		return vX;
	}
	public void setvX(double vX) {
		this.vX = vX;

}
	
	public  Particle(double xX, double eX, double vX, double mass ){

		this.xX = xX;
		this.eX = eX;
		this.vX = vX;
		this.mass = mass;

	}


}