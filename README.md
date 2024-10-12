Webtoon Info App
Overview

This project is an Android application developed in Kotlin, inspired by webtoon content. The app demonstrates the ability to implement navigation, manage data storage using Room Database, and create a user-friendly interface with interactive features like adding webtoons to favorites and rating them.

This app was built as part of an internship assignment for Animemangatoon.com.
Features

The Webtoon Info App includes the following key features:

    Home Screen:
        Displays a list of webtoon titles inspired by The Manhua.
        Each title includes an image and a brief description.

    Detail Screen:
        When a webtoon title is clicked, the app navigates to a detail screen showing more information about the webtoon, using Vagabond as an example.
        The screen includes a larger image, a detailed description, and a button to Add to Favorites.

    Favorites Screen:
        Users can view their saved favorite webtoons.
        Favorites are stored locally using Room Database, ensuring data persists when the app is closed and reopened.

    Interactive Feature:
        Users can rate a webtoon (1-5 stars).
        The average rating is dynamically displayed on the detail screen.
        In the Webtoon Info App, I have implemented an efficient data management strategy utilizing the Room Database for local storage. To enhance user experience, I employed an onDismiss callback mechanism to facilitate the removal of webtoons from the favorites list.

This feature allows users to easily dismiss webtoons from their favorites by swiping left or right, triggering the onDismiss action. Upon dismissal, the selected webtoon is promptly deleted from the Room Database, ensuring that the changes are immediately reflected in the user interface. This approach not only streamlines the process of managing favorites but also maintains data integrity and responsiveness within the application.

        Tech Stack

    Kotlin: Primary programming language used for app development.
    Android Studio: Development environment for building and testing the app.
    Room Database: Used for storing and retrieving favorite webtoons locally.
    Jetpack Compose: Used for building the UI components in a declarative way.
    Coil: Image loading library for handling webtoon images.
    Navigation: For handling screen navigation between the Home, Detail, and Favorites screens.
