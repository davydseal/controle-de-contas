package util;

public class Calcular2 {

	private float n1;
	private float n2;
	private float n3;

	
	public float calcula() {
		return (float)getN1() +getN2() +getN3();
	}
	
	
	public float getN1() {
		return n1;
	}
	public void setN1(float n1) {
		this.n1 = n1;
	}
	public float getN2() {
		return n2;
	}
	public void setN2(float n2) {
		this.n2 = n2;
	}
	
	public float getN3() {
		return n3;
	}
	public void setN3(float n3) {
		this.n3 = n3;
	}

}
