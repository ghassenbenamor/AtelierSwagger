package rest.activator;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import io.swagger.jaxrs.config.BeanConfig;
import rest.ressources.Ressources;

@ApplicationPath("api")
public class RestActivator extends Application {
	public RestActivator() {
		super();
		BeanConfig beanConig = new BeanConfig();
		beanConig.setVersion("1.0.0");
		beanConig.setSchemes(new String[] {"http"});
		beanConig.setHost("localhost:8081");
		beanConig.setBasePath("Atelier3_1ALINFO5/api");
		beanConig.setResourcePackage("rest.ressources");
		beanConig.setScan(true);
	}
	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> resources = new HashSet<Class<?>>();
		resources.add(Ressources.class);
		resources.add(io.swagger.jaxrs.listing.ApiListingResource.class);
		resources.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);
		return resources;
}
	
	

}
