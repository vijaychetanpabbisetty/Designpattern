package testing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class ClassProductList extends ArrayList<Product> {

	
	public void accept(NodeVisitor visitor) {

	}
	public void readProductFromFile() throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\pabbi\\Desktop\\Designpattern-main\\DP515\\bin\\Database\\ProductInfo.txt"));
		String line = null;
		while ((line = br.readLine()) != null) {
			Product product = new Product(line, 0);
			add(product);
		}
			br.close();
	}

}
