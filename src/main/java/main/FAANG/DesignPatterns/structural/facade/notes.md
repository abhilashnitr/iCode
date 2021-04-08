Provide a unified interface to a set of interfaces in a subsystem. Facade defines a higher-level interface that makes the subsystem easier to use.
Wrap a complicated subsystem with a simpler interface.

Problem:
Imagine that you must make your code work with a broad set of objects that belong to a sophisticated library or framework. Ordinarily, you’d need to initialize all of those objects, keep track of dependencies, execute methods in the correct order, and so on.

As a result, the business logic of your classes would become tightly coupled to the implementation details of 3rd-party classes, making it hard to comprehend and maintain.

 Use the Facade pattern when you need to have a limited but straightforward interface to a complex subsystem.

 Use the Facade when you want to structure a subsystem into layers.
 
 
 How to use
 Identify a simpler, unified interface for the subsystem or component.
 Design a 'wrapper' class that encapsulates the subsystem.
 The facade/wrapper captures the complexity and collaborations of the component, and delegates to the appropriate methods.
 The client uses (is coupled to) the Facade only.
 Consider whether additional Facades would add value.
 
 
 
 You can isolate your code from the complexity of a subsystem.
 
  A facade can become a god object coupled to all classes of an app.


