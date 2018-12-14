import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

public class ImplementationOfQueue<E> implements Queue<E> {

    private Nod<E> prim;
    private Nod<E> ultim;
    private Iterator<E> it;


    public ImplementationOfQueue() {
        it = new Iterator<>() {
            @Override
            public boolean hasNext() {
                return prim.getUrmator() != null;
            }

            @Override
            public E next() {
                E item = prim.getValue();
                prim = prim.getUrmator();
                return item;
            }
        };
    }

    /**
     * Inserts the specified element into this queue if it is possible
     *
     * @param object the element to add
     * @return {@code true} if this collection changed as a result of the call
     * @throws NullPointerException if the specified element is null and this queue does not permit null elements
     */
    @Override
    public boolean add(E object) {
        if (object == null) {
            throw new NullPointerException("This queue does not permit null elements");
        }
        Nod<E> nodNou = new Nod<>(object);
        nodNou.setValue(object);
        nodNou.setUrmator(null);

        if (this.prim == null) {
            this.prim = nodNou;
            this.ultim = nodNou;
        } else {
            Nod penultim = this.ultim;
            this.ultim = nodNou;
            penultim.setUrmator(this.ultim);
        }
        return true;
    }

    /**
     * Tries to add an element to a queue
     *
     * @param object the element to offer
     * @return false if the element can't be added (like in case when a queue is full) or true if the element was added, and doesn't throw any specific exception.
     */
    @Override
    public boolean offer(E object) {
        if (object == null) {
            return false;
        }
        Nod<E> nodNou = new Nod<>(object);
        nodNou.setValue(object);
        nodNou.setUrmator(null);

        if (this.prim == null) {
            this.prim = nodNou;
            this.ultim = nodNou;
        } else {
            Nod<E> penultim = this.ultim;
            this.ultim = nodNou;
            penultim.setUrmator(this.ultim);
        }
        return true;
    }

    /**
     * Retrieves and removes the head of this queue.
     * This method differs from  poll() only in that it throws an exception if this queue is empty.
     *
     * @return the head of this queue
     * @throws NoSuchElementException if this queue is empty
     */
    @Override
    public E remove() {

        if (isEmpty()) {
            throw new NoSuchElementException("Nu s-a putut face remove! Coada este goala!");
        }
        if (this.prim == this.ultim) {
            E value = prim.getValue();
            prim = ultim = null;
            return value;
        }
        E value = this.prim.getValue();
        prim = prim.getUrmator();
        return value;
    }

