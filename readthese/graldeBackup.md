# Gradle Configuration Backup

In this markdown, the build and settings configuration for Gradle are put as a backup.

## build.gradle

> plugins {  
>     id 'java'  
> }  
> 
> group 'com._4th_dimension_software'  
> version '0.5-WORK-IN-PROGRESS'  
> 
> repositories {  
>     mavenCentral()  
> }  
> 
> dependencies {  
>     testImplementation 'org.junit.jupiter:junit-jupiter:5.8.1'  
>     testRuntimeOnly 'org.junit.jupiter:junit-jupiter-engine:5.8.1'  
> }  
> 
> test {  
>     useJUnitPlatform()  
> }  
> 
> jar {  
>     manifest {  
>         attributes 'Main-Class': 'com._4th_dimension_softwares.app.run.Main'  
>     }  
> }  
> 
> sourceSets {  
>     main {  
>         java {  
>             srcDirs = ['src/main/java']  
>         }  
>         resources {  
>             srcDirs = ['src/main/resources']  
>         }  
>     }}

## settings.gradle

> rootProject.name = 'FencingCompetitionManager'

**If you're having problems configuring gradle, copy these into the corresponding gradle file, and it should work properly.**
