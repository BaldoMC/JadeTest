import javax.swing.JOptionPane;

import jade.core.Agent;
import jade.core.behaviours.*;
import jade.lang.acl.*;

public class SegundoAgente extends Agent{

	protected void setup() {
		System.out.println("Hey!, mi nombre puede ser: " + getAID().getName());
		
		/**
		 *Metodo que agrega un comportamiento ciclico
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
					//Si el mensaje contiene un Hola
					if(mensaje.getContent().contains("Hola")) {
						
						respuesta.setContent("holaaaa, ¿como estas?");
	
					}else {
						if(mensaje.getContent().contains("bien y tu")) {
							
							respuesta.setContent("muy bien, ahora me tengo que ir, ¡chao!");
							
						}
					}
					//Se muestra el contenido del mensaje
					JOptionPane.showMessageDialog(null,mensaje.getSender().getLocalName() + " Tu mensaje os ha sido recibido, y es: " +mensaje.getContent());
					//Pausa de 3 segundos
					try{ 
						Thread.sleep(3000); 
					} catch(InterruptedException e ){ 
						System.out.println("Thread Interrupted");
						
					}
					//Se envia la respuesta
					myAgent.send(respuesta);

				}else block();
				
			}	
		});
	}
}
