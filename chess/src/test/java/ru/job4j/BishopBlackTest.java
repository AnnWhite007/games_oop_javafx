package ru.job4j;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

public class BishopBlackTest {
    @Test
    public void whatPosition() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A2);
        Cell a = bishopBlack.position();
        assertThat(a, is(Cell.A2));
    }

    @Test
    public void whatCopyPosition() {
        BishopBlack bishopBlack = new BishopBlack(Cell.A2);
        Figure x = bishopBlack.copy(Cell.A8);
        assertThat(x.position(), is(Cell.A8));
    }

    @Test
    public void whatWay() {
        BishopBlack bishopBlack = new BishopBlack(Cell.C1);
        Cell [] array = bishopBlack.way(Cell.G5);
        assertThat(array, is(new Object[] {Cell.D2, Cell.E3, Cell.F4, Cell.G5}));
    }

    @Test(expected = ImpossibleMoveException.class)
    public void whenNotDiagonal() {
        BishopBlack bishopBlack = new BishopBlack(Cell.B1);
        bishopBlack.way(Cell.B3);
    }
}
