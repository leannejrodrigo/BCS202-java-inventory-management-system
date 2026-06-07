public class Login extends FileHandler {
    private static String[][] users;
    public static boolean checkUser(String username, String password) throws Exception{
        String data = readFile("user.txt");
        String[] lines = data.split("\n");
        users = new String[lines.length][2];
        for(int i=0; i< lines.length; i++){
            if ( !lines[i].isEmpty() ) {
               users[i] = lines[i].split(",");
            }
        }
        for (int i = 0; i< users.length; i++){
            if (users[i][0].equals(username) && users[i][1].equals(password)) {
                return true;  // Login successful
            }
        }
        return false;
    }
}
