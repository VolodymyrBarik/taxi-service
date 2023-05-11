package taxi.service;

import java.util.List;
import java.util.NoSuchElementException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import taxi.dao.ManufacturerDao;
import taxi.lib.Inject;
import taxi.lib.Service;
import taxi.model.Manufacturer;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {
    private static final Logger logger = LogManager.getLogger(ManufacturerServiceImpl.class);
    @Inject
    private ManufacturerDao manufacturerDao;

    @Override
    public Manufacturer create(Manufacturer manufacturer) {
        logger.info("create was called for manufacturer={}", manufacturer);
        return manufacturerDao.create(manufacturer);
    }

    @Override
    public Manufacturer get(Long id) {
        logger.info("get was called for id={}", id);
        return manufacturerDao.get(id).orElseThrow(() -> {
                    logger.error(new NoSuchElementException("Can't get manufacturer by id: " + id));
                    return new NoSuchElementException("Can't get manufacturer by id: " + id);
                }
        );
    }

    @Override
    public List<Manufacturer> getAll() {
        logger.info("getAll was called");
        return manufacturerDao.getAll();
    }

    @Override
    public Manufacturer update(Manufacturer manufacturer) {
        logger.info("update was called for manufacturer={}", manufacturer);
        return manufacturerDao.update(manufacturer);
    }

    @Override
    public boolean delete(Long id) {
        logger.info("delete was called for manufacturer.id={}", id);
        return manufacturerDao.delete(id);
    }
}
