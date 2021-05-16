package br.com.cod3r.command.migration.commands;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class UserTable extends MigrationCommand{

  public UserTable(Map<String, List<String>> database){
    super(database);
  }

  @Override
  public void execute() {
    List<String> columns = new ArrayList<>(Arrays.asList("id", "name", "email", "password"));
    database.put("user", columns);
  }

  @Override
  public void undo() {
    database.remove("user");
  }
}
