import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import static java.lang.Math.abs;


public class Player implements Runnable {
    private String name;
    private List<Token> tokens;
    private static Board board;
    private static Game game;
    private Player opponent;
    private boolean available;

    public Player(String name, Board board, Game game, boolean available) {
        this.name = name;
        Player.board = board;
        Player.game = game;
        this.available = available;
        tokens = new ArrayList<>();
    }

    public void setPlayer(Player player) {
        this.opponent = player;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addToken(Token token) {
        tokens.add(token);
    }

    public void setBoard(Board board) {
        Player.board = board;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void addRandom() {
        int index;
        Token token;
        Random rand = new Random();
        index = rand.nextInt(game.getTokensNumber());
        token = board.getToken(index);
        while (token == null) {
            index = rand.nextInt(game.getTokensNumber());
            token = board.getToken(index);
        }
        tokens.add(token);
        board.removeToken(token);
        game.setTokensNumber(game.getTokensNumber() - 1);
    }

    public synchronized void chooseToken() throws InterruptedException {
        /*while (!available) {
            wait();
        }
        while(available) {*/

        if (tokens.size() <= 1) {
            addRandom();
        } else {
            boolean added = false;
            int ration = abs(tokens.get(0).getNumber() - tokens.get(1).getNumber());
            for (int index = 0; index < game.getTokensNumber(); index++) {
                if (board.getToken(index) != null) {
                    for (Token token : tokens) {
                        if (abs(board.getToken(index).getNumber() - token.getNumber()) == ration) {
                            added = true;
                            tokens.add(board.getToken(index));
                            board.removeToken(board.getToken(index));
                            game.setTokensNumber(game.getTokensNumber() - 1);
                            break;
                        }
                    }
                }
            }
            if (!added) {
                addRandom();
            }
        }
        /*
        opponent.setAvailable(true);
        available = false;
        notify();

         */
    }


    public void sortTokens() {
        tokens.sort(Comparator.comparing(Token::getNumber));
    }

    @Override
    public void run() {
        for (int i = 0; i < game.getLength(); i++) {
            try {
                chooseToken();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void showTokens() {
        System.out.println(this.getName() + ": ");
        for (Token token : tokens) {
            System.out.println(token.getNumber());
        }
    }

    public Player getOpponent() {
        return opponent;
    }

    public void setOpponent(Player opponent) {
        this.opponent = opponent;
    }

    public static void main(String[] args) throws InterruptedException {
        Game game = new Game(20, 7);
        List<Token> tokens = new ArrayList<>();
        Board board = new Board();

        for (int i = 0; i <= game.getTokensNumber(); i++) {
            tokens.add(new Token(i));
        }
        for (Token token : tokens) {
            board.addToken(token);
        }
        Player p1 = new Player("Andrei", board, game, true);
        Player p2 = new Player("Ioan", board, game, false);
        p1.setOpponent(p2);
        p2.setOpponent(p1);
        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(p2);
        t1.start();
        t1.join();
        t2.start();
        t2.join();

        p1.sortTokens();
        p2.sortTokens();

        p1.showTokens();
        p2.showTokens();
    }
}
