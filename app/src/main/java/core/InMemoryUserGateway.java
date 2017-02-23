package core;

/**
 * Created by Gilos on 2/23/2017.
 */

public class InMemoryUserGateway implements UserGateway {
    @Override
    public Maybe<User> getUserWithCredentials(UserCredentials credentials) {
        if (credentials.username.equals("VALID_USERNAME") && (credentials.password.equals("VALID_PASSWORD"))) {
            return new Some<>(new User());
        } else
            return new None<>();
    }
}
