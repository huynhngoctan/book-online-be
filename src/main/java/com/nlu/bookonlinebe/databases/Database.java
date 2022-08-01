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
//                Product product1 = new Product("Nhà giả kim", "Paulo Coelho", "NXB Hội Nhà Văn", 2020, "Văn học"
//                        , 220, 227, "Mở bán", "Tiểu thuyết Nhà giả kim của Paulo Coelho như một câu chuyện cổ tích giản dị, nhân ái, giàu chất thơ, thấm đẫm những minh triết huyền bí của phương Đông.",
//                        200, 63000,"http://localhost:8080/api/v1/FileUpload/files/40db84c9e8e54ef6ace4cfc7bfbfedf0.jpg");
//                Product product2 = new Product("Không gia đình", "Hector Malot", "NXB Kim Đồng", 2018, "Văn học"
//                        , 500, 464, "Mở bán", "KHÔNG GIA ĐÌNH kể chuyện về cuộc đời của cậu bé Rémi. Từ nhỏ, Rémi đã bị bắt cóc, rồi bị bố nuôi bán cho một đoàn xiếc thú. Em đã theo đoàn xiếc ấy đi lưu lạc khắp nước Pháp.", 200, 139000,"http://localhost:8080/api/v1/FileUpload/files/31f50fd04a924a4b831fd85be1e5a6d6.jpg");
//                Product product3 = new Product("Ông già và biển cả", "Ernest Hemingway", "NXB Văn Học", 2018, "Văn học"
//                        , 150, 124, "Mở bán", "Trong tác phẩm này, ông đã triệt để dùng nguyên lý mà ông gọi là “tảng băng trôi”, chỉ mô tả một phần nổi còn lại bảy phần chìm, khi mô tả sức mạnh của con cá, sự chênh lệch về lực lượng, về cuộc chiến đấu không cân sức giữa con cá hung dữ với ông già.", 300, 36000,"http://localhost:8080/api/v1/FileUpload/files/b3ae5510d7fe41a2864ac84f4709398b.jpg");
//
//                Order order1 = new Order("Huynh Ngoc Tan","Ho Chi Minh","0848107178",new Date("01/02/2022"),"Chưa thanh toán","Đơn hàng mới",30000);
//                Order order2 = new Order("Vo Do Thi Nhan","Binh Dinh","0722355899",new Date("22/05/2022"),"Chưa thanh toán","Đơn hàng mới",20000);
//
//                OrderDetail orderDetail1 = new OrderDetail(order1,product1,3);
//                OrderDetail orderDetail2 = new OrderDetail(order1,product2,1);
//                OrderDetail orderDetail3 = new OrderDetail(order1,product3,5);
//
//                OrderDetail orderDetail4 = new OrderDetail(order2,product1,1);
//                OrderDetail orderDetail5 = new OrderDetail(order2,product2,2);
//                OrderDetail orderDetail6 = new OrderDetail(order2,product3,3);
//
//                productRepository.save(product1);
//                productRepository.save(product2);
//                productRepository.save(product3);
//
//                orderRepository.save(order1);
//                orderRepository.save(order2);
//                orderDetailRepository.save(orderDetail1);
//                orderDetailRepository.save(orderDetail2);
//                orderDetailRepository.save(orderDetail3);
//                orderDetailRepository.save(orderDetail4);
//                orderDetailRepository.save(orderDetail5);
//                orderDetailRepository.save(orderDetail6);
//            }
//        };
//    }
}
