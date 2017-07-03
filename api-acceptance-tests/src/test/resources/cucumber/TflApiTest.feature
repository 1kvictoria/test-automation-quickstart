@api-demo
Feature: Demonstrate the API acceptance testing framework


   Scenario: Line without disruptions
     Given a line without disruptions
     When i retrieve a disruption
     Then I should get a '200' response from the service
     And I should be not shown any disruptions

