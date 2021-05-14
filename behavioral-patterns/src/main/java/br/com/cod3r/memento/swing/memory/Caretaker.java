package br.com.cod3r.memento.swing.memory;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Caretaker {
  Map<String, Memento> mementos = new HashMap<String, Memento>();

  public Map<String, Memento> getHistoryList(){
    return Collections.unmodifiableMap(mementos);
  }

  public void add(String identifier, Memento memento){
    mementos.put(identifier, memento);
  }

  public Memento get(String identifier){
    return mementos.get(identifier);
  }

  public int getSize(){
    switch (mementos.size()){
      case 0:
        return 0;
      case 1:
        return 1;
      default:
        return mementos.size()/2;
    }

  }
}
