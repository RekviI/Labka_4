package org.example.PresentationLayer;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
public class Reader
{
    public JSONArray readAll()
    {
        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = new JSONArray();
        File f = new File("Result.json");
        if(!f.exists() || f.length() == 0)
        {
            return jsonArray;
        }
        try (FileReader reader = new FileReader("Result.json"))
        {
            Object obj = jsonParser.parse(reader);
            jsonArray = (JSONArray) obj;

        } catch (ParseException | IOException e)
        {
            e.printStackTrace();
        }

        return jsonArray;
    }
    public JSONObject readNew() {

        JSONArray jsonArray = readAll();

        return (JSONObject) jsonArray.get(jsonArray.size() - 1);
    }
}
