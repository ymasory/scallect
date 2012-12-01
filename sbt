#!/bin/sh

DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"

cd $DIR

sh "./sbt-launch-script" -v -sbt-snapshot -210 -Djava.awt.headless=true -Dfile.encoding=UTF8 -mem 4096 -J-Xss10M -J-XX:+CMSClassUnloadingEnabled -J-XX:-UseGCOverheadLimit


