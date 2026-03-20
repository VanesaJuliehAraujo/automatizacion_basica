
Feature: Upccelerator

  Scenario: Programar envio email

      Given El usuario da clic en el boton Crear Campania
      And Nombre de la campania
      And Asunto de la campania
      When Remitente
      And Lista de contactos
      When Seleccion template
      When Plantilla predisenada
      And Agrega correos de prueba
      When Enviar prueba
      And Selecciona fecha
      And Selecciona hora
      And Programar
      Then Elimina plantilla


