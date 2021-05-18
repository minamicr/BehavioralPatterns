package br.com.cod3r.observer.party.subject;

import br.com.cod3r.observer.party.observers.Observer;
import java.util.ArrayList;
import java.util.List;

public class Subject {
  List<Observer> observers = new ArrayList<>();

  public void add(Observer observer) {
    observers.add(observer);
  }

  public void notifyObservers(boolean status){
    for (Observer observer : observers){
      observer.update(status);
    }
  }

}
