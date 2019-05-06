package com.epam.javacore2019.steve2.dbservice.misc;

import com.epam.javacore2019.steve2.dbservice.server_old.DBApplication;

public class MainDataEncryptor implements DataEncryptor {

    private static final int KEY_FOR_CAESAR = 7;

    @Override
    public String encrypt(String text) {
        switch (DBApplication.DATA_ENCRYPTION_LEVEL) {
            case LOW:
                return encryptLOW(text);
            case MED:
                return encryptMED(text);
            case HIGH:
                return encryptHIGH(text);
                default:
                    return null;
        }
    }

    @Override
    public String decrypt(String text) {
        switch (DBApplication.DATA_ENCRYPTION_LEVEL) {
            case LOW:
                return decryptLOW(text);
            case MED:
                return decryptMED(text);
            case HIGH:
                return decryptHIGH(text);
            default:
                return null;
        }
    }

    private String encryptLOW(String text) {
        //to hex
        StringBuilder stringBuilder = new StringBuilder();
        byte[] stringInBytes = text.getBytes();
        for (byte b : stringInBytes) {
            stringBuilder.append(String.format("%02x", b));
        }

        return stringBuilder.toString();
    }

    private String decryptLOW(String text) {
        StringBuilder stringBuilder = new StringBuilder();
        String tempSubstring;
        for (int i = 0, len = text.length() - 1; i < len; i+=2) {
            tempSubstring = text.substring(i, i + 2);
            stringBuilder.append((char)Integer.parseInt(tempSubstring, 16));
        }
        return stringBuilder.toString();
    }

    private String encryptMED(String text) {
        //to caesar
        int tempCharInInt;
        char[] encryptedTextInChars = text.toCharArray();
        char tempChar;

        for (int i = 0, len = encryptedTextInChars.length; i < len; i++) {
            tempChar = encryptedTextInChars[i];
            tempCharInInt = (int)tempChar;

            if (Character.isDigit(tempChar)) {
                int digit = Character.digit(tempChar, 10) + KEY_FOR_CAESAR;
                if (digit > 9) {
                    digit -= 10;
                }
                encryptedTextInChars[i] = Character.forDigit(digit, 10);
            }

            else if ((int)tempChar >= 65 && (int)tempChar <= 90) {
                tempCharInInt += KEY_FOR_CAESAR;
                if (tempCharInInt > 90) {
                    tempCharInInt = 64 + tempCharInInt - 90;
                }
                encryptedTextInChars[i] = (char)tempCharInInt;
            }

            else if ((int)tempChar >= 97 && (int)tempChar <= 122) {
                tempCharInInt += KEY_FOR_CAESAR;
                if (tempCharInInt > 122) {
                    tempCharInInt = 96 + tempCharInInt - 122;
                }
                encryptedTextInChars[i] = (char)tempCharInInt;
            }
        }

        return new String(encryptedTextInChars);
    }

    private String decryptMED(String text) {
        int tempCharInInt;
        char[] encryptedTextInChars = text.toCharArray();
        char tempChar;

        for (int i = 0, len = encryptedTextInChars.length; i < len; i++) {
            tempChar = encryptedTextInChars[i];
            tempCharInInt = (int)tempChar;

            if (Character.isDigit(tempChar)) {
                int digit = Character.digit(tempChar, 10) - KEY_FOR_CAESAR;
                if (digit < 0) {
                    digit += 10;
                }
                encryptedTextInChars[i] = Character.forDigit(digit, 10);
            }

            else if ((int)tempChar >= 65 && (int)tempChar <= 90) {
                tempCharInInt -= KEY_FOR_CAESAR;
                if (tempCharInInt < 65) {
                    tempCharInInt = tempCharInInt + 90 - 64;
                }
                encryptedTextInChars[i] = (char)tempCharInInt;
            }

            else if ((int)tempChar >= 97 && (int)tempChar <= 122) {
                tempCharInInt -= KEY_FOR_CAESAR;
                if (tempCharInInt < 97) {
                    tempCharInInt = tempCharInInt + 122 - 96;
                }
                encryptedTextInChars[i] = (char)tempCharInInt;
            }
        }

        return new String(encryptedTextInChars);
    }

    private String encryptHIGH(String text) {
        return null;
    }

    private String decryptHIGH(String text) {
        return null;
    }

}
