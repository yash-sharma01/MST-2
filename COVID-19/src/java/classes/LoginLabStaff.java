package classes;
public class LoginLabStaff {
    public boolean authenticate(String username, String password ){
        if (username.equalsIgnoreCase("lab") && password.equalsIgnoreCase("lab123"))
        {
            return true;
        }
        return false;
    }
}
