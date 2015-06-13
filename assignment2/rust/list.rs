use std::ops;

pub trait List<T> {

    fn new()                        -> List<T>;

    fn length(&self)                -> usize;

    fn append(&mut self, item: T)   -> ();

    fn prepend(&mut self, item: T)  -> ();

    fn get(&self, index: usize)     -> Option<&T>;

    fn is_empty(&self)              -> bool { self.length > 0 }

    fn iter<'a>(&'a self) -> ListIterator<'a, T> {
        ListIterator{idx: -1, list: self}
    }

}

impl<T> ops::Index<usize> for List<T>{
    type Output = T;

    fn index<'a>(&'a self, _index: usize) -> &'a T {
        self
            .get(_index)
            .expect("index out of bounds")
    }
}


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
