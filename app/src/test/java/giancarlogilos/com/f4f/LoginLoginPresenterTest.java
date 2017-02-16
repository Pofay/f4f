package giancarlogilos.com.f4f;

import org.junit.Test;

import core.LoginModel;
import core.LoginView;
import core.LoginPresenter;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

/**
 * Created by pofay on 2/16/17.
 */

public class LoginLoginPresenterTest {

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
        LoginModel model = new LoginModel();
        LoginView view = null;
        try {
            new LoginPresenter(model, view);
            fail("Invariants must be satisfied");
        } catch (NullPointerException e) {
        }
    }

    @Test
    public void ItShouldNotInvokeAnyLogicOnConstruction() {
        LoginModel model = new LoginModel();
        LoginView view = mock(LoginView.class);
        LoginPresenter presenter = new LoginPresenter(model, view);

        verifyNoMoreInteractions(view);
    }


    @Test
    public void ItShouldTellTheViewWhenCredentialsAreInvalid() {
        LoginModel model = new LoginModel();
        LoginView view = mock(LoginView.class);
        LoginPresenter presenter = new LoginPresenter(model, view);

        presenter.onVerifyCredentials("INVALID_USERNAME", "INVALID_PASSWORD");

        verify(view).showCredentialsAreInvalid();
    }


    @Test
    public void ItShouldTellTheViewWhenEnteredCredentialsAreValid() {
        LoginModel model = new LoginModel();
        LoginView view = mock(LoginView.class);
        LoginPresenter presenter = new LoginPresenter(model, view);

        presenter.onVerifyCredentials("VALID_USERNAME", "VALID_PASSWORD");

        verify(view).showCredentialsAreValid();
    }
}

