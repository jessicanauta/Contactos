package ec.edu.ups.controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.modelo.Persona;
import ec.edu.ups.modelo.Telefono;

@Stateless
public class DAOPersona {
	    
    @PersistenceContext(name="ContactosPersistenceUnit")
	private EntityManager em;
    
    public void insertar(Persona persona) {
		em.persist(persona);
	}
	
	public void actualizar(Persona persona) {
		em.merge(persona);
	}

	public Persona buscarCedula(String cedula) {
		return em.find(Persona.class, cedula);
	}

	public void eliminar(String cedula) {
			Persona p = buscarCedula(cedula);
			em.remove(p);
	}
	
	public List<Persona> getPersonas() {
		String jpql = "SELECT p FROM Persona p ";
		Query q = em.createQuery(jpql, Persona.class);		
		return q.getResultList();
	}
	
	public List<Telefono> getTelefonos() {
		String jpql = "SELECT t FROM Telefono t";
		Query q = em.createQuery(jpql, Telefono.class);
		return q.getResultList();
	}

 
    /*Conexion conexion = new Conexion();
    Connection con;
    
    public DAOPersona() throws Exception {
        try {
            con = conexion.getConnection();
        } catch (Exception e) {
            throw new Exception("Error de conexion", e.getCause());
        }

    }
	
	
	public int obtenerCodigo() throws Exception{
        try {
            String sql = "SELECT MAX(codigo ) FROM persona";
            Statement se = con.createStatement();
            ResultSet rs = se.executeQuery(sql);
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            throw new Exception("Error Obtener el codigo", e.getCause());
        }
        return 0;
    }
	
	
	public void insertar(Persona per) throws Exception {
		em.persist(per);
	}
	
	public Persona buscarCedula(String cedu) throws Exception{
        String sql = "select * from persona where cedula = '" + cedu + "'";
        Persona persona = null;
        try {
            Statement se = con.createStatement();
            ResultSet seter = se.executeQuery(sql);
            while (seter.next()) {
                int id = seter.getInt(1);
                String cedula = seter.getString(2);
                String nombre = seter.getString(3);
                sql = "select * from telefono where codigo_per = " + id;
                Statement se1 = con.createStatement();
                ResultSet seter1 = se1.executeQuery(sql);
                List<Telefono> listaTelefonos = new ArrayList<>();
                while (seter1.next()) {
                    int id1 = seter1.getInt(1);
                    String numero = seter1.getString(2);
                    String tipo = seter1.getString(3);
                    Telefono t = new Telefono(id1, numero, tipo, id);
                    listaTelefonos.add(t);
                }
                return new Persona(id, cedula, nombre, listaTelefonos);
            }
            throw new Exception("Persono no encontrada");
        } catch (SQLException e) {
            switch (e.getErrorCode()) {
                case 1064:
                    throw new Exception("Error en sintax en SQL");
                default:
                    throw new Exception(e.getMessage(), e);
            }
        } catch (Exception e) {
            throw new Exception("Error buscar Persona por Cedula", e);
        }
    }
	
	public void eliminar(int id) throws Exception{
        try {
            String Query = "Delete from Persona where codigo = '" + id + "'";
            Statement se = (Statement) con.createStatement();
            se.executeUpdate(Query);
        } catch (SQLException e) {
            switch (e.getErrorCode()) {
                case 1064:
                    throw new Exception("Error en sintax en SQL");
                default:
                    throw new Exception(e.getMessage(), e);
            }
        } catch (Exception e) {
            throw new Exception("Error al eliminar Persona", e);
        }
    }

    public void actualizar(Persona persona) throws Exception{
        try {
            String Query = "Update Persona SET cedula = ?,nombre = ? where codigo = " + persona.getCodigo();
            PreparedStatement statement = con.prepareStatement(Query);

            statement.setString(1, persona.getCedula());
            statement.setString(2, persona.getNombre());
            statement.execute();
        } catch (SQLException e) {
            switch (e.getErrorCode()) {
                case 1064:
                    throw new Exception("Error en sintax en SQL");
                default:
                    throw new Exception(e.getMessage(), e);
            }
        } catch (Exception e) {
            throw new Exception("Error al actualizar Persona", e);
        }
    }
    
    public List<Persona> getPersonas(String filtro) {
		String jpql = "SELECT p FROM Persona p " 
				+ "WHERE nombre LIKE:filtro";
		Query q = em.createQuery(jpql, Persona.class);
		q.setParameter("filtro", filtro+"%");
		return q.getResultList();

	}
    
    
    /*public List<Persona> listar() throws Exception {
        List<Persona> lista = new ArrayList<>();
        String sql = "select * from persona";
        try {
            Statement se = con.createStatement();
            ResultSet seter = se.executeQuery(sql);
            while (seter.next()) {
                int id = seter.getInt(1);
                String cedula = seter.getString(2);
                String nombre = seter.getString(3);
                sql = "select * from telefono where codigo_per = " + id;
                Statement se1 = con.createStatement();
                ResultSet seter1 = se1.executeQuery(sql);
                List<Telefono> listaTelefonos = new ArrayList<>();
                while (seter1.next()) {
                    int id1 = seter1.getInt(1);
                    String numero = seter1.getString(2);
                    String tipo = seter1.getString(3);
                    Telefono t = new Telefono(id1, numero, tipo, id);
                    listaTelefonos.add(t);
                }
                Persona p = new Persona(id, cedula, nombre, listaTelefonos);
                lista.add(p);
            }
            if(lista.isEmpty()){
                throw new Exception("Lista Vacia");
            }
            return lista;
        } catch (SQLException e) {
            switch (e.getErrorCode()) {
                case 1064:
                    throw new Exception("Error en sintax en SQL");
                default:
                    throw new Exception(e.getMessage(), e);
            }
        } catch (Exception e) {
            throw new Exception("Error Listar Persona", e);
        }
    }*/

}
	
