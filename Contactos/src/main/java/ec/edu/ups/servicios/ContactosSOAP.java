package ec.edu.ups.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

import ec.edu.ups.modelo.Persona;
import ec.edu.ups.modelo.Telefono;
import ec.edu.ups.negocio.ContactosONLocal;

@WebService
public class ContactosSOAP {
	
	@Inject
	private ContactosONLocal on;


	@WebMethod
	private List<Telefono> listaTelefonos() {
		List<Telefono> listado = new ArrayList<Telefono>();

			listado = on.getTelefono();

		return listado;
	}

	@WebMethod
	public List<Telefono> listaTelefono(){
		List<Telefono> listado = new ArrayList<Telefono>();
		try {
			listado = on.getTelefono();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return listado;
	}
	
}
