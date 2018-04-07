package Advertisement;

import java.util.Scanner;

public class MainMenu {
    boolean exit;

    public void runMenu() throws Exception {
        printHead();
        while (!exit) {
            printMenu();
            int choice = getInput();
            performAction(choice);
        }
    }

    public void printMenu() {
        if (!Users.isIsLoggedIn()) {
            System.out.println("\nPlease, make your choice: ");
            System.out.println("1\t Registration");
            System.out.println("2\t Login user");
            System.out.println("0\t Exit program");
        } else {
            System.out.println("\nPlease, make your choice: ");
            System.out.println("1\t Registration");
            System.out.println("2\t Login user");
            System.out.println("3\t Add new advertisement");
            System.out.println("4\t Browse the advertisements");
            System.out.println("5\t Logout user");
            System.out.println("6\t Show user profile");
            System.out.println("7\t Change user profile");
            System.out.println("8\t Delete user profile");
            System.out.println("0\t Exit program");
        }
    }

    public void printHead() {
        System.out.println("+---------------------------------------+");
        System.out.println("+           Welcome to our              +");
        System.out.println("+            advertisement              +");
        System.out.println("+            info database              +");
        System.out.println("+---------------------------------------+");
    }

    public int getInput() {
        Scanner kb = new Scanner(System.in);
        int choice = -1;
        if (!Users.isIsLoggedIn()) {
            while (choice < 0 || choice > 2) {
                try {
                    System.out.print("\nEnter your choice: ");
                    choice = Integer.parseInt(kb.nextLine());
                } catch (NumberFormatException e) {
                    System.out.print("Invalid selection. Please, try again. ");
                }
            }
            return choice;
        } else {
            while (choice < 0 || choice > 8) {
                try {
                    System.out.print("\nEnter your choice: ");
                    choice = Integer.parseInt(kb.nextLine());
                } catch (NumberFormatException e) {
                    System.out.print("Invalid selection. Please, try again. ");
                }
            }
            return choice;
        }
    }

    public void performAction(int choice) throws Exception {
        Users user = new Users();
        if (!Users.isIsLoggedIn()) {
            switch (choice) {
                case 0:
                    exit = true;
                    System.out.println("Exiting the program.");
                    System.out.println("Good bye!");
                    break;
                case 1:
                    DbManagement.addUser();
                    break;
                case 2:
                    DbManagement.loginUser();
                    break;
                default:
                    System.out.println("An unknown error has occurred.");
            }
        } else {
            switch (choice) {
                case 0:
                    exit = true;
                    DbManagement.writeToFileUsers();
                    System.out.println("Exiting the program.");
                    System.out.println("Good bye!");
                    break;
                case 1:
                    DbManagement.addUser();
                    break;
                case 2:
                    DbManagement.loginUser();
                    break;
                case 3:
                    System.out.println("Add");
                    break;
                case 4:
                    System.out.println("Browse");
                    break;
                case 5:
                    DbManagement.logoutUser();
                    break;
                case 6:
                    System.out.println(DbManagement.activeUser.toString());
                    break;
                case 7:
                    DbManagement.editUser();
                    break;
                case 8:
                    DbManagement.deleteUser();
                    break;
                default:
                    System.out.println("An unknown error has occurred.");
            }
        }
    }
}
