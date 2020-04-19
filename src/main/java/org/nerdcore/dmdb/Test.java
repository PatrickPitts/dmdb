package org.nerdcore.dmdb;


import org.springframework.data.relational.core.sql.In;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        for(int n : digitList(100000)){
            System.out.println(n);
        }
    }

    public static String[] removeAllOfLen(int len){
        String[] oldArr = {"the","quick","brown", "fox", "jumped", "over", "the","lazy", "dog"};

        String[] newArr = new String[oldArr.length - 4];

        int j = 0;
        for(int i=0; i < oldArr.length;i++){
            if(oldArr[i].length() != len){
                newArr[j] = oldArr[i];
                j++;
            }
        }
        return newArr;

    }

    public static ArrayList<Integer> digitList(int num){
        ArrayList<Integer> digits = new ArrayList<>();
        int len = Integer.toString(num).length();
        for(int i = 0; i < len; i++){
            digits.add(0, num%10);
            num/=10;
        }
        return digits;
    }
}
