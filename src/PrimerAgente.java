import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

import javax.swing.JOptionPane;

import jade.core.AID;

public class PrimerAgente extends Agent {
	
	protected void setup() {
		System.out.println("Hola!, mi nombre es: " + getAID().getName());
		
		ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
		msg.addReceiver(new AID("Joaquin", AID.ISLOCALNAME));
		msg.setContent("Hola");
		msg.setLanguage("Espaniol");
		send(msg);
		
		addBehaviour(new CyclicBehaviour() {
		
			@Override
			public void action() {
				ACLMessage mensaje = receive();
				if(mensaje!= null) {
					if(mensaje.getContent().contains("como estas")) {
						ACLMessage respuesta = mensaje.createReply();
						respuesta.setContent("bien y tu?");
						myAgent.send(respuesta);
					}else {
						if(mensaje.getContent().contains("chao")) {
							ACLMessage respuesta = mensaje.createReply();
							respuesta.setContent("Chaaaao");
							myAgent.send(respuesta);
						}
					}
					JOptionPane.showMessageDialog(null,"Mensaje: "+ mensaje.getContent());
				}else
					block();
				
			}
		});
	}
}
