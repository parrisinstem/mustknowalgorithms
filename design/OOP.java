// Package declaration for the 'design' package

// Java Program to implement Java Abstraction

// Abstraction: An abstract class 'Animal' is defined, representing the concept of an animal.
abstract class Animal {
    // Encapsulation: A private instance variable 'name' is used to store the name of the animal, and it's accessible via getter method 'getName()'.
	private String name;

    // Constructor: A parameterized constructor is defined to initialize the 'name' variable when creating an instance of the 'Animal' class.
	public Animal(String name) { this.name = name; }

    // Abstract method: The abstract method 'makeSound()' is declared without implementation, enforcing subclasses to provide their own implementation.
	public abstract void makeSound();

    // Encapsulation: A getter method 'getName()' is provided to access the private 'name' variable.
	public String getName() { return name; }

    // Polymorphism: A method 'introduceYourself()' is defined, which can be overridden by subclasses to provide their own implementation.
    public void introduceYourself() {
        System.out.println("Hi, I'm " + name + ".");
    }
}

// Inheritance: A class 'Cat' extends the 'Animal' class, inheriting its properties and behaviors.
class Cat extends Animal {
    // Constructor: The constructor of the 'Cat' class calls the constructor of the superclass 'Animal' using 'super(name)' to initialize the name.
    public Cat(String name) {
        super(name);
    }

    // Override: The 'makeSound()' method is overridden in the 'Cat' class to provide a specific implementation for the 'Cat' sound.
    @Override
    public void makeSound() {
        System.out.println("Meow!");
    }

    // Override: The 'introduceYourself()' method is overridden to provide a specific introduction for a cat.
    @Override
    public void introduceYourself() {
        System.out.println("Meow, I'm a cat named " + getName() + ".");
    }
}

// Inheritance: A class 'Dog' extends the 'Animal' class, inheriting its properties and behaviors.
class Dog extends Animal {
    // Constructor: The constructor of the 'Dog' class calls the constructor of the superclass 'Animal' using 'super(name)' to initialize the name.
    public Dog(String name) { super(name); }

    // Override: The 'makeSound()' method is overridden in the 'Dog' class to provide a specific implementation for the 'Dog' sound.
    @Override
    public void makeSound() {
        System.out.println(getName() + " barks");
    }
}

// The code includes various Object-Oriented Programming (OOP) principles:
// - Abstraction: The 'Animal' class is abstract, providing the concept of an animal without a complete implementation of the 'makeSound()' method.
// - Encapsulation: The 'name' variable is declared private and accessed using the getter method 'getName()', providing data hiding and encapsulation.
// - Inheritance: The 'Cat' and 'Dog' classes extend the 'Animal' class, inheriting its properties and methods.
// - Polymorphism: The 'introduceYourself()' method is present in the 'Animal' class and can be overridden by its subclasses to provide specific behavior.
