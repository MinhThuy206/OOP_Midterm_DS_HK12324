package hus.oop.statistics;

import java.util.Arrays;

public class BasicStatistics implements Statistics {
    private DataSet dataSet;

    /**
     * Hàm khỏi tạo tập dữ liệu
     */
    public BasicStatistics(DataSet dataSet) {
        this.dataSet = dataSet;
    }



    public void setDataSet(DataSet dataSet) {
        this.dataSet = dataSet;
    }

    @Override
    public int size() {
        return dataSet.size();
    }

    @Override
    public double max() {
        int size = dataSet.size();
        if (size == 0) {
            throw new IllegalStateException("Empty dataset");
        }

        double max = dataSet.get(0);
        for (int i = 1; i < size; i++) {
            double current = dataSet.get(i);
            if (current > max) {
                max = current;
            }
        }
        return max;
    }

    @Override
    public double min() {
        int size = dataSet.size();
        if (size == 0) {
            throw new IllegalStateException("Empty dataset");
        }

        double min = dataSet.get(0);
        for (int i = 1; i < size; i++) {
            double current = dataSet.get(i);
            if (current < min) {
                min = current;
            }
        }
        return min;
    }

    @Override
    public double mean() {
        int size = dataSet.size();
        if (size == 0) {
            throw new IllegalStateException("Empty dataset");
        }

        double sum = 0;
        for (int i = 0; i < size; i++) {
            sum += dataSet.get(i);
        }
        return sum / size;
    }

    @Override
    public double variance() {
        int size = dataSet.size();
        if (size <= 1) {
            throw new IllegalStateException("Dataset size must be greater than 1 for variance calculation");
        }

        double mean = mean();
        double sumSquaredDiff = 0;
        for (int i = 0; i < size; i++) {
            double diff = dataSet.get(i) - mean;
            sumSquaredDiff += diff * diff;
        }
        return sumSquaredDiff / (size - 1);
    }

    @Override
    public AbstractDataSet rank() {
        if (dataSet instanceof ArrayDataSet) {
            ArrayDataSet arrayDataSet = (ArrayDataSet) dataSet;
            double[] sortedArray = Arrays.copyOf(arrayDataSet.toArray(), arrayDataSet.size());
            Arrays.sort(sortedArray);
            ArrayDataSet rankedDataSet = new ArrayDataSet();
            for (double value : arrayDataSet.toArray()) {
                int rank = Arrays.binarySearch(sortedArray, value) + 1;
                rankedDataSet.append(rank);
            }
            return rankedDataSet;
        } else {
            throw new UnsupportedOperationException("Ranking not supported for this dataset type");
        }
    }

    @Override
    public double median() {
        int size = dataSet.size();
        if (size == 0) {
            throw new IllegalStateException("Empty dataset");
        }

        double[] sortedArray = Arrays.copyOf(dataSet.toArray(), size);
        Arrays.sort(sortedArray);

        if (size % 2 == 0) {
            int middleIndex1 = size / 2 - 1;
            int middleIndex2 = size / 2;
            return (sortedArray[middleIndex1] + sortedArray[middleIndex2]) / 2.0;
        } else {
            int middleIndex = size / 2;
            return sortedArray[middleIndex];
        }
    }
}
