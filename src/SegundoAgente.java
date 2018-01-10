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
					ACLMessage respuesta = mensaje.createReply();
					if(mensaje.getContent().contains("Hola")) {
						
						respuesta.setContent("holaaaa, ¿como estas?");
	
					}else {
						if(mensaje.getContent().contains("bien y tu")) {
							
							respuesta.setContent("muy bien, ahora me tengo que ir, ¡chao!");
							
						}
					}
					
					JOptionPane.showMessageDialog(null, "Tu mensaje os ha sido recibido, y es: " +mensaje.getContent());
					try{ 
						Thread.sleep(3000); 
					} catch(InterruptedException e ){ 
						System.out.println("Thread Interrupted");
						
					}
					myAgent.send(respuesta);

				}else block();
				
			
			}
			
		});
	}
}
