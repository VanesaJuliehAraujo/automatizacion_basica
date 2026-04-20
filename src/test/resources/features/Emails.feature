
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

  @Smoke
  Scenario: Programar envio email
    Given El usuario da clic en el boton Crear Campania
    When Elimina plantilla
    And Nombre de la campania "Automatiz. Programar envio"
    And Asunto de la campania "Prueba programar envio"
    When Remitente
    And Lista de contactos
    When Seleccion template "Plantilla 2"
    When Plantilla predisenada "Plantilla 2"
    And Agrega correos de prueba
    When Enviar prueba
    And Selecciona fecha
    And Selecciona hora
    Then Programar

  @Smoke
  Scenario: Guardar como borrador
    Given El usuario da clic en el boton Crear Campania
    And Nombre de la campania "Borrador"
    And Asunto de la campania "prueba borrador"
    When Remitente
    And Lista de contactos
    When Seleccion template "Plantilla 3"
    When Plantilla predisenada "Plantilla 3"
    And Correos de prueba
    When Guardar como borrador
    When Editar Plantilla
    Then Eliminar plantilla
