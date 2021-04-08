Creational patterns

These design patterns are all about class instantiation. This pattern can be further divided into class-creation patterns and object-creational patterns. While class-creation patterns use inheritance effectively in the instantiation process, object-creation patterns use delegation

BUILDER:
Separate the construction of a complex object from its representation so that the same construction process can create different representations.
The Builder pattern suggests that you extract the object construction code out of its own class and move it to separate objects called builders.
The parameters to the constructor are reduced and are provided in highly readable method calls.
Builder design pattern also helps in minimizing the number of parameters in constructor and thus there is no need to pass in null for optional parameters to the constructor.
The number of lines of code increase at least to double in builder pattern, but the effort pays off in terms of design flexibility and much more readable code.

Structural patterns

These patterns explain how to assemble objects and classes into larger structures while keeping these structures flexible and efficient.

Behavioral patterns

These patterns are concerned with algorithms and the assignment of responsibilities between objects.
