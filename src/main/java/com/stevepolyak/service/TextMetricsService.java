package com.stevepolyak.service;

import javax.jws.WebService;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import com.stevepolyak.model.Text;

@Path("/analyze")
@WebService
@Produces("application/json")
public interface TextMetricsService {

	Text analyze(Text text);
	
	@GET
    @Produces("application/json")
	Text info(@QueryParam("value") String value);
	
	@POST
    @Produces("application/json")
	Text formInfo(@FormParam("value") String value);
}
