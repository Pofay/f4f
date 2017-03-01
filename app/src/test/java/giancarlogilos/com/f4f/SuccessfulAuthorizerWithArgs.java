package giancarlogilos.com.f4f;

import core.AuthorizationGateway;
import core.AuthorizationToken;
import core.LoginModel;
import core.UserCredentials;

/**
 * Created by Gilos on 3/1/2017.
 */
public class SuccessfulAuthorizerWithArgs implements AuthorizationGateway {
    private final AuthorizationToken token;

    public SuccessfulAuthorizerWithArgs(AuthorizationToken expectedToken) {
        this.token = expectedToken;
    }

    @Override
    public void authorize(LoginModel model, UserCredentials credentials) {
        model.onSuccess(token);
    }
}
