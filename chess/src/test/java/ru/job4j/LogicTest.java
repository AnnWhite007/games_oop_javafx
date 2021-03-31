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
    @Test
    public void trueMove() throws FigureNotFoundException, OccupiedCellException {
        Logic logic = new Logic();
        BishopBlack bishopBlack1 = new BishopBlack(Cell.C2);
        logic.move(bishopBlack1.position(), Cell.D3);
        assertThat(bishopBlack1.position(), is(Cell.D3));
    }

    @Test
    public void whenOccupied() throws FigureNotFoundException, OccupiedCellException {
        Logic logic = new Logic();
        BishopBlack bishopBlack1 = new BishopBlack(Cell.A1);
        BishopBlack bishopBlack2 = new BishopBlack(Cell.D3);
        logic.move(bishopBlack1.position(), Cell.B2);
        assertThat(bishopBlack1.position(), is(Cell.B2));
    }

    @Test (expected = ImpossibleMoveException.class)
    public void whenImposibleMove() {
        Logic logic = new Logic();
        BishopBlack bishopBlack1 = new BishopBlack(Cell.A1);
        logic.move(bishopBlack1.position(), Cell.A2);
    }
}