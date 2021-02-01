import cz.educanet.tranformations.IMatrix;
import cz.educanet.tranformations.MatrixFactory;

public class Playground {
    public static void main(String[] args) {


        double[][] rawE = {
                {1 , 2},
                {3 , 4},
                {5 , 6},
        };

        double[][] rawF = {
                {1 , 2},
                {3 , 4},
                {5 , 6},
        };


        IMatrix matrix = MatrixFactory.create(rawE);
        IMatrix matrix2 = MatrixFactory.create(rawF);
        System.out.println(matrix.equals(matrix2));
    }
}
