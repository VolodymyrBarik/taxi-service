package taxi.service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import taxi.dao.DriverDao;
import taxi.lib.Inject;
import taxi.lib.Service;
import taxi.model.Driver;

@Service
public class DriverServiceImpl implements DriverService {
    private final static Logger logger = LogManager.getLogger(AuthenticationServiceImpl.class);
    @Inject
    private DriverDao driverDao;

    @Override
    public Driver create(Driver driver) {
        logger.info("create was called for driver={}", driver);
        return driverDao.create(driver);
    }

    @Override
    public Driver get(Long id) {
        logger.info("get was called with id={}", id);
        return driverDao.get(id).orElseThrow(() -> {
                    logger.error(new NoSuchElementException("Can't get driver by id: " + id));
                    return new NoSuchElementException("Can't get driver by id: " + id);
                }
        );
    }

    @Override
    public List<Driver> getAll() {
        logger.info("getAll was called");
        return driverDao.getAll();
    }

    @Override
    public Driver update(Driver driver) {
        logger.info("update was called for driver={}", driver);
        return driverDao.update(driver);
    }

    @Override
    public boolean delete(Long id) {
        logger.info("delete was called for driver.id={}", id);
        return driverDao.delete(id);
    }

    @Override
    public Optional<Driver> findByLogin(String login) {
        logger.info("findByLogin was called for login={}", login);
        return driverDao.findByLogin(login);
    }
}
