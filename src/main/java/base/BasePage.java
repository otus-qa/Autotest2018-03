package base;

import utils.PropertyReader;

public class BasePage {

    public static int getTimeout() {
        return Integer.parseInt(PropertyReader.getPropertyFromFile("properties/settings.properties", "timeout"));
    }

    public static void main(String[] args) {
        System.out.println(getTimeout());
    }
}
