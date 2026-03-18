package org.example.ExoDecorateur.decorator;

import org.example.ExoDecorateur.Text;

import java.awt.*;

public class PrefixDecorator extends TextDecorator{
    private String prefix;

    public PrefixDecorator(Text text,String prefix) {
        super(text);
        this.prefix = prefix;
    }

    @Override
    public String transform(String input) {
        return prefix+' '+ super.transform(input);
    }
}