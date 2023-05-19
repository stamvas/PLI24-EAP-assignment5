public class SmallParser {

    private char token;
    Lex lex;

    static private void error(String s)
    {
        System.out.println(s);
        System.exit(0);
    }

    SmallParser(String s) {

        lex = new Lex(s);
        token = lex.nextToken();
        S();
        if (token == '\0') {
            System.out.println("Input " + s + " accepted!");
        } else {
            System.out.println("Input " + s + " not accepted!");
        }
    }

    private void S(){
        X(); // εκτελεί τον κανόνα Χ
        A(); // εκτελεί τον κανόνα Α
    }

    // μέθοδος Α
    private void A() {
        if (token == '\0'){
            System.out.println("A-->ε   "+token);
        }
        else {
            System.out.println("A-->XA  "+token);
            X(); // εκτελεί τον κανόνα Χ
            A(); // εκτελεί τον κανόνα A
            token = lex.nextToken();
        }
    }

    // μέθοδος Χ
    private void X() {
        if (token == '0') { //ελέγχει αν βρει 0
            System.out.println("X-->0B  "+token);
            token = lex.nextToken(); // επόμενη θέση και εκτελεί τον κανόνα Β
            B();
        }
        else if (token == '1'){ //ελέγχει αν βρει 1
            System.out.println("X-->1B  "+token);
            token = lex.nextToken(); // επόμενη θέση και εκτελεί τον κανόνα Β
            B();
        }
        else C(); // αλλιώς εκτελεί τον κανόνα C

    }

    // μέθοδος C
    private void C() {
        if (token == '*'){ //ελέγχει αν βρει *
            System.out.println("C-->  "+token);
            token = lex.nextToken(); // επόμενη θέση και εκτελεί τον κανόνα C
            C();
        }
        else token = lex.nextToken();
    }

    // μέθοδος B
    private void B() {
        if (token == '$'){ //ελέγχει αν βρει $
            System.out.println("C-->$X  "+token);
            token = lex.nextToken(); // επόμενη θέση και εκτελεί τον κανόνα X
            X();
        } else if (token == '@') { //ελέγχει αν βρει @
            System.out.println("B-->@X  "+token);
            token = lex.nextToken(); // επόμενη θέση και εκτελεί τον κανόνα X
            X();
        }
        else token = '\0';

    }

}
