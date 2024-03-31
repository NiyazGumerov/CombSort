import java.io.*;

public class CombSort {
    int getNextGap(int gap) {
        gap = (gap * 100) / 125; //здесь мы уменьшаем наш шаг в 1.25 раз, а чтобы алгоритм работал быстрее, и не было перевода из double в int умножаю на 100 и делю на 125
        if (gap < 1)
            return 1;
        return gap;
    }

    void sort(int arr[]) {
        int n = arr.length;
        int gap = n;
        boolean swapped = true; //вводим swapped чтобы убедиться, что цикл выполняется
        while (gap != 1 || swapped == true) //продолжаем выполнение, пока шаг не будет равен 1 и последняя итерация вызывает замену
        {
            gap = getNextGap(gap); //получем следующий шаг
            swapped = false;
            for (int i = 0; i < n - gap; i++) {
                if (arr[i] > arr[i + gap]) {
                    int temp = arr[i];
                    arr[i] = arr[i + gap];
                    arr[i + gap] = temp;
                    swapped = true;
                }
            }
        }
    }

    public static void main(String args[]) {
        CombSort ob = new CombSort();
        int arr[] = {8, 4, 1, 56, 3, -44, 23, -6, 28, 0};
        ob.sort(arr);

        System.out.println("sorted array");
        for (int i = 0; i < arr.length; ++i)
            System.out.print(arr[i] + " ");

    }
}