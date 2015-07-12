import lejos.nxt.Motor;


public class MyMotor {
	
	public void forward(){
		Motor.A.forward();
		Motor.A.setAcceleration(5);
		Motor.B.forward();
		Motor.B.setAcceleration(5);
		Motor.A.setSpeed(300);
		Motor.B.setSpeed(300);
		System.out.println("sdafjsldakfjslkaj");
	}
	public void backward(){
		Motor.A.backward();
		Motor.A.setAcceleration(5);
		Motor.B.backward();
		Motor.B.setAcceleration(5);
		Motor.A.setSpeed(300);
		Motor.B.setSpeed(300);
		System.out.println("sdafjsldakfjslkaj");
	}
	public void left(){
		Motor.A.forward();
		Motor.A.setAcceleration(5);
		Motor.B.forward();
		Motor.B.setAcceleration(5);
		Motor.A.setSpeed(500);
		Motor.B.setSpeed(300);
		System.out.println("sdafjsldakfjslkaj");
	}
	public void right(){
		Motor.A.forward();
		Motor.A.setAcceleration(5);
		Motor.B.forward();
		Motor.B.setAcceleration(5);
		Motor.B.setSpeed(500);
		Motor.A.setSpeed(300);
		System.out.println("sdafjsldakfjslkaj");
	}
	public void stop(){
		Motor.A.flt();
		Motor.B.flt();
	}
}
