package core;

/**
 * Created by pofay on 2/16/17.
 */
public class LoginModel {

    private final AuthorizationGateway gateway;
    private final SessionManager sessionManager;
    private final Event successfulLoginEvent;
    private final DataEvent<String> failedLoginEvent;

    public LoginModel(SessionManager sessionManager, AuthorizationGateway gateway) {
        this.sessionManager = sessionManager;
        this.gateway = gateway;
        this.failedLoginEvent = new DataEvent<String>();
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
        failedLoginEvent.addListener(listener);
    }

    public void onFailure(String message) {
        failedLoginEvent.dispatch(message);
    }
}

