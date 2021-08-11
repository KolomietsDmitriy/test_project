import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PudgeService {

	public byte[] serialize(Pudge pudge) {

		try {
			ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
			ObjectOutputStream outputStream = new ObjectOutputStream(arrayOutputStream);
			outputStream.writeObject(pudge);
			outputStream.close();
			return arrayOutputStream.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Hero deserialize(byte[] bytes) {
		try (ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(bytes)) {
			ObjectInputStream inputStream = new ObjectInputStream(arrayInputStream);
			Pudge o = (Pudge) inputStream.readObject();
			return o;
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
}
