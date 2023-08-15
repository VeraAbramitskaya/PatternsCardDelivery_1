package ru.netology.delivery.data;

import com.github.javafaker.Faker;
import lombok.Value;
import lombok.val;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(int addDays, String pattern) {

        return LocalDate.now().plusDays(addDays).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }


        public static String generateCity () {
            var cities = new String[]{"Горно-Алтайск", "Уфа", "Улан-Удэ", "Махачкала", "Магас", "Нальчик", "Элиста", "Черкесск",
                    "Петрозаводск", "Сыктывкар", "Йошкар-Ола", "Якутск", "Казань", "Ижевск", "Чебоксары",
                    "Симферополь", "Петропавловск-Камчатский", "Чита", "Краснодар", "Ставрополь", "Владивосток", "Пермь", "Красноярск",
                    "Благовещенск", "Архангельск", "Брянск", "Белгород", "Астрахань", "Волгоград", "Владимир", "Мурманск", "Вологда",
                    "Иркутск", "Калининград", "Воронеж", "Киров", "Нижний-Новгород", "Омск", "Новосибирск", "Екатеринбург"};

            return cities[new Random().nextInt(cities.length)];
        }


    public static String generateName(String locale) {

        var faker = new Faker(new Locale(locale));
        return faker.name().lastName() + " " + faker.name().firstName();
    }

    public static String generatePhone(String locale) {

        var faker = new Faker(new Locale(locale));
        return faker.phoneNumber().phoneNumber();

    }

    public static class Registration {
        private Registration() {
        }


        public static UserInfo generateUser(String locale) {
            return new UserInfo(generateCity(), generateName(locale), generatePhone(locale));

        }
    }


    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;


    }
}


