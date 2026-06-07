public class Report extends Product implements TransactionHistory {
    double revenue;
    public static String[][] transactions = {
        {"p10001","+5,-2,+7"},
        {"p10002","+10,-5,-1,+3"},
        {"p10003","+5,-2,+7"},
        {"p10004","+10,-5,-1,+3"}};

    public double getRevenue(String id) throws Exception {
        int index = getID(id);
        double price = (double) products[index][3];
        int sold = (int) products[index][4];
        revenue = price * -sold;
        return revenue;
    }

    @Override
    public void generateReport() throws Exception {
        System.out.println("\n     =====  PRODUCT REPORT  =====");
        System.out.println("\nID, NAME, STOCK, PRICE, SOLD, REVENUE");
        for (int i = 0; i < products.length; i++) {
            String id = (String) products[i][0];
            String name = (String) products[i][1];
            int stock = (int) products[i][2];
            double price = (double) products[i][3];
            int sold = (int) products[i][4];
            double revenue = (double) getRevenue(id);
            String line = id + ", " + name + ", " + stock + ", " + price + ", " + -sold + ", " + revenue;
            System.out.println(line);
        }
        System.out.println("\n    =============================");
    }

    public int getuser(String id) throws ProductNotFoundException {
        try {
            int index = -1;
            for (int i = 0; i < transactions.length; i++) {
                if (transactions[i][0].equals(id)) {
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

    @Override
    public void transact(String id,String newval) throws Exception {
        int index = getuser(id);
        transactions[index][1]=transactions[index][1]+ ",-" + newval;
    }

    @Override
    public void restock(String id, String newval) throws Exception {
        int index = getuser(id);
        transactions[index][1]=transactions[index][1]+ ",+" + newval;
    }

    public void newTran(String id){
        int rows = transactions.length + 1;
        String[][] newT = new String[rows][2];
        int j = 0;
        for (int i = 0; i < transactions.length; i++) {
                newT[j] = transactions[i];
                j++;
        }
        String[] newProd = {id,"0"};
        newT[rows-1] = newProd;
        transactions = newT;
    }

    @Override
    public void displayHistory(String id) throws Exception {
        int index = getuser(id);
        String line = transactions[index][1];
        System.out.println("Transactions: " + line);
    }
}
