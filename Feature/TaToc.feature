
Feature: Complete Basic Course
 Scenario: Check is user is on TaToc home page
 Given User is on Browser
 When User navigate to tatoc link
 Then User is on Home Page
 
 
 Scenario: User is able to click on Basic Course

 When User is able to see Basic course Link
 And User Click on Basic Course Link
 Then User is on Grid Gate Page
 
 Scenario: user is Successfully Enter to Frame Dungeon page
Given user on Grid Gate Page
 When User navigate to the Green Box
 And Click on Green Box
 Then user will enter to Frame Dungeon page
 
 Scenario: user is Successfully Enter to Drag Around page
 Given User on Frame Dungeon page
 When user can See two colored Boxes 
 And if Color of Both not Equal click Repaint-Box2
 And If color equal click proceed
 Then User enter onDrag Arround Page
 
 Scenario: User succesfully drage Drag me to Drop Box and enter to pop up Window Page
 Given User on Drag Arround Page
 When User Drag Drag me to Drop Box
 And Click on Proceed
 Then User will enter to pop up Window Page
 
 Scenario: User is Successfully able to handle popup window
 Given User on pop up Window Page
 When User click on Launch popup window 
 And Enter its name on text box 
 And Click submit 
 And on parent window click proceed 
 Then User will enter on CookieHandling Page
 
 Scenario: User is Successfully able to Genrate Cookie and Finish the Task
 Given user on CookieHandling Page
 When User Click on Genrate cookie 
 And User can See Token value
 And Copy value of cookie 
 And Create cookie on this page
 And Click Proceed 
 Then User will enter to Home Page 
 And See Sucessfull message