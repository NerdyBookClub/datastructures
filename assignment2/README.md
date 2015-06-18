The List ADT
=============

In the previous assignment, we discussed the characteristics of the array data structure. Arrays are often very useful when a programmer wishes to collect a fixed number of elements into an ordered structure. But what if we wish to store a varying number of items in a collection that can grow as more items are added? For this we need to use a _list_ structure.

Essentially, the List ADT defines an indexed collection similar to an array, but which may be dynamically resized as items are added. We would want to provide at least the following operations on such a data structure:

 + _prepend_ an item, adding it to the beginning of the list
 + _append_ an item, adding it to the end of the list
 + _get_ the item at an index
 + _insert_ an item at a specified index

Implementing a List
-------------------

There are, essentially, two methods by which we can easily implement a list data structure.

#### Array Lists

If we recall our previous discussion of the array, we might wish to implement a list by placing the elements in an array. Since the list should be able to grow to an arbitrary size, when more elements are added than the maximum length of the array, we simply allocate a new array with a larger size, and then copy each element into that new array at the corresponding index. This approach is called an _array list_ or a _dynamic array_ data structure.


#### Linked Lists

The alternative approach is called the _linked list_. A linked list consists of a series of _nodes_, which are object or structure types (depending on the language in question) containing at their simplest an element and a reference to the next node in the list. The first node contains the first element and a reference to the second node, the second contains the second element and a reference to the third node, and so on. At the end of the list is a special node which contains no elements and indicates that the end of the list has been reached (this is sometimes referred to as `Nil`).

The list described in the above paragraph is known as a _singly-linked_ list. Alternatively, a list may be _doubly-linked_, with each node containing a reference to both the previous node and the next node.


### Advantages and Disadvantages

TODO: finish this
