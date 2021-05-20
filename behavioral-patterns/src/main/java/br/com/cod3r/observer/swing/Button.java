package br.com.cod3r.observer.swing;


import javax.swing.JButton;

public class Button extends JButton {

  public Button(String text, Label... labels){
    super(text);

    addActionListener(e -> {
      for (Label label : labels) {
        label.increment();
      }
    });
  }


}
