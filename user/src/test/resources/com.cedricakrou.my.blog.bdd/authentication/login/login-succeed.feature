Feature: User login Succeed

  User login is used to connect the users to the application.
  It's successful when user account and user password are corrects.

  Background:
    Given the following users exists:
      | firstname | lastname | email                 | username    | password  |
      | cedric    | akrou    | cedricakrou@gmail.com | cedricakrou | Open1234# |
      | likpech   | akrou    | likpech@gmail.com     | likpech     | Open1234# |
      | belmondok | akrou    | belmondok@gmail.com   | belmondok   | Open1234# |


  Scenario Outline: Login Successfully
    When I enter "<username>" and password "<password>"
    Then I "<username>" will be logged in.

    Examples:
      | username    | password  |
      | cedricakrou | Open1234# |
      | likpech     | Open1234# |
      | belmondok   | Open1234# |



