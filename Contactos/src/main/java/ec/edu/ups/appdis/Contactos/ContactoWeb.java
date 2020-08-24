package ec.edu.ups.appdis.Contactos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ec.edu.ups.controlador.DAOPersona;
import ec.edu.ups.modelo.Persona;
import ec.edu.ups.modelo.Telefono;
import ec.edu.ups.negocio.ContactosONLocal;
import ec.edu.ups.negocio.ContactosONRemoto;

@WebServlet("/contactoweb")
public class ContactoWeb extends HttpServlet{
	
	@Inject
	public ContactosONLocal contactos;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.getWriter().println("MOSTRAR CONTACTO" + "<br>" );
		System.out.println();
	
		 /*try {
			Telefono tel = new Telefono();
			tel.setNumero("0981726354");
			tel.setTipo("Celular");
			List<Telefono> listaTelefono = new ArrayList<>();
			listaTelefono.add(tel);
			
			String cedula = "0103098083";
			String nombre = "Priscila";
			Persona p = new Persona(0,cedula,nombre,listaTelefono);
			tel.setCodigo_per(p);
			 
			if(contactos.validarCedula(cedula)==true) {
				contactos.guardarContacto(p);
				 response.getWriter().println("CONTACTO GUARDADO CON EXITO!! " + "<br>");
			}else {
				response.getWriter().println("CEDULA INCORRECTA!! " + "<br>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		

		
		/*List<Persona> listaPersona;
		try {
			listaPersona = (ArrayList<Persona>) contactos.getPersona();
			for (Persona per : listaPersona) {
            	response.getWriter().println("Cedula: " + per.getCedula() + "<br>");
				response.getWriter().println("Nombre: " +per.getNombre() + "<br>");	
                for (Telefono telefono : per.getListaTelefonos()) {
                    response.getWriter().println("Telefono: " + telefono.getNumero() + "<br>");
                    response.getWriter().println("Tipo: " + telefono.getTipo() + "<br>");                    
                }
            }
		} catch (Exception e) {
			e.printStackTrace();
		}*/

	 }
}
