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
      | "1" | "0" | "1" | "false" | 2 |
      | "1" | "0" | "3" | "false" | 6 |
      | "1" | "0" | "1" | "true" | 75 |
      | "1" | "0" | "0.5" | "false" | 0 |
      | "1" | "0" | "8" | "false" | 15 |
      | "1" | "0" | "25" | "false" | 17 |

