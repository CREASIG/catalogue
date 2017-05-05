/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.creasig.recherche;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author e.vandevondele
 */

//SELECT * FROM donnee WHERE to_tsvector( intitule ) @@ to_tsquery( 'spatia');
@Path("/recherche")
public class RecherchesResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RecherchesResource
     */
    public RecherchesResource() {
    }

    /**
     * Retrieves representation of an instance of org.creasig.recherche.RecherchesResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * POST method for creating an instance of RechercheResource
     * @param content representation for the new resource
     * @return an HTTP response with content of the created resource
     */
    @POST
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Response postXml(String content) {
        //TODO
        return Response.created(context.getAbsolutePath()).build();
    }

    /**
     * Sub-resource locator method for {id}
     */
    @Path("{id}")
    public RechercheResource getRechercheResource(@PathParam("id") String id) {
        return RechercheResource.getInstance(id);
    }
}
