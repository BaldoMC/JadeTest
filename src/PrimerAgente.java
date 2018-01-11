import jade.core.Agent;
import jade.core.behaviours.*;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.lang.acl.ACLMessage;

import javax.swing.JOptionPane;

import jade.core.AID;

public class PrimerAgente extends Agent {



	protected void setup() {
		System.out.println("Hola!, mi nombre es: " + getAID().getName());
			/**
			 * Metodo que agrega un comportamiento de un solo llamado
			 * El cual manda un mensaje al agente Joaquin
			 */
			addBehaviour(new OneShotBehaviour() {

				@Override
				public void action() {
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
				}
			});

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
						respuesta.setContent("");
						if(mensaje.getContent().contains("como estas")) {
							//Se muestra por un mensaje el contenido
							JOptionPane.showMessageDialog(null,mensaje.getSender().getLocalName() + ": " +mensaje.getContent());
							respuesta.setContent("bien y tu?");

						}else {
							if(mensaje.getContent().contains("chao")) {
								//Se muestra por un mensaje el contenido
								JOptionPane.showMessageDialog(null,mensaje.getSender().getLocalName() + ": " +mensaje.getContent());
								respuesta.setContent("Chaaaao");
							}else {
								//Si existe una respuesta se muestra el contenido.
								if(!mensaje.getContent().equals("")) {
									JOptionPane.showMessageDialog(null,mensaje.getSender().getLocalName() + ": " +mensaje.getContent());
								}
								//Se elimina el primer agente
								doDelete();
							}
						}
						
						//Se envia la respuesta
						myAgent.send(respuesta);
					}else
						block();
				}
			});
	}

	protected void takeDown() {
		System.out.println(getAID().getLocalName() +" se despide.");
	}
}
