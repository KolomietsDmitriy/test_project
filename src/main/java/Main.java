import java.sql.SQLException;

public class Main {

	public static void main(String[] args){

		try {

			DbHandler dbHandler = new DbHandler();

			dbHandler.add(new Hero(Long.parseLong(args[0]), args[1], Integer.parseInt(args[2]), args[3]));

			for (Hero hero : dbHandler.getAll()) {
				System.out.println(hero.toString());
			}

			dbHandler.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
