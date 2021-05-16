package br.com.cod3r.command.migration.commands;

import java.util.List;
import java.util.Map;

public class UserTableRoleColumn extends MigrationCommand{

  public UserTableRoleColumn(Map<String, List<String>> database){
    super(database);
  }

  @Override
  public void execute(){
    List<String> columns = database.get("user");
    columns.add("role");
  }

  @Override
  public void undo(){
    List<String> user = database.get("user");
    user.remove("role");

  }
}
