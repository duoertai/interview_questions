package interview.pinterest.phone.DesignCircularDeque;

class MyCircularDeque {
    private int k;
    private int[] array;
    private int read;
    private int write;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.k = k;
        this.array = new int[k + 1];
        this.read = 0;
        this.write = 0;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(isFull())
            return false;
        this.read = (this.read - 1 + k + 1) % (k + 1);
        this.array[this.read] = value;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(isFull())
            return false;
        this.array[this.write] = value;
        this.write = (this.write + 1) % (k + 1);
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(isEmpty())
            return false;
        this.read = (this.read + 1) % (k + 1);
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(isEmpty())
            return false;
        this.write = (this.write - 1 + k + 1) % (k + 1);
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if(isEmpty())
            return -1;
        return this.array[this.read];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if(isEmpty())
            return -1;

        int prev = (this.write - 1 + k + 1) % (k + 1);
        return this.array[prev];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return this.write == this.read;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return (this.write + 1) % (this.k + 1) == this.read;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */

