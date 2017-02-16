package giancarlogilos.com.f4f;

import org.junit.Test;

import core.LoginModel;
import core.UserCredentials;
import core.UserRepository;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by pofay on 2/16/17.
 */

public class LoginModelTest {

    @Test
    public void ItShouldReturnATrueForValidUserCredential() {
        UserRepository repository = mock(UserRepository.class);
        UserCredentials credentials =
                new UserCredentials("VALID_USERNAME", "VALID_PASSWORD");
        when(repository.verifyCredentials(credentials)).thenReturn(true);
        LoginModel model = new LoginModel(repository);

        boolean actual =
                model.verifyCredentials(credentials.username, credentials.password);

        assertTrue(actual);
    }

    @Test
    public void ItShouldReturnAFalseForAnInvalidUserCredential() {
        UserRepository repository = mock(UserRepository.class);
        UserCredentials credentials =
                new UserCredentials("INVALID_USERNAME", "INVALID_PASSWORD");
        when(repository.verifyCredentials(credentials)).thenReturn(false);
        LoginModel model = new LoginModel(repository);

        boolean actual =
                model.verifyCredentials(credentials.username, credentials.password);

        assertFalse(actual);
    }


}
