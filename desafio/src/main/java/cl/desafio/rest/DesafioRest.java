
package cl.desafio.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import cl.desafio.bo.DesafioBO;

@Path("/rest")
@Produces(MediaType.APPLICATION_JSON) 
public class DesafioRest {	
	@POST
	@Path("/getFechas")
	@Consumes(MediaType.APPLICATION_JSON)
	public String getFechas(String in) {		
		return DesafioBO.getInstance().getFechas(in);
	}	
}