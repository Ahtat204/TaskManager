![Status](https://img.shields.io/badge/status-in_development-blue?style=for-the-badge)

### Data Flow:
1. **UI Layer** (Compose screens: Home, Calendar, Dashboard, CreateTask)
    - Displays tasks and handles user interactions.
    - Communicates with the ViewModel.

2. **ViewModel** (`TaskViewModel`)
    - Holds LiveData for tasks.
    - Calls Repository methods to perform database operations.
    - Ensures operations run on background threads with `viewModelScope`.

3. **Repository** (`TaskService`)
    - Abstracts data access.
    - Provides CRUD operations and search functionality.
    - Communicates with DAO.

4. **DAO** (`DAO`)
    - Defines SQL queries and database operations.
    - Returns `Flow<List<Task>>` for reactive updates.

5. **Database** (`TaskDataBase`)
    - Room database that stores `Task` entities.
    - Provides DAO instance.

6. **Dependency Injection**
    - Hilt modules (`TaskDatabaseModule`) provide singleton instances of Database and DAO.
    - `@HiltAndroidApp` annotated `App` class enables DI throughout the app.


<img src
