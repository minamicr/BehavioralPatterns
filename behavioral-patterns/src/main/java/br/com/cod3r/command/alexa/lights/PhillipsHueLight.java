package br.com.cod3r.command.alexa.lights;

public class PhillipsHueLight implements GenericLights{
	
	public void turnOn() {
		System.out.println("The PhillipsHueLight is On");
	}
	
	public void turnOff() {
		System.out.println("The PhillipsHueLight is Off");
	}
}
