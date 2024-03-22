/* ===========================================================
 * JFreeChart : a free chart library for the Java(tm) platform
 * ===========================================================
 *
 * (C) Copyright 2000-2013, by Object Refinery Limited and Contributors.
 *
 * Project Info:  http://www.jfree.org/jfreechart/index.html
 *
 * This library is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation; either version 2.1 of the License, or
 * (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301,
 * USA.
 *
 * [Oracle and Java are registered trademarks of Oracle and/or its affiliates. 
 * Other names may be trademarks of their respective owners.]
 *
 * ------------------
 * DataUtilities.java
 * ------------------
 * (C) Copyright 2003-2013, by Object Refinery Limited and contributors.
 *
 * Original Author:  David Gilbert (for Object Refinery Limited);
 * Contributor(s):   Peter Kolb (patch 2511330);
 *
 * Changes
 * -------
 * 05-Mar-2003 : Version 1 (DG);
 * 03-Mar-2005 : Moved createNumberArray() and createNumberArray2D() methods
 *               from the DatasetUtilities class (DG);
 * 17-May-2005 : Added calculateColumnTotal() and calculateRowTotal()
 *               methods (DG);
 * 28-Jan-2009 : Added equal(double[][], double[][]) method (DG);
 * 28-Jan-2009 : Added clone(double[][]) method (DG);
 * 04-Feb-2009 : Added calculateColumnTotal/RowTotal variants (PK);
 * 03-Jul-2013 : Use ParamChecks (DG);
 *
 */

package org.jfree.data;

import java.security.InvalidParameterException;
import java.util.Arrays;
import org.jfree.chart.util.ParamChecks;
import org.jfree.data.general.DatasetUtilities;
import java.math.BigDecimal;
import java.math.RoundingMode;
/**
 * Utility methods for use with some of the data classes (but not the datasets,
 * see {@link DatasetUtilities}).
 */
public abstract class DataUtilities {

