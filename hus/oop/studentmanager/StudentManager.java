package hus.oop.studentmanager;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class StudentManager {
    private List<Student> studentList;

    StudentManager() {
        this.studentList = new LinkedList<>();
    }

    /**
     * Phương thức kiểm tra xem chỉ số index có nằm trong đoạn [0 - limit] hay không.
     * @param index
     * @param limit
     * @return
     */
    private boolean checkBoundaries(int index, int limit) {
        return index >= 0 && index <= limit;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void append(Student student) {
        studentList.add(student);
    }

    public void add(Student student, int index) {
        if (checkBoundaries(index, studentList.size())) {
            studentList.add(index, student);
        }
    }

    public void remove(int index) {
        if (checkBoundaries(index, studentList.size() - 1)) {
            studentList.remove(index);
        }
    }

    public Student studentAt(int index) {
        if (checkBoundaries(index, studentList.size() - 1)) {
            return studentList.get(index);
        }
        return null;
    }

    /**
     * Sắp xếp danh sách sinh viên theo thứ tự tăng dần theo tên và sau đó đến họ.
     * @return
     */
    public List<Student> sortStudentByName() {
        List<Student> sortedList = new LinkedList<>(studentList);
        Collections.sort(sortedList, new MyStudentNameComparator());
        return sortedList;
    }

    /**
     * Sắp xếp danh sách sinh viên theo thứ tự tăng dần theo tiêu chí, đầu tiên so sánh điểm trung bình,
     * nếu điểm trung bình bằng nhau thì so sánh điểm toán.
     * Sử dụng giao diện MyStudentComparator để thực hiện tiêu chí sắp xếp.
     *
     * @return
     */
    public List<Student> sortByGradeIncreasing() {
        List<Student> sortedList = new LinkedList<>(studentList);
        Collections.sort(sortedList, new MyStudentGradeComparator(true));
        return sortedList;
    }

    /**
     * Sắp xếp danh sách sinh viên theo thứ tự giảm dần theo tiêu chí, đầu tiên so sánh điểm trung bình,
     * nếu điểm trung bình bằng nhau thì so sánh điểm toán.
     * Sử dụng giao diện MyStudentComparator để thực hiện tiêu chí sắp xếp.
     *
     * @return
     */
    public List<Student> sortByGradeDecreasing() {
        List<Student> sortedList = new LinkedList<>(studentList);
        Collections.sort(sortedList, new MyStudentGradeComparator(false));
        return sortedList;
    }

    /**
     * Lọc ra howMany sinh viên có kết quả tốt nhất, theo tiêu chí đầu tiên so sánh điểm trung bình,
     * nếu điểm trung bình bằng nhau thì so sánh điểm toán.
     * @param howMany
     * @return
     */
    public List<Student> filterStudentsHighestGrade(int howMany) {
        List<Student> sortedList = sortByGradeDecreasing();
        return sortedList.subList(0, Math.min(howMany, sortedList.size()));
    }

    /**
     * Lọc ra howMany sinh viên có kết quả thấp nhất, theo tiêu chí đầu tiên so sánh điểm trung bình,
     * nếu điểm trung bình bằng nhau thì so sánh điểm toán.
     * @param
     * @return
     */

    private static class MyStudentGradeComparator implements Comparator<Student> {
        private final boolean increasingOrder;

        public MyStudentGradeComparator(boolean increasingOrder) {
            this.increasingOrder = increasingOrder;
        }

        @Override
        public int compare(Student student1, Student student2) {
            int result = Double.compare(student1.getAverageGrade(), student2.getAverageGrade());
            if (result == 0) {
                result = Double.compare(student1.getMathsGrade(), student2.getMathsGrade());
            }
            return increasingOrder ? result : -result;
        }
    }

    private static class MyStudentNameComparator implements Comparator<Student> {
        @Override
        public int compare(Student student1, Student student2) {
            return student1.getLastname().compareTo(student2.getLastname());
        }
    }
    public List<Student> filterStudentsLowestGrade(int howMany) {
        List<Student> sortedList = sortByGradeIncreasing();
        return sortedList.subList(0, Math.min(howMany, sortedList.size()));
    }

    public static String idOfStudentsToString(List<Student> studentList) {
        StringBuilder idOfStudents = new StringBuilder();
        idOfStudents.append("[");
        for (Student student : studentList) {
            idOfStudents.append(student.getId()).append(" ");
        }
        return idOfStudents.toString().trim() + "]";
    }

    public static void print(List<Student> studentList) {
        StringBuilder studentsString = new StringBuilder();
        studentsString.append("[\n");
        for (Student student : studentList) {
            studentsString.append(student.toString()).append("\n");
        }
        System.out.print(studentsString.toString().trim() + "\n]");
    }
}