public class Main {
    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};

        UniversalSort sort  = new QuickSortAdapter();
        sort.sort(arr);


        System.out.println(java.util.Arrays.toString(arr));
    }
}
