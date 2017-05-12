package bg.elsys.ip.rest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CarService {
	
	private static CarService instance;
	private List<Car> carList = new ArrayList<>();
	
	private CarService() {
		carList.add(new Car(0, "Bega4ka" ,"audi", "rs6", 700, "2017"));
		carList.add(new Car(1, "Karuca", "bmw", "m7", 450, "2017"));
		carList.add(new Car(2, "Brum brum" ,"opel", "zafira", 50, "2002"));
		carList.add(new Car(3, "Kolica", "mazda", "6", 450, "2015"));
		carList.add(new Car(4, "Zvqraa", "Porsche", "911", 450, "2015"));
	}
	
	public static CarService getInstance(){
		if(instance == null) {
			instance = new CarService();
		}
		return instance;
	}
	
	public void addCar(Car car) {
		carList.add(car);
	}
	
	public void updateCar(int id, Car car) {
		carList.remove(id);
		carList.add(car);
	}
	
	public void deleteCar(Car car) {
		carList.remove(car);
	}
	
	public List<Car> getCars() {
		return Collections.unmodifiableList(carList);
	}
	
	public List<Car> getCarsFilteredPaginated
					(int page, int perPage, 
							String withBrand, String withModel, 
							String withYear, String withName) {
		long previousEntries = (page - 1) * perPage;
		return carList.stream()
				.filter(car -> {
					if(withBrand != null) {
						return (car.getBrand().toLowerCase() == withBrand.toLowerCase());
					}
					return true;
				})
				.filter(car -> {
					if(withModel != null){
						return (car.getModel().toLowerCase() == withModel.toLowerCase());
					}
					return true;
				})
				.filter(car -> {
					if(withYear != null) {
						return (car.getYear().toLowerCase() == withYear.toLowerCase());
					}
					return true;
				})
				.filter(car -> {
					if(withName != null){
						return (car.getName().toLowerCase() == withName.toLowerCase());
					}
					return true;
				})
				.skip(previousEntries)
				.limit(perPage)
				.collect(Collectors.toList());
	}
	
	public PagedResponse getCarsFilteredByYearPaginated
						(int page, int perPage, String withYear) {
		long previousEntries = page * perPage;
		List<Car> pageOfCars = carList.stream()
				.filter((u) -> u.getYear()
						.equals(withYear) 
						|| withYear == null)
				.skip(previousEntries)
				.limit(perPage)
				.collect(Collectors.toList());
		int totalPages = (int) Math.ceil((double) carList.size() / perPage);
		PagedResponse response = new PagedResponse(pageOfCars, page, totalPages);
		return response;
	}
	
	public PagedResponse getCarsFilteredByModelPaginated
						(int page, int perPage, String withModel) {
		long previousEntries = page * perPage;
		List<Car> pageOfCars = carList.stream()
				.filter((u) -> u.getModel()
						.equals(withModel) 
						|| withModel == null)
				.skip(previousEntries)
				.limit(perPage)
				.collect(Collectors.toList());
		int totalPages = (int) Math.ceil((double) carList.size() / perPage);
		PagedResponse response = new PagedResponse(pageOfCars, page, totalPages);
		return response;
	}
	
	public PagedResponse getCarsFilteredByBrandPaginated
						(int page, int perPage, String withBrand) {
		long previousEntries = page * perPage;
		List<Car> pageOfCars = carList.stream()
							.filter((u) -> u.getBrand()
									.equals(withBrand) 
									|| withBrand == null)
							.skip(previousEntries)
							.limit(perPage)
							.collect(Collectors.toList());
		int totalPages = (int) Math.ceil((double) carList.size() / perPage);
		PagedResponse response = new PagedResponse(pageOfCars, page, totalPages);
		return response;
	}
	
	public PagedResponse getCarsFilteredByNamePaginated
						(int page, int perPage, String withName) {
		long previousEntries = page * perPage;
		List<Car> pageOfCars = carList.stream()
										.filter((u) -> u.getName()
												.equals(withName) 
												|| withName == null)
										.skip(previousEntries)
										.limit(perPage)
										.collect(Collectors.toList());
		int totalPages = (int) Math.ceil((double) carList.size() / perPage);
		PagedResponse response = new PagedResponse(pageOfCars, page, totalPages);
		return response;
	}
	
	public PagedResponse getCarsPaginated(int page, int perPage) {
		long previousEntries = page * perPage;
		List<Car> pageOfCars = carList.stream()
										.skip(previousEntries)
										.limit(perPage)
										.collect(Collectors.toList());
		int totalPages = (int) Math.ceil((double) carList.size() / perPage);
		PagedResponse response = new PagedResponse(pageOfCars, page, totalPages);
		return response;
	}

}
