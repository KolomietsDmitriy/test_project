import static java.lang.String.format;
import java.io.Serializable;

public class Hero implements Serializable {
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

	@Override
	public String toString() {
		return format("Hero {id = %s, name = %s, level = %s,  ultimate = %s}", id, name, level, ultimate);
	}
}