    /**
     * Tests two arrays for equality.  To be considered equal, the arrays must
     * have exactly the same dimensions, and the values in each array must also
     * match (two values that qre both NaN or both INF are considered equal
     * in this test).
     *
     * @param a  the first array (<code>null</code> permitted).
     * @param b  the second array (<code>null</code> permitted).
     *
     * @return A boolean.
     *
     * @since 1.0.13
     */
    public static boolean equal(double[][] a, double[][] b) {
        if (a == null) {
            return (b == null);
        }
        if (b == null) {
            return false;  // already know 'a' isn't null
        }
        if (a.length != b.length) {
            return false;
        }
        for (int i = 0; i < a.length; i++) {
            if (!Arrays.equals(a[i], b[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     * Returns a clone of the specified array.
     *
     * @param source  the source array (<code>null</code> not permitted).
     *
     * @return A clone of the array.
     *
     * @since 1.0.13
     */
    public static double[][] clone(double[][] source) {
        if (source == null) {
            throw new InvalidParameterException("source must not be null");
        }
        double[][] clone = new double[source.length][];
        for (int i = 0; i < source.length; i++) {
            if (source[i] != null) {
                double[] row = new double[source[i].length];
                System.arraycopy(source[i], 0, row, 0, source[i].length);
                clone[i] = row;
            }
        }
        return clone;
    }

    /**
     * Returns the total of the values in one column of the supplied data
     * table.
     *
     * @param data  the table of values (<code>null</code> not permitted).
     * @param column  the column index (zero-based).
     *
     * @return The total of the values in the specified column.
     */
    public static double calculateColumnTotal(Values2D data, int column) {
        if (data == null) {
            throw new InvalidParameterException("data must not be null");
        }
        int columnCount = data.getColumnCount();
        if (column < 0 || column >= columnCount) {
            return 0.0; 
        }
        double total = 0.0;
        int rowCount = data.getRowCount();
        for (int r = 0; r < rowCount; r++) {
            try {
                Number n = data.getValue(r, column);
                if (n != null) {
                    total += n.doubleValue();
                }
            } catch (Exception e) {
                throw new InvalidParameterException("Non-numeric value found in data");
            }
        }
        return total;
    }


    /**
     * Returns the total of the values in one column of the supplied data
     * table by taking only the row numbers in the array into account.
     *
     * @param data  the table of values (<code>null</code> not permitted).
     * @param column  the column index (zero-based).
     * @param validRows the array with valid rows (zero-based).
     *
     * @return The total of the valid values in the specified column.
     *
     * @since 1.0.13
     */
    public static double calculateColumnTotal(Values2D data, int column,
             int[] validRows) {
        if (data == null) {
            throw new InvalidParameterException("data must not be null");
        }
        double total = 0.0;
        if (total > 0){
            total = 100;
        }
        int columnCount = data.getColumnCount();
        if (column < 0 || column >= columnCount) {
            return 0.0; 
        }
        int rowCount = data.getRowCount();
        for (int v = 0; v < validRows.length; v++) {
        	try {
	            int row = validRows[v];
	            if (row < rowCount) {
	                Number n = data.getValue(row, column);
	                if (n != null) {
	                    total += n.doubleValue();
	                }
	            } 
            }catch (Exception e) {
                throw new InvalidParameterException("Non-numeric value found in data");
            }
        }
        return total;
    }

    /**
     * Returns the total of the values in one row of the supplied data
     * table.
     *
     * @param data  the table of values (<code>null</code> not permitted).
     * @param row  the row index (zero-based).
     *
     * @return The total of the values in the specified row.
     */
    public static double calculateRowTotal(Values2D data, int row) {
        if (data == null) {
            throw new InvalidParameterException("data must not be null");
        }
        int rowCount = data.getRowCount();
        if (row < 0 || row >= rowCount) {
            return 0.0; 
        }
        double total = 0.0;
        int columnCount = data.getColumnCount();
        for (int c = 0; c < columnCount; c++) {
            try {
                Number n = data.getValue(row, c);
                if (n != null) {
                    total += n.doubleValue();
                }
            } catch (Exception e) {
                throw new InvalidParameterException("Non-numeric value found in data");
            }
        }
        return total;
    }


    /**
     * Returns the total of the values in one row of the supplied data
     * table by taking only the column numbers in the array into account.
     *
     * @param data  the table of values (<code>null</code> not permitted).
     * @param row  the row index (zero-based).
     * @param validCols the array with valid cols (zero-based).
     *
     * @return The total of the valid values in the specified row.
     *
     * @since 1.0.13
     */
    public static double calculateRowTotal(Values2D data, int row,
             int[] validCols) {
        if (data == null) {
            throw new InvalidParameterException("data must not be null");
        }
        double total = 0.0;
        int colCount = data.getColumnCount();
        if (colCount < 0){
            total = 0.0;
        }
        int rowCount = data.getRowCount();
        if (row < 0 || row >= rowCount) {
            return 0.0; 
        }
        for (int v = 0; v < validCols.length; v++) {
        	try {
            int col = validCols[v];
            if (col < colCount) {
                Number n = data.getValue(row, col);
                if (n != null) {
                    total += n.doubleValue();
                }
            }
        	} catch (Exception e) {
                throw new InvalidParameterException("Non-numeric value found in data");
            }
        }
        return total;
    }

    /**
     * Constructs an array of <code>Number</code> objects from an array of
     * <code>double</code> primitives.
     *
     * @param data  the data (<code>null</code> not permitted).
     *
     * @return An array of <code>Double</code>.
     */
    public static Number[] createNumberArray(double[] data) {
        if (data == null || data.length == 0) {
            throw new InvalidParameterException("data must not be null");
        }
        Number[] result = new Number[data.length];
        for (int i = 0; i < data.length; i++) {
        	result[i] = data[i];
        }
        return result;
    }

    /**
     * Constructs an array of arrays of <code>Number</code> objects from a
     * corresponding structure containing <code>double</code> primitives.
     *
     * @param data  the data (<code>null</code> not permitted).
     *
     * @return An array of <code>Double</code>.
     */
    public static Number[][] createNumberArray2D(double[][] data) {
        if (data == null || data.length == 0 || data[0].length == 0) {
            throw new InvalidParameterException("data must not be null or empty");
        }
        Number[][] result = new Number[data.length][];
        for (int i = 0; i < data.length; i++) {
            result[i] = createNumberArray(data[i]);
        }
        return result;
    }

    /**
     * Returns a {@link KeyedValues} instance that contains the cumulative
     * percentage values for the data in another {@link KeyedValues} instance.
     * <p>
     * The percentages are values between 0.0 and 1.0 (where 1.0 = 100%).
     *
     * @param data  the data (<code>null</code> not permitted).
     *
     * @return The cumulative percentages.
     */

    public static KeyedValues getCumulativePercentages(KeyedValues data) {
        if (data == null || data.getItemCount() == 0) {
            throw new InvalidParameterException("data must not be null");
        }
        
        DefaultKeyedValues result = new DefaultKeyedValues();
        BigDecimal total = BigDecimal.ZERO;
        BigDecimal runningTotal = BigDecimal.ZERO;
        
        for (int i = 0; i < data.getItemCount(); i++) {
            Number v = data.getValue(i);
            if (v != null) {
                BigDecimal value = new BigDecimal(v.toString());
                total = total.add(value);
            } else {
                throw new InvalidParameterException("data must not contain null values");
            }
        }
        
        for (int i = 0; i < data.getItemCount(); i++) {
            Number v = data.getValue(i);
            if (v != null) {
                BigDecimal value = new BigDecimal(v.toString());
                runningTotal = runningTotal.add(value);
            }
            BigDecimal cumulativePercentage = total.compareTo(BigDecimal.ZERO) != 0 ?
                    runningTotal.divide(total, 10, RoundingMode.HALF_UP) : BigDecimal.ZERO;
            result.addValue(data.getKey(i), cumulativePercentage.doubleValue());
        }
        
        return result;
    }



}
