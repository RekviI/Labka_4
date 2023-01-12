package org.example.PresentationLayer;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
public class Writer
{
    private final JSONObject json;
    private final Scanner scanner;
    private final Reader reader;

    public Writer(JSONObject json, InputStream input, Reader reader)
    {
        this.json = json;
        this.scanner = new Scanner(input);
        this.reader = reader;
    }
    public void SaveFunc(double a, double b, double c, String func, double res)
    {
        double[] lim = new double[2];
        lim[0] = a;
        lim[1] = b;
        System.out.println("How to continue ? 1 - Українська/ 2 - English");
        int menu = scanner.nextInt();
        if (menu == 1)
        {
            json.put("Функція", func);
            json.put("Межі інтегрування", Arrays.toString(lim));
            json.put("Крок", c);
            json.put("Результат", res);
        }
        else
        {
            json.put("Function", func);
            json.put("Interval of integration", Arrays.toString(lim));
            json.put("Step", c);
            json.put("Result", res);
        }
        JSONArray jsonArray = reader.readAll();
        jsonArray.add(json);
        try(FileWriter fileWriter = new FileWriter("Result.json")){
            fileWriter.write(jsonArray.toJSONString());
            fileWriter.flush();
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
