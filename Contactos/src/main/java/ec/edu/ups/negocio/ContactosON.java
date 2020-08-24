package ec.edu.ups.negocio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import ec.edu.ups.controlador.DAOPersona;
import ec.edu.ups.controlador.DAOTelefono;
import ec.edu.ups.modelo.Persona;
import ec.edu.ups.modelo.Telefono;

@Stateless
public class ContactosON implements ContactosONRemoto, ContactosONLocal{

	@Inject 
	private DAOPersona daoper;
	
	@Inject
	private DAOTelefono daotel;
	
	public ContactosON() throws Exception {
		
	}

	public void guardarContacto(Persona per) throws Exception{
        if (validarCedula(per.getCedula())) {
            try {
                daoper.insertar(per);
                    /*List<Telefono> listaTelefonos = per.getListaTelefonos();
                    for (Telefono t : listaTelefonos) {
                        daotel.insertar(t);
                    }*/
                
            } catch (Exception e) {
            	throw new Exception("Error al ingresar Contacto");
            }
        } else {
            throw new Exception("Cedula Incorrecta");
        }
    }
	
	
	public void guardarTelefono(Telefono telefono) {
		daotel.insertar(telefono);
	}
	
	
	public Persona buscarPersonaCedula(String cedula) throws Exception{
        try {
            return daoper.buscarCedula(cedula);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }
	
	

    public void eliminarTelefono(String cedula) throws Exception{
        try {
        	daotel.eliminarTeleofno(cedula);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } 
    }

 
    
    public List<Persona> getPersona(){
		return daoper.getPersonas();
	}
    
    public List<Telefono> getTelefono(){
    	return daoper.getTelefonos();
    }
	
	public boolean validarCedula(String ced) {
        boolean verdadera = false;
        int num = 0;
        int ope = 0;
        int suma = 0;
        for (int cont = 0; cont < ced.length(); cont++) {
            num = Integer.valueOf(ced.substring(cont, cont + 1));
            if (cont == ced.length() - 1) {
                break;
            }
            if (cont % 2 != 0 && cont > 0) {
                suma = suma + num;
            } else {
                ope = num * 2;
                if (ope > 9) {
                    ope = ope - 9;
                }
                suma = suma + ope;
            }
        }
        if (suma != 0) {
            suma = suma % 10;
            if (suma == 0) {
                if (suma == num) {
                    verdadera = true;
                }
            } else {
                ope = 10 - suma;
                if (ope == num) {
                    verdadera = true;
                }
            }
        } else {
            verdadera = false;
        }
        return verdadera;
    }
}
