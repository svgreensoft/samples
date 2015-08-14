Batch jaxb class generation with gradle.
===================================

The application shows how to generate java classes from multiple schemas with default namespaces. 

If the schemas with default namespaces contain the elements with the same name, jaxb generation will fail. In this case we can run xjc for each schema and separate generated classes having the same name by packages. Annotation plugin  is used to define the packages and provide "root" annotation on generated classes.

Gradle command:

     >gradle build
     
