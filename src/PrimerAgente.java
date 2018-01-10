import jade.core.Agent;
import jade.lang.acl.ACLMessage;
import jade.core.AID;

public class PrimerAgente extends Agent {
	
	protected void setup() {
		System.out.println("Hola!, mi nombre es: " + getAID().getName());
		
		ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
		msg.addReceiver(new AID("Joaquin", AID.ISLOCALNAME));
		msg.setContent("Hola!");
		msg.setLanguage("Espaniol");
		send(msg);
	}
	
	
}
