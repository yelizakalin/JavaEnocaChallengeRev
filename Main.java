package EnocaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Customer> customers = Customer.CustomerNameListele();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Please Enter your Name: ");
        String customerName = scanner.nextLine();
        Customer customer = new Customer(customerName,customers.size() + 1);
        Cart cart = new Cart();
        Order order = new Order(customer, cart, new ArrayList<>());
        //Order order = new Order();
        String productYn;

        int customerID = findCustomerIDByName(customers, customerName);
        if (customerID != -1) {
            System.out.println("Welcome");
        
        } else {
            System.out.println("Customer hasn't been found");
            System.out.println("Do you want to create an account? (Y/N)");
            String customerAnswer = scanner.nextLine();
            if (customerAnswer.equalsIgnoreCase("Y")) {
                //Customer newCustomer = new Customer(customerName, customers.size() + 1);
                customers.add(customer);
                System.out.println("Customer List:");
                for (Customer c : customers) {
                    System.out.println(c.getCustomerID() + ": " + c.getCustomerName());
                }
            } else if (customerAnswer.equalsIgnoreCase("N")) {
                System.out.println("See you again.");
                return; 
            } else {
                System.out.println("Invalid input. Exiting.");
                return;
            }
        }
        
        
        
        
        
        
        
        
        
        Product.ProductNameListele();
        List<Product> products = Product.ProductListele();
       

        boolean continueShopping = true;
        do {
            System.out.print("Do you would like to add to order?");
            String answer = scanner.nextLine();

            if (answer.equalsIgnoreCase("Y")) {
                System.out.print("Please Enter the product: ");
                String orderName = scanner.nextLine();
                Product product = Product.getProduct(products, orderName);

                if (product != null && product.getStockState() > 0) {
                    System.out.print("Please enter how many you want to add: ");
                    int input2 = scanner.nextInt();
                    scanner.nextLine(); 
                    cart.setItemStock(input2);
                    cart.addToCart(product, input2, product.getPrice());    

                    order.getAllOrdersForCustomer(product);
                    
                    
                    
                    
                    
                    
                    System.out.print("Do you want to update your cart? (Y/N): ");
                    String updateOption = scanner.nextLine();

                    if (updateOption.equalsIgnoreCase("Y")) {
                        System.out.print("Please enter the product name: ");
                        String newP = scanner.next();
                        System.out.print("Please enter " + newP+"s new stock: ");
                        int stockN = scanner.nextInt();
                        scanner.nextLine();
                        Product newProduct = findProductByName(products, newP);
                        
                        order.getAllOrdersForCustomer(newProduct);
                        
                        cart.updateCart(newProduct, stockN);
                    } else {
                        continueShopping = true;
                    }
                    
                    
                    
                    
                    
                    
                } else {
                    System.out.println("Product not found");
                    System.out.print("Do you would like to add a new product? ");
                     String answerNew = scanner.nextLine();
                    
                    if (answerNew.equalsIgnoreCase("Y")) {
                    	System.out.print("Please enter the stock: ");
                        int stock = scanner.nextInt();
                        System.out.print("Please enter the price: ");
                        double Unitprice = scanner.nextDouble();
                        scanner.nextLine();

                        Product newProduct = new Product(orderName, stock, Unitprice);
                        products.add(newProduct);
                        
                        
                        System.out.println("Product List:");
                        
                        
                        for (Product p : products) {
                        	
                        	System.out.println(p.getProductName() + ": "  + p.getStockState() + " - " + p.getPrice());
                        }
                    }
                    
                    
                    
                    
                    
                   
                    
                    
                }
            } else if (answer.equalsIgnoreCase("N")) {
                continueShopping = false; 
                
                
                order.GetOrderForCode(customerID);
               System.out.println("Total Order Amount: "+cart.TotalAmount());
               
               
               
               
               if (!cart.isEmpty()) {
                   System.out.print("Do you want to delete orders? Y/N:");
                   String emptyCart = scanner.next();

                   if (emptyCart.equalsIgnoreCase("Y")) {
                       System.out.print("Which product do you want to delete?");
                       String emptyProduct = scanner.next();
                       boolean productFound = false; 

                       for (Product product : cart.getItems()) {
                           if (product.getProductName().equalsIgnoreCase(emptyProduct)) {
                               productFound = true;
                               System.out.print("How many do you want to delete?");
                               int emptyStock = scanner.nextInt();
                               cart.removeFromCart(product, emptyStock);
                               break;
                           }
                       }

                       if (!productFound) {
                           System.out.println("The product you specified has not been added to the cart.");
                       }
                   } else if (emptyCart.equalsIgnoreCase("N")) {
                       System.out.println("Your order hasn't been deleted");
                   } else {
                       System.out.println(" Invalid input.");
                   }
               } else {
                   System.out.println("You haven't added any products to the cart yet.");
               }
               
           
               
               
               
               
               
               
               
               
               
               
            } else {
                System.out.println("Invalid input. Please enter Y or N.");
            }
            
          
            order.GetOrderForCode(customerID);
            
            
            
        
            
            
        } while (continueShopping);
        
        order.placeOrder();
     
    }
        
  
    private static Product findProductByName(List<Product> products, String input) {
        for (Product product : products) {
            if (product.getProductName().equalsIgnoreCase(input)) {
            
                return product;
            }
        }
        return null;
    }

    private static int findCustomerIDByName(List<Customer> customers, String name) {
        for (Customer customer : customers) {
            if (customer.getCustomerName().equalsIgnoreCase(name)) {
                return customer.getCustomerID();
            }
        }
        return -1;
    }
}
