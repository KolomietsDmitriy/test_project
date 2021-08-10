import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.StringWriter;

@JsonAutoDetect
public class Pudge extends Hero {

	public Pudge(final long id, final String name, final int level, final String ultimate) {
		super(id, name, level, ultimate);
	}

	public void serialize() {
		try {
			StringWriter writer = new StringWriter();
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(writer, this);

			String result = writer.toString();
			System.out.println(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
