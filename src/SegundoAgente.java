import jade.core.Agent;

public class SegundoAgente extends Agent{

	protected void setup() {
		System.out.println("Hey!, mi nombre puede ser: " + getAID().getName());
	}
}
