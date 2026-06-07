public interface TransactionHistory {

    public void transact(String id, String newval) throws Exception;
    public void restock(String id, String newval) throws Exception;
    public void displayHistory(String id) throws Exception;

}
