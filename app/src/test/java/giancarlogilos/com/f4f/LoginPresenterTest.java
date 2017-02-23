package giancarlogilos.com.f4f;

import org.junit.Test;

import core.LoginModel;
import core.LoginView;
import core.LoginPresenter;
import core.SessionManager;
import core.User;
import core.UserCredentials;
import core.UserGateway;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by pofay on 2/16/17.
 */

public class LoginPresenterTest {

    @Test
    public void ItTellsTheSessionManagerToCreateASessionOnLogin() {
        User expectedUser = new User();
        UserGateway stubGateway = new MockUserGatewayBuilder()
                .setupWithCredentials("USERNAME", "PASSWORD")
                .toReturn(expectedUser)
                .build();
        SessionManager mockSessionManager = mock(SessionManager.class);
        LoginModel model = new LoginModel(mockSessionManager, stubGateway);
        LoginView dummyView = mock(LoginView.class);
        LoginPresenter sut = new LoginPresenter(model, dummyView);

        sut.onLogin("USERNAME", "PASSWORD");

        verify(mockSessionManager).createSessionFor(expectedUser);
    }

    @Test
    public void ItTellsViewToGoToProfileWhenLoginIsSuccessful() {
        User expectedUser = new User();
        UserGateway stubGateway = new MockUserGatewayBuilder()
                .setupWithCredentials("VALID_USERNAME", "VALID_PASSWORD")
                .toReturn(expectedUser)
                .build();
        SessionManager mockSessionManager = mock(SessionManager.class);
        LoginModel model = new LoginModel(mockSessionManager, stubGateway);
        LoginView view = mock(LoginView.class);
        LoginPresenter sut = new LoginPresenter(model, view);

        sut.onLogin("VALID_USERNAME", "VALID_PASSWORD");

        verify(view).goToProfile();
    }


}


