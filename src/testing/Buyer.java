package testing;

public class Buyer extends Person {

	public void showMenu() {

	}
	@Override
	public void CreateProductMenu() {
		System.out.println("Menu is loaded.");
		if (theSelectedProduct.getProductCategory() == ProductMenu.ProductCategory.valueOf("MeatProductMenu").ordinal()) {
			productMenu = new MeatProductMenu(theSelectedProduct, ProductMenu.ProductCategory.MeatProductMenu);
		} else {
			productMenu = new ProduceProductMenu(theSelectedProduct, ProductMenu.ProductCategory.ProduceProductMenu);
		}
	}

}


