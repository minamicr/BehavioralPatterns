package br.com.cod3r.command.alexa.commands;

import br.com.cod3r.command.alexa.lights.GenericLights;

public class TurnLightOffCommand implements Command{
  private GenericLights light;

  public TurnLightOffCommand(GenericLights light){
    this.light = light;
  }

  @Override
  public void execute() {
    light.turnOff();
  }
}
