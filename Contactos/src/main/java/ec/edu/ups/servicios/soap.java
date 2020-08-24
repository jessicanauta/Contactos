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
public class soap {
	
	@Inject
	private ContactosONLocal on;


	@WebMethod
	public String guardarDatos(String cedula, String nombre, String numero, String tipo) {

		System.out.println(this.toString());
		try {
			Persona per = new Persona();
			per.setCedula(cedula);
			per.setNombre(nombre);
			 on.guardarContacto(per);
				Telefono telefono = new Telefono();
				telefono.setNumero(numero);
				telefono.setTipo(tipo);
				telefono.setPersona(per);

				on.guardarTelefono(telefono);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "listarContacto";
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
