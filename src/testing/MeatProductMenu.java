package testing;

public class MeatProductMenu extends ProductMenu {

	public MeatProductMenu(Product theSelectedProduct, ProductCategory category) {
		super(theSelectedProduct, category);
	
	}

	public void showMenu() {
		System.out.println(" Meat Product Menu");

	}

	public void showAddButton() {
		System.out.println("Add Anybuttons");

	}

	public void showViewButton() {
		System.out.println("View Buttons");

	}

	public void showRadioButton() {
		System.out.println("Radio Buttons");

	}

	public void showLabels() {
		System.out.println("Labels Buttons");

	}

	public void showComboxes() {
		System.out.println("Comboxes");

	}

}
