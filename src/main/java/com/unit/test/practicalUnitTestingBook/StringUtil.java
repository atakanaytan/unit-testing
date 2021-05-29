package com.unit.test.practicalUnitTestingBook;

public class StringUtil {

    public static String reverse(String s) {

        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException(
                    "illegal parameter :  [" + s + "] ");
        }

        int i = 0;
        int j = s.length() - 1;
        char[] arr = s.toCharArray();

        while (j >= i) {
            char temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
            j--;
            i++;
        }

        return new String(arr);
    }

    public static void main(String[] args) {
        String s = "entscheidung";

        System.out.println(reverse(s));
    }
}
