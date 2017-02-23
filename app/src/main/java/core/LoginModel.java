package core;

/**
 * Created by pofay on 2/16/17.
 */
public class LoginModel {

    private final UserGateway gateway;
    private final SessionManager sessionManager;

    public LoginModel(SessionManager sessionManager, UserGateway gateway) {
        this.sessionManager = sessionManager;
        this.gateway = gateway;
    }

    public void createNewSession(UserCredentials credentials){
        User user = gateway.getUserWithCredentials(credentials);
        sessionManager.createSessionFor(user);
    }
}
