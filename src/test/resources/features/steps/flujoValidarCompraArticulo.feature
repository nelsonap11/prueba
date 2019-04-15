@compra
Feature: se realiza la validacion de la compra con garantia extendida

  @validar_orden_compra
  Scenario Outline: validar compra
    Given Ingreso la url de google<CasoPrueba>
    When busco la palabra falabella<buscar>
    And selecciono el texto correspondiente<texto>
    And ingresar producto<producto>
    And seleccionar producto
    And agregar producto al carro
    And ingresar a la bolsa de compras
    And aumento cantidad de productos<cantidad>
    And agregar garantia extendida
    And seleccionar boton ir a compra
    Then verifico que muestre la seccion ir a comprar
    
    @P1
    Examples: Compra
      | CasoPrueba | buscar      | texto                                 | producto   | cantidad |
      | "P1-1"     | "falabella" | "Falabella.com - Mejor Compra Online" | "ps4"     | "2"      |