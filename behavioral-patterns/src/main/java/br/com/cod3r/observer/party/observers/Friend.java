package br.com.cod3r.observer.party.observers;

public class Friend implements Observer{


  @Override
  public void update(boolean status) {
    if(status){
      sendGift();
    } else {
      System.out.println("Sleep ...");
    }
  }

  private void sendGift(){
    System.out.println("Look, I bought your favorite beer!");
  }
}
