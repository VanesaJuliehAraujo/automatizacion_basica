
Feature: Upccelerator


  Scenario: Guardar como borrador

    Given El usuario da clic en el boton Crear Campania
    And Nombre de la campania
    And Asunto de la campania
    When Remitente
    And Lista de contactos
    When Seleccion template
    When Plantilla predisenada
    And Elimina plantilla
    And Agrega platilla
    And Guardar como borrador
    And Eliminar Plantilla
    Then Confirmar
