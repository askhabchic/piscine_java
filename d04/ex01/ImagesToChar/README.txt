#delete old target folder
rm -rf target

#create new folder
mkdir -p target

#compiling source code
javac -d ./target src/java/edu/school21/printer/*/*.java   

#copy resources to archive
cp -R src/resources target/.

#create new archive
jar cfm ./target/images-to-chars-printer.jar src/manifest.txt -C ./target .

#starting program
java -jar ./target/images-to-chars-printer.jar 0 .
