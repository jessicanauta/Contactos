package ec.edu.ups.negocio;

import java.util.List;

import javax.ejb.Remote;
import ec.edu.ups.modelo.Persona;
import ec.edu.ups.modelo.Telefono;

@Remote
public interface ContactosONRemoto {

	public void guardarContacto(Persona per) throws Exception;	
	
	public void guardarTelefono(Telefono telefono);
	
	public Persona buscarPersonaCedula(String cedula) throws Exception;
	
	
	public void eliminarTelefono(String cedula) throws Exception;
	
	
	public List<Persona> getPersona();
	
	public boolean validarCedula(String ced);
}
