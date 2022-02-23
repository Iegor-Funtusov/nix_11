package ua.com.alevel;

//public class AuthUser implements Comparable<AuthUser> {
public class AuthUser{

    private final String email;
    private final String token;

    public AuthUser(String email, String token) {
        this.email = email;
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public String getToken() {
        return token;
    }

    @Override
    public String toString() {
        return "AuthUser{" +
                "email='" + email + '\'' +
                ", token='" + token + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AuthUser)) return false;

        AuthUser authUser = (AuthUser) o;

        if (email != null ? !email.equals(authUser.email) : authUser.email != null) return false;
        return token != null ? token.equals(authUser.token) : authUser.token == null;
    }

    @Override
    public int hashCode() {
        int result = email != null ? email.hashCode() : 0;
        result = 31 * result + (token != null ? token.hashCode() : 0);
        return result;
    }

//    @Override
//    public int compareTo(AuthUser o) {
//        return 0;
//    }
}
