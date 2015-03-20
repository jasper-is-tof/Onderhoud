package ui.rest;


import Entity.EmployeeEntity;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author peetersjoris
 */
@Stateless
@Path("init-db")
public class InitDbREST {

    @PersistenceContext(unitName = "RESORTPU")
    private EntityManager em;

    @GET
    @Produces({"application/json", "application/xml"})
    public EmployeeEntity createDB() {
        List<Object> objectsToSave = new LinkedList<>();

        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setLastName("Mariën");
        employeeEntity.setFirstName("Jasper");
        employeeEntity.setAddress("Tiendeschuurstraat 18 Eppegem");
        employeeEntity.setJob("Onderhouder");
        employeeEntity.setStarthr("9:00");
        employeeEntity.setEndhr("18:00");
        employeeEntity.setEmail("jasper.marien@hotmail.be");
        employeeEntity.setPhone("0476909874");
        objectsToSave.add(employeeEntity);
        
        employeeEntity = new EmployeeEntity();
        employeeEntity.setLastName("Degrote");
        employeeEntity.setFirstName("Hans");
        employeeEntity.setAddress("Bomenlei 14 Hulst");
        employeeEntity.setJob("Poetser");
        employeeEntity.setStarthr("9:00");
        employeeEntity.setEndhr("18:00");
        employeeEntity.setEmail("Degrote.hans@hotmail.be");
        employeeEntity.setPhone("0478256874");
        objectsToSave.add(employeeEntity);
        
        
        for (Object objectsToSave1 : objectsToSave) {
            em.persist(objectsToSave1);
        }

        return employeeEntity;
    }

}
