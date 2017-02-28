package core;

import utils.Action;
import utils.GenericAction;
import utils.Maybe;

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

    }


}

