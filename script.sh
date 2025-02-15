#!/bin/sh

echo "$HOME"
./gradlew version_catalog:generateCatalogAsToml
cp version_catalog/build/version-catalog/libs.versions.toml "$HOME"/.gradle
cd hayden-bom || exit
./gradlew build
cd ..
cd hayden-bom-plugin/build_hayden_bom || exit
ls
python3 build-docker.py
cd ../..
./gradlew hayden-bom-plugin:build
./gradlew hayden-bom-plugin:publishToMavenLocal

sleep 999999999
ls /home/ubuntu || true
ls /home/ubuntu/.m2/com/hayden || true