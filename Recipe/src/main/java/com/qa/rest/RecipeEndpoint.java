package com.qa.rest;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;

import com.qa.business.service.RecipeService;

@Path("/Recipe")
public class RecipeEndpoint {
	
	@Inject
	private RecipeService service;
	
	@Path("/test")
	@GET
	public String test() {
		return "Hello World!";
	}
	@Path("/getAllRecipes")
	@GET
	@Produces({ "application/json" })
	public String getAllRecipes() {
		return service.getAllRecipes();
	}
	
	@Path("/cycleRecipes/{recipe}")
	@GET
	@Produces({ "application/json" })
	public int cycleRecipes(@PathParam("recipe") String recipe) {
		return service.cycleRecipes(recipe);
	}
	
	@Path("/getARecipe/{id}")
	@GET
	@Produces({ "application/json" })
	public String getARecipe(@PathParam("id") Long id) {
		return service.getARecipe(id);
	}

	@Path("/createRecipe")
	@POST
	@Produces({ "application/json" })
	public String addRecipe(String Recipe) {
		return service.addRecipe(Recipe);
	}

	@Path("/deleteRecipe/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteRecipe(@PathParam("id") Long id) {
		return service.deleteRecipe(id);
	}

	public void setService(RecipeService service) {
		this.service = service;
	}

}
