package ec.edu.ups.servicios;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
		servers = {
				@Server(description = "Servidor local",
						url = "/contactos")
		}
)

@ApplicationPath("/ws")
public class RestAplication extends Application{

}
