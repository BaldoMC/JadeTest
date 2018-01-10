import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

import javax.swing.JOptionPane;

import jade.core.AID;

public class PrimerAgente extends Agent {
	
	protected void setup() {
		System.out.println("Hola!, mi nombre es: " + getAID().getName());
		
		//Se crea un mensaje con PERFORMATIVE = INFORM
		ACLMessage msg = new ACLMessage(ACLMessage.INFORM);
		//Se agrega el receptor a Joaquin
		msg.addReceiver(new AID("Joaquin", AID.ISLOCALNAME));
		//Se agrega el contenido del mensaje
		msg.setContent("Hola");
		//Se define el lenguaje del mensaje
		msg.setLanguage("Espaniol");
		//Se envia el mensaje
		send(msg);
		
	    /**
	     * Metodo que agrega un comportamiento ciclico
	     * El cual recibe un mensaje y dependiendo del texto, responde.
	     */
		addBehaviour(new CyclicBehaviour() {
		
			@Override
			public void action() {
				//Se obtiene el mensaje de la pila de mensajes
				ACLMessage mensaje = receive();
				if(mensaje!= null) {
					//Se crea una respuesta a ese mensaje
					ACLMessage respuesta = mensaje.createReply();
					if(mensaje.getContent().contains("como estas")) {
						
						respuesta.setContent("bien y tu?");
					
					}else {
						if(mensaje.getContent().contains("chao")) {
							
							respuesta.setContent("Chaaaao");
						
						}
					}
					//Se muestra por un mensaje el contenido
					JOptionPane.showMessageDialog(null,mensaje.getSender().getLocalName() +": " + mensaje.getContent());
					//Se pausa por 3 segundos
					/**try{ 
						Thread.sleep(1000); 
					} catch(InterruptedException e ){ 
						System.out.println("Thread Interrupted");
						
					}
					*/
					//Se envia la respuesta
					myAgent.send(respuesta);
				}else
					block();
				
			}
		});
	}
	
	
}
