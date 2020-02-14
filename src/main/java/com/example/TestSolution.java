package com.example;

import org.springframework.util.CollectionUtils;

import java.lang.reflect.Array;
import java.util.*;

public class TestSolution {

    public Map<Integer, char[]> map = new HashMap<>();

    {
        map.put(0, new char[]{});
        map.put(1, new char[]{});
        map.put(2, new char[]{'a', 'b', 'c'});
        map.put(3, new char[]{'d', 'e', 'f'});
        map.put(4, new char[]{'g', 'h', 'i'});
        map.put(5, new char[]{'j', 'k', 'l'});
        map.put(6, new char[]{'m', 'n', 'o'});
        map.put(7, new char[]{'p', 'q', 'r', 's'});
        map.put(8, new char[]{'t', 'u', 'v'});
        map.put(9, new char[]{'w', 'x', 'y', 'z'});
    }

    public List<String> getResult(Integer[] params) {
        List<String> result = new ArrayList<>();
        if (params.length == 0) {
            return result;
        }
        combine(params, result, "", 0);
        return result;
    }

    public void combine(Integer[] digits, List<String> result, String beforString, int nowIndex) {
        Integer digit = digits[nowIndex];
        if (digit == 0 || digit == 1) {
            return;
        }
        int length = digits.length;

        if (length == 1) {
            char[] nowChars = getCharsByNum(digit);
            for (int i = 0; i < nowChars.length; i++) {
                char nowChar = nowChars[i];
                result.add(String.valueOf(nowChar));
            }
            return;
        }
        if (nowIndex >= length) {
            result.add(beforString);
            return;
        }

        char[] nowChars = getCharsByNum(digit);
        for (int i = 0; i < nowChars.length; i++) {
            combine(digits, result, beforString + nowChars[i], nowIndex + 1);
        }

    }

    public char[] getCharsByNum(Integer num) {
        return map.get(num);
    }

    public static void main(String[] args) {
        TestSolution testSolution = new TestSolution();
        Integer data[] = {9};
        List<String> result = testSolution.getResult(data);
        System.out.println(result);
    }

}
