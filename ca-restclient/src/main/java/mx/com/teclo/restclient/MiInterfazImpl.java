package mx.com.teclo.restclient;

import org.springframework.stereotype.Service;


@Service("miInterfaz")
public class MiInterfazImpl implements MiInterfaz {

	public void mimetodo() {
System.out.println("Hola desde miInterfaz");		
	}
	 
	
	
}