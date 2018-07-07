package com.geekbrains.weather;

public final class Data {
    private static String country;
    private static String name;
    private static boolean humidityChecked;
    private static boolean pressureChecked;

    public static boolean isHumidityChecked() {
        return humidityChecked;
    }

    public static void setHumidityChecked(boolean humidityChecked) {
        Data.humidityChecked = humidityChecked;
    }

    public static boolean isPressureChecked() {
        return pressureChecked;
    }

    public static void setPressureChecked(boolean pressureChecked) {
        Data.pressureChecked = pressureChecked;
    }



    public static String getCountry() {
        return country;
    }

    public static void setCountry(String country) {
        Data.country = country;
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Data.name = name;
    }





}
