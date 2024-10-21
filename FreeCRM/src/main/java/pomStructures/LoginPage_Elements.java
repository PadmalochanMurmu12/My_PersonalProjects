package pomStructures;

public interface LoginPage_Elements {
	
	String LoginText= "//div[@class='ui fluid large blue submit button']";
	String emailField= "email", passwordField= "password", loginBtn= "Login";
	String err_Msg= "//*[text()='Something went wrong...']";
}
