package main;

public class CalcM1M2 {

	private static final double af = 0.5 * Math.PI;
	private static final double at = 0.5 * Math.PI;
	private static final double alpha = 0.1;
	
	private static final double h = 0.1;
	private static final double w = 1.0;

	private static final double a = sin(af);
	private static final double b = cos(at) * cos(af);
	private static final double c = sin(at) * cos(af);

	private static final double dt = 0.001;
	
	public double m1 = 0;
	public double m2 = 0;
	private double  t = 0;

	
	public void iteration() {
		double[] k1 = dm(m1, m2, t);
		double[] k2 = dm(m1 + k1[0] * dt/2, m2 + k1[1] * dt/2, t + dt/2);
		double[] k3 = dm(m1 + k2[0] * dt/2, m2 + k2[1] * dt/2, t + dt/2);
		double[] k4 = dm(m1 + k3[0] * dt, m2 + k3[1] * dt, t + dt);	
		
		m1 += dt/6 * (k1[0] + 2 * k2[0] + 2 * k3[0] + k4[0]);
		m2 += dt/6 * (k1[1] + 2 * k2[1] + 2 * k3[1] + k4[1]);
		t += dt;
	}
	
	private double[] dm(double m1, double m2, double t) {
		double dm1 = 1 / (1 + alpha * alpha) *
				(h * (b + alpha * a) * sin (w * t) - 
						(1 + h * c * sin(w * t)) * (m2 + alpha * m1));
		
		double dm2 = 1 / (1 + alpha * alpha) *
				(- h * (a - alpha * b) * sin (w * t) +
						(1 + h * c * sin(w * t)) * (m1 - alpha * m2));
		double[] result = {dm1, dm2};
		return result;
	}

	
	
	
	
	
	private static double sin(double a) {
		return Math.sin(a);
	}
	
	private static double cos(double a) {
		return Math.cos(a);
	}
	
}
