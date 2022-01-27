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

### Iterator (Behavioural)

> In this pattern, elements of a collection can be traversed in sequence without needing to know the underlying implementation.

The representation or structure of a collection is decoupled from the algorithm that operates on it. This way, the same code used to traverse one collection can also be used to traverse many other collections.

**Requirements**
- Create an `Iterator` interface, defining the operations required for traversal.
- Create an `Iterable` interface, defining one or more methods to retrieve a compatible implementation of the `Iterator` interface.
- Create concrete implementations of the above interfaces. For example a `MapIterator` to iterate over a `MapCollection`.

### Adapter (Structural)

---

