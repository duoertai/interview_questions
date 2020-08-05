package interview.pinterest.DesignCircularQueue;

class MyCircularQueue {

    private int[] array;
    private int read;
    private int write;
    private int k;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        this.k = k;
        this.array = new int[k + 1];
        this.read = 0;
        this.write = 0;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(isFull())
            return false;

        this.array[this.write] = value;
        this.write = (this.write + 1) % (k + 1);
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(isEmpty())
            return false;

        this.read = (this.read + 1) % (k + 1);
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if(isEmpty())
            return -1;

        return array[this.read];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if(isEmpty())
            return -1;

        int index = (this.write - 1 + k + 1) % (k + 1);
        return array[index];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return this.read == this.write;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return (this.write + 1) % (k + 1) == this.read;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
