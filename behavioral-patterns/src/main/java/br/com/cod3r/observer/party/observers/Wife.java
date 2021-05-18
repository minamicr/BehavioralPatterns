package br.com.cod3r.observer.party.observers;

public class Wife implements Observer {


  @Override
  public void update(boolean status) {
    if (status){
      partyTime();
    } else {
      System.out.println("Hold ...");
    }
  }

  private void partyTime(){
    System.out.println("Let´s party ;-)");
  }
}
