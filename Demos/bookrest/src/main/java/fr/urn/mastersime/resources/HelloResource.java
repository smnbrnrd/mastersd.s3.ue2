package fr.urn.mastersime.resources;

import jakarta.ws.rs.Produces;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;

@Path("/hello")
public class HelloResource {

    @Context
    private UriInfo uriInfo;

    @GET
    @Produces("text/html")
    public String sayHello() {
        String baseUri = uriInfo.getBaseUri().toString();
        return "<html>" +
                "<head><title>Hello</title></head>" +
                "<body>" +
                "<h1>Hello, World!</h1>" +
                "<p>This service is running at: " + baseUri + "</p>" +
                "</body>" +
                "</html>";
    }

}
