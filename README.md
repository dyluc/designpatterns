## Design Patterns

### Singleton (Creational)

> In this pattern, class instantiation is restricted to a single instance, shared across multiple resources in a single system.

**Requirements**
- Private constructor(s) to ensure no new instances can be created.
- Static getter method to return a reference to the instance so that it is globally accessible.

To make singletons thread safe in a multi-threaded environment, we must guarantee access to the instance, as well as creation of the instance if it doesn't exist, is an atomic operation. One way of doing this in Java is by ensuring the static getter method is a synchronized method.

A better and much simpler approach to writing singletons in Java is to use enums with synchronized member methods (or Atomic variables) to guarantee only one instance will be created that is thread safe.

### Builder (Creational)

> In this pattern, the construction code of an object is separated from its representation.

Complex objects with many fields and methods can have many representations. It becomes impractical and inflexible to initialise every field step-by-step for each new instance, potentially taking the form of a huge constructor with many irrelevant parameters. The Builder design pattern allows flexible control over the steps involved in the construction of these complex objects.

**Requirements**
- Extract and encapsulate the object creation code into a separate `Builder` object.
- Only the `Builder` object should be able to create new instances of the class.
- The class must be immutable (final, private fields with only getters)

In a Builder pattern, a further level of abstraction can be provided by a `Director`. A director is a separate class defining the order in which to call the builder steps. They can be useful for defining specific construction routines for building commonly used objects.

### Factory (Creational)

> In this pattern, a method wil return one of several possible subclasses that share a common interface, or abstract super class.

The factory pattern allows for the flexibility of choosing the created class at runtime. As with other creational patterns, object creation logic is hidden from the client. The client also doesn't need to know every subclass of the interface either.

**Requirements**
- Create a common interface / abstract super class.
- Create a factory class to instantiate new objects that are referred to by their shared super class.


### Prototype (Creational)

> In this pattern, object duplication is delegated to the object being cloned. A common interface (often with a single `clone` method) is created to avoid coupling between client code and the class of the object being cloned. 

Implementations of the `clone` method involves creating a object of the same type and copying over all field values. An object that supports cloning is known as a prototype. Often, cloning can serve as an alternative to subclassing for complex objects with many fields and configurations.

The benefit here is that you can create a set of preconfigured objects and clone the object you need when you need it instead of constructing it from scratch.

A prototype registry can be used to store frequently used prototypes, containing pre-built objects.
A simple implementation could be a hashmap with name -> prototype key value pairs.

### Iterator (Behavioural)

> In this pattern, elements of a collection can be traversed in sequence without needing to know the underlying implementation.

The representation or structure of a collection is decoupled from the algorithm that operates on it. This way, the same code used to traverse one collection can also be used to traverse many other collections.

**Requirements**
- Create an `Iterator` interface, defining the operations required for traversal.
- Create an `Iterable` interface, defining one or more methods to retrieve a compatible implementation of the `Iterator` interface.
- Create concrete implementations of the above interfaces. For example a `MapIterator` to iterate over a `MapCollection`.


### Strategy (Behavioural)

> In this pattern, behaviours/algorithms can be extracted into independent objects allowing for interchangeability at runtime.

Using the strategy pattern, you can separate algorithm implementations from one another, and allow selection of which to use at runtime.

**Requirements**
- Create a `Strategy` interface common to all variations of an algorithm.
- Create separate classes for each algorithm, which implement the newly created interface.
- Create a `Context` class which internally references a strategy object. Provide methods for the context class to set and execute the strategy.

### Visitor (Behavioural)

> In this pattern, an algorithm is separated from the object that it operates on.

As such, this allows for new functionality to be introduced that operates on existing objects with minimal modification to the original structure (reducing the potential to introduce breaking changes). This new functionality can be created for families of classes, defining individual method specialisations for each separate type.

You can imagine this could result in individual type checking for every single type that the visitor wanted to support. As such, this pattern uses the concept of Double Dispatch to solve this problem.
Resolving which specialised method to use is delegated to the original object the visitor class intends to operate on. As such the original class will require minimal modification by means of implementing a new `#accept(Visitor visitor)` method.

**Requirements**
- Create a `Visitor` interface to define operations to be performed on separate types of an object structure (many languages can facilitate this through method overloading).
- Provide concrete implementations for the `Visitor` interface and each of it's specialised methods.
- Create a `Visitable` base element interface that defines an `#accept(Visitor visitor)` method to accept a visitor.
- Concrete implementations of the `Visitable` interface may be existing objects, that should now direct calls to their `accept` method to the visitor's specific specialised method.

### Adapter (Structural)

> In this pattern, a wrapper is constructed to facilitate communication between incompatible objects.

Interfaces that are independent of one another can benefit from the adapter pattern to communicate with one another without a need to modify their source code. As such this is a popular pattern for systems that need to make legacy code work with modern classes. 

In the wild, use of an adapter pattern can be recognizable by a class constructor or method which takes an instance of a different abstract/interface type. For example, Java's `java.util.Arrays::asList`.

**Requirements**
- Create a separate Adapter wrapper class to convert instances of one interface (adaptee) into another interface (target).
- Work through the Adapter wrapper to interact with the classes that don't have the required interface (the adaptee).


---