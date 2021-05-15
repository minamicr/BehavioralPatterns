package br.com.cod3r.command.alexa.alexa;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import javax.print.DocFlavor.STRING;

public class AlexaAI {
  private Map<String, String[]> associations;

  public AlexaAI() {
    associations = new HashMap<String, String[]>();
  }

  public void addAssociation(String key, String[] association) {
    associations.put(key,
        Stream.of(association).map(String::toLowerCase).toArray(String[]::new));
  }

  public String getFindAssociations(String request) {
    for (String[] association: associations.values()){
      if(Stream.of(association).allMatch(request::contains)){
        return getKeyFromAssociations(association);
      }
    }
    return null;
  }

  private String getKeyFromAssociations(String ...keywords) {
    return associations
        .entrySet()
        .stream()
        .filter(entry -> keywords.equals(entry.getValue()))
        .map(Map.Entry::getKey)
        .findFirst()
        .get();
  }
}
