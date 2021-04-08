Observer is a behavioral design pattern that lets you define a subscription mechanism to notify multiple objects about any events that happen to the object they’re observing.

Define a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.

Encapsulate the core (or common or engine) components in a Subject abstraction, and the variable (or optional or user interface) components in an Observer hierarchy.

Each time the Editor object changes, it notifies its subscribers. EmailNotificationListener and LogOpenListener react to these notifications by executing their primary behaviors.

EventManager.java: Basic publisher

Editor.java: Concrete publisher, tracked by other objects

EventListener.java: Common observer interface

EmailNotificationListener.java: Sends emails upon receiving notification

LogOpenListener.java: Writes a message to a log upon receiving notification

 Demo.java: Initialization code