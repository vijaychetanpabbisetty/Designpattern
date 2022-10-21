package testing;

import java.io.BufferedReader;
//import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Facade {

	private int UserType;

	private Product theSelectedProduct;

	private int nProductCategory;

	ClassProductList classProductList = new ClassProductList();

	Person thePerson;

	@SuppressWarnings("static-access")
	public boolean login(UserInfoItem userinfodetail) throws IOException {
		System.out.println("Enter your UserName: ");
		Scanner sc = new Scanner(System.in);
		String userName = sc.next();
		userinfodetail.setUserName(userName);
		System.out.println("Enter your Password: ");
		String password = sc.next();
		userinfodetail.setPassword(password);
		while (true) {
			System.out.println("Choose your options: ");
			System.out.println("0. Buyer's Login ");
			System.out.println("1. Seller's Login ");
			UserType = sc.nextInt();
			if (UserType == 0) { 
				userinfodetail.setUserType(userinfodetail.userTypes.BUYER);
				break;
			} else if (UserType == 1) {
				userinfodetail.setUserType(userinfodetail.userTypes.SELLER);
				break;
			} else {
				System.out.println("Select the correct details ");
			} 
			sc.close();
		}
		System.out.println("Logging as " + userinfodetail.getUserType());
		Login login = new Login();
		boolean loginattempt = login.validateCredentials(userinfodetail);
		if (loginattempt) {
			System.out.println("Login granted");
			return true;
		} else {
			System.out.println("Login Failed");
			return false;
		}
	}

	public void addTrading() {

	}

	public void viewTrading() {

	}

	public void decideBidding() {

	}

	public void discussBidding() {

	}

	public void submitBidding() {

	}

	public void remind() {
		System.out.println("Visitor Design");
		System.out.println(" Perform functionalities on \r\n"
				+ "structure keeping the elements of the class same \n");
		Reminder remind = new Reminder();
		remind.checkProductRemainder(classProductList);

	}

	public void createUser(UserInfoItem userinfoitem) {
		System.out.println("Create different types of user" + userinfoitem.getUserType());
		if (userinfoitem.getUserType() == UserInfoItem.UserType.BUYER) {
			
			thePerson = new Buyer();

		} else {
			
			thePerson = new Seller();
		}
		thePerson.setUserName(userinfoitem.getUserName());

	}

	public void createProductList() throws IOException {
		try {
			try {
				System.out.println("Create some list of products for person " + thePerson.getUserName());
			} catch (Exception e) {
			
				e.printStackTrace();
			}
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		System.out.println("entered here");

		classProductList.readProductFromFile();

	}

	
	public void AttachProductToUser() throws IOException{
		try {
			System.out.println("Attaching products to " + thePerson.getUserName());
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\pabbi\\Desktop\\Designpattern-main\\DP515\\bin\\Database\\UserProduct.txt"));
		String line = null;
		while ((line = br.readLine()) != null) {
			String[] nameNdProduct = line.split(":");
			if (nameNdProduct[0].equals(thePerson.getUserName())) {
				for (Product c : classProductList) {
					if (c.getProductName().equals(nameNdProduct[1])) {
						thePerson.addProduct(c);
					}
				}
			}
		}

	}

	@SuppressWarnings("unchecked")
	public Product SelectProduct() {
		System.out.println("Design for Iterator ");
		System.out.println(
				"It iterates over the list of products for the chosen product by :" + thePerson.getUserName());
		@SuppressWarnings("rawtypes")
		ProductIterator pi = new ProductIterator(thePerson.getProductList());
		int a = 0;
		while (pi.hasNext()) {
			System.out.println(a + ")" + pi.Next().getProductName());
			a++;
		}
		Scanner sc = new Scanner(System.in);
		System.out.println("Select a product :");
		int selection = sc.nextInt();
		System.out.println("0. MeatProductMenu");
		System.out.println("1. ProduceProductMenu");
		System.out.println("Select a product category:");
		nProductCategory = sc.nextInt();
		theSelectedProduct = new Product(thePerson.getProductList().get(selection).getProductName(),nProductCategory);
		thePerson.setSelectedProduct(theSelectedProduct);
		sc.close();
		System.out.println(
				"Choosen product is " + theSelectedProduct.getProductName() + " from category " + ProductMenu.ProductCategory.values()[nProductCategory]);
		
		return theSelectedProduct;
	}
	
	

	public void productOperation() {
		int i = 1;
		System.out.println("Select Functionality");
		System.out.println(i + ")" + "Load products");
		i++;
		System.out.println(i + ")" + "Show the products selected");
		i++;
		System.out.println(i + ")" + "Add another product");
		i++;
		if (thePerson instanceof Buyer) {
			System.out.println(i + ")" + "Remind");
			i++;
		}
		System.out.println(i + ")" + "Logout");
		Scanner sc = new Scanner(System.in);
		int selectedOperation = sc.nextInt();
		switch (selectedOperation) {
		case 1:
			selectedOperation = 1; {
			System.out.println("Design for Factory");
			System.out.println("Processing product menu based on the category of the selected product\n");
			thePerson.CreateProductMenu();
			break;
		}
		case 2:
			selectedOperation = 2; {
			if (thePerson.productMenu != null) {
				System.out.println("Design for Bridge");
				System.out.println("Displays products based on the category of the selected product and login \n");
				thePerson.productMenu.showMenu();
			} else {
				System.out.println("Design for Factory");
				System.out.println("Processing product menu based on the category of the selected product\n");
				thePerson.CreateProductMenu();
			}
			break;
		}
		case 3:
			selectedOperation = 3; {
			SelectProduct();
			break;
		}
		case 4:
			selectedOperation = 4; {
			if (i == 5) {
				remind();
			} else {
				System.out.println("Logout successful for the username" + thePerson.getUserName());
				System.exit(0);
			}
			break;
		}
		case 5:
			selectedOperation = 5;
			selectedOperation = 4; {
			System.out.println("Logout success");
			System.exit(0);
			break;
		}
		}
		sc.close(); 

	}

}
