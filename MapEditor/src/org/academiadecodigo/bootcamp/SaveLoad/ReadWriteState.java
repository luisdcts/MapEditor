package org.academiadecodigo.bootcamp.SaveLoad;

import java.io.*;

public class ReadWriteState {

    public static void save(String grid) {
        try {
            FileWriter fileWriter = new FileWriter("resources/Save.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write("");
            bufferedWriter.write(grid);
            bufferedWriter.close();

        } catch (IOException io) {
            System.out.println("File not found");
        }
    }

    public static String[] load() {
        try {

            String load = "";
            String loadResult = "";
            FileReader fileReader = new FileReader("resources/Save.txt");
            BufferedReader bufferedReaders = new BufferedReader(fileReader);

            while ((load = bufferedReaders.readLine()) != null) {
                loadResult += load + "\n";
            }

            String[] loadResultArray = loadResult.split("\n");

            return loadResultArray;

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException io) {
            System.out.println("IO exception");
        }
        return null;
    }

}
