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
					ACLMessage respuesta = mensaje.createReply();
					if(mensaje.getContent().contains("como estas")) {
						
						respuesta.setContent("bien y tu?");
					
					}else {
						if(mensaje.getContent().contains("chao")) {
							
							respuesta.setContent("Chaaaao");
						
						}
					}
					JOptionPane.showMessageDialog(null,"Mensaje: "+ mensaje.getContent());
					try{ 
						Thread.sleep(3000); 
					} catch(InterruptedException e ){ 
						System.out.println("Thread Interrupted");
						
					}
					myAgent.send(respuesta);
				}else
					block();
				
			}
		});
	}
}
