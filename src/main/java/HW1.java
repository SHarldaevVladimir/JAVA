// 1. Выбросить случайное целое число в диапазоне от 0 до 2000 и сохранить в i
//   2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
//   3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1
//   4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2

import java.util.Random;

public class HW1 {
    static int number = new Random().nextInt(2000);
    public static void main(String[] args) {
        System.out.println("Выброшенное число: " + number);
        int n = getBit();
        System.out.println("Старший значащий бит выпавшего числа: " + n);
        int m1[] = getFirstArray();
        int m2[] = getSecondArray();
    }

    public static int getBit() {
        int n = 0;
        while ((int) Math.pow(2, n) <= number) {
            n++;
        }
        n -= 1;
        return n;
    }

    public static int[] getFirstArray() {
        int count = 0;
        for (int i = number; i < Short.MAX_VALUE ; i++) {
            if (i % getBit() == 0 ) count++;
        }
        System.out.println("Количество элементов массива m1: " + count);
        int[] m1 = new int[count];
        int k = 0;
        for (int i = number; i < Short.MAX_VALUE ; i++) {
            if (i % getBit() == 0) {
                m1[k] = i;
                k++;
            }
        }
        return m1;
    }

    public static int[] getSecondArray() {
        int count = 0;
        for (int i = Short.MIN_VALUE; i < number; i++) {
            if (i % getBit() != 0) count++;
        }
        System.out.println("Количество элементов массива m2: " + count);
        int[] m2 = new int[count];
        int k = 0;
        for (int i = Short.MIN_VALUE; i < number; i++) {
            if (i % getBit() != 0) {
                m2[k] = i;
                k++;
            }

        }
    return m2;
    }
}