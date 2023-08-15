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
        // TODO: добавить логику для объявления переменной date и задания её значения, для генерации строки с датой
        // Вы можете использовать класс LocalDate и его методы для получения и форматирования даты
        return LocalDate.now().plusDays(addDays).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        //return date;

    public static String generateCity() {
        var cities = new String[] {"Горно-Алтайск", "Уфа", "Улан-Удэ","Махачкала", "Магас", "Нальчик", "Элиста", "Черкесск",
                "Петрозаводск","Сыктывкар", "Йошкар-Ола", "Якутск", "Казань", "Ижевск", "Чебоксары",
                "Симферополь", "Петропавловск-Камчатский", "Чита", "Краснодар", "Ставрополь", "Владивосток", "Пермь", "Красноярск",
                "Благовещенск", "Архангельск", "Брянск", "Белгород", "Астрахань", "Волгоград", "Владимир", "Мурманск", "Вологда",
                "Иркутск", "Калининград", "Воронеж", "Киров", "Нижний-Новгород", "Омск", "Новосибирск", "Екатеринбург"};
        // TODO: добавить логику для объявления переменной city и задания её значения, генерацию можно выполнить
        // с помощью Faker, либо используя массив валидных городов и класс Random
        return cities [new Random().nextInt(cities.length)];
    }

    public static String generateName(String locale) {
        // TODO: добавить логику для объявления переменной name и задания её значения, для генерации можно
        // использовать Faker
        var faker = new Faker(new Locale(locale));
        return faker.name().lastName() +" "+faker.name().firstName();
    }

    public static String generatePhone(String locale) {
        // TODO: добавить логику для объявления переменной phone и задания её значения, для генерации можно
        // использовать Faker
        var faker = new Faker(new Locale(locale));
        return faker.phoneNumber().phoneNumber();
        //return phone;
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser (String(locale)){
            // TODO: добавить логику для создания пользователя user с использованием методов generateCity(locale),
            // generateName(locale), generatePhone(locale)
            return new UserInfo (generateCity(), generateName(locale), generatePhone(locale));
            // return user;
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;


    }
}
