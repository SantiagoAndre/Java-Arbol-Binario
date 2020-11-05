FROM java:8  
COPY . /var/www/java  
WORKDIR /var/www/java
RUN javac \
-sourcepath src \ 
src/Main.java  
WORKDIR /var/www/java/src
#CMD ["ls"]  
CMD ["java", "Main"]  
