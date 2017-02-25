package core;

/**
 * Created by pofay on 2/16/17.
 */
public class LoginModel {

    private final AuthorizationGateway gateway;
    private final SessionManager sessionManager;

    public LoginModel(SessionManager sessionManager, AuthorizationGateway gateway) {
        this.sessionManager = sessionManager;
        this.gateway = gateway;
    }

    public void createNewSession(UserCredentials credentials, Action onSuccess, GenericAction<String> onFailure) {
        Maybe<AuthorizationToken> token = gateway.authorize(credentials);
        if (token.hasValue()) {
            sessionManager.createSessionFor(token.Value());
            onSuccess.execute();
        } else
            onFailure.execute("Invalid Username or Password");
        /*
        * authToken = gateway.authorize(credentials)
        * session.createSessionFor(credentials, authToken)
        * */
    }
}

