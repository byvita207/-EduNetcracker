package ru.matrix;

public class IMatrixWorkerImpl implements IMatrixWorker {
    //public double[][] matrix;

    public void print(double[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.print("\n");
        }
    }

    @Override
    public boolean haveSameDimension(double[][] m1, double[][] m2) {
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[0].length; j++) {
                if (m1[i][j] != m2[i][j]) return false;
            }
        }
        return true;
    }

    @Override
    public double[][] add(double[][] m1, double[][] m2) throws IllegalArgumentException {
        if (m1.length == m2.length && m1[0].length == m2[0].length){
            double[][] res = new double[m1.length][m1[0].length];
            for (int i = 0; i < m1.length; i++){
                for (int j = 0; j < m1[0].length; j++){
                    res[i][j] = m1[i][j] + m2[i][j];
                }
            }
            return res;
        }
        else throw new IllegalArgumentException ("Only matrices of the same size can be added. ");
    }

    @Override
    public double[][] subtract(double[][] m1, double[][] m2) throws IllegalArgumentException{
        if (m1.length == m2.length && m1[0].length == m2[0].length){
            double[][] res = new double[m1.length][m1[0].length];
            for (int i = 0; i < m1.length; i++){
                for (int j = 0; j < m1[0].length; j++){
                    res[i][j] = m1[i][j] - m2[i][j];
                }
            }
            return res;
        }
        else throw new IllegalArgumentException ("Only matrices of the same size can be subtracted. ");
    }

    @Override
    public double[][] multiply(double[][] m1, double[][] m2) throws IllegalArgumentException{
        if (m1.length == m2[0].length){
            double[][] m3= new double[m1[0].length][m2.length];
            for (int i = 0; i < m1[0].length; i++){
                for (int j = 0; j <m2.length; j++){
                    double t = 0;
                    for (int k = 0; k < m1.length; k++){
                        t += m1[k][i] * m2[j][k];
                    }
                    m3[i][j] = t;
                }
            }
            return m3;
        }
        else throw new IllegalArgumentException ("the number of columns in matrix m1 must match the number of rows in matrix2.");
    }
    public double det(double[][] mat) {
        if (mat.length == 1)
            return mat[0][0];
        if (mat.length == 2)
            return mat[0][0] * mat[1][1] - mat[1][0] * mat[0][1];
        double sum = 0, sign = 1;
        int newN = mat.length - 1;
        double[][] temp = new double[newN][newN];
        for (int t = 0; t < newN; t++) {
            int q = 0;
            for (int i = 0; i < newN; i++) {
                for (int j = 0; j < newN; j++) {
                    temp[i][j] = mat[1 + i][q + j];
                }
                if (q == i)
                    q = 1;
            }
            sum += sign * mat[0][t] * det(temp);
            sign *= -1;
        }
        return sum;
    }
    public static void main(String[] args) {
        IMatrixWorkerImpl mat = new IMatrixWorkerImpl();
        double[][] matrix = new double[][]{{1, 2,6}, {1, 5,9},{5,5,5}};
        mat.print(matrix);
        IMatrixWorkerImpl mat2 = new IMatrixWorkerImpl();
        double[][] matrix2 = new double[][]{{1, 2}, {1, 4}};   
    }
}
