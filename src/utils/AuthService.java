package utils;



import model.User;

public class AuthService {
    private static User[] users = new User[3]; // Fixed-size array

    static {
        // Hardcoded users
        users[0] = new User("Suber", "Suber123", "admin");
        users[1] = new User("Awol", "awol123", "admin");
        users[2] = new User("mubarak", "mubarak123", "client");
    }

    public static User login(String username, String password) throws UserNotFoundException, IncorrectPasswordException {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                if (user.getPassword().equals(password)) {
                    return user;
                } else {
                    throw new IncorrectPasswordException("Incorrect password. Please try again.");
                }
            }
        }
        throw new UserNotFoundException("Username not found. Please register before you try to login or try again.");
    }
}
