# NL

NL is an experimental esoteric programming language that bases its syntax in Dutch rather than English.

## Progress

The language currently supports:

- Print statements, `schrijf` and `schrijfn`
- String literals
- Number literals

## Is there a language design document?

No, this is completely improvised. Extremely dramatic changes to the syntax can and will occur.

## How to build the interpreter

```
./gradlew build
```

## Running example code

```
java -jar build/libs/NL-1.0-SNAPSHOT.jar example/hallo.nl
```

This jar can also be compiled to a native image using Graalvm. This actually makes the performance of the interpreter quite competitive with interpreted languages like python.
