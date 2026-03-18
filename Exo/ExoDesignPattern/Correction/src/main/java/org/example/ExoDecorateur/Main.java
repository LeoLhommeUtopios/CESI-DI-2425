package org.example.ExoDecorateur;

import org.example.ExoDecorateur.decorator.PrefixDecorator;
import org.example.ExoDecorateur.decorator.UpperCaseDecorator;

public class Main {
    public static void main(String[] args) {
        Text text = new PlainText();

        text = new PrefixDecorator(text,">> -");
        System.out.println(text.transform("hello world !!"));

        text = new UpperCaseDecorator(text);
        System.out.println(text.transform("HelloWorld 2 !!"));
    }
}
