package org.example.ServiceLayer;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.example.PresentationLayer.Reader;
import org.example.PresentationLayer.Writer;
import java.io.InputStream;
public class Service
{
    private final Reader reader;
    private final Writer writer;
    public Service(JSONObject jsObj, InputStream input, Reader reader)
    {
        this.reader = reader;
        this.writer = new Writer(jsObj, input, reader);
    }
    public double getResult(double a, double b, double c, String func)
    {
        MathModel math = new MathModel(a, b, c, func);
        return math.Integration();
    }
    public void saveResult(double a, double b, double c, String func, double res)
    {
        writer.SaveFunc(a, b, c, func, res);
    }
    public JSONObject getComponents()
    {
        return reader.readNew();
    }
}
