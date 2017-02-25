package core;

/**
 * Created by pofay on 2/16/17.
 */
public interface AuthorizationGateway {

    Maybe<AuthorizationToken> authorize(UserCredentials credentials);
}