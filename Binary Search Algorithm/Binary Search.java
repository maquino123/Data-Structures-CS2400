public class Binary Search {
    public boolean BinSearch(int[] A, int start, int end, int val) {
        if (start > end){
            return false;
        }

        int midpoint = start + (end - start)/2;

        if (A[midpoint] == val){
            return true;
        }

        if (A[midpoint] < val){
            return BinSearch(A, midpoint++, end, val);
        }

        return BinSearch(A, start, midpoint-1, val);
    }


}