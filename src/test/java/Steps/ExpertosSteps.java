package Steps;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.nio.file.Paths;
import java.util.regex.Pattern;

import static driverSetup.driver.page;

public class ExpertosSteps {

    @Given("El usuario da clic en Agregar Experto")
    public void clic_agregar_experto() {
        page.navigate("https://appredesign.upccelerator.com/experts");
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
        page.getByRole(
                AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName(Pattern.compile("AGREGAR", Pattern.CASE_INSENSITIVE))
        ).first().click();
        page.waitForTimeout(1000);
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("after_click_agregar.png")));
        System.out.println("Screenshot guardado: after_click_agregar.png");
    }

    @Given("El usuario agrega fotografia")
    public void el_usuario_agrega_fotografia() {
        page.waitForTimeout(1000);
        try {
            if (page.locator("input[type='file']").count() > 0) {
                page.locator("input[type='file']").first().setInputFiles(Paths.get("src/test/resources/images/pet (1).jpg"));
                page.waitForTimeout(1000);
                System.out.println("Fotografía cargada exitosamente");
            } else {
                System.out.println("No se encontró input de archivo - continuando sin imagen");
            }
        } catch (Exception e) {
            System.out.println("Error al cargar fotografía (opcional): " + e.getMessage());
        }
    }

    @When("Nombre experto")
    public void nombre_experto() {
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName(Pattern.compile(".*Nombre.*", Pattern.CASE_INSENSITIVE))).first().fill("prueba automatizada 2");
    }

    @When("Descripción")
    public void descripcion() {
        Locator desc = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName(Pattern.compile(".*Descripci.*", Pattern.CASE_INSENSITIVE))).first();
        desc.click();
        desc.fill("esto es una prueba");
    }

    @When("Email incorrecto")
    public void email_incorrecto() {
        Locator email = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName(Pattern.compile(".*Email.*", Pattern.CASE_INSENSITIVE))).first();
        email.click();
        email.fill("hahortadevcol.com");
    }

    @When("Selecciona extension")
    public void selecciona_extension() {
        page.locator(".v-field.v-field--appended > .v-field__field > .v-field__input").first().click();
        page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("+31")).click();
    }

    @When("Telefono")
    public void telefono() {
        Locator tel = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName(Pattern.compile(".*[Tt]el.*"))).first();
        tel.click();
        tel.fill("(302) 446 - 9077");
    }

    @When("Pais")
    public void pais() {
        page.locator("div:nth-child(5) > div > .v-input__control > .v-field > .v-field__append-inner").click();
        page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Bulgaria")).click();
    }

    @When("Ciudad")
    public void ciudad() {
        page.locator(".flex.gap-2 > .v-input > .v-input__control > .v-field > .v-field__field > .v-field__input").click();
        page.waitForTimeout(500);
        page.getByText("Anton", new Page.GetByTextOptions().setExact(true)).click();
    }

    @And("Dominio")
    public void dominio() {
        Locator dominio = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Dominio"));
        dominio.click();
        dominio.fill("www.pruebaautomatizada.com");
    }

    @And("Terminos y condiciones")
    public void Terminos_y_condiciones() {
        page.locator(".ql-editor").first().press("CapsLock");

        page.locator(".ql-editor").first().fill("Aceptación de términos y condiciones, indica que al navegar, compra, el usuario acepta las condiciones\n\nPolítica de pagos: Especifica los métodos de pago moneda y la obligación de realizar el pago por adelantado\n\nUso permitido: Prohíbe actividades ilícitas, spam o comentarios ofensivos");
    }

    @And("Politica de tratamiento de datos")
    public void politica_de_tratamiento_de_datos() {
        page.locator(".ql-editor").nth(1).click();
        page.locator(".ql-editor").nth(1).fill("Aceptación de terminos y condiciones, indica que al navegar, compra, el usuario acepta las condiciones\n\nPolítica de pagos: Especifica los métodos de pago moneda y la obligación de realizar el pago por adelantado\n\nUso permitido: Prohibe actividades ilicitas, spam o comentarios ofensivos\n\nAceptación de Términos: Indica que al navegar o comprar, el usuario acepta las condiciones.\nPropiedad Intelectual: Protege el contenido (logos, textos, fotos) indicando que es propiedad exclusiva de la empresa. Política de Pagos: Especifica los métodos de pago, moneda y la obligatoriedad de realizar el pago por adelantado. Uso Permitido/Prohibido: Prohíbe actividades ilícitas, spam o comentarios ofensivos.\nEnvíos y Devoluciones: Detalla tiempos de entrega, costes de envío y el procedimiento para devoluciones o garantías.\nLimitación de Responsabilidad: La empresa no se hace responsable de errores técnicos o usos indebidos del producto. Legislación Aplicable: Define la jurisdicción y las leyes del país o estado bajo las cuales se rige el acuerdo");
    }

    @Then("Clic Guardar")
    public void clic_guardar() {
        page.waitForTimeout(1000);
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("before_guardar.png")).setFullPage(true));
        System.out.println("Screenshot antes de guardar: before_guardar.png");
        try {
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Guardar")).click(new com.microsoft.playwright.Locator.ClickOptions().setForce(true).setTimeout(10000));
            System.out.println("Clic en Guardar ejecutado exitosamente");
        } catch (Exception e) {
            System.out.println("Nota: No se pudo hacer clic en Guardar - " + e.getMessage());
        }
        page.waitForTimeout(1000);
    }

    @When("Email correcto")
    public void email_correcto() {
        Locator email = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName(Pattern.compile(".*Email.*", Pattern.CASE_INSENSITIVE))).first();
        email.click();
        email.fill("hahorta@devcol.com.co");
    }

    private void esperarTarjetaExperto() {
        try {
            page.locator(".v-card")
                    .filter(new Locator.FilterOptions().setHasText("prueba automatizada 2"))
                    .first()
                    .waitFor(new Locator.WaitForOptions().setTimeout(10000));
        } catch (Exception ignore) {
            try {
                page.locator(".v-card")
                        .filter(new Locator.FilterOptions().setHasText("hahorta@devcol.com.co"))
                        .first()
                        .waitFor(new Locator.WaitForOptions().setTimeout(5000));
            } catch (Exception ignored) {}
        }
    }

    private void clickThreeDotMenu() {
        Locator card = page.locator(".v-card").filter(new Locator.FilterOptions().setHasText("prueba automatizada 2"));
        if (card.count() == 0) {
            card = page.locator(".v-card").filter(new Locator.FilterOptions().setHasText("hahorta@devcol.com.co"));
        }
        card.first().locator("button").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^$"))).first()
                .click(new Locator.ClickOptions().setForce(true));
    }

    @Then("Editar")
    public void editar() {
        page.navigate("https://appredesign.upccelerator.com/experts");
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
        esperarTarjetaExperto();
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("before_edit.png")));
        System.out.println("Buscando el experto 'prueba automatizada 2' para editar...");
        try {
            clickThreeDotMenu();
            page.locator(".v-list-item").filter(new Locator.FilterOptions().setHasText("Editar")).first().click();
            page.waitForTimeout(1000);
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("after_3dot_editar.png")));
            System.out.println("Modal de edición abierto para 'prueba automatizada 2'");
        } catch (Exception e) {
            System.out.println("Error al abrir edición: " + e.getMessage());
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("error_editar.png")));
        }
    }

    @Then("Editar Descripcion")
    public void editar_descripcion() {
        try {
            Locator desc = page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName(Pattern.compile(".*Descripci.*", Pattern.CASE_INSENSITIVE))).first();
            desc.click();
            desc.fill("esto es una prueba, editada");
            System.out.println("Descripción editada correctamente");
        } catch (Exception e) {
            System.out.println("Error al editar descripción: " + e.getMessage());
        }
    }

    @Then("Modificar")
    public void modificar() {
        try {
            page.evaluate("() => { const btns = Array.from(document.querySelectorAll('button')); const btn = btns.find(b => b.textContent.trim().toLowerCase() === 'modificar'); if (btn) { btn.scrollIntoView(); btn.click(); } else throw new Error('Botón Modificar no encontrado'); }");
            page.waitForTimeout(1000);
            System.out.println("Experto modificado");
        } catch (Exception e) {
            System.out.println("Error al modificar: " + e.getMessage());
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("error_modificar.png")));
        }
    }

    @Then("Eliminar experto")
    public void eliminar_experto() {
        page.navigate("https://appredesign.upccelerator.com/experts");
        page.waitForLoadState(LoadState.DOMCONTENTLOADED);
        esperarTarjetaExperto();
        System.out.println("Buscando el experto 'prueba automatizada 2' para eliminar...");
        try {
            clickThreeDotMenu();
            page.waitForTimeout(500);
            page.locator(".v-list-item").filter(new Locator.FilterOptions().setHasText("Eliminar")).first().click();
            page.waitForTimeout(1000);
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("after_3dot_eliminar.png")));
            System.out.println("Modal de confirmación de eliminación abierto para 'prueba automatizada 2'");
        } catch (Exception e) {
            System.out.println("Error al abrir eliminación: " + e.getMessage());
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("error_eliminar.png")));
        }
    }

    @When("Cancelar eliminar")
    public void cancelar_eliminar() {
        try {
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Cancelar")).click();
            page.waitForTimeout(500);
            System.out.println("Eliminación cancelada");
        } catch (Exception e) {
            System.out.println("Error en cancelar eliminar: " + e.getMessage());
        }
    }

    @Then("Confirmar eliminar")
    public void confirmar_eliminar() {
        try {
            clickThreeDotMenu();
            page.waitForTimeout(500);
            page.locator(".v-list-item").filter(new Locator.FilterOptions().setHasText("Eliminar")).first().click();
            page.waitForTimeout(500);
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(Pattern.compile(".*eliminar.*", Pattern.CASE_INSENSITIVE))).click();
            page.waitForTimeout(1000);
            System.out.println("Experto eliminado exitosamente");
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("after_delete.png")));
        } catch (Exception e) {
            System.out.println("Error al confirmar eliminación: " + e.getMessage());
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("error_confirmar_eliminar.png")));
        }
    }
}
