package assingment_1;

public class Player {
    private String name;
    private int position;
    private boolean turn;
    private int diceValue;
    private boolean knockedOut;

    public Player(String name){
        this.name = name;
        this.position = 0;
        this.turn = false;
        this.diceValue = 0;
        this.knockedOut = false;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    public boolean getTurn(){
        return turn;
    }

    public int getDiceValue() {
        return diceValue;
    }

    public void setDiceValue(int diceValue) {
        this.diceValue = diceValue;
    }

    public boolean isKnockedOut() {
        return knockedOut;
    }

    public void setKnockedOut(boolean knockedOut) {
        this.knockedOut = knockedOut;
    }
}
