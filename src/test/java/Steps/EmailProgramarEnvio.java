package Steps;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import static driverSetup.driver.page;

public class EmailProgramarEnvio {
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
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Nombre de la campaña*")).fill("Automatiz. Programar envio");
    }
    @Given("Asunto de la campania")
    public void asunto_de_la_campania() {
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Asunto de la campaña*")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Asunto de la campaña*")).fill("Prueba programar envio");
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
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Plantilla 2")).click();
        page.getByRole(AriaRole.BUTTON).nth(3).click();
    }
    @When("Plantilla predisenada")
    public void plantilla_predisenada() {
        page.waitForTimeout(500);
        try {
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sí")).click();
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Plantilla 2")).click();
        } catch (Exception e) {
            System.out.println("Plantilla predisenada: plantilla ya seleccionada, continuando");
        }
    }
    @When("Agrega correos de prueba")
    public void agrega_correos_de_prueba() {
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Correos de Prueba")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Correos de Prueba")).fill("vanesajulietharaujo@gmail.com.co");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Correos de Prueba")).fill("amontoya@devcol.com.co");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Correos de Prueba")).fill("bcorreat@unicartagena.edu.co");
    }

    @When("Enviar prueba")
    public void enviar_prueba() {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Enviar Prueba")).click();
    }


    @When("Selecciona fecha")
    public void selecciona_fecha() {
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Fecha")).fill("2026-03-20");
    }

    @When("Selecciona hora")
    public void selecciona_hora() {
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Hora")).press("ArrowLeft");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Hora")).fill("17:15");
    }

    @And("Programar")
    public void programar() {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Programar")).click();
    }
}
