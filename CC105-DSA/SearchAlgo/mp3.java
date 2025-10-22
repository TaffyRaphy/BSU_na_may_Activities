package SearchAlgo;

public class mp3 {
    public static int linearSearch(int[] array, int key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] array, int key) {
        int left = 0, right = array.length - 1;
        
        while (left <= right){
            int middle = left + (right-left)/2;
            
            if(array[middle] == key){
                return middle;
            }
            
            if(array[middle] < key){
                left = middle + 1;
            } else{
                right = middle - 1;
            }
        }
        return -1;
    }
}
