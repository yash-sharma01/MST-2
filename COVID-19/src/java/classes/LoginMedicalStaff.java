package classes;

public class LoginMedicalStaff {
    public boolean authenticate(String username, String password ){
        if (username.equalsIgnoreCase("medical") && password.equalsIgnoreCase("medical123"))
        {
            return true;
        }
        return false;
    }
}
