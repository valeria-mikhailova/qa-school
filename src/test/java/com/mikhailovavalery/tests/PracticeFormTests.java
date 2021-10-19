package com.mikhailovavalery.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.mikhailovavalery.tests.TestData.firstName;
import static com.mikhailovavalery.tests.TestData.lastName;

public class PracticeFormTests extends TestBase{



    @Test
    void TestForm() {
        open("https://demoqa.com/automation-practice-form");
        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue("a.smith@gmail.com");
        $(".custom-control-label").click();
        $("#userNumber").setValue("2354567454");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("December");
        $(".react-datepicker__year-select").selectOptionByValue("1992");
        $(".react-datepicker__day--017").click();
        $("#subjectsContainer").find("input").setValue("Commerce").pressEnter();
        $("[for='hobbies-checkbox-2']").click();
        File file = $("#uploadPicture").uploadFile(new File("src/test/java/com/mikhailovavalery/tests/resources/PracticeForm.jpg"));
        $("#currentAddress").setValue("Blin Street");
        $("#state").find("input").setValue("NCR").pressEnter();
        $("#city").find("input").setValue("Gurgaon").pressEnter();
        $("#submit").scrollTo().click();
        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text(firstName + " " + lastName),text("a.smith@gmail.com"), text("2354567454"), text("Commerce"),text("Reading"),text("PracticeForm.jpg"),text("Blin Street"),text("NCR"),text("Gurgaon")
        );
    }
}