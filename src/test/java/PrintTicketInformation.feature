Feature: Print Ticket Information
    Scenario Outline: Receipt File Generated each time Ticket is processed
    Given A ticket
    And CarID is <carId>
    And TimeIn is <timeIn>
    And TimeOut is <timeOut>
    And TicketLost is <ticketLost>
    When Ticket is processed
    Then receipt generated
    And receipt has carId <carId>
    And receipt has totalTimeParked <totalTimeParked>
    And receipt has ticketLost <ticketLost>
    And receipt has feeCollected <feeCollected>

   Examples:
      | carId | timeIn | timeOut | ticketLost | totalTimeParked | feeCollected |
      | "1" | "0" | "0.5" | "false" | 0.5 | 2 |
