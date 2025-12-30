package Steps;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.nio.file.Paths;
import java.util.regex.Pattern;

import static driverSetup.driver.page;

public class InicioSesionValidaciones {
    @Given("El usuario accede al sistema de upccelerator")
    public void el_usuario_accede_al_sistema_de_upccelerator() {
            page.navigate("https://appredesign.upccelerator.com/login");
        System.out.println(page.title());
    }
    @Given("Correo incorrecto")
    public void correo_incorrecto() {
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Correo electrónico Correo")).click();page.waitForTimeout(3000);
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Correo electrónico Correo")).fill("vanesagmail.com");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Enviar código de ingreso")).click();
        System.out.println("correo incorrecto");
    }
    @When("Correo NO registrado en la base de datos")
    public void correo_no_registrado_en_la_base_de_datos() {
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Correo electrónico Correo")).click();page.waitForTimeout(3000);
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Correo electrónico Correo")).fill("varaujo@devcol.co");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Enviar código de ingreso")).click();
        System.out.println("correo no registrado");
    }
    @When("Correo registrado en la base de datos y clic en enviar codigo de ingreso")
    public void correo_registrado_en_la_base_de_datos_y_clic_en_enviar_codigo_de_ingreso() {
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Correo electrónico Correo")).click(); page.waitForTimeout(3000);
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Correo electrónico Correo")).fill("varaujo@devcol.com.co");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Enviar código de ingreso")).click();
        System.out.println("correo registrado con codigo incorrecto");
    }
    @When("Codigo con letras")
    public void codigo_con_letras() {
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Código de Acceso")).first().click(); page.waitForTimeout(3000);
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Código de Acceso")).first().fill("4");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Código de Acceso")).nth(1).fill("1");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Código de Acceso")).nth(2).fill("5");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Código de Acceso")).nth(3).fill("a");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Código de Acceso")).nth(4).fill("s");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Código de Acceso")).nth(5).fill("1");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ingresar")).click();
        System.out.println("código con letras");
    }
    @When("Codigo incorrecto")
    public void codigo_incorrecto() {
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Código de Acceso")).first().fill("5");page.waitForTimeout(4000);
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Código de Acceso")).nth(1).fill("4");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Código de Acceso")).nth(2).fill("6");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Código de Acceso")).nth(3).fill("6");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Código de Acceso")).nth(4).fill("6");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Código de Acceso")).nth(5).fill("5");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ingresar")).click();
        System.out.println("codio incorrecto");
    }
    @When("Reenviar codigo")
    public void reenviar_codigo() {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("reenviar")).click(); page.waitForTimeout(3000);
        System.out.println("Reenviar código");
    }
    @Then("Codigo correcto")
    public void codigo_correcto() {

        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Código de Acceso")).first().fill("1");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Código de Acceso")).nth(1).fill("2");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Código de Acceso")).nth(2).fill("3");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Código de Acceso")).nth(3).fill("4");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Código de Acceso")).nth(4).fill("5");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Código de Acceso")).nth(5).fill("6");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Código de Acceso")).nth(5).press("Enter");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Ingresar")).first().click();

          //System.out.print("hasta aqui llegó");
    }

    @Given("El usuario da clic en Agregar Experto")
    public void clic_agregar_experto() {
        page.getByRole(
                AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName(Pattern.compile("Agregar"))
        ).click();


    }

    @Given("El usuario agrega fotografia")
    public void el_usuario_agrega_fotografia() {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Seleccionar archivos")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Seleccionar archivos")).setInputFiles(Paths.get("pet (1).jpg"));
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Eliminar archivo")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Seleccionar archivos")).click();
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Seleccionar archivos")).setInputFiles(Paths.get("pet (1).jpg"));
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Seleccionar archivo")).click();
        page.locator("form").click();

    }

    @When("Nombre experto")
    public void nombre_experto() {
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Nombre Nombre")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Nombre Nombre")).fill("prueba automatizada 2");

    }
    @When("Descripción")
    public void descripcion() {
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Descripción Descripcion")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Descripción Descripcion")).fill("esto es una prueba");

    }
    @When("Email incorrecto")
    public void email_incorrecto() {
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email Email")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email Email")).fill("hahortadevcol.com");
    }

    @When("Selecciona extension")
    public void selecciona_extension() {
        page.locator(".v-field.v-field--appended > .v-field__field > .v-field__input").first().click();
        page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("+31")).click();
    }
    @When("Telefono")
    public void telefono() {
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Teléfono Teléfono")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Teléfono Teléfono")).fill("(302) 446 - 9077");
    }
    @When("Pais")
    public void pais() {
        page.locator("div:nth-child(5) > div > .v-input__control > .v-field > .v-field__append-inner").click();
        page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Bulgaria")).click();
    }
    @When("Ciudad")
    public void ciudad() {
        page.getByRole(AriaRole.OPTION, new Page.GetByRoleOptions().setName("Bulgaria")).click();
        page.locator(".flex.gap-2 > .v-input > .v-input__control > .v-field > .v-field__field > .v-field__input").click();
        page.getByText("Anton", new Page.GetByTextOptions().setExact(true)).click();
    }
    @Then("Clic  Guardar")
    public void clic_guardar() {
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Guardar")).click();
    }
    @When("Email correcto")
    public void email_correcto() {
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email Email")).dblclick();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email Email")).press("ArrowLeft");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email Email")).press("ArrowLeft");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email Email")).press("ArrowLeft");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email Email")).fill("hahorta@devcol.com");
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email Email")).click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName("Email Email")).fill("hahorta@devcol.com.co");
        page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Guardar")).click();
    }

}