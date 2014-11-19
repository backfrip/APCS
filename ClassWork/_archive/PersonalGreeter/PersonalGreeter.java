public class PersonalGreeter{
    //instance variables
    private String greeting,name;

    //constructors
    public PersonalGreeter(){
	name = "Bob";
	greeting = "Hello";
    }

    public PersonalGreeter(String name){
	setName(name);
	setGreeting("Hello");
    }

    public PersonalGreeter(String name, String greeting){
	this.name = name;
	this.greeting = greeting;
    }

    //set/get methods
    public String getName(){
	return name;
    }

    public String getGreeting(){
	return greeting;
    }

    public void setName(String name){
	this.name = name;
    }

    public void setGreeting(String greeting){
	this.greeting = greeting;
    }

    //greet method
    public String greet(){
	return getGreeting() + " " + getName();
    }

}
