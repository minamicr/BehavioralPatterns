package br.com.cod3r.command.alexa.lights;

public class XiaomiLight implements GenericLights {
	
	public void turnOn() {
		System.out.println("The XiaomiLight is On");
	}
	
	public void turnOff() {
		System.out.println("The XiaomiLight is Off");
	}
}
