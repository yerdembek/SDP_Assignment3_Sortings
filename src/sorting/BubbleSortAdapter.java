package sorting;

import sorting.typesOfSort.BubbleSort;

public class BubbleSortAdapter implements UniversalSort {
    private BubbleSort bubbleSort =  new BubbleSort();

    @Override
    public void sort(int[] arr) {
        bubbleSort.bubbleSort(arr);
    }
}
