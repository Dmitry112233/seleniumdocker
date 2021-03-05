import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleTest extends BaseTest{

    private String textExp = "Google";

    @Test
    public void checkLogo() {
        googlePage.OpenPage();
        String attributeText = googlePage.GetLogoAtributeAlt();
        System.out.println("Logo text is: " + attributeText);
        Assert.assertEquals(attributeText, textExp, String.format("Logo has incorrect attribute alt: %s", attributeText));
    }
}
