use std::ops;

use super::List;

pub struct ArrayList<T>;

impl<T> List<T> for ArrayList<T> {
    /// Create a new empty list.
    fn new()                        -> List<T> {
        unimplemented!() // TODO: implement this!
    }

    /// Returns the length of the list.
    fn length(&self)                -> usize  {
        unimplemented!() // TODO: implement this!
    }

    /// Adds an item to the end of the list.
    fn append(&mut self, item: T)   -> ()  {
        unimplemented!() // TODO: implement this!
    }

    /// Adds an item to the beginning of the list.
    fn prepend(&mut self, item: T)  -> ()  {
        unimplemented!() // TODO: implement this!
    }

    /// Returns the item at the specified index, or `None` if that
    /// index is out of range.
    fn get(&self, index: usize)     -> Option<&T>  {
        unimplemented!() // TODO: implement this!
    }

}

/// Implements indexing for lists.
///
/// This allows you to access list elements using `list[n]` syntax.
/// This is implemented for you, and should work, provided that your
/// list implementation behaves as expected.
impl<T> ops::Index<usize> for ArrayList<T> {
    type Output = T;

    fn index<'a>(&'a self, _index: usize) -> &'a T {
        self.get(_index)
            .expect("index out of bounds")
    }
}
