Decorator is a structural design pattern that lets you attach new behaviors to objects by placing these objects inside special wrapper objects that contain the behaviors.

Problem

The initial version of the library was based on the Notifier class that had only a few fields, a constructor and a single send method. The method could accept a message argument from a client and send the message to a list of emails that were passed to the notifier via its constructor. A third-party app which acted as a client was supposed to create and configure the notifier object once, and then use it each time something important happened.

At some point, you realize that users of the library expect more than just email notifications.

You extended the Notifier class and put the additional notification methods into new subclasses. Now the client was supposed to instantiate the desired notification class and use it for all further notifications.

example :
Notifier:
    1. Sms Notifier extends Notifier
    2. Email Notifier extends Notifier
    3. facebook Notifier extends Notifier
    4. sms+email Notifier extends Notifier
    5. sms+facebook Notifier extends Notifier
    6. email+facebook Notifier extends Notifier
    
Decorator design pattern
Create a "lowest common denominator" that makes classes interchangeable
Create a second level base class for optional functionality
"Core" class and "Decorator" class declare an "isa" relationship
Decorator class "has a" instance of the "lowest common denominator"
Decorator class delegates to the "has a" object
Create a Decorator derived class for each optional embellishment
Decorator derived classes delegate to base class AND add extra stuff
Client has the responsibility to compose desired configurations

    