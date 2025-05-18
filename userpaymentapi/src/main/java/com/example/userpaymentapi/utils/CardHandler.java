package com.example.userpaymentapi.utils;

public class CardHandler {

    public static boolean isValidCardNumber(String cardNumber) {
        int sum = 0;
        boolean alternate = false;

        for (int i = cardNumber.length() - 1; i >= 0; i--) {
            int n = Integer.parseInt(cardNumber.substring(i, i + 1));

            if (alternate) {
                n *= 2;
                if (n > 9) {
                    n -= 9;
                }
            }

            sum += n;
            alternate = !alternate;
        }

        return (sum % 10 == 0);
    }

    public static String maskCardNumber(String cardNumber) {
        int length = cardNumber.length();
        return "*".repeat(length - 4) + cardNumber.substring(length - 4);
    }

}
