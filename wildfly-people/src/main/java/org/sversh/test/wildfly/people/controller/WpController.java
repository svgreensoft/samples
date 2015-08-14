package org.sversh.test.wildfly.people.controller;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.sversh.test.wildfly.people.model.Person;
import org.sversh.test.wildfly.people.service.WpService;

/**
 * 
 * @author Sergey Vershinin
 * @since Jun 16, 2015
 *
 */
@Path("/")
public class WpController {
    
    @Inject
    private WpService wpService;

    @POST
    @Path("json")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postPersonData(Person person) {
        boolean result = wpService.save(person);
        String msg = result ? "Person's data added successfully" : "The person already exists in DB.";
        return Response.ok(msg).build();
    }


}
