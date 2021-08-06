import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.sqlite.JDBC;

public class DbHandler {

	private static final String CON = "jdbc:sqlite::resource:java_sqlite";

	private final Connection connection;

	public DbHandler() throws SQLException {
		DriverManager.registerDriver(new JDBC());

		connection = DriverManager.getConnection(CON);
	}

	public void close() throws SQLException {
		connection.close();
	}

	public void add(Hero hero) {
		try (PreparedStatement statement = connection.prepareStatement(
				"INSERT INTO hero(id, name, level, ultimate) VALUES(?, ?, ?, ?)")) {
			statement.setObject(1, hero.id);
			statement.setObject(2, hero.name);
			statement.setObject(3, hero.level);
			statement.setObject(4, hero.ultimate);

			statement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.printf("%s added%n", hero.name);
	}

	public List<Hero> getAll() {
		try (Statement statement = connection.createStatement()) {
			ResultSet resultSet = statement.executeQuery("SELECT id, name, level, ultimate from hero");
			List<Hero> hero = new ArrayList<>();

			while (resultSet.next()) {
				hero.add(new Hero(
						resultSet.getLong("id"),
						resultSet.getString("name"),
						resultSet.getInt("level"),
						resultSet.getString("ultimate")
				));
			}
			resultSet.close();
			return hero;
		} catch (SQLException e) {
			e.printStackTrace();
			return Collections.emptyList();
		}
	}
}
