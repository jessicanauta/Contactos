package ec.edu.ups.modelo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Telefono implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codigo_tel;
	
    private String  numero;
    private String tipo;   
    
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="codigo_per")
    private Persona persona;
       
    
	public void agregarPersona(Persona p) {
		if(persona==null) {
		persona=new Persona();
		Telefono tel=new Telefono();
		tel.setPersona(p);
		
		}
		
	}

    public Telefono(int codigo_tel, String numero, String tipo, Persona persona) {
		super();
		this.codigo_tel = codigo_tel;
		this.numero = numero;
		this.tipo = tipo;
		this.persona = persona;
	}


	public Telefono() {
		// TODO Auto-generated constructor stub
	}


	public int getCodigo_tel() {
		return codigo_tel;
	}


	public void setCodigo_tel(int codigo_tel) {
		this.codigo_tel = codigo_tel;
	}


	public String getNumero() {
		return numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}





	public Persona getPersona() {
		return persona;
	}


	public void setPersona(Persona persona) {
		this.persona = persona;
	}


	@Override
	public String toString() {
		return "numero=" + numero + ", tipo=" + tipo;
	}
	



}
