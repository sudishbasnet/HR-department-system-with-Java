package Test;

import controller.*;
import model.*;
import view.*;

public class System {
	public static void main(String args[]) throws ClassNotFoundException{
		
		LoginView l=new LoginView();
		l.addLogin();
		LoginModel m=new LoginModel();
		LoginController c=new LoginController(l,m);
		c.login();

		
		
		
		
	}

}
