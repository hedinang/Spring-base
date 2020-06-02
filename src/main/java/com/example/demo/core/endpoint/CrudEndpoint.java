//package com.example.demo.core.endpoint;
//
//import com.example.demo.core.service.CrudService;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.web.bind.annotation.RequestBody;
//
//import javax.ws.rs.*;
//import java.io.Serializable;
//
//public class CrudEndpoint<T, ID extends Serializable> {
//
//    private static Logger LOG = LoggerFactory.getLogger(CrudEndpoint.class);
//
//    protected CrudService<T, ID> crudService;
//
//    @GET
//    @Path("/{id}")
//    public T findById(@PathParam("id") ID id) {
//        return crudService.read(id);
//    }
//
//    @POST
//    public T create(@RequestBody T entity) {
//        return crudService.create(entity);
//    }
//
//    @PUT
//    public T update(@RequestBody T entity) {
//        return crudService.update(entity);
//    }
//
//    @DELETE
//    @Path("/{id}")
//    public void delete(@PathParam("id") ID id) {
//        crudService.delete(id);
//    }
//
//}
