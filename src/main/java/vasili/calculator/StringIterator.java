package vasili.calculator;

import static java.lang.Character.isDigit;

public class StringIterator {
    private final String string;
    private int currentIndex;

    public StringIterator(String string) {
        this.string = string.replace(" ", "");
        currentIndex = 0;
    }

    public boolean hasNext() {
        return string != null &&
                !string.isEmpty() &&
                currentIndex < string.length();
    }

    public String next() {
        var builder = new StringBuilder();
        char element = string.charAt(currentIndex);
        while (checkElement(element)) {
            builder.append(element);
            currentIndex++;
            if (currentIndex == string.length())
                return builder.toString();
            element = string.charAt(currentIndex);
        }
        if (builder.length() != 0)
            return builder.toString();
        currentIndex++;
        return Character.toString(element);
    }

    private boolean checkElement(char element) {
        return isDigit(element)
                || element == '.'
                || (currentIndex == 0 && element == '-')
                || (currentIndex > 0 && string.charAt(currentIndex - 1) == '(' && element == '-')
                || (string.charAt(currentIndex - 1) == '*' && element == '-')
                || (string.charAt(currentIndex - 1) == '/' && element == '-');
    }
}
