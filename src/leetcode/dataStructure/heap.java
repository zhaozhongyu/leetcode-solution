package leetcode.dataStructure;
/**
 * 堆的数组实现
 * */
public class heap {

    // 根节点是1
    public int getParent(int cur) {
        if (cur == 1) return -1;
        return (cur >> 1);
    }
    // 根节点是1
    public int leftChild(int cur) {
        return (cur << 1);
    }
    // 根节点是1
    public int rightChild(int cur) {
        return (cur << 1) + 1;
    }

    // 通过让A[i]的值在堆中逐级下降, 从而使得下标i为根节点的子树重新遵循最大堆的性质
    public void max_heapify(int[] heap, int i) {
        int l = leftChild(i);
        int r = rightChild(i);
        int lagest;
        if (l <= heap.length && heap[l] > heap[i]) {
            lagest = l;
        } else {
            lagest = i;
        }
        if (r <= heap.length && heap[r] > heap[lagest]) {
            lagest = r;
        }
        if (lagest != i) {
            int tmp = heap[i];
            heap[i] = heap[lagest];
            heap[lagest] = tmp;
            max_heapify(heap, lagest);
        }
    }

    // 用自底向上方法利用max_heapify方法把一个数组转化为最大堆. 用heap[0]存放堆大小
    public void build_max_heap(int[] heap) {
        heap[0] = heap.length;
        for (int i = heap.length / 2; i > 0; i--) {
            max_heapify(heap, i);
        }
    }

    // 插入时, 把n插入到heap的最后一个值中, 然后, 自底向上浮起
    public void insert(int[] heap, int n) {

    }

    // 弹出第一个头结点后, 把heap中的最后一个值放到头中, 然后从上到下维护一次堆
    public int pop(int[] heap) {
        return heap[1];
    }

    public void heapsort() {

    }

    public void max_heap_insert() {

    }
//    public void init() {
//        int n = 0;
//        int size = 10;
//        int[] heapList = new int[size];
//        int[] nums = new int[]{5,4,3,2,1,6,7,8,9,10};
//
//
//    }
//
//    // n代表当前数组中存入了多少个元素, 这里实现的是小根堆
//    public void insert(int[] heaplist, int n, int num) {
//
//    }

}

class ArrayPriorityQueue {

    private final int maxSize;

    private int length = 0;

    private final int[][] array;

    public ArrayPriorityQueue(int maxSize) {
        this.maxSize = maxSize;
        this.array = new int[this.maxSize][2];
    }

    public boolean isEmpty() {
        return this.length == 0;
    }

    public int[] peek() {
        return this.array[0];
    }

    public boolean isFull() {
        return this.length == this.maxSize;
    }

    public void enQueue(int[] data) {
        if (isFull()) {
            this.array[0] = data;
            // 从堆顶开始调整堆
            adjustHeap(this.array, this.length);
        } else {
            // 如果不是满的, 需要将其挂到最后的位置, 然后往上浮
            this.array[this.length] = data;
            int rootIndex = this.length++;
            int parentIndex = rootIndex % 2 == 0 ? rootIndex / 2 - 1 : rootIndex / 2;
            while (rootIndex > 0 && data[1] < this.array[parentIndex][1]) {
                // 元素下沉(就是这个位置, 用的rootIndex / 2而不是parentIndex, 改了两次才改好)
                this.array[rootIndex] = this.array[parentIndex];
                // 第一次就是改这里, 原本是rootIndex /= 2, 但是因为根节点是从0开始的, 因此需要加判断
                rootIndex = parentIndex;
                parentIndex = rootIndex % 2 == 0 ? rootIndex / 2 - 1 : rootIndex / 2;
            }
            this.array[rootIndex] = data;
        }
    }

    public int[][] getArray() {
        return this.array;
    }

    private void adjustHeap(int[][] array, int length) {
        // 取出当前子树的根元素的值
        int index = 0;
        int[] root = array[index];
        for (int leftOrRightIndex = 1; leftOrRightIndex < length; leftOrRightIndex = leftOrRightIndex * 2 + 1) {
            // 找出root的左右子树谁小
            if (leftOrRightIndex + 1 < length && array[leftOrRightIndex][1] > array[leftOrRightIndex + 1][1]) {
                // 右子树的根更小, 转右子树
                leftOrRightIndex++;
            }
            if (root[1] > array[leftOrRightIndex][1]) {
                // 根的值下移动, 虽然此时root的左/右子树的值覆盖了它父节点的值, 但是没关系, 它父节点的值保存在了root中
                // 没有进行上移的那个子树本身就符合堆, 不需要管; 调整发生了改变的子树
                array[index] = array[leftOrRightIndex];
                index = leftOrRightIndex;
            } else {
                // 调整结束, 当前子树的根适合放root值
                break;
            }
            array[index] = root;
        }
    }

}
