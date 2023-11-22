package hus.oop.statistics;

import java.util.Random;

public class TestStatistics {
    public static void main(String[] args) {
//        testStatisticsUsingArrayDataSet();
        testStatisticsUsingLinkedListDataSet();
        /* Yêu cầu:

        I. Hoàn thiện các file source code đã cho. Viết các chức năng test cho chương trình.
        Viết hàm test cho ArrayDataSet:
            1. Sinh ngẫu nhiên một số tự nhiên nằm trong đoạn [20 - 30]. Tạo ra tập dữ liệu kiểu ArrayDataSet gồm các phần tử
               là các số double được sinh ngẫu nhiên, và có số phần tử bằng số tự nhiên đã cho.
            2. In ra các dữ liệu thống kê về tập dữ liệu (tập dữ liệu, cỡ mẫu, max, min, kỳ vọng, phương sai, rank, median).
            3. Xóa một phần tử ở đầu tập dữ liệu và một phần tử ở cuối tập dữ liệu. In ra các dữ liệu thống kê về tập dữ liệu
               (tập dữ liệu, cỡ mẫu, max, min, kỳ vọng, phương sai, rank, median).

         Viết hàm test cho LinkedListDataSet:
            1. Sinh ngẫu nhiên một số tự nhiên nằm trong đoạn [20 - 30]. Tạo ra tập dữ liệu kiểu ArrayDataSet gồm các phần tử
               là các số double được sinh ngẫu nhiên, và có số phần tử bằng số tự nhiên đã cho.
            2. In ra các dữ liệu thống kê về tập dữ liệu (tập dữ liệu, cỡ mẫu, max, min, kỳ vọng, phương sai, rank, median).
            3. Xóa một phần tử ở đầu tập dữ liệu và một phần tử ở cuối tập dữ liệu. In ra các dữ liệu thống kê về tập dữ liệu
               (tập dữ liệu, cỡ mẫu, max, min, kỳ vọng, phương sai, rank, median).

         II. Chạy các hàm test để test chương trình.
         Copy kết quả chạy chương trình và lưu vào file text có tên <TenSinhVien_MaSinhVien_Statistics>.txt
         (ví dụ, NguyenVanA_123456S_Statistics.txt).
         Nén các file source code và file text kết quả chạy chương trình theo định dạng .zip,
         đặt tên là <TenSinhVien_MaSinhVien_Statistics>.zip (ví dụ, NguyenVanA_123456_Statistics.zip) và nộp lên classroom.
         */
    }

    /**
     * Hàm test cho tập dữ liệu kiểu ArrayDataSet.
     */
    public static void testStatisticsUsingArrayDataSet() {
        Random random = new Random();
        int randomSize = random.nextInt(11) + 20; // Random size in [20, 30]

        AbstractDataSet arrayDataSet = new ArrayDataSet();
        for (int i = 0; i < randomSize; i++) {
            double randomValue = random.nextDouble() * 100; // Adjust range as needed
            arrayDataSet.append(randomValue);
        }

        Statistics statistics = new BasicStatistics(arrayDataSet);

        System.out.println("Dataset: " + arrayDataSet);
        System.out.println("Size: " + arrayDataSet.size());
        System.out.println("Max: " + statistics.max());
        System.out.println("Min: " + statistics.min());
        System.out.println("Mean: " + statistics.mean());
        System.out.println("Variance: " + statistics.variance());
        System.out.println("Rank: " + statistics.rank());
        System.out.println("Median: " + statistics.median());

        // Remove elements from the array
        arrayDataSet.remove(0);
        arrayDataSet.remove(arrayDataSet.size() - 1);

        System.out.println("\nAfter removing elements:");
        System.out.println("Dataset: " + arrayDataSet);
        System.out.println("Size: " + arrayDataSet.size());
        System.out.println("Max: " + statistics.max());
        System.out.println("Min: " + statistics.min());
        System.out.println("Mean: " + statistics.mean());
        System.out.println("Variance: " + statistics.variance());
        System.out.println("Rank: " + statistics.rank());
        System.out.println("Median: " + statistics.median());
    }

    /**
     * Hàm test cho tập dữ liệu kiểu LinkedListDataSet.
     */
    public static void testStatisticsUsingLinkedListDataSet() {
        Random random = new Random();
        int randomSize = random.nextInt(11) + 20; // Random size in [20, 30]

        LinkedListDataSet linkedListDataSet = new LinkedListDataSet();
        for (int i = 0; i < randomSize; i++) {
            double randomValue = random.nextDouble() * 100; // Adjust range as needed
            linkedListDataSet.append(randomValue);
        }

        Statistics statis = new BasicStatistics(linkedListDataSet);

        System.out.println("Dataset: " + linkedListDataSet);
        System.out.println("Size: " + linkedListDataSet.size());
        System.out.println("Max: " + statis.max());
        System.out.println("Min: " + statis.min());
        System.out.println("Mean: " + statis.mean());
        System.out.println("Variance: " + statis.variance());
//        System.out.println("Rank: " + statis.rank());
        System.out.println("Median: " + statis.median());

        // Remove elements from the array
        linkedListDataSet.remove(0);
        linkedListDataSet.remove(linkedListDataSet.size() - 1);

        System.out.println("\nAfter removing elements:");
        System.out.println("Dataset: " + linkedListDataSet);
        System.out.println("Size: " + linkedListDataSet.size());
        System.out.println("Max: " + statis.max());
        System.out.println("Min: " + statis.min());
        System.out.println("Mean: " + statis.mean());
        System.out.println("Variance: " + statis.variance());
//        System.out.println("Rank: " + statis.rank());
        System.out.println("Median: " + statis.median());
    }
}
