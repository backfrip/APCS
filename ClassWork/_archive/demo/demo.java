public class demo {
    public static void main(String[]args) {
	greeter bob,amy;
	bob = new greeter("Greetings... bah, humbug.");
	amy = new greeter("Konnichiwa");
	bob.greet();
	amy.greet();
    }
}