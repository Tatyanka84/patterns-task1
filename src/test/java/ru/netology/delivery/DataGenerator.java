package ru.netology.delivery;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DataGenerator {

    private DataGenerator() {
    }

    public static String generateDate(int shift) {
        return LocalDate.now()
                .plusDays(shift)
                .format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

    public static String generateCity(Faker faker) {
        String[] cities = {
                "Абакан",
                "Архангельск",
                "Астрахань",
                "Барнаул",
                "Белгород",
                "Биробиджан",
                "Благовещенск",
                "Брянск",
                "Великий Новгород",
                "Владивосток",
                "Владикавказ",
                "Владимир",
                "Волгоград",
                "Вологда",
                "Воронеж",
                "Горно-Алтайск",
                "Грозный",
                "Екатеринбург",
                "Иваново",
                "Ижевск",
                "Иркутск",
                "Йошкар-Ола",
                "Казань",
                "Калининград",
                "Калуга",
                "Кемерово",
                "Киров",
                "Кострома",
                "Краснодар",
                "Красноярск",
                "Курган",
                "Курск",
                "Кызыл",
                "Липецк",
                "Магадан",
                "Майкоп",
                "Махачкала",
                "Москва",
                "Мурманск",
                "Нальчик",
                "Нарьян-Мар",
                "Нижний Новгород",
                "Новосибирск",
                "Омск",
                "Оренбург",
                "Орёл",
                "Пенза",
                "Пермь",
                "Петрозаводск",
                "Псков",
                "Ростов-на-Дону",
                "Рязань",
                "Салехард",
                "Самара",
                "Санкт-Петербург",
                "Саранск",
                "Саратов",
                "Смоленск",
                "Ставрополь",
                "Сыктывкар",
                "Тамбов",
                "Тверь",
                "Томск",
                "Тула",
                "Тюмень",
                "Улан-Удэ",
                "Ульяновск",
                "Уфа",
                "Хабаровск",
                "Ханты-Мансийск",
                "Чебоксары",
                "Челябинск",
                "Черкесск",
                "Чита",
                "Элиста",
                "Южно-Сахалинск",
                "Якутск",
                "Ярославль"
        };

        return faker.options().option(cities);
    }


    public static String generateName(Faker faker) {
        return faker.name().fullName();
    }

    public static String generatePhone(Faker faker) {
        return faker.phoneNumber().phoneNumber();
    }

    public static class Registration {

        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            Faker faker = new Faker(new Locale(locale));

            return new UserInfo(
                    generateCity(faker),
                    generateName(faker),
                    generatePhone(faker)
            );
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}
