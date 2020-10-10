#!/bin/bash
scp -i ~/.ssh/jda_ubuntuserver.pem target/*.war ubuntu@35.180.50.87:/home/ubuntu/tomcat/
