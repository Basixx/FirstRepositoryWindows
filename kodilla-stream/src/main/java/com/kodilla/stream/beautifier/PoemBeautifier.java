package com.kodilla.stream.beautifier;

public class PoemBeautifier {
    public void beautify(String poem, PoemDecorator poemDecorator) {
        String beautifiedPoem = poemDecorator.decorate(poem);
        System.out.println(beautifiedPoem);
    }
}
