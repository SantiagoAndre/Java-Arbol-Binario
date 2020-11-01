FROM java:8  
COPY . /var/www/java  
WORKDIR /var/www/java
RUN javac \
-sourcepath src \ 
src/arbolbinario/Main.java  
WORKDIR /var/www/java/src
RUN ls arbolbinario
#CMD ["ls"]  
CMD ["java", "arbolbinario/Main"]  