    /**
     * Retrieves and removes the head of this queue, or returns null if this queue is empty.
     *
     * @return the head of this queue, or null if this queue is empty
     */
    @Override
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        if (this.prim == this.ultim) {
            E value = prim.getValue();
            prim = ultim = null;
            return value;
        }
        E value = this.prim.getValue();
        prim = prim.getUrmator();
        return value;
    }

    /**
     * Retrieves, but does not remove, the head of this queue.
     * This method differs from {peek} only in that it throws an exception if this queue is empty.
     *
     * @return the head of this queue
     * @throws NoSuchElementException if this queue is empty
     */
    @Override
    public E element() {
        if (isEmpty()) {
            throw new NoSuchElementException("Nu s-a putut face retrieve! Coada este goala!");
        }
        return this.prim.getValue();
    }

    /**
     * Retrieves, but does not remove, the head of this queue.
     *
     * @return the head of this queue, or null if this queue is empty
     */
    @Override
    public E peek() {
        return isEmpty() ? null : this.prim.getValue();
    }

    /**
     * Returns the number of elements in this queue.
     *
     * @return the number of elements in this queue.
     */
    @Override
    public int size() {
        if (this.prim == null)
            return 0;
        int i = 0;
        Nod<E> node = prim;
        while (node != null) {
            i += 1;
            node = node.getUrmator();
        }
        return i;
    }

    /**
     * Returns true if this collection contains no elements.
     *
     * @return true if this collection contains no elements
     */
    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * Returns true if this collection contains the specified element.
     *
     * @param obj element whose presence in this collection is to be tested
     * @return true if this collection contains the specified element
     * @throws NullPointerException if the specified element is null and this collection does not permit null elements
     */
    @Override
    public boolean contains(Object obj) {
        if (obj == null) {
            throw new NullPointerException("The specified element is null and this collection does not permit null elements!!!");
        }
        Nod<E> node = prim;
        while (node != null) {
            if (node.getValue().equals(obj))
                return true;
            node = node.getUrmator();
        }
        return false;
    }

    /**
     * Returns an iterator over the elements in this collection.
     *
     * @return an {@code Iterator} over the elements in this collection
     */
    @Override
    public Iterator<E> iterator() {
        return it;
    }

    /**
     * Returns an array containing all of the elements in this collection.
     * This method must return the elements in the same order that are returned by the iterator
     *
     * @return an array containing all of the elements in this collection
     */
    @Override
    public Object[] toArray() {
        Object[] result = new Object[this.size()];
        int i = 0;
        for (Nod<E> x = this.prim; x != null; x = x.getUrmator())
            result[i++] = x.getValue();
        return result;

    }

    /**
     * Returns an array containing all of the elements in this list in proper sequence (from first to last element);
     * the runtime type of the returned array is that of the specified array.
     * If the list fits in the specified array, it is returned therein.
     *
     * @param a the array into which the elements of the list are to be stored,
     *          if it is big enough; otherwise, a new array of the same runtime type is allocated for this purpose.
     * @return an array containing the elements of the list
     * @throws NullPointerException if the specified array is null
     */
    @Override
    @SuppressWarnings("unchecked")
    public Object[] toArray(Object[] a) {
        if (a.length < this.size())
            a = (E[]) java.lang.reflect.Array.newInstance(
                    a.getClass().getComponentType(), this.size());
        int i = 0;
        Object[] result = a;
        for (Nod<E> x = prim; x != null; x = x.getUrmator()) {
            result[i++] = x.getValue();
        }
        if (a.length > this.size())
            a[this.size()] = null;

        return a;

    }

    /**
     * Removes a single instance of the specified element from this collection, if it is present.
     * More formally removes an element such that the queue does not break his format.
     *
     * @param o element to be removed from this collection, if present
     * @return {@code true} if an element was removed as a result of this call
     * @throws NullPointerException if the specified element is null and this collection does not permit null elements
     */
    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("This operation is not supported by this collection!!!");
    }

    /**
     * Adds all of the elements in the specified collection to this collection.
     * The behavior of this operation is undefined if the specified collection is modified while the operation is in progress.
     *
     * @param collection collection containing elements to be added to this collection
     * @return {@code true} if this collection changed as a result of the call
     * @throws UnsupportedOperationException if the specified operation is not supported by this collection
     */
    @Override
    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("The specified operation is not supported by this collection!!!");
    }

    /**
     * Removes all of the elements from this collection (optional operation).
     * The collection will be empty after this method returns.
     */
    @Override
    public void clear() {
        while (!isEmpty()) {
            this.remove();
        }
    }

    /**
     * Retains only the elements in this collection that are contained in the specified collection.
     *
     * @param c collection containing elements to be retained in this collection
     * @return {@code true} if this collection changed as a result of the call
     * @throws NullPointerException if this collection contains one or more
     *                              null elements and the specified collection does not permit null
     *                              elements
     */
    @Override
    public boolean retainAll(Collection c) {
        throw new UnsupportedOperationException("This operation is not supported by this collection!!!");
    }

    /**
     * Removes all of this collection's elements that are also contained in the specified collection (optional operation).
     * After this call returns, this collection will contain no elements in common with the specified collection.
     *
     * @param c collection containing elements to be removed from this collection
     * @return {@code true} if this collection changed as a result of the call
     * @throws NullPointerException if this collection contains one or more null elements
     *                              and the specified collection does not support null elements
     */
    @Override
    public boolean removeAll(Collection c) {
        throw new UnsupportedOperationException("This operation is not supported by this collection!!!");
    }

    /**
     * Returns {@code true} if this collection contains all of the elements
     * in the specified collection.
     *
     * @param collection collection to be checked for containment in this collection
     * @return {@code true} if this collection contains all of the elements
     * in the specified collection
     * @throws NullPointerException if the specified collection contains one
     *                              or more null elements and this collection does not permit null
     *                              elements
     */
    @Override
    public boolean containsAll(Collection collection) {
        if (collection.size() == 0 || collection.contains(null)) {
            throw new NullPointerException("Collection cannot be null and does not permit null elements!!!");
        }
        for (Object o : collection) {
            if (!this.contains(o))
                return false;
        }
        return true;

    }

    @Override
    public String toString() {
        String myStr = "";
        Nod nod = this.prim;

        for (Nod<E> x = prim; x != null; x = x.getUrmator()) {
            myStr = myStr + nod.toString();
            nod = nod.getUrmator();
        }
        return myStr;
    }

}
