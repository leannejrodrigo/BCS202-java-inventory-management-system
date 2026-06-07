import java.util.InputMismatchException;
import java.util.Scanner;

public class InventoryManagementSystem {
    public static void main(String[] args) throws Exception {
        Product.loadProductsArray();
        Scanner input = new Scanner(System.in);
        System.out.println("enter username: ");
        String user = input.nextLine();
        System.out.println("enter password: ");
        String pass = input.nextLine();
        try{
        if (Login.checkUser(user,pass) ) {
            System.out.println("Successfully logged in.");
            boolean cont = true;
            while (cont) {
                System.out.println("\n\n");
                System.out.println("WELCOME\nEnter your choice number:\n1.Add product\n2.Remove Product\n"+
                "3.Update product.\n4.Display Inventory level\n5.Generate Report\n6.Product detail\n"+
                "7.Low Stock Products\n8.display transactions\n9.EXIT");
                int choice = input.nextInt();
                input.nextLine();
                switch (choice){
                    case 1:
                        System.out.println("enter product ID: ");
                        String id = input.nextLine();
                        System.out.println("enter product name: ");
                        String name = input.nextLine();
                        System.out.println("enter stock available: ");
                        int stock = input.nextInt();
                        System.out.println("enter product price: ");
                        double price = input.nextDouble();
                        input.nextLine();
                        Product.addProduct(id,name,stock,price,0);
                        System.out.println("Product added successfully.");
                        break;
                    case 2:
                        System.out.println("enter Product ID:");
                        String pID = input.nextLine();
                        Product.removeProduct(pID);
                        System.out.println("Product removed successfully.");
                        break;
                    case 3:
                        System.out.println("enter Product ID:");
                        String prd = input.nextLine();
                        System.out.println("What do you want to update? Choose Number:\n"+
                        "1.Product ID\n2.Product Name\n3.add to Stock\n4.Product Price\n5.Process Sale\n");
                        int option = input.nextInt();
                        input.nextLine();
                        System.out.println("enter value: ");
                        String newVal = input.nextLine();
                        Product.updateProduct(prd, option, newVal);
                        System.out.println("Product updated successfully.");
                        break;
                    case 4:
                        Product.getInventory(); 
                        break;
                    case 5:
                        Report r1 = new Report();
                        r1.generateReport();
                        break;
                    case 6:
                        System.out.println("enter product ID: ");
                        String prod = input.nextLine();
                        System.out.println("Product detail: ");
                        Product.getProduct(prod);
                        break;
                    case 7:
                        Product.lowStock();
                        break;
                    case 8:
                        Report transactions = new Report();
                        System.out.println("enter product ID: ");
                        String tranID = input.nextLine();
                        transactions.displayHistory(tranID);
                        break;
                    case 9:
                        System.out.println("PROGRAM EXITED.");
                        cont = false;
                        break;
                    default:
                        System.out.println("Invalid number.");
                        break;
                }
            }
            input.close();
        }
        else{
            input.close();
            throw new InvalidLoginException();
        }
        } catch(InvalidLoginException l){
            
            System.out.println(l.getMessage());
        } catch (InputMismatchException i) {
            System.out.println("error: the entered input is of wrong type.");
        } catch (Exception e) {
            System.out.println("Sorry! an error occured.");
        }
    }
}
