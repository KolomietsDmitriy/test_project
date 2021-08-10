import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.StringWriter;
import java.sql.SQLException;
import java.util.Objects;

public class Main {

	public static void main(String[] args) {

		if (args.length < 4) {
			System.out.println("Невалидный входные параметры");
			return;
		}

		DbHandler dbHandler = null;
		try {

			dbHandler = new DbHandler();

			Hero hero;

			if (Objects.equals(args[1], "Pudge")) {
				hero = new Pudge(Long.parseLong(args[0]), args[1], Integer.parseInt(args[2]), args[3]);
			} else {
				hero = new Hero(Long.parseLong(args[0]), args[1], Integer.parseInt(args[2]), args[3]);

			}

			dbHandler.add(hero);

			if (Objects.equals(hero.name, "Pudge")) {
				((Pudge) hero).serialize();
			}

			for (Hero hero1 : dbHandler.getAll()) {
				System.out.println(hero1.toString());
			}

//			dbHandler.close();
		} catch (SQLException e) {
			e.printStackTrace();
			dbHandler.close();
		} finally {
			dbHandler.close();
		}
	}
}
