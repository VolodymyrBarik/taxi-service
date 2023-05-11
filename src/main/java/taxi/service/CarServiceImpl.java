package taxi.service;

import java.util.List;
import java.util.NoSuchElementException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import taxi.dao.CarDao;
import taxi.lib.Inject;
import taxi.lib.Service;
import taxi.model.Car;
import taxi.model.Driver;

@Service
public class CarServiceImpl implements CarService {
    private static final Logger logger = LogManager.getLogger(CarServiceImpl.class);

    @Inject
    private CarDao carDao;

    @Override
    public void addDriverToCar(Driver driver, Car car) {
        logger.info("addDriverToCar was called with driver={}, car={}", driver, car);
        car.getDrivers().add(driver);
        carDao.update(car);
    }

    @Override
    public void removeDriverFromCar(Driver driver, Car car) {
        logger.info("removeDriverFromCar was called with driver={}, car={}", driver, car);
        car.getDrivers().remove(driver);
        carDao.update(car);
    }

    @Override
    public List<Car> getAllByDriver(Long driverId) {
        logger.info("getAllByDriver was called");
        return carDao.getAllByDriver(driverId);
    }

    @Override
    public Car create(Car car) {
        logger.info("createCar was called with car={}", car);
        return carDao.create(car);
    }

    @Override
    public Car get(Long id) {
        logger.info("getCar was called with id={}", id);
        return carDao.get(id).orElseThrow(() -> {
                    logger.error(new NoSuchElementException("Can't get car by id: " + id));
                    return new NoSuchElementException("Can't get car by id: " + id);
                }
        );
    }

    @Override
    public List<Car> getAll() {
        logger.info("getAll was called");
        return carDao.getAll();
    }

    @Override
    public Car update(Car car) {
        logger.info("update was called for car={}", car);
        return carDao.update(car);
    }

    @Override
    public boolean delete(Long id) {
        logger.info("delete was called for car.id={}", id);
        return carDao.delete(id);
    }
}
