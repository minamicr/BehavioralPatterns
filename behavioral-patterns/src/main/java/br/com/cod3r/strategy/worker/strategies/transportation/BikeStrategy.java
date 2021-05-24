package br.com.cod3r.strategy.worker.strategies.transportation;

public class BikeStrategy implements TransportationStrategy{

  @Override
  public void move() {
    System.out.println("I move by bike");
  }
}
