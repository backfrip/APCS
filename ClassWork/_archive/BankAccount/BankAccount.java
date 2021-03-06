public class BankAccount{
    private double balance;
    private int account;
    private String username;
    private String password;
    private int pin;

    // constructor
    public BankAccount(double balance, int account, String username, String password, int pin){
	this.balance = balance;
	this.account = account;
	this.username = username;
	this.password = password;
	this.pin = pin;
    }

    // set methods
    public void setBalance(double balance){
	this.balance = balance;
    }

    public void setAccount(int account){
	this.account = account;
    }

    public void setUsername(String username){
	this.username = username;
    }

    public void setPassword(String password){
	this.password = password;
    }

    public void setPin(int pin){
	this.pin = pin;
    }

    // deposit method
    public void makeDeposit(float deposit){
	balance += deposit;
    }

    // withdraw method
    public boolean makeWithdrawl(float withdrawl){
	if (balance >= withdrawl){
	    balance -= withdrawl;
	    return true;
	}
	return false;
    }

    // print method
    public void print(){
	System.out.println("Current Balance: " + balance);
	System.out.println("Account Number: " + account);
	System.out.println("Username: " + username);
	System.out.println("Password: " + password);
	System.out.println("PIN: " + pin);
    }

}