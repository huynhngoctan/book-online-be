package com.nlu.bookonlinebe.databases;

import com.nlu.bookonlinebe.models.Order;
import com.nlu.bookonlinebe.models.OrderDetail;
import com.nlu.bookonlinebe.models.Product;
import com.nlu.bookonlinebe.models.User;
import com.nlu.bookonlinebe.repositories.OrderDetailRepository;
import com.nlu.bookonlinebe.repositories.OrderRepository;
import com.nlu.bookonlinebe.repositories.ProductRepository;
import com.nlu.bookonlinebe.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class Database {
//    @Bean
//    public CommandLineRunner initDatabase(UserRepository userRepository) {
//        return new CommandLineRunner() {
//            @Override
//            public void run(String... args) throws Exception {
//                User user1 = new User("admin", "admin", "admin@gmail.com", "hello", new Date("01/02/2000"),
//                        "0945258369", "Ho Chi Minh", "admin", "Kích hoạt", "http://localhost:8080/api/v1/FileUpload/files/85c5dd5f0ca844ce8a2c5d637cf24b08.jpg");
//                User user2 = new User("tan123", "tan123", "tan123@gmail.com", "tan huynh", new Date("02/03/2000"),
//                        "0945258123", "Ben Tre", "user", "Kích hoạt", "http://localhost:8080/api/v1/FileUpload/files/85c5dd5f0ca844ce8a2c5d637cf24b08.jpg");
//                User user3 = new User("teo", "teo", "teo@gmail.com", "Nguyen Van Teo", new Date("03/04/2000"),
//                        "0945258789", "Ca Mau", "user", "Kích hoạt", "http://localhost:8080/api/v1/FileUpload/files/85c5dd5f0ca844ce8a2c5d637cf24b08.jpg");
//
//                userRepository.save(user1);
//                userRepository.save(user2);
//                userRepository.save(user3);
//            }
//        };
//    }

//    @Bean
//    public CommandLineRunner initProducts(ProductRepository productRepository, OrderDetailRepository orderDetailRepository, OrderRepository orderRepository) {
//        return new CommandLineRunner() {
//            @Override
//            public void run(String... args) throws Exception {
////                Product product1 = new Product("Nghĩ Giàu & Làm Giàu", "Napoleon Hill", "NXB Tổng Hợp TPHCM", 2020, "Kinh tế"
////                        , 450, 400, "Mở bán",
////                        "Là một trong những cuốn sách bán chạy nhất mọi thời đại. Đã hơn 60 triệu bản được phát hành với gần trăm ngôn ngữ trên toàn thế giới",
////                        280, 74000,"http://localhost:8080/api/v1/FileUpload/files/280cd37c8bbe4e41aa8e7a2bb177d47f.png");
////
////                Product product2 = new Product("Bí Mật Tư Duy Triệu Phú", "Harv Eker", "NXB Tổng Hợp TPHCM", 2021, "Kinh tế"
////                        , 300, 287, "Mở bán",
////                        "Tiết lộ những bí mật tại sao một số người lại đạt được những thành công vượt bậc, được số phận ban cho cuộc sống sung túc, giàu có.",
////                        160, 70000,"http://localhost:8080/api/v1/FileUpload/files/0e32f540dce043c5ad023e0bcb8d1581.png");
////
////                Product product3 = new Product("Người Giàu Có Nhất Thành Babylon", "George S Clason", "NXB Tổng Hợp TPHCM", 2020, "Kinh tế"
////                        , 265, 214, "Mở bán",
////                        "Quyển sách này sẽ giúp bạn biết cách vận dụng những nguyên lý quan trọng để phát triển tài chính",
////                        340, 66000,"http://localhost:8080/api/v1/FileUpload/files/378055e756b64802873d6d569aef0a0e.png");
////
////                Product product4 = new Product("Đường Đến Thành Công", "Napoleon Hill", "NXB Tổng Hợp TPHCM", 2021, "Kinh tế"
////                        , 300, 280, "Mở bán",
////                        "15 biển báo từ Napoleon Hill giúp bạn không bị lạc đường trên hành trình tìm kiếm sự thành công trong cuộc sống",
////                        250, 93000,"http://localhost:8080/api/v1/FileUpload/files/8afc0621f7c04a6ebe344e9970e5dd78.png");
////
////                Product product5 = new Product("Công Thức Tự Tin", "Napoleon Hill", "NXB Dân Trí", 2022, "Kinh tế"
////                        , 100, 104, "Mở bán",
////                        "Công thức tự tin giúp bạn tăng cường sự tự tin của mình thông qua việc áp dụng các chiến lược của Hill để kiểm soát suy nghĩ của bạn",
////                        250, 39000,"http://localhost:8080/api/v1/FileUpload/files/fc066ec7d5b44a75a1e038096594e769.png");
//
//
//
////                Order order1 = new Order("Huynh Ngoc Tan","Ho Chi Minh","0848107178",new Date("01/02/2022"),"Chưa thanh toán","Đơn hàng mới",30000);
////                Order order2 = new Order("Vo Do Thi Nhan","Binh Dinh","0722355899",new Date("22/05/2022"),"Chưa thanh toán","Đơn hàng mới",20000);
////
////                OrderDetail orderDetail1 = new OrderDetail(order1,product1,3);
////                OrderDetail orderDetail2 = new OrderDetail(order1,product2,1);
////                OrderDetail orderDetail3 = new OrderDetail(order1,product3,5);
////
////                OrderDetail orderDetail4 = new OrderDetail(order2,product1,1);
////                OrderDetail orderDetail5 = new OrderDetail(order2,product2,2);
////                OrderDetail orderDetail6 = new OrderDetail(order2,product3,3);
//
////                productRepository.save(product1);
////                productRepository.save(product2);
////                productRepository.save(product3);
////                productRepository.save(product4);
////                productRepository.save(product5);
////                productRepository.save(product3);
//
////                orderRepository.save(order1);
////                orderRepository.save(order2);
////                orderDetailRepository.save(orderDetail1);
////                orderDetailRepository.save(orderDetail2);
////                orderDetailRepository.save(orderDetail3);
////                orderDetailRepository.save(orderDetail4);
////                orderDetailRepository.save(orderDetail5);
////                orderDetailRepository.save(orderDetail6);
//            }
//        };
//    }
}
