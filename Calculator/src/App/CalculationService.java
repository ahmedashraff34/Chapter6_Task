package App;


import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Stateless
@Path("service")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CalculationService {
	
	@PersistenceContext (unitName="CalcDB")
    private EntityManager entityManager;
	
	
	
	@POST
	@Path("calc")
	public String calculationProcess(Calculation Request) {
		entityManager.persist(Request);
		double res=Request.calculate(Request);
		return "{\"Result\": " + res + "}";
	}
	
	@GET
    @Path("calculations")
    public List<Calculation> getAllCalculations() {
        try {

        	return entityManager.createQuery("SELECT c FROM Calculation c", Calculation.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            // Return null or handle the error appropriately
            return null;
        }
        }
	
}
