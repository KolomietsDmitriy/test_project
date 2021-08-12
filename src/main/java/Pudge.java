import java.io.Serializable;

public class Pudge extends Hero implements Serializable {

	public Pudge(final long id, final String name, final int level, final String ultimate, final byte[] serialize) {
		super(id, name, level, ultimate, serialize);
	}

}
