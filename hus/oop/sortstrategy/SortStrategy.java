package hus.oop.sortstrategy;

public class SortStrategy {
    // Singleton Pattern, chỉ cho phép tạo ra nhiều nhất một đối tượng trong chương trình.
    private static SortStrategy instance;

    private Sorter sortee;

    // Hàm dựng là private, nên không tạo được đối tượng từ bên ngoài.
    private SortStrategy() {
        this.sortee = null;
    }

    /**
     * Phương thức dùng để tạo đối tượng SortStrategy.
     * @return
     */
    public static SortStrategy getInstance() {
        if (instance == null) {
            instance = new SortStrategy();
        }
        return instance;
    }

    /**
     * Phương thức dùng để lựa chọn thuật toán sắp xếp.
     * @param sortee
     * @return đối tượng hiện tại.
     */
    public SortStrategy setSortee(Sorter sortee) {
        this.sortee = sortee;
        return this;
    }

    /**
     * Phương thức thực hiện sắp xếp mảng dữ liệu.
     * @param data
     */
    public void sort(double[] data, boolean order) {
        if (sortee != null) {
            sortee.sort(data, order);
        } else {
            System.out.println("Không có thuật toán sắp xếp được chọn.");
        }
    }
}
