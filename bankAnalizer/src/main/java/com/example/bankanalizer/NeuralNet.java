package com.example.bankanalizer;

import org.deeplearning4j.nn.graph.ComputationGraph;
import org.deeplearning4j.nn.modelimport.keras.KerasModelImport;
import org.deeplearning4j.nn.modelimport.keras.exceptions.InvalidKerasConfigurationException;
import org.deeplearning4j.nn.modelimport.keras.exceptions.UnsupportedKerasConfigurationException;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.factory.Nd4j;

import java.io.IOException;
import java.util.Arrays;

public class NeuralNet {

    private float[] inputVector;

    public NeuralNet(float[] inputVector){
        this.inputVector = inputVector;
    }

    public float[] getInputVector() {
        return inputVector;
    }
    public void setInputVector(float[] inputVector) {
        this.inputVector = inputVector;
    }
    public float[] predict() throws IOException, UnsupportedKerasConfigurationException, InvalidKerasConfigurationException {
        float[] result = new float[12];
        ComputationGraph model = KerasModelImport.importKerasModelAndWeights("D:\\model.h5");
        int len_inp = inputVector.length;
        INDArray row = Nd4j.zeros(35);
        INDArray inp = Nd4j.create(1, 35);
        for(int i = 0; i < len_inp; i++){
            row.putScalar(new int[] {i}, inputVector[i]);
        }
        inp.putRow(0, row);
        INDArray[] res = model.output(inp);
        float[] classification = res[0].toFloatVector();
        float[] regression = res[1].toFloatVector();
        System.out.println(Arrays.toString(regression));
        System.out.println(Arrays.toString(classification));
        for(int i = 0; i < 11; i++){
            result[i] = regression[i];
        }
        result[11] = classification[0];
        return result;
    }
}
