#!/bin/bash
echo "copying war files..."
scp -i ~/.ssh/jda_ubuntuserver.pem target/*.war ubuntu@jda.danieldev.es:/home/ubuntu/tomcat/

echo "running tomcat in aws..."
ssh -i ~/.ssh/jda_ubuntuserver.pem ubuntu@jda.danieldev.es 'sh /home/ubuntu/run_tomcat.sh'
