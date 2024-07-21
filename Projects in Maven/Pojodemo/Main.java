package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Player Info");

        PlayerData pd = new PlayerData();

        pd.setPlayerName("Virat Kohli");
        pd.setCountry("India");
        pd.setAge(30);

        System.out.println("Player Name : " + pd.getPlayerName());
        System.out.println("Country Name : " + pd.getCountry());
        System.out.println("Player Age : " + pd.getAge());

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the players's name");
        String playerName = sc.nextLine();

        System.out.println("Enter the players's name");
        String countryName = sc.nextLine();

        System.out.println("Enter the players's name");
        int age = sc.nextInt();

        pd = new PlayerData();
        pd.setCountry(countryName);
        pd.setAge(age);
        pd.setPlayerName(playerName);

        System.out.println("Player Name : " + pd.getPlayerName());
        System.out.println("Country Name : " + pd.getCountry());
        System.out.println("Player's Age : " + pd.getAge());

    }
}