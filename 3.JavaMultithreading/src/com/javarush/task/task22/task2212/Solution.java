package com.javarush.task.task22.task2212;

/* 
Проверка номера телефона
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static boolean checkTelNumber(String telNumber) {
       if(telNumber ==null)
           return false;
        Pattern p1 =Pattern.compile("^\\+(\\d[()]?){12}$|^([()]?\\d){10}$");
        Pattern p2 =Pattern.compile("^(\\+)?(\\d+)?(\\(\\d{3}\\))?\\d+$");
        Matcher m1 =p1.matcher(telNumber);
        Matcher m2 = p2.matcher(telNumber);


        return m1.matches() &&m2.matches();
    }

    public static void main(String[] args) {
        Map<String, Boolean> tests = new HashMap<>();
        // empty string and null
        tests.put("", false);
      //  tests.put(null, false);
        // characters
        tests.put("characters", false);
        tests.put("+abc123456789012", false);
        tests.put("050xxx4567", false);
        // without '+', less than 10 digits
        tests.put("12345678", false);
        tests.put("123456789", false);
        // without '+', more than 10 digits
        tests.put("12345678901", false);
        tests.put("123456789012", false);
        tests.put("1234567890123", false);
        // with '+', less than 12 digits
        tests.put("+1234567890", false);
        tests.put("+12345678901", false);
        // with '+', more than 12 digits
        tests.put("+1234567890123", false);
        tests.put("+12345678901234", false);
        // with '+' and parentheses, less than 12 digits
        tests.put("+12(345)67890", false);
        tests.put("+12(345)678901", false);
        // with '+' and parentheses, more than 12 digits
        tests.put("+12(345)67890123", false);
        tests.put("+12(345)678901234", false);
        // spaces
        tests.put(" +(380)501234567", false);
        tests.put("+(380)501234567 ", false);
        tests.put("+(380) 501234567", false);
        // parentheses
        tests.put("+38)050(1234567", false);
        tests.put("+38050(1234567", false);
        tests.put("+38)0501234567", false);
        tests.put("(380501234567)", false);
        tests.put("(0)501234567", false);
        tests.put("(05)01234567", false);
        tests.put("12(3456789)0", false);
        tests.put("+38(0501234567)", false);
        tests.put("+380501234(567)", false);
        tests.put("0501234(567)", false);
        // dashes
        tests.put("+38(050)123-45-67", false);
        // correct numbers
        tests.put("+380501234567", true);
        tests.put("+(380)501234567", true);
        tests.put("+3(805)01234567", true);
        tests.put("+38(050)1234567", true);
        tests.put("+380(501)234567", true);
        tests.put("+3805(012)34567", true);
        tests.put("+38050(123)4567", true);
        tests.put("+380501(234)567", true);
        tests.put("+3805012(345)67", true);
        tests.put("+38050123(456)7", true);
        tests.put("0501234567", true);
        tests.put("(050)1234567", true);
        tests.put("0(501)234567", true);
        tests.put("05(012)34567", true);
        tests.put("050(123)4567", true);
        tests.put("0501(234)567", true);
        tests.put("05012(345)67", true);
        tests.put("050123(456)7", true);

        String pattern = "%-23s%-20s%-13sYour result: %-10bMust be: %b";
        List<String> failedTests = new ArrayList<>();

        System.out.println("\n========== ALL TESTS ==========\n");
        for (Map.Entry<String, Boolean> phoneNumber : tests.entrySet()) {
            String action = "Checking phone number:";
            if (phoneNumber.getKey() == null) action = "Checking \"null\":";
            else if (phoneNumber.getKey().equals("")) action = "Checking empty string:";
            boolean myResult = checkTelNumber(phoneNumber.getKey());
            boolean desiredResult = phoneNumber.getValue();
            String testResult = myResult == desiredResult ? "✓ passed" : "✗ failed";
            System.out.println(String.format(pattern, action, phoneNumber.getKey(), testResult, myResult, desiredResult));
            if (myResult != desiredResult)
                failedTests.add(String.format("%-20s Must be: %b", phoneNumber.getKey(), desiredResult));
        }

        System.out.println("\n========== FAILED TESTS ==========\n");
        for (String phoneNumber : failedTests) System.out.println(phoneNumber);



    }
}
