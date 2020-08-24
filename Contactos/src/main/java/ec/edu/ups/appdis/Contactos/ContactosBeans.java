package ec.edu.ups.appdis.Contactos;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import javax.sound.midi.Soundbank;

import org.hibernate.validator.internal.util.privilegedactions.NewProxyInstance;

import ec.edu.ups.modelo.Persona;
import ec.edu.ups.modelo.Telefono;
import ec.edu.ups.negocio.ContactosONLocal;

@ManagedBean
@ViewScoped
public class ContactosBeans {

	@Inject
	private ContactosONLocal on;

	private Persona newPersona;

	private List<Persona> listarContactos;

	private List<Telefono> listaTelefonos;

	private Telefono telefono;

	private List<Telefono> addTel;

	@PostConstruct
	public void init() {
		newPersona = new Persona();
		telefono = new Telefono();
		// newPersona.addTelefono(new Telefono());
		loadDataPersonas();
		loadDataTelefonos();

		addTel = new ArrayList<Telefono>();
	}

	public Persona getNewPersona() {
		return newPersona;
	}

	public void setNewPersona(Persona newPersona) {
		this.newPersona = newPersona;
	}

	public List<Persona> getListarContactos() {
		return listarContactos;
	}

	public void setListarContactos(List<Persona> listarContactos) {
		this.listarContactos = listarContactos;
	}

	public List<Telefono> getListaTelefonos() {
		return listaTelefonos;
	}

	public void setListaTelefonos(List<Telefono> listaTelefonos) {
		this.listaTelefonos = listaTelefonos;
	}

	@Override
	public String toString() {
		return "ContactosBeans [cedula=" + newPersona.getCedula() + ", nombre=" + newPersona.getNombre() + "]";
	}

	public void addTelefono() {
		addTel.add(new Telefono());
		telefono.agregarPersona(newPersona);
	}

	public String guardarDatos() {

		System.out.println(this.toString());
		try {
			 on.guardarContacto(newPersona);
				for(Telefono t:addTel) {
				Telefono telefono = new Telefono();

				telefono.setNumero(t.getNumero());
				telefono.setTipo(t.getTipo());
				telefono.setPersona(newPersona);

				on.guardarTelefono(telefono);
			}

//		

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "listarContacto";
	}

	private void loadDataTelefonos() {
		listaTelefonos = on.getTelefono();

	}

	private void loadDataPersonas() {
		listarContactos = on.getPersona();

		/*
		 * try { listarContactos = (ArrayList<Persona>) on.getPersona(); for (Persona
		 * per : listarContactos) { System.out.println("Cédula: " + per.getCedula());
		 * System.out.println("Nombre: " + per.getNombre()); for (Telefono telefono :
		 * per.getListaTelefonos()) { System.out.println("Número: " +
		 * telefono.getNumero()); System.out.println("Tipo: " + telefono.getTipo()); } }
		 * } catch (Exception e) { e.printStackTrace(); }
		 */
	}

	public List<Telefono> getAddTel() {
		return addTel;
	}

	public void setAddTel(List<Telefono> addTel) {
		this.addTel = addTel;
	}

}
