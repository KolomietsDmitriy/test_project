import java.sql.SQLException;

public class Main {

	public static void main(String[] args){
		try {
			DbHandler dbHandler = new DbHandler();

			dbHandler.add(new Hero(1, "Hero3", 3, "ultimate"));

			for (Hero hero : dbHandler.getAll()) {
				System.out.println(hero.toString());
			}

			dbHandler.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
