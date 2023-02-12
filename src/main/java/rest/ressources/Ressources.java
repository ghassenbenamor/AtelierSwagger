package rest.ressources;

import java.util.*;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import rest.entity.Employe;


@Path("employes")
@Api
public class Ressources {

	static List<Employe> employes = new ArrayList<Employe>();
	
	@GET
	@Produces("application/json")
	public  List<Employe> getAll()
	{
		return employes;
	}
	
	@POST
	@Consumes("application/json")
	@Produces("text/plain")
	public String addEmp(Employe emp) {
		if(employes.add(emp))
			return "Employe ajout�";
		
		return "Employ� non ajout�";
	}
	
	

	@PUT
	@Consumes("application/json")
	@Produces("text/plain")
	@ApiOperation(value ="update  Employes")
	@ApiResponses({
		
	@ApiResponse(code=200,message="Success"),@ApiResponse(code=404,message="failed")})
	public Response updateEmployee(Employe emp) {
		for (Employe emp1 : employes) {
			if (emp1.getCin().equals(emp1.getCin())) {
				emp1.setNom(emp1.getNom());
				emp1.setPrenom(emp1.getPrenom());
				return Response.status(Status.ACCEPTED).entity(employes).build();			}
		}
		return Response.status(Status.NOT_FOUND).entity("").build();
	}

	@GET
	@Produces("application/json")
	@Path("{cin}")
	@ApiOperation(value ="GET  Employe by id")
	public Employe searchEmployee(@PathParam("cin") String cin) {
		for (Employe emp : employes) {
			if (emp.getCin().equals(cin)) {
				return emp;

			}
		}
		return null;
	}

	@DELETE
	@Path("{cin}")
	@ApiOperation(value ="delete  Employes")
	@ApiResponses({
		
	@ApiResponse(code=200,message="Success"),@ApiResponse(code=404,message="failed")})
	public Response  deleteEmployee(@PathParam("cin") String cin) {
		Employe emp = searchEmployee(cin);
		if (employes.remove(emp)) {
			return Response.status(Status.ACCEPTED).entity(employes).build();			}
	
	return Response.status(Status.NOT_FOUND).entity("").build();
		}
	
}
