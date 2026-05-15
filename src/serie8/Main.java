package serie8;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public final class Main {
    public static void main(String[] args) {
        try {
            int[] hell0 = byteFrequencies("assets/file0.bin");
            int[] hell1 = byteFrequencies("assets/file1.bin");
            int[] hell2 = byteFrequencies("assets/file2.bin");
            int[] hell3 = byteFrequencies("assets/file3.bin");
            int[] hell4 = byteFrequencies("assets/file4.bin");
            int[] hell5 = byteFrequencies("assets/file5.bin");
            System.out.println(
                    "File0: avg: "+average(hell0)+" entropy: "+entropy(hell0)+",\n"+
                    "File1: avg: "+average(hell1)+" entropy: "+entropy(hell1)+",\n"+
                    "File2: avg: "+average(hell2)+" entropy: "+entropy(hell2)+",\n"+
                    "File3: avg: "+average(hell3)+" entropy: "+entropy(hell3)+",\n"+
                    "File4: avg: "+average(hell4)+" entropy: "+entropy(hell4)+",\n"+
                    "File5: avg: "+average(hell5)+" entropy: "+entropy(hell5)+",\n"
            );
        } catch (IOException e) {
            System.out.println("Fuckyou");
        }
    }

    static int[] byteFrequencies(String fileName) throws IOException {
        InputStream stream = new FileInputStream(fileName);
        int[] ct = new int[256];
        int tt = stream.read();
        while(tt != -1) {
            ct[tt]++;
            tt = stream.read();
        }
        stream.close();
        return ct;
    }

    static double average(int[] arr) {
        int sum = 0;
        int avg = 0;
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
            avg += arr[i]*i;
        }
        return (double) avg/sum;
    }

    static double entropy(int[] arr) {
        int sum = 0;
        double entropy = 0;
        for (int k : arr) {
            sum += k;
        }
        for(int j = 0; j < arr.length; j++) {
            if(arr[j] != 0) {
                double p = (double) arr[j] / sum;
                entropy -= p * (Math.log(p) / Math.log(2));
            }
        }
        return entropy;
    }
}
