package ru.netology.delivery;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DeliveryTest {

    @BeforeEach
    void setup() {
        open("http://localhost:9999");
    }

    @Test
    void shouldReplanMeeting() {
        var validUser = DataGenerator.Registration.generateUser("ru");

        String firstMeetingDate = DataGenerator.generateDate(4);
        String secondMeetingDate = DataGenerator.generateDate(7);

        // Первое заполнение формы
        $("[data-test-id='city'] input")
                .setValue(validUser.getCity());

        $("[data-test-id='date'] input")
                .press(Keys.chord(Keys.SHIFT, Keys.HOME))
                .press(Keys.DELETE)
                .setValue(firstMeetingDate);

        $("[data-test-id='name'] input")
                .setValue(validUser.getName());

        $("[data-test-id='phone'] input")
                .setValue(validUser.getPhone());

        $("[data-test-id='agreement']")
                .click();

        $(byText("Запланировать"))
                .shouldBe(visible, Duration.ofSeconds(15))
                .click();

        $(byText("Успешно!"))
                .shouldBe(visible, Duration.ofSeconds(15));

        $(byText("Встреча успешно запланирована на"))
                .shouldBe(visible, Duration.ofSeconds(15));

        $(byText(firstMeetingDate))
                .shouldBe(visible, Duration.ofSeconds(15));

        $("[data-test-id='date'] input")
                .press(Keys.chord(Keys.SHIFT, Keys.HOME))
                .press(Keys.DELETE)
                .setValue(secondMeetingDate);

        $(byText("Запланировать"))
                .shouldBe(visible, Duration.ofSeconds(15))
                .click();

        $(byText("Перепланировать"))
                .shouldBe(visible, Duration.ofSeconds(15))
                .click();

        $(byText("Успешно!"))
                .shouldBe(visible, Duration.ofSeconds(15));

        $(byText("Встреча успешно запланирована на"))
                .shouldBe(visible, Duration.ofSeconds(15));

        $(byText(secondMeetingDate))
                .shouldBe(visible, Duration.ofSeconds(15));
    }
}


