#!/bin/bash

./gradlew build
native-image -jar ./build/libs/NL-1.0-SNAPSHOT.jar
