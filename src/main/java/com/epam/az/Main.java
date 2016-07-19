package com.epam.az;


import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        /*FileReader fileReader = new FileReader();
        Parser parser = new Parser();
        Paragraph paragraph = parser.parse(fileReader.read());
*/
        Pattern pattern = Pattern.compile("//S //s ");
        String[] strings = pattern.split("aaaaa  aaa  aas  s  ss  vvv  ffb  bb   ss   aa");
        for (String string : strings) {
            System.out.println(string);
        }

    }
}
