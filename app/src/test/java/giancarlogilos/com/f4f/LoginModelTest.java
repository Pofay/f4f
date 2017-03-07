package giancarlogilos.com.f4f;

import org.junit.Test;

import core.AuthorizationGateway;
import core.AuthorizationToken;
import core.DataEventListener;
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
        AuthorizationToken expectedToken = new AuthorizationToken("SOmeToken");
        AuthorizationGateway gateway = new SuccessfulAuthorizerWithArgs(expectedToken);
        SessionManager sessionManager = mock(SessionManager.class);
        LoginModel sut = new LoginModel(sessionManager, gateway);

        sut.createNewSession(new UserCredentials("SUCCESS", "SUCCESS"));

        verify(sessionManager).createSessionFor(expectedToken);
    }

    // TODO Remove these two tests since these APIs(onSuccess, onFailure) are not invoked outside the system
    // TODO Design Principle: Test only the public API
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

    @Test
    public void ItShouldDispatchAnEventWithFailureMessageOnFailure() {
        DataEventListener<String> listener = mock(DataEventListener.class);
        AuthorizationGateway gateway = mock(AuthorizationGateway.class);
        SessionManager sessionManager = mock(SessionManager.class);
        LoginModel sut = new LoginModel(sessionManager, gateway);
        sut.addOnFailureListener(listener);
        String expectedMessage = "Failure Message";

        sut.onFailure(expectedMessage);

        verify(listener).onDispatch(expectedMessage);
    }


}
