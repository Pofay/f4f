package giancarlogilos.com.f4f;

import org.junit.Test;

import core.AuthorizationGateway;
import core.AuthorizationToken;
import core.EventListener;
import core.LoginModel;
import core.SessionManager;
import core.UserCredentials;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by Gilos on 2/28/2017.
 */

public class LoginModelTest {

    @Test
    public void ItShouldDelegateAuthorizationToTheGateway() {
        UserCredentials credentials = new UserCredentials("USERNAME", "PASSWORD");
        AuthorizationGateway gateway = mock(AuthorizationGateway.class);
        SessionManager sessionManager = mock(SessionManager.class);
        LoginModel sut = new LoginModel(sessionManager, gateway);

        sut.createNewSession(credentials);

        verify(gateway).authorize(sut, credentials);
    }

    @Test
    public void ItShouldSaveTheAuthorizationTokenToTheSessionManagerOnSuccess() {
        AuthorizationGateway gateway = mock(AuthorizationGateway.class);
        SessionManager sessionManager = mock(SessionManager.class);
        LoginModel sut = new LoginModel(sessionManager, gateway);
        AuthorizationToken expectedToken = new AuthorizationToken("SOmeToken");

        sut.onSuccess(expectedToken);

        verify(sessionManager).createSessionFor(expectedToken);
    }

    @Test
    public void ItShouldDispatchToAnEventListenerOnSuccesfulLogin() {
        EventListener listener = mock(EventListener.class);
        AuthorizationGateway gateway = mock(AuthorizationGateway.class);
        SessionManager sessionManager = mock(SessionManager.class);
        LoginModel sut = new LoginModel(sessionManager, gateway);
        sut.addOnSuccessListener(listener);
        AuthorizationToken expectedToken = new AuthorizationToken("SOmeToken");

        sut.onSuccess(expectedToken);

        verify(listener).onDispatch();
    }


}
