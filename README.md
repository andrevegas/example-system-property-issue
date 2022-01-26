## Intro

The configuration [MyConfiguration.java](src/main/java/com/example/config/MyConfiguration.java) has a `Map<String, String>` which it's loaded from application yml or system properties (overwrite). However, looks like if the config it's defined as empty (`config-b`), micronaut cannot load the value from system properties in some cases.  


application.yml
```yaml
...
my-configuration:
  config-a:
    foo:
      BAR: 'baz'
  config-b:
    foo: {}
  config-c:
    foo: {}
...
```

## Steps to reproduce:

```shell
#build
./gradlew clean build -x test

#run
java \
    -D"my-configuration.config-a.foo.BAR1='baz1'" \
    -D"my-configuration.config-b.foo.BAR='baz'" \
    -D"my-configuration.config-c.foo[BAR]='baz'" \
    -D"my-configuration.config-d.foo.BAR='baz'" \
    -jar build/libs/example-system-property-issue-0.1-all.jar
```

### Output/Results

```
 __  __ _                                  _
|  \/  (_) ___ _ __ ___  _ __   __ _ _   _| |_
| |\/| | |/ __| '__/ _ \| '_ \ / _` | | | | __|
| |  | | | (__| | | (_) | | | | (_| | |_| | |_
|_|  |_|_|\___|_|  \___/|_| |_|\__,_|\__,_|\__|
  Micronaut (v3.2.7)

20:11:21.014 [main] INFO  com.example.Task - >>> MyConfiguration(name=config-a, foo={bar=baz})
20:11:21.016 [main] INFO  com.example.Task - >>> MyConfiguration(name=config-b, foo={})
20:11:21.016 [main] INFO  com.example.Task - >>> MyConfiguration(name=config-c, foo={-bar='baz'})
20:11:21.016 [main] INFO  com.example.Task - >>> MyConfiguration(name=config-d, foo={bar='baz'})
```

As demonstrated above: 

`config-a` can successfully add the new item from the system property. 

`config-b` remains empty. 

`config-c` can successfully add the item from the system property. 

`config-d` uses same syntax as `config-b`, but since it hasn't been defined as empty in the app.yml it also can successfully add the item from the system property.


---
---
---

# Bootstrap README

---

## Micronaut 3.2.7 Documentation

- [User Guide](https://docs.micronaut.io/3.2.7/guide/index.html)
- [API Reference](https://docs.micronaut.io/3.2.7/api/index.html)
- [Configuration Reference](https://docs.micronaut.io/3.2.7/guide/configurationreference.html)
- [Micronaut Guides](https://guides.micronaut.io/index.html)
---

## Feature lombok documentation

- [Micronaut Project Lombok documentation](https://docs.micronaut.io/latest/guide/index.html#lombok)

- [https://projectlombok.org/features/all](https://projectlombok.org/features/all)

## Feature http-client documentation

- [Micronaut HTTP Client documentation](https://docs.micronaut.io/latest/guide/index.html#httpClient)

## Feature hamcrest documentation

- [https://hamcrest.org/JavaHamcrest/](https://hamcrest.org/JavaHamcrest/)

## Feature mockito documentation

- [https://site.mockito.org](https://site.mockito.org)

