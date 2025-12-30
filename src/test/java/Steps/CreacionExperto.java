/* package Steps;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.nio.file.Paths;

import static driverSetup.driver.page;

public class CreacionExperto {

    @Given("El usuario da clic en el boton Craer Experto")
    public void el_usuario_da_clic_en_el_boton_craer_experto() {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Agregar experto")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Nombre Nombre")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Nombre Nombre")).press("CapsLock");
    }
    @Given("El usuario agrega fotografia")
    public void el_usuario_agrega_fotografia() {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Haz clic para seleccionar una")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Seleccionar archivos")).click();

    }
    @Given("Selecciona la imagen del local")
    public void selecciona_la_imagen_del_local() {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Seleccionar archivos")).setInputFiles(Paths.get("PXL_20251122_225754479.MP.jpg"));
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Seleccionar archivo")).click();
    }

    @When("Seleccion de imagen dos")
    public void seleccion_de_imagen_dos() {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Seleccionar archivos")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Seleccionar archivos")).setInputFiles(Paths.get("PXL_20251122_225754479.MP.jpg"));

    }
    @When("Elimina imagen")
    public void elimina_imagen() {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Eliminar archivo")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Seleccionar archivos")).click();
    }
    @When("Nombre experto")
    public void nombre_experto() {
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Nombre Nombre")).press("CapsLock");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Nombre Nombre")).fill("Esto es una prueba automatizada");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Descripción Descripción")).click();

    }
    @When("Descripción")
    public void descripción() {
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Descripción Descripción")).press("Dead");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Descripción Descripción")).fill("prueba automatización");

    }
    @When("Email incorrecto")
    public void email_incorrecto() {
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email Email")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email Email")).fill("hhortadevcol.com.co");
    }
    @When("Email correcto")
    public void email_correcto() {
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email Email")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email Email")).dblclick();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email Email")).fill("hhorta@devcol.com.co");
    }
    @When("Selecciona extension")
    public void selecciona_extension() {
        page.getByRole(AriaRole.COMBOBOX).filter(new Locator.FilterOptions().setHasText("Extensión+30Extensión")).getByLabel("Open").click();
        page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Extensión Extensión")).click();
        page.getByText("+65").click();
    }
    @When("Telefono")
    public void telefono() {
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Teléfono Teléfono")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Teléfono Teléfono")).fill("(302) 446 - 9076");
    }
    @When("Pais")
    public void pais() {
        page.getByRole(AriaRole.COMBOBOX).filter(new Locator.FilterOptions().setHasText("PaísMacauPaís")).getByLabel("Open").click();
        page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Malta")).click();
    }
    @When("Ciudad")
    public void ciudad() {
        page.getByRole(AriaRole.COMBOBOX, new Page.GetByRoleOptions().setName("Ciudad Ciudad")).click();
        page.getByText("Birkirkara").click();
    }
    @Then("Clic  Guardar")
    public void clic_guardar() {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Guardar")).click();
    }

}


 */
