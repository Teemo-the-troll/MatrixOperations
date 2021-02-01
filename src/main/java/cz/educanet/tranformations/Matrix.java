package cz.educanet.tranformations;

import kotlin.NotImplementedError;

import java.util.Arrays;

public class Matrix implements IMatrix {

    private final double[][] rawArray;

    public Matrix(double[][] rawArray) {
        this.rawArray = rawArray;
    }

    @Override
    public int getRows() {
        return rawArray.length;
    }

    @Override
    public int getColumns() {
        if (getRows() > 0)
            return rawArray[0].length;
        return 0;
    }

    @Override
    public IMatrix times(IMatrix matrix) {
        if (!this.checkFormat(matrix))
            return null;
        IMatrix transposed = matrix.transpose();
        double[][] result = new double[this.getRows()][matrix.getColumns()];
        for (int i = 0; i < this.getRows(); i++){
            for (int j = 0; j < matrix.getColumns(); j++){
                int x = 0;
                for (int k = 0; k < matrix.getRows(); k++){
                    x += this.rawArray[i][k] * transposed.get(j,k);
                }
                result[i][j] = x;
            }
        }
        return MatrixFactory.create(result);
    }

    @Override
    public boolean checkFormat(IMatrix matrix){
        return matrix.getColumns() == this.getRows();
    }

    @Override
    public IMatrix times(Number scalar) {
        return null;
    }

    @Override
    public IMatrix add(IMatrix matrix) {
        if (!this.checkFormat(matrix))
            return null;
        double[][] result = new double [this.getRows()][this.getColumns()];
        for (int i = 0; i < this.getRows(); i++) {
            for (int j = 0; j < this.getColumns(); j++) {
                result[i][j] = this.get(i,j) + matrix.get(i,j);
            }
        }
        return MatrixFactory.create(result);
    }

    @Override
    public double get(int n, int m) {
        return this.rawArray[n][m];
    }

    //region Optional
    @Override
    public IMatrix transpose() {
        Matrix tempMatrix = new Matrix( new double[this.getColumns()][this.getRows()]);
        for (int i = 0; i < tempMatrix.getRows(); i++) {
            for (int j = 0; j < tempMatrix.getColumns(); j++) {
                tempMatrix.rawArray[i][j] = this.rawArray[j][i];
            }
        }
        return tempMatrix;
    }

    @Override
    public double determinant() {
        return 0;
    }
    //endregion
    //region Generated
    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix matrix = (Matrix) o;

        for (int i = 0; i < rawArray.length; i++) {
            if (!Arrays.equals(rawArray[i], matrix.rawArray[i]))
                return false;
        }
        return true;

    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(rawArray);
    }
    //endregion
}
