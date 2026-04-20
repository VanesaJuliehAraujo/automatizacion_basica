package Steps;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.regex.Pattern;

import static baseTest.BaseTest.page;

public class Emails {
    @Given("El usuario da clic en el boton Crear Campania")
    public void el_usuario_da_clic_en_el_boton_crear_campania() {
        page.navigate("https://appredesign.upccelerator.com/communication/email/all");
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
        page.waitForTimeout(3000);

        // Si la app redirigió a otra página (experts, login, etc.), reintentar navegación
        if (!page.url().contains("/communication/email")) {
            System.out.println("=== Redirigido a: " + page.url() + " — reintentando navegación a email...");
            page.waitForTimeout(2000);
            page.navigate("https://appredesign.upccelerator.com/communication/email/all");
            page.waitForLoadState(LoadState.DOMCONTENTLOADED);
            page.waitForTimeout(3000);
        }

        page.locator("button").filter(new Locator.FilterOptions()
                        .setHasText(Pattern.compile("crear", Pattern.CASE_INSENSITIVE)))
                .first().click();
    }

    @Given("Nombre de la campania {string}")
    public void nombre_de_la_campania(String nombre) {
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email enviar ahora")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email enviar ahora")).fill(nombre);
    }

    @Given("Asunto de la campania {string}")
    public void asunto_de_la_campania(String asunto) {
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Prueba enviar ahora")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Prueba enviar ahora")).fill(asunto);
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

    @When("Seleccion template {string}")
    public void seleccion_template(String plantilla) {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Seleccionar template")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(plantilla)).click();
        page.getByRole(AriaRole.BUTTON).nth(3).click();
    }

    @When("Plantilla predisenada {string}")
    public void plantilla_predisenada(String plantilla) {
        page.waitForTimeout(500);
        try {
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Sí")).click();
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(plantilla)).click();
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
    @And("Correos de prueba")
    public void correos_de_prueba() {
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Correos de Prueba")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Correos de Prueba")).fill("bcorrea@devcol.com.co");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Enviar Prueba")).click();
    }

    @When("Guardar como borrador")
    public void guardar_como_borrador() {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Guardar borrador")).click();
    }

    @When("Editar Plantilla")
    public void Editar_plantilla() {
        page.locator("div:nth-child(21) > .v-card-item > .v-card-item__content > .flex.items-center.gap-2.mt-4 > .flex.flex-row > .v-btn.v-btn--icon.v-theme--light.text-warning").click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Asunto de la campaña*")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Asunto de la campaña*")).fill("borradores");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Nombre de la campaña*")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Nombre de la campaña*")).fill("Guardar como borrador1");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Guardar borrador")).click();
    }

    @Then("Eliminar plantilla")
    public void Eliminar_plantilla() {
        page.locator("div:nth-child(22) > .v-card-item > .v-card-item__content > .flex.items-center.gap-2.mt-4 > .flex.flex-row > .v-btn.v-btn--icon.v-theme--light.text-error").click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Eliminar").setExact(true)).click();
    }
}
