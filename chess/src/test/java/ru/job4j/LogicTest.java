package ru.job4j;

import org.junit.Test;
import ru.job4j.chess.FigureNotFoundException;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.Logic;
import ru.job4j.chess.OccupiedCellException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class LogicTest {
    @Test(expected = ImpossibleMoveException.class)
    public void whenImposibleMove() throws FigureNotFoundException, OccupiedCellException {
        Logic logic = new Logic();
        BishopBlack bishopBlack = new BishopBlack(Cell.C2);
        logic.add(bishopBlack);
        logic.move(bishopBlack.position(), Cell.C3);
    }

    @Test(expected = OccupiedCellException.class)
    public void whenOccupied() throws FigureNotFoundException, ImpossibleMoveException, OccupiedCellException {
        Logic logic = new Logic();
        BishopBlack bishopBlack1 = new BishopBlack(Cell.A1);
        BishopBlack bishopBlack2 = new BishopBlack(Cell.B2);
        logic.add(bishopBlack1);
        logic.add(bishopBlack2);
        logic.move(bishopBlack1.position(), Cell.C3);
    }

    @Test(expected = FigureNotFoundException.class)
    public void whenNotFound() throws ImpossibleMoveException, OccupiedCellException, FigureNotFoundException {
        Logic logic = new Logic();
        BishopBlack bishopBlack = new BishopBlack(Cell.B3);
        logic.add(bishopBlack);
        logic.move(Cell.B1, Cell.D3);
    }
}