package core;

/**
 * Created by pofay on 2/16/17.
 */
public class UserCredentials {
    public String password;
    public String username;

    public UserCredentials(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserCredentials that = (UserCredentials) o;

        if(username.equals(that.username) && (password.equals(that.password)))
            return true;
        else
            return false;

    }

    @Override
    public int hashCode() {
        int result = password != null ? password.hashCode() : 0;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        return result;
    }
}
