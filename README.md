# National ID Processor
This is a module for processing a national ID number.  
### Constraints:
- First digit represents persons sex (3 or 5 - male, 4 or 6 - female, other digits are not allowed)
  - There are rare exceptions where national ID contains six zeros instead of birthdate.
- Next six digits represent the birth date (in yymmdd format)
- Next three digits are random
- The last one is a control digit
  - If the national ID is represented as ABCDEFGHIJK - K is a control digit. It is calculated this
  way:
    - S = A*1 + B*2 + C*3 + D*4 + E*5 + F*6 + G*7 + H*8 + I*9 + J*1
    - Sum S is divided by 11.
    - If the remainder is less than 10, then it is a control digit K.
    - If the remainder is 10, then new sum must be calculated:
      - S = A*3 + B*4 + C*5 + D*6 + E*7 + F*8 + G*9 + H*1 + I*2 + J*3
      - New sum S is again divided by 11.
        - If the remainder is less than 10, then it is a control digit K.
        - If the remainder is 10, then the control digit is 0.
## Design
The validators are created using the composite design pattern.  This allows constraints to be maintained in case of change over time, and also testability of each constraint individually.

## Testing
Unit tests are done with JUnit, testing for pass and fail states of constraints

## Installation
To install this package, run `mvn install:install` to add it to your local repository