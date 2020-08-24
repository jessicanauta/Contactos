package ec.edu.ups.negocio;

import java.util.List;

import javax.ejb.Local;
import ec.edu.ups.modelo.Persona;
import ec.edu.ups.modelo.Telefono;

@Local
public interface ContactosONLocal {

	public void guardarContacto(Persona per) throws Exception;	
	
	public void guardarTelefono(Telefono telefono);
	
	public Persona buscarPersonaCedula(String cedula) throws Exception;
	
	public void eliminarTelefono(String cedula) throws Exception;
	
	
	//public List<Persona> listarContactos() throws Exception;
	public List<Persona> getPersona();
	
	public List<Telefono> getTelefono();
	
	public boolean validarCedula(String ced);
}
