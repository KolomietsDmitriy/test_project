import static java.lang.String.format;

public class Hero {
	public long id;
	public String name;
	public int level;
	public String ultimate;
	public byte[] serialize;

	public Hero(final long id, final String name, final int level, final String ultimate, final byte[] serialize) {
		this.id = id;
		this.name = name;
		this.level = level;
		this.ultimate = ultimate;
		this.serialize = serialize;
	}

	@Override
	public String toString() {
		return format("Hero {id = %s, name = %s, level = %s,  ultimate = %s}", id, name, level, ultimate);
	}
}
