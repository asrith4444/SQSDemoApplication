## Welcome to SQSDemo Application

By using this Java Application, One can create a queue, send a message to queue, receive a message from queue, delete a message in the queue and sending mail.

### Requirements
- Eclipse IDE for Java Developers
- Amazon AWS Tool kit
- Java Mail dependency

### 1.Eclipse IDE for Java Developers
Download it from [here](https://www.eclipse.org/downloads/packages/)

### 2.Amazon AWS Tool Kit
**Steps to Install Amazon AWS Tool Kit in Eclipse IDE**
- Open Eclipse IDE
- Go to HELP Section
- Click on Marketplace
- Search for Amazon AWS Tool Kit
- Install it
- Now you can see an Orange cube in the top-middle of the IDE
- Click on it, choose preferences
- Save your AWS Profile here.
- Apply and close

### 3.Java Mail Dependency
```markdown
Paste the below code in the POM.XML file

` <dependency>
    <groupId>com.sun.mail</groupId>
    <artifactId>javax.mail</artifactId>
    <version>1.6.2</version>
  </dependency>`

```

#### By completing the above requirements you can start the project. Do not forget to read [**README.md**](https://github.com/asrith4444/SQSDemoApplication/)
