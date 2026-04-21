package Steps;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static driverSetup.driver.page;

public class Emails {
    @Given("El usuario da clic en el boton Crear Campania")
    public void el_usuario_da_clic_en_el_boton_crear_campania() {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ingresar")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ingresar")).first().click();
        page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("E-mails")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Crear Campaña")).click();
    }
    @Given("Nombre de la campania {string}")
    public void nombre_de_la_campania(String nombre) {
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Nombre de la campaña*")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Nombre de la campaña*")).fill("campaña automatizada");
    }
    @Given("Asunto de la campania {string}")
    public void asunto_de_la_campania(String asunto) {
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Asunto de la campaña*")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Asunto de la campaña*")).fill("Automatización");
    }
    @When("Remitente")
    public void remitente() {
        page.locator(".v-field__append-inner").first().click();
        page.getByText("notification@app.upccelerator").click();
    }
    @When("Lista de contactos")
    public void lista_de_contactos() {
        page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Lista de contactos*")).click();
        page.getByText("contactos los boniticos").click();
    }
    @When("Seleccion template {string}")
    public void seleccion_template(String plantilla) {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Seleccionar template")).click();
    }
    @When("Plantilla predisenada {string}")
    public void plantilla_predisenada(String plantilla) {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Plantilla 3")).click();
    }
    @And("Enviar ahora")
    public void enviar_ahora() {
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Correos de Prueba")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Correos de Prueba")).fill("vjaraujo0810@gmail.com");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Enviar Prueba")).click();
    }
    @Then("Elimina plantilla")
    public void elimina_plantilla() {
        page.getByRole(AriaRole.BUTTON).nth(3).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sí")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Plantilla 1")).click();
    }
    @When("Enviar prueba")
    public void enviar_prueba() {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Enviar").setExact(true)).click();
    }
}

