package uk.tests.obsolete;

import org.testng.annotations.Test;
import utils.PersonInformationBuilder;
import utils.PropertyReader;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SuperTest {
    long magicValue = 200;

    @Test
    public void test() {
        System.out.println("The property:" + PropertyReader.getPropertyFromFile("properties/settings.properties", "timeout"));

        PersonInformationBuilder person =
                new PersonInformationBuilder
                        .PersonBuilder("", "", "")
                        .city("city")
                        .isEmployed(true)
                        .isFemale(false)
                        .createPerson();
    }

    public static void main(String[] args) {

        List<String> names = Arrays.asList("vasya", "alena", "petya", "kostik", "pasha");

        Collections.sort(names, Comparator.naturalOrder());

        names.forEach(System.out::println);

        List<String> namesStartWithP = names.stream().parallel().filter(name -> name.startsWith("p")).collect(Collectors.toList());

        namesStartWithP.forEach(System.out::println);
    }

}
