#Autor: Maria Alejandra Rodriguez
@stories
Feature: User login and Recruitment in Orange HRM

  @scenario1
  Scenario: Successful login
    Given the user is on the login page
    And the user logs in with valid credentials
      | userNameField | passwordField |
      | Admin         | admin123      |
    When the user fills in all the required fields in Recruitment
      | firstName | middleName | lastName | vacancy        |email                |contactNumber|keywords|Notes             |
      | Maria     | Alejandra  | Suarez1   | Senior QA Lead |mariasuarez@gmail.com|3202456790   | Prueba |Agregar candidato |
    Then i check the hired status

