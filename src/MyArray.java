public class MyArray {

    private int[] array;
    private int capacity;
    private int size;

    MyArray(int capacity){
        array = new int[capacity];
        this.capacity = capacity;
        size=0;
    }

    // retrieval of element by index
    public int retrieve(int index) throws Exception{
        if(index>0 && index <size)
            return array[index];
        throw new Exception("Index not in range of array");
    }

    // search for an element in unsorted array returns index position
    public int search(int target){

        int j=0,k=size-1;
        while(j<=k){
            if(array[j]==target)
                return j;
            else if(array[k]==target)
                return k;
            j++;k--;
        }
        return -1; // if element not found
    }

    // search for an element in sorted array returns index position
    public int searchSorted(int target){
        
        if(size==0){
            return -1;
        }
        else if(target<array[0] || target>array[size-1]){
            return -1;
        }
        int low=0,high=size-1,mid;

        while(low<=high){
            mid = low + (high-low) / 2;

            if(array[mid]==target){
                return mid;
            }
            else if(target<array[mid]){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return -1;
    }

    // add element at last
    public void add(int element){
        if(isFull()){
            System.out.println("Array is full");
            array = resizeArray();
            System.out.println("Array Resized.");
        }
        array[size++] = element;
        System.out.println("Element inserted : "+element);
    }

    // add element at specific position
    public void addAtPosition(int element,int position) throws Exception{
        if(position<1 || position>size+1){
            throw new Exception("Position invalid");
        }
        if(isFull()){
            System.out.println("Array is full");
            array = resizeArray();
            System.out.println("Array Resized.");
        }
        for(int i=size;i>=position;i--){
            array[i] = array[i-1];
        }
        array[position-1] = element;
        size++;
        System.out.println("Element inserted : "+element +" at position : "+position);
    }

    // deleting element at index
    public void delete(int position) throws Exception{
        if(position<1 || position > size){
            throw new Exception("Position invalid");
        }
        int element = array[position-1];
        for(int i=position-1;i<size-1;i++){
            array[i] = array[i+1];
        }
        System.out.println("Element deleted : "+element +" at position : "+position);
        size--;
    }

    public int[] resizeArray(){
        capacity = capacity*2;
        int[] newarray = new int[capacity];
        for(int i=0;i<size;i++){
            newarray[i] = array[i];
        }
        return newarray;
    }

    public boolean isFull(){
        return capacity == size;
    }

    public void display(){
        System.out.print("Array : ");
        for(int i=0;i<size;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
}
