import java.util.Arrays;

public abstract class Product extends FileHandler {
    public static Object[][] products;

    public static void loadProductsArray() throws Exception {
        String data = readFile("inventory.txt");
        String[] lines = data.split("\n");
        products = new Object[lines.length][5];
        for (int i = 0; i < lines.length; i++) {
            String[] columns = lines[i].split(",");
            products[i][0] = columns[0];
            products[i][1] = columns[1];
            products[i][2] = Integer.parseInt(columns[2]);
            products[i][3] = Double.parseDouble(columns[3]);
            products[i][4] = Integer.parseInt(columns[4]);
        }
    }

    public static void updateInventory() throws Exception {
        String data = "";
        for (int i = 0; i < products.length; i++) {
            for (int k = 0; k < products[i].length; k++) {
                data += products[i][k];
                if (k < products[i].length - 1) {
                    data += ",";
                }
            }
            data += "\n";
        }
        FileHandler.editFile("inventory.txt", data);
    }

    public static void addProduct(String id, String name, int stock, double price, int sold) throws Exception {
        int rows = products.length + 1;
        Object[][] newProducts = new Object[rows][5];
        int j = 0;
        for (int i = 0; i < products.length; i++) {
            newProducts[j] = products[i];
            j++;
        }
        Object[] newProd = { id, name, stock, price, sold };
        newProducts[rows - 1] = newProd;
        products = newProducts;
        updateInventory();
        Report t = new Report();
        t.newTran(id);
    }

    public static int getID(String id) throws ProductNotFoundException {
        try {
            int index = -1;
            for (int i = 0; i < products.length; i++) {
                if (products[i][0].equals(id)) {
                    index = i;
                    break;
                }
            }
            if (index == -1) {
                throw new ProductNotFoundException();
            }
            return index;
        } catch (ProductNotFoundException p) {
            System.out.println(p.getMessage());
            return -1;
        }
    }

    public static void removeProduct(String id) throws Exception {
        int index = getID(id);
        Object[][] newProducts = new Object[products.length - 1][5];
        int j = 0;
        for (int i = 0; i < products.length; i++) {
            if (i != index) {
                newProducts[j] = products[i];
                j++;
            }
        }
        products = newProducts;
        updateInventory();
    }

    public static void updateProduct(String id, int option, String newVal) throws Exception {
        int index = getID(id);
        switch (option) {
            case 1:
                products[index][0] = newVal;
                break;
            case 2:
                products[index][1] = newVal;
                break;
            case 3:
                products[index][2] = (Integer) products[index][2] + Integer.parseInt(newVal);
                Report t1 = new Report();
                t1.restock(id, newVal);
                break;
            case 4:
                products[index][3] = Double.parseDouble(newVal);
                break;
            case 5:
                products[index][4] = (Integer) products[index][4] - Integer.parseInt(newVal);
                products[index][2] = (Integer) products[index][2] - Integer.parseInt(newVal);
                Report t2 = new Report();
                t2.transact(id, newVal);
                break;
            default:
                System.out.println("Invalid option.");
                break;
        }
        updateInventory();
    }

    public static void getInventory() {
        System.out.println("PRODUCT: INVENTORY LEVEL");
        for (int i = 0; i < products.length; i++) {
            System.out.println(products[i][1] + " : " + products[i][2]);
        }
    }

    public static void getProduct(String id) throws Exception {
        int index = getID(id);
        //System.out.println(Arrays.deepToString(products[index]));
        System.out.println("ID: "+products[index][0]+"\nName: "+products[index][1]+"\nStock: "+
        products[index][2]+"\nPrice: "+products[index][3]+"\nSold:"+products[index][4]);
    }

    public static void lowStock() {
        System.out.println("low stock products:");
        for (int i = 0; i < products.length; i++) {
            String name = (String) products[i][1];
            int stock = (int) products[i][2];
            if (stock < 100) {
                System.out.println(name + " : " + stock);
            }
            ;
        }
    }

    abstract void generateReport() throws Exception;
}