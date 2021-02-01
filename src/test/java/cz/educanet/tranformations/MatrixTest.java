package cz.educanet.tranformations;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class MatrixTest {

    private IMatrix a;
    private IMatrix b;
    private IMatrix c;
    private IMatrix d;
    private IMatrix e;
    private IMatrix empty;

    @Before
    public void setUp() throws Exception {
        double[][] rawA = {
                {1, 1, 1},
                {1, 1, 1},
        };
        a = MatrixFactory.create(rawA);

        double[][] rawB = {
                {1, 1, 1},
                {1, 1, 1},
                {0, 0, 0},
        };
        b = MatrixFactory.create(rawB);
        double[][] rawC = {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1},
        };
        c = MatrixFactory.create(rawC);

        double[][] rawEmpty = {};
        empty = MatrixFactory.create(rawEmpty);

        double[][] rawD = {
                {1, 1}
        };
        d = MatrixFactory.create(rawD);

        double[][] rawE = {
                {1, 2},
                {3, 4},
                {5, 6},
        };
        e = MatrixFactory.create(rawE);

    }

    @Test
    public void getRows() {
        assertEquals(2, a.getRows());
        assertEquals(3, b.getRows());
        assertEquals(3, c.getRows());
        assertEquals(0, empty.getRows());
    }

    @Test
    public void getColumns() {
        assertEquals(3, a.getColumns());
        assertEquals(3, b.getColumns());
        assertEquals(3, c.getColumns());
        assertEquals(0, empty.getColumns());
        assertEquals(2, d.getColumns());
    }

    @Test
    public void times() {


        double[][] expectedAtimesE = {
                {9, 12},
                {9, 12}
        };

        double[][] expectedEtimesA = {
                {3, 3, 3},
                {7, 7, 7},
                {11, 11, 11}
        };

        assert (MatrixFactory.create(expectedAtimesE).equals(a.times(e)));
        assert (MatrixFactory.create(expectedEtimesA).equals(e.times(a)));
    }

    @Test
    public void timesScalar() {
    }

    @Test
    public void add() {
        double[][] expectedAplusB = null;
        double[][] expectedBplusC = {
                {2, 1, 1},
                {1, 2, 1},
                {0, 0, 1}
        };
        assertNull(a.add(b));
        assert(b.add(c).equals(MatrixFactory.create(expectedBplusC)));
    }

    @Test
    public void get() {
        assertEquals(4, e.get(1,1), 0);
    }

    @Test
    public void transpose() {
        double[][] expected = {
                {1, 3, 5},
                {2, 4, 6}
        };
        assert (e.transpose().equals(MatrixFactory.create(expected)));
    }

    @Test
    public void determinant() {
    }
}
