import java.util.*;

public class Board {
    private List<Token> tokens;

    public Board() {
        tokens = new ArrayList<>();
    }

    public void addToken(Token token) {
        tokens.add(token);
    }

    public void removeToken(Token token) {
        tokens.remove(token);
    }
    public Token getToken(int index) {
        return tokens.get(index);
    }
}
