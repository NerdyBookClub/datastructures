Getting Started with Data Structures
====================================

Data structures are, just like it says on the tin, structures with which data may be organized. They define ways of accessing and manipulating that data, and operations that can be performed on their own structure. Knowing how to write efficient data structures and how and when to use them is vital to the implementation of effective algorithms.

What are Data Structures?
-------------------------

Technically, a data structure is a concrete implementation of an _abstract data type_, or ADT. An ADT is a description of a data type based on the ways in which that data type behaves rather than how it functions. This description might take the form of possible data values, possible operations that may be performed on the data type, and the behaviour of those operations.

What this means is that, essentially, the difference between a data structure and an abstract data type is that an abstract data type describes _what_ behaviours a data type has, while a data structure describes _how_ it carries out those behaviours. Throughout this course, I'll be providing you with abstract data types, and asking you to program data structures that implement those ADTs. By implementing a data structure, you are taking an abstract description of a data type and explaining to the computer, in a language that it understands, how to do whatever it is that that data structure does.

### An Example: the Array

Most people with any programming experience have probably encountered and used _arrays_. In most languages, an array is a _primitive_ data structure, meaning that it is provided by the programming language and does not have to be implemented by a programmer in order to be used.

What is an array? An array is a fixed-length collection of values of the same type, where each element has an index by which it can be accessed. Let's take a look at the components of that definition.

  + _Fixed-length:_ An array is created with a certain number of elements that it may hold, and cannot hold more than that number of elements. For example, when declaring an array variable, we might write something like the following:

  ```java
  // in Java
  int[] array = new int[10];
  ```
  ```c
  // in C
  int[10] array;
  ```

  Notice the `10`. That number determines the size of the array. In both of these examples, we're telling the computer to create an array of ten integers.

  + _Elements of the same type_: Each element in an array must be the same data type – you cannot create an array and put in two integers, a floating-point number, and a String. In the example we saw above, both the Java and C array variables are declared with a _type annotation_, a statement that says what type the array will be. In both examples, we have created an array of integers.

  + _Indexable_: in most programming languages, each element in an array is assigned a non-negative integer associated with it. These values begin at 0 and increase by one for each element of the array. Such numbers are called _indices_. Therefore, for an array of size _n_, the first element would be at index 0, the second at index 1, the third at index 2, and so forth, until we reach index _n_-1. For example, suppose we have an array of ten integers called `array`, and we want to access and print out the third integer in the array. We might write something like this:

  ```java
  // in Java
  System.out.println(array[2]);
  ```
  ```c
  // in C
  printf("%i%n", array[2]);
  ```

But _why_ does an array have these properties? These properties of an array exist due to the way in which the array data type is stored in a computer's memory. An array consists of a contiguous block of memory locations, each one containing a value. The computer stores the address at which the array begins as a _pointer_ to the array. To access an element of an array at a certain index, the computer begins at the array pointer and then adds the size of the type of element in the array to the array pointer to find the address (or _offset_) corresponding to that index. This is why all the elements of the array must be the same type; since different data types have different sizes (for example, a `char` in C is 8 bits, while a `double` is 64 bits). If we had an array of mixed types of differing sizes, it would be impossible to compute the offset needed to access any given element in this manner.

Similarly, the array is of a fixed size because it is simply a block of contiguous memory. The memory address after the last element in the array might be assigned to contain some completely different variable or data type when our program is running. If we wanted to add more elements to an array, we would have nowhere to put them, since that space in the computer's memory might be used for some different purpose.

Writing Data Structures
-----------------------

Now that we understand the distinction between data structures and abstract data types, an inquisitive reader might wonder, how do we translate these ideas into programming concepts?

### Representing Abstract Data Types

Most programming languages provide methods for separating _interface_ from _implementation_. In Java, this is accomplished using `interface`s. An interface is like a class that provides no implementation for its methods, it only defines the signatures of methods that may be performed on that class. Such an interface may then be extended by concrete `class`es that must implement those methods.

Why would we want to program using interfaces? Interfaces may be used to create a contract for a particular type of object. By extending a particular interface, we can guarantee that specific behaviours or operations may be performed. Here's a contrived example. Suppose we wish to model different types of food that can be eaten. We might start by writing something like this:

```java
// Interface for something that can be eaten
public interface Edible {

    // Returns the number of calories in this Edible object
    public int calories();

    // Eat this Edible object, returning true if there is any left
    // or false if it's all gone.
    public boolean eat();
}

public class Sandwich extends Edible {

    private int bitesRemaining;

    public Sandwich() {
        bitesRemaining = 10;
    }

    public int calories() {
        return 350;
    }

    public boolean eat() {
        if (bitesRemaining == 0) {
            return false;
        } else {
            bitesRemaining--;
            return true;
        }
    }

}

public class Strawberry extends Edible {

    public Strawberry() {
        bitesRemaining = 10;
    }

    public int calories() {
        return 20;
    }

    public boolean eat() {
        // each strawberry only has one bite in it
        return false;
    }
}
```

In order to complete a number of the assignments in this course using Java, you will be provided with one or more interfaces representing abstract data types, and you will be asked to provide concrete implementations of those interfaces.

In C, _header files_ may be used to achieve a similar end.

TODO: explain header files in C.

### Generic programming

When implementing data structures, we might want our data structures to be useable for storing data of various types. For example, consider how the array data structure we've discussed above. Note that it is not limited to storing a particular type of value. Rather, we may create arrays of `int`s or `float`s or, in Java, any type of object. If we are implementing some data structure, such as a list, we would want to write a list implementation that can store any type of value, rather than a list that stores only integers. This is called _generic programming_.

In Java, we can create generic container classes using _type parameters_. To create a generic container class, we can add one or more type parameter to the class's definition, like this:

```java
public class Container<T> { // T is a type parameter - it can be any type

    private T contained; // 'contained' is a variable of type T

    public Container(T value) { // takes a value of type T as a parameter
        contained = value;
    }

    public T getContained() { // returns a value of type T
        return contained;
    }

}
```

The `T` in angle brackets is a type variable. Not unlike a regular variable, we can refer to `T` throughout our class. However, rather than referencing a specific value, a type variable references a type. Notice how the `Container<T>` class contains methods and variables that refer to `T` in their declarations. The class does not care whether the value of `T` is `int` or `String` or even another `Container<T>`; it can still be created and provide access to the contained value regardless of its type.

When creating and using instances of classes with type parameters, we can declare them like this:

```java

Container<String> c; // declares the variable 'c' as a Container holding a String

c = new Container<String>("This is a string"); // this works

c = new Container<Integer>(1); // this will not compile

```

Note that the second line, in which `c` is assigned to a new `Container<Integer>`, will not compile. We have already told the computer that the variable `c` refers to a `Container` that holds `String`s, so we cannot assign it to a `Container` that holds `Integer`s.

If a generic variable is declared and instantiated on the same line, we don't have to write out the type parameter twice, like this:

```java
Container<Double> container = new Container<>(1.0);
```

The compiler understands that the empty type parameter should be filled in with the type specified in the declaration.

Unfortunately, C has no such facility for generic programming. C++, the object-oriented extension of C, does have support for _templates_, which are similar to Java's generics. If completing the assignments in this course using C rather than Java, you will not be asked to implement generic data structures in the same manner.
