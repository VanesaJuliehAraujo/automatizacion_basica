
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