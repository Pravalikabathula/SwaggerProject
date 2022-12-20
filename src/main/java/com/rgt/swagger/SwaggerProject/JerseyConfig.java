package com.rgt.swagger.SwaggerProject;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
import springfox.documentation.swagger.web.InMemorySwaggerResourcesProvider;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
@ApplicationPath("/api")
@Component
@Primary
public class JerseyConfig extends ResourceConfig implements SwaggerResourcesProvider {

	public JerseyConfig() {
		register(EmployeeResourceController.class);
		//register(DepartmentController.class);
	}

	@PostConstruct
	public void init() {
		this.configureSwagger();
	}

	private void configureSwagger() {
		this.register(ApiListingResource.class);
		this.register(SwaggerSerializers.class);

		BeanConfig config = new BeanConfig();
		config.setTitle(" Swagger Docmentation");
		config.setVersion("v2");
		config.setContact("Bright");
		config.setSchemes(new String[] { "http", "https" });
		config.setBasePath("/api");
		config.setResourcePackage(" com.rgt.swagger.SwaggerProject");
		config.setPrettyPrint(true);
		config.setScan(true);
	}

	@Resource
	private InMemorySwaggerResourcesProvider inMemorySwaggerResourcesProvider;

	@Override
	public List<SwaggerResource> get() {

		SwaggerResource Resource = new SwaggerResource();
		Resource.setLocation("/api/swagger.json");
		Resource.setSwaggerVersion("2.0");

		return Stream.concat(Stream.of(Resource), inMemorySwaggerResourcesProvider.get().stream())
				.collect(Collectors.toList());
	}

}
