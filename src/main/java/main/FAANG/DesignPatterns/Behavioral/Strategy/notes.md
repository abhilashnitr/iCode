Strategy is a behavioral design pattern that lets you define a family of algorithms, put each of them into a separate class, and make their objects interchangeable.

Use the Strategy pattern when you want to use different variants of an algorithm within an object and be able to switch from one algorithm to another during runtime.

Use the Strategy when you have a lot of similar classes that only differ in the way they execute some behavior.Use the Strategy when you have a lot of similar classes that only differ in the way they execute some behavior.

HOW TO IMPLEMENT
In the context class, identify an algorithm that’s prone to frequent changes. It may also be a massive conditional that selects and executes a variant of the same algorithm at runtime.

Declare the strategy interface common to all variants of the algorithm.

One by one, extract all algorithms into their own classes. They should all implement the strategy interface.

In the context class, add a field for storing a reference to a strategy object. Provide a setter for replacing values of that field. The context should work with the strategy object only via the strategy interface. The context may define an interface which lets the strategy access its data.

Clients of the context must associate it with a suitable strategy that matches the way they expect the context to perform its primary job.

Imp :
Bridge, State, Strategy (and to some degree Adapter) have very similar structures.
