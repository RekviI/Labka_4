package org.example.DataAccesLayer;

import org.example.ServiceLayer.Service;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.example.PresentationLayer.Reader;
import org.example.ServiceLayer.MathModel;
import java.io.InputStream;
import java.util.*;

public class Interaction
{
    private static Scanner scanner;
    public Interaction(InputStream input)
    {
        scanner = new Scanner(input);
    }
    public static double getInput(String requiredData)
    {
        System.out.print(requiredData);
        String userInput = scanner.nextLine();
        return Double.parseDouble(userInput);
    }
    public void Integrate()
    {
        double menu = getInput("1 - Українська/ 2 - English\n");
        if (menu == 1)
        {
            double a = getInput("Введіть нижню межу інтегрування: ");
            double b = getInput("Введіть верхню межу інтегрування: ");
            double c = getInput("Введіть кількість інтервалів: ");
            System.out.print("Введіть функцію: ");
            String func = scanner.nextLine();
            Service service = new Service(new JSONObject(), System.in, new Reader());
            double res = service.getResult(a, b, c, func);
            service.saveResult(a, b , c, func, res);
            JSONObject components = service.getComponents();
            System.out.println(components);
        }
        else
        {
            double a = getInput("Enter lower limit integration limit: ");
            double b = getInput("Enter upper integration limit: ");
            double c = getInput("Enter sub intervals: ");
            System.out.print("Enter function: ");
            String func = scanner.nextLine();
            Service service = new Service(new JSONObject(), System.in, new Reader());
            double res = service.getResult(a, b, c, func);
            service.saveResult(a, b , c, func, res);
            JSONObject components = service.getComponents();
            System.out.println(components);
        }
        /*
        double a = getInput("Enter lower limit integration limit: ");
        double b = getInput("Enter upper integration limit: ");
        double c = getInput("Enter sub intervals: ");

        System.out.print("Enter function: ");
        String func = scanner.nextLine();
        Service service = new Service(new JSONObject(), System.in, new Reader());
        double res = service.getResult(a, b, c, func);
        service.saveResult(a, b , c, func, res);
        JSONObject components = service.getComponents();
        System.out.println(components);

         */
    }
}
