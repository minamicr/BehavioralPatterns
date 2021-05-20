package br.com.cod3r.state.headphone.states;

import br.com.cod3r.state.headphone.HeadPhone;

public class PlayingState implements HPState{
  private static final HPState instance = new PlayingState();

  private PlayingState(){}

  public static HPState getInstance(){
    return instance;
  }

  @Override
  public void click(HeadPhone phone) {
    phone.setPlaying(false);
    System.out.println("> Stop Player");
    phone.setState(OffState.getInstance());
  }

  @Override
  public void longClick(HeadPhone phone) {
    phone.setPlaying(false);
    System.out.println("> Turning off");
    phone.setState(OffState.getInstance());

  }
}
