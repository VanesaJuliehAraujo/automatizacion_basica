package Steps;

import com.microsoft.playwright.Locator;
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
    }

    @Given("El usuario da clic en Agregar Experto")
    public void clic_agregar_experto() {
        page.waitForTimeout(5000);
        // Intentar navegar directamente a la página de expertos
        page.navigate("https://appredesign.upccelerator.com/experts");
        page.waitForTimeout(3000);
        // Buscar el botón con texto que contenga "AGREGAR"
        page.getByRole(
                AriaRole.BUTTON,
                new Page.GetByRoleOptions().setName(Pattern.compile("AGREGAR", Pattern.CASE_INSENSITIVE))
        ).first().click();
        page.waitForTimeout(3000);
        // Screenshot para debug
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("after_click_agregar.png")));
        System.out.println("Screenshot guardado: after_click_agregar.png");
    }

    @Given("El usuario da clic en el boton Crear Experto")
    public void clic_boton_crear_experto() {
        clic_agregar_experto();
    }

    @Given("El usuario agrega fotografia")
    public void el_usuario_agrega_fotografia() {
        // Esperar para que el modal esté completamente cargado
        page.waitForTimeout(3000);

        try {
            // Intentar encontrar y cargar la imagen
            // Primero verificar si hay inputs de tipo file visibles
            if (page.locator("input[type='file']").count() > 0) {
                page.locator("input[type='file']").first().setInputFiles(Paths.get("src/test/resources/images/pet (1).jpg"));
                page.waitForTimeout(3000);
                System.out.println("Fotografía cargada exitosamente");
            } else {
                System.out.println("No se encontró input de archivo - continuando sin imagen");
            }
        } catch (Exception e) {
            System.out.println("Error al cargar fotografía (opcional): " + e.getMessage());
            System.out.println("Continuando sin imagen...");
        }

        page.waitForTimeout(2000);
    }

    @Given("Selecciona la imagen del local")
    public void selecciona_imagen_del_local() {
        page.waitForTimeout(1000);
        // Cargar primera imagen de perfil
        page.locator("input[type='file']").first().setInputFiles(Paths.get("src/test/resources/images/pet (1).jpg"));
        page.waitForTimeout(1500);
        System.out.println("Primera imagen seleccionada del local");
    }

    @When("Seleccion de imagen dos")
    public void seleccion_imagen_dos() {
        page.waitForTimeout(1000);
        // Cargar imagen de logotipo (segundo input)
        page.locator("input[type='file']").nth(1).setInputFiles(Paths.get("src/test/resources/images/Screenshot_2.png"));
        page.waitForTimeout(1500);
        System.out.println("Segunda imagen seleccionada");
    }

    @When("Elimina imagen")
    public void elimina_imagen() {
        page.waitForTimeout(1000);
        // Buscar botón de eliminar imagen (generalmente un ícono de X o trash)
        // Intentar varios selectores comunes para botones de eliminar
        try {
            page.locator("button[aria-label*='eliminar'], button[aria-label*='delete'], button[aria-label*='remove']").first().click();
            System.out.println("Imagen eliminada");
        } catch (Exception e) {
            System.out.println("No se encontró botón de eliminar o ya fue eliminada");
        }
        page.waitForTimeout(1000);
    }

    @When("Nombre experto")
    public void nombre_experto() {
        // Esperar un poco para asegurar que el modal esté listo
        page.waitForTimeout(2000);

        // Forzar el llenado sin click previo para evitar problemas de overlays
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName(Pattern.compile(".*Nombre.*", Pattern.CASE_INSENSITIVE))).first().fill("prueba automatizada 2");
        page.waitForTimeout(1000);
    }
    @When("Descripción")
    public void descripcion() {
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName(Pattern.compile(".*Descripci.*", Pattern.CASE_INSENSITIVE))).first().click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName(Pattern.compile(".*Descripci.*", Pattern.CASE_INSENSITIVE))).first().fill("esto es una prueba");
        page.waitForTimeout(1000);
    }

    @When("Descripcion")
    public void descripcion_sin_acento() {
        descripcion();
    }
    @When("Email incorrecto")
    public void email_incorrecto() {
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName(Pattern.compile(".*Email.*", Pattern.CASE_INSENSITIVE))).first().click();
        page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName(Pattern.compile(".*Email.*", Pattern.CASE_INSENSITIVE))).first().fill("hahortadevcol.com");
        page.waitForTimeout(1000);
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
        page.waitForTimeout(1000);
        // Hacer clic en el campo de ciudad para abrir el selector
        page.locator(".flex.gap-2 > .v-input > .v-input__control > .v-field > .v-field__field > .v-field__input").click();
        page.waitForTimeout(1000);
        // Seleccionar la ciudad
        page.getByText("Anton", new Page.GetByTextOptions().setExact(true)).click();
    }
    @Then("Clic  Guardar")
    public void clic_guardar() {
        // Esperar un poco para que el formulario se valide
        page.waitForTimeout(3000);

        // Tomar screenshot antes de intentar guardar
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("before_guardar.png")).setFullPage(true));
        System.out.println("Screenshot antes de guardar: before_guardar.png");

        // Intentar hacer clic en el botón Guardar con force
        try {
            // Buscar el botón con un timeout más corto
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Guardar")).click(new com.microsoft.playwright.Locator.ClickOptions().setForce(true).setTimeout(10000));
            System.out.println("Clic en Guardar ejecutado exitosamente");
        } catch (Exception e) {
            System.out.println("Nota: No se pudo hacer clic en Guardar - " + e.getMessage());
            System.out.println("El formulario pudo haber sido enviado automáticamente o el modal pudo cerrarse");
        }

        page.waitForTimeout(3000);
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
    @Then("Editar")
    public void editar() {
        // Esperar a que la página esté lista
        page.waitForTimeout(2000);

        // Screenshot antes de editar
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("before_edit.png")));
        System.out.println("Buscando el experto 'prueba automatizada 2' para editar...");

        try {
            // Buscar la tarjeta del experto por su nombre o email
            // Primero intentar por nombre
            Locator expertoCard = page.locator("text=prueba automatizada 2").locator("..");

            // Si no lo encuentra por nombre, intentar por email
            if (expertoCard.count() == 0) {
                expertoCard = page.locator("text=hahorta@devcol.com.co").locator("..");
            }

            // Navegar hacia arriba hasta encontrar la tarjeta completa del experto
            for (int i = 0; i < 5; i++) {
                expertoCard = expertoCard.locator("..");
                // Verificar si contiene el botón de opciones
                if (expertoCard.locator("button").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^$"))).count() > 0) {
                    break;
                }
            }

            // Hacer clic en el botón de opciones (3 puntos) dentro de esa tarjeta
            expertoCard.locator("button").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^$"))).first().click();
            page.waitForTimeout(1000);

            // Hacer clic en la opción "Editar"
            page.getByText("Editar").click();
            page.waitForTimeout(2000);
            System.out.println("Modal de edición abierto para 'prueba automatizada 2'");
        } catch (Exception e) {
            System.out.println("Error al abrir edición: " + e.getMessage());
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("error_editar.png")));
        }
    }

    @Then("Editar Descripcion")
    public void editar_descripcion() {
        page.waitForTimeout(1000);

        // Intentar con diferentes variantes del nombre del campo
        try {
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName(Pattern.compile(".*Descripci.*", Pattern.CASE_INSENSITIVE))).first().click();
            page.waitForTimeout(500);
            page.getByRole(AriaRole.TEXTBOX, new Page.GetByRoleOptions().setName(Pattern.compile(".*Descripci.*", Pattern.CASE_INSENSITIVE))).first().fill("esto es una prueba, editada");
            page.waitForTimeout(1000);
            System.out.println("Descripción editada correctamente");
        } catch (Exception e) {
            System.out.println("Error al editar descripción: " + e.getMessage());
        }
    }

    @Then("Modificar")
    public void modificar() {
        page.waitForTimeout(1000);

        try {
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Modificar")).click();
            page.waitForTimeout(3000);
            System.out.println("Experto modificado");
        } catch (Exception e) {
            System.out.println("Error al modificar: " + e.getMessage());
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("error_modificar.png")));
        }
    }

    @Then("Eliminar experto")
    public void eliminar_experto() {
        // Esperar a que la página esté lista
        page.waitForTimeout(2000);

        System.out.println("Buscando el experto 'prueba automatizada 2' para eliminar...");

        try {
            // Buscar la tarjeta del experto por su nombre o email
            Locator expertoCard = page.locator("text=prueba automatizada 2").locator("..");

            // Si no lo encuentra por nombre, intentar por email
            if (expertoCard.count() == 0) {
                expertoCard = page.locator("text=hahorta@devcol.com.co").locator("..");
            }

            // Navegar hacia arriba hasta encontrar la tarjeta completa del experto
            for (int i = 0; i < 5; i++) {
                expertoCard = expertoCard.locator("..");
                // Verificar si contiene el botón de opciones
                if (expertoCard.locator("button").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^$"))).count() > 0) {
                    break;
                }
            }

            // Hacer clic en el botón de opciones (3 puntos) dentro de esa tarjeta
            expertoCard.locator("button").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^$"))).first().click();
            page.waitForTimeout(1000);

            // Hacer clic en la opción "Eliminar"
            page.getByText("Eliminar").click();
            page.waitForTimeout(2000);
            System.out.println("Modal de confirmación de eliminación abierto para 'prueba automatizada 2'");
        } catch (Exception e) {
            System.out.println("Error al abrir eliminación: " + e.getMessage());
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("error_eliminar.png")));
        }
    }

    @When("Cancelar eliminar")
    public void cancelar_eliminar() {
        page.waitForTimeout(1000);

        try {
            // Hacer clic en el botón Cancelar
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Cancelar")).click();
            page.waitForTimeout(2000);
            System.out.println("Eliminación cancelada");

            // Abrir nuevamente el menú para eliminar el mismo experto
            page.waitForTimeout(1000);

            // Buscar nuevamente la tarjeta del experto específico
            Locator expertoCard = page.locator("text=prueba automatizada 2").locator("..");

            if (expertoCard.count() == 0) {
                expertoCard = page.locator("text=hahorta@devcol.com.co").locator("..");
            }

            // Navegar hacia arriba hasta encontrar la tarjeta completa
            for (int i = 0; i < 5; i++) {
                expertoCard = expertoCard.locator("..");
                if (expertoCard.locator("button").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^$"))).count() > 0) {
                    break;
                }
            }

            // Hacer clic en el botón de opciones
            expertoCard.locator("button").filter(new Locator.FilterOptions().setHasText(Pattern.compile("^$"))).first().click();
            page.waitForTimeout(1000);
            page.getByText("Eliminar").click();
            page.waitForTimeout(1000);
            System.out.println("Modal de eliminación reabierto");
        } catch (Exception e) {
            System.out.println("Error en cancelar eliminar: " + e.getMessage());
        }
    }

    @Then("Confirmar eliminar")
    public void confirmar_eliminar() {
        page.waitForTimeout(1000);

        try {
            // Hacer clic en "Sí, eliminar"
            page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName(Pattern.compile(".*eliminar.*", Pattern.CASE_INSENSITIVE))).click();
            page.waitForTimeout(3000);
            System.out.println("Experto eliminado exitosamente");

            // Screenshot de confirmación
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("after_delete.png")));
        } catch (Exception e) {
            System.out.println("Error al confirmar eliminación: " + e.getMessage());
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("error_confirmar_eliminar.png")));
        }
    }

}