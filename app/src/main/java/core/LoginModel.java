package core;

/**
 * Created by pofay on 2/16/17.
 */
public class LoginModel {

    private final AuthorizationGateway gateway;
    private final SessionManager sessionManager;
    private final Event successfulLoginEvent;

    public LoginModel(SessionManager sessionManager, AuthorizationGateway gateway) {
        this.sessionManager = sessionManager;
        this.gateway = gateway;
        this.successfulLoginEvent = new Event();
    }

    public void addOnSuccessListener(EventListener listener) {
        successfulLoginEvent.addListener(listener);
    }

    public void createNewSession(UserCredentials credentials) {
        gateway.authorize(this, credentials);
    }


    public void onSuccess(AuthorizationToken token) {
        sessionManager.createSessionFor(token);
        successfulLoginEvent.dispatch();
    }


    public void addOnFailureListener(DataEventListener<String> listener) {
    }

    public void onFailure(String expectedMessage) {

    }
}

