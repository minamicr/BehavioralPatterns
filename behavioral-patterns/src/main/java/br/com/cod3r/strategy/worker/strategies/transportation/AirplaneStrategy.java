package br.com.cod3r.strategy.worker.strategies.transportation;

public class AirplaneStrategy implements TransportationStrategy{

  @Override
  public void move() {
    System.out.println("I move by airplane");
  }
}
