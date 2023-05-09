package taxi.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import taxi.lib.Injector;
import taxi.model.Car;
import taxi.model.Driver;
import taxi.model.Manufacturer;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarServiceImplTest {
    private static final Injector injector = Injector.getInstance("taxi");
    private final DriverService driverService =
            (DriverService) injector.getInstance(DriverService.class);
    private final CarService carService =
            (CarService) injector.getInstance(CarService.class);
    private final ManufacturerService manufacturerService =
            (ManufacturerService) injector.getInstance(ManufacturerService.class);

    private List<Driver> driversList;
    private Driver driver;
    private Car car;

    @BeforeEach
    void setUp() {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setCountry("TestCountry");
        manufacturer.setName("TestName");
        manufacturerService.create(manufacturer);

        driver = new Driver();
        driver.setLogin("testDriver");
        driver.setPassword("PasswordOfTestDriver$^&*%$&^*#GHI");
        driver.setLicenseNumber("hguayrgfwie849");
        driver.setName("George");
        driverService.create(driver);

        car = new Car();
        //driversList = new ArrayList<>();
        //driversList.add(driverService.get(driver.getId()));
        car.setDrivers(driversList);
        car.setModel("testModel");
        car.setManufacturer(manufacturerService.get(manufacturer.getId()));
        carService.create(car);
    }

    @Test
    public void add_DriverToCar_Ok() {
        carService.addDriverToCar(driverService.get(driver.getId()), carService.get(car.getId()));
        List<Driver> drivers = carService.get(car.getId()).getDrivers();
        boolean contains = drivers.contains(driver);
        assertTrue(contains);
    }

    @Test
    public void removeDriverFromCar() {
        carService.removeDriverFromCar(driver, car);
        driversList = new ArrayList<>();
        driversList.add(driverService.get(driver.getId()));
        List<Driver> drivers = carService.get(car.getId()).getDrivers();
        boolean contains = drivers.contains(driver);
        assertFalse(contains);
    }

    @Test
    void getAllByDriver() {
        driversList.add(driver);
        car.setDrivers(driversList);
        List<Car> allByDriver = carService.getAllByDriver(driver.getId());
        assertEquals(1, allByDriver.size());
        assertTrue(allByDriver.contains(car));
    }

    @Test
    void create() {
    }

    @Test
    void get() {
    }

    @Test
    void getAll() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

//    @AfterEach
//    void tearDown() {
//        carService.delete(car.getId());
//        manufacturerService.delete(manufacturer.getId());
//        driverService.delete(driver.getId());
//    }
}