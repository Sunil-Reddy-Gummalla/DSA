package Strings;

import java.util.Arrays;

// Problem from IBM
// When model is Given in Certain Patterns We need to Divide Them into Type 1 and Type 2 and Core

public class ClassifySwitch {

    public static void main(String[] args) {
        String s = "WS-C3850-24P-X";
        classifySwitch(s);
    }

    private static void classifySwitch(String s) {
        String modelCode;
        String port_count;
        String[] arr = s.split("-");
        if (arr.length == 4 && arr[0].length() == 2 && arr[1].length() == 5) {
            modelCode = arr[1].replaceAll("[^0-9]", "");
            port_count = arr[2].replaceAll("[^0-9]", "");
        } else if (arr.length == 3 && arr[0].length() == 6 && arr[1].length() == 3) {
            modelCode = arr[0].replaceAll("[^0-9]", "");
            port_count = arr[1].replaceAll("[^0-9]", "");

        } else if (arr.length == 2 && arr[0].length() == 5 && arr[1].length() == 3) {
            modelCode = arr[0].replaceAll("[^0-9]", "");
            port_count = arr[1].replaceAll("[^0-9]", "");

        } else {
            System.out.println("Invalid Model Number");
            return;
        }

        if (s.endsWith("-S") || s.endsWith("-NX")) {
            System.out.println(port_count);
            System.out.println("Core");
            return;
        }
        if (Arrays.asList("5200", "5250", "5270").contains(modelCode) && Integer.parseInt(port_count) <= 24) {
            System.out.println(port_count);
            System.out.println("Type 1");
            return;
        }

        if (Arrays.asList("5200", "5250", "5270", "5300", "5350", "5370", "5400").contains(modelCode)) {
            System.out.println(port_count);
            System.out.println("Type 2");
            return;
        }

    }

}