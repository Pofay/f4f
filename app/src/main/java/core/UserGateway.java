package core;

/**
 * Created by pofay on 2/16/17.
 */
public interface UserGateway {

    Maybe<User> getUserWithCredentials(UserCredentials credentials);
}
