import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AplikasiSorting {

    enum Order {
        ASCENDING, DESCENDING
    }

    public static void bubbleSort(int[] arr, Order order) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if ((order == Order.ASCENDING && arr[j] > arr[j + 1]) ||
                    (order == Order.DESCENDING && arr[j] < arr[j + 1])) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void quickSort(int[] arr, int low, int high, Order order) {
        if (low < high) {
            int pi = partition(arr, low, high, order);
            quickSort(arr, low, pi - 1, order);
            quickSort(arr, pi + 1, high, order);
        }
    }

    private static int partition(int[] arr, int low, int high, Order order) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if ((order == Order.ASCENDING && arr[j] < pivot) ||
                (order == Order.DESCENDING && arr[j] > pivot)) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Selamat datang di Aplikasi Sorting!");

            System.out.println("Apakah Anda ingin menginput nilai sendiri? (ya/tidak)");
            boolean generateArray = scanner.next().equalsIgnoreCase("tidak");
            int[] arr;

            if (generateArray) {
                System.out.print("Masukkan ukuran array: ");
                int n = scanner.nextInt();
                System.out.print("Masukkan rentang nilai (contoh: 100 untuk 0-99): ");
                int range = scanner.nextInt();
                arr = generateRandomArray(n, range);
                System.out.println("Array yang dihasilkan: ");
                printArray(arr);
            } else {
                System.out.print("Masukkan ukuran array: ");
                int n = scanner.nextInt();
                arr = new int[n];
                System.out.println("Masukkan elemen-elemen array:");
                for (int i = 0; i < n; i++) {
                    arr[i] = scanner.nextInt();
                }
            }

            System.out.println("Pilih metode pengurutan:");
            System.out.println("1. Bubble Sort");
            System.out.println("2. Quick Sort");
            int method = scanner.nextInt();

            System.out.println("Pilih urutan:");
            System.out.println("1. Ascending (dari kecil ke besar)");
            System.out.println("2. Descending (dari besar ke kecil)");
            int orderChoice = scanner.nextInt();
            Order order = (orderChoice == 1) ? Order.ASCENDING : Order.DESCENDING;

            switch (method) {
                case 1:
                    bubbleSort(arr, order);
                    System.out.println("Array setelah diurutkan menggunakan Bubble Sort:");
                    break;
                case 2:
                    quickSort(arr, 0, arr.length - 1, order);
                    System.out.println("Array setelah diurutkan menggunakan Quick Sort:");
                    break;
                default:
                    System.out.println("Pilihan metode tidak valid!");
                    return;
            }

            printArray(arr);

        } catch (InputMismatchException e) {
            System.out.println("Input tidak valid. Harap masukkan angka saja.");
        } finally {
            scanner.close();
        }
    }

    private static int[] generateRandomArray(int size, int range) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * range);
        }
        return arr;
    }
}
