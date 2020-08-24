package ec.edu.ups.controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import ec.edu.ups.modelo.Persona;
import ec.edu.ups.modelo.Telefono;

@Stateless
public class DAOTelefono {
	    
    @PersistenceContext(name="ContactosPersistenceUnit")
	private EntityManager em;
    
    public void insertar(Telefono telefono) {
		em.persist(telefono);
	}
	
	public void actualizarTelefono(Telefono telefono) {
		em.merge(telefono);
	}

	public Telefono buscarTelefono(String cedula) {
		return em.find(Telefono.class, cedula);
	}

	public void eliminarTeleofno(String cedula) {
			Telefono tel = buscarTelefono(cedula);
			em.remove(tel);
	}
	
	public List<Telefono> getTelefonos() {
		String jpql = "SELECT t FROM Telefono t ";
		Query q = em.createQuery(jpql, Telefono.class);
		return q.getResultList();
	}
	
    /*Conexion conexion = new Conexion();
    Connection con;
    
    public DAOTelefono() throws Exception {
        try {
            con = conexion.getConnection();
        } catch (Exception e) {
            System.err.println(e.getCause());
            throw new Exception("Error de conexion");
        }
    }	
	
	public void ingresar(Telefono telefono) throws Exception{
		try {
			em.persist(telefono);
		} catch (Exception e) {
			// TODO: handle exception
		}		
    }
	
	public void eliminar(int codigo) throws Exception{
        try {
            String Query = "DELETE from Telefono where codigo_tel = '" + codigo + "'";
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
            throw new Exception("Error al eliminar telefono", e);
        }
    }

    public void actualizar(Telefono telefono) throws Exception{
        try {
            String Query = "UPDATE Telefono SET numero = ?, tipo = ?, codigo_per  = ? WHERE codigo_tel = " + telefono.getCodigo_tel();
            PreparedStatement statement = con.prepareStatement(Query);

            statement.setString(1, telefono.getNumero());
            statement.setString(2, telefono.getTipo());
            statement.setInt(3, telefono.getCodigo_per());
            statement.execute();
        } catch (SQLException e) {
            switch (e.getErrorCode()) {
                case 1064:
                    throw new Exception("Error en sintax en SQL");
                default:
                    throw new Exception(e.getMessage(), e);
            }
        } catch (Exception e) {
            throw new Exception("Error actualizar telefono", e);
        }
    }*/
}
