import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.sql.SQLException;
import java.util.Objects;

@JsonSerialize
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
				hero = new Pudge(Long.parseLong(args[0]), args[1], Integer.parseInt(args[2]), args[3], null);
			} else {
				hero = new Hero(Long.parseLong(args[0]), args[1], Integer.parseInt(args[2]), args[3], null);
			}

			if (hero instanceof Pudge) {
				hero.serialize = new PudgeService().serialize((Pudge) hero);
			}

			dbHandler.add(hero);

			for (Hero hero1 : dbHandler.getAll()) {
				if (Objects.equals(hero1.name, "Pudge")) {
					System.out.println((new PudgeService().deserialize(hero1.serialize)).toString());
				} else {
					System.out.println(hero1.toString());
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			dbHandler.close();
		} finally {
			dbHandler.close();
		}
	}
}
