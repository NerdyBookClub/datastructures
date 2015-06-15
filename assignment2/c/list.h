
/* this is where you can change the list's element type     */
typedef int LIST_ELEM;

struct list_struct;
typedef *list_struct List;

/* Returns true if the specified list is empty.             */
int list_isEmpty(List l);

/* Returns the length of the specified list.                */
int list_length(List l);

/* Adds the specified element to the beginning of the list. */
void list_prepend(List l, LIST_ELEM);

/* Adds the specified element to the end of the list.       */
void list_append(List l, LIST_ELEM);

/* Returns the element at the specified index into the list. */
LIST_ELEM list_get(List l, int index);
