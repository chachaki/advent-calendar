# ドメインを隔離する Isolating the Domain
gradle based Spring Boot &amp; MVC &amp; Thymeleaf &amp; Security &amp; MyBatis template project

## 起動方法

```sh
./gradlew clean bootRun
```

## 実行可能Jarのビルド

```sh
./gradlew clean build
```

## アーキテクチャ

![アーキテクチャ](architecture.png)


## How to Install to project
`package_name` and `project_name` are required.

```sh

$ git grep -l 'example' |xargs sed -i '' 's/example/package_name/g'
$ git grep -l 'package_name.com' |xargs sed -i '' 's/package_name.com/example.com/g'
$ git mv src/main/java/example src/main/java/package_name
$ git mv src/main/resources/example src/main/resources/package_name
$ git mv src/test/groovy/example src/test/groovy/package_name

$ git grep -l 'isolating-the-domain' |xargs sed -i '' 's/isolating-the-domain/project_name/g'

```

# How to Deploy Setting to Heroku

1. Add `Procfile` to Root, like below.
```
web: java -jar build/libs/advent-calendar-0.1.0.jar --server.port=$PORT
```

2. Add heroku Setting
```sh

(example)
$ heroku create project_name

$ heroku config:set BUILDPACK_URL=https://github.com/marcoVermeulen/heroku-buildpack-gradlew.git
```

3. Add `defaultTasks` to `build.gradle` .
```
defaultTasks 'clean', 'build'
```

4. push to heroku.
```sh
$ git push heroku master
```

# How to setting CircleCI

Add 'circle.yml' 
```
machine:
    java:
        version: oraclejdk8
    environment:
        JAVA_OPTS: "-Xms256m -Xmx512m"
```
