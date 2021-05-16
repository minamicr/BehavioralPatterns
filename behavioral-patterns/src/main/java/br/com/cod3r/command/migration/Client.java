package br.com.cod3r.command.migration;

import br.com.cod3r.command.migration.commands.ProductTable;
import br.com.cod3r.command.migration.commands.UserTable;
import br.com.cod3r.command.migration.commands.UserTableRoleColumn;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Client {

	public static void main(String[] args) {
		Map<String, List<String>> database = new HashMap<String, List<String>>();

		MigrationTool tool = new MigrationTool();
		tool.addMigration(new ProductTable(database));
		tool.addMigration(new UserTable(database));
		tool.addMigration(new UserTableRoleColumn(database));

		System.out.println(database);
		tool.up();

		System.out.println(database);
		tool.up();

		System.out.println(database);
		tool.up();

		System.out.println(database);
		tool.up();

		System.out.println(database);
		tool.up();

		System.out.println(database);
		tool.up();

		System.out.println(database);
		tool.up();

		System.out.println(database);
		tool.down();

		System.out.println(database);
		tool.down();

		System.out.println(database);
		tool.down();

		System.out.println(database);
		tool.down();

	}
}
