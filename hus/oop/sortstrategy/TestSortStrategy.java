package hus.oop.sortstrategy;

import java.util.Arrays;
import java.util.Random;

public class TestSortStrategy {
    public static void main(String[] args) {
        /* Yêu cầu:
        - Sinh ra ngẫu nhiên một số tự nhiên có giá trị nằm trong khoảng [20 - 30].
        - Sinh ra ngẫu nhiên một mảng các số kiểu double, có kích thước bằng số tự nhiên đã sinh ngẫu nhiên ở trên.
        - Copy dữ liệu mảng trên sang 2 mảng khác để có 3 mảng có dữ liệu giống nhau.
        - Tạo đối tượng có kiểu dữ liệu SortStrategy. Dùng đối tượng này test 3 thuật toán đã cho với 3 mảng dữ liệu trên.
          Các kết quả test được in ra terminal theo định dạng: ví dụ
          Using Bubble Sort Algorithm:
          Before sorting: [5.0 4.0 3.0 2.0 1.0]
          After sorting: [1.0 2.0 3.0 4.0 5.0]

          Using Insertion Sort Algorithm:
          Before sorting: [5.0 4.0 3.0 2.0 1.0]
          After sorting: [1.0 2.0 3.0 4.0 5.0]

        - Kết quả chạy chương trình lưu vào file text được đặt tên <TenSinhVien_MaSinhVien_SortStrategy.txt.
        - Nén các file source code và file text kết quả chạy chương trình vào file zip có tên
          <TenSinhVien_MaSinhVien_StudentManager>.zip (Ví dụ, NguyenVanA_123456_StudentManager.zip),
          nộp lên classroom
         */

        int randomSize = new Random().nextInt(11) + 20;

        // Sinh mảng ngẫu nhiên có kích thước bằng số tự nhiên vừa sinh
        double[] randomArray = new double[randomSize];
        Random rand = new Random();
        for (int i = 0; i < randomSize; i++) {
            randomArray[i] = rand.nextDouble() * 10;
        }


        double[] array1 = Arrays.copyOf(randomArray, randomArray.length);
        double[] array2 = Arrays.copyOf(randomArray, randomArray.length);

        SortStrategy sortStrategy = SortStrategy.getInstance();

        System.out.println("Using Bubble Sort Algorithm:");
        System.out.print("Before sorting:");

        System.out.println(Arrays.toString(randomArray));
        System.out.print("After sorting: ");

        SortStrategy s1 = sortStrategy.setSortee(new BubbleSort());
        s1.sort(array1, true);

        System.out.println(Arrays.toString(array1));


        //
        System.out.println("Using Insertion Sort Algorithm:");
        System.out.print("Before sorting:");

        System.out.println(Arrays.toString(randomArray));
        System.out.print("After sorting: ");

        SortStrategy s2 = sortStrategy.setSortee(new InsertionSort());
        s1.sort(array2, true);

        System.out.println(Arrays.toString(array2));
    }
}
