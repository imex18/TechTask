TechTask
=========================

An application which illustrates a simplified MVVM architecture for executing a network call and showing
the list of content inside a `LazyColumn`, and saving temporarily a list of favourites.
For implementing the MVVM architecture I used JetPack and recommended best practices.


Libraries Used
--------------
* [Architecture] - A collection of libraries that help you design robust, testable, and
  maintainable apps. 
    * [StateFlow] - Build data objects that notify views when the underlying state changes.
    * [ViewModel] - Store UI-related data that isn't destroyed on app rotations. Easily schedule
      asynchronous tasks for optimal execution.
    * [Navigation Components] for navigation between the two tabs.
    * [Coroutines] for multithreading.
* [UI] - Jetpack Compose - implements a simpler and more robust UI.

* Third party
    * [Retrofit] - for network requests.
    * [Gson] for - serialisation/deserialization.
    * [Dagger-Hilt] - for dependency injection.
  

Areas to grow
-----------------
As mentioned this is a simple implementation of MVVM and the following can be improved.

   * Architecture - Implemenent and additional abstraction layer by adding UseCases, also add elements of Redux for State Management which will lead to a even more granular code base.
   * State - Unify the screen state in a single UiScreenStateClass. This will save the trouble to listen to multiple StateFlow object in the ViewModel.
   * Persistence - At the moment the favourites are saved in a list that is not persistent. To solve this, we either can save locally the list of ids for favourite items 
                 and fetch them from the API, or save the list of albums in a local data base (won't be a big trouble for this particular project but would be quite heavy for bigger projects).
   * UI - Add animation when an item is removed from favourites. Generally , the UI is simple and could use a bit more love :) .
   * Tests - I tried to add instrumentation tests but ran into some gradle issues and due to lack of time I did not get them working.
   * Tech Features - I would also add here Pagination as at the moment it fetches all albums at once, also check internet connection before fetching the albums. 
                 
