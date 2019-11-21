package net.judgeglass.tilegame.world;

import net.judgeglass.jgameengine.core.io.Log;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Save {
    public static int[] data;

    public static void read(String filename){
        data = new int[64];
        BufferedReader reader;
        try{
            int counter = 0;
            reader = new BufferedReader(new FileReader(filename));
            String line = reader.readLine();
            while(line != null){
                String[] lineS = line.split(",");
                for(int i = 0; i < lineS.length; i++){
                    data[i * counter] = Integer.parseInt(lineS[i]);
                }
                counter++;
                line = reader.readLine();
            }
            reader.close();
        }catch (IOException e){
            Log.error("Could not read: " + filename);
        }
    }
}
