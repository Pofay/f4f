package giancarlogilos.com.f4f;

import org.junit.Test;

import core.AuthorizationToken;
import core.LoginModel;
import core.LoginPresenter;
import core.SessionManager;
import core.Some;
import core.AuthorizationGateway;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by pofay on 2/16/17.
 */

public class LoginPresenterTest {

    @Test
    public void ItTellsTheSessionManagerToCreateASessionOnLogin() {
        AuthorizationToken expectedToken = new AuthorizationToken("ejb7");
        AuthorizationGateway stubGateway = new MockGateway()
                .setupWithCredentials("USERNAME", "PASSWORD")
                .toReturn(new Some<>(expectedToken))
                .build();
        SessionManager mockSessionManager = mock(SessionManager.class);
        LoginPresenter sut = new LoginPresenterBuilder()
                .withModel(new LoginModel(mockSessionManager, stubGateway))
                .build();

        sut.onLogin("USERNAME", "PASSWORD");

        verify(mockSessionManager).createSessionFor(expectedToken);
    }
/*

    @Test
    public void ItTellsViewToGoToProfileWhenLoginIsSuccessful() {
        AuthorizationGateway stubGateway = new MockGateway()
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
        AuthorizationGateway stubGateway = new MockGateway()
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
*/


}


