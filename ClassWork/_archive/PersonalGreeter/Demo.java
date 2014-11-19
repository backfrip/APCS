public class Demo{

    public static void main(String[]args){
	PersonalGreeter charles;
	PersonalGreeter stacy;
	PersonalGreeter ramone;

	charles = new PersonalGreeter();
	stacy = new PersonalGreeter("Samuel");
	ramone = new PersonalGreeter("Marissa","Good day,");

	System.out.println(charles.greet());
	System.out.println(stacy.greet());
	System.out.println(ramone.greet());

	charles.setName("Robert");
	System.out.println(charles.getName());

	stacy.setGreeting("What's up");
	System.out.println(stacy.getGreeting());

	System.out.println("'It's working! It's working! It's actually functioning properly!' ~ Heinz Doofenshmirtz");
    }
}