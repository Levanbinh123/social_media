# Social Media Project

## Giới thiệu
Đây là một dự án mạng xã hội đơn giản được xây dựng bằng **Java Spring Boot**, mô phỏng các chức năng cơ bản như:
- Đăng bài viết (Post)
- Bình luận (Comment)
- Chat nhóm (Chat + Message)
- Story, Reels ngắn
- Like/Saved Post
- Follow người dùng khác 
---
##  Công nghệ sử dụng
- **Java 17+** – Ngôn ngữ chính  
- **Spring Boot** – Framework backend  
- **JPA / Hibernate** – ORM Mapping  
- **H2 / MySQL** – Cơ sở dữ liệu  
- **Lombok** – Tự động generate code  
- **Maven** – Quản lý thư viện  
- **Postman** – Test API  
- **JWT** – Spring Security  
---
## Cấu trúc thư mục
```bash
├── src/main/java
│   └── com/example/social_media_PJ
│       ├── controller/
│       ├── model/
│       ├── repository/
│       └── service/
├── src/main/resources
│   └── application.properties
├── PTTK/                  # Chứa sơ đồ phân tích thiết kế và tài liệu REST-API
├── pom.xml                # File cấu hình Maven
└── README.md              # File này
## Tải dự án
git clone https://github.com/Levanbinh123/social_media.git
cd social_media
## cấu hình database
Tạo database tên: social_media
Mở file src/main/resources/application.properties và chỉnh sửa username và password tương ứng với MySQL của bạn:
spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://localhost:3306/social_media
spring.datasource.username=spring
spring.datasource.password=spring
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.show-sql=true
## start dự án
Mở project bằng IDE (IntelliJ hoặc Eclipse)
Chạy class chính (có @SpringBootApplication) – ví dụ: SocialMediaPjApplication.java
