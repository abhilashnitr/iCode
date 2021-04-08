Button.java: Common product interface
HtmlButton.java: Concrete product
WindowsButton.java: One more concrete product
Dialog.java: Base creator
HtmlDialog.java: Concrete creator
WindowsDialog.java: One more concrete creator
Demo.java:Client code


The Factory Method pattern suggests that you replace direct object construction calls (using the new operator) with calls to a special factory method. Don’t worry: the objects are still created via the new operator, but it’s being called from within the factory method. Objects returned by a factory method are often referred to as products.

here concrete creator has the factory method which creates the factory.

You avoid tight coupling between the creator and the concrete products.

Open/Closed Principle. You can introduce new types of products into the program without breaking existing client code.

Single Responsibility Principle. You can move the product creation code into one place in the program, making the code easier to support.
 
The code may become more complicated since you need to introduce a lot of new subclasses to implement the pattern. The best case scenario is when you’re introducing the pattern into an existing hierarchy of creator classes.

 