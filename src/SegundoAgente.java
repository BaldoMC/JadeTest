import javax.swing.JOptionPane;

import jade.core.Agent;
import jade.core.behaviours.*;
import jade.lang.acl.*;

public class SegundoAgente extends Agent{

	protected void setup() {
		System.out.println("Hey!, mi nombre puede ser: " + getAID().getName());
		
		/**
		 * Metodo que agrega un comportamiento ciclico
	     * El cual recibe un mensaje y dependiendo del texto, responde.
		 */
		addBehaviour(new CyclicBehaviour() {
			
			@Override
			public void action() {
				//Se toma el mensaje de la pila de mensajes
				ACLMessage mensaje = receive();
				if(mensaje!=null) {
					//Se crea un mensaje de respuesta
					ACLMessage respuesta = mensaje.createReply();
					respuesta.setContent("");
					//Si el mensaje contiene un Hola
					if(mensaje.getContent().contains("Hola")) {
						//Se muestra por un mensaje el contenido
						JOptionPane.showMessageDialog(null,mensaje.getSender().getLocalName() + ": " +mensaje.getContent());
						respuesta.setContent("holaaaa, ¿como estas?");
	
					}else {
						if(mensaje.getContent().contains("bien y tu")) {
							//Se muestra por un mensaje el contenido
							JOptionPane.showMessageDialog(null,mensaje.getSender().getLocalName() + ": " +mensaje.getContent());
							respuesta.setContent("muy bien, ahora me tengo que ir, ¡chao!");
							
						}else {
							if(!mensaje.getContent().equals("")) {
								JOptionPane.showMessageDialog(null,mensaje.getSender().getLocalName() + ": " +mensaje.getContent());
							}
							doDelete();
						}
					}					
					//Se envia la respuesta
					myAgent.send(respuesta);

				}else block();
				
			}	
		});
	}
	protected void takeDown() {
		System.out.println(getAID().getLocalName() +" se despide.");
	}
}
