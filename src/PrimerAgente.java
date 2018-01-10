import jade.core.Agent;

public class PrimerAgente extends Agent {
	
	protected void setup() {
		System.out.println("Hola!, mi nombre es: " + getAID().getName());
	}

}
