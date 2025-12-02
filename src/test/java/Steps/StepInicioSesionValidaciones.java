package Steps;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static driverSetup.driver.page;

public class StepInicioSesionValidaciones {
    @Given("El usuario accede al sistema de upccelerator")
    public void el_usuario_accede_al_sistema_de_upccelerator() {
        page.navigate("https://appedesign.upccelerator.com/login");
        System.out.println(page.title());
    }
    @Given("Correo incorrecto")
    public void correo_incorrecto() {
    page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Correo electrónico Correo")).fill("vanesaqvanesa.com");
    }
    @When("Correo NO registrado en la base de datos")
    public void correo_no_registrado_en_la_base_de_datos() {
     page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Correo electrónico Correo")).fill("varaujo123@devcol.com");
    }
    @When("Correo registrado en la base de datos y clic en enviar codigo de ingreso")
    public void correo_registrado_en_la_base_de_datos_y_clic_en_enviar_codigo_de_ingreso() {
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Correo electrónico Correo")).fill("varaujo@devcol.com.co");
    }
    @When("Codigo incorrecto")
    public void codigo_incorrecto() {

    }
    @When("Reenviar codigo")
    public void reenviar_codigo() {

    }
    @Then("Codigo correcto")
    public void codigo_correcto() {
        throw new io.cucumber.java.PendingException();
    }
}