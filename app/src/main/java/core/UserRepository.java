package core;

/**
 * Created by pofay on 2/16/17.
 */
public interface UserRepository {

    boolean verifyCredentials(UserCredentials credentials);
}
