package br.com.cod3r.command.migration;

import br.com.cod3r.command.migration.commands.MigrationCommand;
import java.util.ArrayList;
import java.util.List;

public class MigrationTool {
  private List<MigrationCommand> migrations;
  private int nextMigrationIndex;

  public MigrationTool(){
    migrations = new ArrayList<>();
    nextMigrationIndex = 0;
  }

  public void addMigration(MigrationCommand migration) {
    migrations.add(migration);
  }

  public void up (){
    if (migrations.size() > nextMigrationIndex){
      migrations.get(nextMigrationIndex).execute();
      nextMigrationIndex ++;
    } else {
      System.out.println("You are up to date !");
    }
  }

  public void down() {
    if (nextMigrationIndex > 0) {
      migrations.get(nextMigrationIndex - 1).undo();
      nextMigrationIndex --;
    } else {
      System.out.println("You don´t have migrations left !");
    }

  }
}
