package giancarlogilos.com.f4f;

import org.junit.Test;

import core.LoginModel;
import core.LoginView;
import core.LoginPresenter;
import core.UserRepository;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.mockingDetails;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

/**
 * Created by pofay on 2/16/17.
 */

public class LoginPresenterTest {

    @Test
    public void ItsInvariantsMustBeSatisfied() {
        LoginModel model = null;
        LoginView view = null;

        try {
            new LoginPresenter(model, view);
            fail("Invariants must be satisfied");
        } catch (NullPointerException e) {

        }
    }

    @Test
    public void ViewMustNotBeNull() {
        UserRepository repository = mock(UserRepository.class);
        LoginModel model = new LoginModel(repository);
        LoginView view = null;
        try {
            new LoginPresenter(model, view);
            fail("Invariants must be satisfied");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void ItShouldNotInvokeAnyLogicOnConstruction() {
        UserRepository repository = mock(UserRepository.class);
        LoginModel model = new LoginModel(repository);
        LoginView view = mock(LoginView.class);
        LoginPresenter presenter = new LoginPresenter(model, view);

        verifyNoMoreInteractions(view);
    }


    @Test
    public void ItShouldTellTheViewWhenCredentialsAreInvalid() {
        UserRepository repository = mock(UserRepository.class);
        LoginModel model = new LoginModel(repository);
        LoginView view = mock(LoginView.class);
        LoginPresenter presenter = new LoginPresenter(model, view);

        presenter.onVerifyCredentials("INVALID_USERNAME", "INVALID_PASSWORD");

        verify(view).showCredentialsAreInvalid();
    }


    @Test
    public void ItShouldTellTheViewWhenEnteredCredentialsAreValid() {
        UserRepository repository = mock(UserRepository.class);
        LoginModel model = new LoginModel(repository);
        LoginView view = mock(LoginView.class);
        LoginPresenter presenter = new LoginPresenter(model, view);

        presenter.onVerifyCredentials("VALID_USERNAME", "VALID_PASSWORD");

        verify(view).showCredentialsAreValid();
    }

    @Test
    public void ItShouldNotShowInvalidCredentialsWhenCredentialsAreValid() {
        UserRepository repository = mock(UserRepository.class);
        LoginModel model = new LoginModel(repository);
        LoginView view = mock(LoginView.class);
        LoginPresenter presenter = new LoginPresenter(model, view);

        presenter.onVerifyCredentials("VALID_USERNAME", "VALID_PASSWORD");

        verify(view, never()).showCredentialsAreInvalid();
    }
}

