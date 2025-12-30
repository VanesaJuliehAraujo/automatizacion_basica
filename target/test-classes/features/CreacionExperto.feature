
Feature: Upccelerator

  @Smoke
  @test
  Scenario: Creación de experto

    Given El usuario accede al sistema de upccelerator
    And Correo correcto
    And El usuario da clic en el boton Craer Experto
    And El usuario agrega fotografia
    And Selecciona la imagen del local
    When Seleccion de imagen dos
    And Elimina imagen
    When Nombre experto
    When Descripción
    And Email incorrecto
    And Email correcto
    When Selecciona extension
    When Telefono
    And Pais
    And Ciudad
    Then Clic  Guardar
