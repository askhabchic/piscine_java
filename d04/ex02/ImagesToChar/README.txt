# delete old target folder
rm -rf target

# create new folder
mkdir -p target

cd target/. ; jar xf ../lib/jcommander-1.78.jar com ; jar xf ../lib/JColor-5.0.0.jar com ; cd ..

# compiling source code
javac -classpath ./lib/jcommander-1.78.jar:./lib/JColor-5.0.0.jar -d ./target src/java/edu/school21/printer/*/*.java   

# copy resources to archive
cp -R src/resources target/.

# create new archive
jar cfm ./target/images-to-chars-printer.jar src/manifest.txt -C ./target .

# starting program
java -jar ./target/images-to-chars-printer.jar --white=GREEN --black=WHITE
