package components;

import static com.codeborne.selenide.Selenide.$;
import static java.lang.String.format;

public class Calendar {
    public void setDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
        String DayLocator = format(".react-datepicker__day.react-datepicker__day--0%s", day);
        $(DayLocator).click();

    }
}
