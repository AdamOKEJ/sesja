public class Session {
    private static String username;
    private static String role;

    public static void login(String user, String userRole) {
        username = user;
        role = userRole;
    }

    public static String getUsername() { return username; }
    public static String getRole() { return role; }
    public static void logout() { username = null; role = null; }
}
