package bg.elsys.ip.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Path("/cars")
@Api("cars")
public class CarResource {
	
	@POST
	@ApiOperation(value = "create new car", response = Car.class)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createCar(Car car) {
		CarService carService = CarService.getInstance();
		carService.addCar(car);
		return Response.ok(car).status(Status.CREATED).build();
	}
	
	@PUT
	@ApiOperation(value = "update car", response = Car.class)
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{userId}")
	public Response updateCar(@PathParam("carId") int carId, Car car) {
		CarService carService = CarService.getInstance();
		carService.updateCar(carId, car);
		return Response.ok(car).build();
	}
	
	@DELETE
	@ApiOperation(value = "delete car")
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteCar(Car car) {
		CarService carService = CarService.getInstance();
		carService.deleteCar(car);
	}

	@GET
	@ApiOperation(value = "get list of cars")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCars(
				@QueryParam("page") int page,
				@QueryParam("per-page") int perPage,
				@QueryParam("with-name") String withName,
				@QueryParam("with-brand") String withBrand,
				@QueryParam("with-model") String withModel,
				@QueryParam("with-year") String withYear
			) {
		
		CarService carService = CarService.getInstance();
		return Response.ok(
				carService.getCarsFilteredPaginated(
						page, perPage, withBrand, withModel, withYear, withName)
						).build();
	}
}













