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
			outputStream.flush();

			return arrayOutputStream.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public Pudge deserialize(byte[] bytes) {
		try {
			ObjectInputStream inputStream = new ObjectInputStream(new ByteArrayInputStream(bytes));
			Pudge pudge = (Pudge) inputStream.readObject();
			inputStream.close();
			return pudge;
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
}
