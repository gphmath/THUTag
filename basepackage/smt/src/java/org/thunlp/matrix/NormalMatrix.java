package org.thunlp.matrix;

public class NormalMatrix implements MatrixInterface {
	private double[][] matrix;
	int rows, cols;

	public NormalMatrix(int rows, int cols) {
		matrix = new double[rows][];
		for (int i = 0; i != rows; i++)
			matrix[i] = new double[cols];
		this.rows = rows;
		this.cols = cols;
	}

	public double get(int row, int col) {
		return matrix[row][col];
	}

	public void set(int row, int col, double value) {
		matrix[row][col] = value;
	}

	public void add(int row, int col, double value) {
		matrix[row][col] += value;
	}

	public int getRowsCount() {
		return rows;
	}

	public int getColsCount() {
		return cols;
	}

	// 转置
	public void inv() {
		if (rows == cols) {
			for (int i = 0; i != rows; i++) {
				for (int j = i + 1; j != cols; j++) {
					double tmp = matrix[i][j];
					matrix[i][j] = matrix[j][i];
					matrix[j][i] = tmp;
				}
			}
		} else {
			double[][] newMatrix = new double[cols][];
			for (int i = 0; i != cols; i++) {
				newMatrix[i] = new double[rows];
				for (int j = 0; j != rows; j++) {
					newMatrix[i][j] = matrix[j][i];
				}
			}
			matrix = newMatrix;
		}
	}

	public double[] multiply(double[] vector) {
		double result[] = new double[vector.length];
		for (int i = 0; i != matrix.length; i++) {
			double sum = 0.0;
			for (int j = 0; j != matrix[i].length; j++) {
				sum += matrix[i][j] * vector[j];
			}
			result[i] = sum;
		}
		return result;
	}

	@Override
	public Object clone() {
		NormalMatrix result = new NormalMatrix(rows, cols);
		for (int i = 0; i != rows; i++)
			for (int j = 0; j != cols; j++)
				result.matrix[i][j] = matrix[i][j];
		return result;
	}

	@Override
	public String toString() {
		if (rows == 0)
			return "[]";
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i != rows; i++) {
			for (int j = 0; j < cols - 1; j++)
				sb.append(matrix[i][j] + "\t");
			sb.append(matrix[i][cols - 1] + "\n");
		}
		return sb.toString();
	}
}
