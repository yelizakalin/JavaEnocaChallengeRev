package EnocaTest;
import java.util.ArrayList;
import java.util.List;

public class Customer extends BaseEntity {

    private String CustomerName;
    private  int CustomerID;
    private double balance=300.0;
    private static List<Customer> customerList = CustomerNameListele();
    //private static int lastCustomerID = customerList.size();

    /*
    public  Customer(){

}

*/
    
    
    public  Customer(String CustomerName, int CustomerID){
    	    	super(CustomerName,CustomerID);
    	       this.CustomerName = CustomerName;
    	        this.CustomerID = CustomerID;
    }
    

    public String getCustomerName() {
        return CustomerName;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int customerID) {
        CustomerID = customerID;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public void addToBalance(double amount) {
        this.balance += amount;
    }

    public void deductFromBalance(double amount) {
        this.balance -= amount;
        System.out.println("Refundable Amount: "+ balance);
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public static List<Customer>  CustomerNameListele(){
    	List<Customer> customer = new ArrayList<>();
        customer.add(new Customer("Ayşe Benli",1));
        customer.add(new Customer("Kieun Choie",2));
        customer.add(new Customer("Yeliz Akalın",3));
        return  customer;
        
      
    }
    
    public static void AddCustomer(Customer customer) {
   	customerList.add(customer);
    	
    }
    
    
}
