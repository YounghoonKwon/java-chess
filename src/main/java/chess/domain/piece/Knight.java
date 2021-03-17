package chess.domain.piece;

import chess.domain.grid.Grid;
import chess.domain.position.Direction;
import chess.domain.position.Position;

import java.util.List;
import java.util.stream.Collectors;

public class Knight extends Piece {
    private static final char NAME_WHEN_BLACK = 'N';
    private static final char NAME_WHEN_WHITE = 'n';

    public Knight(final Boolean isBlack, final char x, final char y) {
        super(isBlack, x, y);
    }

    @Override
    List<Position> extractMovablePositions() {
        List<Position> collect = Direction.knightDirection()
                .stream()
                .map(direction -> getPosition().moved(direction.getXDegree(), direction.getYDegree()))
                .filter(position -> !isOutOfRange(position) && Grid.isOccupied(position))
                .collect(Collectors.toList());
        return collect;
    }

    @Override
    char getName() {
        if (isBlack()) {
            return NAME_WHEN_BLACK;
        }
        return NAME_WHEN_WHITE;
    }
}

