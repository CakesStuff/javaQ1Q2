package sortieren;

import gui.GUI;
import linear.List;

import java.util.Arrays;

public class Sorting {
    public List<String> quicksort(List<String> strings) {
        int length = 0;
        for(strings.toFirst(); strings.hasAccess(); strings.next()) {
            length++;
        }
        if(length < 2) {
            return strings;
        }
        strings.toFirst();
        String pivot = strings.getContent();

        List<String> left = new List<>();
        List<String> right = new List<>();

        for(strings.next(); strings.hasAccess(); strings.next()) {
            if(strings.getContent().toCharArray()[0] < pivot.toCharArray()[0]) {
                left.append(strings.getContent());
            } else {
                right.append(strings.getContent());
            }
        }

        left = quicksort(left);
        right = quicksort(right);

        List<String> result = new List<>();

        for(left.toFirst(); left.hasAccess(); left.next()) {
            result.append(left.getContent());
        }
        result.append(pivot);
        for(right.toFirst(); right.hasAccess(); right.next()) {
            result.append(right.getContent());
        }
        return result;
    }

    public void mergesort(String[] arr) {
        mergesortRec(arr, 0, arr.length);
    }

    public void mergesortRec(String[] arr, int l, int r) {
        //TODO
    }

    public static void main(String[] args) {
        Sorting s = new Sorting();
        List<String> strings = new List<>();
        strings.append("G");
        strings.append("V");
        strings.append("Z");
        strings.append("A");
        strings.append("J");
        strings.append("E");
        strings.append("C");
        strings.append("J");
        strings.append("N");
        strings.append("Z");
        strings.append("R");
        strings.append("A");
        strings.append("W");
        strings = s.quicksort(strings);

        for(strings.toFirst(); strings.hasAccess(); strings.next()) {
            System.out.println(strings.getContent());
        }
    }
}
