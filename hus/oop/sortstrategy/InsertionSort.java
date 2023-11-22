package hus.oop.sortstrategy;

public class InsertionSort implements Sorter {
    /**
     * Phương thức sắp xếp dữ liệu sử dụng thuật toán Insertion sort.
     * @param data
     */
    @Override
    public void sort(double[] data, boolean order) {
        if(order){
            sortAscending(data);
        }else{
            sortDescending(data);
        }
    }

    /**
     * Phương thức sắp xếp mảng dữ liệu theo thứ tự tăng dần,
     * sử dụng thuật toán Insertion sort.
     * @param data
     */
    private void sortAscending(double[] data) {
        int len = data.length;
        for (int i = 1; i < len - 1; i++) {
            int j = i;
            while (j > 0 && data[j - 1] > data[j]) {
                double temp = data[j];
                data[j] = data[j - 1];
                data[j - 1] = temp;
                j = j -1;
            }
        }
    }

    /**
     * Phương thức sắp xếp mảng dữ liệu theo thứ tự giảm dần,
     * sử dụng thuật toán Insertion sort.
     * @param data
     */
    private void sortDescending(double[] data) {
        int len = data.length;
        for (int i = 1; i < len - 1; i++) {
            int j = i;
            while (j > 0 && data[j - 1] < data[j]) {
                double temp = data[j];
                data[j] = data[j - 1];
                data[j - 1] = temp;
                j = j -1;
            }
        }
    }
}
