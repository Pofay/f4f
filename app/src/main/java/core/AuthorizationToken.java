package core;

/**
 * Created by Gilos on 2/25/2017.
 */
public class AuthorizationToken {
    public final String token;

    public AuthorizationToken(String authorizationString) {
        this.token = authorizationString;
    }
}
