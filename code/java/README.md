
# Compile AND Run

Compile a .java file into a .class file and run the .class file

```
mvn compile exec:java -Dexec.mainClass=howto.App
```

# Run a compiled class

If the file has already been compiled, we can skip compile and simply run the .class file
```
mvn exec:java -Dexec.mainClass=howto.App
```

# What are the files stored?

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
