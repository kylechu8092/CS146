package ExtraCredit.heaps;

public class heap {

    int [] heap;

    public heap()
    {
        heap = new int[10];
    }

    public int parent(int key)
    {
        return (key - 1) / 2;
    }

    public int left(int key)
    {
        //Formula to find left
        return 2 * key + 1;
    }

    public int right(int key)
    {
        //Formula to find right
        return 2 * key + 2;
    }

    public void swap(int key1, int key2)
    {
        int temp = heap[key1];
        heap[key1] = heap[key2];
        heap[key2] = temp;
    }

    public void insert(int key)
    {
        int i = heap.length - 1;
        heap[i] = key;
        //Insertion adds the value to the very end of aray
        //Check if it satisfies our properties by checking if the parent
        //is smaller, if not swap, keep going up the tree
        while (i != 0 && heap[i] < heap[parent(i)])
        {
            swap(heap[i], heap[parent(i)])
            i = parent(i);
        }
    }

    public void heapify(int key)
    {
        int leftChild = left(key); //Assume we have a helper function that gives us the left and right child of an index key
        int rightChild = right(key); 
        int smallest = key; //Key should be smallest but if not, we can check and change
        
        if (key < heap.length && leftChild < key)
        {
            smallest = leftChild;
        }
        if (key < heap.length && rightChild < key)
        {
            smallest = rightChild;

        }
        
        if (key != smallest) //We have to make a swap
        {
            swap(key, smallest);
            heapify(smallest);
        } 
        
    }

    
}
