Feature: Search and place the order for Products
@SearchProduct
  Scenario Outline: Search experience for product search in both home and offers page

    Given User is on green cart landing page
    When User searched with Shortname "<Name>" and extracted actual name of the product
    Then User searched with same shortname "<Name>" in offers page
    And Validate product exist

    Examples:
    |Name |
    |Tom |
    |Pot |