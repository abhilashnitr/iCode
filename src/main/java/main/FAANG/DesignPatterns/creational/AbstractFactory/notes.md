Abstract Factory is a creational design pattern that lets you produce families of related objects without specifying their concrete classes.

Imagine that you’re creating a furniture shop simulator. Your code consists of classes that represent:

A family of related products, say: Chair + Sofa + CoffeeTable.

Several variants of this family. For example, products Chair + Sofa + CoffeeTable are available in these variants: Modern, Victorian, ArtDeco.



Map out a matrix of distinct product types versus variants of these products.

Declare abstract product interfaces for all product types. Then make all concrete product classes implement these interfaces.

Declare the abstract factory interface with a set of creation methods for all abstract products.

Implement a set of concrete factory classes, one for each product variant.

Create factory initialization code somewhere in the app. It should instantiate one of the concrete factory classes, depending on the application configuration or the current environment. Pass this factory object to all classes that construct products.

Scan through the code and find all direct calls to product constructors. Replace them with calls to the appropriate creation method on the factory object.


 You can be sure that the products you’re getting from a factory are compatible with each other.
 You avoid tight coupling between concrete products and client code.
 Single Responsibility Principle. You can extract the product creation code into one place, making the code easier to support.
 Open/Closed Principle. You can introduce new variants of products without breaking existing client code.
 
 The code may become more complicated than it should be, since a lot of new interfaces and classes are introduced along with the pattern.
 
 Button.java        This is the common interface for buttons family
 MacOSButton.java   This is a MacOS variant of a button.
 WindowsButton.java This is another variant of a button.
 Checkbox.java      Checkboxes is the second product family
 MacOSCheckbox.java This is a variant of a checkbox.
 WindowsCheckbox.java This is another variant of a checkbox.
 
 GUIFactory Abstract factory knows about all (abstract) product types.
 MacOSFactory.java: Concrete factory (macOS)
 WindowsFactory.java: Concrete factory (Windows)
 
 Application.java: Client code
 Demo.java: App configuration
 
 