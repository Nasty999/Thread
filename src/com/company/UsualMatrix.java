package com.company;

public class UsualMatrix {
    protected int row;
    protected int column;
    protected int[][] matrix;

    public UsualMatrix(int n, int m) {
        this.row = n;
        this.column = m;
        this.matrix = new int[row][column];
    }

    public UsualMatrix(int[][] m) {
        this.matrix = new int[m.length][m[0].length];
        this.row = m.length;
        this.column = m[0].length;
        for(int i = 0; i < row; i++) {
            for(int j = 0; j < column; j++) {
                matrix[i][j] = m[i][j];
            }

        }
    }

    public void setElement(int row, int column, int value) {
        this.matrix[row][column] = value;
    }

    public int getElement(int row, int column) {
        return this.matrix[row][column];
    }

    public UsualMatrix sum(UsualMatrix mtr) {
        UsualMatrix  result = new UsualMatrix (mtr.Row(), mtr.Column());
        for(int i = 0; i < this.Row(); i++) {
            for(int j = 0; j < this.Column(); j++) {
                int matr = this.getElement(i, j) + mtr.getElement(i, j);
                result.setElement(i, j, matr);
            }
        }
        return result;

    }

    public UsualMatrix product(UsualMatrix mtr) {
        UsualMatrix result = new UsualMatrix(mtr.Row(), mtr.Column());
        for(int i = 0; i < this.Row(); i++) {
            for(int j = 0; j < this.Column(); j++) {
                int matr = 0;
                for(int k = 0; k < Column(); k++) {
                    matr += this.getElement(i, k) * mtr.getElement(k, j);
                    result.setElement(i, j, matr);
                }
            }

        }
        return result;

    }

    @Override
    public String toString(){
        StringBuilder out = new StringBuilder();
        for(int i = 0; i < this.row; i++) {
            for(int j = 0; j < this.column; j++) {
                out.append(this.matrix[i][j]).append(" ");
            }
            out.append("\n");
        }
        return out.toString();
    }


    public final boolean equals(Object m) {
        if(this.getClass() != m.getClass())
            return false;
        UsualMatrix matr = (UsualMatrix) m;
        if((row != matr.row) || (column != matr.column))
            return false;
        for(int i = 0; i < this.row; i++) {
            for(int j = 0; j < this.column; j++) {
                if(matrix[i][j] != matr.matrix[i][j])
                    return false;
            }
        }
        return true;
    }



    public int Row() {
        return row;
    }

    public int Column() {
        return column;
    }

}

