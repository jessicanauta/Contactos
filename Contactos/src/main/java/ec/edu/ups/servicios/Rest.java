package ec.edu.ups.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import ec.edu.ups.modelo.Persona;
import ec.edu.ups.modelo.Telefono;
import ec.edu.ups.negocio.ContactosONLocal;

@Path("/telefonos")
public class Rest {
	
	@Inject
	private ContactosONLocal on;


	@POST
	@Path("/guardarTelefono/{cedula}/{nombre}/{numero}/{tipo}")
	@Produces("application/json")
	public String guardarDatos(@PathParam("cedula") String cedula, @PathParam("nombre") String nombre, @PathParam("numero") String numero, @PathParam("tipo") String tipo) throws Exception {

		System.out.println(this.toString());

			Persona per = new Persona();
			per.setCedula(cedula);
			per.setNombre(nombre);
			 on.guardarContacto(per);
				Telefono telefono = new Telefono();
				telefono.setNumero(numero);
				telefono.setTipo(tipo);
				telefono.setPersona(per);

				on.guardarTelefono(telefono);

		return "listarContacto";
	}
	
	@GET
	@Path("/listarTelefino")
	@Produces("application/json")
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
