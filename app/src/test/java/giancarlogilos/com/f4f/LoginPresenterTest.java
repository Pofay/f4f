package giancarlogilos.com.f4f;

import org.junit.Test;

import core.LoginModel;
import core.LoginView;
import core.Presenter;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;

/**
 * Created by pofay on 2/16/17.
 */

public class LoginPresenterTest {

    @Test
    public void ItsInvariantsMustBeSatisfied() {
        LoginModel model = null;
        LoginView view = null;

        try {
            new Presenter(model, view);
            fail("Invariants must be satisfied");
        } catch (NullPointerException e) {

        }
    }

    @Test
    public void ViewMustNotBeNull() {
        LoginModel model = new LoginModel();
        LoginView view = null;

        try {
            new Presenter(model, view);
            fail("Invariants must be satisfied");
        } catch (NullPointerException e) {

        }
    }

}

