import javax.swing.JOptionPane;

import jade.core.Agent;
import jade.core.behaviours.*;
import jade.lang.acl.*;

public class SegundoAgente extends Agent{

	protected void setup() {
		System.out.println("Hey!, mi nombre puede ser: " + getAID().getName());
		
		addBehaviour(new CyclicBehaviour() {
			
			@Override
			public void action() {
				
				ACLMessage msg = receive();
				if(msg!=null) {
					JOptionPane.showMessageDialog(null, "Tu mensaje os ha sido recibido, y es: " +msg.getContent());
				
					
					//Respondiendo de vuelta
					ACLMessage respuesta = msg.createReply();
					respuesta.setContent("¡No me gusto tu mensaje!");
					myAgent.send(respuesta);
				}else block();
				
			
			}
			
		});
	}
}
