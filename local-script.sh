#!/bin/sh

if [[ ! -e dgs-codegen-version-update ]]; then
  git clone git@github.com:haydenrear/dgs-codegen-version-update.git
fi

cd dgs-codegen-version-update
./gradlew build -x test
./gradlew publishToMavenLocal
cd ..

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
./run-build.sh
cd ../..
./gradlew hayden-bom-plugin:build
./gradlew hayden-bom-plugin:publishToMavenLocal