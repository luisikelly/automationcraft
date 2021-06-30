package automationcraft.testcreation.petclinic.pages;

import automationcraft.engine.selenium.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.testng.Assert.*;

public class petClinicHomePage extends SeleniumBase {
    public petClinicHomePage(WebDriver driver) {
        super(driver);
    }

    //objects
    private By labelFindPets = By.xpath("//a[@href='/pets/search']");

    //method
    public void validarPetClinicHomePage(){
        goToUrl("http://spring-petclinic-git-webappspring.apps.ocp.tsoftlabs.com/");
        String validador = getTitle();
        if (validador != null){
            assertEquals(validador,"PetClinic :: a Spring Framework demonstration");
        }
    }

    public void irAFindPetsDesdeHomePage(){
        if(isDisplayed(labelFindPets)){
            click(labelFindPets);
        }
    }

}
