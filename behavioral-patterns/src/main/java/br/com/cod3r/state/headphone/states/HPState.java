package br.com.cod3r.state.headphone.states;

import br.com.cod3r.state.headphone.HeadPhone;

public interface HPState {
  void click(HeadPhone phone);
  void longClick(HeadPhone phone);

}
