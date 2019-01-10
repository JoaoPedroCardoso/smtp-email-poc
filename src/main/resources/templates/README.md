# @name@

## Welcome to smtpEmail poc!

This is a simple example of how to use Spring Smtp Email with Spring/Java features.

##### Technologies Used::
 - Java.
 - H2.
 - Spring Boot.

## Dependencies
- [Git](https://www.atlassian.com/git/tutorials/install-git)
- [Java](https://www.java.com/en/download/help/download_options.xml)
- [Maven](https://maven.apache.org/install.html)
- Maven Alternative Installation Options: 
  - http://sdkman.io: `$ sdk install maven`
  - https://brew.sh: `$ brew install maven`

### Executing the Project
- Clone the [Project](https://github.com/JoaoPedroCardoso/smtp-email-poc.git).
- Open the application.properties file and set up your credentials and the email who'll be the sender. Ex:
```
spring.mail.host=smtp.gmail.com
spring.mail.username=your_mail_here@gmail.com
spring.mail.password=yourMailPasswordHere
```
- After, open your terminal and execute: 
```
$ mvn clean install.
```
- Execute the EmailApplication in project.

### API Documentation
- After run the application:

	> http://localhost:8080/swagger-ui.html