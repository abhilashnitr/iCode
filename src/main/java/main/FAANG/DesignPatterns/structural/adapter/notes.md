Convert the interface of a class into another interface clients expect.
Wrap an existing class with a new interface.
Adapter is a structural design pattern that allows objects with incompatible interfaces to collaborate.Adapter is a structural design pattern that allows objects with incompatible interfaces to collaborate.

Problem:
Imagine that you’re creating a stock market monitoring app. The app downloads the stock data from multiple sources in XML format and then displays nice-looking charts and diagrams for the user.

At some point, you decide to improve the app by integrating a smart 3rd-party analytics library. But there’s a catch: the analytics library only works with data in JSON format.

Solution:
You can create an adapter. This is a special object that converts the interface of one object so that another object can understand it.





RoundHole.java: Round holes RoundHoles are compatible with RoundPegs   
RoundPeg.java: Round pegs  (RoundPegs are compatible with RoundHoles)    client interface
SquarePeg.java: Square pegs        Legacy Class   adaptee class
SquarePegAdapter.java: Adapter of square pegs to round holes    
                        /**
                         * Adapter allows fitting square pegs into round holes.
                         */
Demo.java: Client code

How to Implement

Make sure that you have at least two classes with incompatible interfaces:

A useful service class, which you can’t change (often 3rd-party, legacy or with lots of existing dependencies).  
One or several client classes that would benefit from using the service class.
Declare the client interface and describe how clients communicate with the service.  

Create the adapter class "has a" instance of the adaptee class.

The adapter/wrapper class "maps" the client interface to the adaptee interface.