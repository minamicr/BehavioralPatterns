package br.com.cod3r.state.headphone.states;

import br.com.cod3r.state.headphone.HeadPhone;

public class OnState implements HPState {
  private static final HPState instance = new OnState();

  private OnState(){}

  public static HPState getInstance(){
    return instance;
  }

  @Override
  public void click(HeadPhone phone) {
    phone.setPlaying(true);
    System.out.println("> resume playing");
    phone.setState(PlayingState.getInstance());
  }

  @Override
  public void longClick(HeadPhone phone) {
    phone.setOn(false);
    System.out.println("> turning off");
    phone.setState(OffState.getInstance());
  }
}
