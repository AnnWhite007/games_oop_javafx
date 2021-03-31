package ru.job4j.chess.firuges.black;

import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell dest) { if (!isDiagonal(position, dest)) {
        throw new ImpossibleMoveException(
                String.format("Could not way by diagonal from %s to %s", position, dest)
        );
    }
        int size = Math.abs(dest.x - position.x);
        Cell[] steps = new Cell[size];
        int deltaX;
        int deltaY;
        if (dest.x < position.x) {
            deltaX = (position.x - 1) * (-1);
        } else {
            deltaX = position.x + 1;
        }
        if (dest.y < position.y) {
            deltaY = (position.y - 1) * (-1);
        } else {
            deltaY = position.y + 1;
        }
        for (int index = 0; index < size; index++) {
            int x = Math.abs(deltaX + index);
            int y = Math.abs(deltaY + index);
            steps[index] = Cell.findBy(x, y);
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) throws ImpossibleMoveException {
        if (Math.abs(source.x - dest.x) == Math.abs(source.y - dest.y)) {
            return true;
        }
        throw new ImpossibleMoveException("Could not move by diagonal from %s to %s\", source, dest");
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
