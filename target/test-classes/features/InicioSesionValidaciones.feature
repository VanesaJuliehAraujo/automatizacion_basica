
#autor_Vanesa Araujo
Feature: Upccelerator

  @Smoke
  @test
  Scenario: Validaciones de Inicio de sesion
    Given El usuario accede al sistema de upccelerator
    And Correo incorrecto
    When Correo NO registrado en la base de datos
    When Correo registrado en la base de datos y clic en enviar codigo de ingreso
    And Codigo incorrecto
    And Reenviar codigo
    Then Codigo correcto
    And El usuario da clic en Agregar Experto
    And El usuario agrega fotografia
    When Nombre experto
    When Descripción
    And Email incorrecto
    When Selecciona extension
    When Telefono
    And Pais
    And Ciudad
    And Email correcto
    Then Clic  Guardar