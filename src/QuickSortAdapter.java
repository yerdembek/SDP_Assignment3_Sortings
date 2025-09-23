import typesOfSort.QuickSort;

public class QuickSortAdapter implements UniversalSort{
    private QuickSort quickSort = new QuickSort();

    public void sort(int[] arr){
        quickSort.quickSort(arr);
    }
}
