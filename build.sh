#!/bin/bash
set -e

APP_NAME="NEXUS Password Generator"
VERSION="1.0.1"
MAIN_CLASS="PasswordGeneratorGUI"
ICON_FILE="logo.icns"
INPUT_DIR="input"
OUTPUT_DIR="output"
JAR_FILE="${MAIN_CLASS}.jar"
JAVA_FILE="${MAIN_CLASS}.java"

echo "Cleaning old build folders..."
rm -rf "$INPUT_DIR" "$OUTPUT_DIR"

echo "Creating fresh build folders..."
mkdir -p "$INPUT_DIR" "$OUTPUT_DIR"

echo "Compiling Java..."
javac "$JAVA_FILE"

echo "Creating JAR..."
jar --create --file "$JAR_FILE" "${MAIN_CLASS}.class"

echo "Moving JAR into input folder..."
mv "$JAR_FILE" "$INPUT_DIR/"

echo "Packaging DMG..."
jpackage \
  --input "$INPUT_DIR" \
  --name "$APP_NAME" \
  --main-jar "$JAR_FILE" \
  --main-class "$MAIN_CLASS" \
  --type dmg \
  --dest "$OUTPUT_DIR" \
<<<<<<< HEAD
<<<<<<< Updated upstream
  --icon "$ICON_FILE"
=======
  --icon "$ICON_FILE" \
  --app-version "$VERSION"
>>>>>>> Stashed changes
=======
  --icon "$ICON_FILE" \
  --app-version "VERSION"
>>>>>>> 1db7ef890db241c04433e39e77fda8391c917430

echo "Done."
echo "Your new build is in: $OUTPUT_DIR"