#!/usr/bin/env bash
./gradlew \
androidx:skin-core:bintrayUpload --stacktrace \
androidx:skin-appcompat:bintrayUpload --stacktrace \
androidx:skin-design:bintrayUpload --stacktrace \
androidx:skin-cardview:bintrayUpload --stacktrace \
androidx:skin-constraint-layout:bintrayUpload --stacktrace
