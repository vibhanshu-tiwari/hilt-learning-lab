# Hilt Learning Lab

A hands-on Android project for learning **Dependency Injection with
Dagger Hilt** by building a small application with **Kotlin, Jetpack
Compose, and MVVM architecture**.

The focus of this project is not just learning Hilt annotations. It is
understanding how dependencies are created, how abstractions are
connected to implementations, how Hilt resolves a dependency graph, and
how component lifetimes and scopes affect object reuse.

## Project Overview

The sample application displays a simple Product Catalog. Product data
is supplied by a local data source through a repository abstraction.

Alongside the catalog, the project includes focused examples that
demonstrate:

-   Constructor injection
-   Field injection into an Android entry point
-   Interface-to-implementation bindings with `@Binds`
-   Custom dependency creation with `@Provides`
-   Qualifiers for selecting between multiple implementations
-   Hilt component installation and scopes
-   Dependency resolution across application layers

The application is intentionally small so the examples remain easy to
follow. It is a learning project, not a production-ready commerce
application.

## Hilt Concepts Covered

  ---------------------------------------------------------------------
  Concept                            Where it is demonstrated
  ---------------------------------- ----------------------------------
  Hilt initialization                `MyApplication.kt` with
                                     `@HiltAndroidApp`

  Android entry point                `MainActivity.kt` with
                                     `@AndroidEntryPoint`

  Constructor injection              Services, repositories, data
                                     sources, and `HomeViewModel`

  `@Binds`                           `DataSourceModule`,
                                     `RepositoryModule`, and
                                     `LoggerModule`

  `@Provides`                        `PreferenceModule` provides
                                     `SharedPreferences`

  Qualifiers                         `ConsoleLoggerQualifier` and
                                     `FileLoggerQualifier` distinguish
                                     `Logger` bindings

  Components and scopes              Modules installed in
                                     `SingletonComponent`; singleton
                                     bindings for the product
                                     repository and data source

  ViewModel integration              `@HiltViewModel` and
                                     `hiltViewModel()`
  ---------------------------------------------------------------------

## Tech Stack

-   Kotlin
-   Android SDK
-   Dagger Hilt
-   KSP for Hilt code generation
-   Jetpack Compose and Material 3
-   AndroidX Navigation Compose
-   AndroidX Lifecycle and `StateFlow`
-   Gradle Kotlin DSL
-   Gradle Version Catalog

## How the Dependency Graph Fits Together

The Product Catalog uses a repository abstraction between the
presentation and data layers:

``` text
AppNavigation
    |
    | obtains HomeViewModel and collects its StateFlow
    v
HomeViewModel
    |
    v
ProductRepository (interface)
    |
    |  @Binds
    v
ProductRepositoryImpl
    |
    v
ProductDataSource (interface)
    |
    |  @Binds
    v
LocalProductDataSource
    |
    v
Sample product list
```

`HomeViewModel` depends on `ProductRepository`, not on
`ProductRepositoryImpl` or the concrete data source. Hilt uses the
bindings declared in the modules to resolve the required
implementations.

The modules are installed in `SingletonComponent`. The product
repository and product data source bindings are scoped with
`@Singleton`.

The logger example demonstrates why qualifiers are needed when more than
one implementation is available for the same interface:

-   `@ConsoleLoggerQualifier` selects `ConsoleLogger`.
-   `@FileLoggerQualifier` selects `FileLogger`.

`PreferenceModule` demonstrates `@Provides` by creating an
application-level `SharedPreferences` instance using
`@ApplicationContext`.

## Application Architecture

The project uses a deliberately simple MVVM arrangement:

-   **Presentation:** `HomeScreen`, `HomeUiState`, `HomeViewModel`, and
    `AppNavigation`
-   **Repository abstraction:** `ProductRepository`
-   **Data:** `ProductRepositoryImpl`, `ProductDataSource`, and
    `LocalProductDataSource`
-   **Dependency injection:** Hilt modules in the `di` package

The UI collects the ViewModel's `StateFlow` with lifecycle-aware
collection and receives the resulting `HomeUiState`.

The current product source is local sample data. The project does not
currently implement a remote API, database persistence, product-detail
navigation, or a working refresh action.

## Project Structure

The main source layout is:

``` text
com.vibh.hiltlearninglab/
├── core/
│   ├── logger/
│   │   ├── ConsoleLogger.kt
│   │   ├── FileLogger.kt
│   │   └── Logger.kt
│   ├── qualifier/
│   │   ├── ConsoleLoggerQualifier.kt
│   │   └── FileLoggerQualifier.kt
│   ├── repository/
│   │   └── UserRepository.kt
│   └── GreetingService.kt
├── data/
│   ├── model/
│   │   └── Product.kt
│   ├── repository/
│   │   ├── ProductRepository.kt
│   │   └── ProductRepositoryImpl.kt
│   └── source/
│       ├── ProductDataSource.kt
│       └── LocalProductDataSource.kt
├── di/
│   ├── DataSourceModule.kt
│   ├── LoggerModule.kt
│   ├── PreferenceModule.kt
│   └── RepositoryModule.kt
├── ui/
│   ├── home/
│   │   ├── component/
│   │   │   ├── HomeTopBar.kt
│   │   │   └── ProductCard.kt
│   │   ├── HomeScreen.kt
│   │   ├── HomeUiState.kt
│   │   └── HomeViewModel.kt
│   ├── navigation/
│   │   ├── AppDestination.kt
│   │   └── AppNavigation.kt
│   └── theme/
│       ├── Color.kt
│       ├── Theme.kt
│       └── Type.kt
├── MainActivity.kt
└── MyApplication.kt
```

## Getting Started

### Prerequisites

-   Android Studio
-   Android SDK required by the project
-   JDK 21 for the configured Gradle daemon JVM

### Clone the repository

``` bash
git clone https://github.com/vibhanshu-tiwari/hilt-learning-lab.git
```

### Open and run

1.  Open the cloned project in Android Studio.
2.  Allow Gradle sync to complete.
3.  Run the `app` configuration on an emulator or Android device.

You can also build the debug APK from the project root:

``` bash
./gradlew assembleDebug
```

On Windows PowerShell:

``` powershell
.\gradlew.bat assembleDebug
```

## Learning Journey

This repository accompanies a structured Hilt learning journey. The
concepts were explored incrementally: first understanding the
dependency-injection problem, then learning how Hilt constructs objects,
connects abstractions to implementations, and manages dependencies
through components and scopes.

The intention is to keep the examples small and explain the reasoning
behind each Hilt feature---not simply list annotations.

## Author

**Vibhanshu Tiwari**

-   GitHub: [@vibhanshu-tiwari](https://github.com/vibhanshu-tiwari)

------------------------------------------------------------------------

If you are learning Hilt, feel free to explore the source code and use
the project as a reference while experimenting with dependency injection
in your own Android applications.
