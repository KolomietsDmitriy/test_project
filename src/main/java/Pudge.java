import java.io.Serializable;

public class Pudge extends Hero implements Serializable {

	private static final long serialVersionUID = 1L;

	public Pudge(final long id, final String name, final int level, final String ultimate, final byte[] serialize) {
		super(id, name, level, ultimate, serialize);
	}

	public Pudge(final long id, final int level, final String name, final String ultimate) {
		super(id, name, level, ultimate, null);
	}

}
