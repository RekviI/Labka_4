package org.example;

import org.example.DataAccesLayer.Interaction;
public class Main
{
    public static void main(String[] args)
    {
        Interaction starter = new Interaction(System.in);
        starter.Integrate();
    }
}