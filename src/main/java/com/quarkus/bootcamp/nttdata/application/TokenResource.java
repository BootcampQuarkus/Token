package com.quarkus.bootcamp.nttdata.application;

import com.quarkus.bootcamp.nttdata.domain.TokenService;
import com.quarkus.bootcamp.nttdata.infraestructure.Association;
import com.quarkus.bootcamp.nttdata.infraestructure.Value;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;

import java.util.List;

@Path("/increments")
public class TokenResource {
  @Inject
  TokenService service;

  @GET
  public Uni<List<String>> keys() {
    return service.keys();
  }

  @POST
  public Association create(Association association) {
    service.set(association.getKey(), association.getValue());
    return association;
  }

  @GET
  @Path("/{key}")
  public Association get(String key) {
    return new Association(key, service.get(key));
  }

  @PUT
  @Path("/{key}")
  public void increment(String key, Value value) {
    service.update(key, value);
  }

  @DELETE
  @Path("/{key}")
  public Uni<Void> delete(String key) {
    return service.del(key);
  }
}
