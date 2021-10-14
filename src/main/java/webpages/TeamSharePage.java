package webpages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class TeamSharePage {
    @FindBy(css = "a[title=\"Shares\"]")
    public SelenideElement sharesTab;

    @FindBy(id = "company_id")
    public SelenideElement company_id;

    @FindBy(id = "name")
    public SelenideElement name;

    @FindBy(id = "submit_form")
    public SelenideElement saveButton;

    @FindBy(css = "button[id='btn_confirm']")
    public SelenideElement confirmOkButton;

    @FindBy(xpath = "//*[contains(text(), \"Team share name is required\")]")
    public SelenideElement errorMessageTeamShareIsRequired;

    public void clickOnCreateTeamShareButton(int orgId){
        $(By.cssSelector("a[href=\"/roots/" + orgId +"/create/share/\"]")).click();
    }

    public void clickOnCreateTeamShareButton(){
        $(By.cssSelector(".btn")).shouldHave(exactText("Create Team Share")).click();
    }

    public void clickOnUserCheckBox(String name){
        $(By.xpath("//td[contains(., \"" + name + "\")]//span[@role='checkbox']")).click();
    }

    public void teamShareIsVisible(String teamShareName){
        $(By.xpath("//a[contains(., \"" + teamShareName + "\")]")).shouldBe(visible);
    }

    public String getTeamShareId(String teamShareName){
        String teamShareId = $(By.xpath("//tr[contains(., \"" + teamShareName + "\")]")).getAttribute("data-root_id");
        return teamShareId;
    }


}
