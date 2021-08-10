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

	private static final String INSERT = "INSERT INTO hero(id, name, level, ultimate) VALUES(?, ?, ?, ?)";
	private static final String SELECT = "SELECT id, name, level, ultimate from hero";

	private final Connection connection;

	public DbHandler() throws SQLException {
		DriverManager.registerDriver(new JDBC());

		connection = DriverManager.getConnection(CON);
	}

	public void close() {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void add(Hero hero) {
		try (PreparedStatement statement = connection.prepareStatement(INSERT)) {
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
		ResultSet resultSet = null;
		List<Hero> hero = new ArrayList<>();

		try (Statement statement = connection.createStatement()) {
			resultSet = statement.executeQuery(SELECT);

			while (resultSet.next()) {
				hero.add(new Hero(
						resultSet.getLong("id"),
						resultSet.getString("name"),
						resultSet.getInt("level"),
						resultSet.getString("ultimate")
				));
			}
//			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return Collections.emptyList();
		} finally {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return hero;
	}
}
