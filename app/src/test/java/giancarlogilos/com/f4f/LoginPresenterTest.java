package giancarlogilos.com.f4f;

import org.junit.Test;

import core.AuthorizationGateway;
import core.LoginModel;
import core.LoginPresenter;
import core.LoginView;
import core.SessionManager;

import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by Gilos on 2/28/2017.
 */

public class LoginPresenterTest {


  /*  @Test
    public void WhenLoginIsSuccessfulItTellsViewToGoToProfile() {
        AuthorizationGateway gateway = mock(AuthorizationGateway.class);
        SessionManager manager = mock(SessionManager.class);
        LoginModel model = new LoginModel(manager, gateway);
        LoginView view = mock(LoginView.class);
        LoginPresenter sut = new LoginPresenter(model, view);

        doAnswer(invocation -> {
           invocation.
        });

        sut.onLogin("USERNAME", "PASSWORD");

        verify(view).goToFinder();
    }*/
}
