# Liskov Substitude Principle

The Liskov Substitution Principle is the 3rd of Robert C. Martin's SOLID design principles. The Liskov Substitution Principle was proposed by Barbara Liskov, group leader of MIT programming methodologies.

The Liskov Substitution Principle argues that "We should be able to use subclasses in place of the superclasses from which they are derived, without needing to make any changes to our code". At the same time, classes or objects made up of subclasses must exhibit the same behavior when replaced by objects of the superclass. Also, a subclass's overridden method must accept the same input parameter values as the superclass's method. This means that less restrictive validation rules can be applied, but stricter rules are not allowed in the subclass. Otherwise, any code that calls this method on an object of the superclass may raise an exception if called with an object of the subclass.

Learning where to apply the Liskov Substitution  Principle and applying it in the right place makes the code more flexible for new modifications. Compliance with this principle improves class structures by creating a hierarchy that can fully meet the expected behavior of classes. When it is decided to apply this principle, the behavior of classes becomes more important than its structure. The compiler only checks the structural rules defined by the Java language, but cannot enforce a particular principle. Therefore, applying this principle is not easy.

Code reviews or tests can be written to see if we are successful in applying this principle. When running tests, it should be ensured that applying this principle does not cause errors or significantly alter performance. In addition, testing should be done by taking into account all possible situations.

Finally, this principle is similar to the Open/Closed Principle, and following the Open/Closed Principle also simplifies the application of the Liskov Principle.

## Example

```java
public class Mammals{
    public void flightless(){}
}
public class Dolphin extends Mammals{}
```

The dolphin cannot fly because it is a mammal.

```java
public class Bat extends Mammals{}
```

When we derive a bat from the same class: Bat is mammal but can fly, bat class is a subclass of mammals but should not use flightless method.

To implement the Liskov Substitution Principle, we can edit the code as follows.

```java
public class Mammals{}
public class FlightlessMammal extends Mammals{
    public void flightless(){}
}
public class Bat extends FlyingMammals{}
public class Dolphin extends Mammals{}
```

## Check More

1. [Data Abstraction and Hierarchy](https://www.cs.tufts.edu/~nr/cs257/archive/barbara-liskov/data-abstraction-and-hierarchy.pdf)
2. [The Liskov Substitution Principle with Code Examples](https://stackify.com/solid-design-liskov-substitution-principle/)
3. [The Liskov Substitution Principle Flashback](http://bloomlab.blogspot.com/2016/12/liskov-substitution-principle-lsp.html)