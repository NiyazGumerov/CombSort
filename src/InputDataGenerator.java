import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class InputDataGenerator {

    public static void main(String[] args) {
        generateInputData(50, 100, 10000);
    }

    public static void generateInputData(int numSets, int minSize, int maxSize) {
        Random random = new Random();
        for (int i = 1; i <= numSets; i++) {
            int size = random.nextInt(maxSize - minSize + 1) + minSize;
            try {
                FileWriter writer = new FileWriter("input_set_" + i + ".txt");
                for (int j = 0; j < size; j++) {
                    int randomNumber = random.nextInt(2001) - 1000; // Генерация случайного числа от -1000 до 1000
                    writer.write(randomNumber + "\n");
                }
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
