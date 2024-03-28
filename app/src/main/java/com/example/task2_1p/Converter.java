package com.example.task2_1p;

public class Converter {
    public static double convertUnits(String sourceUnit, String destinationUnit, double value) {
        switch (sourceUnit) {
            case "inch":
                switch (destinationUnit) {
                    case "cm":
                        return value * 2.54;
                    case "foot":
                        return value / 12.0; // Convert inches to feet
                    default:
                        break;
                }
                break;
            case "foot":
                switch (destinationUnit) {
                    case "cm":
                        return value * 30.48;
                    case "inch":
                        return value * 12.0; // Convert feet to inches
                    case "yard":
                        return value / 3.0; // Convert feet to yards
                    default:
                        break;
                }
                break;
            case "yard":
                switch (destinationUnit) {
                    case "cm":
                        return value * 91.44;
                    case "foot":
                        return value * 3.0; // Convert yards to feet
                    default:
                        break;
                }
                break;
            case "mile":
                switch (destinationUnit) {
                    case "km":
                        return value * 1.60934;
                    default:
                        break;
                }
                break;
            case "pound":
                switch (destinationUnit) {
                    case "kg":
                        return value * 0.453592;
                    case "ounce":
                        return value * 16.0; // Convert pounds to ounces
                    default:
                        break;
                }
                break;
            case "ounce":
                switch (destinationUnit) {
                    case "g":
                        return value * 28.3495;
                    case "pound":
                        return value / 16.0; // Convert ounces to pounds
                    default:
                        break;
                }
                break;
            case "ton":
                switch (destinationUnit) {
                    case "kg":
                        return value * 907.185;
                    default:
                        break;
                }
                break;
            case "Celsius":
                switch (destinationUnit) {
                    case "Fahrenheit":
                        return (value * 1.8) + 32;
                    case "Kelvin":
                        return value + 273.15;
                    default:
                        break;
                }
                break;
            case "Fahrenheit":
                switch (destinationUnit) {
                    case "Celsius":
                        return (value - 32) / 1.8;
                    case "Kelvin":
                        return (value + 459.67) * (5.0 / 9.0);
                    default:
                        break;
                }
                break;
            case "Kelvin":
                switch (destinationUnit) {
                    case "Celsius":
                        return value - 273.15;
                    case "Fahrenheit":
                        return (value * 9.0 / 5.0) - 459.67;
                    default:
                        break;
                }
                break;
            default:
                break;
        }
        return -1; // Return -1 if conversion is not supported
    }
}
