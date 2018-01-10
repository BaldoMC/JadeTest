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
				
				ACLMessage mensaje = receive();
				if(mensaje!=null) {
					if(mensaje.getContent().contains("Hola")) {
						ACLMessage respuesta = mensaje.createReply();
						respuesta.setContent("holaaaa, ¿como estas?");
						myAgent.send(respuesta);
					}else {
						if(mensaje.getContent().contains("bien y tu")) {
							ACLMessage respuesta = mensaje.createReply();
							respuesta.setContent("muy bien, ahora me tengo que ir, ¡chao!");
							myAgent.send(respuesta);
						}
					}
					JOptionPane.showMessageDialog(null, "Tu mensaje os ha sido recibido, y es: " +mensaje.getContent());
				
					

				}else block();
				
			
			}
			
		});
	}
}
