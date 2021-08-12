import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Pudge extends Hero implements Externalizable {

	public Pudge(final long id, final String name, final int level, final String ultimate, final byte[] serialize) {
		super(id, name, level, ultimate, serialize);
	}

	public Pudge(){};

	@Override
	public void writeExternal(final ObjectOutput out) throws IOException {
		out.writeObject(this.getId());
		out.writeObject(this.getName());
		out.writeObject(this.getLevel());
		out.writeObject(this.getUltimate());
	}

	@Override
	public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
		this.setId((Long) in.readObject());
		this.setName((String) in.readObject());
		this.setLevel((Integer) in.readObject());
		this.setUltimate((String) in.readObject());
	}
}
