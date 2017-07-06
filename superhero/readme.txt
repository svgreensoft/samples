Write a RESTFUL webservice that can be accessed via http.

    Use Java for coding
    Use any framework and build managers you like (please provide a short statement why you chose a particular framework)
    Include some testing (unit, integration, end-to-end)

 

The webservice needs to be publicly available:

    Deploy on any service you like (e.g. AWS)
    You will provide us with a link when you are done

It should be able to do the following:

    Create a superhero with the following properties
        Name
        Pseudonym
        The publisher it is from (e.g. DC or Marvel)
        List of "skills" or powers
        List of allies (e.g Batman's ally would be Robin) if the superhero has any
        Date of first appearance (in the format YYYY-MM-DD)
    Get a list of all superheros in JSON format
    Get the details of a specific superhero in JSON format

Optional tasks (only in case you are finished early and get bored...):

    Add some form of authentication for the API and https access
    Create a docker image including the webservice

Where should you put the code?

    Please put the code into a git repository. If you send us your bitbucket account, we will create a repository for you


Prerequisites: java 8 / gradle

To build application:
>gradle build

To run application:
copy war file to Tomcat webapp dir:
>cp <repo.dir>\hw\build\libs\hw.war <catalina.home>\webapps\

To start application - start tomcat and send loan request in browser:
http://localhost:8080/hw/firstname/John/lastname/Smith/amount/1000/term/30

Limitations:
terms and amount accept only digits
