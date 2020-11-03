#!/bin/bash

host=18.214.248.0
echo "copying war files..."
scp -i ~/.ssh/jdaec2.pem target/*.war ubuntu@$host:/home/ubuntu/tomcat/chessmasters.war

echo "running tomcat in aws..."
ssh -i ~/.ssh/jdaec2.pem ubuntu@$host 'sh /home/ubuntu/run_tomcat.sh'
