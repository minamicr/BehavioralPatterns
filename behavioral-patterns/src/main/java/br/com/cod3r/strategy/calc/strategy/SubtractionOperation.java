package br.com.cod3r.strategy.calc.strategy;

public class SubtractionOperation implements OperationStrategy{
  public int calculate (int number1, int number2) {
    System.out.println(String.format("%d - %d", number1, number2));
    return number1 - number2;
  }

}
