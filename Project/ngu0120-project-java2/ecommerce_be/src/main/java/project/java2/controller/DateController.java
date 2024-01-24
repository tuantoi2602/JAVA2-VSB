package project.java2.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/date")
@CrossOrigin(origins = "http://localhost:3000")
public class DateController {
    @Autowired
    private DateTimeFormatter dateTimeFormatter;

    @GetMapping
    public String getCurrentDate() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofLocalizedDate(
            FormatStyle.FULL).localizedBy(Locale.ENGLISH);
        return dateTimeFormatter.format(LocalDate.now());
    }
}
