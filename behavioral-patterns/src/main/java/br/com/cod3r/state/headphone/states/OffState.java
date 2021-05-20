package br.com.cod3r.state.headphone.states;

import br.com.cod3r.state.headphone.HeadPhone;

public class OffState implements HPState{
  private static final HPState instance = new OffState();

  public static HPState getInstance() {
    return instance;
  }

  @Override
  public void click(HeadPhone phone) {
    //Nothing to do;
    System.out.println("> Nothing happens");
  }

  @Override
  public void longClick(HeadPhone phone) {
    phone.setOn(true);
    System.out.println("> Turning on");
    phone.setState(OnState.getInstance());
  }
}
