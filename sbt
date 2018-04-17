"$JAVA_HOME"/bin/java -Xms512M -Xmx2048M -Xss1M -XX:+CMSClassUnloadingEnabled -XX:MaxPermSize=2048M -Dfile.encoding=UTF-8 -jar `dirname $0`/launcher/sbt-launch.jar "$@"
