
Feature: Upccelerator

  @Smoke
  Scenario: Email enviar ahora
    Given El usuario da clic en el boton Crear Campania
    And Nombre de la campania "email Automatizado"
    And Asunto de la campania "prueba automat"
    When Remitente
    And Lista de contactos
    When Seleccion template "Plantilla 1"
    When Plantilla predisenada "Plantilla 1"
    And Enviar ahora
    Then Elimina plantilla
