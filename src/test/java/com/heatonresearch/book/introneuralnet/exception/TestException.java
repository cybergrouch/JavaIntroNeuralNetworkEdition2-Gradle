package com.heatonresearch.book.introneuralnet.exception;

import com.heatonresearch.book.introneuralnet.neural.exception.MatrixError;
import com.heatonresearch.book.introneuralnet.neural.exception.NeuralNetworkError;
import junit.framework.TestCase;

public class TestException extends TestCase {
    public void testMatrixError() {
        NullPointerException npe = new NullPointerException();
        new MatrixError(npe);
        new NeuralNetworkError(npe);
    }
}
