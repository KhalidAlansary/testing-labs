# How to create and run a new project with gradle

- Step 1: Install Gradle: https://gradle.org/install/
- Step 2: Create a new directory for your project and navigate into it:

  ```bash
  mkdir lab-n
  cd lab-n
  ```

- Step 3: Initialize a new Gradle project:

  ```bash
  gradle init --test-framework junit-jupiter --java-version 25
  ```

  > Spam enter to accept defaults.

- Step 4: Write some code 👨🏻‍💻

- Step 5: Run with `./gradlew run`

- Step 6: Test with `./gradlew test`

> Note: For Windows, use `gradlew.bat` instead of `./gradlew`.
