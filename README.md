# ArcMovies
Android project to list upcomming movies, using an api provided by themoviedb.org

* Language - Kotlin
* Architecture - MVP

## third-party libraries

* [RxJava] - Used for composing asynchronous requests.
* [Retrofit] - Http Client.
* [DataBinding] - Goolge library to handle Layout.
* [ConstraintLayout] - Used to make layouts.
* [Dagger] - Dependency Injection Library.
* [Picasso] - Used to download the image provided by RestApi.
* [Mockito] - Library used to mock classes for tests.

#Debts
There are some debts that were not implemented due to time, they are:

* Work out an offline solution, using Room to store some results and load then when offline.
* Cover more classes.
* Instrumented tests with Android Espresso
