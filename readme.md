# Spring boot sample for JAVA CoP

### Basic sample

#### build.gradle file

Add in the root of your project the build.gradle file below :

> build.gradle

```gradle
buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:2.0.0.RELEASE")
    }
}

apply plugin: 'java'
apply plugin: 'eclipse'
apply plugin: 'idea'
apply plugin: 'org.springframework.boot'
apply plugin: 'io.spring.dependency-management'

jar {
    baseName = 'gs-serving-web-content'
    version =  '0.1.0'
}

repositories {
    mavenCentral()
}

sourceCompatibility = 1.8
targetCompatibility = 1.8

dependencies {
    compile("org.springframework.boot:spring-boot-starter-web")
    compile("org.springframework.boot:spring-boot-starter-thymeleaf")
    compile("org.springframework.boot:spring-boot-devtools")
    testCompile("junit:junit")
}
```

#### Create the application file

Then Add your application 'entrypoint' file in 'src/main/java/hello' :

> Application.java

```java
package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```

#### Add a controller

Add a controller in 1/2 line of code.

> GreetingController.java

```java
package hello.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }

}
```

#### Template

Finally add a view file in the resources/templates folder and you're done !

> greeting.html

```html
<!DOCTYPE HTML>
<html xmlns:th="http://www.thymeleaf.org">
<body>
  <p th:text="'Hello, ' + ${name} + '!'" />
</body>
</html>
```

### Build & deploy in localhost

Time to deploy it in localhost. You can run the command `gradle bootrun` or call the 'bootrun' task from your IDE :

![bootrun with intellij](https://i.imgur.com/RNYnPXB.png)

You can also build your application as jar file and run it with `gradle build && java -jar build/libs/gs-serving-web-content-0.1.0.jar` .