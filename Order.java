package EnocaTest;

import java.util.List;
import java.util.ArrayList;
public class Order {
	

	private List<Product> items;
    private double price;
    private Customer customer;
    private Cart cart;
    

    public Order(Customer customer, Cart cart, List<Product> items) {
        this.customer = customer;
        this.cart = cart;
        this.items = items;
    }
 
  
  
    
  
    
    
  public void Listele() {
	  System.out.println("Product = " + items);
	  
	  
  }
  
  public void GetOrderForCode(int customerid) {
	  
	  System.out.print(items);
	  
  }
  
  public void placeOrder() {
      
      double totalPrice = cart.TotalAmount(); 
System.out.println("Your Balance is: "+ customer.getBalance() );
System.out.println("Amount to be Paid: " + totalPrice );

      if (customer.getBalance() >= totalPrice) {
       customer.deductFromBalance(totalPrice); 
          
      } else {

          System.out.println("Customer's balance is insufficient.");
      }
  }
  
  
  
  
  
    public void getAllOrdersForCustomer(Product product) {
    	 if (items == null) {
    	        items = new ArrayList<>();
    	    }

    	    boolean found = false;
    	    for (Product item : items) {
    	        if (item.getProductName().equals(product.getProductName())) {
    	            found = true;
    	            break;
    	        }
    	    }

    	    if (!found) {
    	        items.add(product);
    	    }
    }
    
    }
  
