package br.com.cod3r.strategy.worker.strategies.work;

public class PilotStrategy implements WorkStrategy{

  @Override
  public void work() {
    System.out.println("I pilot planes to earn a lot of money");
  }
}
