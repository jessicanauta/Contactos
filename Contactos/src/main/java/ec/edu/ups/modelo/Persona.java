package ec.edu.ups.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Persona implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo_per;
	
	
    private String cedula;
    private String nombre;
    
    /*@OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Telefono> listaTelefonos;*/
    
    
	
    
    public Persona() {
		// TODO Auto-generated constructor stub
	}

	public int getCodigo() {
		return codigo_per;
	}

	public void setCodigo(int codigo) {
		this.codigo_per = codigo;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/*public List<Telefono> getListaTelefonos() {
		return listaTelefonos;
	}

	public void setListaTelefonos(List<Telefono> listaTelefonos) {
		this.listaTelefonos = listaTelefonos;
	}
	
	public void addTelefono(Telefono tel){
		if(listaTelefonos==null)
			listaTelefonos = new ArrayList<Telefono>();
		
		listaTelefonos.add(tel);
	}*/
}
