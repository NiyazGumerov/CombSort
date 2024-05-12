import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CombSort {
    public int getNextGap(int gap) {
        gap = (gap * 100) / 125; //здесь мы уменьшаем наш шаг в 1.25 раз, а чтобы алгоритм работал быстрее, и не было перевода из double в int умножаю на 100 и делю на 125
        if (gap < 1)
            return 1;
        return gap;
    }

    public long[] sort(int arr[]) {
        int n = arr.length;
        int gap = n;
        boolean swapped = true; //вводим swapped чтобы убедиться, что цикл выполняется
        long startTime = System.nanoTime();
        long counter = 0;
        while (gap != 1 || swapped == true) //продолжаем выполнение, пока шаг не будет равен 1 и последняя итерация вызывает замену
        {
            gap = getNextGap(gap); //получем следующий шаг
            swapped = false;
            for (int i = 0; i < n - gap; i++) {
                counter++;
                if (arr[i] > arr[i + gap]) {
                    int temp = arr[i];
                    arr[i] = arr[i + gap];
                    arr[i + gap] = temp;
                    swapped = true;
                }
            }
        }
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;
        return new long[]{counter, executionTime};
    }

    public static void main(String args[]) {
        CombSort ob = new CombSort();
        long iterations = 0;
        long time = 0;
        for (int i = 1; i < 51; i++) {
            int[] numbers = null;
            int index = 0;
            try {
                File file = new File("input_set_" + i + ".txt");
                Scanner scanner = new Scanner(file);
                // Подсчет количества чисел в файле
                int count = 0;
                while (scanner.hasNextInt()) {
                    count++;
                    scanner.nextInt();
                }
                // Создание массива нужного размера
                numbers = new int[count];
                // Повторное открытие файла для считывания чисел
                scanner = new Scanner(file);
                // Считывание чисел в массив
                while (scanner.hasNextInt()) {
                    numbers[index] = scanner.nextInt();
                    index++;
                }
                scanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("File not found.");
            }
            long[] result = ob.sort(numbers);
            iterations += result[0];
            time += result[1];
            System.out.println(index + " " + result[0] + " " + result[1]);
        }
        System.out.println("Кол-во итераций " + iterations + ". Время выполнения (в наносекундах): " + time);
    }
}