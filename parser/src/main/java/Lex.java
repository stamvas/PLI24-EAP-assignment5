public class Lex {

    private String input_string;
    private int pointer = 0;

    Lex(String s)
    {
        this.input_string = s;
    }


    public char nextToken()
    {
        try
        {
            char c = input_string.charAt(pointer);
            pointer++;
            return c;

        }
        catch(StringIndexOutOfBoundsException e)
        {
            return '\0';
        }
    }

}
