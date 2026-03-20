package Steps;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static driverSetup.driver.page;

public class EmailEnviarAhora {
    @Given("El usuario da clic en el boton Crear Campania")
    public void el_usuario_da_clic_en_el_boton_crear_campania() {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ingresar")).first().click();
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
        page.waitForTimeout(1000);
        page.evaluate("() => { const el = document.querySelector('a[href*=\"/email\"]'); if (el) el.click(); else throw new Error('Link E-mails no encontrado'); }");
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
        page.waitForTimeout(500);
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Crear Campaña")).click();
    }
    @Given("Nombre de la campania")
    public void nombre_de_la_campania() {
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Nombre de la campaña*")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Nombre de la campaña*")).fill("email Automatizado");
    }
    @Given("Asunto de la campania")
    public void asunto_de_la_campania() {
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Asunto de la campaña*")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Asunto de la campaña*")).fill("prueba automat");
    }
    @When("Remitente")
    public void remitente() {
        page.locator(".v-field.v-field--appended > .v-field__field > .v-field__input").first().click();
        page.getByText("notification@app.upccelerator").click();
    }
    @When("Lista de contactos")
    public void lista_de_contactos() {
        page.locator("div:nth-child(4) > .v-input__control > .v-field > .v-field__append-inner > .mdi-menu-down").click();
        page.getByText("contactos los boniticos").click();
    }
    @When("Seleccion template")
    public void seleccion_template() {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Seleccionar template")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Plantilla 1")).click();
        page.getByRole(AriaRole.BUTTON).nth(3).click();
    }
    @When("Plantilla predisenada")
    public void plantilla_predisenada() {
        page.waitForTimeout(500);
        try {
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sí")).click();
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Plantilla 1")).click();
        } catch (Exception e) {
            System.out.println("Plantilla predisenada: plantilla ya seleccionada, continuando");
        }
    }
    @And("Enviar ahora")
    public void enviar_ahora() {
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Correos de Prueba")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Correos de Prueba")).fill("vanesajulietharaujo@gmail.com.co");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Enviar Prueba")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Enviar").setExact(true)).click();
    }
    @Then("Elimina plantilla")
    public void elimina_plantilla() {
        page.locator("div:nth-child(16) > .v-card-item > .v-card-item__content > .flex.items-center.gap-2.mt-4 > .flex.flex-row > .v-btn.v-btn--icon.v-theme--light.text-error").click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Eliminar").setExact(true)).click();
    }

}
