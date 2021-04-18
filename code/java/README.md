
# Compile AND Run

Compile **all** .java files and execute main() in the specified class

```
mvn compile exec:java -Dexec.mainClass=howto.App
```

# Run a compiled class

If all the files are already compiled, we can skip `compile` and execute the main class directly.
```
mvn exec:java -Dexec.mainClass=howto.App
```

# Directory Structure

```
$ tree src
src
├── main
│   └── java
│       └── howto
│           ├── App.java
│           └── TroubleMaker.java
└── test
    └── java
        └── howto
            └── AppTest.java


$ tree target/
target/
├── classes
│   └── howto
│       ├── App.class
│       └── TroubleMaker.class
└── test-classes
    └── howto
        └── AppTest.class
```
