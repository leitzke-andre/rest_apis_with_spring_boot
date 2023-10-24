# rest_apis_with_spring_boot
Repository for the ["REST API from 0 wth Spring Boot"](https://www.udemy.com/course/restful-apis-do-0-a-nuvem-com-springboot-e-docker/) udemy course (in Brazilian Portuguese).

Notes: 
- Even though the course recommends using Java 18, I'm sticking to v17 for now and will migrate to v21 if I face any issues.
- The course itself utilizes MySQL as database. I chose to use MariaDB instead, therefore there are changes to the configuration of Hibernate in properties.yaml. These should be pretty clear and easy to revert in case MySQL becomes a necessity.
- The database password is currently stored in plaintext and commited to the repository. Of course this entire project is *only for learning purposes* and it should be clear that this repository *is not meant for any sort of production usage*, but still it is worth mentioning that I am avoiding for now the extra complexity of secrets management.
