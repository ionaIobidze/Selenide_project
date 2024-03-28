package ge.tbcitacademy.data;

import org.testng.annotations.DataProvider;

public class VacationDataProvider {

    @DataProvider(name = "boundsProvider")
    public static Object[][] createData() {
        return new Object[][] {
                {"0", "120"},
                {"10", "120"},
                {"15", "150"},
                {"25", "200"},
                {"10", "300"}
        };
    }
}
