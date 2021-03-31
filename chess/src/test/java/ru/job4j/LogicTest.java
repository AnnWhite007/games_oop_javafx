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
        assertThat(bishopBlack1.position(), is(Cell.B3));
    }
}