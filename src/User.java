import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public abstract class User {
    private String username;
    private String password;
    private final DiceRoller diceRoller;

    public User() {
        diceRoller = new DiceRoller();
    }

    public void createAccount(){
        try(FileWriter file = new FileWriter("logins.csv");){
            Scanner scan = new Scanner(System.in);
            System.out.println("Please Enter a Username: ");
            file.write("" + scan.next());
            System.out.println("Please Enter a Password: ");
            file.write("," + scan.next());
            file.close();
            assignAccount();
            System.out.println();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void assignAccount(){
        try(Scanner scan = new Scanner(new File("logins.csv"))){
            String[] users = scan.nextLine().split(",");
            this.username = users[0];
            this.password = users[1];
            scan.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private boolean loginCheck(String username, String password){
        if(this.username.equals(username.trim()) && this.password.equals(password.trim())){
            System.out.print("Username and Password Correct!");
            return true;
        }
        return false;
    }

    public void login(){
        try(Scanner scan = new Scanner(new File("logins.csv"))){
            String[] users = scan.nextLine().split(",");
            this.username = users[0];
            this.password = users[1];
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
