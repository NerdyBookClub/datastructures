use std::ops;

pub trait List<T> {

    /// Create a new empty list.
    fn new()                        -> List<T>;

    /// Returns the length of the list.
    fn length(&self)                -> usize;

    /// Adds an item to the end of the list.
    fn append(&mut self, item: T)   -> ();

    /// Adds an item to the beginning of the list.
    fn prepend(&mut self, item: T)  -> ();

    /// Returns the item at the specified index, or `None` if that
    /// index is out of range.
    fn get(&self, index: usize)     -> Option<&T>;

    /// Returns true if the list is empty.
    ///
    /// This is implemented for you.
    fn is_empty(&self)              -> bool { self.length > 0 }

    /// Returns a forwards iterator over the entries in the list.
    ///
    /// This one is implemented for you.
    fn iter<'a>(&'a self)           -> ListIterator<'a, T> {
        ListIterator{idx: -1, list: self}
    }

}


/// Implements indexing for lists.
impl<T> ops::Index<usize> for List<T>{
    type Output = T;

    fn index<'a>(&'a self, _index: usize) -> &'a T {
        self.get(_index)
            .expect("index out of bounds")
    }
}

/// Iterator over the entries of a list.
///
/// This is basically just a pointer to the list,
/// plus an index to the current item in the iterator.
struct ListIterator<'a, T:'a> {
    idx: usize,
    list: &'a List<T>
}

impl<'a, T> Iterator for ListIterator<'a, T> {
    type Item = &'a T;

    fn next(&mut self) -> Option<&'a T> {
        self.idx = self.idx + 1;
        self.list.get(self.idx)
    }
}
