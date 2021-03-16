package chess.domain.piece;

public abstract class Piece {
    private final Position position;
    private final boolean isBlack;

    public Piece(boolean isBlack, char horizontal, char vertical) {
        this.position = new Position(horizontal, vertical);
        this.isBlack = isBlack;
    }

    public boolean isBlack() {
        return isBlack;
    }

    public Position getPosition() {
        return position;
    }

    abstract void move(char nextHorizontal, char nextVertical);

    abstract char getName();
}