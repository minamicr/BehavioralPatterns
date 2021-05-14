package br.com.cod3r.memento.swing.component;

import br.com.cod3r.memento.swing.component.TextAreaWithMemory.TextAreaMemento;
import br.com.cod3r.memento.swing.memory.Memento;
import javax.swing.JTextField;

public class TextFieldWithMemory extends JTextField {

  public TextFieldWithMemory() {
    super();
  }

  public TextFieldWithMemory(String text, int size) {
    super(text, size);
  }

  public TextFieldMemento save (){
    return new TextFieldMemento(getText());

  }

  public void restore(TextFieldMemento memento){
    setText(memento.getState());
  }

  public static class TextFieldMemento implements Memento {
    String text;

    public TextFieldMemento (String text){
      this.text = text;
    }

    private String getState() {
      return text;
    }
  }
}
