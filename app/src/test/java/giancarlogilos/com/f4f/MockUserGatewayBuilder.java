package giancarlogilos.com.f4f;

import core.Maybe;
import core.User;
import core.UserCredentials;
import core.UserGateway;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Gilos on 2/23/2017.
 */

public class MockUserGatewayBuilder {

    private UserGateway gateway;
    private UserCredentials credentials;
    private Maybe<User> user;

    public MockUserGatewayBuilder(){
        this.gateway = mock(UserGateway.class);
    }

    public MockUserGatewayBuilder setupWithCredentials(String username, String password){
        this.credentials = new UserCredentials(username, password);
        return this;
    }

    public MockUserGatewayBuilder toReturn(Maybe<User> user){
        this.user = user;
        return this;
    }

    public UserGateway build(){
        when(gateway.getUserWithCredentials(credentials)).thenReturn(user);
        return gateway;
    }
}
