import static java.lang.String.format;

public class Hero {
	private long id;
	private String name;
	private int level;
	private String ultimate;
	private byte[] serialize;

	public Hero(final long id, final String name, final int level, final String ultimate, final byte[] serialize) {
		this.id = id;
		this.name = name;
		this.level = level;
		this.ultimate = ultimate;
		this.serialize = serialize;
	}
	
	public Hero(){};

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getLevel() {
		return level;
	}

	public String getUltimate() {
		return ultimate;
	}

	public byte[] getSerialize() {
		return serialize;
	}

	public void setId(final long id) {
		this.id = id;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public void setLevel(final int level) {
		this.level = level;
	}

	public void setUltimate(final String ultimate) {
		this.ultimate = ultimate;
	}

	public void setSerialize(final byte[] serialize) {
		this.serialize = serialize;
	}

	@Override
	public String toString() {
		return format("Hero {id = %s, name = %s, level = %s,  ultimate = %s}", id, name, level, ultimate);
	}
}
