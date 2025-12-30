
Feature: Upccelerator

  @Ignore
  Scenario: Creación de experto

    Given El usuario da clic en el boton Crear Experto
    And El usuario agrega fotografia
    And Selecciona la imagen del local
    When Seleccion de imagen dos
    And Elimina imagen
    When Nombre experto
    When Descripcion
    And Email incorrecto
    And Email correcto
    When Selecciona extension
    When Telefono
    And Pais
    And Ciudad
    Then Clic  Guardar
