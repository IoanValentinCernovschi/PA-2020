public class Game {
    private int tokensNumber;
    private int length;

    public Game(int tokensNumber, int length) {
        this.tokensNumber = tokensNumber;
        this.length = length;
    }


    public int getTokensNumber() {
        return tokensNumber;
    }

    public void setTokensNumber(int tokensNumber) {
        this.tokensNumber = tokensNumber;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
