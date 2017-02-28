package core;

/**
 * Created by Gilos on 2/28/2017.
 */
public interface AuthorizationGateway {
    void authorize(UserCredentials credentials);
}
