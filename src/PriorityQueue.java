import java.util.ArrayList;

/**
 * This class represents a Priority Queue (heap) based on the ordering
 * defined by the compareTo method for the element. "Lower" value will
 * mean "higher" priority.
 *
 * @param <E> the type of elements in the queue
 * @author Alex
 */
public class PriorityQueue<E extends Comparable<E>> {

    private ArrayList<E> myHeap; // array representation of the heap

    /**
     * Creates an empty Priority Queue
     */
    public PriorityQueue() {
        myHeap = new ArrayList<E>();
    }

    /**
     * Adds the element to the priority queue
     *
     * @param element the element to be added
     */
    public void add(E element) {

        myHeap.add(element);

        int current = myHeap.size() - 1;

        // sift up
        while (current > 0) {

            int parent = (current - 1) / 2;

            if (myHeap.get(current).compareTo(myHeap.get(parent)) < 0) {

                swap(current, parent);
                current = parent;

            } else {
                break;
            }
        }
    }

    /**
     * Swaps two elements in the queue.
     * Pre-condition: 0 <= posOne, posTwo < size of queue
     *
     * @param posOne the first element's position in the queue
     * @param posTwo the second element's position in the queue
     */
    private void swap(int posOne, int posTwo) {

        E temp = myHeap.get(posOne);

        myHeap.set(posOne, myHeap.get(posTwo));
        myHeap.set(posTwo, temp);
    }

    /**
     * Returns whether or not the element is in the heap
     *
     * @param element the element to be searched for
     * @return true if the element is in the queue, false otherwise
     */
    public boolean contains(E element) {

        return myHeap.contains(element);
    }

    /**
     * Returns the element of highest priority, null if queue is empty.
     * Post-condition: the queue is not changed
     *
     * @return the element of highest priority queue
     */
    public E peek() {

        if (myHeap.isEmpty()) {
            return null;
        }

        return myHeap.get(0);
    }

    /**
     * Removes and returns the element of highest priority,
     * returns null if queue is empty.
     *
     * @return the element of highest priority
     */
    public E poll() {

        if (myHeap.isEmpty()) {
            return null;
        }

        E removed = myHeap.get(0);

        // move last element to root
        E last = myHeap.remove(myHeap.size() - 1);

        if (!myHeap.isEmpty()) {

            myHeap.set(0, last);

            heapify(0);
        }

        return removed;
    }

    /**
     * Will "sift down" the element at the given position
     * down to restore the heap property
     *
     * @param pos the starting position for heapify
     */
    private void heapify(int pos) {

        int smallest = pos;

        int left = 2 * pos + 1;
        int right = 2 * pos + 2;

        // check left child
        if (left < myHeap.size()
                && myHeap.get(left).compareTo(myHeap.get(smallest)) < 0) {

            smallest = left;
        }

        // check right child
        if (right < myHeap.size()
                && myHeap.get(right).compareTo(myHeap.get(smallest)) < 0) {

            smallest = right;
        }

        // swap and continue heapifying
        if (smallest != pos) {

            swap(pos, smallest);

            heapify(smallest);
        }
    }

    /**
     * Finds and removes the given element from the queue.
     * Returns true if an element was deleted from the queue,
     * false otherwise.
     *
     * @param element the element to be removed from the queue
     * @return true if an element was removed from the queue, false otherwise
     */
    public boolean remove(E element) {

        int index = myHeap.indexOf(element);

        if (index == -1) {
            return false;
        }

        // if removing last element
        if (index == myHeap.size() - 1) {

            myHeap.remove(myHeap.size() - 1);

            return true;
        }

        // move last element into removed spot
        E last = myHeap.remove(myHeap.size() - 1);

        myHeap.set(index, last);

        // restore heap
        heapify(index);

        return true;
    }

    /**
     * Returns the number of elements in the queue
     *
     * @return the number of elements in the queue
     */
    public int size() {

        return myHeap.size();
    }

    /**
     * Returns the String representation of the heap
     * (by the order of list, each element separated
     * with a single space)
     *
     * @return the String representation of the heap
     */
    public String toString() {

        String result = "";

        for (int i = 0; i < myHeap.size(); i++) {

            result += myHeap.get(i);

            if (i < myHeap.size() - 1) {
                result += " ";
            }
        }

        return result;
    }

    /**
     * Main method - contains console program used
     * for testing of the PriorityQueue class.
     *
     * @param args
     */
    public static void main(String[] args) {

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        pq.add(5);
        pq.add(2);
        pq.add(8);
        pq.add(1);

        System.out.println(pq);

        System.out.println("Peek: " + pq.peek());

        System.out.println("Poll: " + pq.poll());

        System.out.println(pq);

        pq.remove(5);

        System.out.println(pq);
    }
}
