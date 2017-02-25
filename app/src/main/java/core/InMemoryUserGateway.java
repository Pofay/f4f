package core;

/**
 * Created by Gilos on 2/23/2017.
 */

public class InMemoryUserGateway implements AuthorizationGateway {
    @Override
    public Maybe<AuthorizationToken> authorize(UserCredentials credentials) {
        if (credentials.username.equals("VALID_USERNAME") && (credentials.password.equals("VALID_PASSWORD"))) {
            return new Some<>(new AuthorizationToken("Something"));
        } else
            return new None<>();
    }
}
