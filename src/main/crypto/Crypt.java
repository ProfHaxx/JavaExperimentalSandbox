package main.crypto;

import java.math.BigInteger;
import java.util.Arrays;

public class Crypt {

    private static String message = "Passix";

    public static void main(String[] args) {
        System.out.println("Works: " + Arrays.toString(toHex(message)));
        System.out.println("Works: " + Arrays.toString(new KeyFactory().getKey()));
        System.out.println("Works " + Bitwise.XOR("66", "fa"));
        Word sample = new Word(new String[]{"aa", "bb", "cc", "dd"});
        System.out.println(sample.toString());
        Bitwise.rotateRight(sample, 2);
        System.out.println(sample.toString());

    }

    private static String[] toHex(String message) {
        String[] result = new String[message.length()];
        for(int i = 0; i < message.length(); i++) {
            result[i] = String.format("%04x", (int) message.toCharArray()[i]).substring(2);
        }
        return result;
    }
}

class KeyFactory {
    String[] key;

    public KeyFactory() {
        this.key = generateKey();
    }

    public KeyFactory(String[] key) {
        if(key.length == 8) {
            this.key = key;
        } else {
            throw new KeyLimitException("Key cannot exceed 128 bits!");
        }
    }

    public String[] generateKey() {
        String[] result = new String[8];
        for(int i = 0; i < 8; i++) {
            String RandomHex = Integer.toHexString((int) (Math.random()*255));
            result[i] = "00".substring(RandomHex.length()) + RandomHex;
        }
        return result;
    }

    public String[] getKey() {
        return key;
    }
}

class KeyLimitException extends RuntimeException {
    public KeyLimitException(String message) {
        super(message);
    }
}

class Bitwise {
    public static String XOR(String hex1, String hex2) {
        //TODO: Try not to use BigInteger!
        String bin1 = String.format("%8s", new BigInteger(hex1, 16).toString(2)).replace(' ', '0');
        String bin2 = String.format("%8s", new BigInteger(hex2, 16).toString(2)).replace(' ', '0');
        String result = "";
        for(int i = 0; i < 8; i++) {
            if(bin1.toCharArray()[i] != bin2.toCharArray()[i]) {
                result += "1";
            } else {
                result += "0";
            }
        }
        return String.format("%2s", new BigInteger(result, 2).toString(16)).replace(' ', '0');
    }

    public static Word rotateRight(Word word, int n) {
        return (n > 0) ? rotateRight(word.rotateRight(), n - 1) : word;
    }
}

class Block {
    Word[] words;
}

class Word {
    String[] bytes;

    public Word() {

    }

    public Word(String[] bytes) {
        this.bytes = bytes;
    }

    Word rotateRight() {
        this.bytes = new String[] {bytes[3], bytes[0], bytes[1], bytes[2]};
        return this;
    }

    @Override
    public String toString() {
        return "[" + bytes[0] + ", " + bytes[1] + ", " + bytes[2] + ", " + bytes[3] + "]";
    }
}