package br.com.cod3r.command.alexa.commands;

import br.com.cod3r.command.alexa.lights.GenericLights;

public class TurnLightOnCommand implements Command{
  private GenericLights light;

  public TurnLightOnCommand(GenericLights light){
    this.light = light;
  }

  @Override
  public void execute() {
    light.turnOn();
  }
}
