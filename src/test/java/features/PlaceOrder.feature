Feature: Place the order
@PlaceOrder
  Scenario Outline: Place the order for product and validate checkout page

    Given User is on green cart landing page
    When User searched product "<Product>" and edit the quantity "<Qty>" and add product to cart
    Then View the cart and click on Proceed to checkout
    And Validate "<Product>", promo apply and place order button on checkout page

    Examples:
    | Product | Qty |
    | Tom | 2 |
    | Pot | 4 |