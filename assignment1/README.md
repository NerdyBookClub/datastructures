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
