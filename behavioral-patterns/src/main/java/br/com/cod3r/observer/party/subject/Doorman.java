package br.com.cod3r.observer.party.subject;

public class Doorman extends Subject {
  private boolean status = false;

  public boolean getStatus(){
    return this.status;
  }

  public void setStatus(boolean status){
    if (status != this.status) {
      this.status = status;
      notifyObservers(status);
    } else {
      System.out.println("status " + status);
    }
  }
}
