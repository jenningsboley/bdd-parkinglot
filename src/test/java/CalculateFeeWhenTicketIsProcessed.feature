Feature: Calculate Fee When Ticket is Processed
  Scenario Outline: Ticket is processed, gets fee due
    Given A ticket
    And CarID is <carId>
    And TimeIn is <timeIn>
    And TimeOut is <timeOut>
    And TicketLost is <ticketLost>
    When Ticket is processed
    Then fee is calculated to be <fee>

    Examples:
      | carId | timeIn | timeOut | ticketLost | fee |
      | "1" | "0" | "0.5" | "false" | 2 |
      | "1" | "1" | "4" | "false" | 6 |
      | "1" | "0" | "1" | "true" | 75 |
      | "1" | "0" | "0.49" | "false" | 0 |
      | "1" | "0" | "7.5" | "false" | 15 |
      | "1" | "0" | "24.5" | "false" | 17 |
      | "1" | "0" | "144.5" | "false" | 90 |
      | "1" | "0" | "192" | "false" | 105 |
      | "1" | "0" | "336" | "false" | 180 |
      | "1" | "0" | "720" | "false" | 390 |
