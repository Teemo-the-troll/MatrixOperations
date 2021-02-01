package cz.educanet.tranformations;

public interface IMatrix {

    /**
     * Multiplies the two matrices together and returns the resulting matrix.
     *
     * @param matrix
     * @return Multiplied matrix
     */
    IMatrix times(IMatrix matrix) throws IllegalArgumentException;

    /**
     * Multiplies the matrix with a number.
     *
     * @param scalar
     * @return Scalar times "larger" matrix
     */
    IMatrix times(Number scalar);

    /**
     * Adds two matrices
     *
     * @param matrix-IMatrix
     * @return sum of the two matrices
     */
    IMatrix add(IMatrix matrix);

    /**
     * Transposes the matrix (flips rows and columns)
     *
     * @return flipped matrix
     */
    IMatrix transpose();


    /**
     * Checks if the format of the matrix is plausible to multiply it
     *
     * @return boolean
     */
    boolean checkFormat(IMatrix matrix);

    /**
     * Calculates the determinant, https://en.wikipedia.org/wiki/Determinant
     * https://matematika.cz/determinanty
     *
     * @return
     */
    double determinant();

    /**
     * returns the amount of rows in Matrix
     *
     * @return rows
     */
    int getRows();

    /**
     * @return columns
     */
    int getColumns();


    /**
     * @param n
     * @param m
     * @return the value of the "cell"
     */
    double get(int n, int m);

}
