Command is a behavioral design pattern that turns a request into a stand-alone object that contains all information about the request. This transformation lets you pass requests as a method arguments, delay or queue a request’s execution, and support undoable operations.

 Use the Command pattern when you want to queue operations, schedule their execution, or execute them remotely.
 
 Use the Command pattern when you want to parametrize objects with operations.
 
 Use the Command pattern when you want to implement reversible operations.
 
 How to Implement
 
 Declare the command interface with a single execution method.
 
 Start extracting requests into concrete command classes that implement the command interface. Each class must have a set of fields for storing the request arguments along with a reference to the actual receiver object. All these values must be initialized via the command’s constructor.
 
 Identify classes that will act as senders. Add the fields for storing commands into these classes. Senders should communicate with their commands only via the command interface. Senders usually don’t create command objects on their own, but rather get them from the client code.
 
 Change the senders so they execute the command instead of sending a request to the receiver directly.
 
 The client should initialize objects in the following order:
 
 Create receivers.
 Create commands, and associate them with receivers if needed.
 Create senders, and associate them with specific commands.
 
 cons
 The code may become more complicated since you’re introducing a whole new layer between senders and receivers.
 
 pros
 
  Single Responsibility Principle. You can decouple classes that invoke operations from classes that perform these operations.
  Open/Closed Principle. You can introduce new commands into the app without breaking existing client code.
  You can implement undo/redo.
  You can implement deferred execution of operations.
  You can assemble a set of simple commands into a complex one.
  
  command:
  Command.java: Abstract base command
  
  CopyCommand.java: Copy selected text to clipboard
  
  PasteCommand.java: Paste text from clipboard
  
  CutCommand.java: Cut text to clipboard
  
  CommandHistory.java: Command history
  
  Editor:
  Editor.java: GUI of text editor
  
  Demo.java: Client code
  
  Most often it’s used as an alternative for callbacks to parameterizing UI elements with actions. It’s also used for queueing tasks, tracking operations history, etc.