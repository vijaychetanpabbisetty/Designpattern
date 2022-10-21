package testing;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Login {
	public boolean validateCredentials(UserInfoItem userinfoitem) throws IOException {

		BufferedReader br = null;
		if (userinfoitem.userTypes.equals(UserInfoItem.UserType.BUYER)) {
			br = new BufferedReader(new FileReader("C:\\Users\\pabbi\\Desktop\\Designpattern-main\\DP515\\bin\\Database\\BuyerInfo.txt"
					+ ""));
		} else if (userinfoitem.userTypes.equals(UserInfoItem.UserType.SELLER)) {
			br = new BufferedReader(new FileReader("C:\\Users\\pabbi\\Desktop\\Designpattern-main\\DP515\\bin\\Database\\SellerInfo.txt"));
		}
		String line = null;
		while ((line = br.readLine()) != null) {
			String[] credentials = line.split(":");
			if (credentials[0].equals(userinfoitem.getUserName())
					&& credentials[1].equals(userinfoitem.getPassword())) {
				return true;
			}
		}
		return false;
	}

}
