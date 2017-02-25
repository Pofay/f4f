package giancarlogilos.com.f4f;

import core.AuthorizationToken;
import core.Maybe;
import core.UserCredentials;
import core.AuthorizationGateway;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Gilos on 2/23/2017.
 */

public class MockGateway {

    private AuthorizationGateway gateway;
    private UserCredentials credentials;
    private Maybe<AuthorizationToken> token;

    public MockGateway() {
        this.gateway = mock(AuthorizationGateway.class);
    }

    public MockGateway setupWithCredentials(String username, String password) {
        this.credentials = new UserCredentials(username, password);
        return this;
    }

    public MockGateway toReturn(Maybe<AuthorizationToken> token) {
        this.token = token;
        return this;
    }

    public AuthorizationGateway build() {
        when(gateway.authorize(credentials)).thenReturn(token);
        return gateway;
    }
}
