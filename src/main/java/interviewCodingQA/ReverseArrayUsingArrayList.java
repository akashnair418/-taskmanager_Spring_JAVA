package interviewCodingQA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ReverseArrayUsingArrayList {

    public static void main(String[] args){

        int[] arr ={10,20,30};
        String[] languages = {"Java", "Python", "C++"};
        String[] result2 = reverseArrayofStrings(languages);
        int[] result = reverseArrayusingArrayList(arr);
        System.out.println(Arrays.toString(result));
        System.out.println(Arrays.toString(result2));
    }

    private static int[] reverseArrayusingArrayList(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int num: arr){
            list.add(num);
        }
        Collections.reverse(list);

        for(int i = 0; i<arr.length; i++){
            arr[i] = list.get(i);
        }
        return arr;
    }

    private static String[] reverseArrayofStrings(String[] languages) {
        ArrayList<String> stringofarray = new ArrayList<>(Arrays.asList(languages));
        System.out.println(stringofarray);
        return stringofarray.toArray(new String[0]);
    }
}
