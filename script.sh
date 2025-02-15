#!/bin/sh

echo "$HOME"
./gradlew version_catalog:build
./gradlew version_catalog:generateCatalogAsToml
./gradlew version_catalog:publishToMavenLocal
cp version_catalog/build/version-catalog/libs.versions.toml "$HOME"/.gradle
cd hayden-bom || exit
./gradlew build
./gradlew publishToMavenLocal
cd ..
cd hayden-bom-plugin/build_hayden_bom || exit
ls
python3 build-docker.py
cd ../..
./gradlew hayden-bom-plugin:build
./gradlew hayden-bom-plugin:publishToMavenLocal

ls /root || true
ls /root/.m2/repository/com/hayden || true