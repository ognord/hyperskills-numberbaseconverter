package converter;

import java.math.BigInteger;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Main {
    public static String convertFromDecimalIntegerPart(BigInteger decimal, int targetBase) {
        if (BigInteger.ZERO.equals(decimal)) {
            return "0";
        }
        if (10 == targetBase) {
            return decimal.toString();
        }
        // write your code here
        BigInteger quotient;
        int remainder;
        String remainderStr = "";
        quotient = decimal;
        String result = "";

        while (!quotient.equals(BigInteger.ZERO)) {
            remainder = quotient.remainder(BigInteger.valueOf(targetBase)).intValue();
            quotient = quotient.divide(BigInteger.valueOf(targetBase));

            if (remainder > 9) {
                switch (remainder) {
                    case (10):
                        remainderStr = "a";
                        break;
                    case (11):
                        remainderStr = "b";
                        break;
                    case (12):
                        remainderStr = "c";
                        break;
                    case (13):
                        remainderStr = "d";
                        break;
                    case (14):
                        remainderStr = "e";
                        break;
                    case (15):
                        remainderStr = "f";
                        break;
                    case (16):
                        remainderStr = "g";
                        break;
                    case (17):
                        remainderStr = "h";
                        break;
                    case (18):
                        remainderStr = "i";
                        break;
                    case (19):
                        remainderStr = "j";
                        break;
                    case (20):
                        remainderStr = "k";
                        break;
                    case (21):
                        remainderStr = "l";
                        break;
                    case (22):
                        remainderStr = "m";
                        break;
                    case (23):
                        remainderStr = "n";
                        break;
                    case (24):
                        remainderStr = "o";
                        break;
                    case (25):
                        remainderStr = "p";
                        break;
                    case (26):
                        remainderStr = "q";
                        break;
                    case (27):
                        remainderStr = "r";
                        break;
                    case (28):
                        remainderStr = "s";
                        break;
                    case (29):
                        remainderStr = "t";
                        break;
                    case (30):
                        remainderStr = "u";
                        break;
                    case (31):
                        remainderStr = "v";
                        break;
                    case (32):
                        remainderStr = "w";
                        break;
                    case (33):
                        remainderStr = "x";
                        break;
                    case (34):
                        remainderStr = "y";
                        break;
                    case (35):
                        remainderStr = "z";
                        break;
                }
                result += remainderStr;
            } else {
                result += remainder;
            }
        }
        String res;
        res = new StringBuilder(result).reverse().toString();
        return res;
    }
    public static String convertFromDecimalFractionalPart(BigDecimal fractional, int targetBase) {
        if (BigDecimal.ZERO.equals(fractional)) {
            return BigDecimal.ZERO.toString();
        }
        if (10 == targetBase) {
            return fractional.toString();
        }
        String result = "";
        BigDecimal remainder;

        BigDecimal number = fractional;
        BigDecimal targetBaseBigDecimal = BigDecimal.valueOf(targetBase);

        int cycle = 0;
        String remainderStr = "";
        int remainderInt;

        while (!BigDecimal.ZERO.equals(number.remainder(BigDecimal.ONE)) && cycle < 5) {
            remainder = number.multiply(targetBaseBigDecimal);
            remainderInt = remainder.toBigInteger().intValue();
            if (remainderInt > 9) {
                switch (remainderInt) {
                    case (10):
                        remainderStr = "a";
                        break;
                    case (11):
                        remainderStr = "b";
                        break;
                    case (12):
                        remainderStr = "c";
                        break;
                    case (13):
                        remainderStr = "d";
                        break;
                    case (14):
                        remainderStr = "e";
                        break;
                    case (15):
                        remainderStr = "f";
                        break;
                    case (16):
                        remainderStr = "g";
                        break;
                    case (17):
                        remainderStr = "h";
                        break;
                    case (18):
                        remainderStr = "i";
                        break;
                    case (19):
                        remainderStr = "j";
                        break;
                    case (20):
                        remainderStr = "k";
                        break;
                    case (21):
                        remainderStr = "l";
                        break;
                    case (22):
                        remainderStr = "m";
                        break;
                    case (23):
                        remainderStr = "n";
                        break;
                    case (24):
                        remainderStr = "o";
                        break;
                    case (25):
                        remainderStr = "p";
                        break;
                    case (26):
                        remainderStr = "q";
                        break;
                    case (27):
                        remainderStr = "r";
                        break;
                    case (28):
                        remainderStr = "s";
                        break;
                    case (29):
                        remainderStr = "t";
                        break;
                    case (30):
                        remainderStr = "u";
                        break;
                    case (31):
                        remainderStr = "v";
                        break;
                    case (32):
                        remainderStr = "w";
                        break;
                    case (33):
                        remainderStr = "x";
                        break;
                    case (34):
                        remainderStr = "y";
                        break;
                    case (35):
                        remainderStr = "z";
                        break;
                }
                result += remainderStr;
            } else {
                result += remainderInt;
            }
            number = remainder.remainder(BigDecimal.ONE);
            cycle += 1;
        }
        return result;
    }

    public static BigInteger convertToDecimal(String sourceNumber, int sourceBase) {
        if ("0".equals(sourceNumber)) {
            return BigInteger.ZERO;
        }
        String reversedNumber;
        char[] charsReversedNumberFromString;
        BigInteger sum = BigInteger.valueOf(0);
        int intValue = 0;

        reversedNumber = new StringBuilder(sourceNumber).reverse().toString();
        //System.out.println("ReversedNumber: " + reversedNumber);
        charsReversedNumberFromString = reversedNumber.toCharArray();

        for (int i = 0; i < charsReversedNumberFromString.length; i++) {
            intValue = Character.getNumericValue(charsReversedNumberFromString[i]);
            sum = sum.add(BigDecimal.valueOf(Math.pow(sourceBase, i) * intValue).toBigInteger());
        }
        return sum;
    }
    public static BigDecimal convertToDecimalFractionalPart(String sourceNumber, int sourceBase) {
        if ("0".equals(sourceNumber)) {
            return BigDecimal.ZERO;
        }
        BigDecimal sum = BigDecimal.ZERO;
        int intValue;
        char[] charNumber = sourceNumber.toCharArray();
        for (int i = 0; i < charNumber.length; i++) {
            intValue = Character.getNumericValue(charNumber[i]);
            sum = sum.add(BigDecimal.valueOf(Math.pow(sourceBase, -(i+1)) * intValue));
        }
        return sum.setScale(5, RoundingMode.HALF_UP);
    }


    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        String input;
        int sourceBase;
        int targetBase;
        String sourceNumber;
        String[] parts;
        String numberIntegerPart;
        String numberFractionalPart;
        BigInteger decimalIntegerPart;
        BigDecimal decimalFractionalPart;
        String resultInteger;
        String resultFractional;
        boolean fractionalExist;

        while (true) {
            System.out.println("Enter two numbers in format: {source base} {target base} (To quit type /exit)");
            input = scanner.next();
            if (input.equals("/exit")) {
                break;
            } else {
                sourceBase = Integer.parseInt(input);
                targetBase = scanner.nextInt();
            }
            while (true) {
                System.out.println("Enter number in base " + sourceBase + " to convert to base "
                        + targetBase + " (To go back type /back)");
                sourceNumber = scanner.next();
                if (sourceNumber.equals("/back")) {
                    break;
                } else {
                    if (sourceNumber.contains(".")) { //there is a fractional part
                        fractionalExist = true;
                        parts = sourceNumber.split("\\.");  //split by escaped "." symbol
                        decimalIntegerPart  = convertToDecimal(parts[0], sourceBase);
                        decimalFractionalPart = convertToDecimalFractionalPart(parts[1], sourceBase);
                    } else { // no fractional part
                        fractionalExist = false;
                        decimalIntegerPart = convertToDecimal(sourceNumber, sourceBase);
                        decimalFractionalPart = BigDecimal.ZERO;
                    }
                    resultInteger = convertFromDecimalIntegerPart(decimalIntegerPart, targetBase);
                    resultFractional = convertFromDecimalFractionalPart(decimalFractionalPart, targetBase);
                }
                if (fractionalExist) {
                    System.out.println("Conversion result: " + resultInteger + "." + resultFractional);
                } else {
                    System.out.println("Conversion result: " + resultInteger);
                }
            }
        }
    }
}
