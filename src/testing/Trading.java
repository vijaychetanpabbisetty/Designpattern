package testing;
public class Trading {

	public void accept(NodeVisitor visitor) {
		System.out.println("Accept Trading Class Method.");
		visitor.visitTrading(this);

	}

}
