package giancarlogilos.com.f4f;

import org.junit.Test;

import core.LoginModel;
import core.LoginView;
import core.LoginPresenter;
import core.None;
import core.SessionManager;
import core.Some;
import core.User;
import core.UserGateway;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by pofay on 2/16/17.
 */

public class LoginPresenterTest {

    @Test
    public void ItTellsTheSessionManagerToCreateASessionOnLogin() {
        User expectedUser = new User();
        UserGateway stubGateway = new MockUserGatewayBuilder()
                .setupWithCredentials("USERNAME", "PASSWORD")
                .toReturn(new Some<>(expectedUser))
                .build();
        SessionManager mockSessionManager = mock(SessionManager.class);
        LoginPresenter sut = new LoginPresenterBuilder()
                .withModel(new LoginModel(mockSessionManager, stubGateway))
                .build();

        sut.onLogin("USERNAME", "PASSWORD");

        verify(mockSessionManager).createSessionFor(expectedUser);
    }

    @Test
    public void ItTellsViewToGoToProfileWhenLoginIsSuccessful() {
        UserGateway stubGateway = new MockUserGatewayBuilder()
                .setupWithCredentials("VALID_USERNAME", "VALID_PASSWORD")
                .toReturn(new Some<>(new User()))
                .build();
        LoginView view = mock(LoginView.class);
        LoginPresenter sut = new LoginPresenterBuilder()
                .withModel(new LoginModel(mock(SessionManager.class), stubGateway))
                .withView(view)
                .build();

        sut.onLogin("VALID_USERNAME", "VALID_PASSWORD");

        verify(view).goToProfile();
    }

    @Test
    public void ItTellsViewToDisplayFailureMessageWhenLoginIsUnsuccesful() {
        UserGateway stubGateway = new MockUserGatewayBuilder()
                .setupWithCredentials("INVALID_USERNAME", "INVALID_PASSWORD")
                .toReturn(new None<>())
                .build();
        LoginView view = mock(LoginView.class);
        LoginPresenter sut = new LoginPresenterBuilder()
                .withModel(new LoginModel(mock(SessionManager.class), stubGateway))
                .withView(view)
                .build();

        sut.onLogin("INVALID_USERNAME", "INVALID_PASSWORD");

        verify(view).showFailureMessage("Invalid Username or Password");
    }


}


