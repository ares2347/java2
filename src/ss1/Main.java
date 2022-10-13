package ss1;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args){
        HashSet<String> hs = new HashSet<>();
        hs.add("Hello");
        hs.add("World!");
        PriorityQueue<Integer> numbers = new PriorityQueue<>();
        numbers.add(2);
        numbers.add(4);
        numbers.add(1);

        int first = numbers.peek();
        int total = numbers.size();
        numbers.poll();

        PriorityQueue<Student> st = new PriorityQueue<>(
                new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
                        return o2.getMark() - o1.getMark();
                    }
                }
        );
        st.add(new Student("A", 5));
        st.add(new Student("T", 8));
        st.add(new Student("X", 1));

        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("ten", 10);
        hm.put("three", 3);
        hm.get("ten");

    }
}
