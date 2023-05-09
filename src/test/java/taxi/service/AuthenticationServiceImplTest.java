package taxi.service;

import org.junit.jupiter.api.Test;
import taxi.exception.AuthenticationException;
import taxi.lib.Injector;
import taxi.model.Driver;

import static org.junit.jupiter.api.Assertions.*;

class AuthenticationServiceImplTest {
    private static final Injector injector = Injector.getInstance("taxi");
    private final AuthenticationService authenticationService =
            (AuthenticationService) injector.getInstance(AuthenticationService.class);

    private final DriverService driverService = (DriverService) injector.getInstance(DriverService.class);

    private Driver defaultDriverSupplier() {
        Driver driver = new Driver();
        driver.setLogin("test");
        driver.setPassword("test");
        driver.setLicenseNumber("test");
        driver.setName("test");
        driver.setId(driverService.findByLogin("test").get().getId());
        return driver;
    }

    @Test
    void login_ExistingDriver_Ok() throws AuthenticationException {
        Driver driver = defaultDriverSupplier();
        Driver driver1 = authenticationService.login("test", "test");
        assertEquals(driver, driver1);
    }

    @Test
    void login_ExistingDriverWrongPassword_NotOk() {
        assertThrows(AuthenticationException.class, () -> {
            authenticationService.login("test", "111111");
        });
    }

    @Test
    void login_ExistingDriverEmptyPassword_NotOk() {
        assertThrows(AuthenticationException.class, () -> {
            authenticationService.login("test", null);
        });
    }

    @Test
    void login_NonExistingDriver_NotOk() {
        assertThrows(AuthenticationException.class, () -> {
            authenticationService.login("nonExistingDriver", "passOfNonExistingDriver");
        });
    }

    @Test
    void login_NullLogin_NotOk() {
        assertThrows(AuthenticationException.class, () -> {
            authenticationService.login("null", "null");
        });
    }
}