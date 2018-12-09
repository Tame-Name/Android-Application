# Picky Eater

A user-friendly Android application that gathers recipes from the web based off of user specified criteria.

The application first authenticates the user through a Google Firebase based email authentication UI and checks the cloud database to verify the user has entered a valid and password. If the has not created a valid account, then they are sent to the account creation activity where we collect some basic user demographic information and initiate the create of a new account. 
Once the account creation is successful, the user is sent to the main activity of the application where they can utilize the application to search the internet for a meal based upon specific ingredients and dietary restrictions. We implemented the “Yummy” API and JSON parser to scrape the web for food recipes that match similar criteria to the users input data. This API returns the parsed JSON data to our backend and we output the cleaned data to the user on a “meal page.” This page collects the meals that the user has recently searched for and displays the meals in a menu format so the user can later retrieve previous queries. 

## Repository Organization / Structure
The application is included in this repository. Test cases can be found as classes within the  following folder:
      https://github.com/Tame-Name/Android-Application/tree/master/app/src/androidTest/java/de/andreasschrade/androidtemplate/ui/base
      
Milestone deliverables: https://github.com/Tame-Name/Milestones
       
Meeting Notes: https://github.com/Tame-Name/Meeting-Notes

## Building App
The application must be built in Android Studio. To run, build the app build.gradle file, and then run the code in an adb emulator running Android 8.0.0 or higher. 

To run tests, navigate to the individual test files within the androidTest folder, right click each file, and click run. 

## Dependencies

The focus of this project lies on the view layer and app navigation. It uses the following dependencies:

- Firebase core-support
- Firebase email authentication
- Firebase cloud database
- AppCompat Support Library
- Support Design Library
- Support Card View Library
- Butterknife
- Glide 
-Espresso

## Supported devices

The template supports every device with a SDK level of at least 14 (Android 4+).
